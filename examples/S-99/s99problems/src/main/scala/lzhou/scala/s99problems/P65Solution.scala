package lzhou.scala.s99problems

import binarytree.Tree
import binarytree.Node
import binarytree.PositionedNode
import binarytree.End

class P65Solution {
    def layoutBinaryTree2[T](root: Tree[T]): Tree[T] = {
        def depth(root:Tree[Any]): Int = root match {
            case n: Node[Any] =>
                Math.max(depth(n.left), depth(n.right))+1
            case _ => 0
        }
        def helper[T](x:Int, y:Int, height:Int, root:Tree[T]):(Tree[T], Int) = root match {
            case n: Node[T] =>
                val spaceHalf = Math.pow(2, height-y-1).toInt
                val (left, leftAdjust) = helper(x-spaceHalf, y+1, height, n.left)
                val adjestedX = Math.max(1, leftAdjust+x).toInt
                val (right, _) = helper(adjestedX+spaceHalf, y+1, height, n.right)
                val produceAdject = Math.max(1-x, leftAdjust).toInt
                (PositionedNode(n.value, left, right, adjestedX, y), produceAdject)
            case _ =>
                val spaceHalf = Math.pow(2, height-y).toInt
                (End, 0)
        }

        helper(1, 1, depth(root), root)._1
    }
}

object P65Solution {
    def get: P65Solution = new P65Solution()
}
