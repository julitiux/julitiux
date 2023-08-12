---
title: "Functional Programming in Java"
date: 2023-07-06T20:39:27-06:00
draft: false
---


# **INDEX**


# [Chapter 1 Hello Lambda Expressions!](#chapter-1-hello-lambda-expression)
# [Chapter 2 Using Collections](#chapter-2-using-collections)
# [Chapter 3 Strings, Comparators, and Filters](#chapter-3-strings-comparators-and-filters)
# [Chapter 4 Designing with Lambda Expressions](#chapter-4-designing-with-lambda-expressions)
# [Chapter 5 Working with Resources](#chapter-5-working-with-resources)
# [Chapter 6 Being Lazy](#chapter-6-being-lazy)
# [Chapter 7 Optimizing Recursions](#chapter-7-optimizing-recursions)

# Chapter 1 Hello Lambda Expression!

## Change the Way You Think
```java
// Cities.java

boolean found = false;
for(String city : cities) {
  if(city.equals("Chicago")) {
    found = true;
      break;
  }
}
```

## A Better Way
```java
// Cities.java

System.out.println("Found chicago?:" + cities.contains("Chicago"));
```

## The Old Way
### given
```java
final List<BigDecimal> prices = Arrays.asList(new BigDecimal("10"), new BigDecimal("30"), new BigDecimal("17"), new BigDecimal("20"), new BigDecimal("15"), new BigDecimal("18"), new BigDecimal("45"), new BigDecimal("12"));
```

```java
// DiscountImperative.java

BigDecimal totalOfDiscountedPrices = BigDecimal.ZERO;

for(BigDecimal price : prices) {
  if(price.compareTo(BigDecimal.valueOf(20)) > 0)
    totalOfDiscountedPrices = totalOfDiscountedPrices.add(price.multiply(BigDecimal.valueOf(0.9)));
}

System.out.println("Total of discounted prices: " + totalOfDiscountedPrices);
```

## A Better Way, Again
```java
// DiscountImperative.java

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
```java
// Iteration.java

for(int i = 0; i < friends.size(); i++) {
  System.out.println(friends.get(i));
}
```

This form of iteration uses the `Iterator` interface and calls into its `hasNext()` and `next()` methods
```java
// Iteration.java

for(String name : friends) {
  System.out.println(name);
}
```

Use the forEach() method with the all-too-familiar anonymous inner class syntaz

```java
// Iteration.java

friends.forEach(new Consumer<String>() {
  public void accept(final String name) {
    System.out.println(name);
  }
});
```

Remplacing the anonympus inner class with a lambda expression
```java
// Iteration.java

friends.forEach((final String name) -> System.out.println(name));
```
Leaving tout the type id convenient, requires less effort, and is less noisy
```java
// Iteration.java

friends.forEach((name) -> System.out.println(name));
```

Leve off the parentheses around the parameter if the parameter's type is inferred
```java
// Iteration.java

friends.forEach(name -> System.out.println(name));
```

Using a _method reference_
```java
// Iteration.java

friends.forEach(System.out::println);
```

## Transforming a List

Let's start by creating a new collection of uppercase names from the given collection

```java
// Transform.java

final List<String> uppercaseNames = new ArrayList<String>();

for(String name : friends) {
  uppercaseNames.add(name.toUpperCase());
}
```
replacing the for loop by ferEach()
```java
// Transform.java

final List<String> uppercaseNames = new ArrayList<String>();
friends.forEach(name -> uppercaseNames.add(name.toUpperCase()));
System.out.println(uppercaseNames);
```

## Using Method References

With this feature, a short String::toUppercase can replace name -> name.toUppercase
```java
// Transform.java

friends.stream()
  .map(String::toUpperCase)
  .forEach(name -> System.out.println(name));
```
## Finding Elements

Let's pick the ones that start with the letter N
```java
// PickElements.java

final List<String> startsWithN = new ArrayList<String>();
for(String name : friends) {
  if(name.startsWith("N")) {
    startsWithN.add(name);
  }
}
```

The method `filter()` is designed fot that purpose

```java
// PickElements.java

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

```java
// PickElementsMultipleCollection.java

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
```java
// PickDifferentNames.java

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
```java
// PickDifferentNames.java

public static Predicate<String> checkIfStartsWith(final String letter) {
  return name -> name.startsWith(letter);
}
```

We can use the lambda expression returned by checkIfStartWith() in the call to filter() method:
```java
// PickDifferentNames.java

final long countFriendsStartN =
    friends.stream()
           .filter(checkIfStartsWith("N")).count();

final long countFriendsStartB =
    friends.stream()
           .filter(checkIfStartsWith("B")).count();
```

## Refactoring to Narrow the Scope

In the preceding (smelly) example we used a static method, but we don't want to pollute the class with static methods to cache each variable in the future. We can do that using a Functional interface.
```java
// PickDifferentNames.java

final Function<String, Predicate<String>> startsWithLetter =
  (String letter) -> {
    Predicate<String> checkStarts = (String name) -> name.startsWith(letter);
    return checkStarts;
};
```
This version is verbose compared to the static methos we saw earlier, but we'll refactor that soon to make it concise.
```java
// PickDifferentNames.java

final Function<String, Predicate<String>> startsWithLetter =
  (String letter) -> (String name) -> name.startsWith(letter);
```
We reduce clutterm but we can take the conciseness up another notch by removing the types and letting the Java compiler inger the types based on the context.
```java
// PickDifferentNames.java

final Function<String, Predicate<String>> startsWithLetter =
  letter -> name -> name.startsWith(letter);
```
I takes a bit of effort to get used to this concuse syntax.

```java
// PickDifferentNames.java

final long countFriendsStartN =
  friends.stream()
         .filter(startsWithLetter.apply("N")).count();

final long countFriendsStartB =
  friends.stream()
         .filter(startsWithLetter.apply("B")).count();
```

## Picking an Element

Let's create a method thta will look for an element that starts with a given letter, and print it:
```java
// PickAElement.jaba

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
```java
// PickElementElegant.java

public static void pickName(final List<String> names, final String startingLetter) {

  final Optional<String> foundName =
    names.stream()
         .filter(name ->name.startsWith(startingLetter))
         .findFirst();

  System.out.println(String.format("A name starting with %s: %s", startingLetter, foundName.orElse("No name found")));
}
```

The combination of the findFirst() method and the Optional class reduced our code and its smell quite a bit. We rather than providing an alternate value for the absent instance, we can ask Optional to run a vblock of code or a lambda only if a value is present, like so:
```java
// PickElementElegant.java

foundName.ifPresent(name -> System.out.println("Hello " + name));
```

## Reducing a Collection to a Single Value

Let's start with some basic operations and build up to something a bit more sophisticated,
```java
// PickALongest.java

System.out.println("Total number of characters in all names: " +
  friends.stream()
         .mapToInt(name -> name.length())
         .sum());
```

We can use the reduce() method to compare two elements against each other and pass along the result for further comparison with the remaining elements in the collections.
```java
// PickALongest.java

final Optional<String> aLongName =
  friends.stream()
         .reduce((name1, name2) ->
            name1.length() >= name2.length() ? name1 : name2);

  aLongName.ifPresent(name ->
  System.out.println(String.format("A longest name: %s", name)));
```

If any name was longer than the given base, it would get picked up; otherwise the function would return the base value, Steve in this example. This version of reduce() does not return an Optional since if the collection is empty, the default will be returned; there's no concern of an absent of nonexistent value
```java
// PickALongest.java

final String steveOrLonger =
  friends.stream()
         .reduce("Steve", (name1, name2) ->
            name1.length() >= name2.length() ? name1 : name2);
```

## Joining Elements.

We have to iterate through the list and print each element. Since the Java 5 for construct is better than the archaic for loop:
```java
// PrintList.java

for(String name : friends) {
  System.out.print(name + ", ");
}

System.out.println();
```

There's a stinking comma at the end (shall we blame it on Scott?)
```java
// PrintList.java

