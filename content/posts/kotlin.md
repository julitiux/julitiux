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
