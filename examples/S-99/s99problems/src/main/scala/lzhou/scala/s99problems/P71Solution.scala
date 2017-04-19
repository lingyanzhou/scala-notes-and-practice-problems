package lzhou.scala.s99problems

import multiwaytree.MTree

class P71Solution {
    def internalPathLength(s:String):Int = {
        def helper(s:String, level:Int, result:Int):Int = level match {
            case 0 => if (s.size>0) {
                    require(result==0)
                    require(s.size>0)
                    require(s.head!='^')
                    helper(s.tail, level+1, result)
                } else {
                    result
                }
            case l if l>0 =>
                require(s.size>0)
                s.head match {
                    case '^' =>
                        helper(s.tail, level-1, result)
                    case _ =>
                        helper(s.tail, level+1, result+level)
                }
            case _ =>
                throw new RuntimeException()
        }

        helper(s, 0, 0)
    }
}

object P71Solution {
    def get: P71Solution = new P71Solution()
}
