package lzhou.scala.s99problems

import scala.collection.mutable.MutableList

import graph.Graph
import graph.GraphBase
import graph.Digraph

abstract class P81Solution {
    def graphFindPaths[T,U](g:GraphBase[T,U], from:T, to:T): List[List[T]]
}

class P81SolutionImpl extends P81Solution {
    def graphFindPaths[T,U](g:GraphBase[T,U], from:T, to:T): List[List[T]] = {
        def helper[T,U](g:GraphBase[T,U], seen: Set[T], cur:T, to:T): List[List[T]] = {
            if (seen(cur)) {
                Nil
            } else if (cur==to) {
                List(List(cur))
            } else {
                val newSeen = seen+cur
                val nexts = g.nodes(cur).adj.flatMap(g.edgeTarget(_, g.nodes(cur))).map(n=>n.value)
                //println(nexts)
                nexts.map(n=>helper(g, newSeen, n, to).map(l=>cur::l)).flatMap(l=>l)
            }
        }
        helper(g, Set(), from, to)
    }
}



object P81Solution {
    def get: P81Solution = new P81SolutionImpl
}
