package lzhou.scala.s99problems

import org.scalatest.FunSuite
import org.scalatest.MustMatchers._

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import multiwaytree.MTree
import lzhou.scala.s99problems.P71Solution._

@RunWith(classOf[JUnitRunner])
class P71SolutionTest extends FunSuite {
    
    test("P71 Solution internalPathLength") {
        val tests = List(
                        ("1^", 0),
                        ("12^^", 1),
                        ("12^3^^", 2),
                        ("123^^^", 3),
                        ("1234^^^^", 6),
                        ("123^45^^^6^78^^^", 12)
                        )
        tests.foreach(test=>
            P71Solution.get.internalPathLength(test._1) must equal (test._2)
        )
    }
}

