# proyecto-base-spring-boot
Proyecto de referencia para construir aplicaciones Spring Boot. La siguiente es una imagen que muestra la arquitectura del componente y un resumen de las capas y su dependencia entre si.

![Arquitectura base](https://github.com/gotorresevo/proyecto-base-spring-boot/raw/master/assets/ArquitecturaProyectoBase.png "Arquitectura base de una aplicacion orientada al dominio de evobanco")

### Diagrama de secuencia de la arquitectura
![Diagrama de secuencia de la Arquitectura base](https://github.com/gotorresevo/proyecto-base-spring-boot/raw/master/assets/SequenceArquitecturaBase.png "Diagrama de secuencia de la arquitectura")

### Diagrama de casos de uso del ejemplo base
![Diagrama de casos de uso del ejemplo base](https://github.com/gotorresevo/proyecto-base-spring-boot/raw/master/assets/UsesCases.png "Diagrama de caso de uso del ejemplo base")

## Cobertura de las pruebas unitarias del componente
![Cobertura de las pruebas](https://github.com/gotorresevo/proyecto-base-spring-boot/raw/master/assets/ComponentTest.png "Cobertura de las pruebas")

## Cobertura del caso de uso
Cubre las capas de:  application, usecases y Domain. Para esta cobertura se propone Mockear los objetos de tipo "IRepository" y "IEventBus". La intension de esta cobertura es validar que el caso de uso cumple con los requisitos del negocio.

## Cobertura del Controlador
Cubre las capas de:  controllers, application, usecases y Domain. Para esta cobertura se propone Mockear los objetos de tipo "IRepository" y "IEventBus". La intension de esta cobertura es validar que el controlador reciba y retorne lo especificado en el Open Api Specification (Swagger).  

### Enlaces de interes

[Inicio](https://github.com/gotorresevo/proyecto-base-spring-boot)  
[Ver como se implemento el modulo Shopping](https://github.com/gotorresevo/proyecto-base-spring-boot/tree/master/src/main/java/com/evobank/shopping)  
[Ver como se implemento el submodulo CARTS del modulo Shopping](https://github.com/gotorresevo/proyecto-base-spring-boot/tree/master/src/main/java/com/evobank/shopping/submodules/carts)  
[Ver como se implemento las pruebas unitarias del Controlador para CREAR CARRITO](https://github.com/gotorresevo/proyecto-base-spring-boot/tree/master/src/test/java/com/evobank/shopping/controllers)  
[Ver como se implemento las pruebas unitarias del caso de uso CREAR CARRITO](https://github.com/gotorresevo/proyecto-base-spring-boot/tree/master/src/test/java/com/evobank/shopping/submodules)  
[Configuracion de Sonar en local](https://github.com/gotorresevo/proyecto-base-spring-boot/tree/master/sonarqube)  