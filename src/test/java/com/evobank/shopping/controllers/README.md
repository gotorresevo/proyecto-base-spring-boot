# Test Controllers
Cubre las capas de:  controllers, application, usecases y Domain. Para esta cobertura se propone Mockear los objetos de tipo "IRepository" y "IEventBus". La intension de esta cobertura es validar que el controlador reciba y retorne lo especificado en el Open Api Specification (Swagger).  
![Cobertura de las pruebas](https://github.com/gotorresevo/proyecto-base-spring-boot/raw/master/assets/ComponentTest.png "Cobertura de las pruebas")

### Cobertura del CartPutController: Crear Carrito
![Cobertura de crear carrito](https://github.com/gotorresevo/proyecto-base-spring-boot/raw/master/assets/TestCartPutController.png "Diagrama de secuencia de la arquitectura, mostrando la cobertura de pruebas")



### Enlaces de interes
[Ver como se implemento el modulo Shopping](https://github.com/gotorresevo/proyecto-base-spring-boot/tree/master/src/main/java/com/evobank/shopping)  
[Ver como se implemento el submodulo CARTS del modulo Shopping](https://github.com/gotorresevo/proyecto-base-spring-boot/tree/master/src/main/java/com/evobank/shopping/submodules/carts)  
[Configuracion de Sonar en local](https://github.com/gotorresevo/proyecto-base-spring-boot/tree/master/sonarqube)  