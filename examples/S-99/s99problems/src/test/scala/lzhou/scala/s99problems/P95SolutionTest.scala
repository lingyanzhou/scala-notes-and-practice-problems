package lzhou.scala.s99problems

import org.scalatest.FunSuite
import org.scalatest.MustMatchers._

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class P95SolutionTest extends FunSuite {
    test("P95 Solution") {
        val tests = List((0,"zero"),
                        (1,"one"),
                        (2,"two"),
                        (3,"three"),
                        (4,"four"),
                        (5,"five"),
                        (6,"six"),
                        (7,"seven"),
                        (8,"eight"),
                        (9,"nine"),
                        (14,"one-four"),
                        (17,"one-seven"),
                        (302,"three-zero-two"),
                        (900702,"nine-zero-zero-seven-zero-two"),
                        (900000,"nine-zero-zero-zero-zero-zero"),
                        (123456789,"one-two-three-four-five-six-seven-eight-nine")
                        )
        tests.foreach(test=>
            P95Solution.get().fullwords(test._1) must equal (test._2)
        )
    }
}