for(int i = 0; i < friends.size() - 1; i++) {
  System.out.print(friends.get(i) + ", ");
}

if(friends.size() > 0)
  System.out.println(friends.get(friends.size() - 1));
```

A StringJoiner class cleans up all that mess in Java 8 and the String class has an added convenience method join() to turn smelly code into a simple one-liner
```java
// PrintList.java

System.out.println(String.join(", ", friends));
```
The collect() method does the reduction but delegates the actual implementation or target to a collector
```java
// PrintList.java

System.out.println(
  friends.stream()
         .map(String::toUpperCase)
         .collect(joining(", ")));
```

We invoked the collect() on the transformed list and provided it a collector returned by the joining() method, which is a static method on a Collectors utility class. A collector acts as a sink object to receive alements passed by the collect() method and store it in a desired format.

# Chapter 3 Strings, Comparators, and Filters

## Iterating a String

```java
// IterateString.java

final String str = "w00t";

str.chars()
  .forEach(ch -> System.out.println(ch));
```

```java
// IterateString.java

final String str = "w00t";

str.chars()
  .forEach(System.out::println);
```

We write a convenience method
```java
// IterateString.java

private static void printChar(int aChar) {
  System.out.println((char)(aChar));
}
```
We can use a reference to this convenience method to fix the output
```java
// IterateString.java

tr.chars()
   .forEach(IterateString::printChar);
```

If we want to process characters and not int from the start
```java
// IterateString.java

str.chars()
  .mapToObj(ch -> Character.valueOf((char)ch))
  .forEach(System.out::println);
```

We can see the filtered digits in the next ouput
```java
// IterateString.java

str.chars()
  .filter(ch -> Character.isDigit(ch))
  .forEach(ch -> printChar(ch));
```

Use reference to the references to the respective methods
```java
// IterateString.java

str.chars()
  .filter(Character::isDigit)
  .forEach(IterateString::printChar);
```

## Implemening the Comparator Interface

### Sorting with comparator
```java
// Person.java

public class Person {
  private final String name;
  private final int age;

  public Person(final String theName, final int theAge) {
    name = theName;
    age = theAge;
  }

  public String getName() { return name; }
  public int getAge() { return age; }

  public int ageDifference(final Person other) { return age - other.age; }

  public String toString() {
    return String.format("%s - %d", name, age);
  }
}
```

```java
// Compare.java

final List<Person> people = Arrays.asList(
  new Person("John", 20),
  new Person("Sara", 21),
  new Person("Jane", 21),
  new Person("Greg", 35));

List<Person> ascendingAge =
  people.stream()
        .sorted((person1, person2) -> person1.ageDifference(person2))
        .collect(toList());

printPeople("Sorted in ascending order by age: ", ascendingAge);

public static void printPeople(final String message, final List<Person> people) {
  System.out.println(message);
  people.forEach(System.out::println);
}
```

Remplace the lambda expression in the previous call to the sorted() method with a short and sweet reference to the ageDifference() method
```java
// Compare.java

people.stream()
      .sorted(Person::ageDifference)
      .collect(toList());
```

## Reusing a Comparator
We got the people sorted in ascending order by age quite easily, and sorting then in descending order is just as easy
```java
// Compare.java

printPeople("Sorted in descending order by age: ",
  people.stream()
    .sorted((person1, person2) -> person2.ageDifference(person1))
    .collect(toList()));
```

Using a Comparator
```java
// Compare.java

Comparator<Person> compareAscending = (person1, person2) -> person1.ageDifference(person2);
Comparator<Person> compareDescending = compareAscending.reversed();
```

Let's use these two comparators in the code
```java
// Compare.java

printPeople("Sorted in ascending order by age: ",
  people.stream()
        .sorted(compareAscending)
        .collect(toList())
);

printPeople("Sorted in descending order by age: ",
  people.stream()
        .sorted(compareDescending)
        .collect(toList())
);
```

Now sorting by name
```java
// Compare.java

printPeople("Sorted in ascending order by name: ",
  people.stream()
        .sorted((person1, person2) ->
           person1.getName().compareTo(person2.getName()))
        .collect(toList()));
```

Now lets pick the youngest person in the list
```java
// Compare.java

people.stream()
    .min(Person::ageDifference)
    .ifPresent(youngest -> System.out.println("Youngest: " + youngest));
```

Now pick the oldest person in the list
```java
// Compare.java

people.stream()
    .max(Person::ageDifference)
    .ifPresent(eldest -> System.out.println("Eldest: " + eldest));
```

## Multiple and Fluent Comparisons.

Let's look at the new convenience methods added to the `Comparator` interface and use to compare with ease based multiple properties.


```java
// Compare.java

final Function<Person, String> byName = person -> person.getName();

people.stream()
      .sorted(comparing(byName));
```

In the code we statically imported the comparing() method in the Comparator interface. The comparing() method uses the logic embedded in the provided lambda expression to create a Comparator. In other words, it´s a high-order function that takes in one function (Function) and returns another (Comparator)

We can take this fluency further to make multiple comparisons.

```java
// Compare.java

final Function<Person, Integer> byAge = person -> person.getAge();
final Function<Person, String> byTheirName = person -> person.getName();

printPeople("Sorted in ascending order by age and name: ",
  people.stream()
        .sorted(comparing(byAge).thenComparing(byTheirName))
        .collect(toList()));
```

## Using the collect Method and the Collectors Class
Here's a version thta uses mutability and forEach()

```java
// OlderThan20.java

List<Person> olderThan20 = new ArrayList<>();
  people.stream()
        .filter(person -> person.getAge() > 20)
        .forEach(person -> olderThan20.add(person));

System.out.println("People older than 20: " + olderThan20);
```

The collect() method takes a stream of elements and collects or gathers them into a result container. To do that, the method needs to know three things.

* How to make a result container (for example, using the ArrayList::new method)
* How to add a single element to a result container (for examplem using the ArrayList::add method)
* How to merge one result elememt container into another (for example, using the ArrayList::addAll method)

Lets provide these operations to the collect() method to gather teh results of a stream after a filter operation.
```java
// OlderThan20.java

List<Person> olderThan20 =
  people.stream()
        .filter(person -> person.getAge() > 20)
        .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

System.out.println("People older than 20: " + olderThan20);
```

This version of code produces the same result as the previous version; however, this version has many benefits.

Now, lets modify the previous version to use this version of collect() method.

```java
// OlderThan20.java

List<Person> olderThan20 =
  people.stream()
        .filter(person -> person.getAge() > 20)
        .collect(Collectors.toList());

System.out.println("People older than 20: " + olderThan20);
```
There are several methods on the addition to toList(), there is toSet(), to accumulate into a set, toMap() to gather into a key-value collection, and joinning() to concatenate the elements into a String. We can also join multiple combine operations using methods like mapping(), collectingAndThen(), minBy(), and groupingBy().
```java
// OlderThan20.java

Map<Integer, List<Person>> peopleByAge =
  people.stream()
        .collect(Collectors.groupingBy(Person::getAge));

System.out.println("Grouped by age: " + peopleByAge);
```

You can see the grouping in this output:
```text
Grouped by age: {35=[Greg - 35], 20=[John - 20], 21=[Sara - 21, Jane - 21]}
```

With as simple call to the collect() method are we are able to perform the grouping. The groupingBy() method akes a lambda expression or a method reference called the _classifier function_, that returns the value of the propertiy on which we want to do the grouping. Based on what we return from this function, it put the element in context into that bucket or group

Continuing with the pervoius example, instead of creating a map of all Person objects by age, lets get only people's names, ordered by age
```java
// OlderThan20.java

Map<Integer, List<String>> nameOfPeopleByAge =
  people.stream()
        .collect(
          groupingBy(Person::getAge, mapping(Person::getName, toList())));

