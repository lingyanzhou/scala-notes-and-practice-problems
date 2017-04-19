package lzhou.scala.s99problems

import org.scalatest.FunSuite
import org.scalatest.MustMatchers._

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class P06SolutionTest extends FunSuite {
    test("P06 Solution") {
        val tests = List((List(), true),
                        (List(1), true),
                        (List(1,2), false),
                        (List(1,2,1), true),
                        (List(1,2,2), false),
                        (List(2,2,1), false),
                        (List(2,2,2), true),
                        (List(3,1,3), true),
                        (List(1,3,3,1), true),
                        (List(1,3,2,1), false),
                        (List(1,3,3,2), false))
        tests.foreach(test=>
            P06Solution.get().isPalindrome(test._1) must equal (test._2)
        )
    }
}

