package lzhou.scala.s99problems

import org.scalatest.FunSuite
import org.scalatest.MustMatchers._
import java.util.NoSuchElementException

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class P34SolutionTest extends FunSuite {
    
    test("P34 Solution totient") {
        val tests = List((1,1),
                         (2,1),
                         (5,4),
                         (7,6),
                         (8,4),
                         (9,6),
                         (11,10),
                         (12,4),
                         (14,6),
                         (27,18),
                         (39,24),
                         (41,40),
                         (77,60),
                         (92,44),
                         (99,60))
        tests.foreach(x=>
            withClue(f"${x._1}%d.totient = ${x._2}:") {
                P34Solution.of(x._1).totient must equal (x._2)
            }
        )
    }
}

