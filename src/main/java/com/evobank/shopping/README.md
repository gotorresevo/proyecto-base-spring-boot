# Modulo Shooping
Estructura de paquetes del Modulo. 
El modulo puede dividirse en varios submodulos si asi se ve pertinente. Si fuera el caso, cada modulo cumpliria con la arquitectura de manera independiente donde la comunicacion entre submodulos se debe realizar de manera desacoplada, por tal motivo se desacopla, sacando aquellos fuentes de un submodulo que usa otro submodulos al paquete shared.

### Diagrama de caso de uso del modulo vs Submodulos
![Diagrama de casos de uso del modulo](https://github.com/gotorresevo/proyecto-base-spring-boot/raw/master/assets/UseCasesBySubmodules.png "Diagrama de casos de usos vs submodulos")

### Diagrama de paquetes del modulo
![Diagrama de paquetes del modulo](https://github.com/gotorresevo/proyecto-base-spring-boot/raw/master/assets/ModuloShopping.png "Description del modulo describiendo los submodulos")

### Diagrama de secuencia Completo del caso de uso: Crear Carrito
![Diagrama de secuencia completo de CREAR CARRITO](https://github.com/gotorresevo/proyecto-base-spring-boot/raw/master/assets/SequenceArchitectureFullFlowCreateCarts.png "Flujo completo desde el llamado al controlador hasta el dominio")

### Enlaces de interes

[Inicio](https://github.com/gotorresevo/proyecto-base-spring-boot)  
[Ver como se implemento el modulo Shopping](https://github.com/gotorresevo/proyecto-base-spring-boot/tree/master/src/main/java/com/evobank/shopping)  
[Ver como se implemento el submodulo CARTS del modulo Shopping](https://github.com/gotorresevo/proyecto-base-spring-boot/tree/master/src/main/java/com/evobank/shopping/submodules/carts)  
[Ver como se implemento las pruebas unitarias del Controlador para CREAR CARRITO](https://github.com/gotorresevo/proyecto-base-spring-boot/tree/master/src/test/java/com/evobank/shopping/controllers)  
[Ver como se implemento las pruebas unitarias del caso de uso CREAR CARRITO](https://github.com/gotorresevo/proyecto-base-spring-boot/tree/master/src/test/java/com/evobank/shopping/submodules)  
[Configuracion de Sonar en local](https://github.com/gotorresevo/proyecto-base-spring-boot/tree/master/sonarqube)  