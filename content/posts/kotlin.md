---
title: "Kotlin"
date: 2022-03-07T14:46:09-06:00
toc: false
images:
tags:
  --untagged
---

# **INDEX**

# 1. Your first kotlin application

# 2. Variables, Constants, and Types.

You use _variables_ and _constants_ ti store values and pass data around in your application.

## Declaring a Variable

You defines a variable using the keyword var, which indicates that you want to declare a new variable, followed by the new variable's name.

Next, you specified the type definition for the variable. : Int.

Last, you used th _assignment operator_ (=) to assign what is on the righthand.

```kotlin
var variableName : Int = 5
```

## Kotlin's Built-In Tyoes

|Type|Description|Examples|
|---|---|---|
|String|Textual Data|"Text"|
|Char|Single character|'x' Unicode character U+0041|
|Boolean|True/False values|true / false|
|Int|Whole numbers| 1,2,3,4,5,6,7,8,9,0|
|Double|Decimal numbers|3.14, 2.10|
|List|Collections of Elements|[1,2,3,4,5,6,7,8,9,0]|
|Set|Collections of _unique_ elements|[1,2,3,4,5,6,7,8,9,0]|
|Map|Collections of key-value pairs|"small" to 5.99, "medium" to 7.99, "large" to 10.99|

## Read-Only Variables

Kotlin provides a different syntaxis for declaring _read-only_ variables - variables that cannot be modified once they are addigned.

To declare a read-only variable, you use the **val** keyword.

## Type Inference

Notice that the type definitions you specified for the playerName and experiencePoints variables are grayed out in IntelliJ. Grayed-out text indicates an element that is not required.

```kotlin
val playerName : _String_ = "Estragon"
```

Kotlin includes a feature called _type inference_ that allows you to omit the type definition for the variable that are assigned a value when are declared. Because you assign data of the String type to playerName and of the Int type to experiencePoints when you declare them, the kotlin compiler infers the appropriate type information for both variables.

## Inspecting Kotlin Bytecode

Press the Shift key twice to open the Search Everywhere dialog. Begin entering "show kotling bytecode" in the search box, and select Show Kotlin Bytecode from the list of available actions when it appears.

You can also open the tool window with Tools => Kotlin => Show Kotlin Bytecode.

# 3. Conditionals

This lenguage feature is called _control flow_, and it allows yoy yo describe the conditions for when specific portions of your program should run.

Tip: Add a **main** entry point function to _program_kt_ by typing "main" and pressing the Tab key. Your function should look like this:


```kotlin
fun main(args: Array<String>){
	...
}
```

## Listing 3.1 Printing the player’s health condition (Game.kt)
```kotlin
fun main(args: Array<String>) {
    val name = "Madrigal"
    var healthPoints = 100
    if (healthPoints == 100) {
        println(name + " is in excellent condition!")
} else {
        println(name + " is in awful condition!")
    }
}
```

You express this with the == _structural equality operator_. It can be read as "is equal to", so this statement reads "if healthPoint is equals to 100".

Using the addition operator (+) to append a value to a string is called _string concatenation_. It is an easy way to customize what is printed to the conole based on the value of variable.

## Table 3.1 Comparison operators

|Operator|Description|
|---|---|
|< |Evaluates whether the value on the left is less than the value on the right|
|<=|Evaluates whether the value on the left is less than or equal to the value on the right|
|> |Evaluates whether the value on the left is greater than the value on the right|
|>=|Evaluates whether the value on the left is greater than or equal to the value on the right|
|==|Evaluates whether the value on the left is equal to the value on the right|
|!=|Evaluates whether the value on the left is not equal to the value on the right|
|===|Evaluates whether the two instances point to the same reference|
|!==|Evaluates whether the two instances do not point to the same reference|

Back to business. Run Game.tk by clicking the run button to the left of the **main** function.

You can included a code _comment_, indicated by //

```kotlin
// This is a comment
```

Anything to the right of // is included in the comment and is ignored by the compiler, so you can use any syntaxys you want there.

## Listing 3.2 Modifying healthPoints (Game.kt)
```kotlin
fun main(args: Array<String>) { val name = "Madrigal"
~~~var healthPoints = 100~~~
var healthPoints = 89
    if (healthPoints == 100) {
        println(name + " is in excellent condition!")
} else {
        println(name + " is in awful condition!")
    }
}
```

## Listing 3.3 Checking for more player conditions (Game.kt)
```kotlin
fun main(args: Array<String>) {
    val name = "Madrigal"
    var healthPoints = 89
    if (healthPoints == 100) {
        println(name + " is in excellent condition!")
} else if (healthPoints >= 90) { println(name + " has a few scratches.")
    } else if (healthPoints >= 75) {
        println(name + " has some minor wounds.")
    } else if (healthPoints >= 15) {
        println(name + " looks pretty hurt.")
} else {
        println(name + " is in awful condition!")
    }
}
```

