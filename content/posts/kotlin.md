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

## Common functions in Kotlin

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

# 3. Conditionals

This lenguage feature is called _control flow_, and it allows yoy yo describe the conditions for when specific portions of your program should run.

Tip: Add a **main** entry point function to _program_kt_ by typing "main" and pressing the Tab key. Your function should look like this:


```kotlin
fun main(args: Array<String>){
	...
}
```

### Listing 3.1 Printing the player’s health condition (Game.kt)
```kotlin
fun main(args: Array<String>) {
>>    val name = "Madrigal"
>>    var healthPoints = 100
>>    if (healthPoints == 100) {
>>        println(name + " is in excellent condition!")
>>    } else {
>>        println(name + " is in awful condition!")
>>    }
}
```

You express this with the == _structural equality operator_. It can be read as "is equal to", so this statement reads "if healthPoint is equals to 100".

Using the addition operator (+) to append a value to a string is called _string concatenation_. It is an easy way to customize what is printed to the conole based on the value of variable.

### Table 3.1 Comparison operators

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

### Listing 3.2 Modifying healthPoints (Game.kt)
```kotlin
fun main(args: Array<String>) { 
    val name = "Madrigal"
<<  var healthPoints = 100
>>  var healthPoints = 89
    if (healthPoints == 100) {
        println(name + " is in excellent condition!")
    } else {
        println(name + " is in awful condition!")
    }
}
```

### Listing 3.3 Checking for more player conditions (Game.kt)
```kotlin
fun main(args: Array<String>) {
    val name = "Madrigal"
    var healthPoints = 89
    if (healthPoints == 100) {
        println(name + " is in excellent condition!")
>>  } else if (healthPoints >= 90) { println(name + " has a few scratches.")
>>  } else if (healthPoints >= 75) {
>>      println(name + " has some minor wounds.")
>>  } else if (healthPoints >= 15) {
>>      println(name + " looks pretty hurt.")
    } else {
        println(name + " is in awful condition!")
    }
}
```

### Listing 3.4 Checking for blessedness (Game.kt)
```kotlin
fun main(args: Array<String>) {
    val name = "Madrigal"
    var healthPoints = 89
>>  val isBlessed = true

        if (healthPoints == 100) {
            println(name + "is in excellent condition!")
        } else if (healthPoints >= 90) {
            println(name + " has a few scratches.")
        } else if (healthPoints >= 75) {
>>          if (isBlessed) {
>>              println(name + " has some minor wounds but is healing quite quickly!")
>>          } else {
                println(name + " has some minor wounds.")
            }
        } else if (healthPoints >= 15) {
            println(name + " looks pretty hurt.")
        } else {
            println(name + " is in awful condition!")
        }
}
```

### Listing 3.5 Using logical operators in a conditional (Game.kt)
```kotlin
fun main(args: Array<String>) {
    val name = "Madrigal"
    var healthPoints = 89
    val isBlessed = true
>>  val isImmortal = false

>>  // Aura
>>  if (isBlessed && healthPoints > 50 || isImmortal) {
>>      println("GREEN")
>>  } else {
>>      println("NONE")
>>  }

    if (healthPoints == 100) {
        ...
    }
}
```

### Table 3.2 Logical operator

|Operator|Description|
|---|---|
|&&|Logical 'and' : true if and only if both are true (false otherwise)|
|'||'|Logical 'or' : true if either is true (false only if both are false)|
|!|Logical 'not' : true becomes false, false becomes true|

Incidentally, if you tired of keeping your code nicely indented as you make changes. IntelliJ is here to help. Select Code => Auto-Ident Lines and enjoy the simple pleasure of clean idents.


### Listing 3.6 Using logical operators in the declaration of a variable (Game.kt)
```kotlin
fun main(args: Array<String>) {
    ...
    // Aura
<<  if (isBlessed && healthPoints > 50 || isImmortal) {
>>  val auraVisible = isBlessed && healthPoints > 50 || isImmortal
>>  if (auraVisible) {
        println("GREEN")
    } else {
        println("NONE")
    }
    ... 
}
```

### Listing 3.7 Using a conditional expression (Game.kt)
```kotlin
fun main(args: Array<String>) {
    ...
<<  if (healthPoints == 100) {
>>    val healthStatus = if (healthPoints == 100) {
>>        println(name + "is in excellent condition!")
        "is in excellent condition!"
    } else if (healthPoints >= 90) {
<<      println(name + " has a few scratches.")
>>      "has a few scratches."
    } else if (healthPoints >= 75) {
    if (isBlessed) {
<<      println(name + " has some minor wounds but is healing quite quickly!")
>>      "has some minor wounds but is healing quite quickly!"
        } else {
<<          println(name + " has some minor wounds.")
>>          "has some minor wounds."
        }
    } else if (healthPoints >= 15) {
<<      println(name + " looks pretty hurt.")
>>      "looks pretty hurt."
    } else {
<<      println(name + " is in awful condition!")
>>      "is in awful condition!"
    }
>>  // Player status
>>  println(name + " " + healthStatus)
}
```


### Listing 3.8 Improving aura code with a conditional expression (Game.kt)
```kotlin
...
// Aura
val auraVisible = isBlessed && healthPoints > 50 || isImmortal 
<<  if (auraVisible) {
<<      println("GREEN")
<<  } else {
<<      println("NONE")
<<  }
>>  val auraColor = if (auraVisible) "GREEN" else "NONE" 
>>  println(auraColor)
...
```

## Ranges

Kotlin provides _ranges_ to represent a lineas seriesof values.

The .. operator, as in in 1..5, signals a range. A range includes all values from the value on the leftof the .. operator to the value on teh rigth, so 1..5 includes 1,2,3,4 and 5. Ranges can also be a sequence of characteres.

You use the _in_ keyword to check whether a value is within a range.

### Listing 3.9 Refactoring healthStatus with ranges(Game.kt)
```kotlin
fun main(args: Array<String>) {
    ...
    val healthStatus = if (healthPoints == 100) {
            "is in excellent condition!"
<<      } else if (healthPoints >= 90) {
>>      } else if (healthPoints in 90..99) {
            "has a few scratches."
<<      } else if (healthPoints >= 75) {
>>      } else if (healthPoints in 75..89) {
            if (isBlessed) {
                "has some minor wounds but is healing quite quickly!"
            } else {
                "has some minor wounds."
            }
<<      } else if (healthPoints >= 15) {
>>      } else if (healthPoints in 15..74) {
            "looks pretty hurt."
        } else {
            "is in awful condition!"
        }
}
```


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

