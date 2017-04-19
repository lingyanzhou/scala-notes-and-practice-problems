package lzhou.scala.s99problems

class P13Solution extends P10Solution {
    override def encode(list: List[Symbol]): List[(Int, Symbol)] = {
        def helper(list: List[Symbol], prev: Symbol, count: Int, result:List[(Int, Symbol)]): List[(Int, Symbol)] = {
            if (list.size==0) {
                if (count==0) {
                    result
                } else {
                    (count, prev):: result
                }
            } else {
                if (list.last==prev) {
                    helper(list.init, list.last, count+1, result)
                } else if (count==0) {
                    helper(list.init, list.last, 1, result)
                } else {
                    helper(list.init, list.last, 1, (count, prev)::result)
                }
            }
        }
        helper(list, null, 0, Nil)
    }
}

object P13Solution {
    def get(): P13Solution = new P13Solution()
}
