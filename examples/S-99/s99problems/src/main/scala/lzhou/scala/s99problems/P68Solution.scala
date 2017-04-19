package lzhou.scala.s99problems

import binarytree.Tree
import binarytree.Node
import binarytree.PositionedNode
import binarytree.End

class P68Solution {
    def preorder[T](root: Tree[T]): List[T] = {
        root match {
            case n:Node[T] =>
                (n.value :: preorder(n.left)) ++ preorder(n.right)
            case End => Nil
            case _=> Nil
        }
    }
    
    def inorder[T](root: Tree[T]): List[T] = {
        root match {
            case n:Node[T] =>
                inorder(n.left) ++ (n.value :: inorder(n.right))
            case End => Nil
            case _=> Nil
        }
    }
    
    def preInTree[T](preorder: List[T], inorder: List[T]): Tree[T] = {
        require(preorder.size==inorder.size)

        if (preorder.size==0) {
            End
        } else {
            val rootValue = preorder.head
            val splitIndex = inorder.indexOf(rootValue)
            val inorderLeft = inorder.take(splitIndex)
            val inorderRight = inorder.drop(splitIndex+1)
            val preorderLeft = preorder.take(splitIndex+1).drop(1)
            val preorderRight = preorder.drop(splitIndex+1)
            Node(rootValue, preInTree(preorderLeft, inorderLeft), preInTree(preorderRight, inorderRight))
        }
    }
}

object P68Solution {
    def get: P68Solution = new P68Solution()
}
