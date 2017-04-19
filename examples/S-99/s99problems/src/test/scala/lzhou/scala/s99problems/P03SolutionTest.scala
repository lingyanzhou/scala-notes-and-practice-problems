package lzhou.scala.s99problems

import org.scalatest.FunSuite
import org.scalatest.MustMatchers._
import java.lang.IndexOutOfBoundsException

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class P03SolutionTest extends FunSuite {
    test("P03 Solution v1 oob") {
        val tests = List((List(), -1),
                                        (List(1), -1),
                                        (List(1,2), -1),
                                        (List(1,2),2),
                                        (List(1,2,3), 3),
                                        (List(1,2,3), 5))
        tests.foreach(test=>
            intercept[IndexOutOfBoundsException] {
                P03Solution.getVersion(1).nth(test._2, test._1)
            }
        )
    }
    
    test("P03 Solution v2 oob") {
        val tests = List((List(), -1),
                                        (List(1), -1),
                                        (List(1,2), -1),
                                        (List(1,2),2),
                                        (List(1,2,3), 3),
                                        (List(1,2,3), 5))
        tests.foreach(test=>
            intercept[IndexOutOfBoundsException] {
                P03Solution.getVersion(2).nth(test._2, test._1)
            }
        )
    }
    
    test("P03 Solution v1 inrange") {
        val tests = List((List(1), 0, 1),
                        (List(1,2), 0, 1),
                        (List(1,2), 1, 2),
                        (List(1,2,3), 2, 3))
        tests.foreach(test=>
            P03Solution.getVersion(1).nth(test._2, test._1) must equal (test._3)
        )
    }
    
    test("P03 Solution v2 inrange") {
        val tests = List((List(1), 0, 1),
                        (List(1,2), 0, 1),
                        (List(1,2), 1, 2),
                        (List(1,2,3), 2, 3))
        tests.foreach(test=>
            P03Solution.getVersion(1).nth(test._2, test._1) must equal (test._3)
        )
    }
}

