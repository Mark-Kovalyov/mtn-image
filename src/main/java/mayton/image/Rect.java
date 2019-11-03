package mayton.image;

import org.jetbrains.annotations.NotNull;
import javax.annotation.concurrent.Immutable;

@Immutable
public final class Rect {

    public final int x1;
    public final int y1;
    public final int x2;
    public final int y2;

    public boolean isPointInRect(int x, int y){
        return x >= x1 && x < x2 && y >= y1 && y < y2;
    }

    public boolean isPointInRect(@NotNull Point point){
        return point.x >= x1 && point.x < x2 && point.y >= y1 && point.y < y2;
    }

    // TODO: Implement
    public static Rect intersect(@NotNull Rect r1,@NotNull Rect r2){
        throw new RuntimeException("Not implemented yet!");
    }

    // TODO: Implement
    @NotNull
    public static Rect union(@NotNull Rect r1,@NotNull Rect r2){
        throw new RuntimeException("Not implemented yet!");
    }

    // TODO: Implement
    public static boolean isPointInRect(@NotNull Point point, @NotNull Rect rect){
        throw new RuntimeException("Not implemented yet!");
    }

    public static @NotNull Rect createSquare(int x1, int y1,int size){
        return new Rect(x1, y1, x1 + size, y1 + size);
    }

    public static @NotNull Rect create8x8Square(int x1, int y1) {
        return new Rect(x1, y1, x1 + 8, y1 + 8);
    }

    public Rect(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public int getWidth(){
        return x2 - x1;
    }

    public int getHeight(){
        return y2 - y1;
    }

    @Override
    public String toString() {
        return String.format("Rect(%d , %d ; %d , %d)", x1, y1, x2, y2);
    }
}
