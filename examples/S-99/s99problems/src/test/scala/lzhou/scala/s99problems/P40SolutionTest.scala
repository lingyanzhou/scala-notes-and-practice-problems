package lzhou.scala.s99problems

import org.scalatest.FunSuite
import org.scalatest.MustMatchers._
import java.util.NoSuchElementException

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class P40SolutionTest extends FunSuite {
    
    test("P40 Solution listPrimesinRange") {
        val tests = List((0, null),
                        (1, null),
                        (2, null),
                        (4, (2,2)),
                        (6, (3,3)),
                        (8, (3,5)),
                        (10, (3,7)),
                        (12, (5,7)),
                        (28, (5,23)),
                        (992, (73,919)),
                        (1382, (61,1321)),
                        (1856, (67,1789)),
                        (1928, (61,1867))
                        )
        tests.foreach(x=>
            withClue(f"${x._1}.goldbach = ${x._2}:") {
                P40Solution.of(x._1).goldbach must equal (x._2)
            }
        )
    }
}

