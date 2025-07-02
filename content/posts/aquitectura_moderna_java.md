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



