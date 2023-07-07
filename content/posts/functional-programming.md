---
title: "Functional Programming"
date: 2023-07-06T20:39:27-06:00
draft: false
---


# **INDEX**


# [Hello Lambda Expressions!](#hello-lambda-expression)


# Hello Lambda Expression!

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
