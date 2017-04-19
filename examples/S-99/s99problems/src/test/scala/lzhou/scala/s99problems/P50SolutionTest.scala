package lzhou.scala.s99problems

import org.scalatest.FunSuite
import org.scalatest.MustMatchers._

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class P50SolutionTest extends FunSuite {
    test("P50 Solution") {
        val tests = List((List(("a", 2),("b",1)), List(("a", "0"), ("b", "1"))),
                        (List(("a", 1),("b",3)), List(("a", "1"), ("b", "0"))),
                        (List(("a", 2),("b",1),("c",4)), List(("a", "10"), ("b", "11"), ("c", "0"))),
                        (List(("a", 45),("b",13),("c",12),("d",16),("e",9),("f",5)), List(("a", "1"), ("b", "010"), ("c", "011"), ("d", "000"), ("e", "0010"), ("f", "0011")))
                        )
        tests.foreach(test=>
            P50Solution.get().huffman(test._1) must equal (test._2)
        )
    }
}

