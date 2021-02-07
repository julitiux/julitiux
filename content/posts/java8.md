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

Given a interface:
```java
public interface LambdaSintaxisService {
  public Double calculateAverage(Double num1, Double num2);
}
```

Diferent type of Lambda sintaxis.

Sintaxis 1:
```java
  public Double sintaxis1(Double number1, Double number2){
    LambdaSintaxisService instance = new LambdaSintaxisService(){
      @Override
      public Double calculateAverage(Double num1, Double num2) {
        return (num1 + num2) / 2;
      }
    };
    return instance.calculateAverage(number1,number2);
  }
```

Sintaxis 2:
```java
  public Double sintaxis2(Double number1, Double number2){
    LambdaSintaxisService instance = (Double num1, Double num2) -> (num1 + num2) / 2;
    return instance.calculateAverage(number1,number2);
  }
```

Sintaxis 3:
```java
  public Double sintaxis3(Double number1, Double number2){
    LambdaSintaxisService instance = (Double num1, Double num2) -> { return (num1 + num2) / 2;};
    return instance.calculateAverage(number1,number2);
  }
```

Sintaxis 4:
```java
  public Double sintaxis4(Double number1, Double number2){
    LambdaSintaxisService instance = (Double num1, Double num2) -> {
      System.out.println(num1);
      System.out.println(num2);
      return (num1 + num2) / 2;
    };
    return instance.calculateAverage(number1,number2);
  }
```

Sintaxis 5:
```java
  public Double sintaxis5(Double number1, Double number2){
    LambdaSintaxisService instance = (num1, num2) ->  (num1 + num2) / 2;
    return instance.calculateAverage(number1,number2);
  }
```

# Lambda Scopes

Given a interface

```java
public interface ScopeService {
  public Double calculateAverage(Double number1, Double number2);
}
```

Diferent types of scopes inside of the method:

By local variable:

```java
public Double localVariable1(Double number1, Double number2){

  final double number3 = 0;

  ScopeService instance = new ScopeService(){
    @Override
    public Double calculateAverage(Double n1, Double n2) {
      //number3 = (n1 + n2) / 2; YOU USE IT BUT YOU CANT CHANGE HIS VALUE
      return (n1 + n2) / 2;
    }
  };

  return instance.calculateAverage(number1, number2);
}
```
By local variable but with lambdas:

```java
public Double localVariable2(Double number1, Double number2){

  final double number3 = 0;

  ScopeService instance = (n1,n2) -> {
    //number3 = (n1 + n2) / 2; YOU USE IT BUT YOU CANT CHANGE HIS VALUE
    return (n1 + n2) / 2;
  };

  return instance.calculateAverage(number1, number2);
}
```

By attributes statics and privates:

```java
private static double attribute1;
private double attribute2;
```

```java
public Double attributesStaticVariables(Double number1, Double number2){

  ScopeService instance = (n1,n2) -> {
    attribute1 = (n1 + n2) / 2;
    attribute2 = attribute1;
    return attribute2;
  };

  return instance.calculateAverage(number1, number2);
}
```

# Interface Default Methods

Before Java 8, interfaces could have only abstract methods. The implementation of these methods has to be provided in a separate class. So, if a new method is to be added in an interface, then its implementation code has to be provided in the class implementing the same interface. To overcome this issue, Java 8 has introduced the concept of default methods which allow the interfaces to have methods with implementation without affecting the classes that implement the interface.

Add the default keyword just for turn the method default.

Given a interface:

```java
public interface DefaultMethodService {
  public void holaMundo();

  default public void defaulHolaMundo(){
    System.out.println("Hola Inmundo");
  }

}
```

And the implementation it could be like:

```java
public class DefaultMethodServiceImpl implements DefaultMethodService {

  @Override
  public void holaMundo() {
    System.out.println("Hola Inmundo");
  }

}
```

But without the method defaulHolaMundo.


# Functional Interfaces