## Listing 3.10 Refactoring healthStatus with when (Game.kt)

```kotlin
fun main(args: Array<String>) {
    ...
<<  val healthStatus = if (healthPoints == 100) {
<<          "is in excellent condition!"
<<      } else if (healthPoints in 90..99) {
<<          "has a few scratches."
<<      } else if (healthPoints in 75..89) {
<<          if (isBlessed) {
<<              "has some minor wounds but is healing quite quickly!"
<<          } else {
<<              "has some minor wounds."
<<          }
<<      } else if (healthPoints in 15..74) {
<<          "looks pretty hurt."
<<      } else {
<<          "is in awful condition!"
<<      }

>>    val healthStatus = when (healthPoints) {
>>        100 -> "is in excellent condition!"
>>        in 90..99 -> "has a few scratches."
>>        in 75..89 -> if (isBlessed) {
>>            "has some minor wounds but is healing quite quickly!"
>>        } else {
>>            "has some minor wounds."
>>        }
>>        in 15..74 -> "looks pretty hurt."
>>        else -> "is in awful condition!"
>>    }
}
```


## String Templates

You have seen that a string can be built up with the values of variables and even the results of conditional expressions. Kotlin features _string templates_ to aid in this common need and, again, make your code more readable. Templates allow you to include the value of a variable inside a strig's quotation marks.


```kotlin
println (name + " " + otherVariable)
println ("$name $otherVariable")
```

## Listing 3.11 Using a string template (Game.kt)

```kotlin
fun main(args: Array<String>) {
    ...
    // Player status
<<  println(name + " " + healthStatus)
>>  println("$name $healthStatus")
}
```

This special symbol indicates to Kotlin that you would be like to template a val o var within a string you define, and it is provided as a convenience. Note that these templated values appeat inside the quotation marks that define the string.

Kotlin also allow you to evaluate an expression within a string and _interpolate_ the result -- that is, to insert the result into to string. Any expression that you add within the curl braces after a dollar-sign character (${}) will be evaluated as a part of the string. Add a report of the player's blessedness and aura color to the player status display to see how this works.

## Listing 3.12 Formatting the isBlessed status with a string expression (Game.kt)
```kotlin
fun main(args: Array<String>) {
    ...
    // Aura
    val auraVisible = isBlessed && healthPoints > 50 || isImmortal 
    val auraColor = if (auraVisible) "GREEN" else "NONE" 
<<  print(auraColor)
    ...
    // Player status
>>  println("(Aura: $auraColor) " +
>>          "(Blessed: ${if (isBlessed) "YES" else "NO"})")
        println("$name $healthStatus")
}
```

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

private fun formatHealthStatus(healthPoint: Int, isBlessed Boolean); String{
    return healthStatus
}

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

## Listing4.1 Adding a castFireball function (Game.kt)

```kotlin
...
    private fun auraColor(isBlessed: Boolean,
                        healthPoints: Int,
                        isImmortal: Boolean): String {
        val auraVisible = isBlessed && healthPoints > 50 || isImmortal
        val auraColor = if (auraVisible) "GREEN" else "NONE"
        return auraColor
    }

>>  private fun castFireball() {
>>      println("A glass of Fireball springs into existence.")
>>  }
```

## Listing 4.2 Calling castFireball (Game.kt)
```kotlin
fun main(args: Array<String>) {
    ...
    // Player status
    printPlayerStatus(auraColor, isBlessed, name, healthStatus)
>>  castFireball()
} ...
```

## Listing 4.3 Adding a numFireballs parameter (Game.kt)
```kotlin
fun main(args: Array<String>) {
    ...
    // Player status
    printPlayerStatus(auraColor, isBlessed, name, healthStatus)
<<  castFireball()
>>  castFireball(5)
}
...
<<  private fun castFireball() {
>>  private fun castFireball(numFireballs: Int) {
<<      println("A glass of Fireball springs into existence.")
>>        println("A glass of Fireball springs into existence. (x$numFireballs)")
}
```
## Default Arguments

### Listing 4.4 Giving the numFireballs parameter a default value(Game.kt)
```kotlin
fun main(args: Array<String>) {
    ...
    // Player status
    printPlayerStatus(auraColor, isBlessed, name, healthStatus)
    castFireball(5)
}
...
<<  private fun castFireball(numFireballs: Int) {
>>  private fun castFireball(numFireballs: Int = 2) {
        println("A glass of Fireball springs into existence. (x$numFireballs)")
    }
```


### Listing 4.5 Using castFireball’s default argument value (Game.kt)
```kotlin
fun main(args: Array<String>) {
    ...
    // Player status
    printPlayerStatus(auraColor, isBlessed, name, healthStatus)

<<  castFireball(5)
>>  castFireball()
} 
...
```


### Listing 4.6 Using optional single-expression function syntax (Game.kt)
```kotlin
    ...
<<  private fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean): String {
<<      val healthStatus = when (healthPoints) {
>>  private fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean) =
>>          when (healthPoints) {
                100 -> "is in excellent condition!"
                in 90..99 -> "has a few scratches."
                in 75..89 -> if (isBlessed) {
                    "has some minor wounds, but is healing quite quickly!"
                } else {
                    "has some minor wounds."
                }
                in 15..74 -> "looks pretty hurt."
                else -> "is in awful condition!"
            }
<<      return healthStatus
<<  }
    ...
<<  private fun castFireball(numFireballs: Int = 2)  {
>>  private fun castFireball(numFireballs: Int = 2) =
        println("A glass of Fireball springs into existence. (x$numFireballs)")
<<  }
```

## Unit Functions

Not all functions return a value. Some use side effects instead to do their work, like modifying the state of a variable or calling other functions that yield system output.

```kotlin
private fun castFireball(numFireballs: Int = 2) = 
    println("A glass of Fireball springs into existence. (x$numFireballs)")
```

Kotlin uses the _Unit_ return type to signify exactly this: a function that returns no value. If the return keyword is not used, it is implicit that the return type for that function is Unit.

## Named Function Aguments

Take a look at how you call the printPlayerStatus function, passing arguments as parameters:

```kotling
printPlayerStatus("NONE", true, "Mandrigal", status)
```

Another way you could call the same function is:

```kotlin
printPlayerStatus(auraColor = "NONE",
                  isBlessed = true,
                  name = "Mandrigal",
                  healthStatus = status)
```

This optional syntax uses a _named function arguments_ and is an alternative way to provide arguments to a function. Using named arguments frees you to pass the argument to the function in whatever order you would like. For example, you could also call *printPlayerStatus like this:

