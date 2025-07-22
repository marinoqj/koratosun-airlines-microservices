# KoratoSun Airlines

This is a demo app built with microservices architecture. It uses different patterns and technologies.The components are the following:

* Services. They exposes the main funcionality through a REST API. We find customers and flights services.
* Config Server. This component represents a central point which holds the configuration of the others
* Discovery Server. It is a component which discovers and registers other components easing communications between them.
* Api-gateway. Commonly used in microservices, this component represents the entry point for using REST API endpoints.
* Web front. The UI is built with a Java/Thymeleaf

Besides that, there is a Kafka server which enables communication using messages.


Prerrequisites

* MySQL datbase
* Kafka server: For demo purpose the app is using a docker container from image apache/kafka. It is listening on localhost:9092 (configuration to accept calls using kafka's server IP is needed).To config kafka we are using Kadeck web tool.
* Git repository to use CasC (Configuration as Code)

Components

* config-server (8888): centralized configuration of all the microservices that make up the application
* api-gateway (8080): entry point acting as an intermediary between client and microservices
* discovery-server (8761): enables microservices to dynamically locate and communicate with each other within the application
* customers-service (8091): microservice that manages clients
* flights-service (8090): microservice that manages flights
* webfrontboot (8877): spring boot application with Thymeleaf and Bootstrap that provides the app's UI
* servidor kafka (9092): through the "customers" topic, the registration of a new customer is managed when a reservation is made.

Description

When app is running you can access to a web simulating an airline page for booking flights and buying tickets. If a new user make a reservation all the information about it is saved and at the same time an event is triggered with the customer data. These data can be used for differents microservices with different purposes like marketing, loyalty programs and more.