System.out.println("People grouped by age: " + nameOfPeopleByAge);
```

In this version groupingBy() takes two paramters: the first is the age, which is the criteria to group by, and the second is a Collector, which is the result of a call to the mapping() function

Lets look at the output from this code:
```text
People grouped by age: {35=[Greg], 20=[John], 21=[Sara, Jane]}
```

Lets look at one more conbination: lets group the names by their first character and then get the oldest person in each group.
```java
// OlderThan20.java

Comparator<Person> byAge = Comparator.comparing(Person::getAge);

Map<Character, Optional<Person>> oldestPersonOfEachLetter =
  people.stream()
        .collect(groupingBy(person -> person.getName().charAt(0),
            reducing(BinaryOperator.maxBy(byAge))));

System.out.println("Oldest person of each letter:");
System.out.println(oldestPersonOfEachLetter);
```
We first group the names based on their first letter. For this, we pass a lambda expression as the first parameter to the groupingBy() method. From within this lambda expression we return the first character of the name for grouping purposes. The second parameter in this example, instead of mapping, performs a reduce operation. In each group, it reduces the elements to the oldest person, as decided by the maxBy() method. The syntax is a bit dense due to the combination of operations, but it reads like this: group by first character of name and reduce to the person with maximum age. Let’s look at the output, which lists the oldest person in each grouping of names that start with a given letter.

```text
Oldest person of each letter:
{S=Optional[Sara - 21], G=Optional[Greg - 35], J=Optional[Jane - 21]}
```

## Listing all files in a Directory
Its pretty simple to use the File class list() method to list all filenames in a directory
```java
// ListFiles.java

Files.list(Paths.get("."))
  .forEach(System.out::println);
```

To list files in a different directory, we can replace "." with the full path of the directory we desire

If we want only the subdirectories in teh current directory instead of a listing of all the files, we can use the filter() method:
```java
// ListDirs.java

Files.list(Paths.get("."))
  .filter(Files::isDirectory)
  .forEach(System.out::println);
```

## Listing select Files in a directory
Java has long provided a variation of the list() method to cherry-pick filenames. This version of list() takes a FilenameFilter as its parameter. This interface has one method, accept(), that takes two parameters: File dir (representing the directory) and String name (representing a filename). We’d return a true from the accept() method to include the given filename in the list, and false otherwise. Let’s explore the options to implement this method.
```java
// ListSelectFiles.java

final String[] files =
  new File("fpij").list(new java.io.FilenameFilter() {
    public boolean accept(final File dir, final String name) {
      return name.endsWith(".java");
    }
  });
System.out.println(files);
```

Lets use lambda expression to get a list of all java files in the same directory
```java
// ListSelectFiles.java

Files.newDirectoryStream(
         Paths.get("fpij"), path -> path.toString().endsWith(".java"))
     .forEach(System.out::println);
```

Now, lets loot at an example of listing all hidden files in the curremt directory
```java
// ListHiddenFiles.java

final File[] files = new File(".").listFiles(file -> file.isHidden());
```

We can further reduce the code here; rather passing a lambda expression, we can use a method reference to make teh code more concise.
```java
// ListHiddenFiles.java

new File(".").listFiles(File::isHidden);
```

## Listing Immediate Subdirectories Using flatMap
Lets use the traditional for loop first to iterate over the files ina given directory
```java
// ListSubDirs.java

public static void listTheHardWay() {
  List<File> files = new ArrayList<>();

  File[] filesInCurrentDir = new File(".").listFiles();
  for(File file : filesInCurrentDir) {
    File[] filesInSubDir = file.listFiles();
    if(filesInSubDir != null) {
      files.addAll(Arrays.asList(filesInSubDir));
    } else {
      files.add(file);
    }
  }

  System.out.println("Count: " + files.size());
}
```

Some directories (or files) may be empty and may not have children. In that case, we simply wrap a stream around the no-child directory or file element.
```java
// ListSubDirs.java

public static void betterWay() {
  List<File> files =
    Stream.of(new File(".").listFiles())
          .flatMap(file -> file.listFiles() == null ?
              Stream.of(file) : Stream.of(file.listFiles()))
          .collect(toList());
  System.out.println("Count: " + files.size());
}
```

## Watching a File Change
Let's creae an example to watch for file changes in the current directory
```java
// WatchFileChange.java

final Path path = Paths.get("."); final WatchService watchService =
  path.getFileSystem()
      .newWatchService();

path.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);

System.out.println("Report any file changed within next 1 minute...");
```

We’ve registered a WatchService to observe any change to the current directory. We can poll the watch service for any change to files in this directory, and it will notify us through a WatchKey. Once we gain access to the key, we can iterate though all the events to get the details of the file update. Since multiple files may change at once, a poll may return a collection of events rather than a single event. Let’s look at the code for polling and iterating.
```java
// WatchFileChange.java

final WatchKey watchKey = watchService.poll(1, TimeUnit.MINUTES);

if(watchKey != null) {
  watchKey.pollEvents()
          .stream()
          .forEach(event ->
            System.out.println(event.context()));
}
```

# Chapter 4 Designing with Lambda Expressions

## Separating Converns Using Lambda Expressions.

### Exploring Design Concerns.
The desing we first create will mex multiple concerns in one method, but we'll quickly refactor to make the method cohesive.

```java
// Asset.java

public class Asset {
  public enum AssetType { BOND, STOCK };
  private final AssetType type;
  private final int value;
  public Asset(final AssetType assetType, final int assetValue) {
    type = assetType;
    value = assetValue;
  }

  public AssetType getType() { return type; }
  public int getValue() { return value; } }
```

Asset is a simple JavaBean with two properties; type and value. Suppose we'ra asked to total the values of all the assets given--let's write a method for that in AssetUtils class

```java
// AssetUtil.java

public static int totalAssetValues(final List<Asset> assets) {
  return assets.stream()
               .mapToInt(Asset::getValue)
               .sum();
}
```
We used the convenience of lambda expressions within this function. We transformed the List of Assets into a Stream.

```java
// AssetUtil.java

final List<Asset> assets = Arrays.asList(
  new Asset(Asset.AssetType.BOND, 1000),
  new Asset(Asset.AssetType.BOND, 2000),
  new Asset(Asset.AssetType.STOCK, 3000),
  new Asset(Asset.AssetType.STOCK, 4000)
);
```

Here's a call to the totalAssetValues() method using these assets.

```java
// AssetUtil.java

System.out.println("Total of all assets: " + totalAssetValues(assets));
```

This code will report the total of all the gives assets, as we see in the output.

```text
Total of all assets: 10000
```

## Getting Entangled with the Converns.

Imagine we’re asked to total only the bond assets. After a quick glance at the totalAssetValues() method, we realize it does almost everything we need. Why not copy and paste that code? After all, there’s a reason the integrated development environments have gone through the trouble to provide keyboard shortcuts for that, right?

```java
// AssetUtil.java

public static int totalBondValues(final List<Asset> assets){
  return assets.stream()
               .mapToInt(asset ->
                 asset.getType() == AssetType.BOND ? asset.getValue() : 0)
               .sum();
}
```

Now with Stock Values

```java
// AssetUtil.java

public static int totalStockValues(final List<Asset> assets){
  return assets.stream()
               .mapToInt(asset ->
                 asset.getType() == AssetType.STOCK ? asset.getValue() : 0)
               .sum();
}
```

Execute the methods

```java
// AssetUtil.java

System.out.println("Total of bonds: " + totalBondValues(assets));
System.out.println("Total of stocks: " + totalStockValues(assets));
```

The total give us the desire result

```text
Total of bonds: 3000
Total of stocks: 7000
```

## Refactoring to Separeate a Key Concenrn.

Let's refactor the three methods into one that takes a functional interface as a parameter

```java
// AssetUtilRefactored.java

public static int totalAssetValues(final List<Asset> assets, final Predicate<Asset> assetSelector) {
  return assets.stream()
               .filter(assetSelector)
               .mapToInt(Asset::getValue)
               .sum();
}
```

This refactored version of totalAssetValues() takes two paramters: the list of asset and a `Predicate` to evaluate whether an asset should be considered.

Now, lets use this refactores version of totalAssetValues() to total the values of all the assets.

```java
// AssetUtilRefactored.java
System.out.println("Total of all assets: " +
  totalAssetValues(assets, asset -> true));
