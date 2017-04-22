package lzhou.scala.s99problems

import scala.collection.mutable.MutableList

import graph.Graph
import graph.GraphBase
import graph.Digraph

abstract class P80Solution {
    def graphFromString(s:String): Graph[String, Unit]
    def digraphFromString(s:String): Digraph[String, Unit]
    def graphFromStringLabel(s:String): Graph[String, String]
    def digraphFromStringLabel(s:String): Digraph[String, String]
    def graphToTermForm[T, U](graph:GraphBase[T, U]): (List[T], List[(T,T,U)])
    def graphToAdjacentForm[T, U](graph:Graph[T, U]): List[(T, List[(T, U)])]
    def digraphToAdjacentForm[T, U](graph:Digraph[T, U]): List[(T, List[(T, U)])]
}

class P80SolutionImpl extends P80Solution {
    def graphFromString(s:String): Graph[String, Unit] = {
        require(s.startsWith("["))
        require(s.endsWith("]"))
        val links = s.substring(1, s.size-1).split(", ")
        val graph = new Graph[String, Unit]()
        links.foreach(s=> {
            if (s.contains("-")) {
                val nodes = s.split("-")
                require(nodes.size==2)
                graph.addNode(nodes(0))
                graph.addNode(nodes(1))
                graph.addEdge(nodes(0), nodes(1), Unit)
            } else {
                graph.addNode(s)
            }
        })
        return graph
    }
    
    def digraphFromString(s:String): Digraph[String, Unit] = {
        require(s.startsWith("["))
        require(s.endsWith("]"))
        val links = s.substring(1, s.size-1).split(", ")
        val graph = new Digraph[String, Unit]()
        links.foreach(s=> {
            if (s.contains(">")) {
                val nodes = s.split(">")
                require(nodes.size==2)
                graph.addNode(nodes(0))
                graph.addNode(nodes(1))
                graph.addArc(nodes(0), nodes(1), Unit)
            } else {
                graph.addNode(s)
            }
        })
        return graph
    }
    
    def graphFromStringLabel(s:String): Graph[String, String] = {
        require(s.startsWith("["))
        require(s.endsWith("]"))
        val links = s.substring(1, s.size-1).split(", ")
        val graph = new Graph[String, String]()
        links.foreach(s=> {
            if (s.contains("-")) {
                val tokens = s.split("[-/]")
                require(tokens.size==3)
                graph.addNode(tokens(0))
                graph.addNode(tokens(1))
                graph.addEdge(tokens(0), tokens(1), tokens(2))
            } else {
                graph.addNode(s)
            }
        })
        return graph
    }
    
    def digraphFromStringLabel(s:String): Digraph[String, String] = {
        require(s.startsWith("["))
        require(s.endsWith("]"))
        val links = s.substring(1, s.size-1).split(", ")
        val graph = new Digraph[String, String]()
        links.foreach(s=> {
            if (s.contains(">")) {
                val tokens = s.split("[>/]")
                require(tokens.size==3)
                graph.addNode(tokens(0))
                graph.addNode(tokens(1))
                graph.addArc(tokens(0), tokens(1), tokens(2))
            } else {
                graph.addNode(s)
            }
        })
        return graph
    }
    
    def graphToTermForm[T, U](graph:GraphBase[T, U]): (List[T], List[(T,T,U)]) = {
        (graph.nodes.keys.toList, graph.edges.map(_.toTuple))
    }
    
    def graphToAdjacentForm[T, U](graph:Graph[T, U]): List[(T, List[(T, U)])] = {
        graph.nodes.keys.toList.map(s=> (s, graph.nodes(s).adj.map(e=>(if (s==e.n1.value) e.n2.value else e.n1.value, e.value))))
    }
    
    def digraphToAdjacentForm[T, U](graph:Digraph[T, U]): List[(T, List[(T, U)])] = {
        graph.nodes.keys.toList.map(s=> (s, graph.nodes(s).adj.map(e=>(e.n2.value, e.value))))
    }
}



object P80Solution {
    def get: P80Solution = new P80SolutionImpl
}
