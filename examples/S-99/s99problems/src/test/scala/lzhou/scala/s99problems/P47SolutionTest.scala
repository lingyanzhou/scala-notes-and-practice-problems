package lzhou.scala.s99problems

import org.scalatest.FunSuite
import org.scalatest.MustMatchers._

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class P47SolutionTest extends FunSuite {
    test("P47 Solution") {
        val tests = List((P46Solution.get().and _ , """A     B     result
true  true  true  
true  false false 
false true  false 
false false false 
"""),
                        ((a:Boolean,b:Boolean)=>P46Solution.get().and(a, P46Solution.get().or(a, b)) , """A     B     result
true  true  true  
true  false true  
false true  false 
false false false 
""")
                        )
        tests.foreach(test=>
            P47Solution.get().table(test._1) must equal (test._2)
        )
    }
}

