package lzhou.scala.s99problems

import java.util.NoSuchElementException

trait P36Solution extends S99Int {
    override def primeFactorMultipicity : Map[Int, Int] = {
        def helper(i:Int, v:Int, result: Map[Int, Int]):  Map[Int, Int] = {
            def perfectDevide(v:Int, i:Int, times:Int): (Int, Int) = {
                if (v%i==0) {
                    perfectDevide(v/i, i, times+1)
                } else {
                    (v, times)
                }
            }
            
            if (v==1) {
                result
            } else if (v%i==0) {
                val tmp = perfectDevide(v, i, 0)
                helper(i+1, tmp._1, result+((i, tmp._2)))
            } else {
                helper(i+1, v, result)
            }
        }

        this.data match {
            case x if (x<=1) => Map()
            case _ =>
                helper(2, this.data, Map())
        }
    }
}

object P36Solution {
    def of(v:Int): S99Int = {
        //An anonimous class with P36Solution trait
        new P36Solution{val data=v}
    }
}

