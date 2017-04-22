package lzhou.scala.s99problems

import scala.collection.mutable.MutableList

import graph.Graph
import graph.GraphBase
import graph.Digraph

abstract class P88Solution {
    def splitGraph[T,U](g: Graph[T,U]): List[Graph[T,U]]
}

class P88SolutionImpl extends P88Solution {
    def splitGraph[T,U](g: Graph[T,U]): List[Graph[T,U]] = {
        def splitGraphHelper(notSplitted:Set[g.Node], result:List[Graph[T,U]]): List[Graph[T,U]] = {
            def graphFrom(from: g.Node): (Graph[T,U], Set[g.Node]) = {
                def graphFromHelper(metNode: Set[g.Node], metEdge:Set[g.Edge], queue: List[g.Node], result: Graph[T,U]): (Graph[T,U],Set[g.Node]) = {
                    if (queue.size==0) {
                        (result, metNode)
                    } else {
                        val head = queue.head
                        val neighbors = head.neighbors
                        val neighborValues = neighbors.filterNot(metNode(_)).map(_.value)
                        
                        val edges = head.adj.filterNot(metEdge(_))
                        
                        neighborValues.foreach(result.addNode(_))
                        edges.foreach(e=>result.addEdge(e.n1.value, e.n2.value, e.value))
                        println(result)

                        graphFromHelper(metNode++neighbors, metEdge++edges, queue.tail, result)
                    }
                }

                graphFromHelper(Set(from), Set(), List(from), Graph.termLabel[T,U](List(from.value), List()))
            }

            if (notSplitted.size==0) {
                result
            } else {
                val(ng, used) = graphFrom(notSplitted.head)
                val newNotSplitted = notSplitted--used
                splitGraphHelper(newNotSplitted, ng::result)
            }
        }

        splitGraphHelper(Set()++g.nodes.values, Nil)
    }
}



object P88Solution {
    def get: P88Solution = new P88SolutionImpl
}
