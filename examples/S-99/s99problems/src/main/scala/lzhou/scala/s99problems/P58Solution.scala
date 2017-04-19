package lzhou.scala.s99problems

import binarytree.Tree
import binarytree.Node
import binarytree.End
import scala.util.Random

class P58Solution {
    def symmetricBalancedTrees(n: Int, mark:String): List[Tree[String]] = {
        P55Solution.get.cBalanced(n, mark).filter(P56Solution.get.isSymmetric(_))
    }
}

object P58Solution {
    def get: P58Solution = new P58Solution()
}
