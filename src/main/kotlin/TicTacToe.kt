/*
Grid characters: ─ │ ┌ ┬ ┐ ├ ┼ ┤ └ ┴ ┘
Naughts & crosses: ○ ✗ ⭕ ❌
 */

fun main() {
    val grid = List(3) { MutableList<Symbol?>(3) { null } }
    var playerSymbol = Symbol.CROSS

    grid.print()
    while (grid.winner() == null && grid.hasEmptyCells()) {
        println("Player with ${playerSymbol.value}s, your turn!")
        print("Pick a column (1, 2, 3): ")
        val column = readln().toInt() - 1
        print("Pick a row (1, 2, 3): ")
        val row = readln().toInt() - 1
        
        val existingCellValue = grid[row][column]
        if (existingCellValue != null) {
            System.err.println("Invalid choice, there is already a ${existingCellValue.value}")
            continue
        }
        grid[row][column] = playerSymbol
        grid.print()
        
        playerSymbol = if (playerSymbol == Symbol.CROSS) Symbol.NAUGHT else Symbol.CROSS
    }
    
    println("Player with ${grid.winner()?.value}s won!")
}

private fun List<MutableList<Symbol?>>.hasEmptyCells() = any { row -> row.any { col -> col == null } }

private fun List<MutableList<Symbol?>>.print() {
    println("   1 2 3")
    println("  ┌─┬─┬─┐")
    forEachIndexed { index, row ->
        if (index > 0) {
            println("  ├─┼─┼─┤")
        }
        print("${index + 1} ")
        println(row.joinToString("│", prefix = "│", postfix = "│") { it?.value  ?: " " })
    }
    println("  └─┴─┴─┘")
}

private enum class Symbol(val value: String) {
    CROSS("❌"), NAUGHT("⭕")
}

private fun List<List<Symbol?>>.winner(): Symbol? {
    Symbol.entries.forEach {
        if (isWonBy(it)) {
            return it
        }
    }
    return null
}

private fun List<List<Symbol?>>.isWonBy(player: Symbol): Boolean =
    isWonInRowsBy(player) || isWonInColumnBy(player) || isWonDiagonallyBy(player)

private fun List<List<Symbol?>>.isWonInRowsBy(player: Symbol) = any { row -> row.all { it == player } }

private fun List<List<Symbol?>>.isWonInColumnBy(player: Symbol) = (0..2).any { col -> all { row -> row[col] == player } }

private fun List<List<Symbol?>>.isWonDiagonallyBy(player: Symbol): Boolean =
    (0..2).all { index -> get(index)[index] == player }
    || (0..2).all { index -> get(index)[2 - index] == player }
