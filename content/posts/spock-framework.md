---
title: "Spock Framework"
date: 2023-07-06T01:24:09-06:00
draft: false
---




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
