package mayton.image.standard;

public class PaletteColorMode extends ColorMode {

    public int ofColros;

    public PaletteColorMode(int allColors, int ofColors) {
        super(allColors);
        this.ofColros = ofColors;
    }
}
