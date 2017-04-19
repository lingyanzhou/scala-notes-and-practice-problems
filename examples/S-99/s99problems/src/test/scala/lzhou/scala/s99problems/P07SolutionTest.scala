package lzhou.scala.s99problems

import org.scalatest.FunSuite
import org.scalatest.MustMatchers._

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class P07SolutionTest extends FunSuite {
    test("P07 Solution") {
        val tests = List((List(), List()),
                        (List(1,2,3), List(1,2,3)),
                        (List(List(1),2,3), List(1,2,3)),
                        (List(1,List(2),3), List(1,2,3)),
                        (List(1,List(2,3)), List(1,2,3)),
                        (List(List(1,2,3)), List(1,2,3)),
                        (List(1,List(2,List(3))), List(1,2,3)),
                        (List(List(List(List(List(1),List(2)),3))), List(1,2,3))
                        )
        tests.foreach(test=>
            P07Solution.get().flatten(test._1) must equal (test._2)
        )
    }
}

