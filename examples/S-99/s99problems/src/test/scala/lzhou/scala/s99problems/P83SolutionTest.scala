package lzhou.scala.s99problems

import org.scalatest.FunSuite
import org.scalatest.MustMatchers._

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import graph.Graph
import graph.Digraph

@RunWith(classOf[JUnitRunner])
class P83SolutionTest extends FunSuite {
    test("P83 Solution allSpanningTree") {
        val tests = List(
                        (Graph.termLabel[String, Unit](List("a"), List()), 1),
                        (Graph.termLabel[String, Unit](List("a", "b"), List(("a","b",Unit))), 1),
                        (Graph.termLabel[String, Unit](List("a", "b", "c"), List(("a","b",Unit))), 0),
                        (Graph.termLabel[String, Unit](List("a", "b", "c"), List(("a","b",Unit),("a","c",Unit))), 1),
                        (Graph.termLabel[String, Unit](List("a", "b", "c"), List(("a","b",Unit),("b","c",Unit))), 1),
                        (Graph.termLabel[String, Unit](List("a", "b", "c"), List(("a","b",Unit),("b","c",Unit),("a","c",Unit))), 3),
                        (Graph.termLabel[String, Unit](List("a", "b", "c", "d"), List(("a","b",Unit),("c","d",Unit))), 0),
                        (Graph.termLabel[String, Unit](List("a", "b", "c", "d"), List(("a","b",Unit),("a","c",Unit),("a","d",Unit))), 1),
                        (Graph.termLabel[String, Unit](List("a", "b", "c", "d"), List(("a","b",Unit),("a","c",Unit),("c","d",Unit))), 1),
                        (Graph.termLabel[String, Unit](List("a", "b", "c", "d"), List(("a","b",Unit),("a","c",Unit),("b","c",Unit),("c","d",Unit))), 3),
                        (Graph.termLabel[String, Unit](List("a", "b", "c", "d"), List(("a","b",Unit),("a","c",Unit),("b","c",Unit),("a","d",Unit))), 3),
                        (Graph.termLabel[String, Unit](List("a", "b", "c", "d"), List(("a","b",Unit),("a","c",Unit),("b","d",Unit),("c","d",Unit))), 4)
                        )
        tests.foreach(test=> {
            val spanningTrees = P83Solution.get.allSpanningTree(test._1)
            spanningTrees.size must equal (test._2)
        }
        )
    }
    test("P83 Solution isTree") {
        val tests = List(
                        (Graph.termLabel[String, Unit](List("a"), List()), true),
                        (Graph.termLabel[String, Unit](List("a", "b"), List(("a","b",Unit))), true),
                        (Graph.termLabel[String, Unit](List("a", "b", "c"), List(("a","b",Unit))), false),
                        (Graph.termLabel[String, Unit](List("a", "b", "c"), List(("a","b",Unit),("a","c",Unit))), true),
                        (Graph.termLabel[String, Unit](List("a", "b", "c"), List(("a","b",Unit),("b","c",Unit))), true),
                        (Graph.termLabel[String, Unit](List("a", "b", "c"), List(("a","b",Unit),("b","c",Unit),("a","c",Unit))), false),
                        (Graph.termLabel[String, Unit](List("a", "b", "c", "d"), List(("a","b",Unit),("c","d",Unit))), false),
                        (Graph.termLabel[String, Unit](List("a", "b", "c", "d"), List(("a","b",Unit),("a","c",Unit),("a","d",Unit))), true),
                        (Graph.termLabel[String, Unit](List("a", "b", "c", "d"), List(("a","b",Unit),("a","c",Unit),("c","d",Unit))), true),
                        (Graph.termLabel[String, Unit](List("a", "b", "c", "d"), List(("a","b",Unit),("a","c",Unit),("b","c",Unit),("c","d",Unit))), false),
                        (Graph.termLabel[String, Unit](List("a", "b", "c", "d"), List(("a","b",Unit),("a","c",Unit),("b","c",Unit),("a","d",Unit))), false),
                        (Graph.termLabel[String, Unit](List("a", "b", "c", "d"), List(("a","b",Unit),("a","c",Unit),("b","d",Unit),("c","d",Unit))), false)
                        )
        tests.foreach(test=> {
            P83Solution.get.isTree(test._1) must equal (test._2)
        }
        )
    }
    test("P83 Solution isConnected") {
        val tests = List(
                        (Graph.termLabel[String, Unit](List("a"), List()), true),
                        (Graph.termLabel[String, Unit](List("a", "b"), List(("a","b",Unit))), true),
                        (Graph.termLabel[String, Unit](List("a", "b", "c"), List(("a","b",Unit))), false),
                        (Graph.termLabel[String, Unit](List("a", "b", "c"), List(("a","b",Unit),("a","c",Unit))), true),
                        (Graph.termLabel[String, Unit](List("a", "b", "c"), List(("a","b",Unit),("b","c",Unit))), true),
                        (Graph.termLabel[String, Unit](List("a", "b", "c"), List(("a","b",Unit),("b","c",Unit),("a","c",Unit))), true),
                        (Graph.termLabel[String, Unit](List("a", "b", "c", "d"), List(("a","b",Unit),("c","d",Unit))), false),
                        (Graph.termLabel[String, Unit](List("a", "b", "c", "d"), List(("a","b",Unit),("a","c",Unit),("a","d",Unit))), true),
                        (Graph.termLabel[String, Unit](List("a", "b", "c", "d"), List(("a","b",Unit),("a","c",Unit),("c","d",Unit))), true),
                        (Graph.termLabel[String, Unit](List("a", "b", "c", "d"), List(("a","b",Unit),("a","c",Unit),("b","c",Unit),("c","d",Unit))), true),
                        (Graph.termLabel[String, Unit](List("a", "b", "c", "d"), List(("a","b",Unit),("a","c",Unit),("b","c",Unit),("a","d",Unit))), true),
                        (Graph.termLabel[String, Unit](List("a", "b", "c", "d"), List(("a","b",Unit),("a","c",Unit),("b","d",Unit),("c","d",Unit))), true)
                        )
        tests.foreach(test=> {
            P83Solution.get.isConnected(test._1) must equal (test._2)
        }
        )
    }
}

