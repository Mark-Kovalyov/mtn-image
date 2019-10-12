package mayton.image.iterators;

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
 *
 *   	    Throws exception 	Returns special value      Blocks              Times out
 *   	    ------------------  ----------------------     ----------------    -----------
 * Insert 	add(e)              offer(e)                   put()               offer(e, time, unit)
 * Remove 	remove()            poll()                     take()              poll(time, unit)
 * Examine 	element()           peek()                     <not applicable>    <not applicable>
 *
 * </pre>
 *
 * @author mayton
 */
public class GilbertPixelIterator implements IPixIterator {

    static Logger logger =  LoggerFactory.getLogger(GilbertPixelIterator.class);

    private BlockingQueue<Point> blockingQueue = new ArrayBlockingQueue<>(256, true); // TODO: Refactor with 'disruptor' queue

    private Thread worker;

    private int u = 1;

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
            blockingQueue.put(point); // TODO: Refactor with 'disruptor' queue
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            logger.warn("Thread interrupted during put!");
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
        checkArgument(size >= 4 , "Impossible to create gilbert gurve less than 4x4 plane!");
        int level = Utils.log2up(size);
        logger.trace(":: level = {}", level);
        worker = new Thread(() -> {
            moveto(0, 0);
            a(level);
            safePut(poisonedPill);
        });
        worker.start();
    }


    @Override
    public int getX() {
        if (finished) throw new IllegalStateException("Iterator is finished!");
        return current.x;
    }

    @Override
    public int getY() {
        if (finished) throw new IllegalStateException("Iterator is finished!");
        return current.y;
    }

    @Override
    public boolean next() {
        if (finished) {
            return false;
        } else {
            try {
                current = blockingQueue.take(); // TODO: Refactor with 'disruptor' queue
                finished = (current == poisonedPill);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
                logger.warn("Thread interrupted during take!");
                finished = true;
            }
            return !finished;
        }
    }

    @Override
    public void reset() {
        throw new RuntimeException("Not implemented for mt-iterator");
    }
}