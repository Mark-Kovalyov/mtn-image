package mayton.image.iterators;

import java.util.Random;

public class RandomIterator implements IPixIterator{

    Random r=null;

    int count=0;

    long seed=0;

    int Xsize;
    int Ysize;
    int x;
    int y;

    public RandomIterator(int x,int y,long seed)
    {
        Xsize=x;
        Ysize=y;
        count=x*y;
        this.seed=seed;
        r=new Random(seed);
    }

    public RandomIterator(int x,int y)
    {
        Xsize=x;
        Ysize=y;
        count=x*y;
        this.seed=0;
        r=new Random(seed);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean next()
    {
        x=r.nextInt(Xsize);
        y=r.nextInt(Ysize);
        if (count==0) return false;
        return true;
    }

    public void reset()
    {
        r.setSeed(seed);
    }
}
