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

## Componetes clave al documentar
* Descrpcion del estilo
* Estructura del sistema basada en el estilo
* Patrones de comunicación
* Razonamiento detras de la eleccion del estilo
* Limitaciones del estilo
* Adaptaciones o personalizaciones del estilo
* Patrones comunes asociados al estilo
* Consideraciones de calidad para el estilo

## Descripcion del estilo
* _Proposito:_ Explicar las caracteristicas del estilo, los tipos de sistemas para los que es mas adecuado y los problemas que aborda
* _Contenido:_
    - Definicion general del estilo
    - Principales caracteristicas del estilo
    - Ejemplos de sistemas que utilizan este estilo
* _Ejemplo:_ Para una arquitectura en capas, se describe como el sistema se organiza en capas (capa de presentacion, capa logica, capa de datos) y como las capas interactúan entre si

## Estructura del sistema bada en el estilo
* _Proposito:_ Definir la estructura concreta del sistema de acuerdo con ese estilo. Esto implica documentar los componentes principales, sus responsabilidades y como interactúan
* _Contenido:_
    - Componetes principales del sistema
    - Conexiones y relaciones entre esos componentes
    - Responsabilidades de cada componente dentro de la estructura del sistema
* _Ejemplo:_ En una arquitectura de microservicios, se documentan las microservicios individuales, como interactuan a traves de APIs, y como se gestionan aspectos como el descubrimiento de servicios y la orquestacion

## Patrones de comunicación
* _Proposito:_ Cada estilo arquitectonico tiene un conjunto de patrones de comunicación de define como los componentes interactuan entre si. Documentar estos patrones es crucial para comprender como los datos y las solicitudes fluyen a traves del sistema
* _Contenido_
    - Patrones de comunicación principales, como solicitudes sincronas, asincronia, mensajeria bada en eventos
    - Tecnologias o protocolos utilizados para facilitar la comunicacion (HTTP, REST, gRPC, etc)
* _Ejemplo:_ En una arquitectura orientada a eventos, se documenta como los eventos se publican y suscriben en un bus de eventosm y como los diferentes servicios reaccionan a esos eventos. OpenAPI, AsyncAPI

## Razonamiento detras de la eleccion del estilo
* _Proposito:_ Es fundamental documentar las razones por las cuales se eligio un estilo arquitectonico especifico. Esto proporciona contexto para las decisiones tomadas ya ayuda a futuros arquitectos y desarrolladores a entender por que el sistem es estructurado de esa manera.
* _Contenido:_
    - Ventajas del estilo arquitectonico elegido en comparacion con otras alternatitvas
    - Requisitos del sistema que llevaron a elegir ese estilo
    - Descripcion de los problemas que resuelve el estilo seleccionado
* _Ejemplo:_ Si se eligio una arquitectura de microservicios, se puede explicar que flexibilidad para escalar individualmente los componentes del sistema fue clave para satisfacer los requisitos de escalabilidad del negocio

## Limitaciones del estilo
* _Proposito:_ Ningun estilo arquitectonico es perfecto para todos los casos. Cada uno tiene limitaciones que es importante decumentar para que los equipos comprendan los desafios potenciales a los que se enfrentanran al adoptar un estilo especifico
* _Contenido:_
    - Restricciones inherentes al estilo arquitectonico
    - Desventajas o desafios tecnicos
    - Situaciones en las que el estilo podria no ser adecuado
* _Ejemplo:_ Para una arquitectura monolitica, las limitaciones decumentadas podrian incluir la dificultad para escalar horizontalmente y los problemas relacionados con el despliegue de grandes bases de codigo

## Adaptaciones o personalizaciones del estilo
* _Proposito:_ En algunos casos, un estilo arquitectonico necesita ser adaptado o personalizado para ajustarse mejor a los requisitos especificos del sistema. Documentar estas adaptaciones es esencial para que otros puedan entender como y por que se ha modificado el estilo
* _Contenido:_
    - Explicacion de las personalizaciones o modificaciones al estilo estandar
    - Justificacion para esas personalizaciones
    - Como las adaptaciones impactan la arquitectura general del sistema
* _Ejemplo:_ En una arquitectura orientada a eventos, podria ser necesario personalizar el mecanismo de enrutamiento de eventos para ajustarse a requisitos espcificos de latencia o seguridad

## Patrones comunes asociados al estilo
* _Proposito:_ Muchos estilos arquitectonicos se asocian comunmente con ciertos patrones de diseño. Documentar estos patrones es importante para que los desarrolladores puedan aplicarlos de manera consistente en el sistema
* _Contenido:_
    - Patrones de diseño tipico asociados con el estilo arquitectonico
    - Ejemplos de como se implementan estos patrones en el sistema
* _Ejemplo:_ En una arquitectura en capas, los patrones tipicos incluyen el patron de "DAO" (Data Access Object) para la interaccion con la base de datos, o el patron "MVC" (Modelo Vista Controlador) en la capa de presentacion

## Consideraciones de calidad para el estilo
* _Proposito:_ Cada estilo arquitectonico tiene diferentes implicaciones para los atributos de calidad del sistema, como rendimiento, escalabilidad, mantenibilidad, etc. Documentar como el estilo afecta estos atributos ayuda a garantizar que el sistema cumpla con los requisitos de calidad.
* _Contenido:_
    - Impacto del estilo en los atributos de calidad, como seguridad, escalabilidad, rendimiento, etc
    - Compromisos entre diferentes atributos de calidad que resultan del estilo arquitectonico
* _Ejemplo:_ En una arquitectura de microservicios, se podrian documentar como la escalabilidad horizontal es mejoradam pero a costa de una mayor complejidad operativa y sobrecarga en la comunicacion (latencia)

## Aspectos clave de la Documentación
* Conocer a la audiencia
* Usar un lenguaje claro y conciso
* Estructura coherente
* Incluir diagramas visuales
* Mantener la documentación actualizada
* Proporcionar referencias cruzadas
* Documentar las decisiones clave de diseño
* Especificar los atributos de calidad del sistema
* Evitar la redundancia innecesaria

## Conoce a tu audiencia
* _Proposito:_ La documentación de arquitectura es leida por una audiencia diversa que incluye desarrolladores, arquitectos, gerentes, partes interesadas no tecnicas e incluso clientes. Por lo tanto es esencial adaptar la escritura a las necesidades y el nivel de compresion de cada grupo
* _Recomendaciones:_
    - Identificar claramente quien sera el lector de cada parte de la documentación
    - Proporcionar diferentes niveles de detalle segun el tipo de audiencia: por ejemplo, altos niveles de abstraccion para gerentes o clientes, y detalles tecnicos profundos para desarrolladores y arquitectos
* _Ejemplo:_ Un diagrama de alto nivel de la arquitectura para un cliente que no este familiarizado con los detalles tecnicos puede ser suficiente para explicar como interactúan los componentes principales del sistema. Sin embargo, los desarrolladores necesitaran diagramas mas detallados con descripciones precisas de los modulos y como interactúan

## Usa un lenguaje claro u conciso
* _Proposito:_ La claridad es crucial en la documentación de arquitectura para evitar malentendidos. Un lengiaje impreciso o ambiguo puede generar confusion entre los lectores, lo que podria llevar a errores en la implementacion
* _Recomendaciones:_
    - Evitar jergas tecnicas innecesarias o complejidad excesiva, especialmente cuando no son necesarias para la comprension del concepto
    - Ser directo en la explicacion de conceptos, evitando palabras o frases vagas
    - Utilizar listas y tablas cuando sea apropiado para desglosar informacion compleja
* _Ejemplo:_ En lugar de escribir "este componente maneja varias tareas importantes", se puede ser mas perciso con "este componente procesa solicitudes de autenticacion de usuarios y consultas de base de datos"

## Estructura coherente
* _Proposito:_ Una buena estructura facilita que los lectores encuentren la informacion que necesitan. La organizacion logica de la documentacion ayuda a que esta sea mas accesible y facilita el mantenimiento a largo plazo
* _Recomendacion:_
    - Seguir un esquema de organizacion claro y consistente en todos los documentos
    - Incluir una tabla de contenidos que permita a los lectores navegar facilmente por la documentacion
    - Separar las secciones en bloques logicos, como introduccion, vistas arquitectonicas, decisiones clave, etc
    - Usar encabezados y subencabezados descriptivos que reflejen el contenido de cada seccion
* _Ejemplo:_ Una buena estructura prodria empezar con una vision general de alto nivel, seguida de vistas especificas (logica, de desarrollo, de despliegue), y luego profundizar en las decisiones clave de diseño, patrones y tacticas utilizadas

## Incluye diagramas visuales
* _Proposito:_ Los diagramas y representaciones graficas ayudan a ilustrar conceptos arquitectonicos complejos de manera mas clara que solo texto. Los diagramas permiten a los lectores visualizar las interacciones entre los componentes del sistema y como se organiza la arquitectura
* _Recomendaciones:_
    - Usar diagramas consistentes, como diagramas de clase UML, diagramas de componentes o diagramas de despliegue, para ilustrar estructuras y relaciones
    - Asegurarse de que los diagramas esten actualizados y alineados con las descripciones contextuales
    - Proporcionar explicaciones textuales para cada diagrama, aclarando el contexto y los detalles clave
* _Ejemplo:_ Incluir un diagrama de componentes que muestre como interactuan los microservicios en un sistema basado en microservicios, complementando con descripciones textuales de las responsabilidades de cada microservicios

