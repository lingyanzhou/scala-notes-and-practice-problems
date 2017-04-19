package lzhou.scala.s99problems

import org.scalatest.FunSuite
import org.scalatest.MustMatchers._

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import binarytree.Tree
import binarytree.Node
import binarytree.PositionedNode
import binarytree.End

@RunWith(classOf[JUnitRunner])
class P64SolutionTest extends FunSuite {
    
    test("P64 Solution layoutBinaryTree") {
        val tests = List(
                        (Node('x'), PositionedNode('x', 1, 1)),
                        (Node('x', Node('y'), End), PositionedNode('x', PositionedNode('y', 1,2), End, 2, 1)),
                        (Node('x', Node('y'), Node('z')), PositionedNode('x', PositionedNode('y', 1,2), PositionedNode('z', 3,2), 2, 1)),
                        (Node('a', Node('b', End, Node('c')), Node('d', Node('e'), End)), PositionedNode('a', PositionedNode('b', End, PositionedNode('c', 2, 3), 1, 2), PositionedNode('d', PositionedNode('e', 4, 3), End, 5, 2), 3, 1)),
                        (Node('1', Node('a', Node('b', End, Node('c')), Node('d', Node('e'), End)), End), PositionedNode('1', PositionedNode('a', PositionedNode('b', End, PositionedNode('c', 2, 4), 1, 3), PositionedNode('d', PositionedNode('e', 4, 4), End, 5, 3), 3, 2), End, 6, 1))
                        )
        tests.foreach(test=>
            P64Solution.get.layoutBinaryTree(test._1) must equal (test._2)
        )
    }
}

