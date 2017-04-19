package lzhou.scala.s99problems

abstract class P05Solution {
    def reverse[T](list: List[T]): List[T]
}

object P05Solution {
    def getVersion(v:Int): P05Solution = {
        v match {
            case 2 => new P05Solution2();
            case _ => new P05Solution1();
        }
    }
}

private class P05Solution1 extends P05Solution {
    override def reverse[T](list: List[T]): List[T] = list.reverse
}

private class P05Solution2 extends P05Solution {
    override def reverse[T](list: List[T]): List[T] = {
        def reverseHelper[T](reversed: List[T], toReverse: List[T]): List[T] = {
            if (toReverse.length==0) {
                reversed
            } else {
                reverseHelper(toReverse.head::reversed, toReverse.tail)
            }
        }
        reverseHelper(List(), list)
    }
}
