package mayton.image.iterators;

// mayton.image.iterators.GilbertPixelIteratorTest

import mayton.image.Point;
import mayton.math.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * <pre>
 *  0   1  14  15
 *  3   2  13  12
 *  4   7   8  11
 *  5   6   9  10
 * </pre>
 *
 * @author mayton
 */
public class GilbertPixelIterator implements IPixIterator {

    static Logger logger =  LoggerFactory.getLogger(GilbertPixelIterator.class);

    private BlockingQueue<Point> blockingQueue = new ArrayBlockingQueue<>(256, true);

    private Thread worker;

    private int u=1;  // pixel step

    private Point poisonedPill = new Point(Integer.MIN_VALUE, Integer.MIN_VALUE);

    private int glx;
    private int gly;

    private Point current = null;

    private boolean finished = false;

    private void a(int i) {
        if (i > 0) {
            d(i - 1);
            linerel(+u, 0);
            a(i - 1);
            linerel(0, u);
            a(i - 1);
            linerel(-u, 0);
            c(i - 1);
        }
    }

    private void b(int i) {
        if (i > 0) {
            c(i - 1);
            linerel(-u, 0);
            b(i - 1);
            linerel(0, -u);
            b(i - 1);
            linerel(u, 0);
            d(i - 1);
        }
    }

    private void c(int i) {
        if (i > 0) {
            b(i - 1);
            linerel(0, -u);
            c(i - 1);
            linerel(-u, 0);
            c(i - 1);
            linerel(0, u);
            a(i - 1);
        }
    }

    private void d(int i) {
        if (i > 0) {
            a(i - 1);
            linerel(0, u);
            d(i - 1);
            linerel(u, 0);
            d(i - 1);
            linerel(0, -u);
            b(i - 1);
        }
    }

    private void safePut(Point point) {
        try {
            logger.info(":: trying to put : {}", point);
            blockingQueue.put(point);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            logger.warn("Thread interrupted!");
        }
    }

    private void linerel(int x, int y) {
        glx += x;
        gly += y;
        safePut(new Point(glx, gly));
    }

    private void moveto(int x, int y) {
        glx = x;
        gly = y;
        safePut(new Point(glx, gly));
    }

    public GilbertPixelIterator(int size) {
        checkArgument(size >= 16);
        logger.info(":: constructor for size = {}", size);
        int level = Utils.log2up(size);
        logger.info(":: level = {}", level);
        worker = new Thread(() -> {
            logger.info(":: Thread function");
            moveto(0, 0);
            a(level);
            safePut(poisonedPill);
        });
        worker.start();
    }


    @Override
    public int getX() {
        return finished? 0 : current.x;
    }

    @Override
    public int getY() {
        return finished? 0 : current.y;
    }

    @Override
    public boolean next() {
        if (finished) {
            return false;
        } else {
            logger.info("::next()");
            // TODO: Bug! Should be replaced 'poll' by 'take' with correct timeout and 'poisoned' marker processing. 
            // :: trying to put : (11,14)                                                                               │"GC Thread#4" os_prio=0 cpu=6.55ms elapsed=80.89s tid=0x00007fdc58005800 nid=0x1a8b runnable
            //:: trying to put : (11,13)                                                                               │
            //:: trying to put : (11,12)                                                                               │"GC Thread#5" os_prio=0 cpu=6.56ms elapsed=80.88s tid=0x00007fdc58007000 nid=0x1a8c runnable
            //:: trying to put : (10,12)                                                                               │
            //:: trying to put : (10,13)                                                                               │"G1 Main Marker" os_prio=0 cpu=0.24ms elapsed=81.22s tid=0x00007fdc94087800 nid=0x1a76 runnable
            //:: trying to put : (9,13)
            current = blockingQueue.poll();
            if (current == null) {
                finished = true;
            } else {
                finished = false;
            }
            return finished;
        }
    }

    @Override
    public void reset() {
        throw new RuntimeException("Not implemented for mt-iterator");
    }
}