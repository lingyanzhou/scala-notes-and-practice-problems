package lzhou.scala.s99problems

import java.lang.IndexOutOfBoundsException

abstract class P03Solution {
    def nth[T](n:Int, list: List[T]): T
}

object P03Solution {
    def getVersion(v:Int): P03Solution = {
        v match {
            case 2 => new P03Solution2();
            case _ => new P03Solution1();
        }
    }
}

private class P03Solution1 extends P03Solution {
    override def nth[T](n:Int, list: List[T]): T = list(n)
}

private class P03Solution2 extends P03Solution {
    override def nth[T](n:Int, list: List[T]): T = {
        if (n<0 || n>= list.length) {
            throw new IndexOutOfBoundsException();
        }
        if (n==0) {
            list(0)
        } else {
            nth(n-1, list.tail)
        }
    }
}
