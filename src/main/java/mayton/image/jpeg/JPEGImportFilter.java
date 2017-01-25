/**
 * Date: 07.11.2006 ������ singleton
 */

package mayton.image.jpeg;

import mayton.math.MatrixDCT;
import mayton.math.MatrixQuantization;
import mayton.math.MatrixGeneric;

import java.util.logging.Logger;

public class JPEGImportFilter {

    MatrixDCT	        MDCT  =null;

    MatrixQuantization  Mq = null;

    MatrixGeneric	    MRes;

    Logger              logger=null;

    static JPEGImportFilter    inst=null;

    private static JPEGImportFilter ourInstance = new JPEGImportFilter();

    public synchronized static JPEGImportFilter getInstance() {
        if (inst==null)
        {
            return new JPEGImportFilter();
        }
        return inst;
    }

    private JPEGImportFilter() {

    }
}
