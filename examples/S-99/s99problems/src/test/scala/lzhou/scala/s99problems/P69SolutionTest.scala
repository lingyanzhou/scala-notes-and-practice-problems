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
class P69SolutionTest extends FunSuite {
    
    test("P69 Solution treeToDotstring") {
        val tests = List(
                        (Node('x'), "x.."),
                        (Node('x', Node('y'), End), "xy..."),
                        (Node('x', Node('y'), Node('z')), "xy..z.."),
                        (Node('x', End, Node('z')), "x.z.."),
                        (Node('a', Node('b', End, Node('c')), Node('d', Node('e'), End)),  "ab.c..de..."),
                        (Node('1', Node('a', Node('b', End, Node('c')), Node('d', Node('e'), End)), End), "1ab.c..de....")
                        )
        tests.foreach(test=>
            P69Solution.get.treeToDotstring(test._1) must equal (test._2)
        )
    }
    
    test("P69 Solution treeFromDotstring") {
        val tests = List(
                        (Node('x'), "x.."),
                        (Node('x', Node('y'), End), "xy..."),
                        (Node('x', Node('y'), Node('z')), "xy..z.."),
                        (Node('x', End, Node('z')), "x.z.."),
                        (Node('a', Node('b', End, Node('c')), Node('d', Node('e'), End)),  "ab.c..de..."),
                        (Node('1', Node('a', Node('b', End, Node('c')), Node('d', Node('e'), End)), End), "1ab.c..de....")
                        )
        tests.foreach(test=>
            P69Solution.get.treeFromDotstring(test._2).toString must equal (test._1.toString)
        )
    }
}

