---
title: "Kotlin"
date: 2022-03-07T14:46:09-06:00
toc: false
images:
tags:
  --untagged
---

# **INDEX**

# Your first kotlin application

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
