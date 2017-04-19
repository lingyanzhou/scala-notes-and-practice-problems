package lzhou.scala.s99problems

import org.scalatest.FunSuite
import org.scalatest.MustMatchers._

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class P18SolutionTest extends FunSuite {
    test("P18 Solution") {
        val tests = List((0, 1, List(), List()),
                        (0, 1, List('a), List('a)),
                        (0, 1, List('a,'b), List('a)),
                        (1, 2, List('a,'b), List('b)),
                        (2, 3, List('a,'b), List()),
                        (1, 3, List('a,'b,'c), List('b,'c)),
                        (1, 1, List('a,'b,'c), List()),
                        (0, 3, List('a,'b,'c), List('a, 'b,'c))
                        )
        tests.foreach(test=>
            P18Solution.get().slice(test._1, test._2, test._3) must equal (test._4)
        )
    }
}

