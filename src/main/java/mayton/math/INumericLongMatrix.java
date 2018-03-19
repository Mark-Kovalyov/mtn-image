/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mayton.math;

/**
 *
 * @author mayton
 */
public interface INumericLongMatrix extends ISize {

    long get(int x,int y) throws IndexOutOfBoundsException;

}
