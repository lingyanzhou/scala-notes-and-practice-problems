package lzhou.scala.s99problems

import org.scalatest.FunSuite
import org.scalatest.MustMatchers._

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import graph.Graph
import graph.Digraph

@RunWith(classOf[JUnitRunner])
class P82SolutionTest extends FunSuite {
    test("P82 Solution graphCycles non-directed") {
        val tests = List(
                        (Graph.termLabel[String, Unit](List("a"), List()), "a", List()),
                        (Graph.termLabel[String, Unit](List("a", "b"), List(("a","b",Unit))), "a", List(List("a","b","a"))),
                        (Graph.termLabel[String, Unit](List("a", "b", "c"), List(("a","b",Unit), ("b","c",Unit))), "a", List(List("a","b","a"))),
                        (Graph.termLabel[String, Unit](List("a", "b", "c"), List(("a","b",Unit), ("b","c",Unit), ("a","c",Unit))), "c", List(List("c","b", "c"), List("c","a", "c"), List("c","a", "b", "c"), List("c","b", "a", "c"))),
                        (Graph.termLabel[String, Unit](List("a", "b", "c", "d"), List(("a","b",Unit), ("b","c",Unit), ("a","c",Unit))), "a", List(List("a", "b", "a"), List("a", "c", "a"), List("a","c","b","a"), List("a","b","c","a"))),
                        (Graph.termLabel[String, Unit](List("a", "b", "c", "d"), List(("a","b",Unit), ("a","c",Unit), ("a","d",Unit))), "a", List(List("a", "b", "a"), List("a", "c", "a"), List("a", "d", "a"))),
                        (Graph.termLabel[String, Unit](List("a", "b","c","d", "e","f"), List(("a","b",Unit),("a","d",Unit),("b","c",Unit),("c","d",Unit),("c","e",Unit),("e","f",Unit))), "e", List(List("e","c","e"), List("e","f","e"))),
                        (Graph.termLabel[String, Unit](List("a", "b","c","d", "e","f"), List(("a","b",Unit),("a","d",Unit),("b","c",Unit),("c","d",Unit),("c","e",Unit),("e","f",Unit))), "a", List(List("a","b","a"), List("a","d","a"),List("a","b","c","d","a"),List("a","d","c","b","a")))
                        )
        tests.foreach(test=> {
            val paths = P82Solution.get.graphCycles(test._1, test._2)
            (paths diff test._3) must equal (Nil)
        }
        )
    }
    test("P82 Solution graphCycles directed") {
        val tests = List(
                        (Digraph.termLabel[String, Unit](List("a"), List()), "a", List()),
                        (Digraph.termLabel[String, Unit](List("a", "b"), List(("a","b",Unit))), "a", List()),
                        (Digraph.termLabel[String, Unit](List("a", "b"), List(("a","b",Unit),("b","a",Unit))), "a", List(List("a","b","a"))),
                        (Digraph.termLabel[String, Unit](List("a", "b", "c", "d"), List(("a","b",Unit), ("a","c",Unit), ("a","d",Unit))), "a", List()),
                        (Digraph.termLabel[String, Unit](List("a", "b","c","d", "e","f"), List(("a","b",Unit),("a","d",Unit),("b","c",Unit),("c","d",Unit),("c","e",Unit),("e","f",Unit))), "e", List()),
                        (Digraph.termLabel[String, Unit](List("a", "b","c","d", "e","f"), List(("a","b",Unit),("a","d",Unit),("b","c",Unit),("c","d",Unit),("c","e",Unit),("e","f",Unit))), "a", List()),
                        (Digraph.termLabel[String, Unit](List("a", "b","c","d", "e","f"), List(("a","b",Unit),("d","a",Unit),("b","c",Unit),("c","d",Unit),("c","e",Unit),("e","f",Unit),("f","c",Unit))), "c", List(List("c","e","f","c"), List("c","d","a","b","c")))
                        )
        tests.foreach(test=> {
            val paths = P82Solution.get.graphCycles(test._1, test._2)
            (paths diff test._3) must equal (Nil)
        }
        )
    }
}

