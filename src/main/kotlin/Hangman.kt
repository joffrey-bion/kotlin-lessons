private const val MAX_MISSES = 10
private const val BLANK = '_'

fun main() {
    val word = dictionary.random().uppercase()
    val guesses = mutableSetOf<Char>()

    var misses = 0
    while (misses < MAX_MISSES && word.any { it !in guesses }) {
        clearScreen()
        printCurrentState(word, guesses, misses)

        val guessLetter = readNewGuess(guesses)
        guesses.add(guessLetter)

        if (guessLetter !in word) {
            misses++
        }
    }
    val verb = if (misses == MAX_MISSES) "LOSE" else "WIN"
    println("You $verb! The word was $word")
}

private fun clearScreen() {
    print("\u001b[2J\u001b[H")
}

private fun printCurrentState(word: String, guesses: MutableSet<Char>, misses: Int) {
    print("  ")
    println(word.map { if (it in guesses) it else BLANK }.joinToString(" "))
    println()
    println("$misses/$MAX_MISSES misses")
    if (guesses.isNotEmpty()) {
        println("Guesses so far: ${guesses.sorted().joinToString()}")
    }
}

private fun readNewGuess(previousGuesses: Set<Char>): Char {
    while (true) {
        print("Guess a letter: ")
        val guess = readln()
        if (guess.length != 1) {
            println("Just a single letter, please!")
            continue
        }
        val guessLetter = guess.single()
        if (guessLetter in previousGuesses) {
            println("You already tried that one!")
            continue
        }
        return guessLetter.uppercaseChar()
    }
}

private val dictionary = listOf(
    "account",
    "adjustment",
    "advertisement",
    "amount",
    "animal",
    "apparatus",
    "attraction",
    "authority",
    "back",
    "baseball",
    "bedroom",
    "beds",
    "boat",
    "book",
    "border",
    "building",
    "camera",
    "camp",
    "card",
    "care",
    "carpenter",
    "cast",
    "cats",
    "clam",
    "cook",
    "crate",
    "design",
    "dinner",
    "direction",
    "discovery",
    "downtown",
    "dress",
    "drink",
    "driving",
    "earthquake",
    "existence",
    "flame",
    "flesh",
    "fog",
    "frog",
    "glass",
    "grade",
    "ground",
    "group",
    "harbor",
    "hour",
    "hydrant",
    "impulse",
    "ink",
    "jam",
    "language",
    "leather",
    "maid",
    "meat",
    "minister",
    "motion",
    "noise",
    "nose",
    "notebook",
    "number",
    "office",
    "pig",
    "popcorn",
    "potato",
    "power",
    "prose",
    "question",
    "quicksand",
    "quiver",
    "record",
    "relation",
    "respect",
    "road",
    "rub",
    "sack",
    "sand",
    "scissors",
    "shake",
    "shoe",
    "skirt",
    "slave",
    "soda",
    "sort",
    "soup",
    "spade",
    "spot",
    "spy",
    "spy",
    "stamp",
    "stamp",
    "start",
    "stick",
    "sticks",
    "store",
    "stranger",
    "stranger",
    "straw",
    "string",
    "structure",
    "tank",
    "teeth",
    "temper",
    "territory",
    "things",
    "thumb",
    "tomatoes",
    "toothbrush",
    "truck",
    "umbrella",
    "vessel",
    "volcano",
    "walk",
    "wash",
    "wealth",
    "wool",
    "wrench",
    "yard",
    "zephyr",
    "zipper",
    "zoo",
)