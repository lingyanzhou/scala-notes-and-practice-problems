package lzhou.scala.s99problems

import org.scalatest.FunSuite
import org.scalatest.MustMatchers._

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import multiwaytree.MTree
import lzhou.scala.s99problems.P70Solution._

@RunWith(classOf[JUnitRunner])
class P70SolutionTest extends FunSuite {
    
    test("P70 Solution nodeCount") {
        val tests = List(
                        (MTree(1), 1),
                        (MTree(1, List(MTree(2))), 2),
                        (MTree(1, List(MTree(2),MTree(3))), 3),
                        (MTree(1, List(MTree(2,List(MTree(3))))), 3),
                        (MTree(1, List(MTree(2,List(MTree(3,List(MTree(4))))))), 4),
                        (MTree(1, List(MTree(2, List(MTree(3), MTree(4, List(MTree(5))))), MTree(6), MTree(7, List(MTree(8))))), 8)
                        )
        tests.foreach(test=>
            P70Solution.get.nodeCount(test._1) must equal (test._2)
        )
    }
    
    test("P70 Solution toString") {
        val tests = List(
                        (MTree(1), "1^"),
                        (MTree(1, List(MTree(2))), "12^^"),
                        (MTree(1, List(MTree(2),MTree(3))), "12^3^^"),
                        (MTree(1, List(MTree(2,List(MTree(3))))), "123^^^"),
                        (MTree(1, List(MTree(2,List(MTree(3,List(MTree(4))))))), "1234^^^^"),
                        (MTree(1, List(MTree(2, List(MTree(3), MTree(4, List(MTree(5))))), MTree(6), MTree(7, List(MTree(8))))), "123^45^^^6^78^^^")
                        )
        tests.foreach(test=>
            P70Solution.get.mTree2String(test._1) must equal (test._2)
        )
    }
    
    test("P70 Solution string2MTree") {
        val tests = List(
                        (MTree(1), "1^"),
                        (MTree(1, List(MTree(2))), "12^^"),
                        (MTree(1, List(MTree(2),MTree(3))), "12^3^^"),
                        (MTree(1, List(MTree(2,List(MTree(3))))), "123^^^"),
                        (MTree(1, List(MTree(2,List(MTree(3,List(MTree(4))))))), "1234^^^^"),
                        (MTree(1, List(MTree(2, List(MTree(3), MTree(4, List(MTree(5))))), MTree(6), MTree(7, List(MTree(8))))), "123^45^^^6^78^^^")
                        )
        tests.foreach(test=>
            P70Solution.get.string2MTree(test._2).toString must equal (test._1.toString)
        )
    }
    
    test("P70 Solution implicit string2MTree") {
        val tests = List(
                        (1, "1^"),
                        (2, "12^^"),
                        (3, "12^3^^"),
                        (3, "123^^^"),
                        (4, "1234^^^^"),
                        (8, "123^45^^^6^78^^^")
                        )
        tests.foreach(test=>
            test._2.nodeCount must equal (test._1)
        )
    }
}

