package lzhou.scala.s99problems

import org.scalatest.FunSuite
import org.scalatest.MustMatchers._

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import binarytree.Node
import binarytree.End

@RunWith(classOf[JUnitRunner])
class P57SolutionTest extends FunSuite {
    test("P57 Solution") {
        val tests = List(
                        (List(1), "T(1 . .)"),
                        (List(1,2), "T(1 . T(2 . .))"),
                        (List(2,1), "T(2 T(1 . .) .)"),
                        (List(1,3,2), "T(1 . T(3 T(2 . .) .))")
                        )
        tests.foreach(test=>
            P57Solution.get.fromList(test._1).toString must equal (test._2)
        )
    }
}