```kotlin
printPlayerStatus(healthStatus = status,
                  auraColor = "NONE",
                  name = "Mandrigal",
                  isBlessed = true)
```

# 5. Anonymous Functions and the Function Type

Functions defined without a name, called _anonymous functions_, are similar, with two major differences: Anonymous functions have no name as part of their definition, an they interact with the rest of your code a little different in that they are commonly passed to or returned from other functions.

## Anonymous Functions

An anonymous function lets you describe additional rules for a standar library function so that you can customize its behavior.

One of meny functions in teh standard library is __count__. When called on a string, __count__ return the total number of letters in the string. The following code counts the letters in the string "Mississippi"

```kotlin
val numLetters = "Mississippi".count()
println(numLetters)
// Prints 11
```

But what if you wanted to count only a specific character in "Mississippi, say the letter "s". the kotlin standard library allows you to provide rules to the __count__ function to determine whether a letter should be counted. You describe the rules for the function by providing an anonymous function as an argument:

```kotlin
val numLetters = "Mississippi".count({ letter ->
    letter == 's'
})
println(numLetters)
// Prints 4
```

### Listing 5.1 Defining an anonymous greeting function (SimVillage.kt)
```kotlin
fun main(args: Array<String>) {
    println({
        val currentYear = 2018
        "Welcome to SimVillage, Mayor! (copyright $currentYear)"
    }())
}
```

Outside the anonymous function's closing brace, you call function with a pair of empty parentheses.

## The function type

Anonymous functions also have a type, called the __function type__. Variables of the function type can hold an anonymous function as their value, and the function can then be passed around your code like any other variable.

### Listing 5.2 Assigning the anonymous function to a variable (SimVillage.kt)
```kotlin
fun main(args: Array<String>) {
<<  println({
>>  val greetingFunction: () -> String = {
>>      val currentYear = 2018
>>      "Welcome to SimVillage, Mayor! (copyright $currentYear)"
>>  }
<<  })()
    println(greetingFunction())
}
```

### Figure 5.1 Function type sintaxis
```kotlin
    fun greetingFunction():   String
                        v       v
                        () -> String 
```
A function type definition consists of two parts: the function's parameters, in parentheses, followed by its return type, delimited by the arrow (->), as show in Figure 5.1

## Implicit returns

Maybe you have noticed that there is no return keyword within the anonymous function you defined:
```kotlin
    val greeetingFunction: () -> String = {
        val currentYear = 2018
        "Welcome to SimVillage, Mayor (copyrigth $currentYear)"
    }
```

## Function arguments

Like a named function, an anonymous function can accept zero, one or multiple argument of any type. The parameters an anonymous function accepts are indicated by type in the function type definition and then named in the anonymous functions's definition.

### Listing5.3 Adding a playerName parameter to the anonymous function (SimVillage.kt)
```kotlin
fun main(args: Array<String>) {
<<  val greetingFunction: () -> String = {
>>  val greetingFunction: (String) -> String = { playerName ->
        val currentYear = 2018
<<      "Welcome to SimVillage, Mayor! (copyright $currentYear)"
>>      "Welcome to SimVillage, $playerName! (copyright $currentYear)"
    }
<<  println(greetingFunction())
>>  println(greetingFunction("Guyal"))
}
```

## The it keyword

When defining anonymous functions that accept exactly one argument, the it keyword is available as a convenient alternative to specifying the parameter name.

### Listing 5.4 Using the it keyword (SimVillage.kt)
```kotlin
fun main(args: Array<String>) {
<<  val greetingFunction: (String) -> String = { playerName ->
>>  val greetingFunction: (String) -> String = {
        val currentYear = 2018
<<      "Welcome to SimVillage, $playerName! (copyright $currentYear)"
>>      "Welcome to SimVillage, $it! (copyright $currentYear)"
    }
    println(greetingFunction("Guyal"))
}
```

## Acceptig multiple arguments
While the _it_ syntaxis is available for an anonymous function that accept one argument, it is not allowed when there is more than one argument, However, anonymous functions can certainly accept multiplen named arguments.

### Listing 5.5 Accepting a second argument (SimVillage.kt)
```kotlin
fun main(args: Array<String>) {
<<  val greetingFunction: (String) -> String = {
>>  val greetingFunction: (String, Int) -> String = { playerName, numBuildings ->
        val currentYear = 2018
>>      println("Adding $numBuildings houses")
<<      "Welcome to SimVillage, $it! (copyright $currentYear)"
>>      "Welcome to SimVillage, $playerName! (copyright $currentYear)"
    }
<<  println(greetingFunction("Guyal"))
>>  println(greetingFunction("Guyal", 2))
}
```

## Type inference Support
Kotlin's type inference rules behave exactly the same with function types as they do with the types you met earlier in thie book: If a variabe is given an anonymous function as its value when it is declared no explicit tyoe definition is needed.

### Listing 5.6 Using type inference for greetingFunction (SimVillage.kt)
```kotlin
fun main() {
<<  val greetingFunction: (String, Int) -> String = { playerName, numBuildings ->
>>  val greetingFunction = { playerName: String, numBuildings: Int ->
        val currentYear = 2018
        println("Adding $numBuildings houses")
        "Welcome to SimVillage, $playerName! (copyright $currentYear)"
    }
    println(greetingFunction("Guyal", 2))
}
```

## Defining a Function that accpets a function

The book refers to anonymous functions as lambdas and their definitions as lambda expressions.

### Listing 5.7 Adding the runSimulation function (SimVillage.kt)
```kotlin
fun main(args: Array<String>) {
    val greetingFunction = { playerName: String, numBuildings: Int ->
        val currentYear = 2018
        println("Adding $numBuildings houses")
        "Welcome to SimVillage, $playerName! (copyright $currentYear)"
    }
<<  println(greetingFunction("Guyal", 2))
>>  runSimulation("Guyal", greetingFunction)
}

>>  fun runSimulation(playerName: String, greetingFunction: (String, Int) -> String) {
>>      val numBuildings = (1..3).shuffled().last()   // Randomly selects 1, 2, or 3
>>      println(greetingFunction(playerName, numBuildings))
>>  } 
```

## Shorthand syntaxis
When a function accepts a function type for its last parameter, you can also aomit the parenthesesaroung the lambda argument.