```

Next, reuse the function to compute the total of only bonds and then the total of only stocks. We'll pass different lambda expressions as the argument to the `totalAssetValues()` function.

```java
// AssetUtilRefactored.java

System.out.println("Total of bonds: " +
  totalAssetValues(assets, asset -> asset.getType() == AssetType.BOND));

System.out.println("Total of stocks: " +
  totalAssetValues(assets, asset -> asset.getType() == AssetType.STOCK));

```

## Delegating Using Lambda Expressions

We used lambda expressions and the strategy pattern to separate a concern from method, even can also use them to separate a concern from a class.

### Creating a Delegate

Rather than delegating part of the responsability to another class, we can delegate it to lambda expressions and method references.

```java
// CalculateNAV.java

public class CalculateNAV {

  public BigDecimal computeStockWorth(final String ticker, final int shares) {
    return priceFinder.apply(ticker).multiply(BigDecimal.valueOf(shares));
  }

  //... other methods that use the priceFinder ...

}
```

Now we need the `priceFinder`; we have to decide what kind of object it will be.

```java
// CalculateNAV.java

private Function<String, BigDecimal> priceFinder;
```

Here's the constructor for the CalculateNAV class

```java
public CalculateNAV(final Function<String, BigDecimal> aPriceFinder) {
  priceFinder = aPriceFinder;
}
```

### Stubbing the Web Service

Create a unit test to try out our computeStockWorth() method, stubbing away the implementation of the apply method.

```java
// CalculateNAVTest.java

public class CalculateNAVTest {

  @Test
  public void computeStockWorth() {
    final CalculateNAV calculateNAV = new CalculateNAV(ticker -> new BigDecimal("6.01"));
    BigDecimal expected = new BigDecimal("6010.00");

    assertEquals(0, calculateNAV.computeStockWorth("GOOG", 1000).compareTo(expected),0.001);
  }
  //...
}
```

Testing the code was quick; we easily stubbed away the dependency to the web sevice, which helped to rapidly and test code. But we can't call it done until we run it with a real web service.

### Integrating with the Web Service

Talking the real web service is almost as easy.

```java
// CalculateNAV.java

final CalculateNAV calculateNav = new CalculateNAV(YahooFinance::getPrice);

System.out.println(String.format("100 shares of Google worth: $%.2f", calculateNav.computeStockWorth("GOOG", 100)));
```

```java
// YahooFinance.java

public class YahooFinance {
  public static BigDecimal getPrice(final String ticker) {
    try {
      final URL url = new URL("http://ichart.finance.yahoo.com/table.csv?s=" + ticker);
      final BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

      final String data = reader.lines().skip(1).findFirst().get();
      final String[] dataItems = data.split(",");
      return new BigDecimal(dataItems[dataItems.length - 1]);
    } catch(Exception ex) {
      throw new RuntimeException(ex);
    }
  }
}
```

## Decorating Using Lambda Expressions

### Designing Filters

Adding filters to a camera is a good example of chaining behavior or responsabilities. We may start with no filters, then add a filter, and then a few more.

```java
// Camera.java

@SuppressWarnings("unchecked")
public class Camera {
  private Function<Color, Color> filter;

  public Color capture(final Color inputColor) {
    final Color processedColor = filter.apply(inputColor);
    //... more processing of color...
    return processedColor;
  }

  //... other functions that use the filter ...
}
```

The Camera has a field for the filter, a reference to an instance of Function (much like the delegation example we saw earlier). This filter function can receive a Color and return a processed Color.

To achieve this flexibility, we’ll use a method that belongs to a special type called default methods, which is new to Java 8. In addition to abstract methods, interfaces can have methods with implementation, marked as default. These methods are automatically added to the classes that implement the interfaces. This was done as a trick in Java 8 to enhance existing classes with new methods without having to change each one of them. In addition, interfaces can have static methods.

In addition to the apply() abstract method, the Function interface has a default method, compose(), to combine or chain multiple Functions. Within the lambda expression that stands in for a Function parameter, we can readily use this method.

The compose() method can combine or chain two Functions together. Once we compose them, a call to apply() will hop through the chained Functions. Let’s take a quick look at how that works. Suppose we compose two Functions, target and next, like this:

```text
wrapper = target.compose(next);
```

Now let’s invoke the apply() method on the resulting wrapper.

```text
wrapper.apply(input);
```

The result of that call is the same as doing this:

```text
temp = target.apply(input);
return next.apply(temp);
```

Without the temporary variable, it would be like this:

```text
return next.apply(target.apply(input));
```

Now let's write a setFilter() method that takes a varargs of Function; we can send zero or more filters to this functon. In addition, let's create the constructor for the camera

```java
// Camera.java

public void setFilters(final Function<Color, Color>... filters) {
  filter =
    Stream.of(filters)
          .reduce((filter, next) -> filter.compose(next))
          .orElse(color -> color);
}

public Camera() { setFilters(); }
```

In the setFilters() methos we iterate through the filters and compose them into a chain using the compose() method. If no filter is given, then the reduce() method will return an Optional empty. In that case we provide a dummy filter as an argument to the orElse() method, and it simply returns the color that the filter would receive for processing. If we provide filters to the setFilters() method, the filter field will refer to the first filter—an instance of Function<Color, Color>—that’s at the head of a chain of filters.

We provided a lambda expression as a parameter to the orElse() method of the Optional that the reduce() method returned. The Function interface has an identity() static method that does the same operation as the lambda expression we wrote. Instead of creating our own lambda expression, we can use a reference to that method instead. To do so, we need to change

```text
.orElse(color -> color);
```

to

```text
.orElseGet(Function::identity);
```

In addition to the setFilters() method we have a constructor that simply sets the filter to the dummy filter I mentioned previously.

We’ll use it with no filters first, but we need a Camera instance to start. Let’s create one and assign it to a local variable camera.

```java
// Camera.java

final Camera camera = new Camera();

final Consumer<String> printCaptured = (filterInfo) ->
  System.out.println(String.format("with %s: %s", filterInfo, camera.capture(new Color(200, 100, 200))));

```

To see the camera in action, we need a convenience function to print the capture() method’s results. Rather than creating a standalone static method, we created a lambda expression to stand in for an instance of the Consumer func- tional interface, right here within the main() method. We chose a Consumer because printing consumes the value and does not yield any results. This function will invoke capture() with the colors 200, 100, 200 for the red, green, and blue parts of color, respectively, and print the resulting filtered/processed output. Let’s ask the camera to capture the given colors.

```java
// Camera.java

printCaptured.accept("no filter");
```

Since no filters are given, the captured color should be the same as the input;
let’s verify that in the output.

```text
with no filter: java.awt.Color[r=200,g=100,b=200]
```

### Adding a Filter

Adding a filter is breeze; we simply have to pass the filter to the setFilters() methos. The filter can be a simple lambda expression or a method reference. We can use brighter() on the java.awt.Color class as a filter, so let’s simply pass a reference of this method to the setFilters() method.

```java
// Camera.java

camera.setFilters(Color::brighter);
printCaptured.accept("brighter filter");
```

Let’s look at the result of the capture() with this filter in place.

```text
with brighter filter: java.awt.Color[r=255,g=142,b=255]
```

The input color has been brightened. As we can see, the output RGB values are higher than the corresponding values in the input. Let’s quickly change the filter to a darker shade.

```java
// Camera.java

camera.setFilters(Color::darker); i
printCaptured.accept("darker filter");
```

This should reduce the brightness of the input, as we can see in the output.

```text
with darker filter: java.awt.Color[r=140,g=70,b=140]
```

### Adding Multiple Filters

The design is good so far; now let's mix to filters - a brighter one and a darker one - to see the effect of chaining

```java
// Camera.java

