---
title: "Functional Programming"
date: 2023-07-06T20:39:27-06:00
draft: false
---


# **INDEX**


# [Chapter 1 Hello Lambda Expressions!](#chapter-1-hello-lambda-expression)
# [Chapter 2 Using Collections](#chapter-2-using-collections)
# [Chapter 3 Strings, Comparators, and Filters](#chapter-3-strings-comparators-and-filters)
# [Chapter 4 Designing with Lambda Expressions](#chapter-4-designing-with-lambda-expressions)

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

## Stubbing the Web Service

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
