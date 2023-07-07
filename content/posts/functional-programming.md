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
### Cities.java
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
### Cities.java
```java
System.out.println("Found chicago?:" + cities.contains("Chicago"));
```

## The Old Way
### given
```java
final List<BigDecimal> prices = Arrays.asList(new BigDecimal("10"), new BigDecimal("30"), new BigDecimal("17"), new BigDecimal("20"), new BigDecimal("15"), new BigDecimal("18"), new BigDecimal("45"), new BigDecimal("12"));
```

### DiscountImperative.java
```java
BigDecimal totalOfDiscountedPrices = BigDecimal.ZERO;

for(BigDecimal price : prices) {
  if(price.compareTo(BigDecimal.valueOf(20)) > 0)
    totalOfDiscountedPrices = totalOfDiscountedPrices.add(price.multiply(BigDecimal.valueOf(0.9)));
}

System.out.println("Total of discounted prices: " + totalOfDiscountedPrices);
```

## A Better Way, Again

### DiscountImperative.java
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
### Iteration.java
```java
for(int i = 0; i < friends.size(); i++) {
  System.out.println(friends.get(i));
}
```

This form of iteration uses the `Iterator` interface and calls into its `hasNext()` and `next()` methods
### Iteration.java
```java
for(String name : friends) {
  System.out.println(name);
}
```

Use the forEach() method with the all-too-familiar anonymous inner class syntaz

### Iteration.java
```java
friends.forEach(new Consumer<String>() {
  public void accept(final String name) {
    System.out.println(name);
  }
});
```

Remplacing the anonympus inner class with a lambda expression
### Iteration.java
```java
friends.forEach((final String name) -> System.out.println(name));
```
Leaving tout the type id convenient, requires less effort, and is less noisy
### Iteration.java
```java
friends.forEach((name) -> System.out.println(name));
```

Leve off the parentheses around the parameter if the parameter's type is inferred
### Iteration.java
```java
friends.forEach(name -> System.out.println(name));
```

Using a _method reference_
### Iteration.java
```java
friends.forEach(System.out::println);
```

## Transforming a List
