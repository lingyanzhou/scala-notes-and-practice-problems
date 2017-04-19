package lzhou.scala.s99problems

import org.scalatest.FunSuite
import org.scalatest.MustMatchers._
import java.util.NoSuchElementException

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class P32SolutionTest extends FunSuite {
    
    test("P32 Solution gcd") {
        val tests = List((1,2,1),
                        (100,1,1),
                        (3,2,1),
                        (4,6,2),
                        (24, 8, 8),
                        (8, 32, 8),
                        (12, 40, 4),
                        (33, 77, 11),
                        (33, 311, 1),
                        (16, 9, 1),
                        (21, 100, 1),
                        (180, 40, 20))
        tests.foreach(x=>
            withClue(f"gcd(${x._1}, ${x._2})=${x._3}:") {
                P32Solution.get.gcd(x._1, x._2) must equal (x._3)
            }
        )
    }
}

