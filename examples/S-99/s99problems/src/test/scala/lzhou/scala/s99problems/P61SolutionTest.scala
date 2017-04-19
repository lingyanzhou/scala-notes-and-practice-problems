package lzhou.scala.s99problems

import org.scalatest.FunSuite
import org.scalatest.MustMatchers._

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import binarytree.Node
import binarytree.End

@RunWith(classOf[JUnitRunner])
class P61SolutionTest extends FunSuite {
    test("P61 Solution leafList") {
        val tests = List(
                        (Node("y", Node("x"), End), List("x")),
                        (Node("x", Node("y", Node("z"), End), End), List("z")),
                        (Node("y", Node("x", Node("x1"), Node("x2")), End), List("x1", "x2")),
                        (Node("y", End, Node("x")), List("x")),
                        (Node("y", End, Node("x", Node("x1"), Node("x2"))), List("x1", "x2")),
                        (Node("y", Node("x1"), Node("x2")), List("x1", "x2"))
                        )
        tests.foreach(test=>
            P61Solution.get.leafList(test._1) must equal (test._2)
        )
    }
    
    test("P61 Solution leafCount") {
        val tests = List(
                        (Node("y", Node("x"), End), 1),
                        (Node("x", Node("y", Node("z"), End), End), 1),
                        (Node("y", Node("x", Node("x1"), Node("x2")), End), 2),
                        (Node("y", End, Node("x")), 1),
                        (Node("y", End, Node("x", Node("x1"), Node("x2"))), 2),
                        (Node("y", Node("x1"), Node("x2")), 2)
                        )
        tests.foreach(test=>
            P61Solution.get.leafCount(test._1) must equal (test._2)
        )
    }
}

