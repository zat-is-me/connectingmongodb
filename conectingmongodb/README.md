# Connecting MongoDB to Spring Boot App

- Add MongoDb dependency to spring boot application

  	<dependency>
  		<groupId>org.springframework.boot</groupId>
  		<artifactId>spring-boot-starter-data-mongodb</artifactId>
  	</dependency>

  - Put these annotations at the top of Entity class
  - 
        @Document(collection = "docmentName")
        @Component
 - Extend the repository from

        MongoRepository<EntityClassName, IdType>
- Finally, the following annotation at the main method class

        @EnableMongoRepositories