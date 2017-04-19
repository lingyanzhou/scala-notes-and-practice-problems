package lzhou.scala.s99problems

import java.util.NoSuchElementException

trait P40Solution extends S99Int {
    override def goldbach: (Int, Int) = {
        def helper(iter: Iterator[Int], primeSet: Set[Int], target: Int): (Int, Int) = {
            if (iter.hasNext) {
                val tmp = iter.next
                if (primeSet.contains(target-tmp)) {
                    if (tmp>target-tmp) {
                        (target-tmp, tmp)
                    } else {
                        (tmp, target-tmp)
                    }
                } else {
                    helper(iter, primeSet, target)
                }
            } else {
                null
            }
        }
        if (this.data<=2 || this.data%2==1) {
            null
        } else {
            val primeIndexed = P39Solution.makePrimeList(this.data)
            val primeList = (0 to this.data).zip(primeIndexed).filter(_._2).map(_._1).toList
            val primeSet = Set() ++ primeList
            helper(primeSet.toList.sortWith(_<_).iterator, primeSet, this.data)
        }
    }
}

object P40Solution {
    def of(v:Int): S99Int = {
        //An anonimous class with P40Solution trait
        new P40Solution{val data=v}
    }
}