```kotlin
"Mississippi".count({it == 's'})
```
Can also written this way
```kotlin
"Mississippi".count {it == 's'}
```
### Listing 5.8 Passing a lambda with the shorthand syntax (SimVillage.kt)
```kotlin
fun main(args: Array<String>) {
<<  val greetingFunction = { playerName: String, numBuildings: Int ->
>>  runSimulation("Guyal") { playerName, numBuildings ->
        val currentYear = 2018
        println("Adding $numBuildings houses")
        "Welcome to SimVillage, $playerName! (copyright $currentYear)"
    }
}

fun runSimulation(playerName: String, greetingFunction: (String, Int) -> String) {
   val numBuildings = (1..3).shuffled().last()   // Randomly selects 1, 2, or 3
   println(greetingFunction(playerName, numBuildings))
}
```

## Function Inlining

Lambda are useful because they enable a high degree of felxibility in how your programs can be written. However, that flexibility comes at a cost.

When you define a lambda, it is represented as an object instancce on the JVM. The JVM alse performs memory allocations for all variables accesible to the lambda, and this behavior comes with associated memory costs. As a result, lambdas introduce memory overhead that can in turn cause a performance impact - and such performance impacts are to be avoided.

The inline a lambda, you mark the function that accpets the lambda using the _inline_ keyword.

### Listing5.9 Using the inline keyword (SimVillage.kt)

```kotlin
...
inline fun runSimulation(playerName: String,
                         greetingFunction: (String, Int) -> String) {
    val numBuildings = (1..3).shuffled().last()   // Randomly selects 1, 2, or 3
    println(greetingFunction(playerName, numBuildings))
}
```

## Function References

So far, you have defined lambdas to provide a function as an argument to another function. There is another way to do so: by passing a —function reference_. A function reference converts a named function (a function defined using the fun keyword) to a value that can be passed as an argument. Tou can use a function reference anywhere you use a lamnda expresion.

### Listing 5.10 Defining the printConstructionCost function (SimVillage.kt)
```kotlin
...
inline fun runSimulation(playerName: String,
                        greetingFunction: (String, Int) -> String) {
    val numBuildings = (1..3).shuffled().last()   // Randomly selects 1, 2, or 3
    println(greetingFunction(playerName, numBuildings))
}

>>  fun printConstructionCost(numBuildings: Int) {
>>      val cost = 500
>>      println("construction cost: ${cost * numBuildings}")
>>  }
```

### Listing 5.11 Adding a costPrinter parameter (SimVillage.kt)
```kotlin
...
<<  inline fun runSimulation(playerName: String,
<<                           greetingFunction: (String, Int) -> String) {
>>  inline fun runSimulation(playerName: String,
>>                           costPrinter: (Int) -> Unit,
                             greetingFunction: (String, Int) -> String) {
        val numBuildings = (1..3).shuffled().last()   // Randomly selects 1, 2, or 3
        costPrinter(numBuildings)
        println(greetingFunction(playerName, numBuildings))
    }
    
    fun printConstructionCost(numBuildings: Int) {
        val cost = 500
        println("construction cost: ${cost * numBuildings}")
    }
```

to obtain a function reference, you use the :: operator with the function name you would like a reference for.

### Listing 5.12 Passing a function reference (SimVillage.kt)
```kotlin
fun main(args: Array<String>) {
<<  runSimulation("Guyal") { playerName, numBuildings ->
>>  runSimulation("Guyal", ::printConstructionCost) { playerName, numBuildings ->
        val currentYear = 2018
        println("Adding $numBuildings houses")
        "Welcome to SimVillage, $playerName! (copyright $currentYear)"
    } 
}
...
```

## Function Type as return type

Like any other type, the function type is also a valid return type, meaning you can define a function that returns a function

### Listing5.13 Adding the configureGreetingFunction function (SimVillage.kt)

```kotling
fun main(args: Array<String>) {
<<  runSimulation("Guyal", ::printContructionCost) { playerName, numBuildings ->
<<      val currentYear = 2018
<<      println("Adding $numBuildings houses")
<<      "Welcome to SimVillage, $playerName! (copyright $currentYear)"
<<  }
>>  runSimulation()
}

<<inline fun runSimulation(playerName: String,
<<                        costPrinter: (Int) -> Unit,
<<                        greetingFunction: (String, Int) -> String) {
<<    val numBuildings = (1..3).shuffled().last()   // Randomly selects 1, 2, or 3
<<    costPrinter(numBuildings)
<<    println(greetingFunction(playerName, numBuildings))
>>fun runSimulation() {
>>    val greetingFunction = configureGreetingFunction()
>>    println(greetingFunction("Guyal"))
}

>>fun configureGreetingFunction(): (String) -> String {
>>    val structureType = "hospitals"
>>    var numBuildings = 5
>>    return { playerName: String ->
>>        val currentYear = 2018
>>        numBuildings += 1
>>        println("Adding $numBuildings $structureType")
>>        "Welcome to SimVillage, $playerName! (copyright $currentYear)"
>>    } 
>>}
```

# 6. Null safety and exceptions

Null is a especial value that indicates that the value of a var does not exists

## Nullability

Some elements in Kotlin can be assigned a value of null, and some cannot. We say thta the former are _nullable_ and the latter are _non-nullable_

### Listing 6.1 Reassigning a var’s value to null (Tavern.kt)
```kotlin
fun main(args: Array<String>) {
    var signatureDrink = "Buttered Ale"
    signatureDrink = null
}
```

Null can not be a value of a non-null type String

## Kotlin's Explicit null type

NullPointerExceptions like the one that you say above should be avoided ata ll costs.

### Listing 6.2 Defining a nullable variable (Tavern.kt)
```kotlin
fun main(args: Array<String>) {
<<  var signatureDrink = "Buttered Ale"
<<  signatureDrink = null
>>  var beverage = readLine()
>>  println(beverage)
}
```

This means that assigning beverage to a null value will indeed compile

### Listing 6.3 Reassigning a variable to null (Tavern.kt)
```kotlin
fun main(args: Array<String>) { 
    var beverage = readLine() 
>>  beverage = null
    
    println(beverage)
}
```

### Listing 6.4 Restoring service (Tavern.kt)
```kotlin
fun main(args: Array<String>) { 
    var beverage = readLine() 
<<  beverage = null
>>  // beverage = null
   
    println(beverage)
}
```

## Compile Time vs Runtime

Kotlin is a _compiler language_, meaning that your program is translated into machine-language instructions prior to execution by a special program, called the compiler. During this step, the compiler ensures that certain requirements are met by you code before the instructions are generated

Errors caught at compiler time are called _compile-time errors_, and they are one of the adventages of working with kotlin.

On the other hand, a _runtime error_ us a mistake that happends after the program has compiled and is already running, because the compuler was unable to dicovery it.

