//I erase my code for this day feels bad :(
fun main() {
    fun part1(input: List<String>): Int {
        var f = input[0].split(",").map { it.toInt() }
        repeat(80) {
            val g = ArrayList<Int>()
            for (x in f) {
                when {
                    x > 0 -> g.add(x - 1)
                    x == 0 -> {
                        g.add(6)
                        g.add(8)
                    }
                }
            }
            f = g
        }
        return f.size
    }

    fun part2(input: List<String>): Long {
        val f = input[0].split(",").map { it.toInt() }
        var c = LongArray(9)
        for (x in f) c[x]++
        repeat(256) {
            val g = LongArray(9)
            for (x in 0..8) {
                when {
                    x > 0 -> g[x - 1] += c[x]
                    x == 0 -> {
                        g[6] += c[x]
                        g[8] += c[x]
                    }
                }
            }
            c = g
        }
        return c.sum()
    }

    val input = readInput("Day6")
    println(part1(input))
    println(part2(input))
}
