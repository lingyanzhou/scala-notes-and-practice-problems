package lzhou.scala.s99problems

abstract class P20Solution {
    def removeAt(n:Int, list: List[Symbol]): (List[Symbol], Symbol)
}

class P20Solution1 extends P20Solution {
    def removeAt(n:Int, list: List[Symbol]): (List[Symbol], Symbol) = {
        (list.take(n) ++ list.drop(n+1), list(n))
    }
}

class P20Solution2 extends P20Solution {
    def removeAt(n:Int, list: List[Symbol]): (List[Symbol], Symbol) = {
        def helper(n:Int, list:List[Symbol], removed: Symbol, remained:List[Symbol]): (List[Symbol], Symbol) = {
            if (list.size==0) {
                (remained, removed)
            } else {
                n match {
                    case x if (x>0) => helper(n-1, list.tail, null, remained ::: List(list.head))
                    case x if (x<0) => (remained, removed)
                    case _ => (remained:::list.tail, list.head)
                }
            }
        }
        
        n match {
            case x if (x>=list.size) => throw new IndexOutOfBoundsException(x.toString)
            case x if (x<0) => throw new IndexOutOfBoundsException(x.toString)
            case _ => helper(n, list, null, Nil)
        }
    }
}

object P20Solution {
    def getVersion(n:Int): P20Solution = n match {
        case 1=> new P20Solution1()
        case _=> new P20Solution2()
    }
}
