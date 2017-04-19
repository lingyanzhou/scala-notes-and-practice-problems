package lzhou.scala.s99problems

import org.scalatest.FunSuite
import org.scalatest.MustMatchers._

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class P08SolutionTest extends FunSuite {
    test("P08 Solution") {
        val tests = List((List(), List()),
                        (List('a, 'a, 'a), List('a)),
                        (List('a, 'b, 'b, 'c), List('a,'b,'c)),
                        (List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'b), List('a,'b,'c, 'b))
                        )
        tests.foreach(test=>
            P08Solution.get().compress(test._1) must equal (test._2)
        )
    }
}

