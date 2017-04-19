package lzhou.scala.s99problems

import org.scalatest.FunSuite
import org.scalatest.MustMatchers._

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class P20SolutionTest extends FunSuite {
    test("P20 Solution v1 inrange") {
        val tests = List(
                        (0, List('a), (List(), 'a)),
                        (0, List('a,'b), (List('b), 'a)),
                        (1, List('a,'b), (List('a), 'b)),
                        (1, List('a,'b,'c), (List('a,'c), 'b)),
                        (2, List('a,'b,'c), (List('a, 'b), 'c))
                        )
        tests.foreach(test=>
            P20Solution.getVersion(1).removeAt(test._1, test._2) must equal (test._3)
        )
    }
    
    test("P20 Solution v1 oob") {
        val tests = List((0, List()),
                        (1, List('a)),
                        (2, List('a,'b)),
                        (3, List('a,'b)),
                        (-1, List('a,'b,'c)),
                        (10, List('a,'b,'c))
                        )
        tests.foreach(test=>
            intercept[IndexOutOfBoundsException] {
                P20Solution.getVersion(1).removeAt(test._1, test._2)
            }
        )
    }
    test("P20 Solution v2 inrange") {
        val tests = List(
                        (0, List('a), (List(), 'a)),
                        (0, List('a,'b), (List('b), 'a)),
                        (1, List('a,'b), (List('a), 'b)),
                        (1, List('a,'b,'c), (List('a,'c), 'b)),
                        (2, List('a,'b,'c), (List('a, 'b), 'c))
                        )
        tests.foreach(test=>
            P20Solution.getVersion(2).removeAt(test._1, test._2) must equal (test._3)
        )
    }
    
    test("P20 Solution v2 oob") {
        val tests = List((0, List()),
                        (1, List('a)),
                        (2, List('a,'b)),
                        (3, List('a,'b)),
                        (-1, List('a,'b,'c)),
                        (10, List('a,'b,'c))
                        )
        tests.foreach(test=>
            intercept[IndexOutOfBoundsException] {
                P20Solution.getVersion(2).removeAt(test._1, test._2)
            }
        )
    }
}

