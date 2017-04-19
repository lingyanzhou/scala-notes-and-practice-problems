package lzhou.scala.s99problems

import binarytree.Tree
import binarytree.Node
import binarytree.End
import scala.util.Random

class P55Solution {
    def cBalanced(n: Int, mark:String): List[Tree[String]] = {
        if (n==0) {
            End :: Nil
        } else if (n%2==0) {
            val half1 = n/2
            val half2 = n-half1-1
            val c1 = cBalanced(half1, mark)
            val c2 = cBalanced(half2, mark)
            val tmp = c1.map(n=> c2.map(m=> new Node(mark, n, m))).reduceRight((l,r)=>l++r)
            tmp ++ c2.map(n=> c1.map(m=> new Node(mark, n, m))).reduceRight((l,r)=>l++r)
        } else {
            val half = n/2
            val child = cBalanced(half, mark)
            child.map(n=> child.map(m=> new Node(mark, n, m))).reduceRight((l,r)=>l++r)
        }
    }
}

object P55Solution {
    def get: P55Solution = new P55Solution()
}
