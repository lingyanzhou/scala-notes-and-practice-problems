package lzhou.scala.s99problems

import org.scalatest.FunSuite
import org.scalatest.MustMatchers._

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class P90SolutionTest extends FunSuite {
    test("P90 Solution v1") {
        P90Solution.get.eightQueen().size must equal (92)
    }
}

