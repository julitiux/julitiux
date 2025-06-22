---
title: "Aquitectura Moderna de Java"
date: 2025-06-11T17:48:08-06:00
draft: false
---

# Modulo 1
* Introduccion a la Arquitectura de Software
    - Entender que es la arquitectura de software
    - Conocer los principios fundamentales
    - Diferenciar tipos comunes de arquitectura
    - Ver como se aplican en proyectos modernos

## Documentación basada en vistas
* _Vista Lógica;_ Muestra los componentes principales del sistema y sus relaciones.
* _Vista de desarrollo:_ Detalla la organización del sistema desde el punto de vista del desarrollo, cómo están estructurados los módulos.
* _Vista de procesos:_ Explica cómo interactúan los componentes en tiempo de ejecución.
* _Vista física:_ Muestra la topología de los componentes del sistema en el hadware.

## Vista Lógica
* _Proposito:_ La vista lógica muestra la estructura del sistema desde el punto de vista de los componentes de software principales y sus relaciones. Es útil para capturar el diseño de alto nivel del sistema.
* _Pregunta clave:_
    - ¿Cuáles son los componentes más importantes?
    - ¿Cómo interactúan entre si?
* _Audiencia:_ Principalmente desarrolladores y arquitectos de software, ya que les ayuda a entender cómo se descompone el sistema en apartes manejables y cómo estas partes colaboran entre si.

* _Ejemplo:_ Un diagrama UML de clases que muestran módulos, clases, funciones, y sus relaciones. Podría usarse un diagrama de componentes a alto nivel.

## Vista de Desarrollo (Vista de Implementación)
* _Proposito:_ Esta vista describe la organizacion estática del sistema desde el punto de vista del equipo de desarrollo. Muestra como el código fuente está estructurado en paquetes, módulos o capas.
* _Pregunta clave:_
    - ¿Cómo se organiza el sistema a nivel de código?
    - ¿Cómo están estructurados los módulos?
    - ¿Qué equipos o personas son responsables de qué partes del sistema?
* _Audiencia:_ Desarrolladores que necesitan entender cómo está organizado el sistema para trabajar en él y contribuir de manera efectiva
* _Ejemplo:_ Diagramas de paquetes o estructura de carpetas y archivos en el código fuente.

## Vista de Procesos
* _Proposito:_ Se enfoca en la interaccion dinámica de los componentes del sistema en tiempo de ejecución. Muestra cómo los diferentes componentes interactúan a través de procesos, hilos y mensajes
* _Pregunta clave:_
    - ¿Cómo interactúan los componentes del sistema en tiempo de ejecución?
    - ¿Qué procesos se ejecutan en paralelo o secuencialmente?
* _Audiencia:_ Arquitectos y desarrolladores interesados en cómo funciona el sistem en ejecución, especialmente para comprender problemas como el rendimiento y la escalabilidad
* _Ejemplo:_ Diagramas de secuencia o diagramas de actividad que muestren flujos de control y colaboración entre los componentes en tiempo de ejecución

## Vista Física (Vista de Despliegue)
* _Proposito:_ Representa la topologia de hardware donde se ejecuta el sistema. Esta vista describe cómo se mapean los componentes de software a los nodos físicos de la red (servidores, máquinas virtuales, etc)
* _Pregunta clave:_
    - ¿Dónde se ejecuta cada parte del sistema?
    - ¿Cómo se distribuye el software en el hardware?
    - ¿Que nodos, servidores o contenedores están involucrados en la ejecución del sistema?
* _Audiencia:_ Ingenieros de infraestructura, administradores de sistema y arquitectos responsables del despliegue físico del Software
* _Ejemplo:_ Diagramas de despliegue que muestran servidores, redes, dispositivos y como los componentes de software están destribuidos entre ellos

## Relación entre vistas.
* La vista no son independientes entre si, De hecho, las vistas debes estar relacionadas y se consistenes entre si. Por ejemplo:
    - Un componente descrito en la vista lógica debe estar reflejado de alguna manera en la vista de desarrollo (como un modulo o paquete).
    - Los procesos descritos en la vista de procesos deben ejecutarse en los nodos descritos en la vista física.
* Cada vista captura una parte de la arquitectura del sistema, y juntas proporcionan una imagen mas completa del sistema en conjunto.

## Personalización de vistas
* Debe existir flexibilidad en cuanto a la creacion de vistas adicionales si el sistema lo requiere.
Por ejemplo:
    - _Vista de serguridad:_ Para sistemas que deben abordar requisitos de seguidad avanzados.
    - _Vista de rendimiento:_ Si el rendimiento es una preocupación clave, se podría incluir una vista que muestre cómo las decisiones arquitetónicas afectan este atributo.

## Beneficios del enfoque basado en vistas
* _Claridad:_ Descomponer el sistema en diferentes vistas ficilita la compresión de la arquitectura por parte de diferentes grupos de interés. Cada vista aborda preocupaciones espcificas y es legible para una audiencia particular.
* _Modularidad:_ Permite a los equipos trabajar en diferentes partes de la arquitectura sin perder de vista el panorama completo.
* _Facilita la comunicación:_ Las vistas proporcionan un lenguaje común

## Documentación basada en vistas: Conclusión
* En el enfoque basado en vistas propuesto en "Documenting Software Architecture" es una forma eficaz de documentar arquitecturas complejas.
* Al dividir la arquitectura en varias vistas, es posible abordar diferentes preocupaciones de los interesados y crear una documentación que sea útil para todo equipo, desde desarrolladores hasta administradores de sistemas.

