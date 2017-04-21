/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mayton.math;

import mayton.math.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * @author mayton
 */
public class OctonionTest {

    @Test
    public void testGetModule() {
        Octonion o1=new Octonion(1.0d,2.0d,3.0d,4.0d,5.0d,4.0d,3.0d,2.0d);
        assertEquals(9.1651513d,
                     o1.getModule(),
                     0.0000001d);
    }

}