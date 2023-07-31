---
title: "Spock Framework"
date: 2023-07-06T01:24:09-06:00
draft: false
---



# **INDEX**
# [Spock Primer](#spock-primer)
# [Data Driven Testing](#data-driven-testing)
# [Interaction Based Testing](#interaction-based-testing)





# Spock Primer
## Imports

```groovy
import spock.lang.*
```

## Specification
```groovy
class MyFirstSpecification extends Specification {
  // fields
  // fixture methods
  // feature methods
  // helper methods
}
```

## Fields
Its a good practice to initialice them right at the point of declaration.
```groovy
def obj = new ClassUnderSpecification()
def coll = new Collaborator()
```

Somethimes you need to share an object between methods; declare `@Shared` field. This es equivalent to initializing the field at the very beginning of the `setupSpec()` method.
```groovy
@Shared res = new VeryExpensiveResource()
```

Static field should only for constants.
```groovy
static final PI = 3.141592654
```

## Fixture Methods
```groovy
def setupSpec() {}    // runs once - before the first feature method
def setup() {}        // runs before every feature method
def cleanup() {}      // runs after every feature method
def cleanupSpec() {}  // runs once - after the last feature method
```
> **_NOTE:_**  They may only one fixture method of each type per specification class

### Invocation order

1. super.stupSpec
2. sub.setupSpec
3. super.setup
4. sub.setup
5. feature.method
6. sub.cleanup
7. super.cleanup
8. sub.cleanupSpec
9. super.cleanupSpec

## Feature Methods
Conceptually, a feature method consists of four phases:
1. Set up the feature's fixture
2. Provide a _stimulus_ to the system under specification
3. Describe the _response_ expected from the system
4. Clean up the feature's fixture

```groovy
def "pushing an element on the stack"() {
  // blocks go here
}
```

### Blocks
1. given
2. when
3. then
4. expect
5. cleanup
6. where

### Given blocks
```groovy
given:
  def stack = new Stack()
  def elem = "push me"
```

### When and Then Blocks
```groovy
when:       // stimulus
then:       // response
```

#### Conditions
```groovy
when:
  stack.push(elem)

then:
  !stack.empty
  stack.size() == 1
  stack.peek() == elem)
```

> **_TIP:_** Try to keep the number of conditions per feature method small.

#### Implicit and explicit conditions
```groovy
def setup(){
  stack = new Stack()
  assert stack.empty
}
```

#### Excepion Conditions
```groovy
when:
  stack.pop()

then:
  thrown(EmptyStackException)
  stack.empty
```

```groovy
when:
  stack.pop()

then:
  def e = thrown(EmptyStackException)
  e.cause == null
```

```groovy
when:
  stack.pop()

then:
  EmptyStackException e = thrown()
  e.cause == null
```

```groovy
def "HashMap accepts null key"() {
  given:
    def map = new HashMap()

  when:
    map.put(null, "elem")

  then:
    notThrown(NullPointerException)
}
```

### Interactions
Whereas conditions decribe an object's state, interactions describe how objects communicate with each other.

```groovy
def "events are published to all subscribers"() {
  given:
    def subscriber1 = Mock(Subscriber)
    def subscriber2 = Mock(Subscriber)
    def publisher = new Publisher()
    publisher.add(subscriber1)
    publisher.add(subscriber2)

  when:
    publisher.fire("event")

  then:
    1 * subscriber1.receive("event")
    1 * subscriber2.receive("event")
}
```

### Expect Block
An expect block is more limited than a `then` block in that may only contain conditions and variable definitions.
Compare the following two attempts to describe the Math.max() method:
```groovy
when:
  def x = Math.max(1, 2)

then:
  x == 2
```

by this one:
```groovy
expecto:
  Math.max(1,2) == 2
```

Although both snippets are semantically equivalent, the secont one is crearly preferable. As a guidelan, use `when-then` to describe methods with side effects, and `expect` to describe purely dunctional methods.

### Clean Blocks
A cleanup block may only be followed by a `where` block, and may not be repeated. Like a cleanup method, is is used to free many resources used by a feature method, and is run even if teh feature has producedan exception.
```grooovy
given:
  def file = new File("/some/path")
  file.createNewFile()

  // ...

cleanup:
  file.delete()
```

