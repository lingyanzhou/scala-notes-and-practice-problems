package lzhou.scala.s99problems

import scala.collection.mutable.MutableList

import graph.Graph
import graph.GraphBase
import graph.Digraph

abstract class P85Solution {
    def isIsomorphic(g:Graph[Any, Any], g2:Graph[Any, Any]): Boolean
}

class P85SolutionImpl extends P85Solution {
    def isIsomorphic(g:Graph[Any, Any], g2:Graph[Any, Any]): Boolean = {
        //TODO
        false
    }
}



object P85Solution {
    def get: P85Solution = new P85SolutionImpl
}
