package lzhou.scala.s99problems

import scala.collection.mutable.MutableList

abstract class P97Solution {
    def sudoku(board: Array[Array[Int]]): Option[Array[Array[Int]]]
}

/**
 * Generate and test solution 
 */
class P97SolutionImpl extends P97Solution {
    def sudoku(board: Array[Array[Int]]): Option[Array[Array[Int]]] = {
        def helper(board: Array[Array[Int]], i:Int, x:Int, y:Int, rows:Array[Array[Boolean]], cols:Array[Array[Boolean]], blocks:Array[Array[Boolean]]): Boolean = {
            if (x>8) {
                if (y==8) {
                    true
                } else {
                    helper(board, 1, 0, y+1, rows, cols, blocks)
                }
            } else {
                if (board(x)(y)!=0) {
                    helper(board, 1, x+1, y, rows, cols, blocks)
                } else {
                    if (i>9) {
                        false
                    } else {
                        if (rows(x)(i) || cols(y)(i) || blocks((x/3)*3+y/3)(i)) {
                            helper(board, i+1, x, y, rows, cols, blocks)
                        } else {
                            board(x)(y) = i
                            rows(x)(i) = true
                            cols(y)(i) = true
                            blocks((x/3)*3+y/3)(i) = true
                            if (helper(board, 1, x+1, y, rows, cols, blocks)) {
                                true
                            } else {
                                board(x)(y) = 0
                                rows(x)(i) = false
                                cols(y)(i) = false
                                blocks((x/3)*3+y/3)(i) = false
                                helper(board, i+1, x, y, rows, cols, blocks)
                            }
                        }
                    }
                }
            }
        }
        
        val rows=Array.fill(9)(Array.fill(10)(false))
        val cols=Array.fill(9)(Array.fill(10)(false))
        val blocks=Array.fill(9)(Array.fill(10)(false))
        for (i <- 0 to 8; j<- 0 to 8) {
            rows(i)(board(i)(j))=true
            cols(j)(board(i)(j))=true
            blocks((i/3)*3+j/3)(board(i)(j))=true
        }

        if (helper(board, 1, 0, 0, rows, cols, blocks)) {
            Option(board)
        } else {
            Option.empty
        }
    }
}



object P97Solution {
    def get: P97Solution = new P97SolutionImpl
}
