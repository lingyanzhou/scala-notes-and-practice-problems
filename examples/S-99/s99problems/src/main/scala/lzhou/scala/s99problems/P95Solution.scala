package lzhou.scala.s99problems

class P09Solution {
    def pack(list: List[Symbol]): List[List[Symbol]] = {
        def helper(original: List[Symbol], same: List[Symbol], packed: List[List[Symbol]]): List[List[Symbol]] = {
            if (original.size==0) {
                if (same.size==0) {
                    packed
                } else {
                    same :: packed
                }
            } else {
                val last = original.last
                val init = original.init
                if (same.size==0 || same.head==last) {
                    helper(init, last::same, packed)
                } else {
                    helper(init, List(last), same :: packed)
                }
            }
        }

        helper(list, Nil, Nil)
    }
}

object P09Solution {
    def get(): P09Solution = new P09Solution()
}