A functional interface is an interface that contains only one abstract method. They can have only one functionality to exhibit. From Java 8 onwards, lambda expressions can be used to represent the instance of a functional interface. A functional interface can have any number of default methods. Runnable, ActionListener, Comparable are some of the examples of functional interfaces.
Before Java 8, we had to create anonymous inner class objects or implement these interfaces.

All functional interfaces are recommended to have an informative @FunctionalInterface annotation. This not only clearly communicates the purpose of this interface, but also allows a compiler to generate an error if the annotated interface does not satisfy the conditions.

Given a interface:

```java
@FunctionalInterface
public interface FunctionalInterfaceService {
  // A Functiona interface, Java is represented with the annotation @FunctionaInterface. Basically, you can not write two methods in the same interface.
  public void process();
}
```

with a implementation:

```java
public class FunctionalInterfaceServiceImpl implements FunctionalInterfaceService{

  @Override
  public void process() {
    System.out.println("Estas clases estan limitadas hacer referencia a un solo metodo ");
  }

}
```

# Method References

Java provides a new feature called method reference in Java 8. Method reference is used to refer method of functional interface. It is compact and easy form of lambda expression. Each time when you are using lambda expression to just referring a method, you can replace your lambda expression with method reference.

There are following types of method references in java:

1. Reference to a static method.
2. Reference to an instance method.
3. Reference to a constructor.

## Reference to a static method.

Given a Functional Interface:

```java
@FunctionalInterface
public interface MethodReferenceService {
  public void saidHello();
}
```

and a method static in the class MethodReferenceServiceImpl::
```java
public class MethodReferenceServiceImpl {

  public static void referenceMethodStatic() {
    System.out.println("I just said Hello");
  }

}
```


### With a expresion lambda:
```java
public void example1ReferenceMethodStatic() {
  //Name of the class . name of the method
  MethodReferenceService instance = () -> MethodReferenceServiceImpl.referenceMethodStatic();
  instance.saidHello();
}
```

### With a method reference and deleting the expression lambda
```java
public void example2ReferenceMethodStatic() {
  //Name of the class :: name of the method
  MethodReferenceService instance = MethodReferenceServiceImpl::referenceMethodStatic;
  instance.saidHello();
}
```


## Reference to an instance method.

### Anonymous Function
```java
public String[] referenceMethodInstanceObjectRandom1() {
  String[] numbers = {"uno", "dos", "tres"};
  Arrays.sort(numbers, new Comparator<String>() {
    @Override
    public int compare(String o1, String o2) {
      return o1.compareTo(o2);
    }
  });
  return numbers;
}
```

### Expresion lambda
```java
public String[] referenceMethodInstanceObjectRandom2() {
  String[] numbers = {"uno", "dos", "tres"};
  Arrays.sort(numbers, (o1, o2) -> o1.compareTo(o2));
  return numbers;
}
```

### With method reference
```java
public String[] referenceMethodInstanceObjectRandom3() {
  String[] numbers = {"uno", "dos", "tres"};
  Arrays.sort(numbers, String::compareTo);
  return numbers;
}
```

### Instance Object


```java
public class MethodReferenceServiceImpl {

  public void sayHi() {
    System.out.println("Hola INHUMAN");
  }

  public void referenceMethodInstanceObjectSingular() {
    MethodReferenceServiceImpl instance = new MethodReferenceServiceImpl();
    MethodReferenceService inst = instance::sayHi;
    inst.saidHello();
  }

}
```


## Reference to a constructor.

Given a class User:

```java
public class User {

  Long id;
  String username;

  public User(Long id, String username) {
    this.id = id;
    this.username = username;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

}
```

and a functional interface:

```java
@FunctionalInterface
public interface UserService {
  public User crear(Long id, String username);
}
```


## Anonymous Function
```java
public User referenceConstructor1(Long id, String username) {
  UserService interfaceUser = new UserService() {
    @Override
    public User crear(Long id, String username) {
      return new User(id, username);
    }
  };
  return interfaceUser.crear(id, username);
}
```