## Null Safety

Because Kotlin distinguishes between multiple nullable and non-nullable types, the compiler is aware of the possibly dangerous situation of asking a variable defined as a nullable type to do something when the variable might not exists.

### Listing 6.5 Using a nullable variable (Tavern.kt)
```kotlin
fun main(args: Array<String>) {
<<  var beverage = readLine()
>>  var beverage = readLine().capitalize()
//   beverage = null
    
    println(beverage)
}
```

## Option one: the safe call operator

Sometimes, nothing but a nullable type will do. For example, when you are working with a variable from code you do not control, you cannot be sure that it eill not return null. In cases like that, your first option is to use the _safe call operator_ __(?.)__ in your function call.

### Listing 6.6 Using the safe call operator (Tavern.kt)
```kotlin
fun main(args: Array<String>) {
<<  var beverage = readLine().capitalize()
>>  var beverage = readLine()?.capitalize()
//   beverage = null
    println(beverage)
}
```

## Using safe calls with let

__Let__ provides its own function scope, you can use a safe call with __let__ to scope multiple expressions that each require the variable that they are called on to be non-null.

### Listing 6.7 Using __let__ with the safe call operator(Tavern.kt)

```kotlin
fun main(args: Array<String>) {
<<  var beverage = readLine()?.capitalize()
>>  var beverage = readLine()?.let {
>>      if (it.isNotBlank()) {
>>          it.capitalize()
>>      } else {
>>          "Buttered Ale"
>>      }
>>  }
//  beverage = null
println(beverag
```

This time you assign its value to the result of safely calling let on it. When bevereage is not null and __let__ is invoked, everything withit the anonymous function passed to __let__ is evaluated: The input from __readline__ is checkef to see whether it is blank; if it is not blank it is capitalized, and if it is blank, then a fallback beverage name, "Buttered Ale", is returned instead. Both __isNotBlank__  and __capitalize__ require the beverage name to be non-null, which is guaranteed by __let__

## Option two: the double-bang operator

The double-bang operator (!!.) can be used to call a function on a nullable type . But be forewarned. This is a much drastic option than the safe call operator and should generally not be used. If you use !!., you are proclaming tot he compiler: "If I ask nonexistent thing to do something, I DEMAND that you throw a null pointer exception!!"

By the way, its official name is the _non-null assertion operator_, but is more often called the double-bang operator.

### Listing 6.8 Using the double-bang operator (Tavern.kt)

```kotlin
fun main(args: Array<String>) {
<<  var beverage = readLine()?.let {
<<      if (it.isNotBlank()) {
<<          it.capitalize()
<<      } else {
<<          "Buttered Ale"
<<      }
<<  }

>>  var beverage = readLine()!!.capitalize()
    // beverage = null
    println(beverage)
```

I don't care whether beverage is null; capitalize it anyway!. If beverage is indeed null, a KotlinNullPointerException us thrown.

## Option three: checking whether a value is null with if

A third option for working safely with null values is to check whether a value is null a condition for executing an __if__ branch

### Listing 6.9 Using != null for null checking (Tavern.kt)

```kotlin
fun main(args: Array<String>) {
<<  var beverage = readLine()!!.capitalize()
>>  var beverage = readLine()
    // beverage = null
>>  if (beverage != null) {
>>      beverage = beverage.capitalize()
>>  } else {
>>      println("I can't do that without crashing - beverage was null!")
>>  }
  
    println(beverage)

}
```
## The null coalescing operator

Another way to check for null values is to use kotlin's _null coalescing operator_ __?:__ also know as the "Elvis operator". this operator says: "If the thing on the lefthand side of me is null, do the thing on the righthand side instead".

### Listing 6.10 Using the null coalescing operator (Tavern.kt)

```kotlin
fun main(args: Array<String>) {
    var beverage = readLine()
    // beverage = null
    if (beverage != null) {
        beverage = beverage.capitalize()
    } else {
        println("I can't do that without crashing - beverage was null!")
    }

<<  println(beverage)
>>  val beverageServed: String = beverage ?: "Buttered Ale"
>>  println(beverageServed)
}
```

## Exceptions

Like many others languages, kotlin laso includes _exceptions_ to indicate that something went wrong in you program

### Listing 6.11 Adding sword juggling logic (SwordJuggler.kt)

```kotlin
fun main(args: Array<String>) {
    var swordsJuggling: Int? = null
    val isJugglingProficient = (1..3).shuffled().last() == 3
    if (isJugglingProficient) {
        swordsJuggling = 2
    }
    println("You juggle $swordsJuggling swords!")
}
```

### Listing 6.12 Adding a third sword (SwordJuggler.kt)

```kotlin
fun main(args: Array<String>) {
    var swordsJuggling: Int? = null
    val isJugglingProficient = (1..3).shuffled().last() == 3
    if (isJugglingProficient) {
        swordsJuggling = 2
    }
    swordsJuggling = swordsJuggling!!.plus(1)
    println("You juggle $swordsJuggling swords!")
}
```

## Throwing an exception

Similar to many languages, Kotlin allows you to manually signal that an exception has occurred, you do this with the _throw_ operator and it is calle throwing an exception.

### Listing6.13 Throwing an IllegalStateException(SwordJuggler.kt)
```kotlin
fun main(args: Array<String>) {
    var swordsJuggling: Int? = null
    val isJugglingProficient = (1..3).shuffled().last() == 3
    if (isJugglingProficient) {
        swordsJuggling = 2
    }
>>  proficiencyCheck(swordsJuggling)
    swordsJuggling = swordsJuggling!!.plus(1)
    println("You juggle $swordsJuggling swords!")
}

>>  fun proficiencyCheck(swordsJuggling: Int?) {
>>      swordsJuggling ?: throw IllegalStateException("Player cannot juggle swords")
>>  }
```

## Custom exceptions

You have now seen how to use the throw operator  to signal that an exception has occurred. The exception you just threw, IllegalStateException, indicates that an illegal state has ocurres and gives  you the opportunity to add more information by passing a string to be printed when the exception is thrown.

### Listing 6.14 Defining a custom exception (SwordJuggler.kt)
```kotlin
  fun main(args: Array<String>) {
  ...   
  }
  fun proficiencyCheck(swordsJuggling: Int?) {
      swordsJuggling ?: throw IllegalStateException("Player cannot juggle swords")
  }

>> class UnskilledSwordJugglerException() :
>>         IllegalStateException("Player cannot juggle swords")
```

