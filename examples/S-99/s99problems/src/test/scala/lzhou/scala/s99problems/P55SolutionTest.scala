package lzhou.scala.s99problems

import org.scalatest.FunSuite
import org.scalatest.MustMatchers._

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class P55SolutionTest extends FunSuite {
    test("P55 Solution") {
        val tests = List(
                        (1,"x", "List(T(x . .))"),
                        (2,"x", "List(T(x T(x . .) .), T(x . T(x . .)))"),
                        (3,"x", "List(T(x T(x . .) T(x . .)))"),
                        (4,"x", "List(T(x T(x T(x . .) .) T(x . .)), T(x T(x . T(x . .)) T(x . .)), T(x T(x . .) T(x T(x . .) .)), T(x T(x . .) T(x . T(x . .))))")
                        )
        tests.foreach(test=>
            P55Solution.get.cBalanced(test._1, test._2).toString must equal (test._3)
        )
    }
}

