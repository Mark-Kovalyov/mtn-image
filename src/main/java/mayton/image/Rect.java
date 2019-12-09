package mayton.image;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.concurrent.Immutable;

@Immutable
public final class Rect {

    public final int x1;
    public final int y1;
    public final int x2;
    public final int y2;

    @Contract(pure = true)
    public boolean isPointInRect(int x, int y){
        return x >= x1 &&
               x <  x2 &&
               y >= y1 &&
               y <  y2;
    }

    @Contract(pure = true)
    public boolean isPointInRect(@NotNull Point point){
        return point.x >= x1 && point.x < x2 && point.y >= y1 && point.y < y2;
    }

    @Contract(pure = true)
    @Nullable
    public static Rect intersect(@NotNull Rect a,@NotNull Rect b){
        if (!isIntersect(a,b)) {
            return null;
        } else {
            // todo
            return new Rect(0,0,0,0);
        }
    }

    @Contract(pure = true)
    public static boolean isIntersect(@NotNull Rect a, @NotNull Rect b) {
        return a.y1 < b.y2 || a.y2 > b.y1 || a.x2 < b.x1 || a.x1 > b.x2;
    }

    // TODO: Implement
    @NotNull
    @Contract(pure = true)
    public static Rect union(@NotNull Rect r1,@NotNull Rect r2){
        throw new RuntimeException("Not implemented yet!");
    }

    // TODO: Implement
    @Contract(pure = true)
    public static boolean isPointInRect(@NotNull Point point, @NotNull Rect rect){
        return rect.isPointInRect(point);
    }

    @Contract(pure = true)
    public static boolean isRectInRect(@NotNull Rect thisRect, @NotNull Rect that){
        throw new RuntimeException("Not implemented yet!");
    }

    @Contract(pure = true)
    public boolean isIn(@NotNull Rect rect) {
        return x1 >= rect.x1 && y1 <= rect.y1 && x2 <= rect.x2 && y2 <= rect.y2;
    }

    @Contract(pure = true)
    public static @NotNull Rect createSquare(int x1, int y1,int size){
        return new Rect(x1, y1, x1 + size, y1 + size);
    }

    @Contract(pure = true)
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

    public boolean isEmpty() {
        return getHeight() == 0 && getWidth() == 0;
    }

    @Override
    public String toString() {
        return String.format("Rect(%d , %d ; %d , %d)", x1, y1, x2, y2);
    }
}
