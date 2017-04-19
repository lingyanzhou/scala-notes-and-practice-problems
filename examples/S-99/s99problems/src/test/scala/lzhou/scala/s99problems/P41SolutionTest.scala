package lzhou.scala.s99problems

import org.scalatest.FunSuite
import org.scalatest.MustMatchers._
import java.util.NoSuchElementException

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class P41SolutionTest extends FunSuite {
    
    test("P41 Solution printGoldbachListLimited") {
        val tests = List((0 to 3, 0, Nil),
                        (0 to 4, 0, List((4,(2,2)))),
                        (3 to 4, 2, List((4,(2,2)))),
                        (3 to 4, 3, Nil),
                        (4 to 7, 2, List((4,(2,2)),(6,(3,3)))),
                        (4 to 7, 3, List((6,(3,3)))),
                        (6 to 8, 3, List((6,(3,3)),(8,(3,5)))),
                        (7 to 9, 3, List((8,(3,5)))),
                        (10 to 20, 4, List((12,(5,7)), (18,(5,13)))),
                        (1 to 2000, 50, List((992,(73,919)),(1382, (61, 1321)),(1856, (67, 1789)),(1928, (61, 1867))))
                        )
        tests.foreach(x=>
            withClue(f"printGoldbachListLimited(${x._1},${x._2}) = ${x._3}:") {
                P41Solution.get.printGoldbachListLimited(x._1, x._2) must equal (x._3)
            }
        )
    }
}

