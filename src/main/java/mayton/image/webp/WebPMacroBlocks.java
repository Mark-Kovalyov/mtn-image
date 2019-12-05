package mayton.image.webp;

import static mayton.image.webp.BlockTypes.CHROMA;
import static mayton.image.webp.BlockTypes.LUMA;

public enum  WebPMacroBlocks {

    LUMA_4x4(4, 4, LUMA),
    CHROMA_8x8(8, 8, CHROMA),
    LUMA_16x16(16, 16, CHROMA);

    int width;
    int height;
    BlockTypes blockTypes;

    WebPMacroBlocks(int width, int height, BlockTypes blockTypes) {
        this.width = width;
        this.height = height;
        this.blockTypes = blockTypes;
    }
}
