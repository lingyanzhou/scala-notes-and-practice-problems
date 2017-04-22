package lzhou.scala.s99problems

import org.scalatest.FunSuite
import org.scalatest.MustMatchers._

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class P96SolutionTest extends FunSuite {
    test("P96 Solution") {
        val tests = List(
                        ("", false),
                        ("a", true),
                        ("a ", false),
                        ("*", false),
                        (" a", false),
                        ("1", false),
                        ("1a", false),
                        ("a1", true),
                        ("a-1", true),
                        ("a-a", true),
                        ("a1-1", true),
                        ("a2-a1", true),
                        ("aa3-1-s-a-2-1-sas-sad-123-123-asd", true),
                        ("a1--a", false)
                        )
        tests.foreach(test=>
            P96Solution.get().isIdentifier(test._1) must equal (test._2)
        )
    }
}

