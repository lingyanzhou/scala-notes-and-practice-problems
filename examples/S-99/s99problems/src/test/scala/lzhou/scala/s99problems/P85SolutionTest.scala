package lzhou.scala.s99problems

import org.scalatest.FunSuite
import org.scalatest.MustMatchers._

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import graph.Graph
import graph.Digraph

@RunWith(classOf[JUnitRunner])
class P85SolutionTest extends FunSuite {
    test("P85 Solution isIsomorphic") {
        val tests = List(
                        (Graph.termLabel[String, Int](List("a"), List()),
                            Graph.termLabel[String, Int](List("b"), List()),
                            true),
                        (Graph.termLabel[String, Int](List("a"), List()),
                            Graph.termLabel[String, Int](List("b", "c"), List()),
                            false),
                        (Graph.termLabel[String, Int](List("a", "b"), List(("a","b",1))),
                            Graph.termLabel[String, Int](List("b", "c"), List(("b","c",3))),
                            true),
                        (Graph.termLabel[String, Int](List("a", "b"), List()),
                            Graph.termLabel[String, Int](List("b", "c"), List(("b","c",3))),
                            false),
                        (Graph.termLabel[String, Int](List("a", "b"), List(("a","b",1))),
                            Graph.termLabel[String, Int](List("b", "c"), List()),
                            false),
                        (Graph.termLabel[String, Int](List("a", "b", "c"), List()),
                            Graph.termLabel[String, Int](List("b", "c"), List()),
                            false),
                        (Graph.termLabel[String, Int](List("a", "b", "c"), List()),
                            Graph.termLabel[String, Int](List("b", "c", "d"), List()),
                            true),
                        (Graph.termLabel[String, Int](List("a", "b", "c"), List(("a","b",1))),
                            Graph.termLabel[String, Int](List("b", "c", "d"), List(("b","c",2))),
                            true),
                        (Graph.termLabel[String, Int](List("a", "b", "c"), List(("a","b",1))),
                            Graph.termLabel[String, Int](List("b", "c", "d"), List(("d","c",2))),
                            true),
                        (Graph.termLabel[String, Int](List("a", "b", "c"), List(("a","b",1),("a","c",1))),
                            Graph.termLabel[String, Int](List("b", "c", "d"), List(("d","c",2))),
                            false),
                        (Graph.termLabel[String, Int](List("a", "b", "c"), List(("a","b",1),("a","c",1))),
                            Graph.termLabel[String, Int](List("b", "c", "d"), List(("d","c",2),("b","c",1))),
                            true),
                        (Graph.termLabel[String, Int](List("a", "b", "c"), List(("a","b",1),("a","c",1))),
                            Graph.termLabel[String, Int](List("b", "c", "d"), List(("b","c",1))),
                            false),
                        (Graph.termLabel[String, Int](List("a", "b", "c", "d"), List(("a","b",1),("a","c",1),("b","c",1),("d","c",1),("a","d",1),("d","b",1))),
                            Graph.termLabel[String, Int](List("a", "b", "c", "d"), List(("a","b",2),("a","c",2),("a","d",2),("b","c",2),("d","c",2),("b","d",2))),
                            true),
                        (Graph.termLabel[String, Int](List("a", "b", "c", "d"), List(("a","b",1),("a","c",1),("b","c",1),("d","c",1),("d","b",1))),
                            Graph.termLabel[String, Int](List("a", "b", "c", "d"), List(("a","b",2),("a","c",2),("a","d",2),("b","c",2),("d","c",2))),
                            true),
                        (Graph.termLabel[String, Int](List("a","b","c","d","e","f","g","h","i","j"), List(("a","b",1),("a","c",1),("a","d",1),("b","e",1),("c","f",1),("c","g",1),("d","h",1),("d","i",1),("d","j",1))),
                            Graph.termLabel[String, Int](List("a","b","c","d","e","f","g","h","i","j"), List(("j","b",1),("j","c",1),("j","d",1),("b","e",1),("c","f",1),("c","g",1),("d","h",1),("d","i",1),("d","a",1))),
                            true)
                        )
        tests.foreach(test=> {
            withClue(test._1.toString+" "+test._2.toString+": ") {
                val actual = P85Solution.get.isIsomorphic(test._1, test._2)
                actual must equal (test._3)
            }
        }
        )
    }
}

