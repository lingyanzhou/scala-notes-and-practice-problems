package lzhou.scala.s99problems

import java.util.NoSuchElementException

class P41Solution {
    def printGoldbachListLimited(seq: Seq[Int], limit: Int): List[(Int, (Int, Int))] = {
        def helper(seq: Seq[Int], limit: Int, primeList:List[Int], primeSet: Set[Int], result: List[(Int, (Int, Int))]): List[(Int, (Int, Int))] = {
            def goldbachPair(iter: Iterator[Int], primeSet: Set[Int], limit: Int, target:Int): (Int, Int) = {
                if (!iter.hasNext) {
                    null
                } else {
                    val next = iter.next
                    if (target-next<next) {
                            null
                    } else if (primeSet.contains(target-next)) {
                        if (next<limit) {
                            null
                        } else {
                            (next, target-next)
                        }
                    } else {
                        goldbachPair(iter, primeSet, limit, target)
                    }
                }
            }
            
            if (seq.isEmpty) {
                result
            } else if (seq.head%2==1) {
                helper(seq.tail, limit, primeList, primeSet, result)
            } else {
                val pair = goldbachPair(primeList.iterator, primeSet, limit, seq.head)
                if (pair!=null) {
                    helper(seq.tail, limit, primeList, primeSet, result :+ (seq.head, pair))
                } else {
                    helper(seq.tail, limit, primeList, primeSet, result)
                }
            }
        }
        
        if (seq.last<=2 || seq.last<=limit) {
            null
        } else {
            val primeIndexed = P39Solution.makePrimeList(seq.last)
            val primeList = (0 to seq.last).zip(primeIndexed).filter(_._2).map(_._1).toList
            val primeSet = Set() ++ primeList
            helper(seq, limit, primeList, primeSet, Nil)
        }
        
    }
}

object P41Solution {
    def get: P41Solution = {
        //An anonimous class with P40Solution trait
        new P41Solution
    }
}

