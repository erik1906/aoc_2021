import com.sun.org.apache.xpath.internal.operations.Bool

fun main() {
    fun createBingo(input: List<String>): Pair<List<Int>, ArrayList<List<MutableList<Pair<Int,Boolean>>>>> {
        var bingo = Pair(listOf<Int>(), arrayListOf<List<MutableList<Pair<Int,Boolean>>>>())
        var list = arrayListOf<MutableList<Pair<Int,Boolean>>>()
        input.forEachIndexed { index, string ->
            val s = string.trim()
            if (index == 0) {
                bingo = Pair(s.split(',').map { it.toInt() }, bingo.second)
                return@forEachIndexed
            } else {
                if (s.isEmpty()) {
                    if(list.isNotEmpty()) {
                        bingo.second.add(list)
                    }

                    list = arrayListOf()

                    return@forEachIndexed
                } else {

                    list.add(s.split("\\s+".toRegex()).map { Pair(it.toInt(), false) }.toMutableList())
                }
            }
        }
        bingo.second.add(list)


        return bingo
    }

    fun findIsBingo(bingoCard: List<MutableList<Pair<Int,Boolean>>>, i: Int, j: Int): Boolean {
        var isRowBingo = true
        for (column in 0 until 5 ){
            if (!bingoCard[i][column].second) {
                isRowBingo = false
                break
            }
        }

        var isColumnBingo = true
        for (row in 0 until 5 ){
            if (!bingoCard[row][j].second) {
                isColumnBingo = false
                break
            }
        }
        return isColumnBingo || isRowBingo
    }

    fun findNumber(bingoCard: List<MutableList<Pair<Int,Boolean>>>, number: Number):  Boolean {
        bingoCard.forEachIndexed { i, row ->
            row.forEachIndexed { j, pair ->
                if (pair.first == number) {
                    bingoCard[i][j] = Pair(number, true)
                    if (findIsBingo(bingoCard, i, j)) return true
                }
            }
        }
        return false
    }


    fun countUnmarked(bingoCard: List<MutableList<Pair<Int,Boolean>>>): Int {
        var sum = 0
        bingoCard.forEach {
            it.forEach { (value, marked) ->
                if (!marked) sum += value
            }
        }
        return sum
    }

    fun findBingo(arrayList: List<List<MutableList<Pair<Int,Boolean>>>>, number: Int): Int {
        arrayList.forEach {
            if (findNumber(it, number)) {
                return countUnmarked(it) * number
            }
        }
        return 0
    }

    fun findLastBingo(arrayList: ArrayList<List<MutableList<Pair<Int,Boolean>>>>, number: Int): List<List<MutableList<Pair<Int,Boolean>>>> {
        val i = arrayListOf<List<MutableList<Pair<Int,Boolean>>>>()
        arrayList.forEachIndexed { index, it ->
            if (findNumber(it, number)) {
                i.add(it)
            }
        }
        return i
    }



    fun part1(input: List<String>): Int {
        val (number, cards) = createBingo(input)
        number.forEach {
            val bingoValue = findBingo(cards, it)
            if(bingoValue != 0 ) return bingoValue

        }
        return 0
    }

    fun part2(input: List<String>): Int {
        val (number, cards) = createBingo(input)

        number.forEach {
            val bingoIndex = findLastBingo(cards, it)
            bingoIndex.forEach { index ->
                if (cards.size == 1 ) {
                    return countUnmarked(cards[0]) * it
                } else {
                    cards.remove(index)
                }
            }
        }
        return 0
    }

    val input = readInput("Day04")
    println(part1(input))
    println(part2(input))
}
