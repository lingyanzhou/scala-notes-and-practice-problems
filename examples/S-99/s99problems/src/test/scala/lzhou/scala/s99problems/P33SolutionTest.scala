package lzhou.scala.s99problems

import org.scalatest.FunSuite
import org.scalatest.MustMatchers._
import java.util.NoSuchElementException

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class P33SolutionTest extends FunSuite {
    
    test("P33 Solution is prime") {
        val tests = List((1,2, true),
                        (100,1,true),
                        (3,2,true),
                        (4,6,false),
                        (24, 8, false),
                        (8, 32, false),
                        (12, 40, false),
                        (33, 77, false),
                        (33, 311, true),
                        (16, 9, true),
                        (35, 64, true),
                        (64, 35, true),
                        (21, 100, true),
                        (180, 40, false))
        tests.foreach(x=>
            withClue(f"${x._1}.isCoprimeTo(${x._2})=${x._3}:") {
                P33Solution.of(x._1).isCoprimeTo(x._2) must equal (x._3)
            }
        )
    }
}

