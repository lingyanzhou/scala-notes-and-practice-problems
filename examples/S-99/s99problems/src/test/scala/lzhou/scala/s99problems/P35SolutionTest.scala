package lzhou.scala.s99problems

import org.scalatest.FunSuite
import org.scalatest.MustMatchers._
import java.util.NoSuchElementException

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class P35SolutionTest extends FunSuite {
    
    test("P35 Solution totient") {
        val tests = List((1,Nil),
                         (2,List(2)),
                         (3,List(3)),
                         (4,List(2,2)),
                         (5,List(5)),
                         (6,List(2,3)),
                         (7,List(7)),
                         (8,List(2,2,2)),
                         (9,List(3,3)),
                         (10,List(2,5)),
                         (11,List(11)),
                         (12,List(2,2,3)),
                         (13,List(13)),
                         (14,List(2,7)),
                         (15,List(3,5)),
                         (20,List(2,2,5)),
                         (22,List(2,11)),
                         (25,List(5,5)),
                         (27,List(3,3,3)),
                         (100,List(2,2,5,5)))
        tests.foreach(x=>
            withClue(f"${x._1}.primeFactors = ${x._2}:") {
                P35Solution.of(x._1).primeFactors must equal (x._2)
            }
        )
    }
}

