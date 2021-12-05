import kotlin.math.pow


fun main() {


    fun updateCount(list: MutableList<Pair<Int, Int>>,index: Int, values: Char) {
        if (values == '0') {
            list[index] = Pair(list[index].first + 1, list[index].second)
        } else {
            list[index] = Pair(list[index].first, list[index].second  + 1)
        }
    }

    fun part1(input: List<String>): Int {
        var gamma = 0
        var epsilon = 0
        val size = input[0].length
        val list = MutableList(size) { Pair(0,0) }


        input.forEach {
            it.forEachIndexed { index, char ->
                updateCount(list, index, char)
            }
        }
        list.forEachIndexed { index, pair ->
            if (pair.first > pair.second) {
                epsilon += (2f.pow(size-1-index)).toInt()
            } else {
                gamma += (2f.pow(size-1-index)).toInt()
            }
        }

        return epsilon * gamma
    }

    fun getOxygen(arrayA: List<String>, index: Int): Int {
        val listCounter = mutableListOf<ArrayList<String>>(arrayListOf(), arrayListOf())
        if (arrayA.size <= 1) return arrayA[0].toDecimal()
            arrayA.forEach {
                if (it[index] == '0') {
                    listCounter[0].add(it)
                } else {
                    listCounter[1].add(it)
                }
            }
        return if (listCounter[0].size > listCounter[1].size) {
            getOxygen(listCounter[0], index + 1)
        } else {
            getOxygen(listCounter[1], index + 1)
        }
    }

    fun getCO2(arrayA: List<String>, index: Int): Int {
        val listCounter = mutableListOf<ArrayList<String>>(arrayListOf(), arrayListOf())
        if (arrayA.size <= 1)  return arrayA[0].toDecimal()

        arrayA.forEach {
            if (it[index] == '0') {
                listCounter[0].add(it)
            } else {
                listCounter[1].add(it)
            }
        }
        return if (listCounter[0].size <= listCounter[1].size) {
            getCO2(listCounter[0], index + 1)
        } else {
            getCO2(listCounter[1], index + 1)
        }
    }


    fun part2(input: List<String>): Int {
        return  getOxygen(input, 0) *  getCO2(input, 0)

    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
//    check(part1(testInput) == 198)

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}
