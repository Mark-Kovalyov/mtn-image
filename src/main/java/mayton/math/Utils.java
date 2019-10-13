package mayton.math;

import org.jetbrains.annotations.NotNull;

import static com.google.common.base.Preconditions.checkArgument;

public class Utils {

    private Utils(){}

    /**
     * Nearest to power of 2
     * @param x
     * @return
     */
    public static int flp2(int x){
        checkArgument(x >= 0);
        x = x | (x>>1);
        x = x | (x>>2);
        x = x | (x>>4);
        x = x | (x>>8);
        x = x | (x>>16);
        return x - (x >> 1);
    }

    public static int clp2(int x){
        checkArgument(x >= 0);
        x = x - 1;
        x = x | (x>>1);
        x = x | (x>>2);
        x = x | (x>>4);
        x = x | (x>>8);
        x = x | (x>>16);
        return x + 1;
    }

    public static int nlz(int x){
        int n;
        if (x == 0) return 32;
        n = 1;
        if (( x >>> 16 ) == 0){
            n += 16;
            x <<= 16;
        }
        if (( x >>> 24 ) == 0){
            n += 8;
            x <<= 8;
        }
        if (( x >>> 28 ) == 0){
            n += 4;
            x <<= 4;
        }
        if (( x >>> 30 ) == 0){
            n += 2;
            x <<= 2;
        }

        n = n - (x >>> 31);
        return n;
    }

    public static int log2up(int x){
        if (x < 1) return 0;
        return 32 - nlz(x - 1);
    }

    public static long ip(@NotNull String ips) throws NumberFormatException {
        int[] ip = new int[4];
        String[] parts = ips.split("\\.");
        for (int i = 0; i < 4; i++) {
            ip[i] = Integer.parseInt(parts[i]);
        }
        return  (long) ip[0] << 24 |
                (long) ip[1] << 16 |
                (long) ip[2] << 8 |
                (long) ip[3] ;
    }


}
