package lzhou.scala.s99problems

abstract class P07Solution {
    def flatten(list: List[Any]): List[Any]
}

object P07Solution {
    def get(): P07Solution = new P07Solution1()
}


private class P07Solution1 extends P07Solution {
    override def flatten(list: List[Any]): List[Any] = {
        def flattenHelper(flattened: List[Any], toFlatten: List[Any]): List[Any] = {
            toFlatten match {
                case Nil => flattened
                case _ => toFlatten.head match {
                    case x :List[Any] => flattenHelper(flattened:::flattenHelper(Nil, x), toFlatten.tail)
                    case x => flattenHelper(flattened:::List(x), toFlatten.tail)
                }
            }
        }
        flattenHelper(Nil, list)
    }
}
