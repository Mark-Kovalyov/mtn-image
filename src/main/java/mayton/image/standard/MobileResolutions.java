package mayton.image.standard;

import mayton.image.Rect;
import org.jetbrains.annotations.NotNull;

import java.math.BigInteger;
import java.util.Collection;
import static java.util.Collections.EMPTY_LIST;

public enum MobileResolutions {

    XIAOMI_REDMI_NOTE_9(1080,2340, EMPTY_LIST);

    public final int x;
    public final int y;
    public final String ratio;

    private final Collection<ColorMode> colorModes;

    MobileResolutions(int x, int y, Collection<ColorMode> colorModes){
        this.x = x;
        this.y = y;
        this.colorModes = colorModes;
        BigInteger xx = BigInteger.valueOf(x);
        BigInteger yy = BigInteger.valueOf(y);
        BigInteger gcd = xx.gcd(yy);
        this.ratio = String.format("%s:%s", xx.divide(gcd).toString(), yy.divide(gcd).toString());
    }

    @NotNull
    public Rect createRectangle() {
        return new Rect(0, 0, x, y);
    }

}
