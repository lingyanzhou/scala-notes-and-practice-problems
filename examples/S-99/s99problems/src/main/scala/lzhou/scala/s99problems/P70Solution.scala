package lzhou.scala.s99problems

import multiwaytree.MTree

class P70Solution {
    def nodeCount[T](root: MTree[T]): Int = 1+root.children.map(nodeCount(_)).sum

    def mTree2String[T](root:MTree[T]): String = root.value.toString + root.children.map(t=>mTree2String(t)).mkString("") + "^"

    def string2MTree(s:String) : MTree[String] =  {
        def getChildren(s:String, nested:Int) : List[MTree[String]] = {
            require(s.size>0)
            nested match {
                case 0=> throw new RuntimeException()
                case 1=>
                    s.head match {
                        case '^' => Nil
                        case _ =>  string2MTree(s) :: getChildren(s.tail, nested+1)
                    }
                    
                case _=>
                    require(s.size>0)
                    s.head match {
                        case '^' => getChildren(s.tail, nested-1)
                        case _ => getChildren(s.tail, nested+1)
                    }
                    
            }
        }
        require(s.size!=0)
        val label = s.substring(0,1)
        val children = getChildren(s.tail, 1)
        MTree(label, children)
    }
}

//I don't want to chage mtree.scala. So I write this wrapper class to test implicit conversion.
class P70SolutionMTreeWrapper[T](val mTree: MTree[T]) {
    def nodeCount:Int = P70Solution.get.nodeCount(mTree)
    override def toString:String = P70Solution.get.mTree2String(mTree)
}


object P70Solution {
    def get: P70Solution = new P70Solution()
    implicit def stringToMTree(s:String) = new P70SolutionMTreeWrapper(P70Solution.get.string2MTree(s))
}
