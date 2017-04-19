package lzhou.scala.s99problems


class P47Solution {
    def table(func: (Boolean, Boolean)=>Boolean): String = {
        def helper(a : Boolean, b:Boolean): String = {
            
            val c = func(a,b)
            val s = f"$a%-6b$b%-6b$c%-6b\n"
            (a, b) match {
                case (true, true) => s+helper(true, false);
                case (true, false) => s+helper(false, true);
                case (false, true) => s+helper(false, false);
                case (false, false) => s;
            }
        }
        
        var s = f"A     B     result\n"
        s += helper(true, true)

        return s;
    }
}

object P47Solution {
    def get(): P47Solution = new P47Solution()
}