## Expresion lambda
```java
public User referenceConstructor2(Long id, String username) {
  UserService interfaceUser = (x, y) -> new User(x, y);
  return interfaceUser.crear(id, username);
}
```

## With a method reference
```java
public User referenceConstructor3(Long id, String username) {
  UserService interfaceUser = User::new;
  return interfaceUser.crear(id, username);
}
```

 And remember folks, the Method Reference can not carry parameters.

# Colections -> forEach, removeIf, sort

Given a interface

```java
import java.util.List;

public interface CollectionService {
  public void forEachJava7(List<String> list);
  public void forEachJava8(List<String> list);
  public void forEachJava8_1(List<String> list);

  public List<String> useRemoveIfJava7(List<String> list, String elementRemove);
  public List<String> useRemoveIfJava8(List<String> list, String elementRemove);

  public List<String> useSortJava7(List<String> list);
  public List<String> useSortJava8(List<String> list);
}
```

## Implementation forEach

Java 7
```java
@Override
public void forEachJava7(List<String> list) {
  for (String element : list) {
    System.out.println(element);
  }
}
```
Java8
```java
@Override
public void forEachJava8(List<String> list) {
  list.forEach(it -> System.out.println(it));
}

@Override
public void forEachJava8_1(List<String> list) {
  list.forEach(System.out::println);
}
```

## Implementation removeIf

Java7
```java
@Override
public List<String> useRemoveIfJava7(List<String> list, String elementRemove) {
  Iterator<String> iterator = list.iterator();
  while (iterator.hasNext()) {
    if (iterator.next().equalsIgnoreCase(elementRemove))
      iterator.remove();
  }
  return list;
}
```
Java8
```java
@Override
public List<String> useRemoveIfJava8(List<String> list, String elementRemove) {
  list.removeIf(x -> x.equalsIgnoreCase(elementRemove));
  return list;
}
```

## Implementation sort

Java7
```java
@Override
public List<String> useSortJava7(List<String> list) {
  Collections.sort(list, new Comparator<String>() {
    @Override
    public int compare(String o1, String o2) {
      return o1.compareTo(o2);
    }
  });
  return list;
}
```
Java8
```java
@Override
public List<String> useSortJava8(List<String> list) {
  Collections.sort(list, ((o1, o2) -> o1.compareTo(o2)));
  return list;
}
```

# Streams

Introduced in Java 8, the Stream API is used to process collections of objects. A stream is a sequence of objects that supports various methods which can be pipelined to produce the desired result.

Given a interface:
```java
public interface StreamService {
  public List<String> filter(List<String> list);
  public List<String> sorter(List<String> list);
  public List<String> transformer(List<String> list);
  public List<String> limiter(List<String> list);
  public Long counter(List<String> list);
}
```

Filter
```java
@Override
public List<String> filter(List<String> list) {
  return list.stream().filter(x -> x.startsWith("M")).collect(Collectors.toList());
}
```
Sort
```java
@Override
public List<String> sorter(List<String> list) {
  return list.stream().sorted().collect(Collectors.toList());
}
```
Map
```java
@Override
public List<String> transformer(List<String> list) {
  return list.stream().map(x -> Integer.parseInt(x) +1).map(Object::toString).collect(Collectors.toList());
}
```
Limit
```java
@Override
public List<String> limiter(List<String> list) {
  return list.stream().limit(2).collect(Collectors.toList());
}
```
Count
```java
@Override
public Long counter(List<String> list) {
  return list.stream().count();
}
```

# Optional

The Optional class that was introduced in Java 8. The purpose of the class is to provide a type-level solution for representing optional values instead of null references.


Given a interface:
```java
public interface OptionalService {
  public void test(String value);
  public String orElse(String value);
  public void orElseThrow(String value);
  public Boolean isPresent(String value);
}
```

