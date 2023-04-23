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

## __also__

The __also__ function works very similarly to the __let__ function. Just like __let__, __also__ passes the receiver you call it on as an argument to a lambda you provide. But there is one major difference between __let__ and __also__: __also__ returns the receiver, rather than the result of the lambda.

```kotlin
var fileContents: List<String>
File("file.txt")
    .also{
        print(it.name)
    }.also{
        fileContents = it.readLines()
    }
```

Sinse __also__ returns the receiver instead of the result of the lambda, you can continue the chain additional function calls on to the original receiver.

## __takeIf__

__takeIf works a bit differently than the other standard functions: It evaluates a condition provided in a lambda, called a _predicate_, that returns either true or false depending on the conditions defines. If the condition evaluates as true, the receiver is returned from takeIf. If the condition is false, null is returned instead.

Consider the following example, which reads a file and only if it is readable and writable.

```kotlin
val fileContents = File("myfile.txt")
    .takeIf { it.canRead() && it.canWrite() }
    ?.readText()
```

Without __takeIf__, this would be more verbose:

```kotlin
val file = File("myfile.txt")
val fileContents = if(file.canRead() && file.canWrite()){
    file.readText()
} else {
    null
}
```

The __takeIf__ version does not require the temporary variable fíle, nor does it need to specify teh possibility of a null return. __takeIf__ is useful for checking that some condition required for assigning a variable or proceeding with work is true before continuing. Conceptuallym __takeIf__ is similar to an _if_ statement, but with the advantage of begin directly callable on an instance, often allowing you remove a temporary variable assigment.

## __takeUnless__

There is a complementary function to __takeIf__ that we should mention. of only to warn you away from it: __takeUnless__. The __takeUnless__ function is exactly like __takeIf__ except that it returns the original value if the condition you define is _false_.

This example reads the file if it is no hidden (and return null otherwise)

```kotlin
val fileContents = File("myfile.txt").takeUnless {it.isHidden}?.readText()
```

the book recommend that you limit the use of __takeUnless__, especially for more complicated condition-checking, because it takes longer for human readers of your program to interpret. Compaare the "understandability" of these two phrases:

* "Return the value if the condition is true" - __takeIf__
* "Return the value unless the condition is true" - __takeUnless__

## Using Standard Library Functions

Table 9.1 Standard functions

| Function | Passes receiver to lambda as argument? | Provides relative scoping? | Returns |
|---|---|---|---|
| let | Yes | No | Lambda result |
| apply | No | Yes | Receiver |
| run | No | Yes | Lambda result |
| with | No | Yes | Lambda result |
| also | Yes | No | Receiver |
| takeIf | Yes | No | Nullable version of receiver |
| takeUnless | Yes | No | Nullable version of receiver |


# 10.List and Sets

Working with a group of related values is an essential part of many programs. For example, your program might manage list of books, travel destinations, menu items, or tavern patron check balances. _Collections_ allow you to coveniently work with those groups of values and pass them as arguments to functions.

## List

Lists hold an ordered collection of values and allow duplicate values.

__listOf__ function returns a read-only list (more on that shortly) populated with the elements you provide for the argument 

### Listing 10.1 Creating a list of patrons (Tavern.kt) import kotlin.math.roundToInt
```kotlin
const val TAVERN_NAME = "Taernyl's Folly"

    var playerGold = 10
    var playerSilver = 10
>>  val patronList: List<String> = listOf("Eli", "Mordoc", "Sophie")

    fun main(args: Array<String>) {
        placeOrder("shandy,Dragon's Breath,5.91")
>>      println(patronList)
    } 
...
```

Though type inference does work with list, you included the type information - val patronList: List<String> - to make it invisible for discussion. Notice the diamond braces in List<String>. <String> is known as a _parameterized type_, and it tells the compiler about the type that teh contents of the list will be - in this case, Strings.

### Listing 10.2 Adding an integer to a list of strings (Tavern.kt)
```kotlin
...
var patronList: List<String> = listOf("Eli", "Mordoc", "Sophie", 1)
...
```

IntelliJ warns you that the integer does not conform to the expected type, String. Type parameters are used with List because List is a _generic type_. This means that a list can hold any tyoe of data, including textual data like strings or characters, numeric data like integer or doubles, or even a new type that you define.

### Listing 10.3 Correcting the list contents (Tavern.kt)
```kotlin
...
<<  var patronList: List<String> = listOf("Eli", "Mordoc", "Sophie", 1)
>>  var patronList: List<String> = listOf("Eli", "Mordoc", "Sophie")
...
```

## Accessing a list's elements

Recall from you work with the split function in Chapter 7 that you can access any element of a list using the element's index and the [] operator.

### Listing 10.4 Accessing the first patron (Tavern.kt) 
```kotlin
imports kotlin.math.roundToInt
const val TAVERN_NAME = "Taernyl's Folly"

    var playerGold = 10
    var playerSilver = 10
 << val patronList: List<String> = listOf("Eli", "Mordoc", "Sophie")
 >> val patronList = listOf("Eli", "Mordoc", "Sophie")
    
    fun main(args: Array<String>) {
        placeOrder("shandy,Dragon's Breath,5.91")
        
        println(patronList[0]) 
    }

...
```

## Index boundaries and safe index access

Accessing an element by index requires care, because attempting to access an element at an index that does not exits - say, the fourth item a list that contains only three - causes an ArrayIndexOutOfBoundsException exception.

### Listing 10.5 Accessing a nonexistent index (REPL)
```kotlin
val patronList = listOf("Eli", "Mordoc", "Sophie")
patronList[4]
```

The result is java.lang.ArrayIndexOutOfBoundsException: 4

The safe index access functions: __getOrElse__. takes two arguments: The first is the requested index (in parentheses, not square brackets). the second is a lambda that generates a default value, instead if an exception, if the requested index does no exist.

### Listing 10.6 Testing getOrElse (REPL)
```kotlin
val patronList = listOf("Eli", "Mordoc", "Sophie")
patronList.getOrElse(4) { "Unknown Patron" }
```

This time, the result is Unknow Patron. The anonymous function was used to provide a default value, since the requested index does not exist.

Another safe index access function, __getOrNull__, returns null instead of throwing an exception. When you use __getOrNull__, you must decide what to do with the null value. One option is to coalesce the null value to a default. Try using __getOrNull__ with the null coalescing operator.

### Listing 10.7 Testing getOrNull (REPL)
```kotlin
val fifthPatron = patronList.getOrNull(4) ?: "Unknown Patron"
fifthPatron
```
## Checking the contents of a list

The __contains__ function performs a structural comparison for the elements in the list, like the structural equality operator.

### Listing 10.8 Checking for a patron (Tavern.kt)
```kotlin
...
fun main(args: Array<String>) {
    if (patronList.contains("Eli")) {
        println("The tavern master says: Eli's in the back playing cards.")
    } else {
        println("The tavern master says: Eli isn't here.")
    }
    placeOrder("shandy,Dragon's Breath,5.91")
    println(patronList[0])
}
...
```

### Listing 10.9 Checking for multiple patrons (Tavern.kt)
```kotlin
...
fun main(args: Array<String>) {
    if (patronList.contains("Eli")) {
        println("The tavern master says: Eli's in the back playing cards. ")
    } else {
        println("The tavern master says: Eli isn't here.")
    }

>>  if (patronList.containsAll(listOf("Sophie", "Mordoc"))) {
>>      println("The tavern master says: Yea, they're seated by the stew kettle.")
>>  } else {
>>      println("The tavern master says: Nay, they departed hours ago.")
>>  }
    
    placeOrder("shandy,Dragon's Breath,5.91")
}
...
```

## Changing a list's contens

In kotlin, a modifiable list is known as a _mutable list_, and use the __mutableListOf__function to create one.

### Listing 10.10 Making the patron list mutable (Tavern.kt)
```kotlin
...
<<  val patronList = listOf("Eli", "Mordoc", "Sophie")
>>  val patronList = mutableListOf("Eli", "Mordoc", "Sophie")

fun main(args: Array<String>) {
    ...
    placeOrder("shandy,Dragon's Breath,5.91")

>>  println(patronList)
>>  patronList.remove("Eli")
>>  patronList.add("Alex")
>>  println(patronList)
} 
...
```

### Listing 10.11 Adding another Alex (Tavern.kt) 
```kotlin
...
val patronList = mutableListOf("Eli", "Mordoc", "Sophie")
fun main(args: Array<String>) {
    ...
    placeOrder("shandy,Dragon's Breath,5.91")

    println(patronList) 
    patronList.remove("Eli") 
    patronList.add("Alex") 
>>  patronList.add(0, "Alex") 
    println(patronList)
} 
...
```

Run Tavern.kt again. You will see the following printed:
```
...
[Eli, Mordoc, Sophie]
[Alex, Mordoc, Sophie, Alex]
```

### Listing 10.12 Modifying a mutable list using the set operator (Tavern.kt) 
...
val patronList = mutableListOf("Eli", "Mordoc", "Sophie")
fun main(args: Array<String>) {
    ...
    placeOrder("shandy,Dragon's Breath,5.91")
    println(patronList) 
    patronList.remove("Eli") 
    patronList.add("Alex") 
    patronList.add(0, "Alex") 
>>  patronList[0] = "Alexis" 
    println(patronList)
} ...

Run Tavern.kt. You will see that patronList has been updated with Alexis’ preferred name.
```
...
[Eli, Mordoc, Sophie]
[Alexis, Mordoc, Sophie, Alex]
```


Table 10.1 Mutable list mutator funtions