### Listing 6.15 Throwing a custom exception (SwordJuggler.kt)
```kotlin
    fun main(args: Array<String>) {
        ... 
    }
    fun proficiencyCheck(swordsJuggling: Int?) {
<<      swordsJuggling ?: throw IllegalStateException("Player cannot juggle swords")
>>      swordsJuggling ?: throw UnskilledSwordJugglerException()
    }
    class UnskilledSwordJugglerException() :
        IllegalStateException("Player cannot juggle swords")
```

## Handling exceptions

Exceptions are disruptive, and they should by - they represent a state that ud unrecoverable unless ut is handled. Kotlin allows you to specify how to handle exceptions by defining a _try/catch_ statement arounf the code that might cause one.

### Listing6.16 Addingatry/catchstatement(SwordJuggler.kt)
```kotlin
fun main(args: Array<String>) {
    var swordsJuggling: Int? = null
    val isJugglingProficient = (1..3).shuffled().last() == 3
    if (isJugglingProficient) {
        swordsJuggling = 2
    }
>>  try {
>>      proficiencyCheck(swordsJuggling)
>>      swordsJuggling = swordsJuggling!!.plus(1)
>>  } catch (e: Exception) {
>>      println(e) 
>>  }
    println("You juggle $swordsJuggling swords!")
}

fun proficiencyCheck(swordsJuggling: Int?) {
    swordsJuggling ?: throw UnskilledSwordJugglerException()
}

class UnskilledSwordJugglerException() :
        IllegalStateException("Player cannot juggle swords")
```

## Preconditions

Unexpected values can cause your program to behave in unintended way. As a developer, you will spend plenty of time validating input to endure you are working with the calues you intend. some sources of exceptions are common, like unexpected null values.

These functions are called _precondition functions_, because they allow you to define preconditions - conditions that must be true before some piece of code is executed.

### Listing 6.17 Using a precondition function (SwordJuggler.kt)
```kotlin
fun main(args: Array<String>) {
    var swordsJuggling: Int? = null
    val isJugglingProficient = (1..3).shuffled().last() == 3
    if (isJugglingProficient) {
        swordsJuggling = 2
    }
    try {
        proficiencyCheck(swordsJuggling)
        swordsJuggling = swordsJuggling!!.plus(1)
    } catch (e: Exception) {
        println(e) 
    }
    println("You juggle $swordsJuggling swords!")

}
fun proficiencyCheck(swordsJuggling: Int?) {
<<  swordsJuggling ?: throw UnskilledSwordJugglerException()
>>  checkNotNull(swordsJuggling, { "Player cannot juggle swords" })
}

class UnskilledSwordJugglerException() :
        IllegalStateException("Player cannot juggle swords")
```

Table 6.1 Kotlin precondition functions

| Function  | Description |
|---|---|
| checkNotNull  | Throws an IllegalStateException if argument is null, Otherwise return the non-null value. |
| require | Throw as IllegalArgumentException if argument is false. |
| requireNotNull | Throws an IllegalArgumentException if argument is null, Otherwise returns the non-null value. |
| error | Throw an IllegalArgumentException with a provided message if argument is null,. Otherwise return the non-null value. |
| assert | Throws an AssertionError if argument is false and the assertion compiler flag is enabled |


# 7. Strings

In programming, textual data is represented by _strings_ -ordered sequences of characteres.

## Extracting Substrings

### Substrings

### Listing 7.1 Extracting the tavern master’s name (Tavern.kt)
```kotlin
>>  const val TAVERN_NAME = "Taernyl's Folly"

fun main(args: Array<String>) {
<<  var beverage = readLine()
<<  // beverage = null
<<  if (beverage != null) {
<<      beverage = beverage.capitalize()
<<  } else {
<<      println("I can't do that without crashing - beverage was null!")
<<  }
<<  val beverageServed: String = beverage ?: "Buttered Ale"
<<  println(beverageServed)
    placeOrder()
}
>>  private fun placeOrder() {
>>     val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
>>     val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
>>     println("Madrigal speaks with $tavernMaster about their order.")
>>  }
```

The list of sdiferents escapes sequences (consisting of \ abd the character being escaped) and their meaning to the compiler.

### Table 7.1 Escape sequences
| Escape sequence | Meaning |
|---|---|
| \t | Tab character |
| \b | Backspace character |
| \n | Newline character |
| \r | Carrier return |
| \" | Double quotation mark |
| \' | Single quotation mark/apostrophe |
| \\ | Backslash |
| \$ | Dollar sign |
| \u | Unicode character |

## split

Creates a series of substrings using a delimiter you provide. Accepts a delimiter character to look for and retuns a list of the resulting substrings with the delimiter omitted, in this case , split, returns a list of strings in the order it found them. You use indices in square brackets. 


### Listing7.2 Passing tavern data to placeOrder (Tavern.kt)
```kotlin
const val TAVERN_NAME = "Taernyl's Folly"

fun main(args: Array<String>) {
    placeOrder("shandy,Dragon's Breath,5.91") 
}

private fun placeOrder(menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe) 
    println("Madrigal speaks with $tavernMaster about their order.")
}
```

### Listing 7.3 Splitting the menu data (Tavern.kt)
```kotlin
...
private fun placeOrder(menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("Madrigal speaks with $tavernMaster about their order.")

>>  val data = menuData.split(',')
>>  val type = data[0]
>>  val name = data[1]
>>  val price = data[2]
>>  val message = "Madrigal buys a $name ($type) for $price."
>>  println(message)
}
```

Because __split__ returns a list, it also supports simplified syntax called _destructuring_ - a feature that allows you to declare and assign multiple variables in a single expression.

### Listing 7.4 Destructuring the menu data (Tavern.kt)
```kotlin
...

private fun placeOrder(menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("Madrigal speaks with $tavernMaster about their order.")

<<  val data = menuData.split(',')
<<  val type = data[0]
<<  val name = data[1]
<<  val price = data[2]

    val (type, name, price) = menuData.split(',')
    val message = "Madrigal buys a $name ($type) for $price."
    println(message)
}
```
## String Manipulation

### Replace

The version of the __replace__ function you used accepts two arguments. The first argument is a __regular expression__ that determines which characteres you want to replace, A regular expression, or __regex__, defines a search pattern for characters you want to look for.

__Regex__ accpets a pattern argument, "[aeiou]", that defines the characters you want to match and replace. Kotlin uses tha same regular expression patterns as Java

