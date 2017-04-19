package lzhou.scala.s99problems

import org.scalatest.FunSuite
import org.scalatest.MustMatchers._

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class P49SolutionTest extends FunSuite {
    test("P49 Solution") {
        val tests = List((1, List("0","1")),
                        (2, List("00","01","11","10")),
                        (3, List("000","001","011","010","110","111","101","100"))
                        )
        tests.foreach(test=>
            P49Solution.get().gray(test._1) must equal (test._2)
        )
    }
}

