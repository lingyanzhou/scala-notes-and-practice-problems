package lzhou.scala.s99problems

class P96Solution {
    def isIdentifier(token:String): Boolean = {
        def isIdentifier2(token:String): Boolean = {
            token match {
                case t if (t.head.isLetterOrDigit) =>
                    val tail = t.tail
                    if (tail.isEmpty) {
                        true
                    } else if (tail.head=='-') {
                        isIdentifier2(tail.tail)
                    } else {
                        isIdentifier2(tail)
                    }
                case _=> false
            }
        }

        token match {
            case "" => false
            case t if (t.head.isLetter) =>
                val tail = t.tail
                if (tail.isEmpty) {
                    true
                } else if (tail.head=='-') {
                    isIdentifier2(tail.tail)
                } else {
                    isIdentifier2(tail)
                }
            case _=> false
        }
    }
}

object P96Solution {
    def get(): P96Solution = new P96Solution()
}
