package lzhou.scala.s99problems

import org.scalatest.FunSuite
import org.scalatest.MustMatchers._

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class P46SolutionTest extends FunSuite {
    test("P46 Solution and") {
        val tests = List((true, true, true),
                        (true, false, false),
                        (false, true, false),
                        (false, false, false)
                        )
        tests.foreach(test=>
            P46Solution.get().and(test._1, test._2) must equal (test._3)
        )
    }
    test("P46 Solution or") {
        val tests = List((true, true, true),
                        (true, false, true),
                        (false, true, true),
                        (false, false, false)
                        )
        tests.foreach(test=>
            P46Solution.get().or(test._1, test._2) must equal (test._3)
        )
    }
    test("P46 Solution nand") {
        val tests = List((true, true, false),
                        (true, false, true),
                        (false, true, true),
                        (false, false, true)
                        )
        tests.foreach(test=>
            P46Solution.get().nand(test._1, test._2) must equal (test._3)
        )
    }
    test("P46 Solution nor") {
        val tests = List((true, true, false),
                        (true, false, false),
                        (false, true, false),
                        (false, false, true)
                        )
        tests.foreach(test=>
            P46Solution.get().nor(test._1, test._2) must equal (test._3)
        )
    }
    test("P46 Solution xor") {
        val tests = List((true, true, false),
                        (true, false, true),
                        (false, true, true),
                        (false, false, false)
                        )
        tests.foreach(test=>
            P46Solution.get().xor(test._1, test._2) must equal (test._3)
        )
    }
    test("P46 Solution impl") {
        val tests = List((true, true, true),
                        (true, false, false),
                        (false, true, true),
                        (false, false, true)
                        )
        tests.foreach(test=>
            P46Solution.get().impl(test._1, test._2) must equal (test._3)
        )
    }
    test("P46 Solution equ") {
        val tests = List((true, true, true),
                        (true, false, false),
                        (false, true, false),
                        (false, false, true)
                        )
        tests.foreach(test=>
            P46Solution.get().equ(test._1, test._2) must equal (test._3)
        )
    }
}

