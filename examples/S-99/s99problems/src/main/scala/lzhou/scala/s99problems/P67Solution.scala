package lzhou.scala.s99problems

import binarytree.Tree
import binarytree.Node
import binarytree.PositionedNode
import binarytree.End

class P67Solution {
    def treeToString[T](root: Tree[T]): String = {
        root match {
            case n:Node[T] =>
                if (n.left==End && n.right==End) {
                    n.value.toString
                } else {
                    n.value.toString+"("+treeToString(n.left)+","+treeToString(n.right)+")"
                }
            case _=>""
        }
    }
    
    def treeFromString(s: String): Tree[String] = {
        def tokens(s:String) : (String, String, String) = {
            def getToken1(s:String, result:String): (String, String) = {
                if (s.length==0) {
                    (result, s)
                } else {
                    val cur = s.head
                    cur match {
                        case '(' =>
                            (result, s.tail)
                        case _ =>
                            getToken1(s.tail, result+cur)
                    }
                }
            }
            def getToken2(s:String, level:Int, result:String): (String, String) = {
                if (s.length==0) {
                    (result, s)
                } else {
                    val cur = s.head
                    cur match {
                        case '(' =>
                            getToken2(s.tail, level+1, result+cur)
                        case ')' =>
                            getToken2(s.tail, level-1, result+cur)
                        case ',' =>
                            if (level==0) {
                                (result, s.tail)
                            } else {
                                getToken2(s.tail, level, result+cur)
                            }
                        case _ =>
                            getToken2(s.tail, level, result+cur)
                    }
                }
            }
            def getToken3(s:String, level:Int, result:String): (String, String) = {
                if (s.length==0) {
                    (result, s)
                } else {
                    val cur = s.head
                    cur match {
                        case '(' =>
                            getToken3(s.tail, level+1, result+cur)
                        case ')' =>
                            if (level==0) {
                                (result, s.tail)
                            } else {
                                getToken3(s.tail, level-1, result+cur)
                            }
                        case _ =>
                            getToken3(s.tail, level, result+cur)
                    }
                }
            }
             
            val (t1,s23) = getToken1(s, "")
            val (t2,s3) = getToken2(s23, 0, "")
            val (t3,_) = getToken3(s3, 0, "")
            (t1,t2,t3)
        }
        
        s match {
            case "" => End
            case _ =>
                val (t1, t2, t3) = tokens(s)
                if (t1=="") {
                    End
                } else {
                    Node(t1, treeFromString(t2), treeFromString(t3))
                }
        }
    }
}

object P67Solution {
    def get: P67Solution = new P67Solution()
}
