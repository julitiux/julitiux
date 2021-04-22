---
title: "Swift"
date: 2020-09-01T21:55:55-05:00
draft: false
toc: false
images:
tags:
  - untagged
---


# **INDEX**


# [Getting Started](#getting-started)
# [Types, Constants, and Variables](#types-constants-and-variables)
## [Types, Strings](#types-strings)
## [Numerical Type](#numerical-type)
## [Constants](#constants)
## [String interpolation](#string-interpolation)
# [Conditional](#conditional)



# Getting Started

First, download and install Xcode, its available on the App Store. Make sure to download Xcode 8 or higher.

Get started with a playground and Create a new Xcode Project. Playsground were released in Xcode6. They provide an interactive enviroment for rapidly developing and evaluating Swift code. A playground does not require that you compile and run a complete project. Instead, playgrouunds evaluate your Swift code on the fly, so its udeal for testing and experimenting with the Swift languaje in a lightweght enviroment.

From the welcomescreen, select Get started with a playground, next, name your playground _MyPlayground_. For the plataform (iOS, macOS, or tvOS), select macOS. Finally, you are prompted to save your playground

```swift
//: Playground - noun: a place where people can play

import Cocoa

var str = "Hello, playground"
str += "!"
```
# Types, Constants, and Variables

## Types, Strings

Variables and constants hava a data type. Here, you have assigned an instance of the _String_ type. The type assignment operator (=) assigns the value on its right side to whatever is on its left side.
Swift uses type inference to determine the data type of your variable; the quotation marks indicate that it is a _String_ literal.

```swift
var variableString: String
var otherVariableString = "Four"

otherVariableString += " add another thing"
print(otherVariableString)
```

## Numerical Type

Now, we are explicitly declaring the variable to be th Int type using Swift's type annotation syntax. The colon on tje code above represents the phrase _"of type"_

```swift
var variableInteger: Int
var otherVariableInteger: Int = 4

otherVariableInteger += 2
print(otherVariableInteger)
```

## Constants

We will want to create instances with values that do not change.
```swift
let constantInteger: Int = 4
let constantString: String = "This a String"

constantInteger += 4 //Error
```

## String interpolation

String interpolation lets you combine constant and variables into a new string.
```swift
var variableInteger: Int = 4
var variableString: String = "String"
let constant: String = "You can use the interpolation in all variables and constants, like \(variableInteger) and \(variableString)"
print(constant)
```
# Conditional
