package lzhou.scala.s99problems


class P49Solution {
    def gray(n:Int) : List[String] = {
        require(n>0)
        
        def toNextLevel(l: List[String]): List[String] = {
            val reversed = l.reverse
            val p1 = l.map("0"+_)
            val p2 = reversed.map("1"+_)
            return p1 ::: p2
        }
        
        n match {
            case 1 => List("0","1")
            case _ =>
                val l = gray(n-1)
                toNextLevel(l)
        }
    }
}

object P49Solution {
    def get(): P49Solution = new P49Solution()
}
