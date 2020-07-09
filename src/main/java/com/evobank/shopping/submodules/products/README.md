# Submodulo PRODUCTS
### Diagrama de caso de uso del modulo
![Diagrama de casos de uso del submodulo carts](https://github.com/gotorresevo/proyecto-base-spring-boot/raw/master/assets/UseCasesSubmoduleCarts.png "Diagrama de casos del submodulo carts")

### Arquitectura
![Arquitectura del submodulo](https://github.com/gotorresevo/proyecto-base-spring-boot/raw/master/assets/ArquitecturaComponent.png "Arquitectura del submodulo")

### Diagrama de secuencia: Crear Carrito
![Diagrama de secuencia CREAR CARRITO](https://github.com/gotorresevo/proyecto-base-spring-boot/raw/master/assets/SequenceArchitectureCreateCart.png "Flujo completo desde el llamado al command hasta la publicacion del evento")

Los objetos resaltados en AMARILLO estan definidos en el diagrama como interfaces JAVA, ya que mediante la capacidad de SPRING de "Inversion de Dependencias" se inyectan sus implementaciones. Para el caso de "ICartsRepository" Dicha implementación esta ubicada en el paquete "infrastructure".  

Para "ICommandBus" su implementación "com.evobank.shopping.infrastructure.bus.command.InMemoryCommandBus"  
Para "IQueryBus" su implementación "com.evobank.shopping.infrastructure.bus.query.InMemoryQueryBus"  
Para "IEventBus" su implementacion "com.evobank.shopping.infrastructure.bus.event.SpringApplicationIEventBus"  

### Enlaces de interes

[Inicio](https://github.com/gotorresevo/proyecto-base-spring-boot)  
[Ver como se implemento el modulo Shopping](https://github.com/gotorresevo/proyecto-base-spring-boot/tree/master/src/main/java/com/evobank/shopping)  
[Ver como se implemento el submodulo CARTS del modulo Shopping](https://github.com/gotorresevo/proyecto-base-spring-boot/tree/master/src/main/java/com/evobank/shopping/submodules/carts)  
[Ver como se implemento las pruebas unitarias del Controlador para CREAR CARRITO](https://github.com/gotorresevo/proyecto-base-spring-boot/tree/master/src/test/java/com/evobank/shopping/controllers)  
[Ver como se implemento las pruebas unitarias del caso de uso CREAR CARRITO](https://github.com/gotorresevo/proyecto-base-spring-boot/tree/master/src/test/java/com/evobank/shopping/submodules)  
[Configuracion de Sonar en local](https://github.com/gotorresevo/proyecto-base-spring-boot/tree/master/sonarqube)  