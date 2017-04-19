package lzhou.scala.s99problems

import java.util.NoSuchElementException

abstract class P01Solution {
    def last[T](list: List[T]): T
}

object P01Solution {
    def getVersion(v:Int): P01Solution = {
        v match {
            case 2 => new P01Solution2();
            case _ => new P01Solution1();
        }
    }
}

private class P01Solution1 extends P01Solution {
    def last[T](list: List[T]): T = {
        return list.last
    }
}

private class P01Solution2 extends P01Solution {
    def last[T](list: List[T]): T = {
        if (list.length==0) {
            throw new NoSuchElementException();
        }
        if (list.length==1) {
            list(0)
        } else {
            last(list.tail)
        }
    }
}
