package lzhou.scala.s99problems

import scala.collection.mutable.MutableList

import graph.Graph
import graph.GraphBase
import graph.Digraph

abstract class P86Solution {
    def nodeDegree[T,U](node: GraphBase[T,U]#Node): Int
    def graphNodesByDegree[T <% Ordered[T],U](graph: GraphBase[T,U]): List[GraphBase[T,U]#Node]
    def paintNodes[T <% Ordered[T],U](graph: GraphBase[T,U]): List[(GraphBase[T,U]#Node, Int)]
}

class P86SolutionImpl extends P86Solution {
    def nodeDegree[T,U](node: GraphBase[T,U]#Node): Int = {
        node.neighbors.distinct.size
    }
    
    def graphNodesByDegree[T <% Ordered[T],U](graph: GraphBase[T,U]): List[GraphBase[T,U]#Node] = {
        graph.nodes.values.toList.sortWith((a,b)=>{
            val degA = nodeDegree(a)
            val degB = nodeDegree(b)
            if (degA==degB) {
                a.value<b.value
            } else {
                degA>degB
            }
        })
    }
    
    def paintNodes[T <% Ordered[T],U](graph: GraphBase[T,U]): List[(GraphBase[T,U]#Node, Int)] = {
        def helper(color:Int, graph: GraphBase[T,U], colored:Map[GraphBase[T,U]#Node, Int], newlyColored:Set[GraphBase[T,U]#Node], notColored: List[GraphBase[T,U]#Node], skipped: List[GraphBase[T,U]#Node]): Map[GraphBase[T,U]#Node, Int] = {
            if (notColored.size==0) {
                if (skipped.size==0) {
                    assert(colored.size==graph.nodes.size)
                    colored
                } else {
                    helper(color+1, graph, colored, Set(), skipped, Nil)
                }
            } else {
                val head = notColored.head
                val neighbors = head.neighbors
                if (neighbors.size==0) {
                    helper(color, graph, colored+(head->color), newlyColored+head, notColored.tail, skipped)
                } else {
                    val hasAdjColored = neighbors.map(n=> newlyColored.contains(n)).reduceLeft(_ || _)
                    if (hasAdjColored) {
                        helper(color, graph, colored, newlyColored, notColored.tail, skipped:+head)
                    } else {
                        helper(color, graph, colored+(head->color), newlyColored+head, notColored.tail, skipped)
                    }
                }
            }
        }
        
        val orderedNodes = graphNodesByDegree(graph)
        val map = helper(1, graph, Map(), Set(), orderedNodes, Nil)
        
        require(map.size==orderedNodes.size)
        
        orderedNodes.map(n=>(n, map(n)))
    }
}



object P86Solution {
    def get: P86Solution = new P86SolutionImpl
}
