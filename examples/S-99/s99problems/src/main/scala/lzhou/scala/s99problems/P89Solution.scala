package lzhou.scala.s99problems

import scala.collection.mutable.MutableList

import graph.Graph
import graph.GraphBase
import graph.Digraph

abstract class P89Solution {
    def isBipartile[T,U](g: GraphBase[T,U]): Boolean
}

class P89SolutionImpl extends P89Solution {
    def isBipartile[T,U](g: GraphBase[T,U]): Boolean = {
        def helper(notColored:Set[g.Node], thisColor:Set[g.Node], oppositeColor:Set[g.Node], thisLevel: List[g.Node]): Boolean = {
            if (notColored.size == 0) {
                //The last check is important
                val allNextLevel = thisLevel.flatMap(n=>n.neighbors).distinct
                if (allNextLevel.find(thisColor(_)).nonEmpty) {
                    false
                } else {
                    true
                }
            } else if (thisLevel.size == 0) {
                helper(notColored.tail, Set(notColored.head), Set(), List(notColored.head))
            } else {
                val allNextLevel = thisLevel.flatMap(n=>n.neighbors).distinct
                if (allNextLevel.find(thisColor(_)).nonEmpty) {
                    false
                } else {
                    val nextLevelNew = allNextLevel.filter(notColored(_))
                    helper(notColored--nextLevelNew, oppositeColor++nextLevelNew, thisColor, nextLevelNew)
                }
            }
        }
    
        val notColored = Set()++g.nodes.values
        helper(notColored.tail, Set(notColored.head), Set(), List(notColored.head))
    }
}



object P89Solution {
    def get: P89Solution = new P89SolutionImpl
}
