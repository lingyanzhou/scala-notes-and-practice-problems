package lzhou.scala.s99problems

import org.scalatest.FunSuite
import org.scalatest.MustMatchers._

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class P13SolutionTest extends FunSuite {
    test("P13 Solution") {
        val tests = List((List(), List()),
                        (List('a, 'a, 'a), List((3,'a))),
                        (List('a, 'b, 'b, 'c), List((1,'a),(2,'b),(1,'c))),
                        (List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'b), List((2, 'a),(2, 'b), (3, 'c), (1,'b)))
                        )
        tests.foreach(test=>
            P13Solution.get().encode(test._1) must equal (test._2)
        )
    }
}

