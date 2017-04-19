package lzhou.scala.s99problems

import org.scalatest.FunSuite
import org.scalatest.MustMatchers._

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class P09SolutionTest extends FunSuite {
    test("P09 Solution") {
        val tests = List((List(), List()),
                        (List('a, 'a, 'a), List(List('a, 'a, 'a))),
                        (List('a, 'b, 'b, 'c), List(List('a),List('b, 'b),List('c))),
                        (List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'b), List(List('a, 'a),List('b, 'b), List('c, 'c, 'c), List('b)))
                        )
        tests.foreach(test=>
            P09Solution.get().pack(test._1) must equal (test._2)
        )
    }
}

