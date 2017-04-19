package lzhou.scala.s99problems

import java.util.NoSuchElementException

class P39Solution {
    def listPrimesinRange(s: Int, e: Int): List[Int] = {
        if (e<2) {
            Nil
        }
        val l = P39Solution.makePrimeList(e)
        (0 to e).zip(l).filter(_._1>=s).filter(_._2).map(_._1).toList
    }
}

object P39Solution {
    def get: P39Solution = {
        new P39Solution
    }

    def makePrimeList(e:Int): List[Boolean] = {
        def helper(i:Int, result: List[Boolean]): List[Boolean] = {
            def unsetEver(inc:Int, i:Int, result: List[Boolean]): List[Boolean] = {
                if (i>=result.size) {
                    result
                } else {
                    unsetEver(inc, i+inc, result.updated(i, false))
                }
            }
            
            i match {
                case x if (x<2) => helper(2, result)
                case x if (x==result.size) => result
                case _ =>
                    result(i) match {
                        case true =>
                            helper(i+1, unsetEver(i, i*2, result))
                        case _ => helper(i+1, result)
                    }
            }
        }
        
        require(e>0)
        val result = List.fill(e+1)(true).updated(0,false).updated(1,false)
        
        helper(2, result)
    }
}
