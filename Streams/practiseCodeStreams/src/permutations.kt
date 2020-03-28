import java.util.stream.IntStream

fun main() {
    println("started")
    permutations(word = "123")
}
fun permutations(prefix: String = "", word: String) {
    if (word.length == 0) println(prefix)
    else IntStream.range(0, word.length).forEach { i -> permutations("${prefix}${word[i]}", "${word.substring(0, i)}${word.substring(i + 1, word.length)}") }
}