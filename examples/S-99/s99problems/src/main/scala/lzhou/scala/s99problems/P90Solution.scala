package lzhou.scala.s99problems

abstract class P90Solution {
    def eightQueen(): List[List[Int]]
}

/**
 * Generate and test solution 
 */
class P90SolutionImpl extends P90Solution {
    def eightQueen(): List[List[Int]] = {
        def isSolution(combination: List[Int], colTaken:List[Boolean], diagTaken:List[Boolean], revDiagTaken:List[Boolean]):Boolean = {
            if (combination.isEmpty) {
                true
            } else  if (colTaken(combination.head-1) || diagTaken(combination.size+combination.head-2) || revDiagTaken(combination.size-combination.head+7)) {
                false
            } else {
                isSolution(combination.tail, colTaken.updated(combination.head-1, true), diagTaken.updated(combination.size+combination.head-2, true), revDiagTaken.updated(combination.size-combination.head+7, true))
            }
        }
    
        def generate(prevLevel: List[List[Int]], level:Int): List[List[Int]] = level match {
            case 9 => prevLevel
            case _ => generate(prevLevel.flatMap(l=>(1 to 8).map(_::l).filter(isSolution(_, List.fill(8)(false), List.fill(15)(false), List.fill(15)(false)))), level+1)
        }

        generate(List(List()), 1)
    }
}

object P90Solution {
    def get: P90Solution = new P90SolutionImpl
}
