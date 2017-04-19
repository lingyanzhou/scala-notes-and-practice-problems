package lzhou.scala.s99problems

class P15Solution {
    def duplicateN(n:Int, list: List[Symbol]): List[Symbol] = {
        def helper(N:Int, n:Int, list: List[Symbol], result: List[Symbol]): List[Symbol] = {
            if (list.size==0) {
                result
            } else if (n==0) {
                helper(N, N, list.init, result)
            } else {
                helper(N, n-1, list, list.last :: result)
            }
        }

        helper(n, n, list, Nil)
    }
}

object P15Solution {
    def get(): P15Solution = new P15Solution()
}
