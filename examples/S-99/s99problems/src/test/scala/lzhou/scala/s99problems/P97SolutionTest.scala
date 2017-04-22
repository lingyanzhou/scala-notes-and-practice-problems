package lzhou.scala.s99problems

import org.scalatest.FunSuite
import org.scalatest.MustMatchers._

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class P97SolutionTest extends FunSuite {
    test("P97 Solution case 1") {
        val board = Array(Array(0,0,4,8,0,0,0,1,7),
                          Array(6,7,0,9,0,0,0,0,0),
                          Array(5,0,8,0,3,0,0,0,4),
                          Array(3,0,0,7,4,0,1,0,0),
                          Array(0,6,9,0,0,0,7,8,0),
                          Array(0,0,1,0,6,9,0,0,5),
                          Array(1,0,0,0,8,0,3,0,6),
                          Array(0,0,0,0,0,6,0,9,1),
                          Array(2,4,0,0,0,1,5,0,0))
        P97Solution.get.sudoku(board).nonEmpty must equal (true)
    }
}

