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

