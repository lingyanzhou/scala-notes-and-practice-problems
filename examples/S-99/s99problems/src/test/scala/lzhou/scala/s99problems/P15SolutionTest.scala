package lzhou.scala.s99problems

import org.scalatest.FunSuite
import org.scalatest.MustMatchers._

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class P15SolutionTest extends FunSuite {
    test("P15 Solution") {
        val tests = List((List(), 2, List()),
                        (List('a, 'a), 2, List('a,'a,'a,'a)),
                        (List('a, 'b, 'b), 3, List('a,'a,'a,'b,'b,'b,'b,'b,'b)),
                        (List('a, 'b, 'c, 'b), 1, List('a,'b,'c,'b))
                        )
        tests.foreach(test=>
            P15Solution.get().duplicateN(test._2, test._1) must equal (test._3)
        )
    }
}

