package lzhou.scala.s99problems

class P21Solution {
    def insertAt(n:Int, toInsert: Symbol, list: List[Symbol]): List[Symbol] = {
        def helper(n:Int, toInsert: Symbol, head: List[Symbol], tail: List[Symbol]): List[Symbol] = {
            n match {
                case 0 => head ::: (toInsert::tail)
                case _ => helper(n-1, toInsert, head.init,  head.last:: tail)
            }
        }
        
        n match {
            case x if (x>=list.size) => list ::: List(toInsert)
            case x if (x<=0) => toInsert :: list
            case _ => helper(n, toInsert, list, Nil)
        }
    }
}

object P21Solution {
    def get(): P21Solution = new P21Solution()
}
