package binarytree {

  sealed abstract class Tree[+T]

  case class Node[+T](value: T, left: Tree[T], right: Tree[T]) extends Tree[T] {
    override def toString = "T(" + value.toString + " " + left.toString + " " + right.toString + ")"
  }

  case object End extends Tree[Nothing] {
    override def toString = "."
  }

  case class PositionedNode[+T](value: T, left: Tree[T], right: Tree[T], x: Int, y: Int) extends Tree[T] {
    override def toString = "T[" + x.toString + "," + y.toString + "](" + value.toString + " " + left.toString + " " + right.toString + ")"
  }

  object Node {
    def apply[T](value: T): Node[T] = Node(value, End, End)
  }

  object PositionedNode {
    def apply[T](value: T, x:Int, y: Int): PositionedNode[T] = PositionedNode(value, End, End, x, y)
  }
  
}

 
