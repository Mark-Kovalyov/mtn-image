package mayton.image.iterators;

/**
 * 
 * @author mayton
 */
public class SpiralIterator implements IPixIterator {

    @Override
    public String toString() {
        return String.format("(%d,%d),%d", x,y,count);
    }

    public SpiralIterator(int size) {
        if (size < 3) {
            throw new IllegalArgumentException("It is not reason to create sprital with size less than 3!");
        }
        if (size % 2 == 0) {
            throw new IllegalArgumentException("Size must be odd!");
        }
        this.size = size;
        reset();
    }

    int x;
    int y;
    public int len;
    int count;
    int pos;
    int size;
    public int dir;
    boolean isStopped = false;

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    /**
     * dir:
     *   0 - направо
     *   1 - вверх
     *   2 - влево
     *   3 - вниз
     */
    private void nextDir() {
        if (dir == 2) len++;
        pos=0;
        dir++;
        if (dir == 4) {
            dir = 0;
        }

    }

    @Override
    public boolean next() {
        if (!isStopped) {
            if (count == 0) {
                count++;
                pos++;
                return true;
            } else {
                switch (dir) {
                    case 0:
                        if (pos > len) {
                            nextDir();
                        }
                        x++;
                        break;
                    case 1:
                        if (pos > len - 1) {
                            nextDir();
                        }
                        y--;
                        break;
                    case 2:
                        if (pos > len) {
                            nextDir();
                        }
                        x--;
                        break;
                    default:
                        if (pos > len + 1) {
                            nextDir();
                        }
                        y++;
                }
                count++;
                return true;
            }
        } else {
            return false;
        }
    }

    @Override
    public void reset() {
        isStopped = false;
        x = size / 2  ;
        y = size / 2  ;
        pos = 0;
        count = -1;
        len = 2;
        dir = 1;
    }
}
