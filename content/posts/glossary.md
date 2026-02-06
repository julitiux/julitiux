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

## Polimorfismo
El polimorfismo permite que un mismo metodo tenga distintos comportamientos segun el objeto que lo ejecute. Es decir, una misma accion puede realizarse de diferentes formaa.
Ejemplo: una persona hispanohablante saluda diciendo "hola" mientras que otra de lengua inglesa saluda diciendo "Hello".
En programacion esto se logra mediante la sobreescritura de metodos (@Override) la clase padre o la interface defina un metodo y la clase hila lo implementan segun su propio comportamiento.
Esto permite un codigo mas flexible y facilita la extension del sistema sin modificar el codigo existente.

## Abstraccion
La abstraccion permite ocultar la implementacion interna y mostrar solo lo esencial del comportamiento de un objeto
Se logra mediante clases _abstractas_ e _interfaces_, que definen que metodos deben existsir, pero no como se implementan.
De esta manera, las clases hijas pueden utilizar esos metodos sin conocer su funcionamiento interno, lo que reduce la complejidad del codigo
Ademas, la logica comun se centraliza en la clase abstracta o en la interfaz, faiclitando el mantenimiento. Si se realiza una mejora o correccion, todas las clases hijas se benefician automaticamente, sin necesidad de modificarlas una por una.

# Hackerrank

## Java Loops II
We use the integers a,b and n to create the following series:
(a + 2^0 * b),(a + 2^0 * b + 2^1 * b),...,(a + 2^0 * b + 2^1 * b + ... + 2^n-1 * b)
You are given q queries in the form of a, b and n. For each query, print the series corresponding to the given a,b and n values as a single line of n space-separated integers

### Input format
The first line contains an integer q, detoning the number of queries.
Each line i of the q subsequents lines contains three space-separated integers describing the respective ai, bi, and ni values for that query.

### Constraints
0 <= q <= 500
0 <= a,b <= 50
1 <= n <= 15

### Output format
For each query, print the corresponding series on a new linem Each series must be printed in order as a single line of n space-separated integers.

### Sample Input
´´´
2
0 2 10
5 3 5
´´´

### Sample Output
´´´
2 6 14 30 62 126 254 510 1022 2046
8 14 26 50 98
´´´

### Code
´´´java
import java.util.*;
import java.io.*;

class Solution{
    public static void main(String []argh) {
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<=t;i++) {

            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();

            int result = a;
            int power = 1;

            for(int j = 0; j < n ; j++) {
                result += b * power;
                System.out.print(result + " ");
                power *= 2;
            }
            System.out.println();
        }
        in.close();
    }
}
´´´
## Java Datatypes
Java has 8 primitive date types: char, boolean, byte, shot, int, long, float and double. For this exercise, we'll work with the primitives used to hold integer values (byte, short, int and long):

* A byte is an 8-bit signed integer.
* A short is a 16-bit signed integer.
* An int is a 32-bit signed integer.
* A long is a 64-bit signed integer.

Given a input integer, you most determine which primitive data types are capable of property storing that input.
To get you started, a portion of the solution is provided for you in the editor.

### Reference
https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html

### Input format
The first line contains an integer _T_. denoting the number of test cases. Each test case, _T_, is comprised of a single line with an integer, _n_, which can be arbitrarily large or small

### Output format
For each input variable _n_ and appropriate primitive _dataType_. you must determine if the given primitives are capable of storing it, if yes, then print:

´´´terminal
n can be fitted in:
* datatype
´´´

If there is more than one appropriate data type, print each one on its own line and order them by size (i.e.: _byte_ < _short_ < _int_ < _long_)
If the number cannot be stored in one of the four aforementioned primitives, print the line:

´´´terminal
n can't be fitted anywhere.
´´´

### Sample Input
´´´terminal
5
-150
150000
1500000000
213333333333333333333333333333333333
-100000000000000
´´´

### Sample Output
´´´terminal
-150 can be fitted in:
* short
* int
* long
150000 can be fitted in:
* int
* long
1500000000 can be fitted in:
* int
* long
213333333333333333333333333333333333 can't be fitted anywhere.
-100000000000000 can be fitted in:
* long
´´´

### Code
´´´java
import java.util.*;
import java.io.*;

class Solution{
    public static void main(String []argh)
    {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();

        for(int i=0;i<t;i++)
        {
            try
            {
                long x=sc.nextLong();
                System.out.println(x+" can be fitted in:");
                if(x>=-128 && x<=127)System.out.println("* byte");
                if(x>=-32768 && x<=32767)System.out.println("* short");
                if(x>= Integer.MIN_VALUE && x<=Integer.MAX_VALUE)System.out.println("* int");
                if(x>= Long.MIN_VALUE && x<=Long.MAX_VALUE)System.out.println("* long");
            }
            catch(Exception e)
            {
                System.out.println(sc.next()+" can't be fitted anywhere.");
            }
        }
    }
}
´´´

## Java End-of-file
"In computing, End Of Line (commonly abbreviated EOF) is a condition in a computer operation system where no more data can be read from a data source"
The challenge here is to read _n_ lines of input until you reach EOF, the number and print all _n_ lines of content.

*Hint:* Java's Scanner.hasNext() method is helpful for this problem.

### Input Format
Read some unknown _n_ lines of input from stdin(System.in) until you reach EOF: each line of input contains a non-empty String.

### Output Format
For each line, print the line number, followed by a single space, and then the line content received as input

### Sample Input
´´´terminal
Hello world
I am a file
Read me until end-of-file.
´´´

### Sample Output
´´´terminal
1 Hello world
2 I am a file
3 Read me until end-of-file.
´´´

### Code
´´´java
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int lineNumber = 1;

        while(sc.hasNext()){
            System.out.println(lineNumber + " " + sc.nextLine());
            lineNumber++;
        }
    }
}
´´´

## Java Static Initializer Block
Static Initialization blocks are executed when the class is loaded, and you can initialize static variables in those blocks
It's time to test you knowledge of Static Initialization blocks.
You are given a class Solution with a main method. Complete the given code so that it outputs the are of a parallelogram with breath _B_ and height _H_. You should read the variables from the standard Input
If _B_ <= 0 or _H_ <= 0, the output should be "java.lang.Exception: Breagth and height must be positive" whithout quotes

### Input Format
There are two lines of input. The first line contains _B_: the breadth of the parallelogram. The next, line contains _H_: the height of the parallelogram

### Constraints

* -100 <= _B_ <= 100
* -100 <= _H_ <= 100

### Output Format

If both values are greater than zero, then the main method must output the area of the parallelogram. Otherwise, print "java.lang.Exception: Breadth and height must be positive" whithout quotes

### Sample Input 1
´´´terminal
1
3
´´´

### Sample Output
´´´terminal
e
´´´

### Sample Input 2
´´´terminal
-1
2
´´´

### Sample Output 2
´´´terminal
java.lang.Exception: Breadth and height must be positive
´´´

### Code
´´´java
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int B;
    static int H;
    static boolean flag = true;

    static{

        Scanner sc = new Scanner(System.in);
        B = sc.nextInt();
        H = sc.nextInt();
        if(B < 0 || H < 0){
            flag = false;
            System.out.println("java.lang.Exception: Breadth and height must be positive");
        }
    }

public static void main(String[] args){
        if(flag){
            int area=B*H;
            System.out.print(area);
        }

    }//end of main

}//end of class
´´´
