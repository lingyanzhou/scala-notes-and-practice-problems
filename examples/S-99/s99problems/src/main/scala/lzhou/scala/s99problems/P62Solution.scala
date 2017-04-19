package lzhou.scala.s99problems

import binarytree.Tree
import binarytree.Node
import binarytree.End

class P62Solution {
    def internalList[T](root: Tree[T]) :List[T] = {
        root match {
            case n: Node[T] =>
                if (n.left==End && n.right==End) {
                    Nil
                } else {
                    (internalList(n.left):+n.value) ++internalList(n.right)
                }
            case _ => Nil
        }
    }
    
    def atLevel[T](level:Int, root: Tree[T]) :List[T] = {
        level match {
            case 1=>
                root match {
                    case n: Node[T] =>
                        n.value :: Nil
                    case _ => Nil
                }
            case x if x>1 =>
                root match {
                    case n: Node[T] =>
                        atLevel(level-1, n.left) ++ atLevel(level-1, n.right)
                    case _ => Nil
                }
            case _ => Nil
        }
    }
}

object P62Solution {
    def get: P62Solution = new P62Solution()
}
