package lzhou.scala.s99problems

import binarytree.Tree
import binarytree.Node
import binarytree.End
import scala.util.Random

class P59Solution {
    def hbalTrees[T](level:Int, value: T): List[Tree[T]] = {
        def helperDp[T](level:Int, value: T, dp: List[List[Tree[T]]]): List[Tree[T]] = {
            def makePermute(l1: List[Tree[T]], l2: List[Tree[T]], result: List[Tree[T]]): List[Tree[T]] = {
                def iterateL1(l1: List[Tree[T]], t2: Tree[T], result: List[Tree[T]]): List[Tree[T]] = {
                    l1 match {
                        case Nil =>
                            result
                        case head::tail =>
                             iterateL1(tail, t2, result:+Node(value, head, t2))
                    }
                }

                l2 match {
                    case Nil =>
                        result
                    case head::tail =>
                        makePermute(l1, tail, result++iterateL1(l1, head, Nil))
                }
            }
            
            if (dp.size==(level+1)) {
                dp(level)
            } else {
                val newList = makePermute(dp.init.last, dp.last, Nil) ++ makePermute(dp.last, dp.init.last, Nil) ++ makePermute(dp.last, dp.last, Nil)
                helperDp(level, value, dp:+newList)
            }
        }

        val dp = List(List(End), List(Node(value)))
        helperDp(level, value, dp)
    }
}

object P59Solution {
    def get: P59Solution = new P59Solution()
}
