package lzhou.scala.s99problems

import scala.util.Random

class P23Solution {
    def randomSelect(s:Int, list:List[Symbol]): List[Symbol] = {
        val r = new Random(1)
        def helper(i:Int, list:List[Symbol], result: List[Symbol]): List[Symbol] = {
            i match {
                case 0 => result
                case _ => helper(i-1, list, list(r.nextInt(list.size))::result)
            }
        }
        assert(s>=0)
        helper(s, list, Nil)
    }
}

object P23Solution {
    def get(): P23Solution = new P23Solution()
}
