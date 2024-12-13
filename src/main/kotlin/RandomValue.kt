import kotlin.random.*

fun main() {
    print("Input the lower limit: ")
    val low = readln().toInt()
    print("Input the higher limit: ")
    val high = readln().toInt()
    val random = Random.nextInt(from = low, until = high)
    print("Your number is: $random")
}
