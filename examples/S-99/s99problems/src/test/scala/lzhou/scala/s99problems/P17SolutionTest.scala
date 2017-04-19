package lzhou.scala.s99problems

import org.scalatest.FunSuite
import org.scalatest.MustMatchers._

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class P17SolutionTest extends FunSuite {
    test("P17 Solution") {
        val tests = List((List(), 2, (List(),List())),
                        (List('a, 'a), 1, (List('a),List('a))),
                        (List('a, 'a), 2, (List('a,'a),List())),
                        (List('a, 'b, 'b), 2, (List('a, 'b), List('b))),
                        (List('a, 'b, 'b), 1, (List('a), List('b, 'b))),
                        (List('a, 'b, 'c, 'b), 1, (List('a), List('b, 'c, 'b))),
                        (List('a, 'b, 'c, 'b), 2, (List('a, 'b), List('c, 'b))),
                        (List('a, 'b, 'c, 'b), 3, (List('a, 'b, 'c), List('b)))
                        )
        tests.foreach(test=>
            P17Solution.get().split(test._2, test._1) must equal (test._3)
        )
    }
}

