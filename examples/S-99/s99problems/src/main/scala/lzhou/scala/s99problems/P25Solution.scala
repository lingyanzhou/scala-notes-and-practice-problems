package lzhou.scala.s99problems

import scala.util.Random

class P25Solution(private val rng:Random) {
    def randomPermute(list:List[Symbol]): List[Symbol] = {
        def helper(list:List[Symbol], index:Int) : List[Symbol] = {
            index match {
                case 0 => list
                case _ =>
                    val swap = rng.nextInt(index+1)
                    val tmp1 = list(swap)
                    val tmp2 = list(index)
                    val listUpdated = list.updated(swap, tmp2).updated(index, tmp1)
                    helper(listUpdated, index-1)
            }
        }

        helper(list, list.size-1)
    }
}

object P25Solution {
    def get(rng:Random): P25Solution = new P25Solution(rng)
}
