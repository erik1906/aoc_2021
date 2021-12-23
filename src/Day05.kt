
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

fun main() {


    fun part1(input: List<String>): Int {

        val vents =  MutableList(1000) {MutableList(1000) { 0 } }

        val newList = input.map {

            val split = it.split("->")
            val from = split[0].trim().split(",")
            val to = split[1].trim().split(",")
            Pair(Pair(from[0].toInt(), from[1].toInt()), Pair(to[0].toInt(), to[1].toInt()))
        }

        newList.forEach {  (from, to) ->
            if(from.first == to.first || from.second == to.second) {
                val (biggerX, smallestX) = if(from.first >= to.first) Pair(max(from.first, to.first), min(from.first, to.first)) else Pair( to.first, from.first)
                val (biggerY, smallestY) = if(from.second >= to.second) Pair(max(from.second, to.second), min(from.second, to.second)) else Pair(to.second, from.second)
                for (i in smallestY..biggerY) {
                    for (j in smallestX..biggerX) {
                        vents[i][j] = vents[i][j] + 1

                    }
                }
            }

        }

        val flatValues= vents.flatten()
        println(flatValues.maxOrNull())
        return flatValues.count { it >= 2 }

    }

    fun part2(input: List<String>): Int {
        val vents =  MutableList(1000) {MutableList(1000) { 0 } }

        val newList = input.map {

            val split = it.split("->")
            val from = split[0].trim().split(",")
            val to = split[1].trim().split(",")
            Pair(Pair(from[0].toInt(), from[1].toInt()), Pair(to[0].toInt(), to[1].toInt()))
        }

        newList.forEach {  (from, to) ->
            if(from.first == to.first || from.second == to.second) {
                val (biggerX, smallestX) = if(from.first >= to.first) Pair(max(from.first, to.first), min(from.first, to.first)) else Pair( to.first, from.first)
                val (biggerY, smallestY) = if(from.second >= to.second) Pair(max(from.second, to.second), min(from.second, to.second)) else Pair(to.second, from.second)
                for (i in smallestY..biggerY) {
                    for (j in smallestX..biggerX) {
                        vents[i][j] = vents[i][j] + 1

                    }
                }
            }
            if(abs(from.first - to.first) == abs(from.second - to.second)) {
                val (biggerX, smallestX) = if(from.first >= to.first) Pair(max(from.first, to.first), min(from.first, to.first)) else Pair( to.first, from.first)
                val (biggerY, smallestY) = if(from.second >= to.second) Pair(max(from.second, to.second), min(from.second, to.second)) else Pair(to.second, from.second)
                for (i in smallestY..biggerY) {
                    for (j in smallestX..biggerX) {
                        if(abs(from.first - j) == abs(from.second - i))
                        vents[i][j] = vents[i][j] + 1

                    }
                }
            }


        }

        val flatValues= vents.flatten()
        return flatValues.count { it >= 2 }
    }

    val input = readInput("Day05")
    println(part1(input))
    println(part2(input))
}
