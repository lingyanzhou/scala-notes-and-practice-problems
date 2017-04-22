package lzhou.scala.s99problems

import org.scalatest.FunSuite
import org.scalatest.MustMatchers._

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import graph.Graph
import graph.GraphBase
import graph.Digraph

@RunWith(classOf[JUnitRunner])
class P88SolutionTest extends FunSuite {
    test("P88 Solution splitGraph") {
        //Expected result's list order is important
        val tests = List(
                        (Graph.termLabel[String, Int](List("a"), List()),
                            List(Graph.termLabel[String, Int](List("a"), List()))),
                        (Graph.termLabel[String, Int](List("a", "b"), List(("a","b",1))),
                            List(Graph.termLabel[String, Int](List("a", "b"), List(("a","b",1))))),
                        (Graph.termLabel[String, Int](List("a", "b"), List()),
                            List(Graph.termLabel[String, Int](List("a"), List()),
                                Graph.termLabel[String, Int](List("b"), List()))),
                        (Graph.termLabel[String, Int](List("a", "b", "c"), List(("a","b",1))),
                            List(Graph.termLabel[String, Int](List("a", "b", "c"), List(("a","b",1))),
                                Graph.termLabel[String, Int](List("c"), List()))),
                        (Graph.termLabel[String, Int](List("a", "b", "c"), List()),
                            List(Graph.termLabel[String, Int](List("a"), List()),
                                Graph.termLabel[String, Int](List("b"), List()),
                                Graph.termLabel[String, Int](List("c"), List())))
                        )
        tests.foreach(test=> {
            val actual = P88Solution.get.splitGraph[String, Int](test._1)

            actual must equal (test._2)
        })
    }
}


