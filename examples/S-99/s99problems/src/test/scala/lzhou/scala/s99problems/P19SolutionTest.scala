package lzhou.scala.s99problems

import org.scalatest.FunSuite
import org.scalatest.MustMatchers._

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class P19SolutionTest extends FunSuite {
    test("P19 Solution") {
        val tests = List((0, List(), List()),
                        (1, List('a), List('a)),
                        (0, List('a,'b), List('a, 'b)),
                        (1, List('a,'b), List('b, 'a)),
                        (1, List('a,'b,'c), List('b,'c,'a)),
                        (2, List('a,'b,'c), List('c, 'a, 'b)),
                        (3, List('a,'b,'c), List('a, 'b,'c))
                        )
        tests.foreach(test=>
            P19Solution.get().rotate(test._1, test._2) must equal (test._3)
        )
    }
}

