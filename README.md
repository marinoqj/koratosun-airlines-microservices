# KoratoSun Airlines

This is a demo app built with microservices architecture. It uses different patterns and technologies.The components are the following:

* Services. They exposes the main funcionality through a REST API. We find customers and flights services.
* Config Server. This component represents a central point which holds the configuration of the others
* Discovery Server. It is a component which discovers and registers other components easing communications between them.
* Api-gateway. Commonly used in microservices, this component represents the entry point for using REST API endpoints.
* Web front. The UI is built with a Java/Thymeleaf

Besides that, there is a Kafka server which enables communication using messages.


Prerrequisitos

* MySQL
* Servidor Kafka : Contenedor docker de la imagen apache/kafka. Se arranca en localhost:9092 (habría que configurarla para que acepte llamadas por IP).Para configurarlo se utiliza la herramienta web Kadeck
* Repositorio Git para almacenar la configuración

Componentes

* config-server (8888): se utiliza para cargar la configuración del resto de microservicios
* api-gateway (8080): es la pasarela que une los el front con los microservicios
* discovery-server (8761): servidor eureka que registra todos los microservicios y permite el acceso transparente a los mismos
* customers-service (8091): microservicio que gestiona los clientes
* flights-service (8090): microservicio que gestiona los vuelos
* webfrontboot (8877): aplicación spring boot con thymeleaf y bootstrap que aporta la UI de la app
* servidor kafka (9092): a través del topic "customers" se gestiona el alta de un nuevo cliente cuando se produce una reserva
