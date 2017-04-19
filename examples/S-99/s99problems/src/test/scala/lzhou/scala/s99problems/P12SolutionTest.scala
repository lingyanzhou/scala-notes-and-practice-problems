package lzhou.scala.s99problems

import org.scalatest.FunSuite
import org.scalatest.MustMatchers._

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class P12SolutionTest extends FunSuite {
    test("P12 Solution") {
        val tests = List((List(), List()),
                        (List((3,'a)), List('a, 'a, 'a)),
                        (List((1,'a),(2,'b),(1,'c)), List('a, 'b, 'b, 'c)),
                        (List((2, 'a),(2, 'b), (3, 'c), (1,'b)), List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'b))
                        )
        tests.foreach(test=>
            P12Solution.get().decode(test._1) must equal (test._2)
        )
    }
}

