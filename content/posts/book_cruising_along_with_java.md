---
title: "Cruising Along With Java"
date: 2026-08-28T22:15:15-06:00
draft: true
---

# Chapter 1 - The Evolution of Java

## Recent Changes to Java
* 8 Functional programming capabilities
* 9 Modularization
* 10 Local variable inference
* 11 Local variable syntax for lambda parameters
* 14 switch expression
* 15 Text blocks
* 16 Pattern matching for instance Records
* 17 Sealed classes
* 21 Pattern matching for switch Record patterns
* 22 Unnamed Variables and Patterns
* 24 Stream Gatherers

# Chapter 2 - Using Type Inference

## Generics and Type Witness

### typeinference/vsca/GenericsTypeInference.java
```java
List<String> justOne = Collections.singletonList("howsy");
List<String> nothingHere = Collections.emptyList();
```

### typeinference/vsca/GenericsTypeInference.java
```java
List<Integer> nothingHereToo = Collections.<Integer>emptyList();
//Redundant Type Witness
```

### typeinference/vsca/GenericsTypeWitness.java
```java
public class GenericsTypeWitness {
    public <T> void process(Consumer <T> consumer) {}
    public static void display(int value) {}

    public static void main(String[] args){
        GenericsTypeWitness instance = new GenericsTypeWitness();

        instance.process(input -> display(input)); //ERROR
                                                   //error: incompatible types: Object cannot be converted to int
    }
}
```

### typeinference/vsca/GenericsTypeWitness.java
```java
instance.<Integer>process(input -> display(input));
```

## Diamong Operatior Enhencements

### typeinference/vsca/Diamond.java
```java
Map<String, List<Integer>> scores = new HashMap<String, List<Integer>>();
```

### typeinference/vsca/Diamond.java
```java
Map<String, List<Integer>> scores = new HashMap<>();
```

### typeinference/vsca/Diamond.java
```java
Map<String, List<Integer>> scores = new HashMap<>() {

};
```

## Lambda Expressions Paramters Type Inference

### typeinference/vsca/Lambda.java
```java
number.forEach((Integer number) -> System.out.println(number * 2));
```

### typeinference/vsca/Lambda.java
```java
number.forEach((number) -> System.out.println(number * 2));
```

### typeinference/vsca/Lambda.java
```java
number.forEach(number -> System.out.println(number * 2));
```

### typeinference/vsca/Lambda.java
```java
number.forEach((@NotNull number) -> System.out.println(number * 2)); //ERROR
```

### typeinference/vsca/Lambda.java
```java
number.forEach((@NotNull var number) -> System.out.println(number * 2));
```

### typeinference/vsca/LambdaTypeInferenceFall.java
```java
List<String> languages =
List.of("Java", "Kotlin", "Scala", "Groovy", "Clojure", "JRuby");

languages.stream()
    .sorted(comparing(name -> name.length()))
    .forEach(System:out:println);
```

### typeinference/vsca/LambdaTypeInferenceFall.java
```java
.sorted(comparing(name -> name.length()).reversed())
//ERROR:    cannot find simbol length() on variable name of type Object
```

### typeinference/vsca/LambdaTypeInferenceFall.java
```java
.sorted(comparing((String name) -> name.length()).reversed())
```

### typeinference/vsca/LambdaTypeInferenceFall.java
```java
.sorted(comparing(String::length).reversed())
```

## Local Variable Type Inference

### typeinference/vsca/LocalVariable.java
```java
public static void greet() {
    String message = "Hello there";

    System.out.println(message);
}
```

### typeinference/vsca/LocalVariable.java
```java
var message = "Hello there";
```

### typeinference/vsca/OtherLocalVariable.java
```java
HashMap<String, List<Integer>> scores = new HasMap<String, List<Integer>();
```

### typeinference/vsca/OtherLocalVariable.java
```java
var scores = new HasMap<String, List<Integer>();
```

### Number of Cores
```java
var numberOfCores = Runtime.getRuntime().availableProcessors();
```
