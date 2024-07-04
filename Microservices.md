# Microservices

## What is Monolithic Services
- Earlier before microservices, monolithic application was build.
- In Monolitic there is single codebase for our entire application.
- If we make any changes in one module then entire application has to be deployed.
- Single Tech Stack is used.

## What is Microservices
- An application is divided into seperate individual deployeable application.
- We can connect the services using any protocol.
- We can scale only that module which we want.
- To maintain microservices as we have multiples of microservices for one application, we need monitering tool.
- Microservices can be stored in two ways :
  * Monorepo: Single repository holds multiple microservices of our application.
    > Issues with monorepo is creating CI-CD pipeline. We need to configure it in such a way that only particular service   changes should be triggered where there is changes and rest other services are ignored for Building and deploying.
  * Polyrepo: Each microservices are having its own repo.
    > Issues is we need to clone indidually all the microservices and look around each microservices at different place for any changes.
- Multiple Tech Stack can be used.

- We can connect the microservices using these ways :
  * HTTP Protocol , Like REST API to communicate between the microservices > Synchronous Connection
  * Messageing System like Brokers                                         > Asynchronous Connection

