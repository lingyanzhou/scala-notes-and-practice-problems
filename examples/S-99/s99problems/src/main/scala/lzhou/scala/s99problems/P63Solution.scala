package lzhou.scala.s99problems

import binarytree.Tree
import binarytree.Node
import binarytree.End

class P63Solution {
    def completeBinaryTree[T](n:Int, value:T): Tree[T] = {
        if (n==0) {
            End
        } else {
            val treeHeight = cbTreeHeight(n)
            val fullH1ChildNodes = treeFullNodes(treeHeight-1)
            val fullH2ChildNodes = treeFullNodes(treeHeight-2)
            if (n>=fullH1ChildNodes+1+fullH2ChildNodes) {
                Node(value, completeBinaryTree(fullH1ChildNodes, value), completeBinaryTree(n-1-fullH1ChildNodes, value))
            } else {
                Node(value, completeBinaryTree(n-1-fullH2ChildNodes, value), completeBinaryTree(fullH2ChildNodes, value))
            }
        }
    }

    def cbTreeHeight(nodes:Int): Int = nodes match {
        case x if x<=0 => 0
        case _ => (Math.log(nodes)/Math.log(2)).toInt+1
    }

    def lastLevelNodes(nodes:Int):Int =  nodes match {
        case x if x<=0 => 0
        case _ => nodes-(Math.pow(2, cbTreeHeight(nodes)-1).toInt-1)
    }
    
    def treeFullNodes(level:Int):Int =  level match {
        case x if x<=0 => 0
        case _ => levelFullNodes(level)*2-1
    }
    
    def levelFullNodes(level:Int):Int =  level match {
        case x if x<=0 => 0
        case _ => Math.pow(2, level-1).toInt
    }

    def isLastLevelFull(nodes:Int):Boolean =  nodes match {
        case x if x<=0 => false
        case _ => lastLevelNodes(nodes)==Math.pow(2,cbTreeHeight(nodes)-1).toInt
    }
}

object P63Solution {
    def get: P63Solution = new P63Solution()
}
