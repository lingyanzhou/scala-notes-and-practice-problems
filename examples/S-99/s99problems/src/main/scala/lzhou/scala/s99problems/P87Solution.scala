package lzhou.scala.s99problems

import scala.collection.mutable.MutableList

import graph.Graph
import graph.GraphBase
import graph.Digraph

abstract class P87Solution {
    def nodesByDepthFrom[T <% Ordered[T],U](g: GraphBase[T,U], from: T): List[T]
}

class P87SolutionImpl extends P87Solution {
    def nodesByDepthFrom[T <% Ordered[T],U](g: GraphBase[T,U], from: T): List[T] = {
        def helper(g: GraphBase[T,U], met: Set[T], level: List[T], result: List[T]): List[T] = {
            if (level.size==0) {
                result
            } else {
                val nextLevel = level.flatMap(v=>g.nodes(v).neighbors.map(_.value).filterNot(met(_))).sortWith(_ > _).distinct

                helper(g, met++nextLevel, nextLevel, nextLevel++result)
            }
        }

        helper(g, Set(from), List(from), List(from))
    }
}



object P87Solution {
    def get: P87Solution = new P87SolutionImpl
}