Implementation Optional with a _empty_ and _get_ method:
```java
@Override
public void test(String value) {
  Optional<String> optional = Optional.empty();
  optional.get();
}
```
Implementation Optional with a _ofNullable_ and _orElse_
```java
@Override
public String orElse(String value) {
  Optional<String> optional = Optional.ofNullable(value);
  return optional.orElse("Sin valor");
}
```
Implementation Optional with a _orElseThrow_
```java
@Override
public void orElseThrow(String value) {
  Optional<String> optional = Optional.ofNullable(value);
  optional.orElseThrow(NumberFormatException::new);
}
```
Implementation Optional with a _isPresent_
```java
@Override
public Boolean isPresent(String value) {
  Optional<String> optional = Optional.ofNullable(value);
  return optional.isPresent();
}
```

# StreamParallels

Java Parallel Streams is a feature of Java 8 and higher, meant for utilizing multiple cores of the processor. Normally any java code has one stream of processing, where it is executed sequentially. Whereas by using parallel streams, we can divide the code into multiple streams that are executed in parallel on separate cores and the final result is the combination of the individual outcomes. The order of execution, however, is not under our control.

Given a interface:

```java
public interface ParallelStreamService {
  public void testStream(List<String> list);
  public void testParallelStream(List<String> list);
}
```
Without _parallelStream()_
```java
@Override
public void testStream(List<String> list) {
  list.forEach(System.out::println);
}
```
With _parallelStream()_
```java
@Override
public void testParallelStream(List<String> list) {
  list.parallelStream().forEach(System.out::println);
}
```
# Map

The Map interface present in java.util package represents a mapping between a key and a value. The Map interface is not a subtype of the Collection interface. Therefore it behaves a bit differently from the rest of the collection types. A map contains unique keys.

Given a interface:
```java
public interface MapService {
  public void printJava7(Map<Integer, String> map);
  public Map<Integer, String> printJava8(Map<Integer, String> map);
  public Map<Integer, String> collect(Map<Integer, String> map);
  public Map<Integer, String> insertIfAbsent(Map<Integer, String> map);
  public Map<Integer, String> operateIfPresent();
}
```

Print a Map

Java7
```java
@Override
public void printJava7(Map<Integer, String> map) {
  for (Map.Entry<Integer, String> entry : map.entrySet()) {
    System.out.println("key: " + entry.getKey() + " Value: " + entry.getValue());
  }
}
```

Java 8

With a _BiConsumer_
```java
@Override
public void printJava8(Map<Integer, String> map) {
  map.forEach((k, v) -> System.out.println("key: " + k + " Value:" + v));
}
```

With a _Consumer_
```java
@Override
public void printJava8_1(Map<Integer, String> map) {
  map.entrySet().forEach(System.out::println);
}
```

Insert a element If Absent

```java
@Override
public Map<Integer, String> insertIfAbsent(Map<Integer, String> map, Integer key, String value) {
  map.putIfAbsent(key,value);
  return map;
}
```

Get or return default value

```java
@Override
public String getOrDefault(Map<Integer, String> map, Integer key) {
  return map.getOrDefault(key, "Don't has value");
}
```

Return a subMap (in the case) with a filter

```java
@Override
public Map<Integer, String> collect_v1(Map<Integer, String> map, String value) {
  return map.entrySet().stream()
    .filter( entry -> entry.getValue().contains(value) )
    .collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));
}
```

```java
@Override
public Map<Integer, String> collect_v2(Map<Integer, String> map, String value) {
  return map.entrySet().stream()
    .filter( entry -> entry.getValue().contains(value) )
    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
}
```

# Annotations
# Date API


The new Date and Time APIs/classes (JSR-310), also called as ThreeTen, which have simply change the way you have been handling dates in java applications.

Date class has even become obsolete. The new classes intended to replace Date class are LocalDate, LocalTime and LocalDateTime.

1. The LocalDate class represents a date. There is no representation of a time or time-zone.
2. The LocalTime class represents a time. There is no representation of a date or time-zone.
3. The LocalDateTime class represents a date-time. There is no representation of a time-zone.


## Comparte two Dates

Java7
```java


```





# High Order Functions
# RXJava
# Nashom