camera.setFilters(Color::brighter, Color::darker);
printCaptured.accept("brighter & darker filter");
```

We passed two method references to the setFilters() method—just essence, no ceremony. (We could’ve passed in lambda expressions instead of method ref- erences.) The two filters are now chained and the filter reference in the Camera instance is referring to the head of the chain. A call to the capture() method will now route the color processing through each of these filters.

With this filter combination, the input color goes through a series of transfor- mations or filtering; first it passes through the bright filter, which brightens the shades, then it goes through the dark filter, which makes the colors darker again, as we can see from the output.

```text
with brighter & darker filter: java.awt.Color[r=200,g=100,b=200]
```

### A Peek into the default Methods.

The Java compiler follows a few simple rules to resolve `default` methods.

1. Subtypes automatically carry over the `default` methods from their supertypes.
2. For interfaces that contribute a default method, the implementation in a subtype takes precedence over the one in supertypes.
3. Implementations in classes, including abstract declarations, take prece- dence over all interface defaults.
4. If there’s a conflict between two or more default method implementations, or there’s a default-abstract conflict between two interfaces, the inheriting class should disambiguate.

```java
public interface Fly {
  default void takeOff() { System.out.println("Fly::takeOff"); }
  default void land() { System.out.println("Fly::land"); }
  default void turn() { System.out.println("Fly::turn"); }
  default void cruise() { System.out.println("Fly::cruise"); }
}

public interface FastFly extends Fly {
  default void takeOff() { System.out.println("FastFly::takeOff"); }
}

public interface Sail {
  default void cruise() { System.out.println("Sail::cruise"); }
  default void turn() { System.out.println("Sail::turn"); }
}

public class Vehicle {
  public void turn() { System.out.println("Vehicle::turn"); }
}
```

Now let's create a class that inherits these types.

```java
public class SeaPlane extends Vehicle implements FastFly, Sail {
  private int altitude;
  //...
  public void cruise() {
    System.out.print("SeaPlane::cruise currently cruise like: ");
    if(altitude > 0)
      FastFly.super.cruise();
    else
      Sail.super.cruise();
  }
}
```

To see the behavior of the default methods in action, let's create an instance of SeaPlane and invoke the methods on it.

```java
SeaPlane seaPlane = new SeaPlane();
seaPlane.takeOff();
seaPlane.turn();
seaPlane.cruise();
seaPlane.land();
```

We can now compare the output we got from the mental run of the code with the output from the run on the computer:

```java
FastFly::takeOff
Vehicle::turn
SeaPlane::cruise currently cruise like: Sail::cruise
Fly::land
```

### Creating Fluent Interfaces Using Lambda Expressions

We can use these techniques to structure the APIof our classes, to make it more intuitive and fluent for programmers to use.

### Starting with a Design

Let's start with a simple Mailer class and evolve the design of this interface

```java
// Mailer.java

public class Mailer {
  public void from(final String address) { /*... */ }
  public void to(final String address)   { /*... */ }
  public void subject(final String line) { /*... */ }
  public void body(final String message) { /*... */ }
  public void send() { System.out.println("sending..."); }

//...
}
```

The class looks routine -- a brunch of voids methods. Let's use this class to configure and send out and email

```java
// Mailer.java

Mailer mailer = new Mailer();
mailer.from("build@agiledeveloper.com");
mailer.to("venkats@agiledeveloper.com");
mailer.subject("build notification");
mailer.body("...your code sucks...");
mailer.send();
```

First it's noisy; we had to repeat the mailer so many times. Second, at the end of the call, what do we do with the mailer instance? we can reuse it for another set of calls, or is it disposable?

### Using method Chaining

Rather tha repeating the reference, it would by great to continue a conversational state on a context object. We can archieve this using a simple _method chaining_ or _cascade method_ patter. In this pattern, rather than having void methods, we make each method return an instance. This returned object is often _this_, the object on which the method is invoked:

```java
// MailBuilder.java

public class MailBuilder {
  public MailBuilder from(final String address) { /*... */; return this; }
  public MailBuilder to(final String address)   { /*... */; return this; }
  public MailBuilder subject(final String line) { /*... */; return this; }
  public MailBuilder body(final String message) { /*... */; return this; }
  public void send() { System.out.println("sending..."); }

//...
}
```

The new interface will be ledd noisy to use; we get rid of the repetitive variable name and nicely chain the calls

```java
// MailBuilder.java

new MailBuilder()
  .from("build@agiledeveloper.com")
  .to("venkats@agiledeveloper.com")
  .subject("build notification")
  .body("...it sucks less...")
  .send();
```

We started with a MailBuilder instance and chained the calls to the functions in sequence to the instance that the previous call returned. The method chaining, or a train wreck as some like to call it, passed the state from one call to next as we moved through the chain.

Even though this design reduced the nise, it has a few disadvantages. The new keyword sticks out, reducing the API's fluency and readability. The design does not prevent someone from storing the reference from new and then chaining from that reference. In the latter case, we’d still have the issue with object lifetime, the second smell I mentioned earlier. Also, there are a lot of corner cases.


### Making the API Intuitive and Fluent

Let's evolve the design further. This time we'll combine the method-chaining approach with lambda expressions.

```java
// FluentMailer.java

public class FluentMailer {
  private FluentMailer() {}

  public FluentMailer from(final String address) { /*... */; return this; }
  public FluentMailer to(final String address) { /*... */; return this; }
  public FluentMailer subject(final String line) { /*... */; return this; }
  public FluentMailer body(final String message) { /*... */; return this; }

  public static void send(final Consumer<FluentMailer> block) {
    final FluentMailer mailer = new FluentMailer();
    block.accept(mailer);
    System.out.println("sending...");
  }

//...
}
```

Just like in the method-chaining version, all the nonterminal methods return the instance. In addition, in this version we made the constructor private. This will disallow direct object creation. We also made the terminal method, send(), a static method and it expects a Consumer as a parameter.

Rather than creating an instance, users will now invoke send() and pass a block of code. The send() method will create an instance, yield it to the block, and, upon return, complete any required validations and perform its final send operations.

```java
// FluentMailer.java

FluentMailer.send(mailer -> mailer
    .from("build@agiledeveloper.com")
    .to("venkats@agiledeveloper.com")
    .subject("build notification")
    .body("...much better..."));
```

The instance’s scope is fairly easy to see: we get it, work with it, and return it. For that reason, this is also called the loan pattern.

### Dealing with Exceptions

Java programmers are quite opinionated about checked exceptions. Irrespec- tive of how we feel about them, checked exceptions are here to stay and we have to deal with them.

In the next example we create a lambda expression that invokes a method that potentially throws a checked exception. We take a list of path names and ask for their canonical path using the getCanonicalPath() method.

```java
public class HandleException {
  public static void main(String[] args) throws IOException {
    Stream.of("/usr", "/tmp")
          .map(path -> new File(path).getCanonicalPath())
          .forEach(System.out::println);
    //Error, this code will not compile
  }
}
```

We’ve decorated the main() method with the throws clause. However, when we compile this code the Java compiler will report an error:

```text
... unreported exception IOException; must be caught or declared to be thrown
         .map(path -> new File(path).getCanonicalPath())
                                                      ^
1 error
```

The error is directly from within the lambda expression passed to the map() method. This method expects as a parameter an implementation of the Function interface. The apply() method of the Function interface does not specify any checked exceptions. So, our lambda expression that stands in for the abstract method in this example is not permitted to throw any checked exceptions.

We’re limited to two options here: we could either handle the exception right there within the lambda expression, or catch it and rethrow it as an unchecked exception. Let’s try the first option:

```java
Stream.of("/usr", "/tmp")
      .map(path -> {
        try {
          return new File(path).getCanonicalPath();
        } catch(IOException ex) {
          return ex.getMessage();
        }
      })
    .forEach(System.out::println);
