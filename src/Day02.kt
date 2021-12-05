fun main() {
    fun part1(input: List<String>): Int {

        val map = hashMapOf<String, Int>()
       input.toPairList().forEach { (a, b) ->
            map[a] = map.getOrDefault(a, 0) + b
        }
       return map.getOrDefault("forward", 0) * (map.getOrDefault("down", 0) - map.getOrDefault("up", 0))

    }

    fun part2(input: List<String>): Int {
        var horizontal = 0
        var aim = 0
        var depth  = 0
        input.toPairList().forEach { (a, b) ->
            when (a) {
                "down" -> aim += b
                "up" -> aim -= b
                "forward" -> {
                    horizontal += b
                    depth += aim * b
                }

            }
        }
        return horizontal * depth

    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 150)

    val input = readInput("Day02_test")
    println(part1(input))
    println(part2(input))
}
