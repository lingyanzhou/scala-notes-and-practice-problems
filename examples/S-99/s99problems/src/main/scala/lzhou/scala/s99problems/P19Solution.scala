package lzhou.scala.s99problems

class P19Solution {
    def rotate(n:Int, list: List[Symbol]): List[Symbol] = {
        n match {
            case 0 => list
            case x if (x<0) => rotate(list.size-n, list)
            case _ => rotate(n-1, list.tail ::: List(list.head))
        }
    }
}

object P19Solution {
    def get(): P19Solution = new P19Solution()
}
