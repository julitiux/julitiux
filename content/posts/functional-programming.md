---
title: "Functional Programming"
date: 2023-07-06T20:39:27-06:00
draft: false
---


# **INDEX**


# [Chapter 1 Hello Lambda Expressions!](#chapter-1-hello-lambda-expression)
# [Chapter 2 Using Collections](#chapter-2-using-collections)

# Chapter 1 Hello Lambda Expression!

## Change the Way You Think
#### Cities.java
```java
boolean found = false;
for(String city : cities) {
  if(city.equals("Chicago")) {
    found = true;
      break;
  }
}
```

## A Better Way
#### Cities.java
```java
System.out.println("Found chicago?:" + cities.contains("Chicago"));
```

## The Old Way
### given
```java
final List<BigDecimal> prices = Arrays.asList(new BigDecimal("10"), new BigDecimal("30"), new BigDecimal("17"), new BigDecimal("20"), new BigDecimal("15"), new BigDecimal("18"), new BigDecimal("45"), new BigDecimal("12"));
```

#### DiscountImperative.java
```java
BigDecimal totalOfDiscountedPrices = BigDecimal.ZERO;

for(BigDecimal price : prices) {
  if(price.compareTo(BigDecimal.valueOf(20)) > 0)
    totalOfDiscountedPrices = totalOfDiscountedPrices.add(price.multiply(BigDecimal.valueOf(0.9)));
}

System.out.println("Total of discounted prices: " + totalOfDiscountedPrices);
```

## A Better Way, Again

#### DiscountImperative.java
```java
final BigDecimal totalOfDiscountedPrices = prices.stream()
  .filter(price -> price.compareTo(BigDecimal.valueOf(20)) > 0)
  .map(price -> price.multiply(BigDecimal.valueOf(0.9)))
  .reduce(BigDecimal.ZERO, BigDecimal::add);

System.out.println("Total of discounted prices: " + totalOfDiscountedPrices);
```

# Chapter 2 Using Collections

## Itering through a List

Given a list
```java
final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
```
#### Iteration.java
```java
for(int i = 0; i < friends.size(); i++) {
  System.out.println(friends.get(i));
}
```

This form of iteration uses the `Iterator` interface and calls into its `hasNext()` and `next()` methods
#### Iteration.java
```java
for(String name : friends) {
  System.out.println(name);
}
```

Use the forEach() method with the all-too-familiar anonymous inner class syntaz

#### Iteration.java
```java
friends.forEach(new Consumer<String>() {
  public void accept(final String name) {
    System.out.println(name);
  }
});
```

Remplacing the anonympus inner class with a lambda expression
#### Iteration.java
```java
friends.forEach((final String name) -> System.out.println(name));
```
Leaving tout the type id convenient, requires less effort, and is less noisy
#### Iteration.java
```java
friends.forEach((name) -> System.out.println(name));
```

Leve off the parentheses around the parameter if the parameter's type is inferred
#### Iteration.java
```java
friends.forEach(name -> System.out.println(name));
```

Using a _method reference_
#### Iteration.java
```java
friends.forEach(System.out::println);
```

## Transforming a List

Let's start by creating a new collection of uppercase names from the given collection

#### Transform.java
```java
final List<String> uppercaseNames = new ArrayList<String>();

for(String name : friends) {
  uppercaseNames.add(name.toUpperCase());
}
```
replacing the for loop by ferEach()
#### Transform.java
```java
final List<String> uppercaseNames = new ArrayList<String>();
friends.forEach(name -> uppercaseNames.add(name.toUpperCase()));
System.out.println(uppercaseNames);
```

## Using Method References

With this feature, a short String::toUppercase can replace name -> name.toUppercase
#### Transform.java
```java
friends.stream()
  .map(String::toUpperCase)
  .forEach(name -> System.out.println(name));
```
## Finding Elements

Let's pick the ones that start with the letter N
#### PickElements.java
```java
final List<String> startsWithN = new ArrayList<String>();
for(String name : friends) {
  if(name.startsWith("N")) {
    startsWithN.add(name);
  }
}
```

The method `filter()` is designed fot that purpose

#### PickElements.java
```java
final List<String> startsWithN =
  friends.stream()
    .filter(name -> name.startsWith("N"))
    .collect(Collectors.toList());
```

## Reusing Lambda Expressions

Suppose we have a few collections of names: friends, editors, comrades, and so on:

```java
final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
final List<String> editors = Arrays.asList("Brian", "Jackie", "John", "Mike");
final List<String> comrades = Arrays.asList("Kate", "Ken", "Nick", "Paula", "Zach");
```

