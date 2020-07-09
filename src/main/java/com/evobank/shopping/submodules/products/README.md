# Submodulo PRODUCTS
### Diagrama de caso de uso del submodulo
![Diagrama de casos de uso del submodulo carts](https://github.com/gotorresevo/proyecto-base-spring-boot/raw/camunda/assets/UseCasesSubmoduleProducts.png "Diagrama de casos del submodulo products")

### Arquitectura
![Arquitectura del submodulo](https://github.com/gotorresevo/proyecto-base-spring-boot/raw/camunda/assets/ArquitecturaComponentBpm.png "Arquitectura del submodulo con BPM")

### Diagrama de secuencia: Actualizar Stock
![Diagrama de secuencia CREAR CARRITO](https://github.com/gotorresevo/proyecto-base-spring-boot/raw/camunda/assets/SequenceArchitectureUpdateStock.png "Flujo completo desde la captura del evento hasta la ejecucion de proceso y los casos de usos")

Los objetos resaltados en AMARILLO estan definidos en el diagrama como interfaces JAVA, ya que mediante la capacidad de SPRING de "Inversion de Dependencias" se inyectan sus implementaciones. Para el caso de "ICartsRepository" Dicha implementación esta ubicada en el paquete "infrastructure".  

Para "ICommandBus" su implementación "com.evobank.shopping.infrastructure.bus.command.InMemoryCommandBus"  
Para "IQueryBus" su implementación "com.evobank.shopping.infrastructure.bus.query.InMemoryQueryBus"  
Para "IEventBus" su implementacion "com.evobank.shopping.infrastructure.bus.event.SpringApplicationIEventBus"  

### Enlaces de interes

[Inicio](https://github.com/gotorresevo/proyecto-base-spring-boot)  
[Ver como se implemento el modulo Shopping](https://github.com/gotorresevo/proyecto-base-spring-boot/tree/camunda/src/main/java/com/evobank/shopping)  
[Ver como se implemento el submodulo CARTS del modulo Shopping](https://github.com/gotorresevo/proyecto-base-spring-boot/tree/camunda/src/main/java/com/evobank/shopping/submodules/carts)  
[Ver como se implemento las pruebas unitarias del Controlador para CREAR CARRITO](https://github.com/gotorresevo/proyecto-base-spring-boot/tree/camunda/src/test/java/com/evobank/shopping/controllers)  
[Ver como se implemento las pruebas unitarias del caso de uso CREAR CARRITO](https://github.com/gotorresevo/proyecto-base-spring-boot/tree/camunda/src/test/java/com/evobank/shopping/submodules)  
[Configuracion de Sonar en local](https://github.com/gotorresevo/proyecto-base-spring-boot/tree/camunda/sonarqube)  