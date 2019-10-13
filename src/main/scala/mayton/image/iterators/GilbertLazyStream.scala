package mayton.image.iterators

class GilbertLazyStream {

  val u = 1

  var glx = 0
  var gly = 0

  private def linerel(x: Int, y: Int) : Stream[Point] = {
    glx = glx + x
    gly = gly + y
    //Point(glx, gly)
    Stream.empty
  }

  private def moveto(x: Int, y: Int) : Stream[Point] = {
    glx = glx + x
    gly = gly + y
    //Point(glx, gly)
    Stream.empty
  }

  private def a(i: Int) : Stream[Point] = {
    if (i > 0) {
      d(i - 1)
      linerel(+u, 0)
      a(i - 1)
      linerel(0, u)
      a(i - 1)
      linerel(-u, 0)
      c(i - 1)
    }
    Stream.empty
  }

  private def b(i: Int) : Stream[Point] = {
    if (i > 0) {
      c(i - 1)
      linerel(-u, 0)
      b(i - 1)
      linerel(0, -u)
      b(i - 1)
      linerel(u, 0)
      d(i - 1)
    }
    Stream.empty
  }

  private def c(i: Int) : Stream[Point] = {
    if (i > 0) {
      b(i - 1)
      linerel(0, -u)
      c(i - 1)
      linerel(-u, 0)
      c(i - 1)
      linerel(0, u)
      a(i - 1)
    }
    Stream.empty
  }

  private def d(i: Int) : Stream[Point] = {
    if (i > 0) {
      a(i - 1)
      linerel(0, u)
      d(i - 1)
      linerel(u, 0)
      d(i - 1)
      linerel(0, -u)
      b(i - 1)
    }
    Stream.empty
  }

  def nlz(xArg: Int): Int = {
    var x = xArg
    var n = 0
    if (x == 0) return 32
    n = 1
    if ((x >>> 16) == 0) {
      n += 16
      x <<= 16
    }
    if ((x >>> 24) == 0) {
      n += 8
      x <<= 8
    }
    if ((x >>> 28) == 0) {
      n += 4
      x <<= 4
    }
    if ((x >>> 30) == 0) {
      n += 2
      x <<= 2
    }
    n = n - (x >>> 31)
    n
  }

  def log2up(x: Int): Int = {
    if (x < 1) return 0
    32 - nlz(x - 1)
  }
  /**
   * Prime candidates generator
   *
   * @return
   */
  def gilbertPoinsStream(size : Int) : Stream[Point] = {

    def gilbertPoinsStream(point : Point) : Stream[Point] = {
      Stream.empty
    }

    val level = log2up(size)
    //moveto(0, 0)
    //a(level)
    //new Point(0, 0) #:: new Point(0, 1)
      //moveto(0, 0)
    Point(0,0) #:: gilbertPoinsStream(Point(0,0))
  }

}
