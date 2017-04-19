package lzhou.scala.s99problems

import org.scalatest.FunSuite
import org.scalatest.MustMatchers._
import java.util.NoSuchElementException

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class P01SolutionTest extends FunSuite {
    test("P01 Solution v1 empty") {
        val list: List[Int]= List()
        intercept[NoSuchElementException] {
            P01Solution.getVersion(1).last(list)
        }
    }
    
    test("P01 Solution v2 empty") {
        val list: List[Int]= List()
        intercept[NoSuchElementException] {
            P01Solution.getVersion(2).last(list)
        }
    }
    
    test("P01 Solution v1 non-empty") {
        val tests = List((List(1), 1),
                        (List(1,2), 2),
                        (List(1,2,3), 3))
        tests.foreach(x=>P01Solution.getVersion(1).last(x._1) must equal (x._2)
        )
    }
    
    test("P01 Solution v2 non-empty") {
        val tests = List((List(1), 1),
                        (List(1,2), 2),
                        (List(1,2,3), 3))
        tests.foreach(x=>P01Solution.getVersion(2).last(x._1) must equal (x._2)
        )
    }
}

