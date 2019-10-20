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
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import static mayton.math.Utils.parseIpV4;

public class GeoIp {

    static Random random = new Random();

    private static final Map<String, Color> colorMap = new HashMap<>();

    static {
        colorMap.put("US", Color.BLUE);
        colorMap.put("RU", Color.RED);
        colorMap.put("EN", Color.GREEN);
    }

    private static int detectColor(@NotNull String country) {
        if (colorMap.containsKey(country)) {
            return colorMap.get(country).getRGB();
        } else {
            return 0xFF_000000 | random.nextInt(0xFFFFFF);
        }
    }


    public static void fillCountrySpace(@NotNull BufferedImage image, @NotNull IPixIterator currentIterator,
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

        Properties properties = new Properties();
        properties.load(new FileInputStream("sensitive.properties"));

        FileReader reader = new FileReader(properties.getProperty("geoIpCityFile"));

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
            long ip1 = parseIpV4(record.get(0));
            long ip2 = parseIpV4(record.get(1));
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
                fillCountrySpace(image, pixIterator, color, ip1, ip2);
            }
            previous = country;
            assert ip1 >= 0 && ip1 < 0xFFFF_FFFFL;
            assert ip2 >= 0 && ip2 < 0xFFFF_FFFFL;
            cnt++;
        }

        System.out.printf("GeoIpCity records %d\n", cnt);

        while (pixIterator.next());

        ImageIO.write(image, "PNG", new FileOutputStream("out/pics/geoip-country-1k-x-1k.png"));

    }


}
