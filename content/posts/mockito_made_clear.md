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
plugins {
    id 'java'
    id 'org.springframework.boot' version '3.2.0'
    id 'io.spring.dependency-management' version '1.1.4'
    id "io.freefair.lombok" version "8.3"
}

group = 'com.learn_mockito'
version = '0.0.1-SNAPSHOT'

java {
    sourceCompatibility = '17'
}

repositories {
    mavenCentral()
}

dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-web'
    testImplementation 'org.springframework.boot:spring-boot-starter-test'

    // Flyway
    implementation 'org.flywaydb:flyway-core'

    // Lombok
    compileOnly 'org.projectlombok:lombok'
    annotationProcessor 'org.projectlombok:lombok'

    // Retrofit
    implementation libs.retrofit.core
    implementation libs.retrofit.gson

    // Jackson JSON library
    implementation libs.jackson

    // Gson
    implementation libs.gson

    // Mockito
    testImplementation libs.bundles.junit
    testImplementation libs.bundles.mockito
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
gson = "2.10.1"
retrofit = "2.9.0"
jackson = "2.15.2"

[libraries]
assertj = { module = "org.assertj:assertj-core", version.ref = "assertj" }
junit-jupiter = { module = "org.junit.jupiter:junit-jupiter", version.ref = "junit" }
junit-vintage = { module = "org.junit.vintage:junit-vintage-engine", version.ref = "junit" }
mockito-inline = { module = "org.mockito:mockito-inline", version.ref = "mockito" }
mockito-junit = { module = "org.mockito:mockito-junit-jupiter", version.ref = "mockito" }
gson = { module = "com.google.code.gson:gson", version.ref = "gson" }
retrofit-core = { module = "com.squareup.retrofit2:retrofit", version.ref = "retrofit" }
retrofit-gson = { module = "com.squareup.retrofit2:converter-gson", version.ref = "retrofit" }
jackson = { module = "com.fasterxml.jackson.core:jackson-databind", version.ref = "jackson" }

[bundles]
junit = [
  "junit-jupiter",
  "junit-vintage"
]
mockito = [
  "mockito-inline",
  "mockito-junit"
]
```

Dont forget put this file inside to _./gradle_ folder

Beacuse we're using JUnit 5 for tests, we included two dependencies for Mockito:

* The _mockito-core_ dependency
* The JUnit 5 extension for Mockito, here called _mockito-junit-jupiter_

## A Mockito Test Class with Everything

```java
// HelloMockitoTestFull.java

@ExtendWith(MockitoExtension.class)
class HelloMockitoTest {

    @Mock
    private PersonRepository repository;
    @Mock
    private TranslationService translationService;

    @InjectMocks
    private HelloMockito helloMockito;

    @Test
    @DisplayName("Greet Admiral Hopper")
    void greetAPersonThatExists() {

        // set the expectations on the mocks
        when(repository.findById(anyInt()))
            .thenReturn(Optional.of(new Person(1, "Grace", "Hopper",
                LocalDate.of(1906, Month.DECEMBER, 9))));
        when(translationService.translate("Hello, Grace, from Mockito!", "en", "en"))
            .thenReturn("Hello, Grace, from Mockito!");

        // test the greet method
        String greeting = helloMockito.greet(1, "en", "en");

        assertEquals("Hello, Grace, from Mockito!", greeting);

        // verify the methods are called once, in the right order
        InOrder inOrder = inOrder(repository, translationService);
        inOrder.verify(repository).findById(anyInt());
        inOrder.verify(translationService).translate(anyString(), eq("en"), eq("en"));
    }

    @Test
    @DisplayName("Greet a person not in the database")
    void greetAPersonThatDoesNotExist() {

        when(repository.findById(anyInt()))
            .thenReturn(Optional.empty());
        when(translationService.translate("Hello, World, from Mockito!", "en", "en"))
            .thenReturn("Hello, World, from Mockito!");
        String greeting = helloMockito.greet(100, "en", "en");

        assertEquals("Hello, World, from Mockito!", greeting);

        // verify the methods are called once, in the right order
        InOrder inOrder = inOrder(repository, translationService);
        inOrder.verify(repository).findById(anyInt());
        inOrder.verify(translationService)
    }
}
```
