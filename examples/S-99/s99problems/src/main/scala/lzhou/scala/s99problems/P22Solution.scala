package lzhou.scala.s99problems

class P22Solution {
    def range(s:Int, e:Int): List[Int] = {
        def helper(i:Int, s:Int, result: List[Int]): List[Int] = {
            i match {
                case x if (x==s-1) => result
                case _ => helper(i-1, s, i::result)
            }
        }
        require(s<=e)
        helper(e, s, Nil)
    }
}

object P22Solution {
    def get(): P22Solution = new P22Solution()
}
