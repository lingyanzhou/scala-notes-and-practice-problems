package lzhou.scala.s99problems

import binarytree.Tree
import binarytree.Node
import binarytree.End

class P60Solution {
    def minHbalNodes(height: Int): Int = {
        def minHbalNodesDp(i:Int, height:Int, last: Int, secLast: Int): Int = i match {
            case `height` => last
            case _ => minHbalNodesDp(i+1, height, 1+last+secLast, last)
        }
        height match {
            case x if x<=0 => 0
            case _ => minHbalNodesDp(1, height, 1, 0)
        }
    }
    
    def maxHbalNodes(height: Int): Int = Math.pow(2, height).toInt-1
    
    def minHbalHeight(nodes: Int): Int = {
        nodes match {
            case x if x<=0 => 0
            case _ => (Math.log(nodes)/Math.log(2)).toInt+1
        }
    }

    def maxHbalHeight(nodes: Int): Int = {
        def minHbalNodesDp(i:Int, last: Int, secLast: Int): Int = i match {
            case x if nodes>=last => minHbalNodesDp(i+1, 1+last+secLast, last)
            case _ => i-1
        }
        
        minHbalNodesDp(0, 0, 0)
    }

    def hbalTreesWithNodes[T](n:Int, value:T): List[Tree[T]] = {
        def helper(i:Int, end:Int, result:List[Tree[T]]): List[Tree[T]] = i match {
            case x if x==end+1 => result
            case _ => helper(i+1, end, result ++ P59Solution.get.hbalTrees(i, value).filter(t=>nodeCount(t)==n))
        }

        helper(minHbalHeight(n), maxHbalHeight(n), Nil)
    }

    def nodeCount[T](root:Tree[T]): Int = root match {
        case e if root==End => 0
        case n: Node[T] => 1 + nodeCount(n.left) + nodeCount(n.right)
        case _ => 0
    }
}

object P60Solution {
    def get: P60Solution = new P60Solution()
}