```

In the previous example we were limited to the Function interface since the map() method relies on it. When we design our own higher-order functions based on our specific needs, we can more flexibly design the companion functional interfaces to go with it. For example, the next code shows a functional interface whose method specifies a checked exception using the throws clause.

```java
// UseInstance.java

@FunctionalInterface
public interface UseInstance<T, X extends Throwable> {
  void accept(T instance) throws X;
}
```

Any method that accepts a parameter of the UseInstance interface will expect and be ready to handle appropriate exceptions or propagate them


# Chapter 5 Working with Resources

## Cleaning Up Resources

## Peeking into the problem

We're converned with external resource cleanup, so let's start with a simple example class that use a FileWriter to some messages

```java
// FileWriterExample.java

public class FileWriterExample {
  private final FileWriter writer;

  public FileWriterExample(final String fileName) throws IOException {
    writer = new FileWriter(fileName);
  }
  public void writeStuff(final String message) throws IOException {
    writer.write(message);
  }
  public void finalize() throws IOException {
    writer.close();
  }
  //...
}
```

Let's write a main() method to use thiss class

```java
// FileWriterExample.java

public static void main(final String[] args) throws IOException {
  final FileWriterExample writerExample = new FileWriterExample("peekaboo.txt");
  writerExample.writeStuff("peek-a-boo");
}
```

We created an instance of the FileWriterExample class and invoked the writeStuff() method on it, but if we ran this code, we’d see that the peekaboo.txt file was created but it’s empty. The finalizer never ran; the JVM decided it wasn’t necessary as there was enough memory. As a result, the file was never closed, and the content we wrote was not flushed from memory.

## Closing the Resource

```java
// FileWriterExample.java

public void close() throws IOException {
  writer.close();
}
```

Let's make explicit use of this method if the main() method.

```java
// FileWriterExample.java

final FileWriterExample writerExample = new FileWriterExample("peekaboo.txt");

writerExample.writeStuff("peek-a-boo");
writerExample.close();
```

## Ensuring Cleanup

We need to ensure the call to close() happens whether or not there's an exception. To achive this we can wrap the call in a finally block.

```java
// FileWriterExample.java
final FileWriterExample writerExample = new FileWriterExample("peekaboo.txt");
try {
   writerExample.writeStuff("peek-a-boo");
} finally {
  writerExample.close();
}
```

This version ensure resource cleanup even if an exception occurs in the code, but that's a lot of effort and the code is quite smelly. The automatic resource management (ARM) feature, introduced in Java 7, was designed to reduce such smells, as we'll see next.

## Using ARM

ARM can reduce the verbority in the previous example. Rather than using both the try and finally blocks, we can use a special form of the try block with a recource attached to it.

```java
// FileWriterARM.java

try(final FileWriterARM writerARM = new FileWriterARM("peekaboo.txt")) {
  writerARM.writeStuff("peek-a-boo");

  System.out.println("done with the resource...");
}
```

We created an instance of the class FileWriterARM within the safe haven of the try-with-resources form and invoked the writeStuff() method within its block. When we leave the scope of the try block, the close() method is automatically called on the instance/resource managed by this try block. For this to work, the compiler requires the managed resource class to implement the AutoCloseable interface, which has just one method, close().

```java
// FileWriterARM.java

public class FileWriterARM implements AutoCloseable {
  private final FileWriter writer;

  public FileWriterARM(final String fileName) throws IOException {
    writer = new FileWriter(fileName);
  }

  public void writeStuff(final String message) throws IOException {
    writer.write(message);
  }

  public void close() throws IOException {
    System.out.println("close called automatically...");
    writer.close();
  }
  //...
}
```

Let's run the code an look at the peekaboo.txt file and the console for the code's output

```text
done with the resource...
close called automatically...
```

## Using Lambda Expressions to Clean Up Resources

## Preparing the Class for Resource Cleanup

The class FileWriterEAM, that encapsulates heavy resources that need timely cleanup. In this example we'll use the FileWriter to represent that resource. Let's make both the contructor and the close() methods private that'll grab the attention of programmers trying to use the class.

```java
// FileWriterEAM.java

public class FileWriterEAM {
  private final FileWriter writer;

  private FileWriterEAM(final String fileName) throws IOException {
    writer = new FileWriter(fileName);
  }
  private void close() throws IOException {
    System.out.println("close called automatically...");
    writer.close();
  }
  public void writeStuff(final String message) throws IOException {
    writer.write(message);
  }
  //...
}
```

## Using Higher-Order Functions

Since the programmers can't directly create an instance of FileWriterEAM, we need a factory method for them to use. Unlike the regular factory methods that create an instance and throw it across the fence, our method will yield it to users and wait for them to finish their work with it.

```java
// FileWriterEAM.java

public static void use(final String fileName, final UseInstance<FileWriterEAM, IOException> block) throws IOException {

  final FileWriterEAM writerEAM = new FileWriterEAM(fileName);
  try {
    block.accept(writerEAM);
  } finally {
     writerEAM.close();
  }
}
```

In the use() method, we receive two parameters, fileName and a reference to an interface UserInstance (which we haven't defined yet). Within method we instantiate FileWriterEAM, and within the safe haven of the try and finally block we pass the instance to an accept() method of our soon-to-be-created interface. When the call returns, we invoke the close() method on the instance in the finally block. Instead of using this construct, we could user ARM within the use() method.In any case, the users of our class don't have to worry aboiut these details.

## Using the Design for Instance Cleanup

```java
// FileWriterEAM.java

FileWriterEAM.user("eam.txt", writerEAM -> writerEAM.writeStuff("sweet"));
```

In the example we use the given instance writerEAM for just one call within the lambda expression. If we have to perform more operations with it, we can send it off to other functions as an argument. We can also perform a few operations on it, right within the lambda expression, by using multiline syntax.

```java
FileWriterEAM.use("eam2.txt", writerEAM -> {
  writerEAM.writeStuff("how");
  writerEAM.writeStuff("sweet");
});
```

## Managing Locks

Locks play a critical part in concurrent Java applications. In this section we'll use lambda expressions to gain finer control over locks and open the doors to unit-test the proper locking of critical sections.

synchronized is an age-old keyword used to provide mutual exclusion. A synchronized block of code, such as synchronized { ... }, is a realization of the _execute around method pattern_

```java
// Loocking.java

public class Locking {
  Lock lock = new ReentrantLock(); //or mock

  protected void setLock(final Lock mock) {
    lock = mock;
  }

  public void doOp1() {
    lock.lock();
    try {
      //...critical code...
    } finally {
      lock.unlock();
    }
  }
  //...
}
```

We’re using a Lock lock field to share the lock between methods of this class. However, the task of locking—for example, within the doOp1() method—leaves a lot to be desired. It’s verbose, error prone, and hard to maintain. Let’s turn to lambda expressions for help, and create a small class to manage the lock.

```java
// Locker.java

public class Locker {
  public static void runLocked(Lock lock, Runnable block) {
    lock.lock();

    try {
      block.run();
    } finally {
      lock.unlock();
    }
  }
}
```

This class absobrs the pain of working with the Lock interface so the rest of the code benefits. We can use the runLocked() method in code to wrap critical sections.

```java
// Locking.java

public void doOp2() {
  runLocked(lock, () -> {/*...critical code ... */});
}

public void doOp3() {
  runLocked(lock, () -> {/*...critical code ... */});
}

public void doOp4() {
  runLocked(lock, () -> {/*...critical code ... */});
}
```

The methods are quite concise, and they use the static method runLocked() of the Locker helper class we created (we’d need an import static Locker.runLocked for this code to compile). Lambda expressions come to our assistance once more.


## Creating Concise Exception Tests

When Java 5 annotations were introduced, JUnit was quick to use them. Overall this has been a benefit, but one use in particular, the convenience of exception tests, leads to terse rather than concise code. Let’s understand the issues and then resolve them using—good guess—lambda expressions. We will see here that lambda expressions are not just another language feature; they alter the way we think and design applications.

## Exception Test with try and catch

Here’s the test for the maxProfit() method with try and catch to check for exceptions.

```java
// RodCutterTest.java

