package lzhou.scala.s99problems

class P11Solution {
    def encode(list: List[Symbol]): List[Any] = {
        P09Solution.get().pack(list).map(l=>if (l.size>1) (l.size, l.head) else l.head)
    }
}

object P11Solution {
    def get(): P11Solution = new P11Solution()
}
