package lzhou.scala.s99problems

import scala.util.Random

abstract class P26Solution {
    def combinations(n:Int, list:List[Symbol]): List[List[Symbol]]
}

//Tail recursion only
class P26Solution1 extends P26Solution {
    def combinations(n:Int, list:List[Symbol]): List[List[Symbol]] = {
        def helper(n:Int, list:List[Symbol], indices:List[Int], partial:List[Symbol], result:List[List[Symbol]]): List[List[Symbol]] = {
            // n==1 is trivial. We deal with n>1 in this function.
            require(n>1)
            val newResult = if (partial.size==n) {
                result :+ partial
            } else {
                result
            }

            
            
            if (indices.isEmpty) {
                // Case 1. When onthing is selected, terminate the function
                newResult
            } else if (indices.size==1) {
                // Case 2.  When only one is selected
                if (indices.last+1>=list.size) {
                    // Case 2.1 When only one is selected, and the second one cannot be selected, terminate the function
                    newResult
                } else {
                    // Case 2.2 Select the next one.
                    // Goto Case 3, or 4.
                    helper(n, list,  indices :+ (indices.last+1), partial :+ list(indices.last+1), newResult)
                }
            } else if (indices.size==n) {
                // Case 3.  When all are selected
                if (indices.last+1>=list.size) {
                    // Case 3.1.  The last one cannot be incremented
                    //          Pop the last one.
                    //          Increment the new last one.
                    // Goto case 4
                    val newIndices = indices.init.init :+ (indices.init.last+1)
                    val newPartial = partial.init.init :+ list(newIndices.last)
                    helper(n, list,  newIndices, newPartial, newResult)
                } else {
                    // Case 3.2.  The last one can be incremented
                    //          Increment the last one.
                    // Goto case 4
                    val newIndices = indices.init :+ (indices.last+1)
                    val newPartial = partial.init :+ list(newIndices.last)
                    helper(n, list, newIndices, newPartial, newResult)
                }
            } else {
                // Case 4.  Selected number is betwee 1..n inclusive.
                if (indices.last+1>=list.size) {
                    // Case 4.1 We cannot select the next one
                    //          Pop the last one.
                    //          Increment the new last one.
                    // Goto case 2 or 4
                    val newIndices = indices.init.init :+ (indices.init.last+1)
                    val newPartial = partial.init.init :+ list(newIndices.last)
                    helper(n, list,  newIndices, newPartial, newResult)
                } else {
                    // Case 4.2 We can select the next one
                    // Goto case 3 or 4
                    val newIndices = indices :+ (indices.last+1)
                    val newPartial = partial :+ list(newIndices.last)
                    helper(n, list, newIndices, newPartial, newResult)
                }
            }
        }
        
        require(n<=list.size)
        n match {
            case x if (x<=0) => Nil
            case 1 => list.map(x=>List(x))
            case _ => helper(n, list, (0 until n).toList, (0 until n).toList.map(x=>list(x)), Nil)
        }
    }
}


class P26Solution2 extends P26Solution {
    def combinations(n:Int, list:List[Symbol]): List[List[Symbol]] = {
        def helper(n:Int, toSelect:List[Symbol], selected:List[Symbol]):  List[List[Symbol]] = {
            if (n==0) {
                selected :: Nil
            } else {
                if (toSelect.isEmpty) {
                    Nil
                } else {
                    helper(n-1, toSelect.tail, selected :+ toSelect.head) ++ helper(n, toSelect.tail, selected)
                }
            }
        }

        require(n>0)
        require(n<=list.size)

        helper(n, list, Nil)
    }
}

object P26Solution {
    def getVersion(n:Int): P26Solution = if (n==1) new P26Solution1() else new P26Solution2()
}