## Mantener la documentacion actualizada
* _Proposito:_ La documentacion arquitectonica pierde valor si no se mantiene actualizada con respecto a los cambios en el sistema. A medida que el sistema evoluciona, la documentancion debe reflejar las nuevas decisiones arquitectonicas, los cambios en los componentes y cualquier evolucion en la estructura general
* _Recomendacion:_
    - Definir procesos para la revision y actualizacion regular de la documentacion, especialmente despues de cambios, importantes en la arquitectura
    - Asegurarse de que la documentación este alineada con el codigo actual, para evitar que los desarrolladores trabajen con informacion obsoleta
    - Utilizar sistemas de control de versiones para la documentacion, similar a como se gestionan los cambios en el codigo
* _Ejemplo:_ Si un nuevo microservicio se añade al sistema, la documentación debe ser actualizada para incluir ese microservicio y explicar su funcion y como interactua con el resto del sistema

## Proporciona referencias cruzadas
* _Proposito:_ Dado que la documentacion arquitectonica cubre diferentes vistas y aspectos del sistema, es importante proporcionar referencias cruzadas entre las secciones para facilitar la navegacion y la compresion
* _Recomendaciones:_
    - Incluir enlaces o referencias entre diferentes partes de la documentacion, como entre una vista logica y la vista de desarrollo, para que los lectores puedan conectar conceptos relacionados
* _Ejemplo:_ Si se describe un componente en la vista logica, se puede proporcionar un enlace a la vista de desarrollo que muestra como se implementa ese componente en el codigo fuente

## Documenta las decisiones clave de diseño
* _Proposito:_ Las decisiones de diseño arquitectonico son criticas para comprender el por que detras de la arquitectura. Documentarlas de manera clara ayuda a los futuros desarrolladores y arquitectos a entender el contexto y las razones detras de la estructura actual del sistema
* _Recomendacion:_
    - Para cada decision importante, incluir detalled sobre la alternativa considerada, los pro y contras de cada opcion, y la razon final para la decision tomada
    - Incluir informacion sobre como estas decisiones afectan a los atributos de calidad del sistema (rendimiento, escalabilidad, etc)
* _Ejemplo:_ Si se decide utilizar una arquitectura basada en eventos en lugar de una arquitectura monolitica, documentar por que esta decision se tomo, que beneficio aporto y cuales fueron las limitaciones a considerar

## Especifica los atributos de calidad del sistema
* _Proposito:_ Los atributos de calidad, como el rendimiento, la escalabilidad, la seguridad y la mantenibilidad, son esenciales para la arquitectura de un sistema y debe ser documentado claramente
* _Recomendacion:_
    - Explicar como la arquitectura soporta los atributos de calidad clave
    - Documentar cualquier compensación o sacrificio que se haya hecho en el diseño para priorizar ciertos atributos de calidad sobre otros
* _Ejemplo:_ Si la arquitectura ha sido optimizada para escalabilidad, explicar como se logra esta escalabilidad, y si ha habido algun sacrificio en terminos de simplicidad o mantenibilidad

## Evita la redundancia innecesaria
* _Proposito:_ La documentacion de arquitectura debe ser clara y eficiente. evitando la repeticion innecesaria que puede hacerla mas dificil de leer y mantener. Sin embargo, es importante saber cuando la redundancia es util, como cuando se necesita proporcionar contecto o explicaciones clave en multiples lugares
* _Recomendacion:_
    - Evitar duplicar informacion que ya se haya explicado claramente en otra parte del documento, utilizando referencias cruzadas cuando sea posible
    - Repetir informacion solo cuando sea necesario para la claridad y la compresión en diferentes contexto
* _Ejemplo:_ En lugar de repetir la descripcion de un componente en varias vistas, incluir una referencia a la vista correspondiente donde ya se haya explicado

## Plantillas para la documentación
* Las plantillas son guias que estandarizan la manera en que se organiza la informacion en la documentacion. Usar plantillas ayuda a los arquitectos y equipos de desarrollo a asegurarse de que se cubren todos los aspectos relevantes de la arquitectura de manera clara y consistente
- Plantilla de vistas arquitectonicas
- Plantilla de decisiones arquitectonicas
- Plantilla de atributos de calidad
- Plantilla de riesgos y mitigaciones

## Plantillas de vistas arquitectonicas
* _Proposito:_ Estructura la documentacion de las diferentes vistas de la arquitectura, asegurando que cada vista este documentada de manera coherente
* _Contenido:_
    - Nombre de la vista: El nombre de la vista (por ejemplo, vista logica, vista de desarrollo)
    - Proposito de la vista: Descripcion del objetivo de la vista y las preguntas que responde
    - Elementos de la vista: Componente principales de la vista (modulos, servicios, nodos, etc)
    - Relaciones entre elementos: Descripcion de como interactuan los componentes dentro de la vistas
    - Diagramas: Diagramas que reprensentan visualmente la estructura o interaccion entre los componentes
    - Decision arquitectonica: Las decisiones clave que afectan la estructura de esa vista
    - Referencias cruzadas: Enlaces o referencias a otras vistas o decisiones arquitectonicas que afectan o complementan esta vista
* _Ejemplo:_ Para la vista de desarrollo, esta plantilla incluiria la estructura de modulos y como se organiza en paquetes o subsistemas, junto con un diagrama que muestre esa organización

## Plantilla de decisiones arquitectonicas
* _Proposito:_ Facilita la captura de las decisiones arquitectonicas clave, incluyendo las alternativas evaluadas, las razones para tomar una decision y su impacto en el sistema
* _Contenido:_
    - Titulo de la decision: Una descripcion concisa de la decision arquitectonica
    - Contexto: Explicacion del problema que llevo a la decision y su contexto en el sistema
    - Alternativas: Las diferentes opciones o enfoques que se consideraron
    - Decision final: La opcion elegida y por que se selecciono
    - Implicaciones: Los efectos de esta decision en otras partes del sistema, incluyendo posibles impactos en atributos de calidad (rendimiento, seguridad, escalabilidad, etc)
    - Estado: Si la decision esta aprobada, pendiente o en revision
    - Responsable: Quien tomo la decision o que es responsable de ella
* _Ejemplo:_ Una decision sobre si utilizar una arquitectura de microservicios o una monolitaca podria documentarse en esta plantilla, describiendo los pros y contras de cada enfoque y la Justificacion para elegir uno sobre el otro

## Plantillas de atributos de calidad
* _Proposito:_ Proporciona un formato estandarizado para documentar como la arquitectura satisface los atributos de calidad especificos, como la escalabilidad, rendimiento, seguidad, mantenibilidad, etc
* _Contenido:_
    - Descripcion del atributo de calidad: Explicacion del atributo de calidad especifico (por ejemplo, tiempo de respuesta o capacidad de recuperacion ante fallos)
    - Requisitos del sistem relacionados: Que requisitos especificos del sistema estan relacionados con este atributo
    - Decisiones arquitectonicas: Que decisiones de diseño apoyan la Implementaciónde este atributo de calidad
    - Impacto en otras partes del sistema: Como esta consideracion afecta a otros atributos o partes del sistema
    - Evidencia de cumplimiento: Pruebas o mecanismos implementados para asegurar que el sistema cumple con los requisitos de calidad establecidos
* _Ejemplo:_ Para el atributo de escalabilidad, la plantilla documentaria como se han implementado mecanismos para escalar componentes especificos, por ejemplo, mediante el uso de microservicios o una arquitectura de eventos

## Plantilla de riesgos y mitigaciones
* _Proposito:_ Ayuda a capturar y documentar los riesgos arquitectonicos y las estrategias utilizadas para mitigar dichos riesgos
* _Contenido:_
    - Descripcion del riesgo: Una explicacion del riesgo identificando en el diseño o la implementacion de la arquitectura
    - Impacto potencial: Cual seria el efecto si el riesgo se materializa (por ejemplo, afectaria la seguridad, el rendimiento, etc)
    - Probabilidad: Una estimacion de la probabilidad de que el riesgo ocurra
    - Estrategia de mitigacion: Medidas para mitigar el riesgo o reducir su impacto
    - Estado: El estado actual del riesgo (activo, mitigado, pendiente)
* _Ejemplo:_ Un riesgo de sobrecarga en la base de datos podria documentarse con estrategias de mitigacion como el uso de caches distribuidos o la implementacion de replicacion de base de datos

## Herramientas para la documentacion
* Herramientas de modelado de diagramas
* Herramientas de gestion de documentación
* Sistemas de control de version (VCS)
* Herramientas de gestion de riesgos
* Generadores automaticos de documentacion

## Herramientas de modelado de diagramas
* _Proposito:_ Crear diagramas arquitectonicos, como diagramas UML, diagramas de componentes, diagramas de despliegue, entre otros. Se pueden generar visualmente o mediante codigo. Se recomienda usar una basada en codigo
* _Recomendaciones visuales:_
    - Draw.io: Una opcion gratuita y de codigo abierto para crear diagramas de arquitectura
    - Enterprice Architect: Herramienta orientada a la creacion de modelos UML y diseño arquitectonico, utilizada en entornos empresariales