We want to filter out names that start with a certain letter. Let's first take a native approach to this using the filter() method
```java
final long countFriendsStartN =
  friends.stream()
         .filter(name -> name.startsWith("N")).count();
final long countEditorsStartN =
  editors.stream()
         .filter(name -> name.startsWith("N")).count();
final long countComradesStartN =
  comrades.stream()
          .filter(name -> name.startsWith("N")).count();
```

The filter() method the receiver of the lambda expression in the previous example, takes a reference to a java.util.function.Predicate functional interface

#### PickElementsMultipleCollection.java
```java
final Predicate<String> startsWithN = name -> name.startsWith("N");

final long countFriendsStartN =
  friends.stream()
         .filter(startsWithN)
         .count();
final long countEditorsStartN =
  editors.stream()
         .filter(startsWithN)
         .count();
final long countComradesStartN =
  comrades.stream()
          .filter(startsWithN)
          .count();
```

## Using Lexical Scoping and Closures

Let's pick the names that start with N or B fromt the friends collections of names. Continuing with the previous example, we may be tempted to write something like the following
#### PickDifferentNames.java
```java
final Predicate<String> startsWithN = name -> name.startsWith("N");
final Predicate<String> startsWithB = name -> name.startsWith("B");

final long countFriendsStartN =
  friends.stream()
         .filter(startsWithN).count();

final long countFriendsStartB =
  friends.stream()
         .filter(startsWithB).count();

```

## Removing Duplication with Lexical Scoping
#### PickDifferentNames.java
```java
public static Predicate<String> checkIfStartsWith(final String letter) {
  return name -> name.startsWith(letter);
}
```

We can use the lambda expression returned by checkIfStartWith() in the call to filter() method:
#### PickDifferentNames.java
```java
final long countFriendsStartN =
    friends.stream()
           .filter(checkIfStartsWith("N")).count();

final long countFriendsStartB =
    friends.stream()
           .filter(checkIfStartsWith("B")).count();
```

## Refactoring to Narrow the Scope

In the preceding (smelly) example we used a static method, but we don't want to pollute the class with static methods to cache each variable in the future. We can do that using a Functional interface.
#### PickDifferentNames.java
```java
final Function<String, Predicate<String>> startsWithLetter =
  (String letter) -> {
    Predicate<String> checkStarts = (String name) -> name.startsWith(letter);
    return checkStarts;
};
```
This version is verbose compared to the static methos we saw earlier, but we'll refactor that soon to make it concise.
#### PickDifferentNames.java
```java
final Function<String, Predicate<String>> startsWithLetter =
  (String letter) -> (String name) -> name.startsWith(letter);
```
We reduce clutterm but we can take the conciseness up another notch by removing the types and letting the Java compiler inger the types based on the context.
#### PickDifferentNames.java
```java
final Function<String, Predicate<String>> startsWithLetter =
  letter -> name -> name.startsWith(letter);
```
I takes a bit of effort to get used to this concuse syntax.

#### PickDifferentNames.java
```java
final long countFriendsStartN =
  friends.stream()
         .filter(startsWithLetter.apply("N")).count();

final long countFriendsStartB =
  friends.stream()
         .filter(startsWithLetter.apply("B")).count();
```

## Picking an Element

Let's create a method thta will look for an element that starts with a given letter, and print it:
#### PickAElement.jaba
```java
public static void pickName(
  final List<String> names, final String startingLetter) {
  String foundName = null;
  for(String name : names) {
    if(name.startsWith(startingLetter)) {
      foundName = name;
      break;
    }
  }

  System.out.print(String.format("A name starting with %s: ", startingLetter));

  if(foundName != null) {
    System.out.println(foundName);
  } else {
    System.out.println("No name found");
  }
}

```

Let's rethink the problem, We simply want to pick the first matching element and safty deal with the absence of sych an element.
#### PickElementElegant.java
```java
public static void pickName(final List<String> names, final String startingLetter) {

  final Optional<String> foundName =
    names.stream()
         .filter(name ->name.startsWith(startingLetter))
         .findFirst();

  System.out.println(String.format("A name starting with %s: %s", startingLetter, foundName.orElse("No name found")));
}
```

The combination of the findFirst() method and the Optional class reduced our code and its smell quite a bit. We rather than providing an alternate value for the absent instance, we can ask Optional to run a vblock of code or a lambda only if a value is present, like so:
#### PickElementElegant.java
```java
foundName.ifPresent(name -> System.out.println("Hello " + name));
```