# Spring Boot Course Repo
## Spring Boot Musix App using sql

1. master branch 
    1. Task 1: Complete all the endpoints for CRUD operations on Muzix
    2. Implemented using sql database
## Spring Boot Tasks
2. h2-console
      1. Task 2: Use h2-console to view in-memory data
3. query-annotation
    1.  Task 3: Add an endpoint to search trackByName. Understand @Query and parameter passing to
@Query
4. swagger-config 
    1. Task 4: Generate API documentation using Swagger 2

5. exception-handling
    1. Task 5: Create custom exceptions TrackNotFoundException, TrackAlreadyExistsException in a
com.stack....exceptions package. Perform appropriate exception handling and propagation
Back.
6. seed-data
    1. Task 6: Running Logic on Startup in Spring. Create seed data to pre-fill the database with track
information whenever the application starts. Use both approaches:
    Approach 1. ApplicationListener<ContextRefreshedEvent>
    Approach 2. CommandLineRunner (Find out how it differs from ApplicationRunner)

7. global-exception
      1. Task 7: Global exception using Controller advice
8. app-prop-new
      1. Task 8: Remove all hard coded data from the application code to application.properties
  a)by using @Value.
  b)by using @PropertySource
  c)by using Environment
(https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/core/env/
  Environment.html)
9. lombok
     1. Task 9: Add @Lombok
(https://drive.google.com/file/d/1QQpEQZbDD9pmW2qrhYsx5N9XYQ5bJ5dM/view)
## Mockito Test Cases task 
10. mockito-tests-new branch
      1. Spring musixapp for testcases in all 3 layers
## Musix app implementation using mongodb 
11. mongodb-new branch 
      1. Implemented using mongodb instead of mysql.
