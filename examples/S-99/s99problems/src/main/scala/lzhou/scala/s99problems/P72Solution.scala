package lzhou.scala.s99problems

import multiwaytree.MTree

class P72Solution {
    def postorder(s:String): List[Char] = {
        def helper(s:String, stack: List[Char], result:List[Char]):List[Char] = stack match {
            case head::tail =>
                require(s.size>0)
                s.head match {
                    case '^' =>
                        helper(s.tail, stack.init, result:+stack.last)
                    case _ =>
                        helper(s.tail, stack:+s.head, result)
                }
            case Nil => if (s.size>0) {
                    require(result.size==0)
                    require(s.size>0)
                    require(s.head!='^')
                    helper(s.tail, stack:+s.head, result)
                } else {
                    result
                }
        }

        helper(s, Nil, Nil)
    }
}

object P72Solution {
    def get: P72Solution = new P72Solution()
}
