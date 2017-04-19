package lzhou.scala.s99problems

class P10Solution {
    def encode(list: List[Symbol]): List[(Int, Symbol)] = {
        P09Solution.get().pack(list).map(l=>(l.size, l.head))
    }
}

object P10Solution {
    def get(): P10Solution = new P10Solution()
}
