package lzhou.scala.s99problems

class P08Solution {
    def compress(list: List[Symbol]): List[Symbol] = {
        def helper(list: List[Symbol], compressed: List[Symbol]): List[Symbol] = {
            list match {
                case x::tail =>
                    if (compressed.size>0 && compressed.last==x)
                        helper(tail, compressed)
                    else
                        helper(tail, compressed:::List(x))
                case Nil => compressed
            }
        }

        helper(list, Nil)
    }
}

object P08Solution {
    def get(): P08Solution = new P08Solution()
}
