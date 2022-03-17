fun main(args: Array<String>) {
  println("Hello World")

//  -----------------------------

  println("any")
  val emptyList = emptyList<Int>()
  println("emptyList.any() is ${emptyList.any()}")

  val nonEmptyList = listOf<Int>(1, 2, 3)
  println("nonEmptyList.any() is ${nonEmptyList.any()}")

//  -----------------------------

  println("find - findLast")
  val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
  val firstOdd = numbers.find { it % 2 == 0 }
  val firstLast = numbers.findLast { it % 2 == 0 }
  println(firstOdd)
  println(firstLast)

//  -----------------------------
  println("mapNotNull")

  val strings : List<String> = listOf("12a", "45", "", "3")
  val ints: List<Int> = strings.mapNotNull { it.toIntOrNull() }
  println(ints) // [45, 3]
  println(ints.sum()) // 48


//  -----------------------------
  println("mapNotNull with Map")

  val map = mapOf("Alice" to 20, "Tom" to 13, "Bob" to 18 )
  val adults = map.mapNotNull { (name, age) -> name.takeIf { age >= 18 } }

  println(adults) // [Alice, Bob]

}