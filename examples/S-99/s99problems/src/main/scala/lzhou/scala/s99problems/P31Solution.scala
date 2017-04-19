package lzhou.scala.s99problems

import java.util.NoSuchElementException

trait P31Solution extends S99Int{
    override def isPrime: Boolean = {
        def helper(i:Int, sqrt:Double, v: Int): Boolean = {
           
            if (i>sqrt) {
                true
            } else if (v%i==0) {
                false
            } else {
                helper(i+1, sqrt, v)
            }
        }

        this.data match {
            case x if (x<2) => false
            case _ =>
                val sqrt = Math.sqrt(this.data)
                helper(2, sqrt, this.data)
        }
    }
}

object P31Solution {
    def of(v:Int): S99Int = {
        //An anonimous class with P31Solution trait
        new P31Solution{val data=v}
    }
}

