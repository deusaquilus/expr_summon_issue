package io.getquill.mytest

object MyUser {

  def encodeIt[T](t: T)(using enc: MyEncoder[T]) = enc.encode(t)

  def doEncoding: Unit = {
    val ctx = new MyContext()
    import ctx.{*, given}
    
    // This works
    //println(encodeIt(123))
    
    // This does not
    println(MyMacro.getAndEncode(123))
  }

  def main(args: Array[String]): Unit = {
    doEncoding
  }
}