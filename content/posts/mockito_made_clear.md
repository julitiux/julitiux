---
title: "Mockito made clear (2023)"
date: 2023-11-28T23:16:32-06:00
draft: false
---

## **INDEX**

# [Chapter 1 Build a Testing Foundation](#chapter-1-build-a-testing-foundation)
# [Chapter 2 Work with the Mockito API](#chapter-2-work-with-the-mockito-api)

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

# Chapter 2 Work with the Mockito API

## Selecting Out System to Test

We need a class to test that includes a dependency, so we'll use the _PersonRepository_ interface

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
// PersonService.java

public class PersonService {

  private final PersonRepository personRepository;

  public PersonService(PersonRepository personRepository) {
    this.personRepository = personRepository;
  }

  // methods to be tested
```

Into the test PersonServiceTest add the attribute:

```java
// PersonServiceTest.java

private final List<Person> people = Arrays.asList(
        new Person(1, "Grace", "Hopper", LocalDate.of(1906, Month.DECEMBER, 9)),
        new Person(2, "Ada", "Lovelace", LocalDate.of(1815, Month.DECEMBER, 10)),
        new Person(3, "Adele", "Goldberg", LocalDate.of(1945, Month.JULY, 7)),
        new Person(14, "Anita", "Borg", LocalDate.of(1949, Month.JANUARY, 17)),
        new Person(5, "Barbara", "Liskov", LocalDate.of(1939, Month.NOVEMBER, 7)));

```

Implement test using Mock method

```java
@Test
void getLastNames_usingMockMethod() {
    // create a stub for the PersonRepository
    PersonRepository mockRepo = new PersonService(mockRepo);

    // Set the expectations on the mock...
    when(mockRepo.findAll()).thenReturn(people);

    // Inject the mock into the service
    PersonService personService = new PersonService(mockRepo);

    // Get the last names (this is the method to test)
    List<String> lastNames = personService.getLastNames();

    // Check that the last names are correct (using AssertJ)
    assertThat(lastNames).contains("Borg", "Goldberg", "Hopper", "Liskov", "Lovelace");

    // Verify that the service called findAll on the mockRepo exactly once
    verify(mockRepo).findAll();
}
```

## Creating Mocks and Stubs

Before we use Mockito, note that we could write out own stub implementation called _InMemoryPersonRepository_

```java
// InMemoyPersonRepository.java

public class InMemoryPersonRepository implements PersonRepository {

    private final List<Person> people = Collections.synchronizedList(new ArrayList<>());

    @Override
        public final Person save(Person person) {
            synchronized (people) {
                people.add(person);
            }
            return person;
        }

    @Override
        public final void delete(Person person) {
            synchronized (people) {
                people.remove(person);
            }

        }
    // ... other methods from PersonRepository ...
}

```

You may have noticed the issues with this approach

1. We have to implement all the methods in the interface, even though our test requires only one of them
2. Wu have to maintain this class, so if our repository methods change, the stub will have to be updated as well
3. If we want to test failure modes, validation, or exceptional cases, we'll need either additional classes or some logic that lets us choose those alternatives.

### Using the mock Method

The mock method in the _Mockito_ class has the following signature:

```java
public class static <T> T mock(Class<T> classToMock)
```

You tell Mockito which class or interface to mock, and Mockito returns the mock object:

```java
PersonRepository mockRepo = mock(PersonRepository.class)
```

That's easy enough. Mockito will generate a class that implements this onterface, where all the methods will return their default values.

```java
// PersonServiceTest.java

@Test
void defaultImplementations() {
    PersonRepository mockRepo = mock(PersonRepository.class);
    assertAll(
            () -> assertNull(mockRepo.save(any(Person.class))),
            () -> assertTrue(mockRepo.findById(anyInt()).isEmpty()),
            () -> assertTrue(mockRepo.findAll().isEmpty()),
            () -> assertEquals(0, mockRepo.count())
    );
}
```

The mock returns a _null_ for the save method, empty _Optional_ instances for tge two finder methods, and 0 for _count_. The delete method already returns _void_, so the mock doesn't change that and therefore doesn't need to be tested.


Hopefully,, you'll find the process intuitive, It does include two steps that can get tedious, because they'll appear in every test we write:

|. We need to create the mock every time, and
2. We need to inject the mock into the class under test every time.

### Using Annotations to Create the Mocks

Mockito provides two annotations for mocks:

1. @Mock
2. @InjectMocks

The combination of one or more attributes with @Mock and a single @InjectMocks on the class under test tells Mockito to create the necessary mocks and do its best inject them into the class under test.

An example shows how to use the @Mock and @InjectMocks annotatíons on the attributes of the PersonServiceTest:

```java
// PersonServiceTest.java

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {
    @Mock
    private PersonRepository repository;

    @InjectMocks
    private PersonService service;

}
```

Whenever you use annotations, you need to tell Mockito to process them. JUnit 5 uses the Mockito JUnit 5 Extension, which is the argument to the _@ExtendWith_ annotation on the test class. This extension initializes the mocks, and, as a side note, "handles strict stubbings". That means in your test you can mock only methods that your method under test actually calls.

The test fro getLastNames is now simplified

```java
// PersonServiceTest.java

@Test
public void getLastNames_usingAnnotations() {
    when(repository.findAll()).thenReturn(people);

    assertThat(service.getLastNames())
        .contains("Borg", "Goldberg", "Hopper", "Liskov", "Lovelace"); verify(repository).findAll();
}
```

### Injecting the Mocks into the Class Under Test

One benefit of the annotation approach is that Mockito tries to inject the mocks into the class under test for you. How does it do that, exctly?:

1. Calls the largest contructor on the test class if takes teh right types of arguments.
2. Calls setters methods of the proper type (and the proper name if there is more than one for a given type).
3. Sets the fields directly.

Remember, Mockito is not a dependency injection frmaworks; don't expect this shorthand utility to inject a complex graph of objects, be it mocks/spies or real objects.

## Setting Expectations

The Mockito-based example that mocked the PersonRepository and PersonService used the methods _when_ and _thenReturn_ to set the expectation on the _findAll_ method. Here's the signature for when:

```java
public static <T> OngoingStubbing<T> when(T methodCall)
```

The argument to _when_ is the declaration of an invocation of the method you want to call on the stub. The return type connect to the various _then_ methods, like _thenReturn_, _thenThrow_, or _thenAnswer_, which are normally chained to the output.

There are a couple of overloads of the _thenReturn_ method:

```java
OngoingStubbing<T> thenReturn(T value)
OngoingStubbing<T> thenReturn(T value, T... values)

```
