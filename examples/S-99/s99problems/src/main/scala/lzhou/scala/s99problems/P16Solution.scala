package lzhou.scala.s99problems

class P16Solution {
    def drop(n:Int, list: List[Symbol]): List[Symbol] = {
        def helper(N:Int, n:Int, list: List[Symbol], result: List[Symbol]): List[Symbol] = {
            if (list.size==0) {
                result
            } else if (n==0) {
                helper(N, N-1, list.init, result)
            } else {
                helper(N, n-1, list.init, list.last :: result)
            }
        }

        helper(n, list.size%n, list, Nil)
    }
}

object P16Solution {
    def get(): P16Solution = new P16Solution()
}
