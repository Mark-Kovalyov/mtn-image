package mayton.image.iterators;

public class ZigzagPixIterator implements IPixIterator {

    protected int x = 0;
    protected int y = 0;
    protected int dx = 0;
    protected int dy = 0;
    protected int diagonal = 0;
    protected boolean stop;
    protected int width;
    protected int half_width;


    public ZigzagPixIterator(int width) {
        this.width = width;
        half_width = width / 2;
        reset();
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void reset() {
        x = -1;
        y = -1;
        diagonal = 0;
        dx = 0;
        dy = 0;
    }

    public boolean next() {
        if (stop) return false;

        if ((x == width) && (y == width)) {
            stop = true;
            return false;
        }

        if ((x == -1) && (y == -1)) {
            x = 0;
            y = 0;
            return true;
        }

        if ((x == 0) && (y == 0)) {
            y = 1;
            return true;
        }

        if ((x == 0) && (y == 1)) {
            dx = 1;
            dy = -1;
        } else {


            //if (diagonal<half_width){

            if (y < 0) {
                dx = -1;
                dy = 1;
                x++;
                diagonal++;
            }

            if (x < 0) {
                dx = 1;
                dy = -1;
                y++;
                diagonal++;
            }

        }
        //}
		/*
		else
		{
			if (y==width)
			{
				dx=1;
				dy=-1;
				diagonal++;
				x++;
			}			

			if (x==width)
			{
				dx=-1;
				dy=1;
				diagonal++;
				x--;				
			}				
		}*/

        x += dx;
        y += dy;

        return true;
    }

}