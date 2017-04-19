package lzhou.scala.s99problems

import java.util.NoSuchElementException

trait P33Solution extends S99Int{
    override def isCoprimeTo(other:Int): Boolean = {
        P32Solution.get.gcd(this.data, other)==1
    }
}

object P33Solution {
    def of(v:Int): S99Int = {
        //An anonimous class with P33Solution trait
        new P33Solution{val data=v}
    }
}

