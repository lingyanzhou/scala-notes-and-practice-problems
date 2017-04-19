package lzhou.scala.s99problems

import org.scalatest.FunSuite
import org.scalatest.MustMatchers._

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class P21SolutionTest extends FunSuite {
    test("P21 Solution inrange") {
        val tests = List(
                        (-1, 'a, List('b), List('a, 'b)),
                        (0, 'a, List('b), List('a, 'b)),
                        (1, 'a, List('b), List('b, 'a)),
                        (2, 'a, List('b), List('b, 'a)),
                        (0, 'new, List('a, 'b), List('new, 'a,'b)),
                        (1, 'new, List('a, 'b), List('a,'new, 'b)),
                        (2, 'new, List('a, 'b), List('a,'b, 'new))
                        )
        tests.foreach(test=>
            P21Solution.get().insertAt(test._1, test._2, test._3) must equal (test._4)
        )
    }
}

