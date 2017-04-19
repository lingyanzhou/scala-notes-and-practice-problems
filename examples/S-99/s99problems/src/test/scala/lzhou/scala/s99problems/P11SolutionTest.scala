package lzhou.scala.s99problems

import org.scalatest.FunSuite
import org.scalatest.MustMatchers._

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class P11SolutionTest extends FunSuite {
    test("P11 Solution") {
        val tests = List((List(), List()),
                        (List('a, 'a, 'a), List((3,'a))),
                        (List('a, 'b, 'b, 'c), List('a,(2,'b),'c)),
                        (List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'b), List((2, 'a),(2, 'b), (3, 'c), 'b))
                        )
        tests.foreach(test=>
            P11Solution.get().encode(test._1) must equal (test._2)
        )
    }
}

