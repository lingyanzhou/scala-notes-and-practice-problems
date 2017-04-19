package lzhou.scala.s99problems

import org.scalatest.FunSuite
import org.scalatest.MustMatchers._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalamock.scalatest.MockFactory

import scala.util.Random

@RunWith(classOf[JUnitRunner])
class P25SolutionTest extends FunSuite with MockFactory {
    test("P25 Solution randomPermute") {
        val rng = stub[Random]
        (rng.nextInt _).when().returns(0)
        val tests = List(
                        (List('a), List('a)),
                        (List('a,'b,'c), List('b,'c,'a)),
                        (List('a,'b,'c,'d,'e), List('b, 'c, 'd,'e,'a)),
                        (List('a,'b,'c,'d,'e,'f), List('b, 'c, 'd, 'e,'f,'a))
                        )
        tests.foreach(test=>
            P25Solution.get(rng).randomPermute(test._1) must equal (test._2)
        )
    }
}

