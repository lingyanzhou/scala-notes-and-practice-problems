package lzhou.scala.s99problems

class P18Solution {
    def slice(s:Int, e:Int, list: List[Symbol]): List[Symbol] = {
        def helper(i:Int, s:Int, e:Int, list: List[Symbol], result: List[Symbol]): List[Symbol] = {
            i match {
                case x if (x>=e) => helper(i-1, s, e, list.init, Nil)
                case x if (x<s) => result
                case _ => helper(i-1, s, e, list.init, list.last :: result)
            }
        }

        helper(list.size-1, s, e, list, Nil)
    }
}

object P18Solution {
    def get(): P18Solution = new P18Solution()
}
