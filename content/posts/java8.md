---
title: "Java8"
date: 2021-01-27T23:55:55-06:00
draft: false
toc: false
images:
tags:
  - untagged
---

# Functional programming

Functional Programming is a programming paradigm where the programs are constructed by applying and composing functions.


## Imperative and declarative programming

### Imperative programming:

* Logic programming
* Functional programming

### Declarative programming:

* Structured programming
* Procedural programming
* Modular programming

# Java 8 and Lambdas.

Java 8 use Lambda expressions. This Lambda expressions are anonymous functions, that is, functions that do not need a class. Its basic syntax is detailed below:

```java
(parameters) -> expresion
```

# Lambda

Given a List of String for sort:

```java
List<String> list = new ArrayList<String>();
list.add("one");
list.add("two");
list.add("three");
```

Sort with Imperative programming

```java
Collections.sort(list, new Comparator<String>() {
  @Override
  public int compare(String o1, String o2) {
    return o1.compareTo(o2);
  }
});
```

Sort with Declarative programming

```java
Collections.sort(list, (String o1, String o2) -> o1.compareTo(o2));
```

Using a interface

```java
public interface LambdaService {
  public Double calculateAverage(Double num1, Double num2);
}
```

with a class:

```java
public class LambdaServiceImpl {

//  Imperative programming
  public void calculateImperative(Double num1, Double num2) {
    LambdaService lambdaService = new LambdaService() {
      @Override
      public Double calculateAverage(Double num1, Double num2) {
        return (num1 + num2) / 2;
      }
    };

    System.out.println(lambdaService.calculateAverage(num1, num2));

  }

//  Declarative programming
  public void calculateDeclarative(Double num1, Double num2) {
    LambdaService lambdaService = (Double n1, Double n2) -> (n1 + n2) / 2;
    System.out.println(lambdaService.calculateAverage(num1, num2));
  }

}
```


# Lambda Sintaxis
# Lambda Scopes
# Interface Default Methods
# Functional Interfaces
# Method References
# Colections -> forEach, removeIf, sort
# Streams
# StreamParallels
# Map
# Annotations
# Date API
# High Order Functions
# RXJava
# Nashom
