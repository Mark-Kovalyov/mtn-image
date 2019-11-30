package mayton.image;

import org.jetbrains.annotations.Range;

import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public interface IProgressable {

    /**
     *
     * @return range from 0 to 100 percents
     */
    @Range(from = 0, to = 100)
    int progress();

}
