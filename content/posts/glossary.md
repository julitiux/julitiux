---
title: "Glossary"
date: 2025-09-16T22:21:32-06:00
draft: false
---


# Glossary

## var
var es una palabra reservada que fue introducida en Java 10 que nos va a permitir inferir el tipo de la variable en tiempo de compilacion, no en ejecucion.

## Constante
Una constante es un valor que no va a cambiar durante la ejecucion del programa. Para tener un constante en Java:
* No puede tener una reasignacion
* Debe pertenecer a la clase
* Tiene que ser _public_
* Tiene que ser _static_
* La variable debe ser _final_

## Enum
Un Enum es una clase especial que nos va a permitir tener valores fijos y limitados que van a ser tratados como constantes.

## Cuando usar el Scope Singleton
En Spring, _Singleton_ es el scope por defecto. Cuando el estado del objeto o la informacion del usuario no se esta guardando en la instancia, solo se usara pura logica de negocio; por ejemplo los servicios, daos, repositorios, donde el estado de datos se guarda en base de datos. Spring recomienda utilizar el scope _Singleton_ en el 90% de los escenarios, de otra forma si se guarde el estado en la instancia y es unico se usara _Prototype_. Quiere decir que Spring crea una sola instancia del bean dentro del contenedor de IoC (Inversion of Control)

## Cuando usar el Scope Prototype
Se utiliza cuando el estado de nuestro objeto no se puede compartir en un ambiente multihilo, tiene que se unico en todo el aplicativo. Un servicio que genera codigo OTP, passwords unicos para cada usuario.

> Un OTP (One-Time Password) es una contraseña de un solo uso que se genera para validar la identidad de un usuario en un sistema

## Cual es la diferencia entre un _Error_ y una _Exception_
Una exception representa un situacion anormal que sucede en timepo de ejecucion por ejemplo un error de SQL que puede ser un SQLException, un error de null que puede ser NullPointerException, un FileNotFoundException; pero te puedes recuperar de estas situaciones anormales con un try/catch.
El Error representa una situacion grave que ocurre en la maquina virtual de la que no nos podemos recuperar, no es conveniente capturarla en un try/catch ya que representa situaciones graves como falta de memoria que es un ArrowMemoryError o un StackOverflowError que sucede cuando tenemos llamadas recursivas.

## Cual es la diferencia entre un _Bean_ y un _Component_
Ambos van a crear objetos y los van a guardar en el contenedor de Spring para ser utilizados cuando sean requeridos pero la forma de registrarlos es distinta.
* Para la anotacion _Bean_ siempre se tienen que crear con metodos, donde el tipo de retorno va a ser el tipo de la instancia que se va a crear.
* Los _Beans_ tienen que estar en una clase de _Configuration_; por ejemplo usando las anotaciones _@SpringBootApplication_ o _@Configuration_
* Los _Beans_ se usan para librerias externas, para clases que no tenemos explicitamente en el proyecto; WebMvcConfigurer, es una clase de SpringFramework, no es una clase nuestra.
Los componentes se utilizan para nuestas clases y la forma de registrarlo es que Spring va a escanear, crear y guardar el objeto en el contenedor de Spring, pero se utiliza para mayormente clases nuestas

## Que es un DTO
Un DTO es un Data Transfer Object que te va ayudar a transportar informacion a lo largo de las placas de la aplicacion, estas capas son el controlador, la capa de servico y la persistencia.

## Que es un Pojo
Es una clase plana que no tiene logica de negocio.

## Spring vs Spring Boot
La diferencia principal entre Spring y SpringBoot es que Spring es el dramework base, toda configuracion es de forma manual y requiere mucho trabajo de configuracion; por otro lado SpringBoot es un todo listo para utilizarse, tiene configuraciones automaticas, un servidor embebido, desarrollas mas rapido y es menos codigo.

## Que es un controllador
Es una clase que va a interceptar y aceptar peticiones del lado del cliente, un controlador habla HTTP; acepta la peticion, la procesa y la manda del lado del servicio, el servicio la regresa al controlador y el controlador la regresa en formato JSON, XML, HTML, texto incluso imagen.

