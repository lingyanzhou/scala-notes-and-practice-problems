package lzhou.scala.s99problems

import binarytree.Tree
import binarytree.Node
import binarytree.End

class P57Solution {
    def addValue[T <% Ordered[T]](tree: Tree[T], newVal:T): Tree[T] = {
        if (tree==null || tree==End) {
            Node(newVal)
        } else {
            val node = tree.asInstanceOf[Node[T]]
            require(node.value!=newVal)
            if (node.value<newVal) {
                new Node[T](node.value, node.left, addValue(node.right, newVal))
            } else {
                new Node[T](node.value, addValue(node.left, newVal), node.right )
            }
        }
    }

    def fromList[T <% Ordered[T]](list:List[T]): Tree[T] = {
        def helperTraverseList(list:List[T], tree: Tree[T]): Tree[T] = {
            list match {
                case Nil=> tree
                case head::tail => helperTraverseList(tail, addValue(tree, head))
            }
        }
        helperTraverseList(list, End)
    }
}

object P57Solution {
    def get: P57Solution = new P57Solution()
}
