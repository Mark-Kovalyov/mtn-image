package mayton.image.honeycomb;

import org.jetbrains.annotations.Range;

import javax.annotation.concurrent.ThreadSafe;

/**
 * Assumtions:
 *
 * Mapping from honeycomb to square:
 *
 * 1
 *
 *   1 1
 * 1 1 1
 * 1 1
 *
 *   1 1 1
 * 1 1 1 1
 * 1 1 1 1
 * 1 1 1
 */
@ThreadSafe
public class HexxagonUtils {

   private HexxagonUtils() {}

   int calculateSizeUpperBound(@Range(from = 1, to = Integer.MAX_VALUE) int cells) {
       int square = cells * cells - (cells / 2 * (cells / 2));

       return square;
   }

}
