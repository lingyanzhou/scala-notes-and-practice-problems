package lzhou.scala.s99problems

import scala.collection.mutable.MutableList

abstract class P91Solution {
    def jump(n:Int, x:Int, y:Int): Option[List[(Int,Int)]]
}

/**
 * Generate and test solution 
 */
class P91SolutionImpl extends P91Solution {
    class Board(val n:Int) {
        def getPoint(x:Int, y:Int): Option[Point] = {
            if (x>0 && x<=n && y>0 && y<=n) {
                Option(new Point(x, y, this))
            } else {
                Option.empty
            }
        }
        override def toString:String = f"Bord(${n})" 
    }

    class Point(val x:Int, val y:Int, val board:Board) {
        def jump(dx:Int, dy:Int): Option[Point] = {
            board.getPoint(x+dx, y+dy)
        }

        def toTuple:(Int,Int) = (x, y)

        override def toString:String = f"Point(${x},${y})" 
    } 
    
    def jump(n:Int, x:Int, y:Int): Option[List[(Int,Int)]] = {
        def helper(n:Int, steps: List[Point], jumped:List[MutableList[Boolean]]): Option[List[Point]] = {
            def tryNextStep(n:Int, steps: List[Point], nextSteps:List[Point], jumped:List[MutableList[Boolean]]): Option[List[Point]] = {
                if (nextSteps.size==0) {
                    Option.empty
                } else {
                    val thisPoint = nextSteps.head
                    jumped(thisPoint.x-1)(thisPoint.y-1) = true
                    val thisResult = helper(n, steps:+thisPoint, jumped)
                    if (thisResult.nonEmpty) {
                        thisResult
                    } else {
                        jumped(thisPoint.x-1)(thisPoint.y-1) = false
                        tryNextStep(n, steps, nextSteps.tail, jumped)
                    }
                }
            }
            if (steps.size==n*n) {
                Option(steps)
            } else if (steps.size==0) {
                Option.empty
            } else {
                val curPoint = steps.last
                val nextJumps = List((-1,-2),(1,-2),(2,-1),(2,1),(1,2),(-1,2),(-2,1),(-2,-1)).flatMap(t=> curPoint.jump(t._1, t._2)).filter(pp => !(jumped(pp.x-1)(pp.y-1)))
                tryNextStep(n, steps, nextJumps, jumped)
            }
        }

        val jumped = List.fill(n)(MutableList.fill(n)(false))
        jumped(x-1)(y-1) = true
        helper(n, (new Point(x, y, new Board(n)))::Nil, jumped).map(_.map(_.toTuple))
    }
}



object P91Solution {
    def get: P91Solution = new P91SolutionImpl
}
