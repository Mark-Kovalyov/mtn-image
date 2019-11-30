package mayton.image.standard;

public enum Devices {

    SAMSUNG_S24F350F(1920, 1080, "Samsung S24F350F"),
    LG_43LH570V(1920, 1080, "LG 43LH570V");

    public int x;
    public int y;
    public String desc;

    Devices(int x, int y, String desc) {
        this.x = x;
        this.y = y;
        this.desc = desc;
    }

}
