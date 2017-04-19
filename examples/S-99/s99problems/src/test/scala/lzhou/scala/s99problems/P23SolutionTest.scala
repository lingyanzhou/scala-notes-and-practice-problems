package lzhou.scala.s99problems

import org.scalatest.FunSuite
import org.scalatest.MustMatchers._

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class P23SolutionTest extends FunSuite {
    test("P23 Solution inrange") {
        val tests = List(
                        (1, List('a)),
                        (2, List('a,'b,'c)),
                        (10, List('a,'b,'c,'d,'e)),
                        (100, List('a,'b,'c,'d,'e,'f))
                        )
        tests.foreach(test=>
            P23Solution.get().randomSelect(test._1, test._2) must have size (test._1)
        )
    }
}

