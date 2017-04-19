package lzhou.scala.s99problems

class P17Solution {
    def split(n:Int, list: List[Symbol]): (List[Symbol],List[Symbol]) = {
        def helper(n:Int, list1: List[Symbol], list2: List[Symbol]): (List[Symbol],List[Symbol]) = {
            n match {
                case x if (x<=0) => (list1, list2)
                case _=>
                    list1 match {
                        case Nil=> (list1, list2)
                        case _ => helper(n-1, list1.init, list1.last::list2)
                    }
            }
        }

        helper(list.size-n, list, Nil)
    }
}

object P17Solution {
    def get(): P17Solution = new P17Solution()
}
