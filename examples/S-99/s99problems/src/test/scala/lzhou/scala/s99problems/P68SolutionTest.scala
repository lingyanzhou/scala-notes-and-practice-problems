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
class P68SolutionTest extends FunSuite {
    
    test("P68 Solution preorder") {
        val tests = List(
                        (Node(1), List(1)),
                        (Node(1, Node(2), End), List(1,2)),
                        (Node(1, End, Node(2)), List(1,2)),
                        (Node(1, Node(2), Node(3)), List(1,2,3)),
                        (Node(1, Node(2, End, Node(3)), Node(4, Node(5), End)), List(1,2,3,4,5)),
                        (Node(1, Node(2, Node(3, End, Node(4)), Node(5, Node(6), End)), End), List(1,2,3,4,5,6))
                        )
        tests.foreach(test=>
            P68Solution.get.preorder(test._1) must equal (test._2)
        )
    }
    
    test("P68 Solution inorder") {
        val tests = List(
                        (Node(1), List(1)),
                        (Node(1, Node(2), End), List(2,1)),
                        (Node(1, End, Node(2)), List(1,2)),
                        (Node(1, Node(2), Node(3)), List(2,1,3)),
                        (Node(1, Node(2, End, Node(3)), Node(4, Node(5), End)), List(2,3,1,5,4)),
                        (Node(1, Node(2, Node(3, End, Node(4)), Node(5, Node(6), End)), End), List(3,4,2,6,5,1))
                        )
        tests.foreach(test=>
            P68Solution.get.inorder(test._1) must equal (test._2)
        )
    }
    
    test("P68 Solution preInTree") {
        val tests = List(
                        (List(1), List(1), Node(1)),
                        (List(1,2), List(2,1), Node(1, Node(2), End)),
                        (List(1,2), List(1,2), Node(1, End, Node(2))),
                        (List(1,2,3), List(2,1,3), Node(1, Node(2), Node(3))),
                        (List(1,2,3,4,5), List(2,3,1,5,4), Node(1, Node(2, End, Node(3)), Node(4, Node(5), End))),
                        (List(1,2,3,4,5,6), List(3,4,2,6,5,1), Node(1, Node(2, Node(3, End, Node(4)), Node(5, Node(6), End)), End))
                        )
        tests.foreach(test=>
            P68Solution.get.preInTree(test._1, test._2) must equal (test._3)
        )
    }
}

