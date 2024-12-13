fun main() {
    print("Type your name: ")
    val name: String = readln()
    println("Hello $name")
    while (true) {
        print("Type an expression: ")
        val inputString: String = readln()

        val regex = Regex("""([\d.]+)\s*([+\-*/])\s*([\d.]+)""")
        val match = regex.matchEntire(inputString)
        if (match == null) {
            println("Invalid input")
            continue
        }

        val a = match.groupValues[1].toDouble()
        val operator = match.groupValues[2]
        val b = match.groupValues[3].toDouble()

        val result = when (operator) {
            "+" -> a + b
            "-" -> a - b
            "*" -> a * b
            "/" -> a / b
            else -> {
                println("Invalid operator")
                continue
            }
        }
        println("Total = $result")
    }
}
