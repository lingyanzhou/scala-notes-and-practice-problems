package lzhou.scala.s99problems

class P12Solution {
    def decode(list: List[(Int, Symbol)]): List[Symbol] = {
        
        def helper(list: List[(Int, Symbol)], result: List[Symbol]): List[Symbol] = {
            
            def repeat(n: Int, s:Symbol, result: List[Symbol]): List[Symbol] = {
                n match {
                    case 0 => result
                    case _ => repeat(n-1, s, s::result)
                }
            }
            
            if (list.size==0) {
                result
            } else {
                val last = list.last
                helper(list.init, repeat(last._1, last._2, Nil) ::: result)
            }
        }
        
        helper(list, Nil)
    }
}

object P12Solution {
    def get(): P12Solution = new P12Solution()
}
