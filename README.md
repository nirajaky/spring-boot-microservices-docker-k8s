# spring-boot-microservices-docker-k8s

## What is Spring Framework
- It has so many module support.
- For Web Application, Spring MVC was used.
- For Batch processing, Spring Batch was used.

- There was lot configuration needed like bean configuration, ORM configuration.
  This all problems got resolved by Spring Boot as it gives us the Production Ready appplication.
  Spring Boot is abstraction of Spring Framework. Means it is build on the top of Spring Framework.

## Dependency Injection
- In Spring Boot we can create the class and its respective object is provided to Spring Framework, that's 
  why we call it as Spring IOC Container means control is in Spring Framework rather that developers. 
  This all object creation happens during runtime and being handled by JVM.

## Spring Initilizer
- To setup our Spring Boot Application
- Jar Packaging helps us to create an standalone application with embedded server (Tomcat Server)
- War packaging is specially designed to pack Web Applications with Servlets and JSPs. In war packaging we need to
  manually deploy of application.

## War vs Jar
- In war file packaging, we create our application and deploy it into these one of the servers: tomcat, jboss, weblogic.
- In Spring Boot = Application + Server all are contained in a single Jar file. We just need to run this Jar file.
- In Spring Boot, these all embedded servers are present: Tomcat(default), Jetty, Undertom.
- To use Jetty as Embedded Server, We need to configure in pom.xml file. Ex. Shown in pom.xml of spring-boot-demo.

### We have a plugin - "maven helper" which is used to manage our dependencies to exclude or include any
### sub dependiesncies

## spring-boot-starter-parent
- This is the default dependency that an Spring Boot application injects. 
- It is the combination of multiple dependency and is bundled in a module.
- Which is called in every Spring Boot Appllication in our pom.xml file inside <parent></parent> tag.
- Basically, all the dependencies with "spring-boot-starter" have a bundle of sub dependencies.
- We can have our own starter dependencies.

## RESTful Web Services
- RESTful Web Services is a web services that follows the standard protocol defined to create our Web services.
- So, that any kind of server(python, java, node etc.) can communicate to that service using standard protocol.
- Different Protocol for RESTful services are :
  * HTTP Methods are used to communicate the server like - GET, POST, PUT, DELETE etc.
    * Where as SOAP uses HTTP, SMTP, TCP, etc. protocol to trasport data.
  * Response body is structured in these formats - JSON, xml, simple text etc.
    * Where as in SOAP only xml formart is used as reponse
  * Similary request body is asked before updating any resources.

## AOP - Aspect oriented programming
- In this concept, we handle all the concern(Like Exception) of Controller in separate class,
- As Controller has to process a lot of other things.
- For this we need to use @ControllerAdvice

- By default Json Jackson dependencies is integrated in Spring Boot.
- To use xml format we need to add jackson-dataformat-xml dependencies and configure
  it globally or at individual endpoints.

### @ControllerAdvice - will handle all the Exception to Controller
### @ExceptionHandler - This is method level annotation which will trigger, When the parameter's Exception class is thrown.

## @Qualifier
- When we have multiple beans of the same type, and we need to specify which one
- should be autowired into a specific field, we use the @Qualifier annotation
- along with the @Autowired annotation. This is useful when you have different
- implementations of an interface or different configurations of a class.

## @Builder
- It is part of lombok dependencies, through ehich we can create Entitity Object without calling or invoking all the fields.