@Test public void VerboseExceptionTest() {
  rodCutter.setPrices(prices);
  try {
    rodCutter.maxProfit(0);
    fail("Expected exception for zero length");
  } catch(RodCutterException ex) {
    assertTrue("expected", true);
  }
}
```

That’s quite verbose and it may take some effort to understand, but this code is quite specific about what’s expected to fail: the call to the maxProfit() method.

## Exception Test Using Annotation

Here we are tempted attack the verbosity with annotation

```java
// RodCutterTest.java

@Test(expected = RodCutterException.class)
public void TerseExceptionTest() {
  rodCutter.setPrices(prices);
  rodCutter.maxProfit(0);
}
```

The code is short but deceptive—it’s terse. It tells us that the test should pass if the exception RodCutterException is received, but it fails to ensure that the method that raised that exception is maxProfit(). If the setPrices() method threw that exception, due to some code change, then this test will continue to pass, but for the wrong reason. A good test should pass only for the right reasons —this test deceives us.

## Using Lambda Expressions for Exception Tests

Let’s use lambda expressions to look for exceptions. We’ll manually create the code for this in a TestHelper class, but if and when JUnit supports this natively we won’t have to write such a class.

```java
// TestHelper.java

public class TestHelper {
  public static <X extends Throwable> Throwable assertThrows(final Class<X> exceptionClass, final Runnable block) {

    try {
      block.run();
    } catch(Throwable ex) {
      if(exceptionClass.isInstance(ex))
        return ex;
    }

    fail("Failed to throw expected exception ");
    return null;

  }
}
```

In the TestHelper we wrote a static method assertThrows() that expects an exception class and a block of code to run. It exercises the block of code, and examines the exception the code throws. If no exception was thrown or if an exception other than the type given in the first parameter was received, the call will fail using the JUnit fail() method.

We use this helper to create a concise test

```java
// RodCutterTest.java

@Test
public void ConciseExceptionTest() {
  rodCutter.setPrices(prices);
  assertThrows(RodCutterException.class, () -> rodCutter.maxProfit(0));
}
```

## Exercising the Tests

```java
// RodCutterTest.java

@Test public void VerboseExceptionTest() {
  rodCutter.setPrices(prices);
  try {
    rodCutter.maxProfit(0);
    fail("Expected exception for zero length");
  } catch(RodCutterException ex) {
    assertTrue("expected", true);
  }
}

@Test(expected = RodCutterException.class)
public void TerseExceptionTest() {
  rodCutter.setPrices(prices);
  rodCutter.maxProfit(0);
}

@Test
public void ConciseExceptionTest() {
  rodCutter.setPrices(prices);
  assertThrows(RodCutterException.class, () -> rodCutter.maxProfit(0));
}
```

All these tests are checking whether the maxProfit() method throws an exception. Let’s implement minimal code in the RodCutter class to make the tests pass.

```java
// RodCutter.java

public class RodCutter {
  public void setPrices(final List<Integer> prices) {
  }
  public int maxProfit(final int length) {
    if (length == 0) throw new RodCutterException();

    return 0;
  }
}
```

The maxProfit() method throws an exception if the value of the length parameter is zero, which is exactly what the tests are checking for. Let’s look at the result of running the tests.

```text
...
Time: ...

OK (3 tests)
```

All the tests achieve the same goal, but the last concise version is better than the others; one change to the setPrice() method will show us why.

```java
// RodCutter.java

public void setPrices(final List<Integer> prices) {
  throw new RodCutterException();
}
```

The setPrice() method, which is called in each of the tests, now abruptly throws the RodCutterException exception. Since the tests are expecting the method maxProfit() to throw a specific exception, any other behavior in the invoked code should trigger an alert. Good tests would fail now due to the code change we made; poor tests will quietly pass. Let’s run the tests to see how they perform.

```text
.E.E.
Time: ...
There were 2 errors:
...
```

We saw how lambda expressions help us write tests that target specific methods for the expected exception, and that helps us create concise, easy- to-read, less error-prone tests.

# Chapter 6 Being Lazy

In Java we often execute code eagerly. The arguments are evaluated right at the time of method calls. When executing code, we can gain in performance by being just a little lazy, Eager is simple, but lazy is efficient.

## Delayed initialization

In object-oriented programming we ensure that objects are well constructed before any methods calls. We, encapsule, ensure proper state transitions, and preserve the objects invariants. This works well most of the time, but when parts of an object's internals are heavyweight resources.

## A Familiar Approach

In the following example, we will craft a way to delay the creation of a heavy-weight instance

```java
// Heavy.java

public class Heavy {
  public Heavy() { System.out.println("Heavy created"); }

  public String toString() { return "quite heavy"; }
}
```

This class represents a hypothetical heavyweight resource. In this constructor we print a message to tell us when it's created. Let's use an instance of this class in the first trial version the _Holder_ class, named _HolderNaive_

```java
public class HolderNaive {
  private Heavy heavy;

  public HolderNaive() {
    System.out.println("Holder created");
  }

  public Heavy getHeavy() {
    if(heavy == null) {
      heavy = new Heavy();
    }

    return heavy;
  }

//...
```

At first glance this code appears quite simple. We created a _null_ reference, _heavy_, and assigned it to a proper instance on the first call to the getheavy() method.

Let's use this class to create an instance of HolderNaive and see if it postpones the creation of the Heacy instance.

```java
// HolderNaive.java

final HolderNaive holder = new HolderNaive();
System.out.println("deferring heavy creation...");
System.out.println(holder.getHeavy());
System.out.println(holder.getHeavy());
```

This is the code's output

```text
Holder created
deferring heavy creation...
Heavy created
quite heavy
quite heavy
```

## Providing Thread Safety

For an instance of HolderNaive, the dependent instance of Heavy is created on the first call to the getHeavy() method. On subsequent calls to this method, the already created instance will be returned. That’s exactly what we want, but there’s a catch.

If two or more threads call the getHeavy() method at the same time, then we could end up with multiple Heavy instances, potentially one per thread. This side effect is undesirable.

```java
public synchronized Heavy getHeavy() {
  if(heavy == null) {
    heavy = new Heavy();
  }

  return heavy; }
```

We marked getHeavy() with the synchronized keyword to ensure mutual exclusion. If two or more threads call this method concurrently, due to mutual exclusion only one will be allowed to enter and the others will queue up for their turn. The first one to enter into the method will create the instance. When subse- quent threads enter this method they will see that the instance already exists, and will simply return it.

## Adding a Level of Indirection

The indirection we’ll add in this example comes from a Supplier<T> class. This is a functional interface in the JDK, with one abstract method named get() that returns an instance. In other words, this is a factory that keeps on giving without expecting anything as input.

In the most rudimentary form a Supplier will return an instance

```java
Supplier<Heavy> supplier = () -> new Heavy();
```

Alternatively, we could use a constructor reference instead of the traditional new syntax to instantiate an instance

```java
Supplier<Heavy> supplier =  Heavy::new;
```

We took a look at what a _Supplier_ can do for us, we need something more than this simple form

```java
// Holder.java

public class Holder {
  private Supplier<Heavy> heavy = () -> createAndCacheHeavy();

  public Holder() {
    System.out.println("Holder created");
  }

