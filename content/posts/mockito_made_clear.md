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

