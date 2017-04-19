package lzhou.scala.s99problems

import org.scalatest.FunSuite
import org.scalatest.MustMatchers._
import java.util.NoSuchElementException

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class P31SolutionTest extends FunSuite {
    
    test("P31 Solution is prime") {
        val tests = List(2,3,5,7,11,13,17,19,23,59,331,550111)
        tests.foreach(x=>
            withClue(f"$x%d.isPrime :") {
                P31Solution.of(x).isPrime must equal (true)
            }
        )
    }
    
    test("P31 Solution is not prime") {
        val tests = List(1,4,6,8,9,10,12,14,15,16,18,20,57,551111,55173119)
        tests.foreach(x=>
            withClue(f"$x%d.isPrime :") {
                P31Solution.of(x).isPrime must equal (false)
            }
        )
    }
}

