package lzhou.scala.s99problems

import org.scalatest.FunSuite
import org.scalatest.MustMatchers._

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class P27SolutionTest extends FunSuite {
    test("P27 Solution 1-group grouping") {
        val tests = List(
                        (List(1), List("a"), List(List(List("a")))),
                        (List(2), List("a", "b", "c"), List(List(List("a","b")),List(List("a","c")),List(List("b","c")))),
                        (List(3), List("a","b","c","d"), List(List(List("a","b","c")),List(List("a","b","d")),List(List("a","c","d")),List(List("b","c","d"))))
                        )
        tests.foreach(test=>
            P27Solution.get.group(test._1, test._2) must equal (test._3)
        )
    }
    
    test("P27 Solution 2-group grouping") {
        val tests = List(
                        (List(1,1), List("a","b"), List(List(List("a"),List("b")),List(List("b"),List("a")))),
                        (List(2,1), List("a","b","c"), List(List(List("a","b"),List("c")),
                                                                List(List("a","c"),List("b")),
                                                                List(List("b","c"),List("a")))),
                        (List(1,2), List("a","b","c"), List(List(List("a"),List("b","c")),
                                                                List(List("b"),List("a","c")),
                                                                List(List("c"),List("a","b"))))
                        )
        tests.foreach(test=>
            P27Solution.get.group(test._1, test._2) must equal (test._3)
        )
    }
}

