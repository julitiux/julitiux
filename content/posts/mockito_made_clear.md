---
title: "Mockito made clear (2023)"
date: 2023-11-28T23:16:32-06:00
draft: false
---

## **INDEX**

# [Chapter 1 Build a Testing Foundation](#chapter-1-build-a-testing-foundation)

# Chapter 1 Build a Testing Foundation

## Saying Hello to Mockito

```java
// HelloWorld.java
public class HelloWorld{
    public static void main(String[] args){
        System.out.println("Hello, World!");
    }
}
```

```java
// HelloMockito.java
public class HelloMockito{
    private String greeting = "Hello, %s, from Mockito!";

    public String greet(String name){
        return String.format(greeting, name);
    }
}
```

It's easy enough to create a JUnit 5 test

```java
import org.junit.jupiter.api.Test

class HelloMockitoTest {
    private HelloMockito helloMockito = new HelloMockito();

    @Test
    void greetPerson(){
        String greeting = helloMockito.greet("World");
        assertEquals("Hello, World, from Mockito!", greeting);
    }
}
```

HelloMockito doesn't have any dependencies, Mockito isn't needed at all.

```java
// HelloMockito.java

public class HelloMockito {
    private String greeting = "Hello, %s, from Mockito!";

    // Dependencies
    private final PersonRepository personRepository;
    private final TranslationService translationService;

    // Constructor to inject the dependencies
    public HelloMockito(PersonRepository personRepository, TranslationService translationService) {
        this.personRepository = personRepository;
        this.translationService = translationService;
    }

    // Method we want to test
    public String greet(int id, String sourceLang, String targetLang) {
        Optional<Person> person = personRepository.findById(id);
        String name = person.map(Person::getFirst).orElse("World");
        return translationService.translate(String.format(greeting, name), sourceLang, targetLang);
    }
}
```

Two interfaces: PersonRepository.java and TranslationService.java

```java
// PersonRepository.java

public interface PersonRepository {
    Person save(Person person);
    Optional<Person> findById(int id);
    List<Person> findAll();

    long count();
    void delete(Person person);
}
```

```java
// TranslationService.java

public interface TranslationService {
    default String translate(String text,
            String sourceLang,
            String targetLang){

        return text;
    }
}
```
## Adding Mockito to the Project

Into my build.gradle

```groovy
// Using Gradle version catalogs -- see gradle/libs.versions.toml
plugins {
    id 'java'
}

group 'com.kousenit'
version '1.0'

repositories {
    mavenCentral()
}
dependencies {
    // JUnit bundle (includes vintage engine)
    testImplementation libs.bundles.junit

    // Mockito bundle (inline and JUnit Jupiter engine)
    testImplementation libs.bundles.mockito

    // AssertJ
    testImplementation libs.assertj
}

tasks.named('test') {
    useJUnitPlatform()
}
```

Note this file relies on the new Gradle Version Catalogs introduced in Gradle 7.4 which means the _gradle_ folder includes a file called _libs.version.toml_, with the following contents:

```toml
[versions]
assertj = "3.23.1"
junit = "5.9.1"
mockito = "4.9.0"

[libraries]
assertj = { module = "org.assertj:assertj-core",version.ref = "assertj" }
junit-jupiter = { module = "org.junit.jupiter:junit-jupiter",version.ref = "junit" }
junit-vintage = { module = "org.junit.vintage:junit-vintage-engine",version.ref = "junit" }
mockito-inline = { module = "org.mockito:mockito-inline",version.ref = "mockito" }
mockito-junit = { module = "org.mockito:mockito-junit-jupiter", version.ref = "mockito" }

[bundles]
junit = ["junit-jupiter", "junit-vintage"]
mockito = ["mockito-inline", "mockito-junit"]
```

This file you should be put inside to _./gradle_ folder
