---
title: "Spock Framework"
date: 2023-07-06T01:24:09-06:00
draft: false
---



# **INDEX**
# [Spock Primer](#spock-primer)
# [Data Driven Testing](#data-driven-testing)





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
