package lzhou.scala.s99problems

import multiwaytree.MTree

class P73Solution {
    def lispyTree[T](root:MTree[T]):String = {
        root.children match {
            case Nil=>
                root.value.toString
            case _=>
                val c = root.children.map(lispyTree(_)).mkString(" ")
                f"(${root.value} ${c})"
        }
    }

    def delispyTree(s:String):MTree[String] = {
        def parseChildren(s:String, result: List[MTree[String]]):List[MTree[String]] = {
            def nextToken(s:String, nested:Int, result:String):(String, String) = {
                if (s.size==0 ) {
                    require(result.size>0)
                    require(nested==0)
                    (result, s)
                } else if (nested!=0) {
                    s.head match {
                        case '(' => nextToken(s.tail, nested+1, result+s.head)
                        case ')' => nextToken(s.tail, nested-1, result+s.head)
                        case _ => nextToken(s.tail, nested, result+s.head)
                    }
                } else if (result.size==0) {
                    s.head match {
                        case '(' => nextToken(s.tail, nested+1, result+s.head)
                        case ')' => throw new RuntimeException()
                        case ' ' => throw new RuntimeException()
                        case _ => nextToken(s.tail, nested, result+s.head)
                    }
                } else { //nested==0, result!=""
                    s.head match {
                        case '(' => nextToken(s.tail, nested+1, result+s.head)
                        case ')' => throw new RuntimeException()
                        case ' ' => (result, s.tail)
                        case _ => nextToken(s.tail, nested, result+s.head)
                    }
                }
            }
            
            if (s.size==0) {
                result
            } else {
                require(!s.startsWith(" "))
                require(!s.endsWith(" "))
                val (tok, remain) = nextToken(s, 0, "")
                parseChildren(remain, result:+delispyTree(tok))
            }
        }
        
        s match {
            case s1 if s1.startsWith("(")=>
                require(s1.size>4)
                require(s1.endsWith(")"))
                val trimmed = s1.substring(1, s1.size-1)
                require(!trimmed.startsWith("("))
                val firstSpaceIndex = trimmed.indexOf(" ")
                val label = trimmed.substring(0, firstSpaceIndex)
                val childrenString = trimmed.substring(firstSpaceIndex+1)
                MTree(label, parseChildren(childrenString, Nil))
            case _=>
                require(s.size==1)
                require(s!=" ")
                MTree(s)
        }
    }
}

object P73Solution {
    def get: P73Solution = new P73Solution()
}
