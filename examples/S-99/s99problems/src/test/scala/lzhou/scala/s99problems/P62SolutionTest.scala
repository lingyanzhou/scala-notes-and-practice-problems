package lzhou.scala.s99problems

import org.scalatest.FunSuite
import org.scalatest.MustMatchers._

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import binarytree.Node
import binarytree.End

@RunWith(classOf[JUnitRunner])
class P62SolutionTest extends FunSuite {
    test("P62 Solution internalList") {
        val tests = List(
                        (Node("y", Node("x"), End), List("y")),
                        (Node("x", Node("y", Node("z"), End), End), List("y","x")),
                        (Node("y", Node("x", Node("x1"), Node("x2")), End), List("x", "y")),
                        (Node("y", End, Node("x")), List("y")),
                        (Node("y", End, Node("x", Node("x1"), Node("x2"))), List("y", "x")),
                        (Node("y", Node("x1"), Node("x2")), List("y"))
                        )
        tests.foreach(test=>
            P62Solution.get.internalList(test._1) must equal (test._2)
        )
    }
    test("P62 Solution atLevel") {
        val tests = List(
                        (1, Node("y", Node("x"), End), List("y")),
                        (1, Node("x", Node("y", Node("z"), End), End), List("x")),
                        (2, Node("x", Node("y", Node("z"), End), End), List("y")),
                        (3, Node("x", Node("y", Node("z"), End), End), List("z")),
                        (4, Node("x", Node("y", Node("z"), End), End), Nil),
                        (2, Node("y", Node("x", Node("x1"), Node("x2")), End), List("x")),
                        (3, Node("y", Node("x", Node("x1"), Node("x2")), End), List("x1", "x2")),
                        (2, Node("y", End, Node("x", Node("x1"), Node("x2"))), List("x")),
                        (3, Node("y", End, Node("x", Node("x1"), Node("x2"))), List("x1", "x2"))
                        )
        tests.foreach(test=>
            P62Solution.get.atLevel(test._1, test._2) must equal (test._3)
        )
    }
}

