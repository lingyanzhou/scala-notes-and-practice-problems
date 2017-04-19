package lzhou.scala.s99problems

import org.scalatest.FunSuite
import org.scalatest.MustMatchers._
import java.util.NoSuchElementException

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class P39SolutionTest extends FunSuite {
    
    test("P39 Solution listPrimesinRange") {
        val tests = List((0, 1, List()),
                        (0, 2, List(2)),
                        (2, 2, List(2)),
                        (2, 3, List(2,3)),
                        (0, 5, List(2,3,5)),
                        (4, 10, List(5,7)),
                        (5, 23, List(5,7,11,13,17,19,23)))
        tests.foreach(x=>
            withClue(f"listPrimesinRange(${x._1}, ${x._2})=${x._3}:") {
                P39Solution.get.listPrimesinRange(x._1, x._2) must equal (x._3)
            }
        )
    }
}

