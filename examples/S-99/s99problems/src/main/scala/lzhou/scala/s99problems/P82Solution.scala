package lzhou.scala.s99problems

import scala.collection.mutable.MutableList

import graph.Graph
import graph.GraphBase
import graph.Digraph

abstract class P82Solution {
    def graphCycles[T,U](g:GraphBase[T,U], from:T): List[List[T]]
}

class P82SolutionImpl extends P82Solution {
    def graphCycles[T,U](g:GraphBase[T,U], from:T): List[List[T]] = {
        def helper[T,U](g:GraphBase[T,U], seen: Set[T], cur:T, end:T): List[List[T]] = {
            if (seen(cur) && cur==end) {
                List(List(cur))
            } else if (seen(cur)) {
                Nil
            } else {
                val newSeen = seen+cur
                val nexts = g.nodes(cur).adj.flatMap(g.edgeTarget(_, g.nodes(cur))).map(n=>n.value)
                nexts.map(n=>helper(g, newSeen, n, end).map(l=>cur::l)).flatMap(l=>l)
            }
        }
        helper(g, Set(), from, from)
    }
}



object P82Solution {
    def get: P82Solution = new P82SolutionImpl
}