### Where blocks
A `where` block always come last in a method, and may not be repeated. It is used to write data-driven feature methods.

```groovy
def "computing the maximum of two numbers"() {
  expect:
    Math.max(a, b) == c

  where:
    a << [5, 3]
    b << [1, 9]
    c << [5, 9]
}
```

## Helper Methods
Sometimes feature methods grow large and/or contains lots of duplicate code. In such case it can make sense to introduce one o more helper methods. Two good candidates for helper methods are setup/cleanup logic and complex condition
```groovy
def "offered PC matches preferred configuration"() {
  when:
    def pc = shop.buyPc()

  then:
    pc.vendor == "Sunny"
    pc.clockRate >= 2333
    pc.ram >= 4096
    pc.os == "Linux"
}
```

If you happend to be a computer geek, you preferred PC configuration mught be very detailed, ou you might want to compare offers from many different shops
```groovy
def "offered PC matches preferred configuration"() {
  when:
    def pc = shop.buyPc()

  then:
    matchesPreferredConfiguration(pc)
}

def matchesPreferredConfiguration(pc) {
  pc.vendor == "Sunny"
  && pc.clockRate >= 2333
  && pc.ram >= 4096
  && pc.os == "Linux"
}
```.

The helper method matchesPreferredConfiguration() consists of a single boolean expression whose result is returned:

```groovy
Condition not satisfied:

matchesPreferredConfiguration(pc)
|                             |
false                         ...
```

No very helpful. Fortunately, we can do better:
```groovy
void matchesPreferredConfiguration(pc) {
  assert pc.vendor == "Sunny"
  assert pc.clockRate >= 2333
  assert pc.ram >= 4096
  assert pc.os == "Linux"
}
```

## Using `with` for expectations
As an alternative to the above helper methods, you can use with(target, closure) method to interact on the object being verified.
```groovy
def "offered PC matches preferred configuration"() {
  when:
    def pc = shop.buyPc()

  then:
    with(pc) {
      vendor == "Sunny"
      clockRate >= 2333
      ram >= 406
      os == "Linux"
    }
```

Unlike when you helper methods, there is no need for explicit assert statements for proper error reporting
When verifying mocks, a `with` statement can also cut out verbose verification statements

```groovy
def service = Mock(Service) // has start(), stop(), and doWork() methods
def app = new Application(service) // controls the lifecycle of the service

when:
  app.run()

then:
  with(service) {
    1 * start()
    1 * doWork()
    1 * stop()
  }
```

## Using `verifyAll` to assert multiple expecations together
Normal exprectations fail the test on the first failed assertions. Sometimes it is helpful to collect these failures before failling the test more information, this behavior is also know as soft assertions
```groovy
def "offered PC matches preferred configuration"() {
  when:
    def pc = shop.buyPc()

  then:
    verifyAll(pc) {
      vendor == "Sunny"
      clockRate >= 2333
      ram >= 406
      os == "Linux"
    }
}
```

or can be used without a target
```groovy
expect:
  verifyAll {
    2 == 2
    4 == 4
  }
```

## Specifications as Documentations
Well-written specifications are a valuable source of information. Especially for higher-level specifications targeting a wider audience than just developers, it makes sense to provide more information in natural languaje than just the names specifications and features. Therefore, Spock provides a way to attach textual descriptions to blocks.

```groovy
given: "open a database connection"
// code goes here
```

Use the `and:` label to describe logically different parts of a block
```groovy
given: "open a database connection"
// code goes here

and: "seed the customer table"
// code goes here

and: "seed the product table"
// code goes here
```

An and: label followed by a description can be inserted at any (top-level) position of a feature method, without altering the method’s semantics.

In Behavior Driven Development, customer-facing features (called stories) are described in a given-when-then format. Spock directly supports this style of specification with the given: label:
```groovy
given: "an empty bank account"
// ...

when: "the account is credited \$10"
// ...

then: "the account's balance is \$10"
// ...
```
## Extensions
As we have seen, Spock offers lots of functionality for writing specifications. However, there always comes a time when something else is needed. Therefore, Spock provides an interception-based extension mechanism. Extensions are activated by annotations called directives. Currently, Spock ships with the following directives:

