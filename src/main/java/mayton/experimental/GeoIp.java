package mayton.experimental;

import mayton.image.iterators.GilbertPixelIterator;
import mayton.image.iterators.IPixIterator;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.jetbrains.annotations.NotNull;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Random;

import static mayton.math.Utils.ip;

public class GeoIp {

    static Random random = new Random();

    private static int detectColor(@NotNull String country) {
        if (country.equals("US")) {
            return Color.BLUE.getRGB();
        } else {
            return 0xFF_000000 | random.nextInt(0xFFFFFF);
        }
    }

    public static void drawGapSpace(@NotNull BufferedImage image, @NotNull IPixIterator currentIterator,
                                    long ip1, long ip2) {
        long size = ip2 - ip1;
        for (long k = 0; k < size; k++) {
            currentIterator.next();
            image.setRGB(currentIterator.getX(), currentIterator.getY(), Color.LIGHT_GRAY.getRGB());
        }
    }

    public static void drawCountrySpace(@NotNull BufferedImage image, @NotNull IPixIterator currentIterator,
                                        int color, long ip1, long ip2) {

        assert ip1 < ip2;
        System.out.printf(":: Draw %d %d \n", ip1, ip2);
        long size = ip2 - ip1;
        for (long k = 0; k < size; k++) {
            currentIterator.next();
            image.setRGB(currentIterator.getX(), currentIterator.getY(), color);
        }
    }


    public static void main(String[] args) throws IOException {

        FileReader reader = new FileReader("/db/maxmind/2010-10.MaxMind GeoIP City CSV Format/GeoIP-139_20101001/GeoIPCity.csv");

        BufferedImage image = new BufferedImage(1024, 1024, BufferedImage.TYPE_INT_ARGB);

        IPixIterator pixIterator = new GilbertPixelIterator(1024);

        CSVParser csvParser = CSVFormat.DEFAULT
                .withQuote('"')
                .withDelimiter(',')
                .withSkipHeaderRecord(true)
                .withFirstRecordAsHeader()
                .parse(reader);

        Iterator<CSVRecord> i = csvParser.iterator();

        int cnt = 0 ;

        String previous = null;

        int color = Color.GRAY.getRGB();

        while (i.hasNext()) {
            CSVRecord record = i.next();
            /////////////////////////////
            long ip1 = ip(record.get(0));
            long ip2 = ip(record.get(1));
            if (ip1 > 1024 * 1024 || ip2 > 1024 * 1024) {
                System.out.printf("Exit by limit ip1 = %d, ip2 = %d, record = %d\n", ip1, ip2, cnt);
                break;
            }
            String country = record.get(2);
            if (previous == null) {

            } else {
                if (!previous.equals(country)) {
                    color = detectColor(country);
                }
                drawCountrySpace(image, pixIterator, color, ip1, ip2);
            }
            previous = country;
            assert ip1 >= 0 && ip1 < 0xFFFF_FFFFL;
            assert ip2 >= 0 && ip2 < 0xFFFF_FFFFL;
            cnt++;
        }

        System.out.printf("GeoIpCity records %d\n", cnt);

        while (pixIterator.next());

        ImageIO.write(image, "PNG", new FileOutputStream("/storage/pics/geoip/geoip-country-1k-x-1k.png"));

    }


}
