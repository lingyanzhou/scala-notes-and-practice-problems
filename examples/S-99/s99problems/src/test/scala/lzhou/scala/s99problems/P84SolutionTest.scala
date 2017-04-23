package lzhou.scala.s99problems

import org.scalatest.FunSuite
import org.scalatest.MustMatchers._

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import graph.Graph
import graph.Digraph

@RunWith(classOf[JUnitRunner])
class P84SolutionTest extends FunSuite {
    test("P84 Solution minimalSpanningTree") {
        val tests = List(
                        (Graph.termLabel[String, Int](List("a"), List()),
                            Option(Graph.termLabel[String, Int](List("a"), List()))),
                        (Graph.termLabel[String, Int](List("a", "b"), List(("a","b",1))),
                            Option(Graph.termLabel[String, Int](List("a", "b"), List(("a","b",1))))),
                        (Graph.termLabel[String, Int](List("a", "b", "c"), List(("a","b",1))),
                            Option.empty),
                        (Graph.termLabel[String, Int](List("a", "b", "c"), List(("a","b",3),("a","c",2))),
                            Option(Graph.termLabel[String, Int](List("a", "b", "c"), List(("a","b",3),("a","c",2))))),
                        (Graph.termLabel[String, Int](List("a", "b", "c"), List(("c","b",3),("a","c",2))),
                            Option(Graph.termLabel[String, Int](List("a", "b", "c"), List(("c","b",3),("a","c",2))))),
                        (Graph.termLabel[String, Int](List("a", "b", "c"), List(("a","b",3),("b","c",2))),
                            Option(Graph.termLabel[String, Int](List("a", "b", "c"), List(("a","b",3),("b","c",2))))),
                        (Graph.termLabel[String, Int](List("a", "b", "c"), List(("a","b",2),("b","c",4))),
                            Option(Graph.termLabel[String, Int](List("a", "b", "c"), List(("a","b",2),("b","c",4))))),
                        (Graph.termLabel[String, Int](List("a", "b", "c"), List(("a","b",1),("b","c",2),("a","c",3))),
                            Option(Graph.termLabel[String, Int](List("a", "b", "c"), List(("a","b",1),("b","c",2))))),
                        (Graph.termLabel[String, Int](List("a", "b", "c"), List(("a","b",2),("b","c",3),("a","c",1))),
                            Option(Graph.termLabel[String, Int](List("a", "b", "c"), List(("a","b",2),("a","c",1))))),
                        (Graph.termLabel[String, Int](List("a", "b", "c", "d"), List(("a","b",1),("c","d",3))),
                            Option.empty),
                        (Graph.termLabel[String, Int](List("a", "b", "c", "d"), List(("a","b",5),("a","c",3),("b","d",2),("c","d",4))),
                            Option(Graph.termLabel[String, Int](List("a", "b", "c", "d"), List(("a","c",3),("b","d",2),("c","d",4))))),
                        (Graph.termLabel[String, Int](List("a", "b", "c", "d", "e", "f", "g", "h"),
                                List(("a","b",5),("b","c",2),("a","d",3),("b","e",4),("c","e",6),("d","e",7),("d","f",4),("d","g",3),("f","g",4),("e","h",6),("g","h",1))),
                            Option(Graph.termLabel[String, Int](List("a", "b", "c", "d", "e", "f", "g", "h"),
                                List(("a","d",3),("d","g",3),("g","h",1),("d","f",4),("a","b",5),("b","c",2),("b","e",4)))))
                        )
        tests.foreach(test=> {
            val minimalSpanningTree = P84Solution.get.minimalSpanningTree(test._1)
            minimalSpanningTree must equal (test._2)
        }
        )
    }
}

