class Person(val name: String) {
    val likedPeople = mutableListOf<Person>()
    infix fun likes(other: Person) { likedPeople.add(other) }  // 6
}

fun main() {

    infix fun Int.times(str: String) = str.repeat(this)        // 1
    println(2 times "Bye ")                                    // 2

    val pair2 = "Ferrari" to "Katrina"                          // 3
    println(pair2)

    infix fun String.onto(other: String) = Pair(this, other)   // 4
    val myPair2 = "McLaren" onto "Lucas"
    println(myPair2)

    val sophia2 = Person("Sophia")
    val claudia2 = Person("Claudia")
    sophia2 likes claudia2                                       // 5
}