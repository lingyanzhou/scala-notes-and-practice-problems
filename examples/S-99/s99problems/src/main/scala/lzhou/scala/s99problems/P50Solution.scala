package lzhou.scala.s99problems


class P50Solution {
    def huffman(freqs : List[(String, Int)]) : List[(String, String)] = {
        def helper(freqs : List[(String, Int)], codes: List[(String, String)]) : List[(String, String)] = {
            if (freqs.size<=1) {
                codes
            } else {
                val sorted = freqs.sortWith(_._2<_._2)
                val minFreq1 = sorted(0)
                val minFreq2 = sorted(1)
                val comb = (minFreq1._1+minFreq2._1, minFreq1._2+minFreq2._2)
                val newCodes = codes.map(t =>
                    if (minFreq1._1.contains(t._1)) {
                        (t._1, "1"+t._2)
                    } else if (minFreq2._1.contains(t._1)) {
                        (t._1, "0"+t._2)
                    } else {
                        t
                    }
                );
                helper(comb::sorted.tail.tail, newCodes)
            }
        }
        
        helper(freqs, freqs.map(t=>(t._1, ""))).sortWith(_._1<_._1);
    }
}

object P50Solution {
    def get(): P50Solution = new P50Solution()
}
