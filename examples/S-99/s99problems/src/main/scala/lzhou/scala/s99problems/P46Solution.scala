package lzhou.scala.s99problems

class P46Solution {
    def and(a: Boolean, b: Boolean) : Boolean = a && b
    def or(a: Boolean, b: Boolean) : Boolean = a || b
    def nand(a: Boolean, b: Boolean) : Boolean = !and(a,b)
    def nor(a: Boolean, b: Boolean) : Boolean = !or(a,b)
    def xor(a: Boolean, b: Boolean) : Boolean = (a && !b) || (!a && b)
    def impl(a: Boolean, b: Boolean) : Boolean = !a || b
    def equ(a: Boolean, b: Boolean) : Boolean = (a && b) || (!a && !b)
}

object P46Solution {
    def get(): P46Solution = new P46Solution()
}
