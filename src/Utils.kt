import java.io.File
import java.math.BigInteger
import java.security.MessageDigest
import kotlin.math.pow

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String) = File("src", "$name.txt").readLines()

/**
 * Converts string to md5 hash.
 */
fun String.md5(): String = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray())).toString(16)

fun List<String>.toPairList() = this.map {
    val split = it.split(" ")
    Pair(split[0], split[1].toInt())
}

fun String.toDecimal() : Int{
    var sum = 0
    val size = this.length - 1
    this.forEachIndexed { index, c ->
        if (c == '1') {
            sum += (2f.pow(size-index)).toInt()
        }

    }
    return sum
}