|             |    |
| ----------- | -- |
| @Timeout    | Sets a timeout for execution of a feature of fixture method |
| @Ignore     | Ignores any feature method carrying this annotation |
| @IgnoreRest | Any feature method carrying this annotations will be executed, all others will be ignored. Useful for quickly running just a single method |
| @FailsWith  | Expects a feature method to complete abruptly. @FailsWith has two use cases: First, to document known bugs that cannot be resolved immediately. Second, to replace exception conditions in certain corner cases where the latter cannot be used (like specifying the behavior of exception conditions). In all other cases, exception conditions are preferable |



# Data Driven Testing

## Introduction

Suppose we want to specify the bahavior of the MAth.max

```groovy
class MathSpec extends Specification {
  def "maximum of two numbers"() {
    expect:
    // exercise math method for a few different inputs
    Math.max(1, 3) == 3
    Math.max(7, 4) == 7
    Math.max(0, 0) == 0
  }
}
```

* Code and data are mixed and cannot easily be changed indenpendently
* Data cannot easily be auto-generated or fetched from external sources
* In order to exercise the same code multiple times, it either has to be duplicated or extracted into a separated method
* In case of a failure, it may not be immediatly clear which input caused the failure
* Exercising teh same code multiple times does not ebenfit from the same isolation as executing separate method does

```groovy
class MathSpec extends Specification {
  def "maximum of two numbers"(int a, int b, int c) {
    expect:
    Math.max(a, b) == c
    ...
  }
}
```

In this code we have finished the test logic, but still need to supply the data values to be used. This is done in a `where`: block, which always comes at the end of the method. In the simplest (and most common) case, the `where`: block holds a _data table_

## Data Tables

Data tables are a convenient way to exercise a feature method with a fixed set of data values

```groovy
class MathSpec extends Specification {
  def "maximum of two numbers"(int a, int b, int c) {
    expect:
    Math.max(a, b) == c

    where:
    a | b | c
    1 | 3 | 3
    7 | 4 | 7
    0 | 0 | 0
  }
}
```

The data table must have at least two columns. A single-columns table can be written as:

```groovy
where:
a | _
1 | _
7 | _
0 | _
```

A sequence of two or more unsdescore can be used to split one wide data table into multiple narrower ones.

```groovy
where:
a | _
1 | _
7 | _
0 | _
__

b | c
1 | 2
3 | 4
5 | 6
```

This is semantically exactly the same, just as one wider combined data table

```groovy
where:
a | b | c
1 | 1 | 2
7 | 3 | 4
0 | 5 | 6
```

The sequence of two or more underscores can be used anywhere in the where block. It will be ignored everywhere, except for in between two data tables, where it is used to separate the two data tables. This means that the separator can also be used as styling element in different ways. It can be used as separator line like shown in the next example

```groovy
where:
_____
a | _
1 | _
7 | _
0 | _
_____
b | c
1 | 2
3 | 4
5 | 6
```

## Isolate Execution of Iterations

Iteration are isolated from each other in the same wey as separate feature methods. Each iteartion get its own instance of the specification class, and the `setup` and `cleanup` methods will be before and after each iteration respectively.

## Sharing Objects between Iterations

I order to share an Object between iterationsm it has to be keep in @Shared or static filed.

> Only @Shared and static variables can be accessed from with a `where` block

## Syntactic Variations

The previous code can be tweaked in a few ways

First, since the where block already declares all data variable, the method parameters can be omitted
Second, inputs and matched by outputs can be separated with  a double pipe simbol `||` to visually set them apart

```groovy
class MathSpec extends Specification {
  def "maximum of two numbers"() {
    expect:
    Math.max(a, b) == c

    where:
    a | b || c
    1 | 3 || 3
    7 | 4 || 7
    0 | 0 || 0
  }
}
```

Even you can use double pipes