  public Heavy getHeavy() {
    return heavy.get();
  }
  //...
}
```

The filed _heavy_ in this version is an instance of the Supplier<Heavy>. We assign it to a lambda expression and the Java compiler synthesize from it an instance with the expected get() method.

```java
private synchronized Heavy createAndCacheHeavy() {
  class HeavyFactory implements Supplier<Heavy> {
    private final Heavy heavyInstance = new Heavy();

    public Heavy get() { return heavyInstance; }
  }

  if(!HeavyFactory.class.isInstance(heavy)) {
    heavy = new HeavyFactory();
  }

  return heavy.get();
}
```

We’ll mark this method synchronized so threads calling this method concurrently will be mutually exclusive. But within this method, on the first call we quickly replace the Supplier reference heavy with a direct supplier, HeavyFactory, that will return an instance of Heavy.

The second concurrent thread to enter will again check if heavy is an instance of HeavyFactory, and will bypass the creation. It would simply return the same instance that first thread returned. Here we assume Heavy itself is thread safe, and we’re only focusing on the thread safety of Holder.

## Lazy Evaluations

Java already uses lazy execution when evaluation logical operations. For example, in fn1() || fn2(), the call fn2() is never performed if fn1() returns a _boolean false_

While Java uses a lazy or normal order when evaluating logical operators., it uses eager or applicative order when evaluation method arguments. All the arguments to methods are fully evaluatd before a methos is invoked.

 ## Starting with Eager Evaluation

We call them eagerly and then alter the design to improve speed. Let's start with a method evaluate() that takes quite a bit of time and resources to run

```java
// Evaluation.java

public class Evaluation {
  public static boolean evaluate(final int value) {
    System.out.println("evaluating ..." + value);
    simulateTimeConsumingOp(2000);
    return value > 100;
  }
  //...
}
```

A call to evaluate() would take a couple of seconds to run, so we definitely want to postpone any unnecessary calls. Let's create a method, eagerEvaluator(), which is like almost any method we write in Java: all of its arguments will be evaluated before its call

```java
// Evaluation.java

public static void eagerEvaluator(
  final boolean input1, final boolean input2) {
  System.out.println("eagerEvaluator called...");
  System.out.println("accept?: " + (input1 && input2));
}
```

The method takes two _boolean_ parameters. Within the method we perform a logical _and_ operations on the parameters. Sadly, it's too late to benefit from the lazy evaluation this operation automatically provides since the argument s are evaluated well before enter this method.

Invoking eagerEvaluator()

```java
eagerEvaluator(evaluate(1), evaluate(2));
```

If we run this code we'll see both the calls to evaluate() execute well before we enter the eagerEvaluator() method

```text
evaluating ...1
evaluating ...2
eagerEvaluator called...
accept?: false
```

## Designing for Lazy Evaluation

If we know that some arguments may not be used during the execution of a method, we can design the method's interface to facilitate the delayed execution of some or all argument. The arguments can be evaluated on demand, like in this lazyEvaluator() method

```java
// Evaluation.java

public static void lazyEvaluator(
  final Supplier<Boolean> input1, final Supplier<Boolean> input2) {
  System.out.println("lazyEvaluator called...");
  System.out.println("accept?: " + (input1.get() && input2.get()));
}
```

The logical and operation we use within the lazyEvaluator() method will invoke the get() methods only on demand.

> If we pass two calls to evaluate() as arguments to the lazyEvaluator() method, the second will be evaluated only if the first call returned a boolean true

```java
// Evaluation.java

lazyEvaluator(() -> evaluate(1), () -> evaluate(2));
```

Each Suppler makes a call to the evaluate() method, but not until the lazyEvaluator() method is invoked.

```text
lazyEvaluator called...
evaluating ...1
accept?: false
```

## Leveraging the Laziness of Streams

## Intermediate and Terminal Operations

_Streams_ have two types of methods: _intermediate_ and _terminal_, which work together. Methods like _map()_ and _filter()_ are intermediate; calls to them return immediately and the lambda expressions provided to them are not evaluated right away.

```java
// Streams.java

public class LazyStreams {
  private static int length(final String name) {
    System.out.println("getting length for " + name);
    return name.length();
  }

  private static String toUpper(final String name ) {
    System.out.println("converting to uppercase: " + name);
    return name.toUpperCase();
  }
  //...
}
```

The two helper methos simply print the paramters they receive before returning the expected result

Now we wrote these methods to take a peek at the intermediate operations in the code we'll write next

```java
// LazyStream.java

public static void main(final String[] args) {
  List<String> names = Arrays.asList("Brad", "Kate", "Kim", "Jack", "Joe", "Mike", "Susan", "George", "Robert", "Julia", "Parker", "Benson");

final String firstNameWith3Letters =
  names.stream()
       .filter(name -> length(name) == 3)
       .map(name -> toUpper(name))
       .findFirst()
       .get();

  System.out.println(firstNameWith3Letters);
}
```

At first glance it appears the code is doing a lot of work transforming collections, but it's deceptively lazy

## Method Evaluation Order

If the code were eager, the filter() method would have first gone through all dozen names in the collection to create a list of two names, Kim and Joe, whose length is three (letters). The subsequent call to the map() method would have then evaluated the two names. The findFirst() method finally would have picked the first element of this reduced list.

Both the filter() and map() methods are lazy to the bone. As the execu- tion goes through the chain, the filter() and map() methods store the lambda expressions and pass on a façade to the next call in the chain. The evaluations start only when findFirst(), a terminal operation, is called.

## Peeking into the Laziness

Writing the series of operations as a chain is the preferred and natural way in Java 8. But to really see that the lazy evaluations didn’t start until we reached the terminal operation, let’s break the chain from the previous code into steps.

```java
// LazyStreams.java

Stream<String> namesWith3Letters =
  names.stream()
       .filter(name -> length(name) == 3)
       .map(name -> toUpper(name));

System.out.println("Stream created, filtered, mapped...");
System.out.println("ready to call findFirst...");

final String firstNameWith3Letters =
  namesWith3Letters.findFirst().get();

System.out.println(firstNameWith3Letters);
```

We transformed the collection into a stream, filtered the values, and then mapped the resulting collection. Then, separately, we called the terminal operation.

```text
Stream created, filtered, mapped...
ready to call findFirst...
getting length for Brad
getting length for Kate
getting length for Kim
converting to uppercase: Kim
KIM
```

## Creating infinite, Lazy Collections

Infinite collections can make the code to create a growing series, like the Fibonacci numbers, clearer and easier to express. But from our experience in Java, we might think a series can’t be infinite due to practical memory limits.

## A Desperate Attempt

Use a series of prime numbers, 2, 3, 5, 7,... as an example to explore the concepts here

```java
// Primes.java

public static boolean isPrime(final int number) {
  return number > 1 && IntStream.rangeClosed(2, (int) Math.sqrt(number)).noneMatch(divisor -> number % divisor == 0);
}
```

On our first attempt, we’ll use the isPrime() method to create a series of prime numbers starting at any given number.

```java
//don't try this at the office

public static List<Integer> primes(final int number) {
  if(isPrime(number))
    return concat(number, primes(number + 1));
  else
    return primes(number + 1);
}
```

## Reaching for the Stars

The Stream interface has a static method iterate() that can create an infinite Stream. It takes two parameters, a seed value to start the collection, and an instance of a UnaryOperator interface, which is the supplier of data in the collection. The Stream the iterate() method returns will postpone creating the elements until we ask for them using a terminating method. To get the first element, for example, we could call the findFirst() method. To get ten elements we could call the limit() method on the Stream, like so: limit(10).

```java
// Primes.java

public class Primes {
  private static int primeAfter(final int number) {
    if(isPrime(number + 1))
      return number + 1;
    else
      return primeAfter(number + 1);
  }

  public static List<Integer> primes(final int fromNumber, final int count) {
    return Stream.iterate(primeAfter(fromNumber - 1), Primes::primeAfter)
                 .limit(count)
                 .collect(Collectos.<Integer>toList());
  }
  //...
}
```

Let’s call the primes() method first to get ten primes starting at 1, and then five primes starting at 100.

```java
// Primes.java

System.out.println("10 primes from 1: " + primes(1, 10));

System.out.println("5 primes from 100: " + primes(100, 5));
```

```text
10 primes from 1: [2, 3, 5, 7, 11, 13, 17, 19, 23, 29]
5 primes from 100: [101, 103, 107, 109, 113]
```

# Chapter 7 Optimizing Recursions

NEW CHANGES
NEW CHANGES
NEW CHANGES
