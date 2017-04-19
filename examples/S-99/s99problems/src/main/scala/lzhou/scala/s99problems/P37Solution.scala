package lzhou.scala.s99problems

import java.util.NoSuchElementException

trait P37Solution extends P36Solution {
    override def totient: Int = {
        def helper(pfm :Map[Int, Int], result: Int): Int = {
            if (pfm.isEmpty) {
                result
            } else {
                val headKey = pfm.keysIterator.next
                val headVal = pfm(headKey)
                val tail = pfm - headKey
                helper(tail, result*(headKey-1)*Math.pow(headKey, headVal-1).toInt)
            }
        }
        
        val pfm = this.primeFactorMultipicity
        helper(pfm, 1)
    }
}

object P37Solution {
    def of(v:Int): S99Int = {
        //An anonimous class with P37Solution trait
        new P37Solution{val data=v}
    }
}

