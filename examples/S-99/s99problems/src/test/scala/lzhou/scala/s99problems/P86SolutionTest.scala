package lzhou.scala.s99problems

import org.scalatest.FunSuite
import org.scalatest.MustMatchers._

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import graph.Graph
import graph.GraphBase
import graph.Digraph

@RunWith(classOf[JUnitRunner])
class P86SolutionTest extends FunSuite {
    test("P86 Solution nodeDegree") {
        val tests = List(
                        (Graph.termLabel[String, Int](List("a"), List()),
                            "a", 0),
                        (Graph.termLabel[String, Int](List("a", "b"), List(("a","b",1))),
                            "a", 1),
                        (Graph.termLabel[String, Int](List("a", "b"), List(("a","b",1))),
                            "b", 1),
                        (Graph.termLabel[String, Int](List("a", "b", "c"), List(("a","b",1))),
                            "a", 1),
                        (Graph.termLabel[String, Int](List("a", "b", "c"), List(("a","b",1))),
                            "b", 1),
                        (Graph.termLabel[String, Int](List("a", "b", "c"), List(("a","b",1))),
                            "c", 0),
                        (Graph.termLabel[String, Int](List("a", "b", "c"), List(("a","b",3),("a","c",2))),
                            "a", 2),
                        (Graph.termLabel[String, Int](List("a", "b", "c"), List(("a","b",3),("a","c",2))),
                            "b", 1),
                        (Graph.termLabel[String, Int](List("a", "b", "c"), List(("a","b",3),("a","c",2))),
                            "c", 1),
                        (Graph.termLabel[String, Int](List("a", "b", "c", "d"), List(("a","b",1),("c","d",3))),
                            "a", 1),
                        (Graph.termLabel[String, Int](List("a", "b", "c", "d"), List(("a","b",1),("c","d",3))),
                            "b", 1),
                        (Graph.termLabel[String, Int](List("a", "b", "c", "d"), List(("a","b",1),("c","d",3))),
                            "c", 1),
                        (Graph.termLabel[String, Int](List("a", "b", "c", "d"), List(("a","b",1),("c","d",3))),
                            "d", 1),
                        (Graph.termLabel[String, Int](List("a", "b", "c", "d"), List(("a","b",5),("a","c",3),("b","d",2),("c","d",4))),
                            "a", 2),
                        (Graph.termLabel[String, Int](List("a", "b", "c", "d"), List(("a","b",5),("a","c",3),("b","d",2),("c","d",4))),
                            "b", 2),
                        (Graph.termLabel[String, Int](List("a", "b", "c", "d"), List(("a","b",5),("a","c",3),("b","d",2),("c","d",4))),
                            "c", 2),
                        (Graph.termLabel[String, Int](List("a", "b", "c", "d"), List(("a","b",5),("a","c",3),("b","d",2),("c","d",4))),
                            "d", 2),
                        (Graph.termLabel[String, Int](List("a", "b", "c", "d"), List(("a","b",5),("a","c",3),("a","d",2),("c","b",4))),
                            "a", 3),
                        (Graph.termLabel[String, Int](List("a", "b", "c", "d"), List(("a","b",5),("a","c",3),("a","d",2),("c","b",4))),
                            "b", 2),
                        (Graph.termLabel[String, Int](List("a", "b", "c", "d"), List(("a","b",5),("a","c",3),("a","d",2),("c","b",4))),
                            "c", 2),
                        (Graph.termLabel[String, Int](List("a", "b", "c", "d"), List(("a","b",5),("a","c",3),("a","d",2),("c","b",4))),
                            "d", 1)
                        )
        tests.foreach(test=> {
            P86Solution.get.nodeDegree(test._1.nodes(test._2).asInstanceOf[GraphBase[Any,Any]#Node]) must equal (test._3)
        })
    }
    
    test("P86 Solution graphNodesByDegree") {
        val tests = List(
                        (Graph.termLabel[String, Int](List("a"), List()), List("a")),
                        (Graph.termLabel[String, Int](List("a", "b"), List(("a","b",1))), List("a", "b")),
                        (Graph.termLabel[String, Int](List("a", "b", "c"), List(("a","b",1))), List("a","b","c")),
                        (Graph.termLabel[String, Int](List("a", "b", "c", "d"), List(("a","b",5),("a","c",3),("b","d",2),("c","d",4))), List("a", "b", "c", "d")),
                        (Graph.termLabel[String, Int](List("d", "c", "b", "a"), List(("a","b",5),("a","c",3),("b","d",2),("c","d",4))), List("a", "b", "c", "d")),
                        (Graph.termLabel[String, Int](List("d", "c", "b", "a"), List(("a","b",5),("a","c",3),("a","d",2),("c","b",4))), List("a","b","c","d")),
                        (Graph.termLabel[String, Int](List("a", "b", "c", "d"), List(("d","b",5),("d","c",3),("a","d",2),("c","b",4))), List("d","b","c","a"))
                        )
        tests.foreach(test=> {
            P86Solution.get.graphNodesByDegree[String, Int](test._1) must equal (test._2.map(l=>test._1.nodes(l)))
        })
    }
    
    test("P86 Solution paintNodes") {
        val tests = List(
                        (Graph.termLabel[String, Int](List("a"), List()), List(("a",1))),
                        (Graph.termLabel[String, Int](List("a", "b"), List(("a","b",1))), List(("a",1), ("b",2))),
                        (Graph.termLabel[String, Int](List("a", "b", "c"), List(("a","b",1))), List(("a",1), ("b",2),("c", 1))),
                        (Graph.termLabel[String, Int](List("a", "b", "c", "d"), List(("a","b",5),("a","c",3),("b","d",2),("c","d",4))), List(("a",1),("b",2),("c",2),("d",1))),
                        (Graph.termLabel[String, Int](List("d", "c", "b", "a"), List(("a","b",5),("a","c",3),("b","d",2),("c","d",4))), List(("a",1),("b",2),("c",2),("d",1))),
                        (Graph.termLabel[String, Int](List("d", "c", "b", "a"), List(("a","b",5),("a","c",3),("a","d",2),("c","b",4))), List(("a",1),("b",2),("c",3),("d",2))),
                        (Graph.termLabel[String, Int](List("a", "b", "c", "d"), List(("d","b",5),("d","c",3),("a","d",2),("c","b",4))), List(("d",1),("b",2),("c",3),("a",2)))
                        )
        tests.foreach(test=> {
            P86Solution.get.paintNodes[String, Int](test._1) must equal (test._2.map(l=>(test._1.nodes(l._1), l._2)))
        })
    }
}

