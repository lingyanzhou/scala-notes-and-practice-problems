package lzhou.scala.s99problems

import org.scalatest.FunSuite
import org.scalatest.MustMatchers._

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import binarytree.Node
import binarytree.End

@RunWith(classOf[JUnitRunner])
class P56SolutionTest extends FunSuite {
    test("P56 Solution") {
        val tests = List(
                        (new Node('a', End, End), true),
                        (new Node('a', Node('b'), End), false),
                        (new Node('a', Node('b'), Node('c')), true),
                        (new Node('a', End, Node('b')), false),
                        (new Node('a', new Node('b', End, Node('e')), new Node('c', Node('d'), End)), true),
                        (new Node('a', new Node('b', Node('e'), End), new Node('c', End, Node('d'))), true),
                        (new Node('a', new Node('b', Node('e'), End), new Node('c', Node('f'), Node('d'))), false)
                        )
        tests.foreach(test=>
            P56Solution.get.isSymmetric(test._1) must equal (test._2)
        )
    }
}

