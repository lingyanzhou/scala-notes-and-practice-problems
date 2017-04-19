package lzhou.scala.s99problems

import scala.util.Random

class P27Solution {
    def group(groups:List[Int], list:List[String]): List[List[List[String]]] = {
        def helperTraverseGroup(groups:List[Int], progress: List[(List[String], List[List[String]])]): List[(List[String], List[List[String]])] = {
            def helperTraverseProcess(n:Int, progress: List[(List[String], List[List[String]])]): List[(List[String], List[List[String]])] = {
                def combination(n:Int, list: List[String]): List[(List[String], List[String])] = {
                    def helperDecN(n:Int, toSelect: List[String], selected:List[String], notSelected:List[String]): List[(List[String], List[String])] = {
                        if (n==0) {
                            (notSelected++toSelect, selected) :: Nil
                        } else {
                            if (toSelect.size==0) {
                                Nil
                            } else {
                                helperDecN(n-1, toSelect.tail, selected:+toSelect.head, notSelected) ++ helperDecN(n, toSelect.tail, selected, notSelected:+toSelect.head) 
                            }
                        }
                    }
                    require(n>0)
                    require(n<=list.size)

                    helperDecN(n, list, Nil, Nil)
                }
                
                progress match {
                    case Nil => Nil
                    case head::tail => combination(n, head._1).map(t=>(t._1, head._2:+t._2)) ++ helperTraverseProcess(n, tail)
                }
            }
            
            groups match {
                case Nil => progress
                case head::tail =>
                    helperTraverseGroup(groups.tail, helperTraverseProcess(groups.head, progress))
            }
        }

        helperTraverseGroup(groups, List((list, Nil))).map(t=>t._2)
    }
}

object P27Solution {
    def get: P27Solution = new P27Solution()
}
