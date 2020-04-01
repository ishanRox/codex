import java.util.stream.IntStream

fun main() {
    println("hello world")

    //immutable
    val name = "ishan"
    //mutable
    var age = 42
    //type inference auto assign types

    //you can specify types too
    var bigInt: Int = Int.MAX_VALUE
    var smallInt: Int = Int.MIN_VALUE

    println("Biggest int " + bigInt)
    //String interpolation
    println("Small int $smallInt")

    //Long Double Float Boolean Short

    //But loss of presition 15 digit
    var deci: Double = 1.11111111111111111111111
    var deci1: Double = 1.11111111111111111111111

    println("added " + (deci + deci1))

    //booleans
    if (true is Boolean) print("true is boolean\n")

    //char
    println("is 'A' is a char =${'A' is Char}")

    //how cast works all goes like this
    println("65 to Char " + 65.toChar())
    println("3.14 as Int " + 3.14.toInt())


    //play with Strings

    val myName = "ishan"
    val longString = """
        hello my name
        is ishan and i dont know you
        why ru looking at my git hub
        just a joke send me a message 
        0782481502
    """
    println(longString)


    var fname = "ishan"
    var lname = "vimukthi"
    println("fname equals lname ${fname.equals(lname)}")
    println("fname compareTo lname ${fname.compareTo(lname)}")

    //get indexses
    println("second index ${fname[2]}")
    println("get subSequence(subsring in java) ${fname.subSequence(0, 3)}")

    //Arrays
    var myArray = arrayOf(1, 23, "isha", 1.22)
    println(myArray[3])
    println("size ${myArray.size}")
    //get first 2 elements
    println("copy Range ${myArray.copyOfRange(1, 3).forEach { println("val ${it}") }}")

    //lambda and arrays

    var squareArrays = Array(5, { it * it })
    squareArrays.forEach { println(it) }

    //  recurtion(10)

    //ranges

    val oneTo10 = 1..10

    val alpha = "A".."B"
    println("is in alpha ${"R" in alpha}")

    val tento1 = 10.downTo(1)
    tento1.forEach { println(it) }
    println("_______________________________")

    val rangeTo = 2.rangeTo(10)
    rangeTo.forEach { println(it) }
    println("______________________")

    val steping = (1..10).step(3)
    steping.forEach { println(it) }
    println("_______________________________")

    for (number in 1..5) println(number)
    println("_______________________________")
    for (number in (1..5).reversed()) println(number)


    //Conditionals

    //logical and condionals work as java
    //speciality is in when its like a switch
    val birthYear = 2005

    when (birthYear) {
        1993, 1992 -> println("aunty babek")

        in 1994..2003 -> println("mattiyek")

        else -> println("Nadu walata asada ?")

    }


    //for loops

    for (x in 1..10) println(x)
    println("_______________________________")
    for ((index, value) in (1..10).withIndex()) println("index $index and value $value")

    println("_______________________________")
    //pair functions
    val (one, two) = nextTwo(4)
    println("$one $two")

    println("_______________________________")
    println(getSum(1, 2, 3, 4, 5))

    println("_______________________________")

    //function literals
    //issella para tika specify anthimata process eka
    val multiply = { num1: Int, num2: Int -> num1 * num2 }
    println(multiply(10, 2))

    println("_______________________________")
    printNo(5)

    //functional

    val noList = 1..10
    val evenList = noList.filter { it % 2 == 0 }
    val sum = noList.sum()

    println(evenList)
    println(sum)
    println("_______________________________")

    val mathMethod = higerOrderFun()
    println(mathMethod(12, 13))

    //shortcut for higer order
    println(higerOrderFun()(12, 15))
    println("_______________________________")

    higherVoid("ishan")("vimukthi")

    //how filter map and foreach made :-)
    //megollange lambda eka mehemai { e -> e % 2 == 0 }
    println(almostLikeFilter((1..10).toList(), { e -> e % 2 == 0 }))
    println(almostLikeFilter((1..10).toList(), { e -> e % 2 == 1 }))
    println("_______________________________")


}

//function that get a function and list
fun almostLikeFilter(list: List<Int>, predicate: (Int) -> Boolean): List<Int> {

    val arrayList = arrayListOf<Int>()

    for (x in list) {
        val filter = predicate(x)
        if (filter) arrayList.add(x)
    }

    return arrayList
}

//function that return functions
// return ekedi para and retrn wala type witharai ona
// habai method ekak para weddi name ekak denna ona
fun higerOrderFun(): (Int, Int) -> Int {

    return { a, b ->
        println("A is $a B is $b ")
        a + b
    }
}

//return type void
fun higherVoid(name1: String): (String) -> Unit {
    return { name2 ->
        println("$name1 vs $name2")
    }

}

//awsome tailrecurtion no need to call itself
// every one knows it because its a keyword

tailrec fun printNo(no: Int) {
    println("call going $no")
    if (no == 0) return
    printNo(no - 1)
    println("call coming back $no")

}

//functions no need of return type automatically resolved
fun add(num: Int, num1: Int) = num1 + num

fun nothing(name: String): Unit = println("hello $name")

//Return a pair
fun nextTwo(num: Int): Pair<Int, Int> {
    return Pair(num + 1, num + 2)
}

//var args
fun getSum(vararg nums: Int): Int {
    var sum = 0
    nums.forEach { sum += it }
    return sum
}