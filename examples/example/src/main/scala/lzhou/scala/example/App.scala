package lzhou.scala.example

/**
 * @author ${user.name}
 */
object App {
  class A {
      def f() = {
        println("hello");
      }
  }
  (new A).f()
  def foo(x : Array[String]) = x.foldLeft("")((a,b) => a + b)
  
  def main(args : Array[String]) {
    println( "Hello World!" )
    println("concat arguments = " + foo(args))
  }

}
