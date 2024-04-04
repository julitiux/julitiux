---
title: "Mockito made clear (2023)"
date: 2023-11-28T23:16:32-06:00
draft: false
---

## **INDEX**

# [Chapter 1 Build a Testing Foundation](#chapter-1-build-a-testing-foundation)
# [Chapter 2 Work with the Mockito API](#chapter-2-work-with-the-mockito-api)

# Chapter 1 Build a Testing Foundation

Mockito is a tool that helps you isolate particular componentsof software. You use Mockito to replace dependencies of the componentes you are testing so that methods in each dependency return knows outputs for know inputs.

> ### Stub
> A _stub_ is an object that stands in for dependencies and returns known outputs for known inputs.

> ### Mock
> A _mock_ is an object that does what a stub does, plus it keeps track of interactions performed.. By tracking interactions, a mock _verifies_ that stibbed methods the correct parameters, in the right order.

> ### Spy
> A _spy_ is an object that wraps the actual dependent objects, which allows you to track calls to that object by the class under test. A spy is similar to a mock, in that it records which methods were called, but a spy invokes those methods on the actual underlying object instead of on a stub.

## Saying Hello to Mockito

We look at the Mockito version in this section, explain what Mockito does and what it is for.

For Java, the classic Hello, World!

```java
// HelloWorld.java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
```
Let's modify this to make a class that welcomes the user with a simple String returned from a greet method

```java
//HelloMockito.java
public class HelloMockito {
    private String greeting = "Hello, %s, from Mockito!";
    public String greet(String name) {
        return String.format(greeting, name);
    }
}
```

# Chapter 2 Work with the Mockito API
