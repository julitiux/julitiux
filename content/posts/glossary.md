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
Cuando el estado del objeto o la informacion del usuario no se esta guardando en la instancia, solo se usara pura logica de negocio; por ejemplo los servicios, daos, repositorios, donde el estado de datos se guarda en base de datos. Spring recomienda utilizar el scope _Singleton_ en el 90% de los escenarios, de otra forma si se guarde el estado en la instancia y es unico se usara _Prototype_.

## Cuando usar el Scope Prototype
Se utiliza cuando el estado de nuestro objeto no se puede compartir en un ambiente multihilo, tiene que se unico en todo el aplicativo. Un servicio que genera codigo OTP, passwords unicos para cada usuario.