| Function | Description | Example(s) |
|---|---|---|
| []= (set operator) | Sets the value at the inex, throws an exception if the index does not exists | val patronList = mutableListOf("Eli", "Mordoc", "Sophie") -- patronList[4] = "Reggie" -- _IndexOutOfBoundsException_ |  
| __add__ | Adds an element to the end of the list, resizing it by one element | val patronList = mutableListOf("Eli", "Mordoc", "Sophie") -- patronList.add("Reggie") -- [Eli, Mordoc, Sophie, Reggie] -- patronList.size -- 4 |
| __add__ (at index) | Adds an element to the list at a particular index, resizing the list by one element. Throwns an exception if the index does not exist. | val patronList = mutableListOf("Eli", "Mordoc","Sophie") -- patronList.add(0, "Reggie") -- [Reggie, Eli, Mordoc, Sophie] -- patronList.add(5, "Sophie") -- IndexOutOfBoundsException |
| __addAll__ | Adds all of another collection with contents of the same type to the list | val patronList = mutableListOf("Eli", "Mordoc","Sophie") -- patronList.addAll(listOf("Reginald", "Alex")) -- [Eli, Mordoc, Sophie, Reginald, Alex] |
| += (plus assign operator) | Adds an element or collection of elements to the list | mutableListOf("Eli", "Mordoc", "Sophie") += "Reginald" -- [Eli, Mordoc, Sophie, Reginald] -- mutableListOf("Eli","Mordoc","Sophie") += listOf("Alex", "Shruti") -- [Eli, Mordoc, Sophie, Alex, Shruti] |
| -= (minus assign operator) | Removes an element of collection of the elements from the list | mutableListOf("Eli","Mordoc","Sophie") -= "Eli" -- [Mordoc, Sophie] -- val patronList = mutableListOf("Eli","Mordoc","Sophie") -- patronList -= listOf("Eli", Mordoc") -- [Sophie] |
| __clear__ | Removes all the elements from the list | mutableListOf("Eli", "Mordoc", Sophie").clear() -- [] |
| __removeIf__ | Removes elements from the list based on a predicate lambda | val patronList = mutableListOf("Eli","Mordoc","Sophie") -- patronList.removeIf { it.contains("o") } -- [Eli] |

## Iteration

List include built-in support for a variety of functions that allow you to perform an action for each element og their contents. This concept is called _iteration_

## __for__

One way to iterate through a list is a _for_ loop. Its logic is, "for each element in the list, do something"

### Listing 10.13 Iterating over the patronList with for(Tavern.kt)
```kotlin
...
fun main(args: Array<String>) {
    ...
    placeOrder("shandy,Dragon's Breath,5.91")

<<  println(patronList)
<<  patronList.remove("Eli")
<<  patronList.add("Alex")
<<  patronList.add(0, "Alex")
<<  patronList[0] = "Alexis"
<<  println(patronList)

>>  for (patron in patronList) {
>>      println("Good evening, $patron")
>>  }
} 
...
```

## __forEach__

The __forEach__ function trsverses each element in teh list  -- one by one, from the left to right -- and passes each element to the anonymous function you provide as an argument.

### Listing 10.14 Iterating over the patronList with forEach (Tavern.kt)
```kotlin
...
fun main(args: Array<String>) {
    ...
    placeOrder("shandy,Dragon's Breath,5.91")
   
<<  for (patron in patronList) {
<<      println("Good evening, $patron")
<<  }
   
>>  patronList.forEach { patron ->
>>      println("Good evening, $patron")
>>  }

} 
...
```

## __forEachIndexed__

Kotlin's __for__ loop and __foreach__ function handle indexing behind the scenes, If you also want access to the index of each element in a list as you iterate, use __forEachIndexed__.

### Listing 10.15 Displaying line position with __forEachIndexed__ (Tavern.kt)
```kotlin
...
fun main(args: Array<String>) {
    ...
    placeOrder("shandy,Dragon's Breath,5.91")
    patronList.forEachIndexed { index, patron ->
        println("Good evening, $patron - you're #${index + 1} in line.") 
    }
} 
...
```

The __forEach__ and __forEachIndexed__ functions are also available on certain other types in kotlin.this category of types is called _Iterable_, and _List_, _Set_, _Map_, _IntRange_, and other collections type belong to the Iterable category. An iterable supports iteration - in other wotds, it allows trversing the elements it holds, performing some action for each element.

## Reading a File into a List.

### Listing 10.17 Reading menu data from a file (Tavern.kt)
```kotlin
>>  import java.io.File
    ...
    val patronList = mutableListOf("Eli", "Mordoc", "Sophie") 
>>  val menuList = File("data/tavern-menu-items.txt")
>>                     .readText()
>>                     .split("\n")
...
```

### Listing 10.18 Printing the diversified menu (Tavern.kt)
```kotlin
...
fun main(args: Array<String>) {
    ...
    patronList.forEachIndexed { index, patron ->
        println("Good evening, $patron - you're #${index + 1} in line.")
        placeOrder(patron, "shandy,Dragon's Breath,5.91")
    }
    
>>  menuList.forEachIndexed { index, data ->
>>      println("$index : $data")
>>  }

} 
...
```

## Destructuring
Alist offers the ability to destructure up to the first five elements it contains. Destructuring, allow you to declare an assign multiple variables in a single expression. You are using this destructuring declaration to separate the elements of the menu data:

```kotlin
val (type, name , price) = menuData.split(',')
```

By the way, you can also selectively destructure elements from a list by using the symbol _ to skip un wanted elements. Say, from example, that the tavern master would like to hand out medals to the best sword jugglers in the realm but gas misplaced the silver medal. If you wanted to destructure only the firts and third value in the result from splitting the patron list, you could do so with:

```kotlin
val (goldMedal, _, bronzeMedal) = patronList
```

## Sets

List, as you have seen, allow deplicate elements (and are ordered, so duplicates - and other elements - can be identifies by their position). but sometimes you want a collection that guarantees that its items are unique.

But there are two major differences between lists and sets: The elements of a set are unique, and a set does not provided index. based mutators, because the iterms in a set not guarenteed to be in any particular order.

## Creating a set

Just as you can create a list using the __listOf__ function, you can create a Set using the __setOf__ function.

### Listing 10.20 Creating a set (REPL)
```kotlin
val planets = setOf("Mercury", "Venus", "Earth") 
planets
["Mercury", "Venus", "Earth"]
```

### Listing 10.21 Trying to create a set with a duplicate (REPL)
```kotlin
val planets = setOf("Mercury", "Venus", "Earth", "Earth") 
planets
["Mercury", "Venus", "Earth"]
```

### Listing 10.22 Checking planets (REPL)
```kotlin
planets.contains("Earth")
>> true
planets.contains("Pluto")
>> false
```

Set does not index its contests - meaning it provides no built-in [] operator to access alements using an index. However, you can still request an element at a particular index, using function that use iteration to accomplish the task.

### Listing 10.23 Finding the third planet (REPL)
```kotlin
val planets = setOf("Mercury", "Venus", "Earth") 
planets.elementAt(2)
Earth
```

## Add elements to a set

### Listing 10.24 Generating 10 random patrons (Tavern.kt)
```kotlin
...
    val patronList = mutableListOf("Eli", "Mordoc", "Sophie") 
>>  val lastName = listOf("Ironfoot", "Fernsworth", "Baggins") 
    val menuList = File("data/tavern-menu-items.txt")
                                    .readText()
                                    .split("\n")
fun main(args: Array<String>) {
    ...
<<    patronList.forEachIndexed { index, patron ->
<<        println("Good evening, $patron - you're #${index + 1} in line.")
<<        placeOrder(patron, menuList.shuffled().first())
<<    }
<<    menuList.forEachIndexed { index, data ->
<<        println("$index : $data")
<<    }

>>   (0..9).forEach {
>>        val first = patronList.shuffled().first()
>>        val last = lastName.shuffled().first()
>>        val name = "$first $last"
>>        println(name)
}
} 
...
```

### Listing 10.25 Ensuring uniqueness using a set (Tavern.kt)
```kotlin
...
    val lastName = listOf("Ironfoot", "Fernsworth", "Baggins") 
>>  val uniquePatrons = mutableSetOf<String>()
    val menuList = File("data/tavern-menu-items.txt")
                                    .readText()
                                    .split("\n")
fun main(args: Array<String>) {
    ...
(0..9).forEach {
    val first = patronList.shuffled().first() val last = lastName.shuffled().first() val name = "$first $last"
<<  println(name)
>>  uniquePatrons += name
}
>>  println(uniquePatrons)
} 
...
```

Table 10.2 Mutable set mutator functions

| Function | Description | Example(s) |
|---|---|---|
| __add__ | Adds the value to the set | mutableSetOf(1,2).add(3) -- [1,2,3] |
| __addAll__ | Adds all elements from another collections to set | mutableSetOf(1,2).addAll(listOf(1,5,6)) -- [1,2,3] |
| += (plus assign operator) | Add the value(s) to the set | mutableSetOf(1,2) -= 3 -- [1,2,3] |
| -= (minus assign operator) | Removes the value to the set | mutableSetOf((1,2,3)) -= 3 -- [1,2] -- mutableSetOf(1,2,3) -= listOf(2,3) -- [1] |
| __remove__ | Removes the element from the set | mutableSetOf(1,2,3).remove(1) -- [2,3] |
| __removeAll__ | Removes all elements in another collection from the set | mutableSetOF(1,2).removeAll(listOf(1,5,6)) -- [2] |
| __clear__ | Removes all elemtns from the set |  mutableSetOf(1,2).clear() -- [] |

## While Loops.

A while loop's logic is "While some condition is truem execute the code in this block". 

### Listing 10.26 Unique patrons placing random orders (Tavern.kt)
```kotlin
...
fun main(args: Array<String>) {
    ...
    println(uniquePatrons)

>>  var orderCount = 0
>>  while (orderCount <= 9) {
>>      placeOrder(uniquePatrons.shuffled().first(),
>>              menuList.shuffled().first())
>>      orderCount++
>>  }
} 
...
```
The _increment operator_ (++) adds 1 to the calue of orderCount during each iteration. 

A while loop requires you to maintain your own counter manager its state. You start with an orderCount calue of 0 and increment time that you loop. white loops are more flexible than for loops in that they can represent state that is not purely based on iteration.

## The break Expression

One way to exit a white loop es by changing the state it depeneds on. Another way to break out of a loop is the break expression.

## Collection Conversion

You can also convert a list to a set, or vise versa, using the __toSet__ and __toList__ functions (or their mutabke cousins: to __MutableSet__ and __toMutableList__).

### Listing 10.27 Converting a list to a set (REPL)
```kotlin
listOf("Eli Baggins", "Eli Baggins", "Eli Ironfoot").toSet()
[Eli Baggins, Eli Ironfoot]
```

### Listing 10.28 Converting a set back to a list (REPL)
```kotlin
val patrons = listOf("Eli Baggins", "Eli Baggins", "Eli Ironfoot")
            .toSet()
            .toList()
[Eli Baggins, Eli Ironfoot]
patrons[0]
Eli Baggins
```

the need to remove duplicates and resume index-based access is so common that kotlin provides a function on List called __distinct__ that calls __toSet__ and __toList__ internally

### Listing 10.29 Calling __distinct__ (REPL)
```kotlin
val patrons = listOf("Eli Baggins", "Eli Baggins", "Eli Ironfoot").distinct()
[Eli Baggins, Eli Ironfoot]
patrons[0]
Eli Baggins
```

Set are useful for representing series of data where each element is unique.

## 11. Maps

Where Map is defferent from List and Set is that its elements consist of key-value pairs that you define and instead of index-based access using an intenger, a map provides key-based acces using a type that you specify. Keys are unique and identify the values in the map; the values, on the other hand, do not need to be unique. In this way, Map shares another feature with Set; The keys of a mao are guaranteed to be unique, just like elements of a set.

## Creating a Map

Like list and sets, maps are created using functions: __mapOf__ and __mutableMapOf__

### Listing 11.1 Creating a read-only map (Tavern.kt)
```kotlin
...
    var uniquePatrons = mutableSetOf<String>()
    val menuList = File("data/tavern-menu-items.txt")
                                    .readText()
                                    .split("\n")
>>  val patronGold = mapOf("Eli" to 10.5, "Mordoc" to 8.0, "Sophie" to 5.5)
    
    fun main(args: Array<String>) {
        ...
        println(uniquePatrons)
        var orderCount = 0
        while (orderCount <= 9) {
            placeOrder(uniquePatrons.shuffled().first(),
                    menuList.shuffled().first())
            orderCount++
        }
>>  println(patronGold)
} 
...
```

While teh keys in a map must all be of the same tyoe, and the values must be of the same type, the keys and values can be of different types. Here you have a map with string keys and double values. You are using type onference, but if you had wanted to include explicit type information, it would look like this:

```kotlin
val patronGold: Map<String, Double>
```

You used __to__ to define each entry (key am value) in the map.

### Listing11.2 Defining a map using the Pair type (REPL)
```kotlin
val patronGold = mapOf(Pair("Eli", 10.75),
    Pair("Mordoc", 8.00),
    Pair("Sophie", 5.50))
```

However, building a map using the __to__ function is cleaner than this sintax

### Listing 11.3 Adding a duplicate key (REPL)
```kotlin
val patronGold = mutableMapOf("Eli" to 5.0, "Sophie" to 1.0) patronGold += "Sophie" to 6.0
println(patronGold)
{Eli=5.0, Sophie=6.0}
```

## Accessing Map Values

You acceess a value in a map using its key. For the partronGold map, you will use the string key to access the patron's gold balances

### Listing 11.4 Accessing individual gold balances (Tavern.kt)
```kotlin
...
fun main(args: Array<String>) {
    ...
    println(uniquePatrons)
    
    var orderCount = 0
    while (orderCount <= 9) {
        placeOrder(uniquePatrons.shuffled().first(),
                menuList.shuffled().first())
        orderCount++
    }

    println(patronGold)
>>  println(patronGold["Eli"])
>>  println(patronGold["Mordoc"])
>>  println(patronGold["Sophie"])
}
```

### Table 11.1 Map access functions

| Function | Description | Example |
|---|---|---|
| [] (get/index operator) | Gets  the value for a key; returns null if the key does not exists | patronGold["Reginald"] -- null |
| __getValue__ | Gets the value for a key; throwsan exception if the key provided is not in the map | patronGold.getValue("Reggie") -- NoSuchElementException |
| __getOrElse__ | Gets the value for the key or return a default using an anonymous function | patronGold.getOrElse("Reggie") {"No such patron"} -- No such patron |
| __getOrDefault__ | Gets the value for the key or return a default using a value you provide | patronGold.getOrDefault("Reginald", 0.0) -- 0.0 |

## Adding entries to a map

### Listing 11.5 Populating the mutable map (Tavern.kt)
```kotlin
    importx java.io.File
    importx kotlin.math.roundToInt
    const val TAVERN_NAME: String = "Taernyl's Folly"

    var playerGold = 10
    var playerSilver = 10
    val patronList = mutableListOf("Eli", "Mordoc", "Sophie")
    val lastName = listOf("Ironfoot", "Fernsworth", "Baggins")
    val uniquePatrons = mutableSetOf<String>()
    val menuList = File("data/tavern-menu-items.txt")
            .readText()
            .split("\n")

<<  val patronGold = mapOf("Eli" to 10.5, "Mordoc" to 8.0, "Sophie" to 5.5)
>>  val patronGold = mutableMapOf<String, Double>()

    fun main(args: Array<String>) {
        ...
<<      println(uniquePatrons)
>>      uniquePatrons.forEach {
>>          patronGold[it] = 6.0
>>      }

        var orderCount = 0
        while (orderCount <= 9) {
            placeOrder(uniquePatrons.shuffled().first(),
                    menuList.shuffled().first())
            orderCount++
        }

<<      println(patronGold)
<<      println(patronGold["Eli"])
<<      println(patronGold["Mordoc"])
<<      println(patronGold["Sophie"])
} 
...
```

### Table 11.2 Mutable map mutator functions

| Function | Description | Example |
|---|---|---|
| = (assigment operator) | Adds or updates the value in the map for the key specified | val patronGold = mutableMapOf("Mordoc" to 6.0) -- patronGold["Mordoc"] = 5.0 -- {Mordoc=5.0} |
| += (plus assign operator) | Adds or updates an entry or entries in the map based on the entry or map specified | val patronGold = mutableMapOf("Mordoc" to 6.0) -- patronGold += "Eli" to 5.0 -- {Mordoc=6.0, Eli=5.0} -- val patronGold = mutableMapOf("Mordoc" to 6.0) -- patronGold += mapOf("Eli" to 7.0,"Mordoc" to 1.0,"Jebediah" to 4.5) -- {Mordoc=1.0, Eli=7.0, Jebediah=4.5} |
| __put__ | Adds or update the value in the map for the key specifies | val patronGold = mutableMapOf("Mordoc" to 6.0) -- patronGold.put("Mordoc", 5.0) -- {Mordoc=5.0} |
| __putAll__ | Adds all of the key-value pairs provided to the map |  val patronGold = mutableMapOf("Mordoc" to 6.0) -- patronGold.putAll(listOf("Jebediah" to 5.0,"Sahara" to 6.0)) -- patronGold["Jebediah"] -- 5.0 -- patronGold["Sahara"] -- 6.0 |
| __getOrPut__ | Adds an entry for the key if it does not exist already and returns the result; otherwise returns the existing entry | val patronGold = mutableMapOf<String, Double>() -- patronGold.getOrPut("Randy"){5.0} -- 5.0 --patronGold.getOrPut("Randy"){10.0} -- 5.0 |
| __remove__ | Removes an entry from the map and returns the value. | val patronGold = mutableMapOf("Mordoc" to 5.0) -- val mordocBalance = patronGold.remove("Mordoc") -- {} -- print(mordocBalance) -- 5.0 |
| - (minus operator) | Returns a new map, excluding the entries specified | val newPatrons = mutableMapOf("Mordoc" to 6.0,"Jebediah" to 1.0) - "Mordoc" -- {Jebediah=1.0} |
| -= (minus assign operator) | Removes antry or map of entries from the map | mutableMapOf("Mordoc" to 6.0,"Jebediah" to 1.0) -= "Mordoc" -- {Jebediah=1.0} |
| __clear__ | Removes all entries from the map | mutableMapOf("Mordoc" to 6.0,"Jebediah" to 1.0).clear() -- {} |

## Modifying Map Values

### Listing 11.6 Updating the values in patronGold (Tavern.kt)
```kotlin
importx java.io.File
importx kotlin.math.roundToInt
const val TAVERN_NAME: String = "Taernyl's Folly"

<<  var playerGold = 10
<<  var playerSilver = 10
    val patronList = mutableListOf("Eli", "Mordoc", "Sophie") 
    ...

<<  fun performPurchase(price: Double) {
<<      displayBalance()
<<      val totalPurse = playerGold + (playerSilver / 100.0)
<<      println("Total purse: $totalPurse")
<<      println("Purchasing item for $price")
<<      val remainingBalance = totalPurse - price
<<      println("Remaining balance: ${"%.2f".format(remainingBalance)}")
<<      val remainingGold = remainingBalance.toInt()
<<      val remainingSilver = (remainingBalance % 1 * 100).roundToInt()
<<      playerGold = remainingGold
<<      playerSilver = remainingSilver
<<      displayBalance()
<<  }
    
<<  private fun displayBalance() {
<<      println("Player's purse balance: Gold: $playerGold , Silver: $playerSilver")
<<  }
    
>>  fun performPurchase(price: Double, patronName: String) {
>>      val totalPurse = patronGold.getValue(patronName)
>>      patronGold[patronName] = totalPurse - price
>>  }
    
    private fun toDragonSpeak(phrase: String) =
        ...
    }
    
    private fun placeOrder(patronName: String, menuData: String) {
        ...
    println(message)
<<      // performPurchase(price.toDouble(), patronName)
>>      performPurchase(price.toDouble(), patronName)

        val phrase = if (name == "Dragon's Breath") {
        ... 
        }
    ...
```


### Listing 11.7 Displaying patron balances (Tavern.kt)
```kotlin
...
fun main(args: Array<String>) {
    ...
    var orderCount = 0
    while (orderCount <= 9) {
        placeOrder(uniquePatrons.shuffled().first(),
                menuList.shuffled().first())
        orderCount++
    }
>>  displayPatronBalances()
}

>>  private fun displayPatronBalances() {
>>      patronGold.forEach { patron, balance ->
>>          println("$patron, balance: ${"%.2f".format(balance)}")
>>      }
>>  }
...
```

Table 11.3 Kotlin Collections summary

| Collection Type | Ordered? | Unique? | Store | Support destructuring? |
|---|---|---|---|---|
| List | Yes | No | Elements | Yes |
| Set | No | Yes | Elements | No |
| Map | No | Keys | Key-value pairs | No |


# 12. Defining Classes

The object-oriented programming paradigm has been around since the 1960s and continues to be popular because it provides a set of useful tools for simplifying the structure of a program. Central to the object-oriented style are _clasess_, definitions of the unique categories of "things" your code represents.

## Defining a Class

A class can be deined in its own file or alongside other elements, like functions or variables

###Listing 12.1 Defining the Playerclass (Player.kt) 
```kotlin
class Player
```

You can define multiple classes in the same file - and you may want to if you have multiple classes usedfor a similiar purpose.


## Constructing Instances

### Listing 12.2 Instantiating a Player (Game.kt)
```kotlin
fun main(args: Array<String>) {
    val name = "Madrigal"
    var healthPoints = 89
    val isBlessed = true
    val isImmortal = false

>>  val player = Player()

    // Aura
    val auraColor = auraColor(isBlessed, healthPoints, isImmortal)
    
    // Player status
    val healthStatus = formatHealthStatus(healthPoints, isBlessed)
    printPlayerStatus(auraColor, isBlessed, name, healthStatus)
   
    castFireball()
}
...
```

When you start a new game, the __main__ function is called, and one of the first things that you will want to do is create a player character to play the game.

You called __Player's__ _primary constructor_ by suffixing the __Player__ class name with parentheses. The player variable is now said to "contains an instance of the __Player__ class"

## Class Function

Class definition can be specify two types of content: _behavior_ and _data_

### Listing 12.3 Defining a class function (Player.kt)
```kotlin
class Player {
    fun castFireball(numFireballs: Int = 2) = println("A glass of Fireball springs into existence. (x$numFireballs)") 
}
```

Here you define a _class body_ for __Player__ with curly braces. The class body holds definitions for the class's behavior and data, much like the actions of a function are defines within the function body.

### Listing 12.4 Calling a class function (Game.kt)
```kotlin
fun main(args: Array<String>) {
    var healthPoints = 89
    val isBlessed = true
    val isImmortal = false
    
    val player = Player()
>>  player.castFireball()

    // Aura
    val auraColor = auraColor(isBlessed, healthPoints, isImmortal)

    // Player status
    val healthStatus = formatHealthStatus(healthPoints, isBlessed)
    printPlayerStatus(auraColor, isBlessed, player.name, healthStatus)

<<  castFireball()
}
...
<<  private fun castFireball(numFireballs: Int = 2) =
<<              println("A glass of Fireball springs into existence. (x$numFireballs)")
```

## Visibility and Encapsulation

Encapsulation says that a class should selectively expose funtions and properties to define how other objects interact with it. Anything that is not essential to expose, including implementations details of exposed functions and properties, should be kept private.

### Table 12.2 Visibility modifiers.

| Modifier | Description |
|---|---|
| public (default) | The function or property will be accessible by code outside of the class, By default, functions and properties without  a visibility modifier are public |
| private | The function or property will be accessible only within the same class |
| protected | The function or property will be accessible only within the same class ot its subclass |
| internal | The function or property will be accessible within the same module  |

## Class Properties

Class function definitions describe the behavior associated with a class, Data definitions, better known as _class properties_, are the attribbutes required to represent the specific state or characteristics of a class.

### Listing 12.5 Defining the name property (Player.kt) 
```kotlin
class Player {
>>  val name = "madrigal"
    fun castFireball(numFireballs: Int = 2) =
            println("A glass of Fireball springs into existence. (x$numFireballs)")
}
```

### Listing 12.7 Resolving the reference to Player’s name property (Game.kt) 
```kotlin
fun main(args: Array<String>) {
...
    // Player status
<<  printPlayerStatus(auraColor, isBlessed, player, healthStatus) 
>>  printPlayerStatus(auraColor, isBlessed, player.name, healthStatus) 
}
...
```

## Property getters and setters

For eache property you define, kotlin will generate a _field_, a _getter_, and, if needed, a setter. A field is where the data for a proeprty is stored, you cannot directly define a filed on a class. Kotlin encapsulates the field for you, protecting the data in the field and exposing it via getters and setters. A property's getter specifies how the property is read. Getter are generated for every property.

### Listing 12.8 Defining a custom getter (Player.kt)
```kotlin
class Player {
    val name = "madrigal"
>>      get() = field.capitalize()
    
    fun castFireball(numFireballs: Int = 2) =
            println("A glass of Fireball springs into existence. (x$numFireballs)")

}
```

### Listing 12.9 Defining a custom setter (Player.kt)
```kotlin
class Player {
    val name = "madrigal"
        get() = field.capitalize()
>>      set(value) {
>>          field = value.trim()
>>      }

    fun castFireball(numFireballs: Int = 2) =
            println("A glass of Fireball springs into existence. (x$numFireballs)")
}
```

## Property visibility

Properties are different from variables defined locally within a function. When a property is defined, it is defined at the class level. As such, it may be accessible to other classes, it its visibility allows.

The peroperties provide fine-grained control around reading and modifying data through their getters and setters. All properties have getters - and all var properties have setters - whether you define custom behavior for them or not.

### Listing 12.12 Hiding name’ssetter (Player.kt)
```kotlin
class Player {
    var name = "madrigal"
    get() = field.capitalize() 
    private set(value) {
        field = value.trim()
    }
    
    fun castFireball(numFireballs: Int = 2) =
            println("A glass of Fireball springs into existence. (x$numFireballs)")
}
```

## Computed properties

Earlier, we said that when you define a property,a field is always generated to store the value the property encapsulates. That is true... except in a particular case: _computer properties_. A computed property is a property that is specified with an overridden __get__ and /or __set__ operator in a way that makes a field unnecessary.

### Listing 12.13 Defining a computed property (REPL)
```kotlin
class Dice() {
    val rolledValue
        get() = (1..6).shuffled().first()
}
```

### Listing 12.14 Accessing the computed property (REPL)
```kotlin
val myD6 = Dice() 
myD6.rolledValue 
6 
myD6.rolledValue 
1 
myD6.rolledValue 
4
```

### Listing 12.16 Adding properties to Player (Player.kt)
```kotlin
class Player {
    var name = "madrigal"
        get() = field.capitalize()
        private set(value) {
            field = value.trim()
        }

>>  var healthPoints = 89
>>  val isBlessed = true
>>  val isImmortal = false
    
    fun castFireball(numFireballs: Int = 2) =
            println("A glass of Fireball springs into existence. (x$numFireballs)")
}
```

### Listing 12.17 Encapsulating isImmortal within Player (Player.kt)
```kotlin
class Player {
    var name = "madrigal"
        get() = field.capitalize()
        private set(value) {
            field = value.trim()
        }
    
    var healthPoints = 89
    val isBlessed = true
>>  private val isImmortal = false

    fun castFireball(numFireballs: Int = 2) =
            println("A glass of Fireball springs into existence. (x$numFireballs)")
}
```

### Listing 12.19 Adding class functions to Player (Player.kt)
```kotlin
class Player {
    var name = "madrigal"
        get() = field.capitalize()
        private set(value) {
            field = value.trim()
        }
    var healthPoints = 89
    val isBlessed = true
    private val isImmortal = false

>>  private fun auraColor(isBlessed: Boolean,
>>                        healthPoints: Int,
>>                        isImmortal: Boolean): String {
>>      val auraVisible = isBlessed && healthPoints > 50 || isImmortal
>>      val auraColor = if (auraVisible) "GREEN" else "NONE"
>>      return auraColor
>>  }
    
>>  private fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean) =
>>          when (healthPoints) {
>>              100 -> "is in excellent condition!"
>>              in 90..99 -> "has a few scratches."
>>              in 75..89 -> if (isBlessed) {
>>                  "has some minor wounds, but is healing quite quickly!"
>>              } else {
>>                  "has some minor wounds."
>>              }
>>              in 15..74 -> "looks pretty hurt."
>>              else -> "is in awful condition!"
>>          }
    
    fun castFireball(numFireballs: Int = 2) =
            println("A glass of Fireball springs into existence. (x$numFireballs)")
}
```

### Listing 12.20 Removing unnecessary parameters from class functions (Player.kt)
```kotlin
class Player {
    var name = "madrigal"
        get() = field.capitalize()
        private set(value) {
            field = value.trim()
        }
    var healthPoints = 89
    val isBlessed = true
    private val isImmortal = false
    
<<  private fun auraColor(isBlessed: Boolean, healthPoints: Int, isImmortal: Boolean): String {
>>  private fun auraColor(): String {
        val auraVisible = isBlessed && healthPoints > 50 || isImmortal
        val auraColor = if (auraVisible) "GREEN" else "NONE"
        return auraColor
    }

<<  private fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean) =
>>  private fun formatHealthStatus() =
        when (healthPoints) {
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

    fun castFireball(numFireballs: Int = 2) =
            println("A glass of Fireball springs into existence. (x$numFireballs)")
}
```

### Listing 12.21 Making class functions public (Player.kt)
```kotlin
class Player {
    var name = "madrigal"
        get() = field.capitalize()
        private set(value) {
            field = value.trim()
        }
    
    var healthPoints = 89
    val isBlessed = true
    private val isImmortal = false
    
<<  private fun auraColor(): String {
>>  fun auraColor(): String {
        ...
    }
    
<<  private fun formatHealthStatus() = when (healthPoints) {
>>  fun formatHealthStatus() = when (healthPoints) {
        ...
    }
    
    fun castFireball(numFireballs: Int = 2) =
            println("A glass of Fireball springs into existence. (x$numFireballs)")
}
```

### Listing 12.22 Calling class functions (Game.kt)
```kotlin
fun main(args: Array<String>) {
    val player = Player()
    player.castFireball()

    // Aura
<<  val auraColor = player.auraColor(isBlessed, healthPoints, isImmortal)
>>  val auraColor = player.auraColor()
    
    // Player status
<<  val healthStatus = formatHealthStatus(healthPoints, isBlessed) 
<<    printPlayerStatus(playerauraColor, isBlessed, player.name, healthStatus)
>>    printPlayerStatus(player)
    
    // Aura
<<  player.auraColor(isBlessed, healthPoints, isImmortal) 
>>  player.auraColor() 
}

<<private fun printPlayerStatus(player: PlayerauraColor: String, isBlessed: Boolean, name: String,healthStatus: String) { 
>>private fun printPlayerStatus(player: Player) { 
    println("(Aura: ${player.auraColor()}) " +
            "(Blessed: ${if (player.isBlessed) "YES" else "NO"})")
    println("${player.name} ${player.formatHealthStatus()}")
}
```

# 13. Initialization.

 When yoy initialize a variable, property, or class instancem you assign it an initial value to make it ready for use.

 An object is _instantiated_ when memory is allocated for it, and it is _initialized_ when it is assigned a value. However, in practice the terms are often used slightly differently. Often, _initialization_ is used to mean "everything required to amke a variable, property, or class instance ready to use" while _instatiation_ tends to be limited to "creating an instance of a class".


 ## Constructors

 A constructor allows its caller to specify the initial calues that an instance of a class will require in order to be constructed, Those values are then available for assignment to the properties defined within the class.

 ## Primary Contrsuctors

Like a function, a contructor defines expected parameters that must be provided as argument.

### Listing 13.1 Defining a primary constructor (Player.tk)
```kotlin
class Player(_name: String,
             _healthPoints: Int,
             _isBlessed: Boolean,
             _isImmortal: Boolean){
    var name = _name
        get() = field.capitalize()
        private set(value){
            field = value.trim()
        }

    var healthPoints = _healthPoints
    val isBlessed = _isBlessed
    private val isImmortal = _isImmortal
}
```

### Listing 13.2 Calling the primary constructor (Game.tk)
```kotlin
fun main(args: Array<String>){
    val player = Player("Madrigal", 89, true, false)
}
```

## Defining properties in a primery constructor

### Listing 13.3 Defining properties in the primery constructor (Player.tk)
```kotlin
class Player(_name: String,
<<           _healthPoints: Int,
>>           var healthPoints: Int,
<<           _isBlessed: Boolean,
>>           val isBlessed: Boolean,
<<           _isImmortal: Boolean
>>           private val isImmortal: Boolean){

    var name = _name
        get() = field.capitalize()
        private set(value){
            field = value.trim()
        }

<<  var healthPoints = _healthPoints
<<  val isBlessed = _isBlessed
<<  private val isImmortal = _isImmortal
}
```


## Secondary constructors

Constructors come in two flavors: primary and secondary. When you specify a primary constructor, you say, "These parameters are required for any instance of this class". When you specify a secondary constructor, you provide alternative ways to construct the class (while still meeting the requirements of the primary constructor)

A secondary constructor must either call the primary constructor, providing it all of the arguments it requires, or call through to another secondary constructor.

### Listing 13.4 Defining a secondary constructor (Player.kt)
```kotlin
class Player(_name: String,
             var healthPoints: Int,
             val isBlessed: Boolean,
             private val isImmortal: Boolean){

    var name = _name
        get() = field.capitalize()
        private set(value){
            field = value.trim()
        }

    constructor(name: String) : this(namem,
                                     healthPoints = 100,
                                     isBlessed = true,
                                     isImmortal = false)
    ...
}
```

You can define multiple secondary constructors for different combinations of parameters. This secondary constructor calls through to the primary constructor with a certain set of paramters. The _this_ keyword in this case refers to the instance of the class for which this constructor is defined, Specifically, _this_ is calling into another constructor defined in the class - the primary constructor.

### Listing 13.5 Calling a secondary constructor (Game.tk)
```kotlin
fun main(args: Array<String>){
<<  val player = Player("Mandrigal", 89, true, false)
>>  val player = Player("Mandrigal")
    ...
}
```

You can also use a secondary constructor to define initialization logic - code that will run when your class is instantied. 

### Listing  13.6 Adding logic to a secondary constructor (Player.kt)
```kotlin
class Player(_name: String,
             var healthPoints: Int,
             val isBlessed: Boolean,
             private val isImmortal: Boolean){

    var name = _name
        get() = field.capitalize()
        private set(value){
            field = value.trim()
        }

    constructor(name: String) : this(namem,
                                     healthPoints = 100,
                                     isBlessed = true,
                                     isImmortal = false) {
        if(name.toLowerCase() == "kar") healthPoints = 40
    }
    ...
```

## Default arguments

When defining a constructorm you can also specify default values that should be assigned if an argument is not provided for a specific paramter.

### Listing 13.7 Defining a default argument in a constructor (Player.kt)
```kotlin
class Player(_name: String,
>>           var healthPoints: Int = 100,
             val isBlessed: Boolean,
             private val isImmortal: Boolean){

    var name = _name
        get() = field.capitalize()
        private set(value){
            field = value.trim()
        }

    constructor(name: String) : this(namem,
<<                                   healthPoints = 100,
                                     isBlessed = true,
                                     isImmortal = false) {
        if(name.toLowerCase() == "kar") healthPoints = 40
    }
    ...
```

## Named arguments

The more default arguments you use, the more options you have for calling your contructor, More options can open the door for more ambiguity, si kotlin provides named constructor arguments, just like the named arguments that you have used to call functions.

You may have notice that the secondary constructor you wrote for Player used named arguments.

```kotlin
constructor(name: String) :  this(name,
                                  healthPoints = 100,
                                  isBlessed = true,
                                  isImmortal = false)
```

When you have more than a few arguments to provide to a constructor or function, we recommend using named paramters.

## Initializer Blocks

In addition to the primary and secondary constructors you can also specify an _initializer block_ for a class in kotlin. The initializer block is a way to set up variables or calues as well as perform validation - like checking to make sure that the argument to the constructor are valid ones.

Use an initializer block, denoted by the __init__ keyword, to enforce there requirements with preconditions.

### Listing 13.8 Defining an initializar block (Player.kt)
```kotlin
class Player(_name: String,
             var healthPoints: Int = 100,
             val isBlessed: Boolean,
             private val isImmortal: Boolean){

    var name = _name
        get() = field.capitalize()
        private set(value){
            field = value.trim()
        }

>>  init{
>>      require(healthPoints > 0, {"healthPoints must be greater than zero."})
>>      require(name.usNotBlank(), {"Player must have a name."})
>>  }

    constructor(name: String) : this(namem,
                                     isBlessed = true,
                                     isImmortal = false) {
        if(name.toLowerCase() == "kar") healthPoints = 40
    }
    ...
```

## Property initialization.

 So far, you have seen a property initialized in two ways  - either assigned to a value passed as an argument, or defined _inline_in a primary constructor.

 A property can (and must) be initialized with any value of its type, including function return values.

 ### Listing 13.9 Defining the hometown property (Player.kt)
 ```kotlin
 class Player(_name: String,
             var healthPoints: Int = 100,
             val isBlessed: Boolean,
             private val isImmortal: Boolean){

    var name = _name
        get() = field.capitalize()
        private set(value){
            field = value.trim()
        }
    val hometown : String

    init{
        require(healthPoints > 0, {"healthPoints must be greater than zero."})
        require(name.usNotBlank(), {"Player must have a name."})
    }

    constructor(name: String) : this(namem,
                                     isBlessed = true,
                                     isImmortal = false) {
        if(name.toLowerCase() == "kar") healthPoints = 40
    }
    ...
 ```

 In this case you have defined hometown, but you not yet satisfied the kotlin compiler. You must assign an initial value when defining a property.

 ### Listing 13.10 Defining the __selectHometown__ function (Player.kt)
 ```kotlin
 importz java.io.File

 class Player(_name: String,
             var healthPoints: Int = 100,
             val isBlessed: Boolean,
             private val isImmortal: Boolean){

    var name = _name
        get() = field.capitalize()
        private set(value){
            field = value.trim()
        }
    val hometown : String

    init{
        require(healthPoints > 0, {"healthPoints must be greater than zero."})
        require(name.usNotBlank(), {"Player must have a name."})
    }

    constructor(name: String) : this(namem,
                                     isBlessed = true,
                                     isImmortal = false) {
        if(name.toLowerCase() == "kar") healthPoints = 40
    }

    private fun selectHometown() = File("data/towns.txt")
        .readText()
        .split("\n")
        .shuffled()
        .first()
    ...
 ```

 ### Listing 13.11 Using the hometown property (Player.kt)
```kotlin
 importz java.io.File

 class Player(_name: String,
             var healthPoints: Int = 100,
             val isBlessed: Boolean,
             private val isImmortal: Boolean){

    var name = _name
        get() = "${field.capitalize()} of $hometown"
        private set(value){
            field = value.trim()
        }
    val hometown : String

    init{
        require(healthPoints > 0, {"healthPoints must be greater than zero."})
        require(name.usNotBlank(), {"Player must have a name."})
    }

    constructor(name: String) : this(namem,
                                     isBlessed = true,
                                     isImmortal = false) {
        if(name.toLowerCase() == "kar") healthPoints = 40
    }

    private fun selectHometown() = File("data/towns.txt")
        .readText()
        .split("\n")
        .shuffled()
        .first()
    ...
 ```

 ## Late Initialization

 _late initialization_ becomes importan - and more than just a simple bending of kotlin's rule on initializacion

 Any _var_ property declaration can be appendedwith the __lateinit__ keyword, and the kotlin compiler will let you put off initializing the property until you assign it.

 ```kotlin
 class Player{
    lateinit var aligment: String

    fun determineFate(){
        aligment = "Good"
    }

    fun proclaimFate(){
        if(::aligment.isInitialized) println(aligment)
    }
 }
 ```

The _lateinit_ keywordfunctions as acontract that you make with yourself: "I take the responsibility for initializing this variable before it is accessed". You can check __isInitialized__ when there is any uncertainty about whether the lateinit variable is initialized to avoid an _UnitializedPropertyAccessException_.

## Lazy initialization

Lazy initialization is implemented in kotlin using a mechanism known as a _delegate_. Delegate define templates for how a property is initialized.

You use a delegate with the keyboard. The kotlin standard library includes some delegates that are alredy implemented for you, and __lazy__is one of them.

Lazy initialization takes a lambda in wich you define any code that you wish to execute when your property is initialized.


### Listing 13.12 Lazily initializing hometown (Player.kt)
```kotlin
class Player(_name: String,
            var healthPoints: Int = 100
            val isBlessed: Boolean
            private val isImmortal: Boolean) {
    var name = _name
        get() = "${field.capitalize()} of $hometown"
        private set(value) {
            field = value.trim()
        }
<<  val hometown = selectHometown()
>>  val hometown by lazy { selectHometown() }
    
    ...
    private fun selectHometown() = File("towns.txt")
            .readText()
            .split("\n")
            .shuffled()
            .first()
}
```

In this lambda, the result of __selectHometown__ is implicity returned and assigned to hometown.

hometown remains unitialized until it is reference for the first time. At that point, all of the code in __lazy__'s lambda is executed. Importantly, this code is only execute once - on the first time that the delefate property (hometown, here) us accessed in name's getter. Future access to the lazy property will use a cached result instead of performing the expinsuce computation again.

Late initialization is useful, but it can be a bit verbose, so stick to using lazy initializacion for more computationally need tasks.

# 14. Inhertance

_Inheritance_ is an object-oriented principle you can use to define hierarchical relation ships between types.

## Defining the Room Class

### Listing 14.1 Declaring the Room class (Room.kt)
```kotlin
class Room(val name: String) {
    fun description() = "Room: $name"

    fun load() = "Nothing much to see here..."
}
```

### Listing 14.2 Printing the room description (Game.kt)
```kotlin
fun main(args: Array<String>) {
    val player = Player("Madrigal")
    player.castFireball()

    var currentRoom = Room("Foyer")
    println(currentRoom.description())
    println(currentRoom.load())

    // Player status
    printPlayerStatus(player)
}
...
```

## Creating a Subclass

A _subclass_ share all properties wuth the class it inherits from, commonly known as the parent class or _superclass_

Add open keyword to __Room__ so that can be subclassed

### Listing 14.3 Making the Room class open for subclassing (Room.kt)
```kotlin
open class Room(val name: String) { 
    fun description() = "Room: $name"

    fun load() = "Nothing much to see here..."
}
```

### Listing 14.4 Declaring the TownSquare class (Room.kt) 
```kotlin
open class Room(val name: String) { 
    fun description() = "Room: $name"

    fun load() = "Nothing much to see here..."
}

class TownSquare : Room("Town Square")
```

The class declaration includes the class name to the left : __operator__ and constructor invocation to the right.

Override load in the class using the override keyword

### Listing 14.5 Declaring the TownSquare class (Room.kt)
```kotlin
open class Room(val name: String) {
    fun description() = "Room: $name"

    fun load() = "Nothing much to see here..."
}

class TownSquare : Room("Town Square") {
    override fun load() = "The villagers rally and cheer as you enter!"
}
```

### Listing 14.6 Declaring an open function (Room.kt)
```kotlin
open class Room(val name: String) {
    fun description() = "Room: $name"
    open fun load() = "Nothing much to see here..." 
}

class TownSquare : Room("Town Square") {
>>  override fun load() = "The villagers rally and cheer as you enter!"
}
```

Protected visibility is a third option the restricts visibility to the class in which property or function is defined or to any subclasses of that class.

### Listing 14.7 Declaring a protected property (Room.kt)
```kotlin
open class Room(val name: String) {
>>  protected open val dangerLevel = 5
    
    fun description() = "Room: $name\n" + 
>>                      "Danger level: $dangerLevel"
    
    open fun load() = "Nothing much to see here..."
}

class TownSquare : Room("Town Square") {
    override fun load() = "The villagers rally and cheer as you enter!"
}
```
This scenario is perfect for the _protected_ keyword: you want to expose a property only to the class where the property is defined and its subclasses.

You can reference a class's superclass using the __super__ keyword. From therem you have access to any public or protected properties or functions, including, in this case, _dangerLevel_.

### Listing 14.8 Overriding dangerLevel (Room.kt) 
```kotlin
open class Room(val name: String) {
    protected open val dangerLevel = 5
    
    fun description() = "Room: $name\n" +
            "Danger level: $dangerLevel"
    
    open fun load() = "Nothing much to see here..."
}
class TownSquare : Room("Town Square") {
>>  override val dangerLevel = super.dangerLevel - 3
    
    override fun load() = "The villagers rally and cheer as you enter!"
}
```

### Listing 14.9 Adding a new property and function to a subclass (Room.kt) 
```kotlin
open class Room(val name: String) {
    protected open val dangerLevel = 5
    fun description() = "Room: $name\n" +
            "Danger level: $dangerLevel"
    open fun load() = "Nothing much to see here..."
}

class TownSquare : Room("Town Square") {
    override val dangerLevel = super.dangerLevel - 3 
>>  private var bellSound = "GWONG"
    
    override fun load() = "The villagers rally and cheer as you enter!\n${ringBell()}" 
    
>>  private fun ringBell() = "The bell tower announces your arrival. $bellSound"
}
```

### Listing 14.10 Calling subclass function implementation (Game.kt)
```kotlin
fun main(args: Array<String>) {
    val player = Player("Madrigal")
    player.castFireball()

<<  var currentRoom: Room = Room("Foyer")
>>  var currentRoom: Room = TownSquare() 
    println(currentRoom.description()) 
    println(currentRoom.load())
    
    // Player status
    printPlayerStatus(player)
}
...
```

Polymorphism is a strategy for simplifying the structure of your program. It allows you to reuse functions for common sets of features across groups of classes and also to customize the behavior for unique needs of a class.


### Listing 14.11 Declaring a function to be final (Room.kt) 
```kotlin
open class Room(val name: String) {
    protected open val dangerLevel = 5

    fun description() = "Room: $name\n" +
            "Danger level: $dangerLevel"

    open fun load() = "Nothing much to see here..."
}

>>open class TownSquare : Room("Town Square") { 
    override val dangerLevel = super.dangerLevel - 3 private var bellSound = "GWONG"

>>  final override fun load() =
        "The villagers rally and cheer as you enter!\n${ringBell()}"
    
    private fun ringBell() = "The bell tower announces your arrival. $bellSound"
}
```

## Type Checking

### Listing 14.12 Instantiating a Room (REPL)
```kotlin
var room = Room("Foyer")
room is Room
true
```

### Listing 14.14 Checking room is TownSquare (REPL)
```kotlin
room is TownSquare
false
```

### Listing 14.15 Checking townSquare is TownSquare (REPL)
```kotlin
var townSquare = TownSquare() townSquare is TownSquare
true
```

### Listing 14.16 Checking townSquare is Room (REPL)
```kotlin
townSquare is Room
true
```

### Listing 14.17 Type checking as a branching condition (REPL)
```kotlin
var townSquare = TownSquare()
var className = when(townSquare) {
    is TownSquare -> "TownSquare"
    is Room -> "Room"
    else -> throw IllegalArgumentException()
}
print(className)
```

## The kotlin Type Hierarchy

Every class in kotlin descends from a common superclass, known as __Any__, without ypu having to explicitly subclass it in your code

```kotlin
    Any -> Room -> TownSquare
```

## Type casting

Type casting allows you to treat an object as if it were an instance of a different type. This gives you the power to do anything with an object that you would of the type ypu specify (such as call functions on it).

```kotlin
fun printIsSourceOfBlessings(any: Any) {
    val isSourceOfBlessings = if (any is Player) {
        any.isBlessed
    } else {
>>      (any as Room).name == "Fount of Blessings"
    }
    println("$any is a source of blessings: $isSourceOfBlessings")
}
```

The __as__ operator denotes a type cast. This cast says, "Treat any as if it were of type __Room__ for the purpose of this expression".

# 15. Objects

This chapter introduces _object declarations_ as well as other types of classes: _nested classes_, _data classes_ and _enum classes_.

## The object keyword
If you need to hold on to a single instance with state is consistent throughout the time that your program is running, consider defining a _singleton_. With the object keyword, you specify thta a class will be limited to a single instance - a singleton. The first time you access an object, it is instantiated for you. That same instance will persist as long as your program is running, and each subsequent access will then return original instance.

There are three ways to use the object keyword: _object declarations_, _objects expressions_ and _companion objects_

## Objects declarations
Objects declarations are useful for organization and state management, especially when you need to maintain some state consistently theroughout the lifespam of your program.

### Listing 15.1 Declaring Game object (Game.kt)
```kotlin
    fun main(args: Array<String>) {
        ... 
    }

    private fun printPlayerStatus(player: Player) {
        println("(Aura: ${player.auraColor()}) " +
                "(Blessed: ${if (player.isBlessed) "YES" else "NO"})")
        println("${player.name} ${player.formatHealthStatus()}")
    }

>>  object Game {
>>  }
```

The main function in Game.kt should now serve exclisively to kick off gameplay. All game logic will be encapsulated in the __Game__ object, of which there will be only one instance.

Beacause an object declaration is instantiated for you, you do not add a custom with code to be called at initialization. Instead, you need an initializer block for any code that you want to be called when your object is initialized. Add one to the Game object with a greeting to be printed to the console when the object in instantiated.

### Listing 15.2 Adding an init block to Game (Game.kt)
```kotlin
fun main(args: Array<String>) {
... 
}
private fun printPlayerStatus(player: Player) {
    println("(Aura: ${player.auraColor()}) " +
            "(Blessed: ${if (player.isBlessed) "YES" else "NO"})")
    println("${player.name} ${player.formatHealthStatus()}")
}

object Game {
>>    init {
>>        println("Welcome, adventurer.")
>>    }
}
```

Your welcome message does not print, because __Game__ has not been initialized. And __Game__ has not been initialized because it has not been referenced yet.

Add __play__ to __Game__ and call it from __main__. When you call a function defined in an object declaration, you call it using the name of the object in which it is defined - not on an instance of a class, as you do for other class functions.

### Listing 15.3 Calling a function defined on an object declaration (Game.kt)
```kotlin
fun main(args: Array<String>) {
    ...
    // Player status
    printPlayerStatus(player)
    Game.play()
}

private fun printPlayerStatus(player: Player) {
    println("(Aura: ${player.auraColor()}) " +
            "(Blessed: ${if (player.isBlessed) "YES" else "NO"})")
    println("${player.name} ${player.formatHealthStatus()}")
}

object Game {
    init {
        println("Welcome, adventurer.")
    }
    
>>    fun play() {
>>        while (true) {
>>            // Play NyetHack
>>        }
>>    }
}
```

### Listing 15.4 Encapsulating properties and functions within the object declaration (Game.kt)
```kotlin
fun main(args: Array<String>) {
<<  val player = Player("Madrigal")
<<  player.castFireball()

<<  var currentRoom: Room = TownSquare()
    println(currentRoom.description())
    println(currentRoom.load())
    
    // Player status
    printPlayerStatus(player)
    Game.play()
}

<<  private fun printPlayerStatus(player: Player) {
<<      println("(Aura: ${player.auraColor()}) " +
<<              "(Blessed: ${if (player.isBlessed) "YES" else "NO"})")
<<      println("${player.name} ${player.formatHealthStatus()}")
<<  }

    object Game {
>>      private val player = Player("Madrigal")
>>      private var currentRoom: Room = TownSquare()
  
        init {
            println("Welcome, adventurer.")
>>          player.castFireball()
        }

    fun play() {
        while (true) {
            // Play NyetHack
        }
    }

>>    private fun printPlayerStatus(player: Player) {
>>        println("(Aura: ${player.auraColor()}) " +
>>                "(Blessed: ${if (player.isBlessed) "YES" else "NO"})")
>>        println("${player.name} ${player.formatHealthStatus()}")
>>    }

}
```

### Listing 15.5 Printing status in the game loop (Game.kt)
```kotlin
fun main(args: Array<String>) {
<<  println(currentRoom.description())
<<  println(currentRoom.load())
<<  // Player status
<<  printPlayerStatus(player)

    Game.play()
}

object Game {
    private val player = Player("Madrigal")
    private var currentRoom: Room = TownSquare()
    
    init {
        println("Welcome, adventurer.")
        player.castFireball()
    }
    
    fun play() {
        while (true) {
<<          // Play NyetHack
>>          println(currentRoom.description())
>>          println(currentRoom.load())
>>          // Player status
>>          printPlayerStatus(player)
        } 
    }

    private fun printPlayerStatus(player: Player) {
        println("(Aura: ${player.auraColor()}) " +
                "(Blessed: ${if (player.isBlessed) "YES" else "NO"})")
        println("${player.name} ${player.formatHealthStatus()}")
    } 
}
```

If you were to run Game.kt, it would loop indefinitely, as there is nothing to stop the loop. The last step for the game loop, at least for now

### Listing 15.6 Accepting user input (Game.kt)
```kotlin
...
object Game {
    ...
    fun play() {
        while (true) {
            println(currentRoom.description())
            println(currentRoom.load())
    
            // Player status
            printPlayerStatus(player)
    
>>          print("> Enter your command: ")
>>          println("Last command: ${readLine()}")
        } 
    }
... 
}

```

## Companion objects
If you would like to the initialization of an object a class instancem there is another option for you: a __companion object__. A __companion object__ es declared within another class declaration using the companion modifies. A class can have no more than more companion object.

There are two case in which a companion object will be initialized, First, a companion obect is initialized when its enclosing class is initialized. this makes it a good place for singleton data that has a contextual connection to a class definition. Second, a companion object is initialized when one of its properties or function is accessed directly

By example.
```kotlin
class PremadeWorldMap {
    ...
    companion object {
        private const val MAPS_FILEPATH = "nyethack.maps"
        fun load() = File(MAPS_FILEPATH).readBytes()
    }
}
```

__PremadeWorldMap__ has compaion object with one function called __load__
```kotlin
    PremadeWorldMap.load()
```

And no matter how many times __PremadeWorldMap__ in instantiated, there will only ever be one instnace of its companion object.

Understanding the differences in how and when object declarations, object expressions, and companion objects are instantiated is key in understanding when to use each of them effectively.

## Nested Classes
Not all classes defined within other classes are declared without a name. You can also use the class keyword to define a named class _nested_ inside of another class.

Create a private class within the __Game__ object to provide this abstraction.

### Listing 15.7 Defining a nested class (Game.kt)
```kotlin
...
object Game {
    ...
        private class GameInput(arg: String?) {
            private val input = arg ?: ""
            val command = input.split(" ")[0]
            val argument = input.split(" ").getOrElse(1, { "" })
    }
}
```

The __GameInput__ class is only relevant to __Game__; it does not need to be accessed from anywhere else in NyeHack, Making __GameInput__ a private, nested class means that GameInput can be used __Game__ but does not clutter the rest of your API.

### Listing 15.8 Defining a function in a nested class (Game.kt)
```kotlin
...
object Game {
    ...
    private class GameInput(arg: String?) {
        private val input = arg ?: ""
        val command = input.split(" ")[0]
        val argument = input.split(" ").getOrElse(1, { "" })
    
>>      private fun commandNotFound() = "I'm not quite sure what you're trying to do!"
    } 
}
```

### Listing 15.9 Defining the __processCommand__ function (Game.kt)
```kotlin
...
object Game {
    ...
    private class GameInput(arg: String?) {
        private val input = arg ?: ""
        val command = input.split(" ")[0]
        val argument = input.split(" ").getOrElse(1, { "" })

>>      fun processCommand() = when (command.toLowerCase()) {
>>          else -> commandNotFound()
>>      }

        private fun commandNotFound() = "I'm not quite sure what you're trying to do!"
    }
}
```

### Listing 15.10 Using __GameInput__ (Game.kt)
```kotlin
...
object Game {
    ...
    fun play() {
        while (true) {
            println(currentRoom.description())
            println(currentRoom.load())
            // Player status
            printPlayerStatus(player)
            print("> Enter your command: ")
<<          println("Last command: ${readLine()}")
>>          println(GameInput(readLine()).processCommand())
        } 
    }
    ... 
}
```

Run Game.tk

## Data classes
A data classes designed specifically for holding data, and they come with some powerful data manupulationbenefits.
```kotlin
Listing 15.11 Defining a data class (Navigation.kt)
data class Coordinate(val x: Int, val y: Int) {
    val isInBounds = x >= 0 && y >= 0
}
```

### Listing 15.12 Tracking player position (Player.kt)
```kotlin
class Player(_name: String,
             var healthPoints: Int = 100,
             val isBlessed: Boolean,
             private val isImmortal: Boolean) {
    var name = _name
        get() = "${field.capitalize()} of $hometown"
        private set(value) {
            field = value.trim()
        }
    
    val hometown by lazy { selectHometown() }
    var currentPosition = Coordinate(0, 0)
... 
}
```

Any provides default implementations for all of these functions, but, as you have before, they are often not very reader friendly. Data classes procide implementations for these functions that may work better for yo project. In this section, we will talk through two of those functions and some of the other benefits of using data classes to represent data in your codebase.

* toString
* equals
* copy
```kotlin
    val mortalPlayer = player.copy(isImmortal = false)
```

## Destructuring declaration
Another bemefit if data classes is that they automatically enable your class's data to be destrcutured.

The example of destructuring you have seen up to this point have involved things like the list output from split.

Under the hood, destructuring depend on the declaration of functions with names like __component1__, __component2__, etc., each declared for some piece of data that you would like to return. Data classes automatically add these functions for you each property defined in their primary constructor.

There is nothing magic about a class supporting destructoring; a data class simply does tje extra work required to make the class "destructurable" for you. You can make any class support destructuring by adding component operator functions to it, like so
```kotlin
class PlayerScore(val experience: Int, val level:Int ){
        operator fun component1() = experience
        operator fun component2() = level
    }

    val (experience, level) = PlayerScore(1250, 5)
```

However, there are also some limitations and requirements on data classes.

* must have a primary constructor with at least one parameter.
* require their primary constructor parameters to be marked wither `val` or `var`
* cannot be abstract, open, sealed, or inner.

## Enumerated Classes
_Enumerated classes_, or "enums", are specual type of class useful for defining a collection od constants, known as _enumerated types_

### Listing 15.13 Defining an enum (Navigation.kt)
```kotlin
enum class Direction {
    NORTH,
    EAST,
    SOUTH,
    WEST
}

data class Coordinate(val x: Int, val y: Int) {
    val isInBounds = x >= 0 && y >= 0
}
```

### Listing 15.14 Defining an enum constructor (Navigation.kt)
```kotlin
enum class Direction(private val coordinate: Coordinate) { 
    NORTH(Coordinate(0, -1)),
    EAST(Coordinate(1, 0)),
    SOUTH(Coordinate(0, 1)),
    WEST(Coordinate(-1, 0)) 
}

data class Coordinate(val x: Int, val y: Int) {
    val isInBounds = x >= 0 && y >= 0
}
```

Add a function called updateCoordinate to Directionto change the player's location based on their movement.
### Listing 15.15 Defining a function in an enum (Navigation.kt)
```kotlin
enum class Direction(private val coordinate: Coordinate) {
    NORTH(Coordinate(0, -1)),
    EAST(Coordinate(1, 0)),
    SOUTH(Coordinate(0, 1)),
    WEST(Coordinate(-1, 0));

>>  fun updateCoordinate(playerCoordinate: Coordinate) =
>>          Coordinate(playerCoordinate.x + coordinate.x, playerCoordinate.y + coordinate.y)
}


data class Coordinate(val x: Int, val y: Int) {
    val isInBounds = x >= 0 && y >= 0
}

```

## Operator Overloading
When you want to use built-in operators with your custom types, you have to override the operators functions to tell the compiler how ti implement them for you type. This is known as _operator overloading_

### Listing15.16 Overloadingtheplusoperator(Navigation.kt)
```kotlin
enum class Direction(private val coordinate: Coordinate) {
    NORTH(Coordinate(0, -1)),
    EAST(Coordinate(1, 0)),
    SOUTH(Coordinate(0, 1)),
    WEST(Coordinate(-1, 0));

    fun updateCoordinate(playerCoordinate: Coordinate) =
            Coordinate(playerCoordinate.x + coordinate.x, playerCoordinate.y + coordinate.y)
}


data class Coordinate(val x: Int, val y: Int) {
    val isInBounds = x >= 0 && y >= 0
>>  operator fun plus(other: Coordinate) = Coordinate(x + other.x, y + other.y)
}
```

Now , you can simply use the addition operator `(x)` to add two Coordinate instances together.

### Listing 15.17 Using an overloaded operator (Navigation.kt)
```kotlin
enum class Direction(private val coordinate: Coordinate) {
    NORTH(Coordinate(0, -1)),
    EAST(Coordinate(1, 0)),
    SOUTH(Coordinate(0, 1)),
    WEST(Coordinate(-1, 0));

    fun updateCoordinate(playerCoordinate: Coordinate) =
<<      Coordinate(playerCoordinate.x + coordinate.x, playerCoordinate.y + coordinate.y) 
>>      coordinate + playerCoordinate

}

data class Coordinate(val x: Int, val y: Int) {
    val isInBounds = x >= 0 && y >= 0
    operator fun plus(other: Coordinate) = Coordinate(x + other.x, y + other.y)
}
```

Come commonly used operators you can override.
### Table 15.1 Common operators
| Operator | Function name | Purpose |
|---|---|---|
| + | __plus__ | Adds an object to another |
| += | __plussAssign__ | Adds an object to another and assign the result to the first |
| == | __equals__ | Returns true if two objects are equal, false otherwise |
| > | __compareTo__ | Returns true if the object on the lefthand side is greaterthan the object on the righthand side, false otherwise |
| [] | __get__ | Returns the element in a collection at a give index |
| .. | __rangeTo__ | Creates a range object |
| in | __contains__ | Returs true if an object exists within a collection |

## Aditional, exploring the world of NyetHack

### Listing 15.18 Defining a world map in NyetHack (Game.kt)
```kotlin
...
object Game {
    private val player = Player("Madrigal")
    private var currentRoom: Room = TownSquare()

>>  private var worldMap = listOf(
>>      listOf(currentRoom, Room("Tavern"), Room("Back Room")),
>>      listOf(Room("Long Corridor"), Room("Generic Room")))
    ...
}
```

### Listing 15.19 Defining the move function (Game.kt)
```kotlin
...
object Game {
    private var currentRoom: Room = TownSquare()
    private val player = Player("Madrigal")
    
    private var worldMap = listOf(
        listOf(currentRoom, Room("Tavern"), Room("Back Room")),
        listOf(Room("Long Corridor"), Room("Generic Room")))
    ...

    private fun move(directionInput: String) =
        try {
            val direction = Direction.valueOf(directionInput.toUpperCase())
            val newPosition = direction.updateCoordinate(player.currentPosition)
            if (!newPosition.isInBounds) {
                throw IllegalStateException("$direction is out of bounds.")
            }
    
            val newRoom = worldMap[newPosition.y][newPosition.x]
            player.currentPosition = newPosition
            currentRoom = newRoom
            "OK, you move $direction to the ${newRoom.name}.\n${newRoom.load()}"
        } catch (e: Exception) {
            "Invalid direction: $directionInput."
        }
}
```

### Listing 15.20 Defining the processCommand function (Game.kt)
```kotlin
...
object Game {
    ...
    private class GameInput(arg: String?) {
        private val input = arg ?: ""
        val command = input.split(" ")[0]
        val argument = input.split(" ").getOrElse(1, { "" })

        fun processCommand() = when (command.toLowerCase()) {
>>          "move" -> move(argument)
            else -> commandNotFound()
        }

        private fun commandNotFound() = "I'm not quite sure what you're trying to do!"
    }
}
```

# 16. Interfaces and Abstract Classes

an interface allows you to specify common properties and beahvior that are supported by a subset of classes in your program - without being required to specify how they will be implemented. This capability - the _what_ without _the how_ - is useful when inheritance is not the right relationship for classes in a program. Using an interface, a group of classes can have properties or functions in common without sharing a superclass or sublcasing one other.

## Defining an Interface
You will first create an interface that specifies the functions and properties used for entities.

### Listing 16.1 Defining an interface (Creature.kt)
```kotlin
interface Fightable {
    var healthPoints: Int
    val diceCount: Int
    val diceSides: Int
    val damageRoll: Int

    fun attack(opponent: Fightable): Int
}
```
Your interface declaration defines  things that are common to eny entity.

## Implementing an Interface
To use an interface, we say that you "implemnt" it on a class. There two parts to this: First, you declare that the class implements the interface. Then, you must ensure that the class provides implementations for all the properties and functions specified in the interface

Use the `:` operator to implemnt an interface.

### Listing 16.2 Implementing an interface (Player.kt)
```kotlin
class Player(_name: String,
>>  override var healthPoints: Int = 100,
    var isBlessed: Boolean = false,
>>  private var isImmortal: Boolean) : Fightable {
    
    ... 
    
    }
```

When you add the interface to the main class, IntelliJ indicates that functions and properties are missing.

### Listing 16.3 Stubbing out an interface implementation (Player.kt)
```kotlin
class Player(_name: String,
            override var healthPoints: Int = 100,
            var isBlessed: Boolean = false,
            private var isImmortal: Boolean) : Fightable {
            
        override val diceCount: Int = 3
<<          get() = TODO("not implemented")
<<          //To change initializer of created properties use 
<<          //File | Settings | File Templates.

        override val diceSides: Int = 6
<<          get() = TODO("not implemented")
<<          //To change initializer of created properties use 
<<          //File | Settings | File Templates.
    
        override fun attack(opponent: Fightable): Int {
<<          TODO("not implemented")
<<          //To change body of created functions use
<<          //File | Settings | File Templates.
>>          val damageDealt = if (isBlessed) {
>>              damageRoll * 2
>>          } else {
>>              damageRoll 
>>          }
>>          opponent.healthPoints -= damageDealt
>>          return damageDealt
>>      }
    ... 
}
```

## Default Implementations
We said several times now that interface focus on the what and not the how. You can, however provide a default implementation for property getters and functions in an interface. Classes that implement the interface then have option of using the default of defining their own implementation.

### Listing 16.4 Defining a default getter implementation (Creature.kt)
```kotlin
interface Fightable {
    var healthPoints: Int
    val diceCount: Int
    val diceSides: Int
    val damageRoll: Int
        get() = (0 until diceCount).map {
            Random().nextInt(diceSides + 1)
        }.sum()
        
    fun attack(opponent: Fightable): Int
}
```

## Abstract Classes
Abstract classes provide another way to enforce structure in your classes. An abstract class is never instantiated. Its purpose is to provide function implementations throughinheritance to subclasses that are instantiated.

An abstract class is defined by prepending the abstract keyword to a class definition. In addition to function implementations, abstract classes can include _abstract functions_ - function declarations without implementations.


### Listing 16.5 Defining an abstract class (Creature.kt)
```kotlin
interface Fightable {
    var healthPoints: Int
    val diceCount: Int
    val diceSides: Int
    val damageRoll: Int
        get() = (0 until diceCount).map {
            Random().nextInt(diceSides + 1)
        }.sum()
    
    fun attack(opponent: Fightable): Int
}

>>    abstract class Monster(val name: String,
>>                           val description: String,
>>                           override var healthPoints: Int) : Fightable {
>>
>>        override fun attack(opponent: Fightable): Int {
>>            val damageDealt = damageRoll
>>            opponent.healthPoints -= damageDealt
>>            return damageDealt
>>        } 

}
```

### Listing 16.6 Subclassing an abstract class (Creature.kt)
```kotlin
interface Fightable {
    ... 
}

abstract class Monster(val name: String,
                       val description: String,
                       override var healthPoints: Int) : Fightable {

    override fun attack(opponent: Fightable): Int {
        val damageDealt = damageRoll
        opponent.healthPoints -= damageDealt
        return damageDealt
    } 

}

>>    class Goblin(name: String = "Goblin",
>>                 description: String = "A nasty-looking goblin",
>>                 healthPoints: Int = 30) : Monster(name, description, healthPoints) {
}
```


### Listing 16.7 Implementing properties in the subclass of an abstract class (Creature.kt)
```kotlin
interface Fightable {
    ... 
}

abstract class Monster(val name: String,
                       val description: String,
                       override var healthPoints: Int) : Fightable {
    ...
}

class Goblin(name: String = "Goblin",
             description: String = "A nasty-looking goblin",
             healthPoints: Int = 30) : Monster(name, description, healthPoints) {
    
    override val diceCount = 2
    override val diceSides = 8

}
```

## Combat in NyetHack
Add a monster proeprty of nullable type __Monter?__to the __Room__ class, and initialize it by assigning it a __Goblin__. Update __Room's__ description to let the player know whether the room has a monster to fight.

### Listing 16.8 Adding a monster to each room (Room.kt)
```kotlin
open class Room(val name: String) {
    protected open val dangerLevel = 5 
>>  var monster: Monster? = Goblin()

    fun description() = "Room: $name\n" + 
                        "Danger level: $dangerLevel\n" + 
>>                      "Creature: ${monster?.description ?: "none."}" 

    open fun load() = "Nothing much to see here..."
}
```

### Listing 16.9 Defining the __fight__ function(Game.kt)
```kotlin
...
object Game {
    ...

    private fun move(directionInput: String) = ...
    
    private fun fight() = currentRoom.monster?.let {
            while (player.healthPoints > 0 && it.healthPoints > 0) {
                Thread.sleep(1000)
            }
            "Combat complete."
        } ?: "There's nothing here to fight."

    private class GameInput(arg: String?) {
        ... 
    }
}
```

### Listing 16.10 Defining the __slay__ function (Game.kt)
```kotlin
...
object Game {
    ...
    
    private fun fight() = ...
    
    private fun slay(monster: Monster) {
        println("${monster.name} did ${monster.attack(player)} damage!")
        println("${player.name} did ${player.attack(monster)} damage!")

        if (player.healthPoints <= 0) {
            println(">>>> You have been defeated! Thanks for playing. <<<<")
            exitProcess(0)
        }

        if (monster.healthPoints <= 0) {
            println(">>>> ${monster.name} has been defeated! <<<<")
            currentRoom.monster = null
        }
    }
    
    private class GameInput(arg: String?) {
        ... 
    }
}
```

Call slay from fight.
### Listing 16.11 Calling the slay function (Game.kt)
```kotlin

...
object Game {
    ...
    
    private fun move(directionInput: String) = ...

    private fun fight() = currentRoom.monster?.let {
        while (player.healthPoints > 0 && it.healthPoints > 0) {
            slay(it)
            Thread.sleep(1000)
        }
        "Combat complete."
    } ?: "There's nothing here to fight."

    private fun slay(monster: Monster) {
        ... 
    }

    private class GameInput(arg: String?) {
        ... 
    }
}
```

### Listing 16.12 Adding the fight command (Game.kt)
```kotlin
...
object Game {
...
    private class GameInput(arg: String?) {
        private val input = arg ?: ""
        val command = input.split(" ")[0]
        val argument = input.split(" ").getOrElse(1, { "" })
   
        fun processCommand() = when (command.toLowerCase()) {
>>          "fight" -> fight()
            "move" -> move(argument)
            else -> commandNotFound()
        }

        private fun commandNotFound() = "I'm not quite sure what you're trying to do!"
    }
}
```

# 17. Generics
List can hold any type because of _generics_, a type system feature that allows both functions and types to work types that are not yet known to you of the compiler.

Generics greatly expand the reusability of your class definitions, because they allow your definitions to work with many types.


## Defining Generic Types
A _generic type_ is a class that accepts an input of any type in its constructor.


### Listing 17.1 Creating a generic type (Generics.kt)
```kotlin
class LootBox<T>(item: T) {
    private var loot: T = item
}
```

You define the __LootBox__ class an make it generic by specifying a generic type parameter for use with the class, written as `T` abd specified within diamon braces (< >) like other type parameters. The generic type parameter, `T`, is a placeholder for the item's type.


Note that the generic type parameter is usually represented with a single leyyer T, short for "type" though any letter or word can be used. The book suggest generally stick with T, since it is what is commonly used in other lenguages that support generics and is therefore teh most readable choice.

### Listing 17.2 Defining loot boxes (Generics.kt)
```kotlin
class LootBox<T>(item: T) {
    private var loot: T = item
}

class Fedora(val name: String, val value: Int)
class Coin(val value: Int)

fun main(args: Array<String>) {
    val lootBoxOne: LootBox<Fedora> = LootBox(Fedora("a generic-looking fedora", 15))
    val lootBoxTwo: LootBox<Coin> = LootBox(Coin(15))
}
```

Notice thr type signature for each LootBox variable:
```kotlin
val lootBoxOne: LootBox<Fedora> = LootBox(Fedora("a generic-looking fedora", 15))
val lootBoxTwo: LootBox<Coin> = LootBox(Coin(15))
```

The diamond braces on the type signature for the variable show what type of loot a particular __LootBox__ instance is capable of holding.

## Generic Functions
Generic type parameters also work with functions. That is good news, since there is currently no way for a player to retrieve loot from a loot box.

### Listing 17.3 Adding a __fetch__ function (Generics.kt)
```kotlin
class LootBox<T>(item: T) {
    
    var open = false
    private var loot: T = item
    
    fun fetch(): T? {
       return loot.takeIf { open }
    }
}
```

Here you define a generic function, __fetch__, that return T - the generic type parameter specified on the __LootBox__ class, which is a placeholder for the type of item.

### Listing 17.4 Testing the generic fetch function (Generics.kt)
```kotlin
...
fun main(args: Array<String>) {
    
    val lootBoxOne: LootBox<Fedora> = LootBox(Fedora("a generic-looking fedora", 15))
    val lootBoxTwo: LootBox<Coin> = LootBox(Coin(15))
    
    lootBoxOne.fetch()?.run {
        println("You retrieve $name from the box!")
    }
}
```

### Listing 17.5 Opening the box (Generics.kt)
```kotlin
...
fun main(args: Array<String>) {
    
    val lootBoxOne: LootBox<Fedora> = LootBox(Fedora("a generic-looking fedora", 15))
    val lootBoxTwo: LootBox<Coin> = LootBox(Coin(15))
    
>>  lootBoxOne.open = true
    
    lootBoxOne.fetch()?.run {
        println("You retrieve a $name from the box!")
    }
}
```


## Multiple Generic Type Paramters.
A generic function or type can also support multiple generic type parameters, Suppose you want a second __fetch__ function that accepts a loot-modification function, allowing you to convert the loot to a some other new type, perhaps a coin, when you fetch it. The value of the coin returned depends on the value of the original loot - and a lootModFunction higher-order function that us passed to __fetch__ will determinate that.

### Listing 17.6 Using multiple generic type parameters (Generics.kt)
```kotlin
class LootBox<T>(item: T) {

    var open = false
    private var loot: T = item

    fun fetch(): T? {
        return loot.takeIf { open }
    }

    fun <R> fetch(lootModFunction: (T) -> R): R? {
        return lootModFunction(loot).takeIf { open }
    }
} 
...
```

Here, you add a new generic type parameter to the function R, short for the "return", since the generic type parameter will be used for fetch's return type. You place the generic type parameter in diamond braces directly before the function name: `fun <R> fetch`. __fetch__ returns a value of type `R?`, anullable version of R.

You also specify that the lootModFunction (via its function type declaration, (T) -> R ) accepts an argument of type T and returns a result of type R. Try out the new __fetch__ function that you defined - this time, apssing a loot-modification function as an argument.

### Listing 17.7 Passing the loot-modification function as an argument (Generics.kt)
```kotlin
...
fun main(args: Array<String>) {
    val lootBoxOne: LootBox<Fedora> = LootBox(Fedora("a generic-looking fedora", 15))
    val lootBoxTwo: LootBox<Coin> = LootBox(Coin(15))
   
    lootBoxOne.open = true
    lootBoxOne.fetch()?.run {
        println("You retrieve $name from the box!")
    }
   
>>  val coin = lootBoxOne.fetch() {
>>      Coin(it.value * 3)
>>  }

>>  coin?.let { println(it.value) }
}
```

## Generic Constraints 
What if you wanted to ensure that the loot box was only used to hold loot, and not something else? You can specify a generic type constraint to enforce exactly that.

### Listing 17.8 Adding a superclass (Generics.kt)
```kotlin
class LootBox<T>(item: T) {

    var open = false
    private var loot: T = item

    fun fetch(): T? {
        return loot.takeIf { open }
    }

    fun <R> fetch(lootModFunction: (T) -> R): R? {
        return lootModFunction(loot).takeIf { open }
    }

}
>>  open class Loot(val value: Int)

>>  class Fedora(val name: String, val value: Int) : Loot(value)
>>  class Coin(val value: Int) : Loot(value)
...
```
Now, add a generic type constraint to LootBox's generic type paramter to allow only descendants of the Loot class to be used with __LootBox__

### Listing 17.9 Constraining the generic parameter to __Loot__ only (Generics.kt)
```kotlin
class LootBox<T : Loot>(item: T) {
    ... 
}
...
```

## vararg and get
you __LootBox__ can now hold any kind of __Loot__, but it cannot hold more that one item at a time. What if you want to hols multiple items of Loot in you __LootBox__?

To do so, modify __lootBox__'s primary constructor with the vararg keyword, which allows a variable number of arguments to be passed to the constructor.

### Listing 17.10 Adding vararg (Generics.kt)
```kotlin
class LootBox<T : Loot>(vararg item: T) {
    ... 
}
...
```

Now that you have added  the `vararg` keyword to __LootBot__, its item cariable will be treated as an Array of elements instead of a single element when it is initialized, and __LootBox__ can accpet multiple items passed into the contructor.

### Listing 17.11 Indexing into the loot array (Generics.kt)
```kotlin
class LootBox<T : Loot>(vararg item: T) {
    var open = false
    private var loot: TArray<out T> = item

    fun fetch(item: Int): T? {
        return loot[item].takeIf { open } 
    }
    
    fun <R> fetch(item: Int, lootModFunction: (T) -> R): R? {
        return lootModFunction(loot[item]).takeIf { open } }
    } 
...
```

Notice the `out` keyword thta you add for the new loot variable's type signature. The out keyword is required here because it is part of the return type for any cariable marked as `vararg`. 

Try out the new and improved  __LootBox__ in __main__. Pass another fedora into the loot box.

### Listing 17.12 Testing the new LootBox (Generics.kt)
```kotlin
...
fun main(args: Array<String>) {
val lootBoxOne: LootBox<Fedora> = LootBox(Fedora("a generic-looking fedora", 15), Fedora("a dazzling magenta fedora", 25))
    
    val lootBoxTwo: LootBox<Coin> = LootBox(Coin(15))
lootBoxOne.open = true lootBoxOne.fetch(1)?.run {
        println("You retrieve $name from the box!")
    }
val coin = lootBoxOne.fetch(0) {
        Coin(it.value * 3)
    }
    coin?.let { println(it.value) }
}
```

Another way to provide index access to the loot array is to have __LootBox__ implement an operator function: the `get` function, which enables the `[]` operator.

Update __LootBox__ to include a __get__ operator implementation.

### Listing 17.13 Adding a get operator to __LootBox__ (Generics.kt)
```kotlin
class LootBox<T : Loot>(vararg item: T) {
   var open = false
   private var loot: Array<out T> = item
   
   operator fun get(index: Int): T? = loot[index].takeIf { open }

   fun fetch(item: Int): T? {
       return loot[item].takeIf { open }
   }
   
   fun <R> fetch(item: Int, lootModFunction: (T) -> R): R? {
       return lootModFunction(loot[item]).takeIf { open }
   }
} 
...
```

Now use the new __get__ operator in your __main__ function

### Listing 17.14 Using get (Generics.kt)
```kotlin
...
fun main(args: Array<String>) {
    ...
    coin?.let { println(it.value) }
   
>>  val fedora = lootBoxOne[1]
>>  fedora?.let { println(it.name) }
}
```

## __in__ and __out__
To further customize your generic type parameter. Kotlin provides the keywords `in` and `out`

### Listing 17.15 Defining Barrel (Variance.kt) 
```kotlin
class Barrel<T>(var item: T)
```

### Listing 17.16 Defining Barrels in main (Variance.kt)
```kotlin
class Barrel<T>(var item: T)
fun main(args: Array<String>) {
    var fedoraBarrel: Barrel<Fedora> = Barrel(Fedora("a generic-looking fedora", 15))
    var lootBarrel: Barrel<Loot> = Barrel(Coin(15))
}
```

### Listing 17.17 Attempting to reassign lootBarrel (Variance.kt)
```kotlin
class Barrel<T>(var item: T)
fun main(args: Array<String>) {
    var fedoraBarrel: Barrel<Fedora> = Barrel(Fedora("a generic-looking fedora", 15))
    var lootBarrel: Barrel<Loot> = Barrel(Coin(15))
    
>>  lootBarrel = fedoraBarrel
}
```

### Listing17.18 Assigning a coin to lootBarrel.item (Variance.kt)
```kotlin
class Barrel<T>(var item: T)
fun main(args: Array<String>) {
    var fedoraBarrel: Barrel<Fedora> = Barrel(Fedora("a generic-looking fedora", 15))
    var lootBarrel: Barrel<Loot> = Barrel(Coin(15))
   
    lootBarrel = fedoraBarrel
>>  lootBarrel.item = Coin(15)
}
```

### Listing17.19 Accessing fedoraBarrel.item (Variance.kt)
```kotlin
class Barrel<T>(var item: T)
fun main(args: Array<String>) {
    var fedoraBarrel: Barrel<Fedora> = Barrel(Fedora("a generic-looking fedora", 15))
    var lootBarrel: Barrel<Loot> = Barrel(Coin(15))
    
    lootBarrel = fedoraBarrel 
    lootBarrel.item = Coin(15)
>>  val myFedora: Fedora = fedoraBarrel.item
}
```

### Listing 17.20 Adding out (Variance.kt) 
```kotlin
class Barrel<out T>(varval item: T)
...
```

### Listing 17.21 Changing the assignment (Variance.kt)
```kotlin
class Barrel<out T>(val item: T)
fun main(args: Array<String>) {
    var fedoraBarrel: Barrel<Fedora> = Barrel(Fedora("a generic-looking fedora", 15))
    var lootBarrel: Barrel<Loot> = Barrel(Coin(15))

    lootBarrel = fedoraBarrel
<<  lootBarrel.item = Coin(15)
<<  val myFedora: Fedora = fedoraBarrel.item
>>  val myFedora: Fedora = lootBarrel.item 
}
```

### Listing 17.22 Marking Barrel within (Variance.kt) 
```kotlin
class Barrel<inout T>(val item: T)
...
```

### Listing 17.23 Reversing the assignment (Variance.kt)
```kotlin
...
fun main(args: Array<String>) {
    var fedoraBarrel: Barrel<Fedora> = Barrel(Fedora("a generic-looking fedora", 15))
    var lootBarrel: Barrel<Loot> = Barrel(Coin(15))

<<  lootBarrel = fedoraBarrel
>>  fedoraBarrel = lootBarrel
<<  val myFedora: Fedora = lootBarrel.item
}
```

# 18. Extensions
__Extensions__ allow you to add functionality to a type without directly modifying the type's definition. You can use extensions with your own types and also types you do not control, like __List__, __Strings__ and other types from the Kotlin standard library.

Extensions are an alternative to the sharing bahavior of inheritance.

The Kotlin standard library frequently uses extensions.

## Defining Extensions Functions.
My first extensions allows you to add a specified amount of enthusiasm to any String.

### Listing 18.1 Addiing an extension to String (Extensions.kt)
```kotlin
fun String.addEnthusiasm(amount: Int = 1) = this + "!".repeat(amount)
```

When you specify an extension function, you also specify the type the extensions adds functionality to, known as the __receiver type__. For the _addEnthusiasm_ function, the receiver type you specified us String.

__addEnthusiasm's__ function body is a single-expression function that returns a new string: the contents of this plus 1 or more exclamations points, based on the argument passed to amount. The _this_ keyword refers to the receiver instance the extension function was called on a String instance, in this case.

### Listing 18.2 Calling the new extension on a String receiver instance (Extensions.kt)
```kotlin
fun String.addEnthusiasm(amount: Int = 1) = this + "!".repeat(amount)

fun main(args: Array<String>) {
    println("Madrigal has left the building".addEnthusiasm())
}
```


## Defining an extension on a superclass
Extension do not rely on inheritance, but they can be combined with inheritance to expand their scope. Define an extension on the Any type called __easyPrint__

### Listing 18.3 Extending Any (Extensions.kt)
```Kotlin
fun String.addEnthusiasm(amount: Int = 1) = this + "!".repeat(amount) 

fun Any.easyPrint() = println(this)

fun main(args: Array<String>) {
    "Madrigal has left the building".addEnthusiasm().easyPrint() 
}
```

Since you added the extension for the any type, it is also available for use with other subtyes. Call the extension on an `Int` after the `String` 

### Listing 18.4 __easyPrint__ is available on all subtypes (Extensions.kt)
```kotlin
fun String.addEnthusiasm(amount: Int = 1) = this + "!".repeat(amount)

fun Any.easyPrint() = println(this)

fun main(args: Array<String>) {
    "Madrigal has left the building".addEnthusiasm().easyPrint()
    42.easyPrint()
}
```

## Generic Extension Functions

### Listing 18.5 Making __easyPring__ chainable (Extesions.kt)
```kotlin
fun String.addEnthusiasm(amount: Int = 1) = this + "!".repeat(amount)

fun Any.easyPrint() : Any { 
    println(this)
    return this 
}

```

Now, try calling the easyPrint function two times: once before addEnthusiasm and once afteward

### Listing 18.6 Calling easyPrint twice (Extensions.kt)
```kotlin
fun String.addEnthusiasm(amount: Int = 1) = this + "!".repeat(amount)

fun Any.easyPrint(): Any {
    println(this)
    return this 
}

fun main(args: Array<String>) {
    "Madrigal has left the building".easyPrint().addEnthusiasm().easyPrint()
    42.easyPrint()
}
```

The code does not compile. The first easyPrint call was allowed, buy addEnthisiasm was not. The easyPrint function returns the String it was called on, but uses Any to represent it. addEnthusiasm is only available on String, so it cannot be called on the return from easyPrint.

To solv this, you can make the extension generic.

### Listing 18.7 Making easyPrint generic (Extensions.kt)
```kotlin
fun String.addEnthusiasm(amount: Int = 1) = this + "!".repeat(amount)

fun <T> T.easyPrint(): T {
    println(this)
    return this 
}
...
```

## Extension Properties
In addition to adding functionality to a type by specifying extension functions, you can also define extensions properties. Add another extension to String in Extensions.kt, this time an extension property that counts a strings' vowels:

### Listing 18.8 Adding an extension property (Extensions.kt)
```kotlin
val String.numVowels
    get() = count { "aeiou".contains(it) }

fun String.addEnthusiasm(amount: Int = 1) = this + "!".repeat(amount)
...
```

Try out your new extension property by printing the numVowel extension in __main__:
### Listing 18.9 Using an extension property (Extensions.kt)
```kotlin
val String.numVowels
    get() = count { "aeiouy".contains(it) }

fun String.addEnthusiasm(amount: Int = 1) = this + "!".repeat(amount)

fun <T> T.easyPrint(): T {
    println(this)
    return this 
}

fun main(args: Array<String>) {
    "Madrigal has left the building".easyPrint().addEnthusiasm().easyPrint() 42.easyPrint()
    "How many vowels?".numVowels.easyPrint()
}
```

## Extensions on Nullable Types
An extension can also be defined for use with nullable type. Defining an extension on a nullable type allows you to deal with the possibility of the value begin null within the body of extensions function, rather than at the call site.

Add an extension for nullable Strings in Extensions.kt and test it out in the main function:

### Lisintg 18.10 Adding an extension on a nullable type (Extensions.kt)
```kotlin
infix fun String?.printWithdDefault(default: String) = println(this ?: default)

fun main(args: Array<String>) {
    "Madrigal has left the building".easyPrint().addEnthusiasm().easyPrint()
    42.easyPrint()
    "How many vowels?".numVowels.easyPrint()

    val nullableString: String? = null
    nullableString printWithDefault "Default String"
}
```

The `infix` keyword available for both extension and class functions that have a single argument, allows for the cleaner syntax you see in the function call.

If a function is defined with `infix` , you can omit the dow between the receiver and the function call as well the parentheses around the argument.

```kotlin
null printWithDefault "Default string"  // With infix 
null.printWithDefault("Default string") // Without infix 
```

## Extracting to Extensions 
Applying what I have learned to refine NyeHack.

Tavern.kt contains duplicate chains of logic called onseveral collections: `shuffled().first()`
```kotlin
    ...
    (0..9).forEach {
        val first = patronList.shuffled().first()
        val last = lastName.shuffled().first()
    }

    uniquePatrons.forEach {
        patronGold[it] = 6.0
    }

    var orderCount = 0
    while (orderCount <= 9) {
        placeOrder(uniquePatrons.shuffled().first(),
                menuList.shuffled().first())
        orderCount++
    ...
```

### Lisintg 18.11 Adding a private __random__ extension (Tavern.kt)
```kotlin
val patronGold = mutableMapOf<String, Double>()

private fun <T> Iterable<T>.random(): T = this.shuffled().first()

fun main(args: Array<String>) {
    ... 
}
...
```
Now replace the old calls to shuffled().first() with a call to the extension function __random__

### Listing 18.12 Using the __random__ extension (Tavern.kt)
```kotlin
...
private fun <T> Iterable<T>.random(): T = this.shuffled().first()
    fun main(args: Array<String>) {
        ...
        (0..9).forEach {
            val first = patronList.random()
            val last = lastName.random() 
        }

        uniquePatrons.forEach {
            patronGold[it] = 6.0
        }

        var orderCount = 0
        while (orderCount <= 9) {
            placeOrder(uniquePatrons.random(), menuList.random())
            orderCount++
        }
        
        displayPatronBalances()
}
...
```

### Listing 18.14 Adding the __random__ extension to IterableExt.kt (IterableExt.kt)
```kotlin
package com.bignerdranch.nyethack.extensions

fun <T> Iterable<T>.random(): T = this.shuffled().first()
```

### Listing 18.15 Using random in selectHometown (Player.kt)
```kotlin
...
private fun selectHometown() = File("data/towns.txt")
    .readText() 
    .split("\n") 
    .random()
...
```











