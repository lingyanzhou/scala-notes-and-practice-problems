package lzhou.scala.s99problems

import org.scalatest.FunSuite
import org.scalatest.MustMatchers._

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import graph.Graph
import graph.Digraph

@RunWith(classOf[JUnitRunner])
class P80SolutionTest extends FunSuite {
    test("P80 Solution graphFromString") {
        val tests = List(
                        ("[a]", Graph.termLabel[String, Unit](List("a"), List())),
                        ("[a-b]", Graph.termLabel[String, Unit](List("a", "b"), List(("a","b",Unit)))),
                        ("[a-b, b-c]", Graph.termLabel[String, Unit](List("a", "b", "c"), List(("a","b",Unit), ("b","c",Unit)))),
                        ("[a-b, d, e-f]", Graph.termLabel[String, Unit](List("a", "b","d", "e","f"), List(("a","b",Unit), ("e","f",Unit)))),
                        ("[a-b, d, e, f]", Graph.termLabel[String, Unit](List("a", "b","d", "e","f"), List(("a","b",Unit)))),
                        ("[aa, bb, cc, dd, ee, ff-aaa]", Graph.termLabel[String, Unit](List("aa", "bb","cc","dd", "ee","ff", "aaa"), List(("ff","aaa",Unit))))
                        )
        tests.foreach(test=> {
            val graph = P80Solution.get.graphFromString(test._1)
            graph must equal (test._2)
        }
        )
    }
    
    
    test("P80 Solution digraphFromString") {
        val tests = List(
                        ("[a]", Digraph.termLabel[String, Unit](List("a"), List())),
                        ("[a>b]", Digraph.termLabel[String, Unit](List("a", "b"), List(("a","b",Unit)))),
                        ("[a>b, b>c]", Digraph.termLabel[String, Unit](List("a", "b", "c"), List(("a","b",Unit), ("b","c",Unit)))),
                        ("[a>b, d, e>f]", Digraph.termLabel[String, Unit](List("a", "b","d", "e","f"), List(("a","b",Unit), ("e","f",Unit)))),
                        ("[a>b, d, e, f]", Digraph.termLabel[String, Unit](List("a", "b","d", "e","f"), List(("a","b",Unit)))),
                        ("[aa, bb, cc, dd, ee, ff>aaa]", Digraph.termLabel[String, Unit](List("aa", "bb","cc","dd", "ee","ff", "aaa"), List(("ff","aaa",Unit))))
                        )
        tests.foreach(test=>{
            val graph = P80Solution.get.digraphFromString(test._1)
            graph must equal (test._2)
        }
        )
    }
    
    test("P80 Solution graphFromStringLabel") {
        val tests = List(
                        ("[a]", Graph.termLabel(List("a"), List())),
                        ("[a-b/3]", Graph.termLabel(List("a", "b"), List(("a","b","3")))),
                        ("[a-b/x, b-c/y]", Graph.termLabel(List("a", "b", "c"), List(("a","b","x"), ("b","c","y")))),
                        ("[a-b/1s, d, e-f/2s]", Graph.termLabel(List("a", "b","d", "e","f"), List(("a","b","1s"), ("e","f","2s")))),
                        ("[a-b/abc, d, e, f]", Graph.termLabel(List("a", "b","d", "e","f"), List(("a","b","abc")))),
                        ("[aa, bb, cc, dd, ee, ff-aaa/def]", Graph.termLabel(List("aa", "bb","cc","dd", "ee","ff", "aaa"), List(("ff","aaa","def"))))
                        )
        tests.foreach(test=> {
            val graph = P80Solution.get.graphFromStringLabel(test._1)
            graph must equal (test._2)
        }
        )
    }
    
    
    test("P80 Solution digraphFromStringLabel") {
        val tests = List(
                        ("[a]", Digraph.termLabel(List("a"), List())),
                        ("[a>b/3]", Digraph.termLabel(List("a", "b"), List(("a","b","3")))),
                        ("[a>b/x, b>c/y]", Digraph.termLabel(List("a", "b", "c"), List(("a","b","x"), ("b","c","y")))),
                        ("[a>b/1s, d, e>f/2s]", Digraph.termLabel(List("a", "b","d", "e","f"), List(("a","b","1s"), ("e","f","2s")))),
                        ("[a>b/abc, d, e, f]", Digraph.termLabel(List("a", "b","d", "e","f"), List(("a","b","abc")))),
                        ("[aa, bb, cc, dd, ee, ff>aaa/def]", Digraph.termLabel(List("aa", "bb","cc","dd", "ee","ff", "aaa"), List(("ff","aaa","def"))))
                        )
        tests.foreach(test=>{
            val graph = P80Solution.get.digraphFromStringLabel(test._1)
            graph must equal (test._2)
        }
        )
    }
    
    test("P80 Solution graphToTermForm") {
        val tests = List(
                        (Digraph.termLabel(List("a"), List()), List("a"), List()),
                        (Graph.termLabel(List("a", "b"), List(("a","b","3"))), List("a", "b"), List(("a","b","3"))),
                        (Digraph.termLabel(List("a", "b", "c"), List(("a","b","x"), ("b","c","y"))), List("a", "b", "c"), List(("a","b","x"), ("b","c","y"))),
                        (Graph.termLabel(List("a", "b","d", "e","f"), List(("a","b","1s"), ("e","f","2s"))), List("a", "b","d", "e","f"), List(("a","b","1s"), ("e","f","2s"))),
                        (Digraph.termLabel(List("a", "b","d", "e","f"), List(("a","b","abc"))), List("a", "b","d", "e","f"), List(("a","b","abc"))),
                        (Graph.termLabel(List("aa", "bb","cc","dd", "ee","ff", "aaa"), List(("ff","aaa","def"))), List("aa", "bb","cc","dd", "ee","ff", "aaa"), List(("ff","aaa","def")))
                        )
        tests.foreach(test=>{
            val form = P80Solution.get.graphToTermForm(test._1)
            (form._1 diff test._2) must equal (Nil)
            (form._2 diff test._3) must equal (Nil)
        }
        )
    }
    
    test("P80 Solution graphToAdjacentForm") {
        val form = P80Solution.get.graphToAdjacentForm(Graph.termLabel(List("a", "b", "c", "d", "e", "f"), List(("a","b","3"), ("a","f","4"), ("e","d","2"))))
        val sortedForm = form.map(t=>(t._1, t._2.sortWith(_._1<_._1))).sortWith(_._1<_._1)
        sortedForm must equal (List(("a", List(("b","3"), ("f","4"))), ("b", List(("a","3"))), ("c", List()), ("d", List(("e","2"))), ("e", List(("d","2"))), ("f", List(("a", "4")))))
    }
    
    test("P80 Solution digraphToAdjacentForm") {
        val form = P80Solution.get.digraphToAdjacentForm(Digraph.termLabel(List("a", "b", "c", "d", "e", "f"), List(("a","b","3"), ("a","f","4"), ("e","d","2"))))
        val sortedForm = form.map(t=>(t._1, t._2.sortWith(_._1<_._1))).sortWith(_._1<_._1)
        sortedForm must equal (List(("a", List(("b","3"), ("f","4"))), ("b", List()), ("c", List()), ("d", List()), ("e", List(("d","2"))), ("f", List())))
    }
}

