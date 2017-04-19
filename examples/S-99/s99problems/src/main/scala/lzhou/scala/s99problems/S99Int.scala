package lzhou.scala.s99problems

trait S99Int {
    val data:Int
    def isPrime: Boolean = false
    def isCoprimeTo(n:Int): Boolean = false
    def totient: Int = 0
    def primeFactors : List[Int] = Nil
    def primeFactorMultipicity : Map[Int, Int] = Map()
    def goldbach: (Int, Int) = (0, 0)
}
