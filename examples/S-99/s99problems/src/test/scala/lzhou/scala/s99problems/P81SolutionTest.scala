package lzhou.scala.s99problems

import org.scalatest.FunSuite
import org.scalatest.MustMatchers._

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import graph.Graph
import graph.Digraph

@RunWith(classOf[JUnitRunner])
class P81SolutionTest extends FunSuite {
    test("P81 Solution graphFindPaths non-directed") {
        val tests = List(
                        (Graph.termLabel[String, Unit](List("a"), List()), "a", "a", List(List("a"))),
                        (Graph.termLabel[String, Unit](List("a", "b"), List(("a","b",Unit))), "a", "b", List(List("a","b"))),
                        (Graph.termLabel[String, Unit](List("a", "b", "c"), List(("a","b",Unit), ("b","c",Unit))), "a", "c", List(List("a", "b", "c"))),
                        (Graph.termLabel[String, Unit](List("a", "b", "c", "d"), List(("a","b",Unit), ("b","c",Unit), ("a","c",Unit))), "a", "c", List(List("a", "b", "c"), List("a","c"))),
                        (Graph.termLabel[String, Unit](List("a", "b", "c", "d"), List(("a","b",Unit), ("a","c",Unit), ("a","d",Unit))), "a", "b", List(List("a", "b"))),
                        (Graph.termLabel[String, Unit](List("a", "b","c","d", "e","f"), List(("a","b",Unit),("a","d",Unit),("b","c",Unit),("c","d",Unit),("c","e",Unit),("e","f",Unit))), "e", "d", List(List("e","c","d"), List("e","c","b","a","d")))
                        )
        tests.foreach(test=> {
            val paths = P81Solution.get.graphFindPaths(test._1, test._2, test._3)
            (paths diff test._4) must equal (Nil)
        }
        )
    }
    test("P81 Solution graphFindPaths directed") {
        val tests = List(
                        (Digraph.termLabel[String, Unit](List("a"), List()), "a", "a", List(List("a"))),
                        (Digraph.termLabel[String, Unit](List("a", "b"), List(("a","b",Unit))), "a", "b", List(List("a","b"))),
                        (Digraph.termLabel[String, Unit](List("a", "b"), List(("a","b",Unit))), "b", "a", List()),
                        (Digraph.termLabel[String, Unit](List("a", "b", "c"), List(("a","b",Unit), ("b","c",Unit))), "a", "c", List(List("a","b","c"))),
                        (Digraph.termLabel[String, Unit](List("a", "b", "c"), List(("a","b",Unit), ("b","c",Unit), ("a","c",Unit))), "a", "c", List(List("a","b","c"),List("a","c"))),
                        (Digraph.termLabel[String, Unit](List("a", "b", "c", "d"), List(("a","b",Unit), ("b","c",Unit), ("a","c",Unit))), "b", "c", List(List("b","c"))),
                        (Digraph.termLabel[String, Unit](List("a", "b", "c", "d"), List(("a","b",Unit), ("a","c",Unit), ("a","d",Unit))), "a", "b", List(List("a", "b"))),
                        (Digraph.termLabel[String, Unit](List("a", "b", "c", "d"), List(("a","b",Unit), ("a","c",Unit), ("a","d",Unit))), "c", "b", List()),
                        (Digraph.termLabel[String, Unit](List("a", "b","c","d", "e","f"), List(("a","b",Unit),("a","d",Unit),("b","c",Unit),("c","d",Unit),("c","e",Unit),("e","f",Unit))), "e", "d", List()),
                        (Digraph.termLabel[String, Unit](List("a", "b","c","d", "e","f"), List(("a","b",Unit),("a","d",Unit),("b","c",Unit),("c","d",Unit),("c","e",Unit),("e","f",Unit))), "b", "e", List(List("b","c","e"))),
                        (Digraph.termLabel[String, Unit](List("a", "b","c","d", "e","f"), List(("a","b",Unit),("a","d",Unit),("b","c",Unit),("c","d",Unit),("c","e",Unit),("e","f",Unit))), "a", "e", List(List("a","b","c","e")))
                        )
        tests.foreach(test=> {
            val paths = P81Solution.get.graphFindPaths(test._1, test._2, test._3)
            (paths diff test._4) must equal (Nil)
        }
        )
    }
}

