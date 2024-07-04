# Microservices Architechture

## What is Service Registory
- Service Registory is the database of microservices instance. It maintains the location and directory of all microservices.
- It basically maintains and shows all the microservices running and in failed state.
- Different service registory present are : Eureka Server, Zookeeper, Consul etc.
    * Basically all the microservices are registered at eureka server by providing its addresses and ports with an name.
    * All the registerd service(microservices or eureka client) gives its heartbeats continously to Service Registory (Eureka Server)
    * It helps to establish a communication between microservices(eureka client) with just name of service. The actual address and ports mapping to name is being handled by Eureka Server.
    * Also Service Registory has Load Balancer which automatically balances the traffic of querry in between services. As each Eureka Client can have multiple instance. Like we can create multiple payment-service instance at different servers IP. 

## Service Registory Creation:
- We need to create ServiceRegistory Application from Spring Initilizer
- Add necessary dependencies like :
    * Spring Cloud
    * Eureka Server
- Annotate our main class with : @EnableEurekaServer

## Registering Microservices with Eureka Server
- As of Spring Cloud Netflix version 2.2.0, you no longer need to explicitly use the @EnableDiscoveryClient annotation to   register your Spring Boot application as a Eureka client. The auto-configuration mechanism in Spring Boot and Spring Cloud handles this for you if the necessary dependencies are on the classpath.
- Only thing we need is :
    * Add dependency to pom.xml : spring-cloud-starter-netflix-eureka-client
    * Configuring in application.yaml file with Eureka Server URL and marking it as Eureka Client

### Since this Eureka Client configuration is repetative for all the microservices.
### We can create a config-server where we can keep all the common application.yaml configuration.
### This common .yaml data we can also segrigate to github repository and this config-server will fetch from gitgub.

## Create config-server
- Create a Spring Boot application with dependencies as :
    * config-server
    * eureka-client (so, that this services can also be traced from eureka server)
- Annotate main class with : @EnableConfigServer
- Add the necessary configuration to fetch the data from github repo's application.yaml.

## Configure services as Config-Client
- To make a service as config-client, we need to add the dependency: 
    * spring-cloud-starter-config
- And we need to specify our config-server in application.yaml file as ;
    *   config:
            import: configserver:http://localhost:9296 (CONFIG_SERVER_URL)

## Communication between microservices
- REST Template , Feign Client (Declarative REST Client)
- In REST Template we need to provide the method URI and Request Body of the API to call any API from one microservice to another.
- Whereas in Feign Client, we call API of one microservices from another microservices by providing the name of microservices (service registory handles the name of microservice and call the respective API of service just by the method name). In this approch, we have one benifit as - Even if we have multiple instances of same service, this service registory handles the load balancing for communication in between the services.

