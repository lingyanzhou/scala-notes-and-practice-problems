package lzhou.scala.s99problems

import java.util.NoSuchElementException

class P32Solution {
    def gcd(a: Int, b: Int): Int = {
        a match {
            case 0 => b
            case _ => gcd(b%a, a)
        }
    }
}

object P32Solution {
    def get: P32Solution = {
        new P32Solution
    }
}

