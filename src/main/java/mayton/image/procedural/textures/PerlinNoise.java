package mayton.image.procedural.textures;

import mayton.image.procedural.IProceduralTexture;
import mayton.math.*;
import org.jetbrains.annotations.NotNull;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Random;

import static java.lang.Math.*;

/**
 * Ported from https://gamedev.ru/code/articles/?id=4212
 * Thanks to Волошин Дмитрий aka WDW
 *
 * TODO: Something looks not like 'Perlin'. Should be fixed.
 */
@SuppressWarnings({"squid:CommentedOutCodeLine", "squid:S1135"})
public class PerlinNoise implements IProceduralTexture {

    private static File tmpDir = new File("/tmp/mtn-image");

    static double noise2D(double x, double y) {
        return noise2D((int) x, (int) y);
    }

    static double noise2D(int x, int y) {
        int n = x + y * 57;
        n = (n << 13) ^ n;
        return (1.0f - ((n * (n * n * 15731 + 789221) + 1376312589) & 0x7fffffff) / 1073741824.0f);
    }

    //public static @NotNull IMatrix genNoise(int size, int numOctaves) {
    //    double factor = new Random().nextDouble();
    //    return genNoise(size, numOctaves, factor);
    // }

    // void CMyNoise::GenNoise(unsigned char pNoise[],int size)
    //public static @NotNull BufferedImage genNoise(byte[] pNoise, int size) {
    //public static @NotNull IMatrix genNoise(int size, int numOctaves, double factor) {
    @Override
    public @NotNull IMatrix generate(int size, @NotNull Map<String, String> parameters) {
        int seed = parameters.containsKey("seed") ? Integer.valueOf(parameters.get("seed")) : 0;
        int numOctaves = parameters.containsKey("numOctaves") ? Integer.valueOf(parameters.get("numOctaves")) : 1;
        Random random = new Random(seed);
        double factor = random.nextDouble();
        //double fac =Random(PI*2*10,PI*3*10);
        // TODO: What does it mean's
        IWriteableMatrix matrix = new MatrixGeneric(size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                //проходим по всем элементам массива и заполняем их значениями
                //pNoise[i * size + j] = (byte) perlinNoise2D(i, j, fac);
                int res = perlinNoise2D(i, j, factor, numOctaves);
                //image.setRGB(i, j, Raster.getPixel(res, res, res));
                matrix.set(i, j, res);
            }
        }
        return matrix;
    }

    static int perlinNoise2D(double x, double y, double factor, int numOctaves) {
        double total = 0;
        // это число может иметь и другие значения хоть cosf(sqrtf(2))*3.14f
        // главное чтобы было красиво и результат вас устраивал
        double persistence = 0.5;

        // экспериментируйте с этими значениями, попробуйте ставить
        // например sqrtf(3.14f)*0.25f или что-то потяжелее для понимания J)
        double frequency = 0.25;
        double amplitude = 1.0;//амплитуда, в прямой зависимости от значения настойчивости

        // вводим фактор случайности, чтобы облака не были всегда одинаковыми
        // (Мы ведь помним что ф-ция шума когерентна?)

        x += factor;
        y += factor;

        // NUM_OCTAVES - переменная, которая обозначает число октав,
        // чем больше октав, тем лучше получается шум
        for (int i = 0; i < numOctaves; i++) {
            total += (compileNoise(x * frequency, y * frequency) * amplitude);
            amplitude *= persistence;
            frequency *= 2.0;
        }
        //здесь можно перевести значения цвета   по какой-то формуле
        //например:
        //total=sqrt(total);
        // total=total*total;
        // total=sqrt(1.0f/double(total));
        //total=255-total;-и.т.д все зависит от желаемого результата
        total = abs(total);
        return (int) (total * 255.0);//приводим цвет к значению 0-255…
    }

    static double smoothedNoise2D(double x, double y) {
        double corners = (noise2D(x - 1, y - 1) + noise2D(x + 1, y - 1) + noise2D(x - 1, y + 1) + noise2D(x + 1, y + 1)) / 16.0;
        double sides = (noise2D(x - 1, y) + noise2D(x + 1, y) + noise2D(x, y - 1) + noise2D(x, y + 1)) / 8.0;
        double center = noise2D(x, y) / 4.0;
        return corners + sides + center;
    }

    static double cosineInterpolate(double a, double b, double x) {
        double ft = x * Math.PI;
        double f = (1.0 - cos(ft)) * 0.5;
        return a * (1.0 - f) + b * f;
    }

    static double compileNoise(double x, double y) {
        double intX = (int) x;//целая часть х
        double fractionalX = x - intX;//дробь от х
        //аналогично у
        double intY = (int) y;
        double fractionalY = y - intY;
        //получаем 4 сглаженных значения
        double v1 = smoothedNoise2D(intX, intY);
        double v2 = smoothedNoise2D(intX + 1, intY);
        double v3 = smoothedNoise2D(intX, intY + 1);
        double v4 = smoothedNoise2D(intX + 1, intY + 1);
        //интерполируем значения 1 и 2 пары и производим интерполяцию между ними
        double i1 = cosineInterpolate(v1, v2, fractionalX);
        double i2 = cosineInterpolate(v3, v4, fractionalX);
        //я использовал косинусною интерполяцию ИМХО лучше
        //по параметрам быстрота-//качество
        return cosineInterpolate(i1, i2, fractionalY);
    }

    public static void main(String[] args) throws IOException {
        PerlinNoise perlinNoise = new PerlinNoise();
        Map<String,String> parameters = Map.of(
                "seed", "0",
                "numOctaves", "2");

        IMatrix matrix = perlinNoise.generate(1024, parameters); // Size: 1024x1024, Num octaves = 3
        BufferedImage image = ImageUtils.matrixToGrayImage(matrix, true);
        ImageIO.write(image, "PNG", File.createTempFile("perlinNoise", ".png", tmpDir));
    }



}
