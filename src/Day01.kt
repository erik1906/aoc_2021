fun main() {
    fun part1(input: List<String>): Int {
        return input.zipWithNext().count { (a, b) ->  a.toInt() < b.toInt()}
    }

    fun part2(input: List<String>): Int {
        val inputInt = input.map { it.toInt() }
        return inputInt.windowed(3) { it.sum() }.zipWithNext().count { (a, b) ->  a < b}
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 7)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