### Listing 7.5 Defining the __toDragonSpeak__ function (Tavern.kt)
```kotlin
const val TAVERN_NAME = "Taernyl's Folly"

fun main(args: Array<String>) {
    placeOrder("shandy,Dragon's Breath,5.91")
}

>>private fun toDragonSpeak(phrase: String) =
>>    phrase.replace(Regex("[aeiou]")) {
>>        when (it.value) {
>>            "a" -> "4"
>>            "e" -> "3"
>>            "i" -> "1"
>>            "o" -> "0"
>>            "u" -> "|_|"
>>            else -> it.value
>>        } 
>>    }

private fun placeOrder(menuData: String) {
    ...
    println(message)

>>  val phrase = "Ah, delicious $name!"
>>  println("Madrigal exclaims: ${toDragonSpeak(phrase)}")
}
```

## Strings are immutable

Whether they are defined with _var_ or _val_, all strings in Kotlin are actually immutable (as they are in Java). Though the variables that hold the value for the String can be reassigned if the string is a var, the string instance itself an never be changed. Any function that appears to change teh value of a string (like replace) actually creates a new string with the change applied to it.

## String Comparison

You checked the _structural equality_ of name and "Dragon's Breath" using the strucutral equality operator, ==. You have seen this operator before, used with numeric values. When used with strings, it checks that the characters in each string match one another and are in the same order.

There is another way to check the equality of two variables: _comparing referential equality_, wich means checking that two variables share the same reference to a type instance - in other words, that two variables point to same object on the heap. Referential equality is checked using ===.

Referential comparison is not usually what you want. You generally donot care whether strings are different instances, only that they have the same characters in the same sequences 

# 8. Numbers

Kotlin has a variety of types for dealing with numbers and numeric computations. Multiple types are available for each of two main varieties of numbers that Kotlin can work with: whole-number integers and numbers with decimals. 

## Numeric Types

All numeric types in kotlin, as in Java , are _signed_, meaning they can represent both positive and negative number. In addition to whether they support decimal values, the numeric types differ in the number of bits they are allocated in memory and, consequently, their minimum and maximum values.

Table 8.1 Commonly used numeric types.

| Type | Bits | Max Value | Min Value |
|---|---|---|---|
| Byte | 8 | 127 | -128 |
| Short | 16 | 32767 | -32768 |
| Int | 32 | 2147483647 | -2147483648 |
| Long | 64 | 9223372036854775807 | -9223372036854775808 |
| Float | 32 | 3.4028235E38 | 1.4E-45 |
| Double | 64 | 1.7976931348623157E308 | 4.9E-324 |

## Integers

You learned in the Chapter 2 that an integer is a number that does not have a decimal point - a whole number - and is represented in kotlin with the _Int_ type. Int is good for representing a quantity od count of "things": the remaining points of mead, the number of tavern patrons, or the count of gold and silver coins a player possesses.

### Listing 8.1 Setting up the player’s purse (Tavern.kt)
```kotlin
const val TAVERN_NAME = "Taernyl's Folly"

var playerGold = 10
var playerSilver = 10

fun main(args: Array<String>) {
    placeOrder("shandy,Dragon's Breath,5.91")
 << placeOrder("elixir,Shirley's Temple,4.12")
}

>>  fun performPurchase() {
>>      displayBalance()
>>  }

>>  private fun displayBalance() {
>>      println("Player's purse balance: Gold: $playerGold , Silver: $playerSilver")
>>  }

private fun toDragonSpeak(phrase: String) =
    ...
}

private fun placeOrder(menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("Madrigal speaks with $tavernMaster about their order.")
 
    val (type, name, price) = menuData.split(',')
    val message = "Madrigal buys a $name ($type) for $price."
    println(message)

>>  performPurchase()

    val phrase = if (name == "Dragon's Breath") {
        "Madrigal exclaims ${toDragonSpeak("Ah, delicious $name!")}"
    } else {
        "Madrigal says: Thanks for the $name."
    }
    println(phrase)
}
```

## Decimal numbers

Numeric calues with decimal places are represented with the Float od Double type. 

### Listing 8.2 Passing the price information (Tavern.kt) 
```kotlin
const val TAVERN_NAME = "Taernyl's Folly"
...
fun performPurchase(price: Double) { 
    displayBalance()
>>  println("Purchasing item for $price")
} 
...

private fun placeOrder(menuData: String) {
    ...
    
    val (type, name, price) = menuData.split(',')
    val message = "Madrigal buys a $name ($type) for $price."
    println(message)
    
    performPurchase(price)
    ... 
}
```

## Converting a String to a Numeric Type

Kotlin includes functions that convert strings to different types - including numbers. Some of the most commonly used of these conversion functions are:

* toFloat 
* toDouble
* toDoubleOrNull
* toIntOrNull
* toLong
* toBigDecimal

Attempting to convert a string of the wrong format will thrown an exception.

Kotlin also provides the safe conversion functions __toDoubleOrNull__ and __toIntOrNull__. When the number does not convert correctly, a null values is returned instead of an exception. You could use the null coalescing operator with __toIntOrNull__, for example, to provide a default value:

```kotlin
    val gold: Int =  "5.91".toIntOrNull() ?: 0
```

### Listing 8.3 Converting the price argument to a double (Tavern.kt)
```kotlin
...
private fun placeOrder(menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("Madrigal speaks with $tavernMaster about their order.")
    
    val (type, name, price) = menuData.split(',')
    val message = "Madrigal buys a $name ($type) for $price."
    println(message)
    
    performPurchase(price.toDouble())
    ... 
}
```

## Converting an Int to a Double

### Listing 8.4 Subtracting the price from the player’s purse (Tavern.kt)
```kotlin
...
fun performPurchase(price: Double) {
    displayBalance()
>>  val totalPurse = playerGold + (playerSilver / 100.0) 
>>  println("Total purse: $totalPurse") 
    println("Purchasing item for $price")

>>  val remainingBalance = totalPurse - price
} 
...
```

## Formatting a Double

Rather than working with 4.1899999999999995 pieces of goldm you will round the value up to 4.19. String's __format__ function can be used to round a double to a precision that you define. 

### Listing 8.5 Formatting a double (Tavern.kt)
```kotlin
...
fun performPurchase(price: Double) {
    displayBalance()
    val totalPurse = playerGold + (playerSilver / 100.0)
    println("Total purse: $totalPurse")
    println("Purchasing item for $price")
    
    val remainingBalance = totalPurse - price
>>  println("Remaining balance: ${"%.2f".format(remainingBalance)}")
} ...
```

The gold remaining the purse is interpolated into the string using $, as you have seen before, But wht follows the $ is not simply the name of the variable - it is an expression in curly braces. Within th braces is a call to __format__with remainingBalance passed in as the argument.

