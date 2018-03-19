package mayton.math;

/**
 * @deprecated refactor with Iterator
 */
@Deprecated
public interface INumGenerator {

    void reset();
    int getNext();
    boolean hasNext();

}
