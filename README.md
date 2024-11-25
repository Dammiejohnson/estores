# EStores

## Project Introduction

Estores is a Java Spring Boot application that demonstrates spring aspect oriented programming in an ecommerce project.

## Brief introduction on AOP terminologies

### Spring AOP
In the realm of software development, achieving clean and maintainable code often involves addressing cross-cutting concerns such as logging,
security, and transaction management. These concerns, which span multiple components of an application, 
can lead to code that is tangled and difficult to manage. 
Spring Aspect-Oriented Programming (AOP), a powerful feature of the Spring Framework that allows developers to modularize these concerns in a clean and elegant way. 
By using Spring AOP, you can separate business logic from system services, resulting in more modular and maintainable code.

### Key Concepts of Spring AOP

Aspect: A modularization of a concern that cuts across multiple classes. 
An aspect can be implemented using regular classes or annotations.

Join Point: A point during the execution of a program, such as the execution of a method or the handling of an exception.
In Spring AOP, a join point always represents a method execution.

Advice: Action taken by an aspect at a particular join point.
Different types of advice include:

Before advice: Executed before a join point.

After advice: Executed after a join point, regardless of its outcome.

After returning advice: Executed after a join point completes normally.

After throwing advice: Executed if a method exits by throwing an exception.

Around advice: Executed around a join point, allowing to control the method execution and the result.

Pointcut: A predicate that matches join points. A pointcut expression determines where advice should be applied.



## Getting Started

### Prerequisites

Ensure you have the following installed:

- [Java](https://www.java.com/) (version 17)
- [Your preferred IDE](https://www.jetbrains.com/idea/) (e.g., IntelliJ, Eclipse)

### AOP- Set Up

1. Add aop dependency to pom.xml file and reload the maven: Spring boot initializer may not have the dependency and this may be added 
   manually in the pom.xml file
        
        
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-aop</artifactId>
           </dependency>

2. Create a folder(aspect package) in the project package for all the aspects:


      This enables one to have all aspects in the same folder

3. Aspect Definition


         1. Create a Java class in the package and by convention,aspect classes have aspect suffices For Example
         LoggingAspect, AuditTrailAspect etc and this contains related advices of anm aspect

         2. Annotate the aspect class with @Aspect and @Component. @Aspect which enables the class to operate as an aspect utilizing 
            the methods from aspectj library. @Component enables Spring to run the class as a component within the spring context 

4. PointCut Expressions:

         This are expressions that indicate where an advice should be applied, it can be of different kinds but the most used 
         is the execution expression, annotation expression and they can be written just beside  any of the advices. For example;
         @Before("execution(* com.catalyst.estores.service.*.*(..))")
         
         execution(modifiers-pattern? return-type-pattern declaring-type-pattern? method-name-pattern(param-pattern) throws-pattern?)
         The ones with '?' means it can be optional while while the mandatory ones like return type can be written with a wild card as '*'



         

