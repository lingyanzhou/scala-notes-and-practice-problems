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
class P67SolutionTest extends FunSuite {
    
    test("P67 Solution treeToString") {
        val tests = List(
                        (Node('x'), "x"),
                        (Node('x', Node('y'), End), "x(y,)"),
                        (Node('x', Node('y'), Node('z')), "x(y,z)"),
                        (Node('x', End, Node('z')), "x(,z)"),
                        (Node('a', Node('b', End, Node('c')), Node('d', Node('e'), End)),  "a(b(,c),d(e,))"),
                        (Node('1', Node('a', Node('b', End, Node('c')), Node('d', Node('e'), End)), End), "1(a(b(,c),d(e,)),)")
                        )
        tests.foreach(test=>
            P67Solution.get.treeToString(test._1) must equal (test._2)
        )
    }
    
    test("P67 Solution treeFromString") {
        val tests = List(
                        (Node('x'), "x"),
                        (Node('x', Node('y'), End), "x(y,)"),
                        (Node('x', Node('y'), Node('z')), "x(y,z)"),
                        (Node('x', End, Node('z')), "x(,z)"),
                        (Node('a', Node('b', End, Node('c')), Node('d', Node('e'), End)),  "a(b(,c),d(e,))"),
                        (Node('1', Node('a', Node('b', End, Node('c')), Node('d', Node('e'), End)), End), "1(a(b(,c),d(e,)),)")
                        )
        tests.foreach(test=>
            P67Solution.get.treeFromString(test._2).toString must equal (test._1.toString)
        )
    }
}

