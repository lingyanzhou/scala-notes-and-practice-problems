package lzhou.scala.s99problems

import org.scalatest.FunSuite
import org.scalatest.MustMatchers._

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import binarytree.Tree
import binarytree.Node
import binarytree.End

@RunWith(classOf[JUnitRunner])
class P63SolutionTest extends FunSuite {
    
    test("P63 Solution cbTreeHeight") {
        val tests = List(
                        (1, 1),
                        (2, 2),
                        (3, 2),
                        (4, 3),
                        (5, 3),
                        (6, 3),
                        (7, 3),
                        (8, 4),
                        (9, 4),
                        (10, 4),
                        (11, 4),
                        (15, 4),
                        (16, 5),
                        (17, 5)
                        )
        tests.foreach(test=>
            P63Solution.get.cbTreeHeight(test._1) must equal (test._2)
        )
    }
    
    test("P63 Solution lastLevelNodes") {
        val tests = List(
                        (0, 0),
                        (1, 1),
                        (2, 1),
                        (3, 2),
                        (4, 1),
                        (5, 2),
                        (6, 3),
                        (7, 4),
                        (8, 1),
                        (9, 2),
                        (10, 3),
                        (11, 4),
                        (15, 8),
                        (16, 1),
                        (17, 2)
                        )
        tests.foreach(test=>
            P63Solution.get.lastLevelNodes(test._1) must equal (test._2)
        )
    }
    
    test("P63 Solution levelFullNodes") {
        val tests = List(
                        (1, 1),
                        (2, 2),
                        (3, 4),
                        (4, 8),
                        (5, 16)
                        )
        tests.foreach(test=>
            P63Solution.get.levelFullNodes(test._1) must equal (test._2)
        )
    }
    
    test("P63 Solution treeFullNodes") {
        val tests = List(
                        (1, 1),
                        (2, 3),
                        (3, 7),
                        (4, 15),
                        (5, 31)
                        )
        tests.foreach(test=>
            P63Solution.get.treeFullNodes(test._1) must equal (test._2)
        )
    }
    
    test("P63 Solution isLastLevelFull") {
        val tests = List(
                        (1, true),
                        (2, false),
                        (3, true),
                        (4, false),
                        (5, false),
                        (6, false),
                        (7, true),
                        (8, false),
                        (9, false),
                        (10, false),
                        (11, false),
                        (15, true),
                        (16, false),
                        (17, false)
                        )
        tests.foreach(test=>
            P63Solution.get.isLastLevelFull(test._1) must equal (test._2)
        )
    }

    test("P63 Solution completeBinaryTree") {
        val tests = List(
                        (1, "T(x . .)"),
                        (2, "T(x T(x . .) .)"),
                        (3, "T(x T(x . .) T(x . .))"),
                        (4, "T(x T(x T(x . .) .) T(x . .))"),
                        (5, "T(x T(x T(x . .) T(x . .)) T(x . .))"),
                        (6, "T(x T(x T(x . .) T(x . .)) T(x T(x . .) .))"),
                        (7, "T(x T(x T(x . .) T(x . .)) T(x T(x . .) T(x . .)))")
                        )
        tests.foreach(test=>
            P63Solution.get.completeBinaryTree(test._1, 'x').toString must equal (test._2)
        )
    }
}

