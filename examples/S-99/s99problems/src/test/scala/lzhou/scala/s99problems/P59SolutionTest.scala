package lzhou.scala.s99problems

import org.scalatest.FunSuite
import org.scalatest.MustMatchers._

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class P59SolutionTest extends FunSuite {
    test("P59 Solution") {
        val tests = List(
                        (1,"x", "List(T(x . .))"),
                        (2,"x", "List(T(x . T(x . .)), T(x T(x . .) .), T(x T(x . .) T(x . .)))")
                        )
        tests.foreach(test=>
            P59Solution.get.hbalTrees(test._1, test._2).toString must equal (test._3)
        )
    }
    
    test("P59 Solution result size tests") {
        val tests = List(
                        (2,"x", 3),
                        (3,"x", 15),
                        (4,"x", 315),
                        (5,"x", 108675)
                        )
        tests.foreach(test=>
            P59Solution.get.hbalTrees(test._1, test._2).size must equal (test._3)
        )
    }
}

