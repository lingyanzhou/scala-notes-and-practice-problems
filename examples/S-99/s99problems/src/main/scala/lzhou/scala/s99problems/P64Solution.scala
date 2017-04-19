package lzhou.scala.s99problems

import binarytree.Tree
import binarytree.Node
import binarytree.PositionedNode
import binarytree.End

class P64Solution {
    def layoutBinaryTree[T](root: Tree[T]): Tree[T] = {
        def helper[T](x:Int, y:Int, root:Tree[T]):(Tree[T], Int) = root match {
            case n: Node[T] =>
                val (left, newX) = helper(x, y+1, n.left)
                val (right, finalX) = helper(newX+1, y+1, n.right)
                (PositionedNode(n.value, left, right, newX, y), finalX)
            case _ => (End, x)
        }

        helper(1, 1, root)._1
    }
}

object P64Solution {
    def get: P64Solution = new P64Solution()
}
