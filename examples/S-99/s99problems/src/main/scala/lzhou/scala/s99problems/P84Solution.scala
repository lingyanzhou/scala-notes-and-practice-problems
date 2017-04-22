package lzhou.scala.s99problems

import scala.collection.mutable.MutableList

import graph.Graph
import graph.GraphBase
import graph.Digraph

abstract class P84Solution {
    def minimalSpanningTree[T,U <% Ordered[U]](g:Graph[T,U]): Option[Graph[T,U]]
}

class P84SolutionImpl extends P84Solution {
    def minimalSpanningTree[T,U <% Ordered[U]](g:Graph[T,U]): Option[Graph[T,U]] = {
        def helper(edges:List[g.Edge], nodeSet:Set[g.Node], treeNodes:List[T], treeEdges:List[(T,T,U)]): Option[Graph[T,U]] = {
            if (nodeSet.size==0) {
                Option(Graph.termLabel[T,U](treeNodes, treeEdges))
            } else if (edges.size==0) {
                Option.empty
            } else {
                val noredundant = edges.filter(e=>nodeSet(e.n1)||nodeSet(e.n2))
                val candidate1 = noredundant.filter(e=>nodeSet(e.n1) && !(nodeSet(e.n2))).reduceLeftOption((l, r) => if (l.value<r.value) l else r)
                val candidate2 = noredundant.filter(e=>nodeSet(e.n2) && !(nodeSet(e.n1))).reduceLeftOption((l, r) => if (l.value<r.value) l else r)
                if (candidate1.nonEmpty && candidate2.nonEmpty) {
                    if (candidate1.get.value<candidate2.get.value) {
                        val candidate = candidate1.get
                        val toRemove = List(candidate)
                        helper(noredundant.diff(toRemove), nodeSet-candidate.n1, treeNodes:+candidate.n1.value, treeEdges:+(candidate.toTuple))
                    } else {
                        val candidate = candidate2.get
                        val toRemove = List(candidate)
                        helper(noredundant.diff(toRemove), nodeSet-candidate.n2, treeNodes:+candidate.n2.value, treeEdges:+(candidate.toTuple))
                    }
                } else if (candidate1.nonEmpty) {
                    val candidate = candidate1.get
                    val toRemove = List(candidate)
                    helper(noredundant.diff(toRemove), nodeSet-candidate.n1, treeNodes:+candidate.n1.value, treeEdges:+(candidate.toTuple))
                } else if (candidate2.nonEmpty) {
                    val candidate = candidate2.get
                    val toRemove = List(candidate)
                    helper(noredundant.diff(toRemove), nodeSet-candidate.n2, treeNodes:+candidate.n2.value, treeEdges:+(candidate.toTuple))
                } else {
                    Option.empty
                }
            }
        }
        
        val nodeSet = Set() ++ g.nodes.values
        val edges = g.edges
        helper(edges, nodeSet.tail, nodeSet.head.value::List[T](), List[(T,T,U)]())
    }
}



object P84Solution {
    def get: P84Solution = new P84SolutionImpl
}
