package lzhou.scala.s99problems

import org.scalatest.FunSuite
import org.scalatest.MustMatchers._

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class P16SolutionTest extends FunSuite {
    test("P16 Solution") {
        val tests = List((List(), 2, List()),
                        (List('a, 'a), 2, List('a)),
                        (List('a, 'b, 'b), 3, List('a,'b)),
                        (List('a, 'b, 'b), 2, List('a,'b)),
                        (List('a, 'b, 'c, 'b), 2, List('a,'c)),
                        (List('a, 'b, 'c, 'b), 3, List('a,'b,'b)),
                        (List('a, 'b, 'c, 'b), 4, List('a,'b,'c))
                        )
        tests.foreach(test=>
            P16Solution.get().drop(test._2, test._1) must equal (test._3)
        )
    }
}