The call to __format__ also specifies a format string "%.2f". A format string uses a special sequences if characters to define how you want to format data. The particular format string you defined specifies that you want to round the floating point number up to the second decimal place. Then you pass the value or values to format as an argument to the __format__ function. 

## Converting a Double to an Int

Here, you used two conversions functions available on Double. Calling __toInt__ on a Double results in dropping any fractional value from the double. Another term for this is _loss of precision_. Some portion of the original data is lost, because you asked for an interger representation of a double that included a fractional quantity, and the integer representation is less precise.

### Listing 8.6 Converting to silver and gold (Tavern.kt)

```kotlin
>>imports kotlin.math.roundToInt
const val TAVERN_NAME = "Taernyl's Folly"
...

fun performPurchase(price: Double) {
    displayBalance()
    val totalPurse = playerGold + (playerSilver / 100.0)
    println("Total purse: $totalPurse")
    println("Purchasing item for $price")

    val remainingBalance = totalPurse - price
    println("Remaining balance: ${"%.2f".format(remainingBalance)}")

>>  val remainingGold = remainingBalance.toInt()
>>  val remainingSilver = (remainingBalance % 1 * 100).roundToInt()
>>  playerGold = remainingGold
>>  playerSilver = remainingSilver
>>  displayBalance()
}
...
```

Here you use the _modulus operator_ (%, also known as the _remainder operator_), which finds the remainder when one number is divided by another.

Kotlin includes functions for performing operations on the binary representations of valuem called bitwise operations - including operations you may be familiar from other languages, suchs as Java 

### Table 8.2 Binary operations

| Function | Description | Example |
|---|---|---|
| Integer.toBinaryString | Converts an integer to binary representation. | Integer.toBinaryString(42)  // 101010 |
| shl(bitcount) | Shifts bits left by bitcount | 42.shl(2) // 10101000 |
| shr(bitcount) | Shifts bits right by bitcount | 42.shr(2) // 1010 |
| inv() | Invert bits | 42.inv() // 11111111111111111111111111010101 |
| xor(number) | Compares two binary representations and performs a logical ‘exclusive or’ operation on the corresponding bit positions, returning 1 for each bit position that has a 1 in one input but not the other. | 42.xor(33) // 001011 |
| and(number) | Compares two binary representations and performs a logical ‘and’ operation on the corresponding bit positions, returning 1 for each bit position that has a 1 in both inputs. | 42.and(10) // 1010 |

# 9. Starndard Functions

Standard functions are general utility functions in the kotlin standard library that accept lambdas to specify their work.

In this chapter we will refer to an instance of a tyoe using the term _receiver_. This is because Kotlin's standard functions are _extension functions_ under the hood, an _receiver_ is the term for the subject of an extension function.

## __apply__

First on out tour of the standard functions is __apply__. __apply__ can be thought of as a configuration function: It allows you to call a series of functions on a receiver to configure it for use. After the lambda provided to __apply__ executes, __apply__ returns the configured receiver.

__apply__ can be used to reduce tha mount of repetition when configuring an object for use.

Without __apply__:
```kotlin
val menuFile = Filer("menu-file.txt")
menuFile.setReadable(true)
menuFile.setWritable(true)
menuFile.setExecutable(false)
```

Using __apply__:
```kotlin
val menuFile = File("menu-file.txt").apply{
    setReadable(true)
    setWritable(true)
    setExecutable(false)
}
```

__apply__ allows you do to drop the variable name from every function call performed to configure the receiver. This is because __apply__ scopes each function call withon the lambda to the receiver it is called on.

This behavior is sometimes referred to as __relative scoping__, because all the function calls within the lambda are now called relative to the receiver. Another way to say this us that they are __implicitly called_ on the receiver.

```kotlin
val menuFile = File("menu-file.txt").apply {
        setReadable(true)  // Implicitly, menuFile.setReadable(true)
        setWritable(true)  // Implicitly, menuFile.setWritable(true)
        setExecutable(false)  // Implicitly, menuFile.setExecutable(false)
}
```

## __let__

__let__ scopes a variable to the lambda provided and makes the keyword __it__.

Using __let__:
```kotlin
var firstItemsquared = listOf(1,2,3).first().let{
    it * it
}
```
Without __let__:
```kotlin
val firstElement = listOf(1,2,3).first()
val firstItemSquared = firstElement * firstElement
```

__let__ can be called on any kind of receiver and returns the result of evaluating the lambda you provided. the lambda passed to __let__ accpets the receiver it is called on as its only argumetns. You therefore access the arguent using the it keyword.

Standard functions like __let__ can also be used to reduce the risk of accidentally changing a variable, because the argument __let__ passes to the lambda is a read-only function parameter.

## __run__

__run__ is similar to __apply__ in that it provides the same relative scoping behavior. However, unlike __apply__, __run__ does not return the receiver.

```kotlin
fun nameIsLong(name: String) = name.length >= 20

"Mandrigal".run(::nameIsLong)  // false
"Polarcubis, Supreme Master of NyetHack".run(::nameIsLong)  // true
```

While the code like this is equivalen to nameIsLong("Mandrigal"), the benefits of using __run__ become clear when there are multiple functions calls: Chained calls using __run__ are easier to read and follow then nested function calls like the next example:

```kotlin
fun nameIsLong(name: String) = name.length >= 20

fun playerCreateMessage(nameTooLong: Boolean): String {
    return if (nameTooLong) {
        "Name is too long. Please choose another name."
    } else {
        "Welcome, adventurer"
    }
}

...

"Polarcubis, Supreme Master of NyetHack"
    .run(::nameIsLong)
    .run(::playerCreateMessage)
    .run(::println)

```

Compare the calls chined with __run__ calling the three functions nested syntax

```kotlin
println(playerCreateMessage(nameIsLong("Polarcubis, Supreme Master of NyetHack")))
```

Note that there is a second flavor of __run__ that is not called on a receiver. This form is far less commonly seen, but we include it here for completeness:

```kotlin
var status = run {
    if(healthPoints == 100) "perfect health" else "has injuries"
}
```

## __with__

__with__ is a variant of run. It behaves identically, but it uses a different calling convention. Unlike the standard functions you have seen so far, __with__ requires its argument to be accepted as the first parameter ratherthan calling the standard function on reveiver type:

```kotlin
val nameTooLong  = with("Polarcubis, Supreme Master of NyeHack"){
    length >= 20
}
```

Instead of calling __with__ on the string, as in "Polarcubis, Supreme Master of NyeHack".run, the string is passed as the first (in this case, only) argument to __with__.