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