```groovy
class MathSpec extends Specification {
  def "maximum of two numbers"() {
    expect:
    Math.max(a, b) == c

    where:
    a ; b ;; c
    1 ; 3 ;; 3
    7 ; 4 ;; 7
    0 ; 0 ;; 0
  }
}
```

Pipes and semicolons as data column separator can not be mixed one table, if the column separator changes, this starts a new stand aline data table.

```groovy
class MathSpec extends Specification {
  def "maximum of two numbers"() {
    expect:
    Math.max(a, b) == c
    Math.max(d, e) == f

    where:
    a | b || c
    1 | 3 || 3
    7 | 4 || 7
    0 | 0 || 0

    d ; e ;; f
    1 ; 3 ;; 3
    7 ; 4 ;; 7
    0 ; 0 ;; 0
  }
}
```

## Reporting of Failures

Assume that our implementation of the max method has a flaw, and one of the iterations fails

```text
maximum of two numbers [a: 1, b: 3, c: 3, #0]   PASSED
maximum of two numbers [a: 7, b: 4, c: 7, #1]   FAILED

Condition not satisfied:

Math.max(a, b) == c
|    |   |  |  |  |
|    |   7  4  |  7
|    42        false
class java.lang.Math

maximum of two numbers [a: 0, b: 0, c: 0, #2]   PASSED
```

Iterations of a feature method are by default unrolled with a rich naming pattern. This pattern can also be configured as documented at Unrolled Iteration Names or the unrolling can be disabled

## Method Uprolling and Unrolling

A method annoted with @Rollup will have its iteration not reportrd independently but only aggregated within the feature.

```groovy
@Rollup
def "maximum of two numbers"() {
...
```

Note that up- and unrolling has no effect on how the method gets executed; it is only an alternation in reporting. Depending on the execution environment, the output will look something like:

```text
maximum of two numbers   FAILED

Condition not satisfied:

Math.max(a, b) == c
|    |   |  |  |  |
|    |   7  4  |  7
|    42        false
class java.lang.Math
```

The @Rollup annotation can also be placed on a spec. This has the same effect as placing it on each data-driven feature method of the spec that does not have an @Unroll annotation.

Alternatively the configuration file setting unrollByDefault in the unroll section can be set to false to roll up all features automatically unless they are annotated with @Unroll or are contained in an @Unrolled spec and thus reinstate the pre Spock 2.0 behavior where this was the default.

```groovy
//Disable Default Unrolling
unroll {
    unrollByDefault false
}
```

It is illegal to annotate a spec or a feature with both the @Unroll and the @Rollup annotation and if detected this will cause an exception to be thrown.

To summarize:

A feature will be uprolled

* if the method is annotated with @Rollup
* if the method is not annotated with @Unroll and the spec is annotated with @Rollup
* if neither the method nor the spec is annotated with @Unroll and the configuration option unroll { unrollByDefault } is set to false

A feature will be unrolled

* if the method is annotated with @Unroll
* if the method is not annotated with @Rollup and the spec is annotated with @Unroll
* if neither the method nor the spec is annotated with @Rollup and the configuration option unroll { unrollByDefault } is set to its default value true


## Data Pipes

A data pipe, indicated by the left-shift `<<` operator, connects a data variable to a _data prvider_. The data provider holds all values for the variable, one per iteration. This include objects of type Collection, Strings, Iterables and objects implementing the Iterable contract.

```groovy
...
where:
a << [1, 7, 0]
b << [3, 4, 0]
c << [3, 7, 0]
```

## Multi-Variable Data Pipes

If a data provider returns multiple values per iteration, it can be connected to multiple data variables simultaneously

```groovy
@Shared sql = Sql.newInstance("jdbc:h2:mem:", "org.h2.Driver")

def "maximum of two numbers"() {
  expect:
  Math.max(a, b) == c

  where:
  [a, b, c] << sql.rows("select a, b, c from maxdata")
}
```

Data can be ignored with an underscore `_`

```groovy
...
where:
[a, b, _, c] << sql.rows("select * from maxdata")
```
The multi-assignments can even be nested. The following example will generate these iterations:

