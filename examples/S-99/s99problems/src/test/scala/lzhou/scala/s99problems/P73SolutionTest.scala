package lzhou.scala.s99problems

import org.scalatest.FunSuite
import org.scalatest.MustMatchers._

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import multiwaytree.MTree
import lzhou.scala.s99problems.P73Solution._

@RunWith(classOf[JUnitRunner])
class P73SolutionTest extends FunSuite {
    
    test("P73 Solution lispyTree") {
        val tests = List(
                        (MTree(1), "1"),
                        (MTree(1, List(MTree(2))), "(1 2)"),
                        (MTree(1, List(MTree(2),MTree(3))), "(1 2 3)"),
                        (MTree(1, List(MTree(2,List(MTree(3))))), "(1 (2 3))"),
                        (MTree(1, List(MTree(2,List(MTree(3,List(MTree(4))))))), "(1 (2 (3 4)))"),
                        (MTree(1, List(MTree(2, List(MTree(3), MTree(4, List(MTree(5))))), MTree(6), MTree(7, List(MTree(8))))), "(1 (2 3 (4 5)) 6 (7 8))")
                        )
        tests.foreach(test=>
            P73Solution.get.lispyTree(test._1) must equal (test._2)
        )
    }
    
    test("P73 Solution delispyTree") {
        val tests = List(
                        (MTree(1), "1"),
                        (MTree(1, List(MTree(2))), "(1 2)"),
                        (MTree(1, List(MTree(2),MTree(3))), "(1 2 3)"),
                        (MTree(1, List(MTree(2,List(MTree(3))))), "(1 (2 3))"),
                        (MTree(1, List(MTree(2,List(MTree(3,List(MTree(4))))))), "(1 (2 (3 4)))"),
                        (MTree(1, List(MTree(2, List(MTree(3), MTree(4, List(MTree(5))))), MTree(6), MTree(7, List(MTree(8))))), "(1 (2 3 (4 5)) 6 (7 8))")
                        )
        tests.foreach(test=>
            P73Solution.get.delispyTree(test._2).toString must equal (test._1.toString)
        )
    }
}

