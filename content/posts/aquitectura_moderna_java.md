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

## Aspectos más allá de las vistas
* Existen varios elementos adicionales que son importantes para documentar adecuadamente la arquitectura de un sistem:
    - Tácticas y desiciones de diseño
    - Requisitos de calidad
    - Contexto arquitectónico
    - Patrones arquitectónicos
    - Evolución de la arquitectura
    - Restricciones arquitectóicas
    - Consideraciones de seguridad
    - Riesgos y mitigaciones

## Tácticas y decisiones de diseño
* _Propósito:_ Las desiciones arquitectónicas son las que determinan la estructura y comportamiento del sistema. Documentar las decisiones clave y las razones detrás de ellas permite que otros comprendan no solo que se hizo, sino por qué.
* _Contenido:_
    - _Justificación:_ Explicar las razones detrás de las elecciones arquitectónicas, como la eleccion de ciertos patrones, tecnologías o enfoques
    - _Alternativas:_ Describir las opciones que fueron consideradas pero no seleccionadas, así como las ventajas y desventajas de cada una.
    - _Implicaciones:_ Cómo estas decisiones impactan en la calidad de sistema, su escalabilidad, en rendimiento, seguridad, etc.
* _Ejemplo:_ Documentar por qué se eligió una arquitectura de microservicios en lugar de una monolitica y como esa elección afecta la escalabilidad y el mantenimiento del sistema a largo plazo

## Atribubtos de calidad
* _Proposito:_ Uno de los elementoa más importantes que influye en las decisiones arquitectónicas son los atributos de calidad del sistema. Estos atributos no siempre se ven directamente en las vistas de arquitectura, pero deben ser explícitamente documentados.
* _Contenido:_
    - Especificar los atributos de calidad más importantes para el sistema
    - Detallar cómo la arquitectura aborda esos atributos y qué decisiones se tomarin para optimizarlos
    - Documentar cualquier compensación o compromiso realizado para lograr ciertos atributos de calidad a expensas de otros
* _Ejemplo:_ En un sistema donde el rendimiento es crítico, se podría documentar cómo la arquitectura fue diseñada para minimizar la latencia, y qué decisiones se tomaron para balancear eso con la mantenibilidad del código

## Contexto arquitectónico
* _Proposito:_ Describe el entorno en que opera el sistema y cómo interactúa con otros sistemas o entidades externas. Es fundamental entender las dependencias externas del sistema y las interfaces con las que debe interactuar
* _Contenido:_
    - Definir los sistema externo con los que interactúa el sistema
    - Describir los protocolos, APIs o interfaces utilizadas
    - Explicar las limitaciones o dependencias que resultan de estas interacciones
* _Ejemplo:_ Si un sistema depende de una API externa para recibir datos en tiempo real, la documentación debe describir esa dependencia, los mecanismos de comunicación y cualquier implicación en caso de fallo de esa API

## Patrones arquitectonicos
* _Proposito:_ Los patrones arquitectonicos son soluciones probadas a problemas comunes en el diseño de sistemas. Documentar los patrones utilizados proporciona a otros desarrolladores y arquitectos una vision mas clara de las decisiones estructurales generales del sistema.
* _Contenido:_
    - Describir los patrones arquitectonicos utilziados, como MVC, microservicios, arquitectura en capas, entre otros.
    - Explicar por que se selecciono un patron en particular y como se implementa en el sistema
* _Ejemplo:_ Documentar el uso de un patron de eventos y comandos (CQRS) en un sistema donde se requiere operaciones intensivas de lectura y explicar como se mejora el rendimiento en esas areas.

## Evolución de la arquitectura
* _Proposito:_ Las arquitecturas de software suelen evolucionar con el tiempo, y es importante documentar como han cambiado o se espera que cambien a medida que el sistema crece o se adapta a nuevas necesidades.
* _Contenido:_
    - Documentar los cambios importantes en la arquitectura a lo largo del tiempo
    - Explicar las razones detras de estos cambios
    - Describir el impacto de estos cambios en la calidad del sistema y en las futuras desiciones.
* _Ejemplo:_ Un sistema que comienza como monolitico y luego migra a una arquitectura de microservicios debe documentar como y por que hizo esa transicion

## Restricciones arquitetónicas
* _Proposito:_ En cualquier proyecto de software, existen restricciones que limitan las opciones arquitectonicas. Estas pueden provenir de requisitos de negocio, limitaciones tecnicas o necesidades especificas del cliente.
* _Contenido:_
    - Documentar las restricciones impuestas en el diseño, ya sea por limitaciones de hardware, presupuesto, plazos o regulaciones.
    - Explicar como esas restricciones influyeron en las decisiones de diseño
* _Ejemplo:_ Si una aplicacion debe funcionar en dispositivos con recursos limitados, las restricciones de rendimiento y memoria se conviertan en factores clave que influiran en la Arquitectura

## Consideraciones de seguridad
* _Proposito:_ En michos sistemas, la seguridad es un atributo fundamental. Es importante documentar como la arquitectura aborda los problemas de seguridad y como protege el sistem frente a amenazas
* _Contenido:_
    - Identificar las amenzas de seguidad mas importantes que enfrenta el sistema
    - Describir las contramedidas arquitectonicas implementadas para mitigar esas amenazas
    - Explicar las decisiones tomadas para equilibrar la seguridad con otros atributos del sistema, como el rendimiento o la facilidad de uso
* _Ejemplo:_ Documentar el uso de cifrado extremo a extremo para proteger la informacion sensible durante la transmision, y los mecanismo de autenticacion y autorizacion utilizados en el sistema

## Riesgos y mitigaciones
* _Proposito:_ Toda arquitectura conlleva riesgos, ya sean tecnicos, financieros o relacionados con la implementacion. Es importante documentar los riesgos identificados y como se planea mitigarlos
* _Contenido:_
    - Identificar los riesgos arquitectonicos mas importantes
    - Describir las estrategias utilizadas para mitigar esos riesgos
    - Explicar los posibles impactos si los riesgos no se mitigan adecuadamente
* _Ejemplo:_ En un sistema distribuido, los riesgos de fallos en la comunicación entre microservicios pueden ser mitigados con el uso de circuit breakers y politicas de reintento

## Mas alla de las vistas Conclusión
* La documentacion de arquitectura no solo debe enfocarse en mostrar las estructuras y relaciones del sistema a traves de diferentes vistas
* Tambien debe proporcionar un contexto mas profundo sobre las decisiones arquitectonicas, los atributos de calidad, las retricciones y otros factores importantes
* Esto permite que la documentacion sea mas rica y util a lo largo del ciclo de la vida del sistema, ayudando a los equipos a comprender mejor el "por que" detras de la arquitectura y no solo el "que"

## Documentación de estilos arquitectónicos
* Es fundamental que este adecuadamente documentado el estilo o estilos elegidos para asegurar que todos los involucrados en el proyecto comprendan la estructura y las interacciones del sistema
* Esto incluye no solo la descripcion de los componentes y sus relaciones, si no tambien los principios y las decisiones clave que motivaron la eleccion del estilo

