package lzhou.scala.s99problems

import org.scalatest.FunSuite
import org.scalatest.MustMatchers._

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import graph.Graph
import graph.GraphBase
import graph.Digraph

@RunWith(classOf[JUnitRunner])
class P89SolutionTest extends FunSuite {
    test("P89 Solution isBipartile on graph") {
        //Expected result's list order is important
        val tests = List(
                        (Graph.termLabel[String, Int](List("a"), List()),
                            true),
                        (Graph.termLabel[String, Int](List("a", "b"), List(("a","b",1))),
                            true),
                        (Graph.termLabel[String, Int](List("a", "b"), List()),
                            true),
                        (Graph.termLabel[String, Int](List("a", "b", "c"), List(("a","b",1),("a","c",1),("b","c",1))),
                            false),
                        (Graph.termLabel[String, Int](List("a", "b", "c"), List(("a","b",1),("a","c",1))),
                            true),
                        (Graph.termLabel[String, Int](List("a", "b", "c"), List(("a","b",1))),
                            true),
                        (Graph.termLabel[String, Int](List("a", "b", "c"), List()),
                            true),
                        (Graph.termLabel[String, Int](List("a", "b", "c","d"), List(("a","b",1),("a","c",1),("a","d",1))),
                            true),
                        (Graph.termLabel[String, Int](List("a", "b", "c","d"), List(("a","b",1),("a","c",1),("a","d",1),("b","c",1))),
                            false),
                        (Graph.termLabel[String, Int](List("a", "b", "c","d"), List(("a","b",1),("b","c",1),("c","d",1),("a","d",1))),
                            true)
                        )
        tests.foreach(test=> {
            withClue(f"isBipartile(${test._1})=${test._2}: ") {
                val actual = P89Solution.get.isBipartile[String, Int](test._1)
                actual must equal (test._2)
            }
        })
    }
    test("P89 Solution isBipartile on digraph") {
        //Expected result's list order is important
        val tests = List(
                        (Digraph.termLabel[String, Int](List("a"), List()),
                            true),
                        (Digraph.termLabel[String, Int](List("a", "b"), List(("a","b",1))),
                            true),
                        (Digraph.termLabel[String, Int](List("a", "b"), List()),
                            true),
                        (Digraph.termLabel[String, Int](List("a", "b", "c"), List(("a","b",1),("a","c",1),("b","c",1))),
                            false),
                        (Digraph.termLabel[String, Int](List("a", "b", "c"), List(("a","b",1),("a","c",1))),
                            true),
                        (Digraph.termLabel[String, Int](List("a", "b", "c"), List(("a","b",1))),
                            true),
                        (Digraph.termLabel[String, Int](List("a", "b", "c"), List()),
                            true),
                        (Digraph.termLabel[String, Int](List("a", "b", "c","d"), List(("a","b",1),("a","c",1),("a","d",1))),
                            true),
                        (Digraph.termLabel[String, Int](List("a", "b", "c","d"), List(("a","b",1),("a","c",1),("a","d",1),("b","c",1))),
                            false),
                        (Digraph.termLabel[String, Int](List("a", "b", "c","d"), List(("a","b",1),("b","c",1),("c","d",1),("a","d",1))),
                            true)
                        )
        tests.foreach(test=> {
            withClue(f"isBipartile(${test._1})=${test._2}: ") {
                val actual = P89Solution.get.isBipartile[String, Int](test._1)
                actual must equal (test._2)
            }
        })
    }
}