## Como declarar un Singleton
```java
public class SingletonClient {                       // 1.- Declarar la clase que queremos hacer Singleton

    private static SingletonClient singleton;        // 2.- Declarar una variable del mismo tipo que la clase, private y static

    private SingletonClient() {                      // 3.- Declarar un contructor private
    }                                                //     Tareas y procesos en el contructor

    public static SingletonClient getInstance() {    // 4.- Declarar un metodo para devolver la instancia
        if(singleton == null) {                      // 5.- Si el objeto no existe vamos a crearlo
            singleton = new SingletonClient();
        }
        return singleton;                            // 6.- Si el objeto ya existe, vamos a regresarlo
    }
}
```

## Cual es la capa mas importante de tu aplicativo
La capa mas importante es la capa del Service; por que en el Service estan las validaciones, las reglas de negocio, la interaccion con otras capas, la interacion con la persistencia y con repositorios que es donde se van a guardar todos los datos, la informacion en base de datos. El Service procesa toda esta informacion, la devuelve al controlador y el controlador se la devuelve al cliente. El cliente puede ser una aplicacion movil, una plataforma web, inclusive postman.

## Que es un Record
Un Record es la forma concisa e inmutable de crear clases Java que solamente van almacenar informacion, no puede ser modificada. Nos ahorrara los Getters, Setters, HashCode e Equals

## SOLID
### S - Single Responsability Principle
Cada clase debe tener una sola responsabilidad

Mal:
´´´java
class UserService {
    void saveUser() {}
    void sendMail() {}
}
´´´
Bien:
´´´java
class UserService {
    void saveUser() {}
}

class EmailService {
    void sendMail() {}
}
´´´

### O - Abieto-Cerrado
Una clase debe estar abierta a la extension, pero cerrada a la modificacion.

Mal
´´´java
if(type.equals("CARD")) {}
if(type.equals("PAYPAL")) {}
´´´
Bien
´´´java
interface Payment {
    void pay();
}

class CardPayment implements Payment {}
class PaypalPayment implements Payment {}
´´´

### L - Sustitucion de Liskov
Los objetos de una subclase deben poder reemplazar a los objetos de su superclase sin alterar el programa.

Mal
´´´java
class Bird {
    void fly() {}
}

class Penguin extends Bird {
    void fly() { throw new Exception(); }
}
´´´

Bien
´´´java
interface Bird {}

interface FlyingBird extends Bird {
    void fly();
}

´´´

### I - Segregacion de interfaces
Evita las interfaces grandes, pues pueden forzar la implementacion de metodos innecesarios

Mal
´´´java
interface Worker {
    void work();
    void eat();
}
´´´
Bien
´´´java
interface Workable {
    void work();
}

interface Eatable {
    void eat();
}
´´´

### D - Inversion de dependencias
Los modulos de alto nivel no deben depender de los de bajo nivel sino que ambos deben depender de abstracciones

Mal
´´´java
class OrderService {
    private MySQLDatabase db = new MySQLDatabase();
}
´´´
Bien
´´´java
class OrderService {
    private final Database db;

    OrderService(Database db) {
        this.db = db;
    }
}
´´´

## Encapsulamiento
El encapsulamiento protege los datos de una clase y permite controlar como se accede y modifican. En Java se logra usando modificadores de acceso como _private_, _public_ y protected.
De esta forma se evita modificaciones incorrectas, por ejemplo, que desde otra clase se pueda modificar el id de un usuario. Otras clases pueden acceder al dato si es necesario, pero no deberian poder modificarlo.
El encapsulamiento hace que el codigo sea mas seguro y mantenible

## Herencia
La herencia permite que una clase herede atributos y metodos de otra.
* La clase que hereda se llama clase hija o subclase
* La clase de la cual se hereda se llama clase padre o superclase
Este enfoque favorece la reutilizacion de codigo y permite establecer relaciones jerarquicas entre las clases.

# Hackerrank