* _Recomendaciones de basada en codigo_
    - Memaid (http://mermaid.live/)
    - PlantUML (https://plantuml.com/)
* _Ejemplo de uso:_ Crear un diagrama de componentes que muestre como los diferente modulos de un sistema de microservicios interactúan entre si

## Herramientas de gestiona de documentación
* _Proposito:_ Mantener y gestionar la documentacion arquitectonica, asegurando que este centralizada, accesible y versionada
* _Herramientas recomendadas:_
    - Confluence: Una plataforma de colaboración para documentar y compartir informacion tecnica dentro de los equipos
    - Google Docs o Microsoft Word: Herramientas simples pero efectivas para crear y colocar en ducumentos de texto
    - Docusaurus o MkDocs: Herramientas de documentacion que permiten generar sitios web de documentacion estatica a partir de archivos Markdown, utiles para documentaciones extensas y tecnicas
    - Asciidoctor
    - GitHub Pages
* _Ejemplo de uso:_ User Confluence para centralizar la documentacion arquitectonica, permitiendo que todos los equipos accedan y colaboren en ella facilmente

## Sistemas de control de versiones (VCS)
* _Proposito:_ Versionar y gestionar los cambios en la documentacion de arquitectura de la misma manera que se hace con el codigo fuente
* _Herramientas recomendadas:_
    - Git: Un sistema de control de versiones ampliamente utilizado que permite realizar seguimientos de los cambios en la documentacion    - GitHub: Pages o GitLab Pages: Permiten alojar documentacion en linea utilizando archivos Markdown versionados con Git
* _Ejemplo de uso:_ Usar Git para versionar los documentos de arquitectura en formato Markdown y publicarlos automaticamente en un estatico utilizando GitHub Pages

## Herramientas de gestion de riesgos
* _Proposito:_ Gestionar los riesgos asociados a las decisiones arquitectonicas y las estrategias de mitigacion
* _Herramientas recomendadas:_
    - JIRA: Herramienta de gestion de proyectos que permiten registrar y hacer seguimiento de los riesgos
    - Trello: Una herramienta visual para la gestion de proyectos y tareas que puede ser usada para documentar y rastrear riesgos arquitectonicos
    - GitHub Issues: Usando etiquetas en los issues prodriamos gestionar Riesgos
    - Hojas de calculo: Google Sheets o Excel prodrian ser alternatitvas
* _Ejemplo de uso:_ Crear tarjetas en Trello que representen riesgos arquitectonicos, asociando cada tarjeta con la estrategia de mitigacion correspondiente y manteniendo un seguimiento del estado del riesgo

 ## Generadores automaticos de documentacion
* _Proposito:_ Automatizar la generacion de documentacion a partir del codigo fuente o modelos arquitectonicos
* _Herramientas recomendadas:_
    - PlantUML: Permite generar diagramas UML a partir de descripciones textuales. Es util para mantener los diagramas actualizados automaticamente en funcion de los cambios en el codigo
    - Swagger: Herramienta para la generacion automatica de documentacion de APIs RESTful
* _Ejemplo de uso:_ User PlantUML para generar diagramas de clases automaticamente a partir de descripciones textuales en la documentacion

## Mejores practicas para la documentacion
* Manten la documentacion ligera
* Haz que la documentacion sea accesible y colaborativa
* Actualiza la documentacion de manera continua
* Incluye ejemplos y casos de uso reales
* Prioriza las decisiones arquitectonicas clave
* Documenta con diferentes niveles de abstraccion
* Alinea la documentacion con los ciclos de vida de desarrollo
* Incorpora pruebas y metricas de arquitectura
* Haz que la documentacion sea modular y reutilizable
* Utiliza una metodologia de documentacion iterativa

## Puntos clave
* Atributos de calidad
    - Como identificarlos
    - Administrarlos
* Decisiones de diseño

## Identificar atributos de calidad
* Comprender los objetivos del negocio
* Analizar los casos de uso clave
* Entrevistar a los stakeholders
* Definir metricas claras
* Revisar patrones arquitectonicos
* Equilibrar compromisos (trade-offs)
* Herramientas utiles

## Comprender los objetivos del negocio
* Lo primero es alinear la arquitectura con los objetivos del negocio. Preguntate: ¿Cuales son las prioridades y necesidades principales del cliente o negocio? Algunos ejemplos comunes son:
    - Escalabilidad: si se espera que el sistema crezca
    - Disponibilidad: si el sistema debe estar accesible 24/7
    - Seguridad: si se manejan datos sensibles

## Analizar los casos de uso clave
* Revisa los casos de uso o los escenarios mas importantes del sistema, y determina que atributos de calidad son criticos para el exito
* Cada caso de uso puede requerir diferentes atributos de calidad. Por ejemplo:
    - Un sistema de transacciones bancarias puede requerir integridad y confiabilidad
    - Una aplicacion en tiempo real puede necesitar baja latencia y alto rendimiento

## Entrevistar a los stakeholders
* Los stakeholders (clientes, usuarios finales, equipo de desarrollo, equipo de operaciones) tienen diferentes expectativas
* Realiza entrevistas para identificar sus prioridades en terminos de
    - Mantenibilidad: ¿Que tan facil sera modificar el sistema en el futuro?
    - Protabilidad: ¿Necesita el sistema ser desplegado en diferentes plataformas?
    - Usabilidad: ¿El sistema debe ser intuitivo para los usuarios?

## Definir metricas claras
* Cada atributo de calidad debe tener una metrica cuantificable. Por ejemplo:
    - Rendimiento: El sistema debe procesar X solicitudes por segundo
    - Disponibilidad: El sistema debe estar operativo el 99.9% del tiempo
    - Seguridad: El sistema debe cumplir con las normativas X y Y

## Definir patrones arquitectonicos
* Con los atributos de calidad identificados puedes seleccionar patrones arquitectonicos que ayuden a cumplir con estos requisitos. Por ejemplo:
    - Para escalabilidad, podrias usar una arquitectura basada en microservicios
    - Para seguridad, podrias aplicar principios de arquitectura hexagonal, donde los mecanismos de seguridad estan desacoplados del nucleo de la logica de negocio

## Equilibrar compromisos Trade-offs
* A menudo, los atributos de calidad entran en conflicto entre si
* Por ejemplo, mejorar la seguridad puede afectar la usabilidad o el rendimiento
* Es importante equilibrar estos compromisos con los stakeholders, priorizando los mas criticos para el exito del sistema

## Herramientas utiles
* El uso de Herramientas de trabajo como ISO/IEC 25010 (calidad del software) puede ser de gran ayuda, ya que proporciona una lista detallada de atributos de calidad a considerar
* Tambien, metodologias como ATAM (Architectura Tradeoff Analysis Method) ayudan a analizar y priorizar estos atributos
* Identificar los atributos de calidad de un sistema es fundamental para tomar decisiones arquitectonicas que se alineen con las necesidades del negocio y las expectativas de los usuarios

## ¿Que es ATAM? Architecture Tradeoff Analysis Method
* _Definicion:_
    - El ATAM es un proceso estructurado para evaluar las decisiones de arquitectura de software, basado en atributos de calidad, como rendimiento, escalabilidad, seguridad, entre otros
* Proposito
    - Identificar los compromisos (Tradeoffs) entre estos atributos, revelando riesgos potenciales y oportunidades de mejora

## Proposito y Beneficios
* Proposito
    - Evaluar si una arquitectura puede satisfacer los requisitos de calidad de un sistema y ayudar a tomar decisiones informadas para mitigar riesgos
* Beneficios
    - Integracion temprana de riesgos y problemas en la arquitectura
    - Balancear diferentes atributos de calidad
    - Alinear las decisiones arquitectonicas con los objetivos del negocio
    - Crear una documentacion clara para todas las partes interesadas

## Pasos del proceso ATAM
* Introduccion al metodo:
    - Se reune a todas las partes interesadas y se explican los objetivos y el proceso
* Presentacion de la arquitectura
    - El equipo de arquitectura describe la arquitectura propuesta
* Identificacion de los atributos de calidad
    - Se priorizan los atributos de calidad que son mas revelantes para el sistema
* Escenarios de calidad
    - Se desarrollan escenarios concretos que ejemplifiquen como se comportara el sistema bajo ciertas condiciones
* Analisis de Tradeoffs
    - Se identifican los compromisos entre diferentes atributos de calidad
* Evaluacion de riesgos
    - Se documentan los riesgos y oportunidades de mejora

## Ejemplos de analisis de Tradeoffs
* Rendimiento vs. Seguridad
    - Mejorar la seguridad puede reducir el rendimiento, ya que agregar mas controles o cifrado en el sistema puede hacerlo mas lento
* Escalabilidad vs. Disponibilidad
    - Incremetar la escalabilidad puede aumentar la complejidad y, potencialmente, reducir la disponibilidad en ciertos momentos de alta carga

## Ejemplo de escenario de calidad
* Escenario de rendimiento
    - "El sistema debe manejar 10,000 solicitudes por segundo sin que la latencia supere los 100ms durantes picos de trafico"
* Escenario de seguridad
    - "La plataforma debe cumplir con las normativas de seguridad ISO 27001 y detectar de intrusion en tiempo real"

## Resultados del ATAM
* Riesgos identificados:
    - Se identifican las areas de mayor riesgo para los atributos de calidad mas criticos
* Mejoras propuestas:
    - Se sugiere modificaciones para mitigar los riesgos y mejorar los Tradeoffs entra atributos de calidad

## Conclusiones
* ATAM es un metodo robusto para garantizar que las arquitecturas de software cumplan los requisitos de calidad, balanceando compromisos clave
* Ayuda a alinear la arquitectura con las necesidades del negocio y las expectativas de los usuarios
* Facilita la toma de decisiones informadas sobr cambios y mejoras arquitectonicas

# Modulo 3

## ¿Que son los ADRs?
* _Definicion:_ Una Architecture Decision Record (ADR) es un documento que captura una decision arquitectonicamente importante, junto con su contexto y las razones detras de ella
* _Origen:_ Introducido por Michael Nygard en su libre "Documenting Architecture Decisions" (2011)
* _Proposito:_ Documentar y comunicar de manera clara la decisiones arquitectonicas clave

## ¿Por que usar ADRs?
* _Claridad y Transparencia:_ Facilita la comunicacion entre los miembros del equipo sobre por que se tomo una decision especifica
* _Historial de decisiones:_ Fomenta discusiones informadas basadas en contexto
* _Evolucion:_ Ayuda a comprender si las decisiones deben ser reevaluadas o modificadas a medidad que cambian los requisitos

## Estructura de un ADR
* _Titulo:_ Describe la decision
* _Contexto:_ Explica las circunstancias que llevaron a la necesidad de tomar una decision
* _Decision:_ Resumen claro y conciso de la eleccion realizada
* _Consecuencias:_ Efectos a corto o largo plazo, tanto positivos como negativos
* _Estado:_ Si la decision esta aprobada, propuesta, o si ha sido rechazada
* _Fecha:_ Cuando se tomo la decision
* _REferencia:_ Documentos o fuentes revelantes que influyeron de la decision

## Beneficios de los ADRs
* Decisiones centralizadas: Se consolidan las decisiones clave en un solo lugar
* Documentacion ligera: Son faciles de escribir y mantener
* Escalabilidad: Funciona bien en proyectos pequeños y grandes
* Comunicacion efectiva: El equipo y las partes interesadas externas pueden estar al tanto del proceso de decision

## Buenas practicas
* _Se conciso:_ Un ADRS debe ser breve y al grano
* _Manten consistencia:_ Utiliza una estrucutura estandar para todos los ADRs
* _Actualiza regularmente:_ Revisa las decisiones conforme evoluciona el proyecto
* _Colaboracion:_ Involucra a todo el equipo en la redaccion y revision de ADRs

## Ejemplo de un ADR
* _Titulo:_ Eleccion del Framework de Microservicios
* _Contexto:_ Evaluamos varios frameworks para la Implementación de microservicios en nuestro sistema basado en Java
* _Decision:_ Se selecciono Spring Boot debido a la robustez y la experiencia del equipo con el framework
* _Consecuencias:_ Se espera un mayor velocidad de desarrollo, pero con un mayor uso de recursos en comparacion con opciones mas ligeras
* _Estado:_ Aprobado
* _Fecha:_ 01 de Octubre de 2024

## Conclusiones
* Los ADRs son una herramienta poderosa para documentar decisiones arquitectonicas
* Aseguran que el equipo este alineado y que las decisiones tengan un registro claro y consultable
* Ayudan a gestionar la complejidad a medida que el proyecto crece y evoluciona
* Implementarlos como parte de tu flujo de trabajo mejora la transparencia y el entendimiento en el equipo

## Herramientas para ADR
* Simple editor o procesador de texto
* Wiki o Confluence
* MARD (Markdown Architectual Decision Records)
    - https://adr.github.oi/

# Modulo 4

## Proceso de ADR
* Uso de plantillas estandarizadas
* Almacenamiento junto al codigo
* Automatizacion con herramientas
* Incluir ADR en las revisiones de codigo
* Definir cuando usar ADR
* Revisiones periodicas
* Etiqueta tus ADRs con IDs

## Uso de plantillas estandarizadas
* Una forma de asegurar consistencias y facilidad de uso es emplear una plantilla estandar para todos los ADRs
    - https://adr.github.io/#existing-adr-templates

## Almacenamiento junto al codigo
* Puedes almacenar los ADRs en el repositorio del codigo para que esten accesibles a todo el equipo y queden versionados junto con el proyecto
* Crear una carpeta llamada _docs/adr/_ o simplemente _adr/_ en la raiz del proyecto es una buena practica
* De esta forma, cada decision estara vinculada al contexto del codigo que refleja esa arquitectura

## Automatizacion con herramientas
* Existen herramientas que ayudan a crear y gestionar ADRs en proyectos de software
* Una opcion es usar el plugin _adr-tools_ que automatiza la creacion de nuevos registros y garantiza que sigan un formato consistente
* Si prefieres algo sencillo, con Git puedes versionar manualmente tus ADRs

## Incluir ADR en las revisiones de codigo
* Cada vez que se haga una revision de codigo, ´puedes revisar o actualizar los ADR relacionados si la decision impacta en la arquitectura
* De esta forma, mantienes la informacion al dia

## Definir cuando usar ADR
* Es importante definir con tu equipo cuando es necesario crear un ADR
* No todas las decisiones tecnicas lo requieren
* Aqui hay algunos criterios para saber cuando es recomendable crear uno
    - Si la decision afecta signifcativamente la arquitectura del sistema
    - Si implica un cambio en las tecnologias o patrones de diseño
    - Si puede generar deuda tecnica futura o requerira compromisos importantes
    - Si es una decision dificil de revertir

## Revisiones periodicas
* Haz que las ADR sean parte de las reuniones de revision tecnica
* Cada cierto tiempo, puedes revisar las decisiones previas para ver si siguen siendo relevantes o necesitan ser modificadas

## Etiqueta tus ADRs con IDs
* Es util numerar y dar un ID unico a cada ADR
* Esto facilita la referencia y el seguimiento
* Por ejemplo, si decides cambiar el sistema de autenticacion en un microservicio, podrias referencias ese ADR en otros documentos o incluso commits

## Ejemplo de flujo de trabajo
1. _Nuevo cambios arquitectonico:_ Al proponer un cambio importante en la arquitectura, crea un nuevo ADR explicando el contexto y las alternativas
2. _Revision del equipo:_ Revisa la propuesta con el equipo para obtener comentarios, y luego aprueba el ADR
3. _Implicacion:_ Tras probar la decision, implementa el cambio en el codigo y marca el ADR como "implementado"
4. _Documentacion continua:_ A medida que evolucionen las decisiones, actualiza los ADR o crea nuevos si cambian las circunstancias

## Amazon y ADR
* https://docs.aws.amazon.com/prescriptive-guidance/latest/architectural-decision-records/adr-process.html

 ## Herramientas para ADR
* ADR-Tools
* Markdown como formato manual
* ADR Manager
* Helmsman ADR
* Alternativas Cloud-Hosted
* ADR GitHub Action
    - ADR TOC
    - ADR Sync
* Custom Solutions

| Herramientas | Tipo | Ventajas | Recomendado para |
| ----- | ----- | ----- | ----- |
| adr-tools | CLI | Sencillo, ligero, facil de integrar | Proectos peuqeños / medianos |
| Markdown manual | Manual | Total control y flexibilidad | equipos peuqeños |
| ADR Manager | GUI/Web | Visual, facil de usar | Equipos que prefieren GUI |
| Helmsman ADR | CLi + Integracion | Avanzado, integra con CI/CD | Equipos destribuidos/avanzados |
| Confluence/Notion | SaaS | Colaboracion en tiempo real | Equipos grandes |
| GitHub Action ADR | GitHub Action | Automatizacion con CI/CD | Equipos que usan GitHub |

## ¿Como verificar las decisiones?
* Integrar ADRs con las revisiones de codigo (Code Revews)
* Usar reglas con ArchUnit
* Linting personalizado
* Documentacion viva
* Verificacion en pipelines CI/CD
* Generar alertas o abrir issues automaticamente
* Documentacion vinculatoria

## Integrar ADRs con las revisiones de codigo
* Una de las formas mas simples de verificar el cumplimiento de ADRs es integrarlas en las revisiones de codigo. Antes de aprobar un pull request, se puede agregar un paso en el que el equipo revise si las decisiones tomadas en los ADRs se respeten
* Puedes incluir checks manuales en tus pull request o en los comentarios, recordando al revisor que valide el cumplimiento de las decisiones arquitectonicas
* GitHub Actions, GitLab CI, o Azure Pipelines pueden generar un recordatorio o incluso detener el flujo de trabajo si no se cumple una ADR relevante

## Usar reglas con ArchUnit
* Puedes definir reglas especificas en ArchUnit que validen si el codigo cumple con las restricciones establecidas en tus ADRs
* ArchUnit te permite escribir pruebas automatizadas en Java que pueden comprobar que ciertos patrones o restricciones arquitectonicas se respeten en el codigo fuente

## Linting personalizado
* Puedes implementar linters personalizados que analicen el codigo en busca de patrones que incumplan tus ADRs
* Herramientas como SonarQube pueden configurarse para verificar reglas arquitectonicas personalizadas y generar alertas cuando el codigo no respeta una decision definida en un ADR
* Ejemplo: si una ADR define que todas las dependencias de acceso a datos deben ser interfaces, puedes escribir una regla en SonarQube que valide esto y genere un error si no se cumple

## Documentacion viva
* Puedes convertir tus ADRs en documentacion viva, donde las decisiones se convierten en pruebas o verificaiones automatizadas dentro de tu pipeline de CI/CD
* Algunas herramientas como ADR Manager o scripts personalizados puede integrarse con tu pipeline para validar si una nueva modificacion del codigo contradice una ADR. Esto se hace estableciendo tests que deben cumplirse para cada ADR, y si alguna falla, el pipeline puede detenerse

## Verificacion en pipelines CI/CD
* Si estas usando CI/CD (Continuos Integration/Continuos Deployment), puedes configurar un paso dentro del pipeline que verifique el cumplimiento de ADRs mediante herramientas como ArchUnit, SonarQube o scripts personalizados que revisen las decisiones arquitectonicas

## Generar alertas o abrir issues automaticamente
* Puedes configurar herramientas como GitHub Actions o GitLab CI para que, si aun ADR no se cumple, generen automaticamente una alerta o abran un issue en el repositorio
* Ejemplo: Si una prueba de arquitectura (definida con ArchUnit) falla, puedes configurar tu pipeline para abrir un issue con el detalle de que ADR se ha incumplido

## Documentacion vinculatoria
* Su usa ADR Manager, puedes generar vinculos entre las decisiones y las implementaciones. Estas decisiones pueden integrarse en el ciclo de vida de desarrollo mediante alertas o anotaciones en el codigo fuente
* Los ADR se pueden ligar a partes especificas del codigo (por ejemplo, componentes o clases) que deben respetar las decisiones

## Resumen
* Automatizar el cumplimiento de ADRs es una forma poderosa de garantizar que las decisiones arquitectonicas sigan vigentes en todo el ciclo de vida de desarrollo
* Algunas opciones incluyen:
    - Usar ArchUnit para crear reglas espcificas en proyectos java
    - Integrar verificaciones en CI/CD  con herramientas como SonarQube, GitHub Actions, o scripts personalizados
    - Automatizar alertas o issues si una ADR no se cumple
* Revisar
    - https://www.ozimmer.ch/practices/2020/09/24/ASRTestECSADecisions.html
    - https://github.com/joelparkerhenderson/architecture-decision-record
    - https://domainanalysis.io/p/document-your-product-and-software?r=26tm44

## ArchUnit
* ArchUnit es una biblioteca para Java que te permite realizar pruebas automaticas sobre la arquitectura de un sistema
* Con ArchUnit, puedes verificar que tu arquitectura sigue ciertas reglas o principios definidos por ti mismo
* Esto es particularmente util en aplicaciones que siguen patrones arquitectonicos como Clean Architecture, DDD o microservicios, donde se busca mantener el codigo bien organizado y modulas

## Caracteristicas de ArchUnit
* _Verificacion de dependencias:_ Puedes asegurarte de que ciertos paquetes o clases no dependan de otros
* _Cumplimiento de capas:_ Verificar que las diferentes capas de tu aplicacion (por ejemplo, presentacion, dominio, infraestructura) esten correctamente separadas
* _Validacion de convenciones:_ Asegurarte de que las clases sigan ciertos patrones de nombres o ubicaciones
* _Comprobacion de herencia y anotaciones:_ Verificar que ciertas clases hereden de otras o tengan ciertas anotaciones
* Integracion con Frameworks de testing como JUnit

## Ejemplo
```java
JavaClasses importedClasses = new ClassFileImporter(). importPackages("com.miapp")

ArchRuleDefinition.classes()
    .that()
        .resideInAPackage("...domain...")
    .should().onlyHaveDependentClassesThat()
        .resideInAnyPackage("..domain..","..application..")
    .check(importedClasses);
```
* En Clean Architecture, podrias usar ArchUnit para asegurar que las capas internas (como dominio o casos de uso) no dependan de las capas externas (como infraestructura o la interfaz de usuario)

## Revision codigo
* Tener JDK minimo 17, deseable 23
* Maven instalado, minimo 3.8, deseable 3.9.9
* https://www.archunit.org/userguide/html/000_Index.html
* Descomprimir el archivo _archunit.zip_ en cuaquier parte de tu filesystem

## Ejercicio
* Ejecutar los test con: _mvn verify_
* Hacer fallar la prueba, agregando una clase en el paquete controller y que rompa la regla definida
* Corregir la prueba

# Modulo 5

## ¿Que es el Domain-Driven-Design?
* Domain-Driven Design (DDD) es una metodologia para desarrollar Software centrada en modelar y resolver problemas complejos del dominio del negocio
* Pone enfasis en la colaboracion entre expertos del domino y desarrolladores
* Enfoque clave: Crear un modelo de negocio basado en las necesaidades del negocio

## Principios clave del DDD
* Lenguaje Ubicuo (Ubiquitous Language):
    - Un lenguaje compartido entre expertos del negocio y desarrolladores
    - Mejora la comunicacion y elimina malentendidos entre el equipo tecnico y no tecnico
* Modelar segun el domino:
    - El modelo del software refleja fielmente las realidades del negocio
    - Enfocado en capturar las reglas y comportamientos esenciales del domino

## Colaboracion con los expertos del Dominio
* _Experto del dominio:_ persona con amplio conocimiento sobre el problema que se esta resolviendo
* _Desarrollador:_ transforma ese conocimiento en codigo
* Colaboracion  continua entre ambos roles es esencial para el exito del modelo

## Contexto Delimitado (Bounded Context)
* Define los limites donde un modelo es aplicable
* Cada Bounded Context tiene su propio modelo de domino
* Evita conflictos entre modelos al establecer fronteras clara entre ellos

## Beneficios de los Contextos Delimitados
* _Escalabilidad:_ Los sistemas pueden dividirse en partes manejables y autonomas
* _Separacion de preocupaciones:_ Cada equipo puede trabajar en su contexto sin interferir con otros
* _Claridad y mantenimiento:_ Los limites permiten gestionar mejor codigo y los cambios

## Colaboracion entres contextos
* Integracion  entre los contextos delimitados
* Los modelos de diferentes contextos interactuan de manera controlada
* Tecnicas como _Context Mapping_ y _Anti-Corruption Layer_ ayudan a gestionar esta interaccion

## El enfoque estrategico
* DDD no solo se centra en la estructura tecnica del software, sino tambien en las decisiones estrategicas
* Impulsa un diseño que responde a las necesidades del negocio, optmizando el impacto del software en los resultados empresariales

## Introduccion
* DDD ayuda a gestionar la complejidad de los dominos empresariales avanzados
* Al establecer un lenguaje comun y dividir el sistema en contextos delimitados premiten crear software mas alineado con los objeticos del negocio

## ¿Que es un Contexto Delimitado?
* Un _Bounded Context_ establece los limites donde un modelo de domino es valido
* Cada contexto tiene su propio lenguaje ubicuo y logica de negocio
* Ayuda a gestionar la complejidad del sistema, dividiendolo en partes manejables

## ¿Por que son importantes los limites?
* Los limites evitan que los modelos se mezclen y generen confusion
* Clara separacion de responsabilidades entre contextos
* Facilita la colaboracion entre equipos, ya que cada uno trabaja en su propio contexto

## Relacion entre contextos
* Los Bounded Contexts pueden interacturar, pero deden hacerlo de manera controlada
* Tecnicas clave para gestionar la interaccion entre contextos
    - _Context Maps:_ Mapa visual de las relaciones netre los diferentes contextos
    - _Anti-Corruption Layer:_ Barrera para proteger un contexto de la complejidad de otro

## Mapa de Contextos (Context Map)
* _Context Map:_ una herramienta que muestra las relaciones y dependencias entre distintos contextos
* Proporciona una vision clara de como interactuan los contextos dentro del sistema
* Identifica las zonas de integracion y las posibles fuentes de conflicto entre modelos

## Context Map para un sistema de e-commerce
* _Customer Management Context:_ Gestiona la informacion de los clientes, perfiles, historial de compras etc
* _Order Management Context:_ Responsable de gestionar los pedidos, su creacion, procesamiento y estado
* _Inventory Management Context:_ Controla el stock de productos, la disponibilidad en el almacen y las actualizaciones del inventario
* _Billing Context:_ Encargado de la facturacion, pagos y cobros
* _Shipping Context:_ Gestiona el envio de los productos, seguimiento de paquetes, y comunicacion con proveedores logisticos

## Relaciones y patrones del Context Map
* Customer Management -> Order Management: Relacion de _Customer/Supplier_
    - Customer Management proporciona datos del cliente cuando se crea un pedido en Order Management
    - Esta relacion indica que Order Management depende de Customer Management para obtener informacion actualizada del cliente
* Order Management -> Inventory Management: Relacion de _Conformist_
    - Order Management depende directamente del modelo de inventario de Inventory Management ara verificar si los productos estan en stock, aqui Oder Management acepta los terminos y modelo de datos que le dicta Inventory Management sin intentar cambiar o interferir en ese modelo
* Oder Management -> Billing: Relacion de _Anti-Corruption Layer (ACL)_
    - Oder Management necesita interactuar con Billing, pero los modelos internos de cada uno son diferentes. Para evitar que Order Management se "contamine" con el modelo de Billing, se crea una capa de anti-corruption que traduce y adapta los datos entre los dos contextos
* Order Management -> Shipping: Relacion de _Publish Language_
    - Order Management publica eventos de dominio cuando un pedido esta listo para ser enviado. Shipping escucha estos eventos para proceder con el proceso de envio. Ambos contextos utilizan un lenguaje de eventos compartido (por ejemplo, un "pedido listo para enviar") para facilitar esta comunicación

## Tipos de relaciones
* Las relaciones entre los diferentes Bounded Context son fundamentales para definir como interactúan y colaboran las distintas partes del sistema
* Eric Evans y Vaughn Vernon describen varios tipos de relaciones entre contextos, y cada una define una forma particular de acoplamiento o interaccion
    - Customer/Supplier
    - Conformist
    - Anti-Corruption Layer (ACL)
    - Published Language
    - Shared Kernel
    - Separate Ways
    - Partnership
    - Open Host Service

## Customer/Supplier
* Esta relacion indica que un contexto (el Supplier) proporciona datos o servicios que otro contexto (el Consumer) necesita para funcionar. En este caso, el Customer depende de los datos o servicios del Supplier, y el Supplier define las reglas o el contrato que debe seguir el Consumer
* Ejemplo: En un sistema de e-commerce, el Orden Management necesita informacion del Customer Management para crear un pedido. Customer Management actua como el Supplier, y el Order Management es el Customer
* Implicaciones: El Customer depende del Supplier para recibir datos y debe adaptarse al modelo y las politicas del Supplier. Sin embargo, los cambios en el Supplier pueden afectar al Consumer, por lo que debe haber una colaboracion entre equipos

## Conformist
* En una relacion Conformist, un contexto depende de otro y acepta el modelo y reglas del tro contexto sin intentar imponer cambios o influir en su comportamiento. El contexto que se conforma debe adaptarse al modelo del contexto dominante
* Ejemplo: El Order Management podria depender del Inventory Management para verificar la disponibilidad de productos. El Order Management acepta y usa el modelo de Inventory Management tal cual, sin intentar modificarlo
* Implicaciones: El Conformist no tiene control sobre los cambios del otro contexto. Esto puede ser solucion rapida, pero tambien significa un fuerte acoplamiento y menos flexibilidad

## Anti-Corruption Layer (ACL)
* Cuando dos contextos necesitan interactuar, pero tienen modelos muy diferentes, se puede utilizar una Anti-Corruption Layer. Esta capa actua como un intermediario que traduce y adapta las estructuras y comportamientos de un contexto al otro, evitando que uno "contamine" al otro
* Ejemplo: El Order Management podria necesitar interactuar con un sistema de facturacion (Billing), pero sus modelos de datos son diferentes. Para evitar que el modelo de Billing afecte el diseño del Order Management, se implementa una ACL que traduce las interacciones entre ambos
* Implicaciones: Esta capa agrega complejidad, pero permite mantener ambos contextos independientes y proteger sus modelos internos, evitando acoplamiento indeseados

## Published Language
* En una relacion Published Language, los contextos acuerdan utilizar un lenguaje compartido o estandar para intercambiar datos o eventos. Este lenguaje puede tomar la forma de mensajes de eventos o APIs bien definidas, lo que permite la comunicacion sin tener que conocer los detalles internos del otro contexto
* Ejemplo: En un sistema de e-commerce, el Orden Management podria publicar un evento llamado "Order Shipped" que Shipping escucha para comenzar el proceso de envio. Ambos contextos se ponen de acuerdo en el formato de ese evento
* Implicaciones: Este tipo de relacion reduce el acoplamiento entro los contextos, ya que dependen solo del lenguaje acordado (eventos o mensajes) y no de los detalles internos de cada uno

## Shared Kernel
* En esta relacion, dos contextos comparten una pequeña parte del modelo o codigo, generalmente en forma de librerias o modulos comunes. El Shared Kernel contiene componentes que ambos contextos necesitan y deben mantener en conjunto, lo que requiere una fuerte colaboracion entre equipos para garantizar que estos componentes compartidos sean consistenes
* Ejemplo: Un sistema de pagos y un sistema de pedidos podria compartir un modulo que contiene logica de calculo de impuestos, que es necesaria para ambos. Esta logica compartida seria parte del Shared Kernel
* Implicaciones: Los equipos deben colaborar estrechamente para mantener el Shared Kernel, lo que puede generar dependencias y complejidad adicional si no se gestiona bien

## Separate Ways
* Es una relacion de Separate Ways, los contextos no necesitan interactuar entre si, y cada uno es independientes. A veces, es mas eficiente que ciertos modulos sigan su propio camino y no interfieran de otros
* Ejemplo: Un sistema de gestion de inventario y un sistema de marketing puede no necesitar comunicarse directamente, ya que gestionan funciones completamente diferentes
* Implicaciones: Los contextos son completamente autonomos, lo que permite mayor flexibilidad y menos acoplamiento. Sin embargo, esto es util si realmente no hay necesidad de interaccion entre ellos

## Partnership
* Es una relacion de Partnership, dos contextos trabajan muy estrechamente y de manera igualitaria para lograr un objetivo comun. Ambos contextos dependen del otro y los cambios en uno pueden afectar al otro. A diferencia de Customer/Supplier, aqui no hay contexto dominante
* Ejemplo: El Order Management y el Shipping pueden trabajar como socios igualitarios, ya que ambos necesitan coordinarse muy de cerca para garantizar que los pedidos se procesen y envien correctamente
* Implicaciones: Los equipos necesitan una colaboracion constantem lo que puede resultar en una mayor coordinacion y mayor riesgo de acoplamiento, pero tambien una integracion mas fluida

## Open Host Service (OHS)
* Su proposito es exponer un servicio claro y accesible para que otros contextos puedan interactuar con un determinado contexto de manera controlada y predecible
* Este patron permite que un contexto ofrezca su funcionalidad a otros contextos de forma publica, mediante una API o servicio, sin necesidad de que los detalles internos de su modelos de dominio sean expuestos
* Ejemplo: Inventory Management expone un servicio que permite consultar el stock de productos, quizas con una API REST o mensajes en un sistema de eventos. Order Management y Shipping consumen este servicio para verificar si un producto esta disponible antes de procesar el pedido o proceder con el envio

## Modularidad y Contextos
* Al dividir el sistema en contextos delimitados, se fomenta la modularidad
* Cada modulo puede evolucionar de forma independiente, facilitando:
    - Mantenibilidad
    - Escalabilidad
    - Independencia entre equipos de desarrollo
* Los Bounded Context son esenciales para gestionar la complejidad de un sistema de dominio
* Definen limites claros que mejoran la colaboracion, el diseño modular y la independencia entre los equipos
* Tecnicas como Context Maps y Anti-Corruption Layer ayudan a mantener la coherencia y claridad en la integracion entre contextos

## ¿Que es el Lenguaje Ubicuo?
* Es un lenguaje compartido entre expertos del dominio y desarrolladores
* Evoluciona a medida que se profundiza en la compresion del modelo de dominio
* Sirve como base para todo el desarrollo del software y la comunicacion dentro del equipo

## Importancia del Lenguaje Ubicuo
* Evita malentendidos entre el equipo tecnico y los expertos del negocio
* Refuerza la colaboracion continua entre desarrolladores y expertos del dominio
* Mejora la calidad del codigo ya que los terminos utilizados en el codigo reflejan con precision el model del negocio

## Lenguaje Ubicuo en el codigo
* El lenguaje ubicuo debe estar presente en todos los artefactos del software, incluyendo:
    - Clases
    - Metodos
    - Nombres de variable
    - Documentación
* Ejemplo:
    - Si en el negocio se habla de "pedido", la entidad en el codigo debe llamarse "Pedido" en lugar de usar terminos genericos como "Transaction" o "Order"

## Colaboracion con los expertos del dominio
* El lenguaje se desarrolla y refina a traves de conversaciones continuas con los expertos del dominio
* Las discusiones sobre el dominio deben ser traducidas directamente en el modeli y codigo
* Crea un ciclo de retroalimentacion entre el desarrollo y el entendimiento del dominio

## Desarrollo Incremental del Lenguaje
* El lenguaje ubicuo no es estatico, evoluciona conforme cambia la compresion del dominio
* Las iteraciones en el desarrollo y la retroalimentacion del negocio permitan refinar tanto el lenguaje como el modelo
* Un lenguaje bien definido puede ayudar a detectar inconsistencias en el modelo

## Tecnicas para desarrollar el lenguaje Ubicuo
* Workshops de descrubrimiento:
    - Sesiones colaborativas con expertos del domino para identificar y definir terminos clave
* Documentacion activa:
    - Registrar continuamente terminos, reglas y relaciones del dominio conforme surgen
* Pruebas colaborativas:
    - Utilizar pruebas unitarias y test de aceptacion para reflejar el lengiaje y comportamiento esperado

## Ventajas del Lenguaje Ubicuo
* Cohesion del equipo: Todos los miembros del equipo, incluidos los no tecnicos, hablan del mismo idioma
* Codigo legible: El codigo es mas facil de entender y mantener, ya que utiliza terminos precisos del negocio
* Menos errores: Minimiza los malentendidos y descrepancias en la Implementación del modelo del negocio.

## ¿Que es un modelo de dominio?
* Un modelo de dominio es una representacion conceptural del area de negocio que esta siendo implementada en el software
* Refleja las reglas de negocio, los comportamientos y las relaciones entre los objetos del domino
* Se contruye a traves de una colaboracion constante entre desarrolladores y expertos del dominio

## Entidades y Valores
* Entidades: Objetos que tienen una identidad unica dentro del sistem y persisten a lo largo del tiempo
* Ejemplo: Cliente, Pedido, Factura
* Objetos de Valor: No tiene identidad propia, se definen por sus atributos y son inmutables
* Ejemplo: Direccion, Dinero, Fecha

## ¿Que es un Agregado?
* Un agregado es un conjunto de entidades y objetos de valor relacionados que se comportan como una unidad de consistencia
* Garantiza la integridad de los datos al definir los limites dentro de los cuales las operaciones deben ser consistentes
* Cada agregado tiene una raiz de agregado que actua como punto de entrada para todas las interacciones externas

## Diseño de Agregados
* Un agregado debe:
    - Mantenerse lo mas pequeño posible
    - Evitar la dependencia entre agregados
    - Estar diseñado para que las operaciones puedan ser transaccionales dentro de sus limites
* Ejemplo:
    - Un agregado Pedido puede incluir entidades como Cliente y Linea de Pedido, asegurando que caulquier cambio en el pedido sea consistente en su conjunto

 ## Raiz de Agregado
* La raiz de agregado es la entidad principal que controla el acceso a los demas objetos dentro del agregado
* Solo se puede acceder a la entidades internas a traves de la raiz
* La raiz asegura la coherencia de los datos y las reglas de negocio

## Regla de Consistencia
* Los agregados garantizan que las reglas de negocio dentro de sus limites se cumplan
* La consistencia fuerte debe mantenerse dentro de los agregados, mientras que la consistencia eventual se puede permitir entre agregados, especialmente en sistemas distribuidos

## Consejos para Diseñar Agregados
* Manten los agregados pequeños:
    - Limita el numero de entidades dentro de un agregado para reducir la complejidad y mejorar la escalabilidad
* Revisa las transacciones:
    - Un agregado debe permitir que las operaciones sean atomicas y consistentes dentro de sus limites
* Distingue responsabilidades:
    - Usa agregados para separar diferentes responsabilidades en el dominio, garantizando un modelo mas limpio y mantenible

## Ejemplo de Diseño de Agregado
* Sistema de Comercio Electronico:
    - Agregado: Pedido
    - Entidades internas: Cliente Linea de Pedido
    - Objetos de valor: Direccion de Envio, Moneda
* El agregado Pedido asegura que todas las operacion (agregar productos, modificar cliente, calcular precio) se realicen de manera coherente.

## Revisar Coodigo
* agregados.zip

## Agregados Conclusiones
* Los agregados son esenciales para estructurar modelos de dominio complejos y asegurar la consistencia de los datos
* El diseño correcto de los agregados permite crear sistemas escalables, modulares y alineados con las reglas del negocio
* La raiz del agregado juega un papel en la proteccion de la integridad del domino

## ¿Que es un Repositorio?
* Un repositorio es una abstraccion que proporciona un mecanismo para almacenar y recuperar agregados
* Actua como una coleccion en memoria de agregados, aunque en realidad interactua con la base de datos u otro sistema de persistencia
* Proporciona acceso a los agregados sin exponer los detaller de como estan almacenados

## Rol del Repositorio
* Los repositorios permiten:
    - Agregar nuevos agregados
    - Recuperar agregados existentes por su identidad
    - Eliminar Agregados
    - Abstener la complejidad del sistema de persistencia subyacente (base de datosm APIs, etc)

## Interaccion con los Agregados
* Los repositorios solo deben operar sobre agregados completos
* Deben encapsular la logica de acceso a la base de datos y garantizar que los agregados recuperados sean consistentes
* Mantienen la integridad de los datos entre las transaccion

## Diseño de un Repositorio
* Un repositorio suele implementar metodos como:
    - _save(Aggregate aggregate):_ guarda un agregado
    - _findById(AggregateId id):_ recupera un agregado por su identidad
    - _delete(Aggregate aggregate):_ elimina un agregado

## Relacion con la Persistencia
* El repositorio abstrae la interaccion con la capa de persistencia, evitando que el codigo de dominio conozca detaller de como y donde se alamcenan los agregados
* Puede estar respaldado por:
    - Bases de datos relacionales (ORM como Hibernate)
    - Base de datos NoSQL
    - Sistemas de almacenamiento distribuido

## Patron Repositorio vs. DAO
* Repositorio:
    - Operaciones enfocadas en agregados completos
    - Mas cercano al dominio del negocio
* DAO (Data Access Object)
    - Operaciones mas granulares, enfocadas en entidades individuales o datos sin estructura
    - Mas tecnico, centrado en la persistencia de datos

## Implementación del Repositorio
* Al diseñar un repositorio, se debe:
    - Asegurar que sea especifico del dominio (trabajar con agregadosm no con entidades aisladas)
    - Encapsular las relgas de negocio que deben aplicarse al guardar y recuperar datos
    - Mantenerlo independiente de la infraestructura especifica
* Ejemplo
    - Si usas JPA o Hibernate, el repositorio interactua con el EntityManager, pero ese detalle no debe estar expuesto al domino

## Repositorios y Consistencia
* Los repositorios deben manejar la consistencia de los agregados, lo que incluye:
    - Garantizar que los agregados sean recuperados en un estado consistente
    - Aplicar las reglas de negocio pertinentes al persistir o eliminar agregado
    - En sistemas distribuidos, puede ser necesario manejar la consistencia eventual

## ¿Que son los Eventos de Dominio?
* Los eventos de domino representan hechos que han ocurrido en el dominio del negocio
* Son inmutables y describen cambios significativos en el estado del sistema
* Ejemplo: "Pedido Creado", "Pago Aceptado", "Cliente Registrado"

## Beneficios de los Eventos de Dominio
* _Desacoplamiento:_ Permiten que distintas partes del sistema reaccionen sin necesidad de estar fuertemente acopladas
* _Rastreo del Estado:_ Los eventos del dominio proporcionan un historial detallado de los cambios del sistema
* _Reactivo:_ Facilita un diseño orientado a eventos donde los cambios se propagan automaticamente

## Eventos en el Modelo de Dominio
* Los eventos son parte del lenguaje ubicuo y deben reflejar hechos del negocio, no detalles tecnicos
* Se pueden utilizar para:
    - Informar a otros agregados de cambios
    - Sincronizar diferentes sistemas
    - Disparar procesos asincronos, como notificaciones o integraciones

## Estructura de un Evento de Dominio
* Un evento de dominio tipicamente incluye:
    - Nombre descriptiovo: Ejemplo, PedidoCreado
    - Datos relevantes; Informacion sobre el hecho ocurrido, como el ID de pedido, fecha de creacion, monto total, etc.
    - Momento del evento: Tiempo en que el evento ocurrio

## Implementación de Eventos de Dominio
* Crear el Evento: Cuando ocurre una accion signifcativa, se genera el evento en el codigo
    - Ejemplo: Al crear un nuevo pedido, se dispara un evento PedidoCreado
* Publicar el Evento: El evento se publica y es procesado por los interesados en el
    - Puede ser publicado sincronicamente o asincronamente
* Procesar el Evento: Otros componentes del sistema escuchan y reaccionan al evento (Enviar un email, actualizar inventario, etc)

## Publicacion y Manejor de Eventos
* Los eventos de dominio se pueden publicar de diferentes maneras:
    - Sincrono: Los eventos se manejan en el mismo proceso y transaccion
    - Asincrono: Los eventos se envian a traves de un sistema de mensajeria y se procesan en un momento posterior
* Infraestructura: Sistemas como RabbitMQ, Kafka o mensajeria interna pueden ser utilizados para manejar eventos asincronos

## Consistencia y Eventualidad
* Los eventos de dominio ayudan a manejar la consistencia eventual en sistemas distribuidos
* Los sistemas que reaccionan a eventos pueden actualizarse de manera eventual, sin necesidad de una transaccion global
* Ejemplo: Un sistema de inventario puede recibir un evento de PedidoCreado y ahustar sus cifras en un proceso separado

## Ventajas del Diseño Basado en Eventos
* Escalabilidad; Los sistemas desacoplados y basados en eventos pueden escalar mas facilmente
* Auditoria y Rastreo: Los eventos proporcionan un registro claro de lo que ha ocurridom util para auditorias
* Resilencia: Al manejar los eventos de manera asincrona, los sistemas son menos propenso a fallos criticos debido a desacoplamiento

## ¿Que es una Fabrica?
* Una fabrica es un patron de diseño utilizado para la creacion de objetos complejos
* Encapsula la logica necesaria para construir un agregado o una entidad, asegurando que se respeten las reglas de negocio
* Facilita la creacion de objetos sin que el codigo cliente necesite conocer los detalles de su construccion

## ¿Por que usar una Fabrica?
* Simplificacion: Evita que los clientes del modelo de dominio tengan que preocuparse por la logica de creacion de objetos
* Consistencia: Asegura que las reglas y restricciones de dominio se cumplan al crear objetos
* Desacoplamiento: Separa la responsabilidad de crear objetos de otras partes del codigo promoviendo la cohesion

## ¿Cuando utilizar una Fabrica?
* Utiliza una fabrica cuando:
* La creacion del objeto es compleja y requiere de multiples pasos o validaciones
* El proceso de construccion puede cambiar en el futuro y deseas encapsular ese cambio
* Se debe garantizar que los objetos sean creados en un estado valido desde el inicio

## Fabricas en el Contexto del DDD
* En Domain-Driven Design, las fabricas son responsables en crear:
    - Entidades: Cuando la creacion involucra logica compleja
    - Agregados: Para garantizar que un agregado completo se construya correctamente, respetando todas las reglas de dominio
* Las fabricas ayudan a proteger la consistencia y las reglas inmutables del modelo de dominio

## Beneficios de Usar Fabricas
* Encapsulacion: Las reglas y la complejidad de la creacion del objeto estan encapsuladas en la fabrica, no en el codigo cliente
* Reduccion de errores: Evita la creacion incorrecta de objetos fuera de se un estado valido
* Reutilizacion: Puedes reutilizar la logica de creacion en diferentes partes del sistema

## Ejemplo de una Fabrica para un Agregado
```java
public class PedidoFactory {
    public Pedido crear(Cliente cliente, List<LineaPedido> lineas) {
        // validaciones y logica de negocio
        if(lineas.isEmpty()){
            throw new IllegalArgumentException("El pedido debe tener al menos una liena");
        }
        return new Pedido(cliente, lineas);
    }
}
```

## Fabricas vs Constructores
* Constructor:
    - Adecuado para la creacion de objetos simples que no requieren validaciones complejas
    - Se usa cuando la logica de creacion es trivial y no viola las reglas del dominio
* Fabrica:
    - Util para la creacion de objetos o agregados
    - Ideal cuando hay logica de negocio o validaciones involucradas

## ¿Que es un Servicio de Dominio?
* Un Servicio de Dominio es un patron que encapsula logica de negocio que no pertenece a una entidad o un objeto de valor
* Responde a preguntas del tipo "¿Donde coloco esta logica que no encaja naturalmente en ninguna entidad o valor?"
* Representa operaciones que son parte del dominio que no tienen estado propio

## Caracteristicas de un Servicio de Dominio
* Sin estado: No guarda informacion persistente, solo ejecuta operaciones sobre otros objetos del dominio
* Foco en el negocio: Representa acciones del dominio que involucran reglas de negocio
* Logica compleja: Encapsula comportamientos que no pertenecen a una unica entidad o agragado

## ¿Cuando usar un Servicio de Dominio?
* Usar un servicio de dominio cuando:
    - La logica no puede ser naturalmente asignada a una entidad o un objeto de valor
    - La operacion afecta a multiples entidades o agregados
    - Quieres mantener el modelo de dominio limpio y cohesivo

## Ejemplos de Servicios de Dominio
* Calculo de Impuestos:
    - La logica de calculo de impuestos puede involucrar multiples entidades (pedido, clientes, etc), pero no pertenece a una entidad especifica
    - Encapsular este logica en un servicio mejora la cohesion
* Transferencia de Dinero:
    - La operacion de transferencia de dinero puede involucrar multiples cuentas (agregados) y necesita reglas de validacion y consistencia

## Tipode de Servicios en DDD
* En DDD, generalmente encontramos tres tipos de servicios
    - Application Services (Servicios de Aplicacion)
    - Domain Services (Servicios de Dominio)
    - Infraestructure Services (Servicios de Infraestructura)

## Application Services (Servicios de Aplicacion)
* Los Application Services son responsables de orquestar la logica de negocio, actuando como una capa entre la interfaz del usuario (o las APIs) y el dominio
* No contienen logica de negocio; su principal tarea es coordinar las operaciones del dominio, a menudo interactuando con repositorios, entidades, y otros servicios de infraestructura
* Responsabilidades:
    - Orquestar los casos de uso de la aplicacion
    - Interactuar con Respositorios y Domain Services
    - Delegar las reglas de negocio al dominio
    - Coordinar transacciones y flujos de trabajo

## Ejemplo de un Application Service
```java
public class OrderApplicationService {
    private final OrderRepository orderRepository;
    private final PaymentService paymentService;

    public OrderApplicationService (OrderRepository orderRepository, PaymentService paymentService) {
        this.oderRepository = orderRepository;
        this.paymentService = paymentService;
    }

    public void confirmOrder(UUID orderId) {
        // Cargar el agregado (Order) desde el repositorio
        Order order = orderRepository.findById(orderId);

        // Validar y confirmar el pedido
        order.confirmOrder();

        // Procesar el pago usando un servicio externo
        paymentService.processPayment(order);

        // Guardar el agregado
        orderRepository.save(order);
    }
}
```

## Domain Services (Servicios de Dominio)
* Los Domain Services encapsulan logica de negocio que no pertenece naturalmente a una entidad o a un objeto de valor
* Cuando una operacion involucra multiples entidades o conceptos que no pueden estar claramente asociados a una unica regla, se utiliza un servicio de dominio
* Un Domain Service contiene reglas de negocio que no tienen un "hogar" natural en una entidad especifica
* Responsabilidades:
    - Implementar logica de negocio que involucra varias entidades
    - Asegura que las operaciones que no pertenecen claramente a una entidad esten encapsuladas correctamente

## Ejemplo de un Domain Service
```java
public static ShippingService {
    public double calculateShippingCost(Order order, Address deliveryAddress) {
        double baseCost = 5.0 // Costo base
        double distanceFactor = deliveryAddress.distanceFromWarehouse();
        // Calculo simplificado
        return baseCost + distanceFactor * order.getTotalWeight();
    }
}
```

## Infraestructure Services (Servicios de Infraestructura)
* Los Infrastructure Services se encargan de las operaciones relacionadas con la infraestructura, como la persistencia, la integracion con sistemas externos, y otras tareas que no pertenecen al dominio del negocio en si.
* Estos servicios son usados tanto por los Application Services como por las entidades del dominio, pero su logica no forma parte del core del dominio
* Responsabilidades:
    - Manejar la interaccion con sistemas externos
    - Proporcionar servicios que no estan directamente relacionados con la logica de negocio
    - Acceso a base de datos, colas de mensajes, APIs externas, etc

## Ejemplo de un Infrastructure Service
```java
public class PaymentService {
    public void processPayment(Order order) {
        // Logica para procesar el pago con uns sistema externo
        System.out.println("Procesando pago para el pedido: " + order.getOrderId());
        Map<String, Object> chargeParams = new HashMap<>();
        chargeParams.put("amount", chargeRequest.getAmount());
        chargeParams.put("currency", chargeRequest.getCurrency());
        chargeParams.put("description", chargeRequest.getDescription());
        chargeParams.put("source", chargeRequest.getStripeToken());
        return Change.create(chargeParams);
    }
}
```

## Buenas Practicas para Servicios de Dominio
* Mantenerlos sin estado; No deben almacenar informacion entre llamadasm asegurando que sea reutilizables y predecibles
* Centrarse en una unica responsabilidad: Cada servicio debe tener una unica responsabilidad en el dominio, siguiendo el perincipio de responsabilidad unica (SRP)
* Usar el lenguaje ubicuo: Nombre y metodos que reflejen claramente la logica del negocio en el lenguaje comun a los expertos del dominio

## ¿Que es un Modulo en DDD?
* Un modulo es una agrupacion logica de conceptos del dominio que estan relacionados entre si
* Se utiliza para organizar el modelo de dominio y mejorar la comprension, mantenibilidad y escalabilidad del sistema
* Un modulo debe ser cohesivo, con responsabilidades claras y bien definidas

## ¿Por que usar Modulos?
* Claridad y Organizacion: Ayudan a organizar grandes modelos de dominio en partes manejables
* Encapsulacion: Los modelos agrupan elementos relacionados y ocultan detalles innecesarios a otras partes del sistema
* Mantenibilidad: Facilitan la evolucion del sistema, permitiendo que los modulos cambien de manera independiente

## Diseño de Modulos
* Cohesion: Todos los elementos dentro de un modulo deben estar estrechamente relacionados con el dominio que el modulo representa
* Bajo Acoplamiento: Los modulos deben interactuar entre si a traves de interfaces bien definidas minimizando las dependencias
* Lenguaje Ubicuo: Cada modulo debe seguir el lenguaje ubicuo del contexto delimitado al que pertenece

## Modularidad en el Modelo del Dominio
* Los modulos en DDD se utilizan para organizar las entidades, objetos de valor, agregados, repositorios y servicios de dominio en agrupaciones logicas
* Permiten que los desarrolladores se enfoquen en partes especificas del dominio sin verse abrumados por la complejidad global del sistema

## Modulos en un Sistema de e-commerce
* Modulo Pedidos:
    - Contiene entidades como Pedido, Linea de Pedido, y servicios relacionados con la gestion de pedidos
* Modulo Inventario:
    - Agrupa la logica relacionada con la gestion del inventario, como las entidades Producto, Almacen, y servicios del inventario
* Modulo Pagos:
    - Maneja todo relacionado con el procesamiento de pagos, como Pago, Metodo de Pago, y servicios de validacion de transacciones

## Buenas practicas de Modularidad
* Agrupar por Dominio de Negocio: Organiza los modulos segun los conceptos de negocio, no por aspecto tecnicos
* Evitar Dependencias Ciclicas: Los modulos no deben depender unos de otros en un ciclo. Mantener las dependencias claras y dirigidas
* Interfaces Claras: Define contratos claros entre los modulos para que interactuen sin necesidad de conocer detaller internos

## Relacion entre Modulos y Contextos Delimitados
* Los Bounded Contexts pueden contener varios modulos agrupando conceptos mas especificos dentro del contexto general del dominio
* Cada modulo dentro de un contexto debe:
    - Respetar los limites del contexto delimitado
    - Seguir el lenguaje ubicuo definido por el contexto
* El uso correcto de modulos dentro de contextos facilita la escala del sistema y reduce la complejidad global

## Modularidad y Escalabilidad
* La modularidad permite
    - Evolucion Independiente: Los modulos pueden evolucionar sin afectar a otras partes del sistema
    - Pruebas Unitarias: Facilita las pruebas y validacion de cada parte de manera independiente
    - Distribucion: En arquitecturas distribuidas, los modulos bien definidos pueden convertirse facilmente en microservicios

# Modulo 6

# Modulo 7

## Motivacion
* Desafio en software empresarial de larga duracion: Evolución constante debido a cambios en los Requisitos
* Importancia de la arquitectura y el diseño: Facilita la compresion del sistema y su modificacion
* Brecha entre diseño arquitectonico y codigo: La Implementación dispersa de conceptos arquitectonicos puede llevar a un aumento de la complejidad y errores

## Solucion Propuesta
* _jMolecules:_ Un enfoque que permite a los desarrolladores expresar explicitamente patrones arquitectonicos en el codigo a traves de anotaciones e interfaces en Java
* Beneficios:
    - Comprensibilidad: El codigo refleja mejor los conceptos arquitectonicos
    - Documentacion precisa: Generada automaticamente desde el codigo
    - Verificacion de reglas: Asegura conformidad con los conceptos de diseño
    - Reduccion de codigo boilerplate: Automatiza detalles tecnicos (p. ej., mapeo de persistencia)

## Conceptos Arquitectonicos
* Bloques de construccion de DDD:
    - Agregados
    - Entidades
    - Repositorios
* Estilos arquitectonicos soportados:
    - Arquitectura en capas
    - Arquitectura onion
    - CQRS (Common Query Responsability Segregation)
    - Hexagonal
* Anotaciones y tipos en jMolecules: Conectar codigo y arquitectura

## Arquitectura Limpia y jMolecules
* jMolecules se alinea con Clean Architecture y DDD, entre otras...
* Facilita la separacion clara de capas y responsabilidades
* Ofrece componentes clave: Agregados, Entidades, Value Objects, Repositorios

## Implementación de un Pedido (Order)
* Desventaja tradicional: Codigo lleno de detalles tecnicos (JPA, JSON, etc)
* Ventaja jMolecules: Elimina el codiog tecnico, dejando solo la logica de dominio

```java
@AggregateRoot
class Order {
    @Entity
    class LineItem { ... }
    @AggregateRoot
    class Customer { ... }
}
```

## Herramientas de Verificacion
* ArchUnit y jQAssistant:
    - Verifican que la implementacion respeten las reglas arquitectonicas del modelo
    - Evitan errores en la proyeccion del diseño en el codigo

## Documentación Automatica
* Generacion de diagramas UML y Canvas del Modulo:
    - Basados en metadatos arquitectonicos presentes en el codigo
    - Correctos por definicion, ya que se derivan directamente del codigo

## Reduccion de Biolerplate
* Implementación tradicional:
    - Anotaciones JPA y otras dependencias tecnicas
* Con jMolecules:
    - El codigo es mas limpio y directo manteniendo la semantica arquitectonica explicita






