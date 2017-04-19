package lzhou.scala.s99problems

import binarytree.Tree
import binarytree.Node
import binarytree.End

class P61Solution {
    def leafList[T](root: Tree[T]) :List[T] = {
        root match {
            case n: Node[T] =>
                if (n.left==End && n.right==End) {
                    n.value::Nil
                } else {
                    leafList(n.left)++leafList(n.right)
                }
            case _ => Nil
        }
    }

    def leafCount[T](root: Tree[T]) :Int = {
        root match {
            case n: Node[T] =>
                if (n.left==End && n.right==End) {
                    1
                } else {
                    leafCount(n.left)+leafCount(n.right)
                }
            case _ => 0
        }
    }
}

object P61Solution {
    def get: P61Solution = new P61Solution()
}
