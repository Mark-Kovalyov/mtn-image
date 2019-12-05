package mayton.image.procedural.filters;

/*
import org.deeplearning4j.nn.conf.MultiLayerConfiguration;
import org.deeplearning4j.nn.conf.NeuralNetConfiguration;
import org.deeplearning4j.nn.conf.layers.DenseLayer;
import org.deeplearning4j.nn.conf.layers.OutputLayer;
import org.deeplearning4j.nn.weights.WeightInit;
import org.nd4j.linalg.activations.Activation;
import org.nd4j.linalg.learning.config.Nesterovs;
import org.nd4j.linalg.lossfunctions.LossFunctions;

import static org.nd4j.linalg.lossfunctions.LossFunctions.LossFunction.NEGATIVELOGLIKELIHOOD;
*/

import mayton.image.Raster;
import mayton.image.Rect;
import mayton.image.standard.Resolutions;
import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class Main {

    static Logger logger = LoggerFactory.getLogger(Main.class);

    public void go(String[] args) throws IOException {

        System.out.println("user dir = " + System.getProperty("user.dir"));

        //InputStream is = getClass().getResourceAsStream("../log4j.properties");

        PropertyConfigurator.configure("log4j.properties");

        int rngSeed = 123; // random number seed for reproducibility
        //number of rows and columns in the input pictures
        final int numRows = 28;
        final int numColumns = 28;
        int outputNum = 10; // number of output classes

        int x = Resolutions.FULL_HD.x;
        int y = Resolutions.FULL_HD.y;

        int xlt = x / 2;
        int ylt = y / 2;

        Rect mainRect = new Rect(0,0,x,y);

        File sourceFolder = new File("/storage/sql.ru/alibek/c1_29");
        for(File file : sourceFolder.listFiles()) {
            String path = file.getAbsolutePath();
            logger.info(":: path = {}", path);
            if (path.toLowerCase().endsWith(".jpg")) {
                BufferedImage image = ImageIO.read(file);
                Rect rect = new Rect(0, 0, image.getWidth(), image.getHeight());
                if (rect.isIn(mainRect)) {
                    logger.info(":: rect {} is in rect {}", rect.toString(), mainRect.toString());
                } else {
                    logger.warn(":: rect {} is not in rect {}",  rect.toString(), mainRect.toString());
                }
            }
        }

/*
        MultiLayerConfiguration conf = new NeuralNetConfiguration.Builder()
                .seed(rngSeed) //include a random seed for reproducibility
                // use stochastic gradient descent as an optimization algorithm
                .updater(new Nesterovs(0.006, 0.9))
                .l2(1e-4)
                .list()
                .layer(1, new DenseLayer.Builder() //create the first, input layer with xavier initialization
                        .nIn(numRows * numColumns)
                        .nOut(1000)
                        .activation(Activation.RELU)
                        .weightInit(WeightInit.XAVIER)
                        .build())
                .layer(2, new OutputLayer.Builder(NEGATIVELOGLIKELIHOOD) //create hidden layer
                        .nIn(1000)
                        .nOut(outputNum)
                        .activation(Activation.SOFTMAX)
                        .weightInit(WeightInit.XAVIER)
                        .build())
                .build();
*/

    }

    public static void main(String[] args) throws IOException {

        new Main().go(args);

    }

}
