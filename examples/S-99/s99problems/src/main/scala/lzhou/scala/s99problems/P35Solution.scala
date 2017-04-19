package lzhou.scala.s99problems

import java.util.NoSuchElementException

trait P35Solution extends S99Int {
    override def primeFactors : List[Int] = {
        def helper(i:Int, v:Int, result: List[Int]): List[Int] = {
            if (i==v || v==1) {
                v :: result
            } else if (v%i==0) {
                helper(i, v/i, i::result)
            } else {
                helper(i+1, v, result)
            }
        }

        this.data match {
            case x if (x<=1) => Nil
            case _ =>
                helper(2, this.data, Nil).reverse
        }
    }
}

object P35Solution {
    def of(v:Int): S99Int = {
        //An anonimous class with P35Solution trait
        new P35Solution{val data=v}
    }
}

