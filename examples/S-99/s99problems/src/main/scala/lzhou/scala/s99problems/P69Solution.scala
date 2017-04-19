package lzhou.scala.s99problems

import binarytree.Tree
import binarytree.Node
import binarytree.PositionedNode
import binarytree.End

class P69Solution {
    def treeToDotstring[T](root: Tree[T]): String = {
        root match {
            case n:Node[T] =>
                n.value.toString+treeToDotstring(n.left)+treeToDotstring(n.right)
            case End=>"."
            case _=>""
        }
    }
    
    def treeFromDotstring(s: String): Tree[String] = {
        def tokens(s:String): (Boolean, (String, String)) =  {
            def token1IsNode(s:String):Boolean= {
                !s.startsWith(".")
            }
            def token23(s:String):(String, String) = {
                def token2Helper(s:String, dots:Int, result:String):(String, String)= {
                    require(s.size>0)
                    if (dots==0) {
                        (result, s )
                    } else {
                        val c = s.head
                        c match {
                            case '.' => token2Helper(s.tail, dots-1, result+c)
                            case _ => token2Helper(s.tail, dots+1, result+c)
                        }
                    }
                }

                token2Helper(s, 1, "")
            }

            val isNode = token1IsNode(s)
            if (isNode) {
                (isNode, token23(s.tail))
            } else {
                (isNode, null)
            }
        }

        require(s.size>0)
        val (isNode, children) = tokens(s)
        if (isNode) {
            Node(s.substring(0,1), treeFromDotstring(children._1), treeFromDotstring(children._2))
        } else {
            End
        }
    }
}

object P69Solution {
    def get: P69Solution = new P69Solution()
}