| a | b | c |
| - | - | - |
| ['a1', 'a2'] | 'b1' | 'c1' |
| ['a2', 'a1'] | 'b1' | 'c1' |
| ['a1', 'a2'] | 'b2' | 'c2' |
| ['a2', 'a1'] | 'b2' | 'c2' |

```groovy
...
where:
[a, [b, _, c]] << [
  ['a1', 'a2'].permutations(),
  [
    ['b1', 'd1', 'c1'],
    ['b2', 'd2', 'c2']
  ]
].combinations()
```

## Named deconstruction of data pipes

Since Spock 2.2, multi variable data pipes can also be deconstructed from maps. This is useful when the data provider returns a map with named keys. Or, if you have long values that don’t fit well into a data-table, then using the maps makes it easier to read.

```groovy
...
where:
[a, b, c] << [
  [
    a: 1,
    b: 3,
    c: 5
  ],
  [
    a: 2,
    b: 4,
    c: 6
  ]
]
```

You can use named deconstruction with nested data pipes, but only on the innermost nesting level.

```groovy
...
where:
[a, [b, c]] << [
  [1, [b: 3, c: 5]],
  [2, [c: 6, b: 4]]
]
```

## Data Variable Assigment

A data variable can be directly assigned

```groovy
...
where:
a = 3
b = Math.random() * 100
c = a > b ? a : b
```

Assignments are re-evaluated for every iteration. As already shown above, the right-hand side of an assignment may refer to other data variables:

```groovy
...
where:
row << sql.rows("select * from maxdata")
// pick apart columns
a = row.a
b = row.b
c = row.c
```

## Accessing Other Data Variables

There are only two possibilities to access one data variable

The first possibility are derived data variables like every data variable that is defined by a direct assignment can access all previously defined data variables, including the ones defined through data tables or data pipes:

```groovy
...
where:
a = 3
b = Math.random() * 100
c = a > b ? a : b
```

The second possibility is to access previous columns within data tables:

```groovy
...
where:
a | b
3 | a + 1
7 | a + 2
0 | a + 3
```

This also includes columns in previous data tables in the same where block:

```groovy
...
where:
a | b
3 | a + 1
7 | a + 2
0 | a + 3

and:
c = 1

and:
d     | e
a * 2 | b * 2
a * 3 | b * 3
a * 4 | b * 4
```

## Multi-Variable Assignment

You can also assign to multiple variables in one expression, if you have some object Groovy can iterate over.

```groovy
@Shared sql = Sql.newInstance("jdbc:h2:mem:", "org.h2.Driver")

def "maximum of two numbers multi-assignment"() {
  expect:
  Math.max(a, b) == c

  where:
  row << sql.rows("select a, b, c from maxdata")
  (a, b, c) = row
}
```

The data values thar aren't of intereset can be ignored with an underscore `_`

```groovy
...
where:
row << sql.rows("select * from maxdata")
(a, b, _, c) = row
```

## Combining Data Tables, Data Pipes and Variable Assigments

```groovy
...
where:
a | b
1 | a + 1
7 | a + 2
0 | a + 3

c << [3, 4, 0]

d = a > c ? a : c
```

## Type Coercion for Data Variable Values

Data variable values are coerced to the declared parameter type using type coercion. Due to that custom type conversions can be provided as extension module or with the help of the @Use extension on the specification (as it has no effect to the where: block if applied to a feature).

```groovy
def "type coercion for data variable values"(Integer i) {
  expect:
  i instanceof Integer
  i == 10

  where:
  i = "10"
}
```

and

```groovy
@Use(CoerceBazToBar)
class Foo extends Specification {
  def foo(Bar bar) {
    expect:
    bar == Bar.FOO

    where:
    bar = Baz.FOO
  }
}
enum Bar { FOO, BAR }
enum Baz { FOO, BAR }
class CoerceBazToBar {
  static Bar asType(Baz self, Class<Bar> clazz) {
    return Bar.valueOf(self.name())
  }
}
```

## Number of iterations

The number of iterations depends on how much data is available. Successive executions of the same method can yield different numbers of iterations.

## Closing of Data Providers

After all iterations have completed, the zero-argument close method is called on all data providers that have such a method.

## Unrolled Iteration Names

