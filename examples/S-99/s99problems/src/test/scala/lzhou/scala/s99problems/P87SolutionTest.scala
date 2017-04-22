package lzhou.scala.s99problems

import org.scalatest.FunSuite
import org.scalatest.MustMatchers._

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import graph.Graph
import graph.GraphBase
import graph.Digraph

@RunWith(classOf[JUnitRunner])
class P87SolutionTest extends FunSuite {
    test("P87 Solution nodesByDepthFrom on graph") {
        val tests = List(
                        (Graph.termLabel[String, Int](List("a"), List()), "a", List("a")),
                        (Graph.termLabel[String, Int](List("a", "b"), List(("a","b",1))), "b", List("a", "b")),
                        (Graph.termLabel[String, Int](List("a", "b", "c"), List(("a","b",1))), "c", List("c")),
                        (Graph.termLabel[String, Int](List("a", "b", "c"), List(("a","b",1))), "a", List("b", "a")),
                        (Graph.termLabel[String, Int](List("a", "b", "c", "d"), List(("a","b",5),("a","c",3),("b","d",2),("c","d",4))), "a", List("d", "c", "b", "a")),
                        (Graph.termLabel[String, Int](List("a", "b", "c", "d"), List(("a","b",5),("a","c",3),("b","d",2),("c","d",4))), "d", List("a", "c", "b", "d")),
                        (Graph.termLabel[String, Int](List("a", "b", "c", "d"), List(("d","b",5),("d","c",3),("a","d",2),("c","b",4))), "a", List("c","b","d","a")),
                        (Graph.termLabel[String, Int](List("a", "b", "c", "d"), List(("d","b",5),("d","c",3),("a","d",2),("c","b",4))), "d", List("c","b","a","d")),
                        (Graph.termLabel[String, Int](List("a", "b", "c", "d","e","f","g"), List(("a","b",5),("a","c",3),("b","d",2),("b","e",4),("c","f",2),("c","g",4))),
                            "a", List("g","f","e","d","c","b","a"))
                        )
        tests.foreach(test=> {
            P87Solution.get.nodesByDepthFrom[String, Int](test._1, test._2) must equal (test._3)
        })
    }
    
    test("P87 Solution nodesByDepthFrom on digraph") {
        val tests = List(
                        (Digraph.termLabel[String, Int](List("a"), List()), "a", List("a")),
                        (Digraph.termLabel[String, Int](List("a", "b"), List(("a","b",1))), "a", List("b", "a")),
                        (Digraph.termLabel[String, Int](List("a", "b"), List(("a","b",1))), "b", List("b")),
                        (Digraph.termLabel[String, Int](List("a", "b", "c"), List(("a","b",1))), "c", List("c")),
                        (Digraph.termLabel[String, Int](List("a", "b", "c"), List(("a","b",1))), "a", List("b", "a")),
                        (Digraph.termLabel[String, Int](List("a", "b", "c"), List(("a","b",1))), "b", List("b")),
                        (Digraph.termLabel[String, Int](List("a", "b", "c", "d"), List(("a","b",5),("a","c",3),("b","d",2),("c","d",4))), "a", List("d", "c", "b", "a")),
                        (Digraph.termLabel[String, Int](List("a", "b", "c", "d"), List(("a","b",5),("a","c",3),("b","d",2),("c","d",4))), "d", List("d")),
                        (Digraph.termLabel[String, Int](List("a", "b", "c", "d"), List(("a","b",5),("a","c",3),("b","d",2),("c","d",4))), "c", List("d","c")),
                        (Digraph.termLabel[String, Int](List("a", "b", "c", "d"), List(("a","b",5),("a","c",3),("b","d",2),("c","d",4))), "b", List("d","b")),
                        (Digraph.termLabel[String, Int](List("a", "b", "c", "d"), List(("d","b",5),("d","c",3),("a","d",2),("c","b",4))), "a", List("c","b","d","a")),
                        (Digraph.termLabel[String, Int](List("a", "b", "c", "d"), List(("d","b",5),("d","c",3),("a","d",2),("c","b",4))), "b", List("b")),
                        (Digraph.termLabel[String, Int](List("a", "b", "c", "d"), List(("d","b",5),("d","c",3),("a","d",2),("c","b",4))), "c", List("b","c")),
                        (Digraph.termLabel[String, Int](List("a", "b", "c", "d"), List(("d","b",5),("d","c",3),("a","d",2),("c","b",4))), "d", List("c","b","d"))
                        )
        tests.foreach(test=> {
            P87Solution.get.nodesByDepthFrom[String, Int](test._1, test._2) must equal (test._3)
        })
    }
}


