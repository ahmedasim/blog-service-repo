# Blog Service Assignment

**Description:**
This project is a simple Blog Management System developed using Spring Boot, Java 17, Hibernate, Spring Data JPA, and MySQL. It provides REST APIs for creating and fetching authors, as well as adding posts associated with authors. The system ensures all required validations are in place and the database tables are properly indexed for optimized performance. Additionally, unit tests are included to ensure code coverage and reliability.

**Technology Stack:**
- Spring Boot 3.3.0
- Java 17 **(Used Java 17 instead of Java 18 as there was some maven compatibility on my machiene, you can change to Java 18+ in pom.xml)**
- JUnit 5
- Maven
- Hibernate
- Spring Data JPA
- MySQL
- Flyway
- Swagger (spring doc open ui)
- Jacoco


**Instructions to Run the Project:**
1. Clone the repository from GitHub: **https://github.com/ahmedasim/blog-service**
2. Open the project in your preferred IDE (e.g., IntelliJ IDEA, Eclipse, SpringToolSuite).
3. Ensure you have Java 17+ installed on your machine.
4. Configure MySQL database settings in `application.yml` file located in `src/main/resources`.
   1. Create Database **blog-service** in MySQL. Change database name in application.yml if you are using different name.
   2. Change db user name and password in `application.yml`
   3. Default port of database in **7000**. Configure as per your db port in yml file.
6. Build the project using Maven: `mvn clean install`.
7. Run the application: `mvn spring-boot:run`.
8. The application will start running on `localhost:9091`. 

**API Endpoints:**
    You can use also Swagger URL **(http://localhost:9091/swagger-ui/index.html)** for API Endpoints. 
  
   **Author Controller**  <br>
      - **Create Author**: POST /api/v1/authors <br>
      - **Update Author**: PUT /api/v1/authors/{authorId}  <br>
      - **Get Author By ID**: GET /api/v1/authors/{authorId}  <br>
      - **Delete Author**: DELETE /api/v1/authors/{authorId}  <br>
      - **Get All Authors**: GET /api/v1/authors  <br>  <br>
  
  **POST Controller**  <br>
      - **Create Post**: POST /api/v1/posts  <br>
      - **Update Post**: PUT /api/v1/posts/{postId}  <br>
      - **Get Post By ID**: GET /api/v1/posts/{postId}  <br>
      - **Delete Post**: DELETE /api/v1/posts/{postId}  <br>
      - **Get All Posts**: GET /api/v1/posts  <br>
      - **Get Posts By Author**: GET /api/v1/posts/author-posts/{authorId  <br>
      - **Get Author Deleted Posts**: GET /api/v1/posts/author-deleted-posts/{authorId}  <br>
      - **Get Author Active Posts**: GET /api/v1/posts/author-active-posts/{authorId}  <br>
    
   
**Scripts for Database Setup:**
- Create a script file named `V01__DB_SCHEMA.sql` containing SQL commands to create the necessary database schema and tables, as well as any required indexes.
- Provide sample data insertion scripts (`V01__DB_SCHEMA.sql`) to populate the database with initial data.
- Use Flyway for database migration script (resrouce/db/migration/V01__DB_SCHEMA.sql)

**Running Unit Tests:**
- Run unit tests using Maven: `mvn test` or right click on project and Run As `Maven Test` or `Junit Test`
- Check the test coverage report generated in the `target/site/jacoco/index.html` file.
      - Test Coverage is not **100%** Because of some getter and setter methods. It's **97%**    

**Project Repository:**
The project is hosted on GitHub: **https://github.com/ahmedasim/blog-service**

**Project Structure:**

blog-service/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── aa/
│   │   │           └── blog_service/
│   │   │               ├── BlogServiceApplication.java
│   │   │               ├── controller/
│   │   │               │   ├── AuthorController.java
│   │   │               │   └── PostController.java
│   │   │               ├── dto/
│   │   │               │   ├── AuthorRequestDto.java
│   │   │               │   ├── AuthorResponseDto.java
│   │   │               │   ├── PostRequestDto.java
│   │   │               │   ├── PostResponseDto.java
│   │   │               │   └── common/
│   │   │               │       ├── ApiError.java
│   │   │               │       └── ApiResponse.java
│   │   │               ├── entity/
│   │   │               │   ├── Author.java
│   │   │               │   └── Post.java
│   │   │               ├── exception/
│   │   │               │   └── GlobalExceptionHandler.java
│   │   │               ├── repo/
│   │   │               │   ├── AuthorRepo.java
│   │   │               │   └── PostRepo.java
│   │   │               ├── service/
│   │   │               │   ├── AuthorService.java
│   │   │               │   ├── PostService.java
│   │   │               │   └── impl/
│   │   │               │       ├── AuthorServiceImpl.java
│   │   │               │       └── PostServiceImpl.java
│   │   ├── resources/
│   │   │   ├── application.yml
│   │   │   └── db
│   │   │      └── migration
│   │   │        └── V01__DB_SCHEMA.sql
│   ├── test/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── aa/
│   │   │           └── blog_service/
│   │   │               ├── BlogServiceApplicationTests.java
│   │   │               ├── controller/
│   │   │               │   ├── AuthorControllerTest.java
│   │   │               │   └── PostControllerTest.java
│   │   │               ├── service/
│   │   │               │   ├── AuthorServiceImplTest.java
│   │   │               │   └── PostServiceImplTest.java
├── pom.xml
└── README.md

**Contributors:**
- Asim Ahmed

<b> Feel free to reach out for any further assistance or inquiries!
<br> Contact me :</b><br>
Linked in: <b>https://www.linkedin.com/in/ahmedasim01/</b> <br>
Email: <b>sendtoasimoff@gmail.com</b> <br>
Hacker Rank: <b>https://www.hackerrank.com/ahmedasim01</b> <br>
Medium: <b>https://medium.com/@ahmedasim01</b> <br>

