package lzhou.scala.s99problems

import org.scalatest.FunSuite
import org.scalatest.MustMatchers._

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import multiwaytree.MTree
import lzhou.scala.s99problems.P72Solution._

@RunWith(classOf[JUnitRunner])
class P72SolutionTest extends FunSuite {
    
    test("P72 Solution postorder") {
        val tests = List(
                        ("1^", List("1")),
                        ("12^^", List("2", "1")),
                        ("12^3^^", List("2","3","1")),
                        ("123^^^", List("3","2","1")),
                        ("1234^^^^", List("4","3","2","1")),
                        ("123^45^^^6^78^^^", List("3","5","4","2","6","8","7","1"))
                        )
        tests.foreach(test=>
            P72Solution.get.postorder(test._1).toString must equal (test._2.toString)
        )
    }
}

