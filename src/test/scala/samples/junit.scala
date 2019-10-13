package samples

import org.junit._
import Assert._
import mayton.image.iterators.scala.{GilbertLazyStream, Point}

@Test
class AppTest {

    @Test
    def test4x4() : Unit = {
        val gilbertLazyStream : GilbertLazyStream = new GilbertLazyStream
        val result = gilbertLazyStream.gilbertPoinsStream(16).toList
        assertEquals(256, result.size)
    }

}


