package lzhou.scala.s99problems

import java.util.NoSuchElementException

trait P34Solution extends P33Solution {
    override def totient: Int = {
        def helper(i:Int, result: Int): Int = {
            if (i==this.data) {
                result
            } else if (this.isCoprimeTo(i)) {
                helper(i+1, result+1)
            } else {
                helper(i+1, result)
            }
        }

        this.data match {
            case x if (x<1) => 0
            case 1 => 1
            case _ =>
                helper(2, 1)
        }
    }
}

object P34Solution {
    def of(v:Int): S99Int = {
        //An anonimous class with P34Solution trait
        new P34Solution{val data=v}
    }
}

