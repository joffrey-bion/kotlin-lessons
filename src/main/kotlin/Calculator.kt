fun main() {
    println("Input expressions like '2 + 5'")
    while(true) {
        print("> ")
        val expression = readln()
        val (xText, op, yText) = expression.split(" ")
        val x = xText.toInt()
        val y = yText.toInt()
        val result = when (op) {
            "+" -> x + y
            "-" -> x - y
            "/", ":" -> x / y
            "*", "x" -> x * y
            else -> error("unknown operator '$op'")
        }
        println(result)
    }
}
