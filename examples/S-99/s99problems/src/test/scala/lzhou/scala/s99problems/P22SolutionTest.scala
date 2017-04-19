package lzhou.scala.s99problems

import org.scalatest.FunSuite
import org.scalatest.MustMatchers._

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class P22SolutionTest extends FunSuite {
    test("P22 Solution inrange") {
        val tests = List(
                        (1, 1, List(1)),
                        (-1, 1, List(-1,0,1)),
                        (-4, 0, List(-4,-3,-2,-1,0)),
                        (4, 9, List(4,5,6,7,8,9))
                        )
        tests.foreach(test=>
            P22Solution.get().range(test._1, test._2) must equal (test._3)
        )
    }
}