## Kotlin Logical operator

|Operator|Description|
|---|---|
|&&|Logical 'and' : true if and only if both are true (false otherwise)|
|'||'|Logical 'or' : true if either is true (false only if both are false)|
|!|Logical 'not' : true becomes false, false becomes true|

Incidentally, if you tired of keeping your code nicely indented as you make changes. IntelliJ is here to help. Select Code => Auto-Ident Lines and enjoy the simple pleasure of clean idents.

## Ranges

Kotlin provides _ranges_ to represent a lineas seriesof values.

The .. operator, as in in 1..5, signals a range. A range includes all values from the value on the leftof the .. operator to the value on teh rigth, so 1..5 includes 1,2,3,4 and 5. Ranges can also be a sequence of characteres.

You use the _in_ keyword to check whether a value is within a range.

## when Expressions

Then when espression is another control flow mechanism available in Kotlin. Like if/else, the when expression allows you to write conditions to check for and will execute corresponding code when the condition evaluates as true. when provides a more concise syntaxis and is an especially good fit for conditionals with three or more branches.


```kotlin
val race = "gnaome"
val faction = when (race) {
	"dwarf" -> "Keepers of the Mines"
	"gnome" -> "Keepers of the Mines"
	"orc" -> "Free people of the Rolling Hills"
	"human" -> "Free people of the Rolling Hills"
}
```
First, a val is declared, race. Next, a second val is declared: faction, whose value isdetermined with a when expression. The expression checks tha value of race against each of the values on the lefthand side of the -> operator (called the arrow), and when it finds a match it assigns faction the value on the righthand side. (-> is used differently in other langaujes -- and, is has other uses in Kotlin, as you will see later) 

A practical rule of thumb is that a when expression should replace an if/else expression if your code includes an else if branch.

A when expression work similarly to an if/else expression in that you define conditions and branches that are executed if a conditions is true. when is different in that it _scopes_ the lefthand side of the condition automatically to whatever you provide as an argument to when.

By the way, were you wondering abut the nested if/else in one branch of your when expression? This pattern is not very common, but Kotlin's when expression gives you all of flexibility that you need to implement it.


## String Templates

You have seen that a string can be built up with the values of variables and even the results of conditional expressions. Kotlin features _string templates_ to aid in this common need and, again, make your code more readable. Templates allow you to include the value of a variable inside a strig's quotation marks.


```kotlin
println (name + " " + otherVariable)
println ("$name $otherVariable")
```

This special symbol indicates to Kotlin that you would be like to template a val o var within a string you define, and it is provided as a convenience. Note that these templated values appeat inside the quotation marks that define the string.

Kotlin also allow you to evaluate an expression within a string and _interpolate_ the result -- that is, to insert the result into to string. Any expression that you add within the curl braces after a dollar-sign character (${}) will be evaluated as a part of the string. Add a report of the player's blessedness and aura color to the player status display to see how this works.

# 4. Functions

A _function_ is a reausable portion of code that accomplishes a specific task.

Control-click (click-right) on the code you selected and choose Refactor -> Extract -> Function...

## Anatomy of a Function

A function consist of a function header and function body


```kotlin
private fun formatHealthStatus(healhPoints: Int, isBlessed: Boolean): String {
	return healthStatus
}
```

## Function header

This first part of function is the function header. The function header is made up of five parts. the visibility modifier, function declaration keyword, function name , function parametert, and return type


```kotlin
// visibility modifier
private

// function declatartion keyword
fun

// function name 
formatHealthStatus

// function parameters
healthPoint: Int, isBlessed Boolean

//return type
String
```










```kotlin
  val emptyList = emptyList<Int>()
  println("emptyList.any() is ${emptyList.any()}")

  val nonEmptyList = listOf<Int>(1, 2, 3)
  println("nonEmptyList.any() is ${nonEmptyList.any()}")
```


```kotlin
  val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
  val firstOdd = numbers.find { it % 2 == 0 }
  val firstLast = numbers.findLast { it % 2 == 0 }
```

```kotlin
  val strings : List<String> = listOf("12a", "45", "", "3")
  val ints: List<Int> = strings.mapNotNull { it.toIntOrNull() }
  println(ints) // [45, 3]
  println(ints.sum()) // 48
```

```kotlin
  val map = mapOf("Alice" to 20, "Tom" to 13, "Bob" to 18 )
  val adults = map.mapNotNull { (name, age) -> name.takeIf { age >= 18 } }
  println(adults) // [Alice, Bob]
```
