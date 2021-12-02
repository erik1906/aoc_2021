fun main() {
    fun part1(input: List<String>): Int {
        var counter = 0
        var lastNumber: Int? = null
        input.forEach {
            val unMutableLastNumber = lastNumber
            val intValue = it.toInt()
            if (unMutableLastNumber != null) {
                if ( intValue > unMutableLastNumber) counter++
            }
            lastNumber = intValue
        }
        return counter
    }

    fun part2(input: List<String>): Int {
        var counter = 0
        var lastNumber: Int? = null
        input.windowed(3,1 ,false) {
            var sum = 0
            it.forEach { value ->
                sum += value.toInt()
            }
            val unMutableLastNumber = lastNumber
            if (unMutableLastNumber != null && sum > unMutableLastNumber) counter++
            lastNumber = sum

            sum
        }

        return counter
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 7)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
