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
    public <T> void process(Consumer <T> consumer){}
    public static void display(int value) {}

    public static void main(String[] args){
        GenericsTypeWitness instance = new GenericsTypeWitness();

        instance.process(input -> display(input)); //ERROR
                                                   //error: incompatible types: Object cannot be converted to int
    }
}
```

