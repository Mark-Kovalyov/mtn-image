/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mayton.image.fractal;

/**
 * 
 *
 * Логистическое отображение (также известное, как квадратичное отображение
 * или отображение Фейгенбаума) - полиномиальное отображение, хрестоматийно
 * упоминаемое в качестве типичного примера того, как сложное, хаотическое
 * поведение может возникать из очень простых нелинейных уравнений. Отображение
 * является дискретным аналогом непрерывного логистического уравнения Ферхюльста,
 * отражая тот факт, что прирост популяции происходит в дискретные моменты времени.
 * Математическая формулировка отображения
 *
 *   x_{n+1} = r x_n (1-x_n)\,
 *
 * где:
 *
 *   x_n\, принимает значения от 0 до 1 и отражает численность популяции в n\,-ом году, а x_0\,
 * обозначает начальную численность (в год номер 0)
 *   r\, — положительный параметр, характеризующий скорость размножения (роста) популяции.
 * @author mayton
 */
public class FaigenbaumMapping implements Runnable {

    public void run() {
        
    }

}