By default, the names of unrolled iteration are the name of the feature, plus the data variable and the iterations index. This will always produce unique names and should enable you to identify easily the falling data variable combination like this

```groovy
def "maximum of #a and #b is #c"() {
...
```

This method name uses placeholders, denoted by a leading hash sign (#), to refer to data variables a, b, and c. In the output, the placeholders will be replaced with concrete values:

```text
maximum of 1 and 3 is 3   PASSED
maximum of 7 and 4 is 7   FAILED

Math.max(a, b) == c
|    |   |  |  |  |
|    |   7  4  |  7
|    42        false
class java.lang.Math

maximum of 0 and 0 is 0   PASSED
```

An unrolled method name is similar to a Groovy GString.except for the following differences:

* Expressions are denoted with # instead of $, and there is no equivalent for the ${...} syntax
* Express only support property access and zero-arg methods calls.

Given a class Person with properties name and age, and a data variable person of type Person, the following are valid method names:

```groovy
def "#person is #person.age years old"() {  // property access
def "#person.name.toUpperCase()"() {        // zero-arg method call
```

Non-string values (like #person above) are converted to Strings according to Groovy semantics.

The following are invalid method names:

```groovy
def "#person.name.split(' ')[1]" {  // cannot have method arguments
def "#person.age / 2" {  // cannot use operators
```

Additionally, to the data variables the tokens #featureName and #iterationIndex are supported. The former does not make much sense inside an actual feature name.

```groovy
def "#person is #person.age years old [#iterationIndex]"() {
...
```

will be reported as

```text
╷
└─ Spock ✔
   └─ PersonSpec ✔
      └─ #person.name is #person.age years old [#iterationIndex] ✔
         ├─ Fred is 38 years old [0] ✔
         ├─ Wilma is 36 years old [1] ✔
         └─ Pebbles is 5 years old [2] ✔
```

Alternatively, to specifying the unroll-pattern as method name, it can be given as parameter to the @Unroll annotation which takes precedence over the method name:

```groovy
@Unroll("#featureName[#iterationIndex] (#person.name is #person.age years old)")
def "person age should be calculated properly"() {
// ...
```

will reported as

```text
╷
└─ Spock ✔
   └─ PersonSpec ✔
      └─ person age should be calculated properly ✔
         ├─ person age should be calculated properly[0] (Fred is 38 years old) ✔
         ├─ person age should be calculated properly[1] (Wilma is 36 years old) ✔
         └─ person age should be calculated properly[2] (Pebbles is 5 years old) ✔
```

The advantage is, that you can have a descriptive method name for the whole feature, while having a separate template for each iteration. Furthermore, the feature method name is not filled with placeholders and thus better readable.

If neither a parameter to the annotation is given, nor the method name contains a #, the configuration file setting defaultPattern in the unroll section is inspected. If it is set to a non-null string, this value is used as unroll-pattern. This could for example be set to

* featureName to have all iterations reported with the same name, or
* featureName[#iterationIndex] to have a simply indexed iteration name, or
* iterationName if you make sure that in each data-driven feature you also set a data variable called iterationName that is then used for reporting

## Special Tokens

This is a list of special tokens

* #featureName is the name of the feature (mostly useful for the defaultPatter setting)
* #iterationIndex is the current iteration index
* #dataVariables lists all data varuables for this iteration, eg x:1, y:2, z:3
* #dataVariablesWithIndex the same as #dataVariables but with an index at the end, eg x:1, y:2, z:3, #0


## Configuration

Set Default Unroll-Pattern

```groovy
unroll {
    defaultPattern '#featureName[#iterationIndex]'
}
```

Disable Unroll-pattern Expression Asserting
```groovy
unroll {
    validateExpressions false
}
```

Disable repetition of feature name in iterations
```groovy
unroll {
    includeFeatureNameForIterations false
}
```

With includeFeatureNameForIterations true

```text
╷
└─ Spock ✔
   └─ ASpec ✔
      └─ really long and informative test name that doesn't have to be repeated ✔
         ├─ really long and informative test name that doesn't have to be repeated [x: 1, y: a, #0] ✔
         ├─ really long and informative test name that doesn't have to be repeated [x: 2, y: b, #1] ✔
         └─ really long and informative test name that doesn't have to be repeated [x: 3, y: c, #2] ✔
```

With includeFeatureNameForIterations false

```text
└─ Spock ✔
   └─ ASpec ✔
      └─ really long and informative test name that doesn't have to be repeated ✔
         ├─ x: 1, y: a, #0 ✔
         ├─ x: 2, y: b, #1 ✔
         └─ x: 3, y: c, #2 ✔
```

# Interaction Based Testing
Interation-based hased testing is a design and testing technique that emerged in the Extreme Programming (XP) community in the early 2000's. Focusing on tje behavior of objects rather than their state, it explores hot the objects under specification interact, by the way of mthods calls. with their collaborators.

Given this Groovy classes:

```groovy
class Publisher {
  List<Subscriber> subscribers = []
  int messageCount = 0
  void send(String message){
    subscribers*.receive(message)
    messageCount++
  }
}

interface Subscriber {
  void receive(String message)
}

class PublisherSpec extends Specification {
  Publisher publisher = new Publisher()
}
```

## Creating Mock Objects

```groovy
def subscriber = Mock(Subscriber)
def subscriber2 = Mock(Subscriber)
```

Alternatively, the following Java-like syntaxis is supported:

```groovy
Subscriber subscriber = Mock()
Subscriber subscriber2 = Mock()
```

## Default Behavior of Mock Objects

Initially, mock objects have no behavior. Calling methods on them is allowed but has no effect other than returning the default value for the method’s return type (false, 0, or null). An exception are the Object.equals, Object.hashCode, and Object.toString methods, which have the following default behavior: A mock object is only equal to itself, has a unique hash code, and a string representation that includes the name of the type it represents.

## Injecting Mock Objects into Code Under Specification

After creating the publisher and his subscribes, we need to make the latter known to the former:

```groovy
class PublisherSpec extends Specification {
  Publisher publisher = new Publisher()
  Subscriber subscriber = Mock()
  Subscriber subscriber2 = Mock()

  def setup() {
    publisher.subscribers << subscriber         // << is a Groovy shorthand for List.add()
    publisher.subscribers << subscriber2
  }
```

## Mocking

Mocking is the act of describing (mandatory) interactions between the objects under specification and its collaborators.

```groovy
def "should send messages to all subscribers"() {
  when:
  publisher.send("hello")

  then:
  1 * subscriber.receive("hello")
  1 * subscriber2.receive("hello")
}
```

> When the publisehd send a 'hello' message, then both subscribers receive that message exactly once

When this feature methods gets run, all invocations on mock objects that occurs while executing the `when` block will be matched against the interactions described in the `then` block.

If one of the interactions isn't satisfied, a (subclass of) `InteractionNotSatisfiedError` will be thrown.

## Interactions

While an insteraction looks similar to a regular method invocation, it is simply a way to express whicj method invocation are expected to occur. A good way og an interaction is as a regular expression that all incoming invocations on mock objects are matched against. Depending on the circumstances, the interaction may match zero, one, or multiple invocations.

Let's take a closer look at the `then:`  block. It containt two _interactions_, each of which has four distinct parts:

* cardinality
* target constraint
* method constraint
* argument constraint

```text
1 * subscriber.receive("hello")
|   |          |       |
|   |          |       argument constraint
|   |          method constraint
|   target constraint
cardinality
```

## Cardinality

The cardinality of an interaction describes how often a method call is expected

```groovy
1 * subscriber.receive("hello")        // exactly one call
0 * subscriber.receive("hello")        // zero calls
(1..3) * subscriber.receive("hello")   // between one and three calls (inclusive)
(1.._) * subscriber.receive("hello")   // at least one call
(_..3) * subscriber.receive("hello")   // at most three calls
_ * subscriber.receive("hello")        // any number of calls, including zero
                                       // (rarely needed; see 'Strict Mocking')
```

## Target Constraint

The method contraint of an interaction describe which method is expected to be called

```groovy
1 * subscriber.receive("hello")         // a call to 'subscriber'
1 * _.receive("hello")                  // a call to any mock object
```
