package lzhou.scala.s99problems

class P95Solution {
    def fullwords(num:Int): String = {
        def helper(num:Int, result:String):String = {
            def toFullWord(d:Int): String = d match {
                case 0 => "zero"
                case 1 => "one"
                case 2 => "two"
                case 3 => "three"
                case 4 => "four"
                case 5 => "five"
                case 6 => "six"
                case 7 => "seven"
                case 8 => "eight"
                case 9 => "nine"
                case _ => throw new RuntimeException()
            }
            num match {
                case 0=>result
                case x if x<10 => toFullWord(x)+result
                case _=>helper(num/10, "-"+toFullWord(num%10)+result)
            }
        }
        
        num match {
            case 0=>"zero"
            case _=>helper(num, "")
        }
    }
}

object P95Solution {
    def get(): P95Solution = new P95Solution()
}
