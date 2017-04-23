package lzhou.scala.s99problems

import scala.collection.mutable.MutableList

import graph.Graph
import graph.GraphBase
import graph.Digraph

abstract class P85Solution {
    def isIsomorphic[T,U,T2,U2](g1:Graph[T, U], g2:Graph[T2, U2]): Boolean
}

class P85SolutionImpl extends P85Solution {
    def isIsomorphic[T,U,T2,U2](g1:Graph[T, U], g2:Graph[T2, U2]): Boolean = {
        def helper(g1Nodes:List[g1.Node], g2Nodes:List[g2.Node], map:Map[g1.Node,g2.Node], mapRev:Map[g2.Node,g1.Node]): Boolean = {
            if (g1Nodes.size==0) {
                true
            } else {
                val g1Head = g1Nodes.head
                val pair_g2Nodes = (0 until g2Nodes.size).view.map(i=>((g1Head, g2Nodes(i)), g2Nodes.take(i)++g2Nodes.drop(i+1)))
                val possiblePairs = pair_g2Nodes.filter(p=> {
                    if (p._1._1.neighbors.size==p._1._2.neighbors.size) {
                        val p2neighborSet = p._1._2.neighbors.toSet
                        !(p._1._1.neighbors.filter(map.contains(_)).map(map(_)).exists(!p2neighborSet(_)))
                    } else {
                        false
                    }
                })

                val g1Tail = g1Nodes.tail
                possiblePairs.exists(p=>
                    helper(g1Tail, p._2, map+p._1, mapRev+(p._1._2->p._1._1))
                )
            }
        }
        
        val g1Nodes = g1.nodes.values.toList
        val g2Nodes = g2.nodes.values.toList
        val g1Edges = g1.edges
        val g2Edges = g2.edges
        if (g1Nodes.size==g2Nodes.size && g1Edges.size==g2Edges.size) {
            helper(g1Nodes, g2Nodes, Map(), Map())
        } else {
            false
        }
    }
}



object P85Solution {
    def get: P85Solution = new P85SolutionImpl
}
