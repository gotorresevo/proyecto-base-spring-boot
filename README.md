# proyecto-base-spring-boot
Proyecto de referencia para construir aplicaciones Spring Boot. La siguiente es una imagen que muestra la arquitectura del componente y un resumen de las capas y su dependencia entre si.

![Arquitectura base](https://github.com/gotorresevo/proyecto-base-spring-boot/raw/camunda/assets/ArquitecturaProyectoBase.png "Arquitectura base de una aplicacion orientada al dominio de evobanco")
##### INFRAESTRUCURA
Es la encargada de implementar aquellas funcionalidades que implique utilizar librerias de terceros. Por ejemplo, Implementaciones para la persistencia, implementacion de las tareas de un motor BPM.

##### APLICACION
Es la encargada de intermediar entre lo externo (Controladores) y la logica de negocio (Procesos de Negocio, Casos de Uso y Dominio).

##### PROCESOS DE NEGOCIO
Es la encargada de ejecutar procesos de negocio mediante algun motor de BPM, por ejemplo CAMUNDA.
Esta capa es necesaria siempre y cuando se requiera un motor de BPM. 
Las tareas que ejecute el motor BPM tendrian una relacion de uno a uno con los casos de usos, 
es decir, una tarea debe tener un fin y es ejecutar un caso de uso.

##### CASOS DE USO
Es la encargada de tener lo mas atomica posible las funcionalidades de la solucion. En caso de utilizar

##### DOMINIO
Es la encargada de mantener el estado de la solucion segun el dominio del negocio.

### Diagrama de secuencia de la arquitectura Base
El siguiente diagrama nos muestra las capas y el flujo de ejecucion entre los tipos de objetos que intervienen en la arquitectura base.
![Diagrama de secuencia de la Arquitectura base](https://github.com/gotorresevo/proyecto-base-spring-boot/raw/camunda/assets/SequenceArquitecturaBase.png "Diagrama de secuencia de la arquitectura")
###### Objeto: @RestController 
Este objeto esta encargado de recibir peticiones HTTP
###### Objeto: ICommand 
Encargado de ejecutar funcionalidad que afecta el estado de la solucion
###### Objeto: IQuery 
Encargado de ejecutar funcionalidad de consulta
###### Objetos: ICommandBus y IQueryBus
Son los encargados de identificar el Handler correspondiente a la funcionalidad solicitada y ejecutarlo
###### Objetos: ICommandHandler y IQueryHandler
Son los encargado de ejecutar la logica del negocio ya sea mediante un "Proceso de Negocio" ó un "Caso de Uso".
###### Objeto: IValueObject
Son instancias de valores encargadas de aplicar todas las validaciones necesarias para cumplir con el dominio del negocio del valor que estan contienen.
###### Objeto: @BusinessProcess
Este objeto esta encargado de ejecutar un proceso de negocio, modelado mediante un motor de BPM.
###### Objeto: IBpmEngine
Este objeto esta encargado de administrar el motor de BPM que se este utilizando.
###### Objeto: @Task
Es la instancia de una tarea que se ejecutará cuando un proceso de negocio se este ejecutando.
###### Objeto: @CaseOfUse
Es la instancia de un caso de uso.
###### Objeto: @Factory
El instancia encargada de instaciar los "AgregateRoot" ejecutando las validaciones de sus IValueObject
###### Objeto: AgregateRoot
Es la instancia que representa el dominio del negocio, encargada del estado de la aplicacion
###### Objeto: IValidator
Es la instancia de las que se valen los IValueObject para hacer las consultas necesarias con el fin de cumplir con sus validaciones
###### Objeto: IRepository
Es la instancia encargada de persistir el "AgregateRoot".
###### Objeto: IEventBus
Es la instancia encargada de publicar el evento ocurrido al ejecutarse el caso de uso.


#### Diagrama de secuencia de la arquitectura sin la capa de "Procesos de Negocio"
El siguiente diagrama nos muestra las capas y el flujo de ejecucion entre los tipos de objetos que intervienen en la arquitectura para un escenario en donde no es necesaria la capa de "Procesos de negocio".
![Diagrama de secuencia de la Arquitectura base Sin BPM](https://github.com/gotorresevo/proyecto-base-spring-boot/raw/camunda/assets/SequenceArquitecturaBaseSinBpm.png "Diagrama de secuencia de la arquitectura Sin Bpm")

#### Diagrama de secuencia de la arquitectura capturando un evento
El siguiente diagrama nos muestra las capas y el flujo de ejecucion entre los tipos de objetos que intervienen en la arquitectura donde el flujo iniciar a partir de la captura de un evento de dominio.
![Diagrama de secuencia de la Arquitectura Capturando Evento Bpm](https://github.com/gotorresevo/proyecto-base-spring-boot/raw/camunda/assets/SequenceArquitecturaEventDomainBpm.png "Diagrama de secuencia de la arquitectura capturando Evento con Bpm")

#### Diagrama de secuencia de la arquitectura capturando un evento sin la capa de "Procesos de Negocio"
El siguiente diagrama nos muestra las capas y el flujo de ejecucion entre los tipos de objetos que intervienen en la arquitectura donde el flujo iniciar a partir de la captura de un evento de dominio pero no es necesaria la capa de "Procesos de Negocio".
![Diagrama de secuencia de la Arquitectura Capturando Evento](https://github.com/gotorresevo/proyecto-base-spring-boot/raw/camunda/assets/SequenceArquitecturaEventDomain.png "Diagrama de secuencia de la arquitectura capturando Evento")

### Cobertura de las pruebas unitarias del componente Base
![Cobertura de las pruebas](https://github.com/gotorresevo/proyecto-base-spring-boot/raw/camunda/assets/ComponentTest.png "Cobertura de las pruebas")

##### Cobertura de las pruebas unitarias del componente sin la capa de "Procesos de Negocio"
![Cobertura de las pruebas Sin Bpm](https://github.com/gotorresevo/proyecto-base-spring-boot/raw/camunda/assets/ComponentTestWithoutBpm.png "Cobertura de las pruebas Sin Bpm")

##### Cobertura de las pruebas unitarias del componente capturando evento
![Cobertura de las pruebas capturando Evento Bpm](https://github.com/gotorresevo/proyecto-base-spring-boot/raw/camunda/assets/ComponentTestEventDomainBpm.png "Cobertura de las pruebas campturando Evento con Bpm")

##### Cobertura de las pruebas unitarias del componente capturando evento sin la capa de "Procesos de Negocio"
![Cobertura de las pruebas capturando Evento](https://github.com/gotorresevo/proyecto-base-spring-boot/raw/camunda/assets/ComponentTestEventDomain.png "Cobertura de las pruebas campturando Evento")

## Cobertura del caso de uso
Cubre las capas de:  Application, Business Process, Use Cases y Domain. Para esta cobertura se propone Mockear los objetos de tipo "IRepository" y "IEventBus". La intension de esta cobertura es validar que el caso de uso cumple con los requisitos del negocio.

## Cobertura del Controlador
Cubre las capas de:  Controllers, Application, Business Process, Use Cases y Domain. Para esta cobertura se propone Mockear los objetos de tipo "IRepository" y "IEventBus". La intension de esta cobertura es validar que el controlador reciba y retorne lo especificado en el Open Api Specification (Swagger).  

### Enlaces de interes

[Inicio](https://github.com/gotorresevo/proyecto-base-spring-boot)  
[Ver como se implemento el modulo Shopping](https://github.com/gotorresevo/proyecto-base-spring-boot/tree/camunda/src/main/java/com/evobank/shopping)  
[Ver como se implemento el submodulo CARTS del modulo Shopping](https://github.com/gotorresevo/proyecto-base-spring-boot/tree/camunda/src/main/java/com/evobank/shopping/submodules/carts)  
[Ver como se implemento las pruebas unitarias del Controlador para CREAR CARRITO](https://github.com/gotorresevo/proyecto-base-spring-boot/tree/camunda/src/test/java/com/evobank/shopping/controllers)  
[Ver como se implemento las pruebas unitarias del caso de uso CREAR CARRITO](https://github.com/gotorresevo/proyecto-base-spring-boot/tree/camunda/src/test/java/com/evobank/shopping/submodules)  
[Ver como se implemento el submodulo PRODUCTS del modulo Shopping](https://github.com/gotorresevo/proyecto-base-spring-boot/tree/camunda/src/main/java/com/evobank/shopping/submodules/products)  
[Configuracion de Sonar en local](https://github.com/gotorresevo/proyecto-base-spring-boot/tree/camunda/sonarqube)  