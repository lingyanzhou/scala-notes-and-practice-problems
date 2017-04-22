package lzhou.scala.s99problems

import scala.collection.mutable.MutableList

import graph.Graph
import graph.GraphBase
import graph.Digraph

abstract class P83Solution {
    def allSpanningTree[T,U](g:Graph[T,U]): List[Graph[T,U]]
    def isTree[T,U](g:Graph[T,U]): Boolean
    def isConnected[T,U](g:Graph[T,U]): Boolean
}

class P83SolutionImpl extends P83Solution {
    def allSpanningTree[T,U](g:Graph[T,U]): List[Graph[T,U]] = {
        def helper(edges:List[g.Edge], nodeSet:Set[g.Node], treeNodes:List[T], treeEdges:List[(T,T,U)]): List[Graph[T,U]] = {
            if (nodeSet.size==0) {
                Graph.termLabel[T,U](treeNodes, treeEdges) :: List[Graph[T,U]]()
            } else if (edges.size==0) {
                List[Graph[T,U]]()
            } else {
                val noredundant = edges.filter(e=>nodeSet(e.n1)||nodeSet(e.n2))
                val candidates1 = noredundant.filter(e=>nodeSet(e.n1) && !(nodeSet(e.n2)))
                val candidates2 = noredundant.filter(e=>nodeSet(e.n2) && !(nodeSet(e.n1)))

                var prevCandidates = List[g.Edge]()
                val result1 = candidates1.flatMap(c=>{
                    prevCandidates = prevCandidates:+c
                    helper(noredundant.diff(prevCandidates), nodeSet-c.n1, treeNodes:+c.n1.value, treeEdges:+(c.toTuple))
                })
                val result2 = candidates2.flatMap(c=>{
                    prevCandidates = prevCandidates:+c
                    helper(noredundant.diff(prevCandidates), nodeSet-c.n2, treeNodes:+c.n2.value, treeEdges:+(c.toTuple))
                })
                result1++result2
            }
        }
        
        val nodeSet = Set() ++ g.nodes.values
        val edges = g.edges
        helper(edges, nodeSet.tail, nodeSet.head.value::List[T](), List[(T,T,U)]())
    }

    def isTree[T,U](g:Graph[T,U]): Boolean = allSpanningTree(g).size==1

    def isConnected[T,U](g:Graph[T,U]): Boolean = allSpanningTree(g).size>=1
}



object P83Solution {
    def get: P83Solution = new P83SolutionImpl
}
