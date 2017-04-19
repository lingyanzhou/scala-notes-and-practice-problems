package lzhou.scala.s99problems

import org.scalatest.FunSuite
import org.scalatest.MustMatchers._

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class P26SolutionTest extends FunSuite {
    test("P26 Solution v1 combinations") {
        val tests = List(
                        (1, List('a), List(List('a))),
                        (2, List('a, 'b, 'c), List(List('a,'b),List('a,'c),List('b,'c))),
                        (3, List('a,'b,'c,'d), List(List('a,'b,'c),List('a,'b,'d),List('a,'c,'d),List('b,'c,'d)))
                        )
        tests.foreach(test=>
            P26Solution.getVersion(1).combinations(test._1, test._2) must equal (test._3)
        )
    }
    test("P26 Solution v2 combinations") {
        val tests = List(
                        (1, List('a), List(List('a))),
                        (2, List('a, 'b, 'c), List(List('a,'b),List('a,'c),List('b,'c))),
                        (3, List('a,'b,'c,'d), List(List('a,'b,'c),List('a,'b,'d),List('a,'c,'d),List('b,'c,'d)))
                        )
        tests.foreach(test=>
            P26Solution.getVersion(2).combinations(test._1, test._2) must equal (test._3)
        )
    }
}

