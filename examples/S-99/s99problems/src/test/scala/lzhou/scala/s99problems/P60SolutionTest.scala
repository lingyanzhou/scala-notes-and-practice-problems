package lzhou.scala.s99problems

import org.scalatest.FunSuite
import org.scalatest.MustMatchers._

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import binarytree.Tree
import binarytree.Node
import binarytree.End

@RunWith(classOf[JUnitRunner])
class P60SolutionTest extends FunSuite {
    
    test("P60 Solution minHbalNodes") {
        val tests = List(
                        (0, 0),
                        (1, 1),
                        (2, 2),
                        (3, 4),
                        (4, 7),
                        (5, 12),
                        (6, 20)
                        )
        tests.foreach(test=>
            P60Solution.get.minHbalNodes(test._1) must equal (test._2)
        )
    }
    
    test("P60 Solution maxHbalNodes") {
        val tests = List(
                        (0, 0),
                        (1, 1),
                        (2, 3),
                        (3, 7),
                        (4, 15),
                        (5, 31)
                        )
        tests.foreach(test=>
            P60Solution.get.maxHbalNodes(test._1) must equal (test._2)
        )
    }
    
    test("P60 Solution minHbalHeight") {
        val tests = List(
                        (0, 0),
                        (1, 1),
                        (2, 2),
                        (3, 2),
                        (4, 3),
                        (5, 3),
                        (6, 3),
                        (7, 3),
                        (8, 4),
                        (9, 4),
                        (15, 4),
                        (16, 5),
                        (17, 5)
                        )
        tests.foreach(test=>
            P60Solution.get.minHbalHeight(test._1) must equal (test._2)
        )
    }
    
    test("P60 Solution maxHbalHeight") {
        val tests = List(
                        (0, 0),
                        (1, 1),
                        (2, 2),
                        (3, 2),
                        (4, 3),
                        (5, 3),
                        (6, 3),
                        (7, 4),
                        (8, 4),
                        (9, 4),
                        (11, 4),
                        (12, 5),
                        (13, 5),
                        (19, 5),
                        (20, 6),
                        (21, 6)
                        )
        tests.foreach(test=>
            withClue(f"maxHbalHeight(${test._1}) = ${test._2}: ") {
                P60Solution.get.maxHbalHeight(test._1) must equal (test._2)
            }
        )
    }
    
    test("P60 Solution nodeCount") {
        val tests = List(
                        (Node("y", Node("x"), End), 2),
                        (Node("x", Node("y", Node("z"), End), End), 3),
                        (Node("y", Node("x", Node("x1"), Node("x2")), End), 4),
                        (Node("y", End, Node("x")), 2),
                        (Node("y", End, Node("x", Node("x1"), Node("x2"))), 4),
                        (Node("y", Node("x1"), Node("x2")), 3)
                        )
        tests.foreach(test=>
            P60Solution.get.nodeCount(test._1) must equal (test._2)
        )
    }
    
    test("P60 Solution hbalTreesWithNodes size only") {
        val tests = List(
                        (1, 1),
                        (2, 2),
                        (3, 1),
                        (4, 4),
                        (5, 6)
                        )
        tests.foreach(test=>
            P60Solution.get.hbalTreesWithNodes(test._1, 'x').size must equal (test._2)
        )
    }
}

