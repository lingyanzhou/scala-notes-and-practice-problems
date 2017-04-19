package lzhou.scala.s99problems

import org.scalatest.FunSuite
import org.scalatest.MustMatchers._
import java.util.NoSuchElementException

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class P36SolutionTest extends FunSuite {
    
    test("P36 Solution totient") {
        val tests = Map((1,Map()),
                         (2,Map(2->1)),
                         (3,Map(3->1)),
                         (4,Map(2->2)),
                         (5,Map(5->1)),
                         (6,Map(2->1,3->1)),
                         (7,Map(7->1)),
                         (8,Map(2->3)),
                         (9,Map(3->2)),
                         (10,Map(2->1,5->1)),
                         (11,Map(11->1)),
                         (12,Map(2->2,3->1)),
                         (13,Map(13->1)),
                         (14,Map(2->1,7->1)),
                         (15,Map(3->1,5->1)),
                         (20,Map(2->2,5->1)),
                         (22,Map(2->1,11->1)),
                         (25,Map(5->2)),
                         (27,Map(3->3)),
                         (100,Map(2->2,5->2)))
        tests.foreach(x=>
            withClue(f"${x._1}.primeFactorMultipicity = ${x._2}:") {
                P36Solution.of(x._1).primeFactorMultipicity must equal (x._2)
            }
        )
    }
}

