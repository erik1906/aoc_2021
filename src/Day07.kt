fun main() {
    fun part1(input: List<String>): Int {

        val horizontalList = input[0].split(",").map { it.toInt()}
        var min = Int.MAX_VALUE
        var sum = 0
        for (i in horizontalList) {
            min = Math.min(min, horizontalList.get(i))
            sum += horizontalList.get(i)
        }
        return sum - horizontalList.size * min
    }

    fun part2(input: List<String>): Int {
        return 0
    }

    val input = readInput("Day07_test")
    println(part1(input))
    println(part2(input))
}
