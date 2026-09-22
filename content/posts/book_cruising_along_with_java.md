---
title: "Cruising Along With Java"
date: 2026-08-28T22:15:15-06:00
draft: false
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

### Group of Languages
```java
List<String> languages =
    List.of("C++", "C", "Erlang", "Elm", "Haskell", "Ruby", "Python");

List<String> languages =
    List.of("Java", "Kotlin", "Scala", "Groovy", "Clojure", "JRuby");

Map<Integer, List<String> namesByLength = languages.stream()
    .collect(groupingBy((String name) -> name.length(),
    mapping((String name) -> name.toUpperCase(), toList())));

Map<Integer, List<String>> jvmNamesByLength = jvmNamesByLength.stream()
    .collect(groupingBy((String name) -> name.length(),
    mapping((String name) -> name.toUpperCase(), toList())));
```

### Group of Languages
```java
Collector<String, ?, Map<Integer, List<String>>> groupingCriteria =
    groupingBy((String name) -> name.length(),
    mapping((String name) -> name.toUpperCase(), toList()));

Map<Integer, List<String> namesByLength = languages.stream()
    .collect(groupingCriteria);

Map<Integer, List<String>> jvmNamesByLength = jvmNamesByLength.stream()
    .collect(groupingCriteria);
```

### Group of Languages
```java
var groupingCriteria =
    groupingBy((String name) -> name.length(),
    mapping((String name) -> name.toUpperCase(), toList()));

var namesByLength = languages.stream()
    .collect(groupingCriteria);

var jvmNamesByLength = jvmNamesByLength.stream()
    .collect(groupingCriteria);
```

## var:Not a Type nor a Keyword

## typeinference/vsca/TypeInferred.java
```Java
public class TypeInferred {
    public static void main(String[] args) {
        var message = "hello  there";
        var max = 1000;
        var instance = new TypeInferred();
    }
}
```

## typeinference/vsca/NotKeyWord.java
```java
var PI = Math.PI;
String var = "please don't"; //Possible, but not a good idea
//var var = "please don't"; //Also possible, buy avoid

System.out.println(var); //prints: please don't
```

# Reducing Clutter with Text Blocks

## From Noisy to Nice

### textblocks/vsca/CreateMessage.java
```java
public static String createMessage() {

    String message = "Thank you for your purchase.";
    message += " We hope you had a pleasant experience.\n\n";
    message += "We request that you take a few minutes ";
    message += "to provide your feedback.\n\n";
    message += "Please fill out the survey at https://survey.example.com\n\n";
    message += "If you have any questions or comments, ";
    message += "please click on the \"Support\" link\n";
    message += "at https://www.example.com.\n";

    return message;
}
```

### textblocks/vsca/CreateMessageConcise.java
```java
public static String createMessage() {
    var message = """
        Thank you for your purchase. We hope you had a pleasant experience.

        We request that you take a few minutes to provide your feedback.

        Please fill out the survey at https://survey.example.com

        If you have any questions or comments, please click on the "Support" link
        at https://www.example.com.
        """;

    return message;
}
```

### textblocks/shoutput/runCreateMessageConcise.sh.ouput
```terminal
    public static java.lang.String createMessage();
        Code:
            0: ldc #7 // String Thank
you for your purchase. We hope you had a pleasant
experience.\n\nWe request that you take a few minutes to
provide your feedback.\n\nPlease fill out the survey
at https://survey.example.com\n\nIf you have any
questions or comments, please click on the \"Support\"
link\nat https://www.example.com.\n
```

## Embedding Strings

### textblocks/vsca/Escapes.java
```java
String message = "The \'National Weather Service\' has issued a " +
    "\"severe\" thunderstorm warning\nfor tomorrow. " +
    "Please \"\"\"stock up\"\"\" on the essentials you'll need " +
    "during\nthe adverse weather.\n\n\\Approved for general distribution\\";
```

## Smart Identations

### textblock/vsca/PreserveIndentation.java
```java
public class PreserveIndentation {
    public static String preserveIndentation() {
        var message = """
            If you like
                you can ask the indentations
            to be preserved, unaltered, like in this example.
            """;

        return message;
    }

    public static void main(String[] args){
        System.out.println("----------");
        System.out.print(preserveIndentation());
        System.out.println("----------");
    }
}
```

### textblocks/vsca/IndentationError.java
```java
var message =
    The compiler can keep an eye
            on lines like this with
    indentation errors""";
```

## Trailling Spaces and Special Escapes

### textblocks/vsca/SpecialEscapes.java
```java
public class SpecialEscapes {
    public static String SpecialEscapes() {
        var message = """
        This line has 3 spaces in the end
        This one has too, but is preserved \s
        This line is appended\
        with the next
            This is intentionally indented. """;

        return message;
    }

}
```
