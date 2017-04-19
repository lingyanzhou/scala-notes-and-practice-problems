package lzhou.scala.s99problems

import binarytree.Tree
import binarytree.Node
import binarytree.End

class P56Solution {
    def isSymmetric(tree: Tree[Any]): Boolean = {
        if (tree==null) {
            true
        } else if (tree==End) {
            true
        } else {
            val left = tree.asInstanceOf[Node[Any]].left
            val right = tree.asInstanceOf[Node[Any]].right
            isMirror(left, right)
        }
    }

    def isMirror(tree1: Tree[Any], tree2: Tree[Any]): Boolean = {
        if (tree1==null || tree2==null) {
            if (tree1==null && tree2==null) {
                true
            } else {
                false
            }
        } else if (tree1==End || tree2==End) {
            if (tree1==End && tree2==End) {
                true
            } else {
                false
            }
        } else {
            val left1 = tree1.asInstanceOf[Node[Any]].left
            val right1 = tree1.asInstanceOf[Node[Any]].right
            val left2 = tree2.asInstanceOf[Node[Any]].left
            val right2 = tree2.asInstanceOf[Node[Any]].right
            isMirror(left1, right2) &&  isMirror(right1, left2)
        }
    }
}

object P56Solution {
    def get: P56Solution = new P56Solution()
}
