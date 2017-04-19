package lzhou.scala.s99problems

import org.scalatest.FunSuite
import org.scalatest.MustMatchers._

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class P05SolutionTest extends FunSuite {
    
    test("P05 Solution v1 inrange") {
        val tests = List((List(1), List(1)),
                        (List(1,2), List(2,1)),
                        (List(1,2,3), List(3,2,1)),
                        (List(1,2,3,4), List(4,3,2,1)))
        tests.foreach(test=>
            P05Solution.getVersion(1).reverse(test._1) must equal (test._2)
        )
    }
    
    test("P05 Solution v2 inrange") {
        val tests = List((List(1), List(1)),
                        (List(1,2), List(2,1)),
                        (List(1,2,3), List(3,2,1)),
                        (List(1,2,3,4), List(4,3,2,1)))
        tests.foreach(test=>
            P05Solution.getVersion(2).reverse(test._1) must equal (test._2)
        )
    }
}

