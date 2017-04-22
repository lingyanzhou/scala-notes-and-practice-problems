package lzhou.scala.s99problems

import org.scalatest.FunSuite
import org.scalatest.MustMatchers._

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class P91SolutionTest extends FunSuite {
    test("P91 Solution impossible") {
        P91Solution.get.jump(3, 1, 1) must equal (Option.empty)
        P91Solution.get.jump(4, 1, 1) must equal (Option.empty)
    }
    test("P91 Solution 5") {
        val result = P91Solution.get.jump(5, 1, 1)
        result.nonEmpty must equal (true)
        result.get.distinct.size must equal (5*5)
    }
    test("P91 Solution 6") {
        val result = P91Solution.get.jump(6, 1, 1)
        result.nonEmpty must equal (true)
        result.get.distinct.size must equal (6*6)
    }
}

