package lzhou.scala.s99problems

abstract class P06Solution {
    def isPalindrome[T](list: List[T]): Boolean
}

object P06Solution {
    def get(): P06Solution = new P06Solution1()
}


private class P06Solution1 extends P06Solution {
    override def isPalindrome[T](list: List[T]): Boolean = {
        list match {
            case l if (l.size>=2) => list.last==list.head && isPalindrome(list.tail.init)
            case x::Nil => true
            case Nil => true
            case _ => false
        }
    }
}
