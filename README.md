# Book store Application

This is a Spring Boot application Implement a RESTful API for a simple online bookstore using Spring and Hibernate.
 The API should allow users to perform CRUD operations on books, authors, and genres.
 Books should have a title, author, genre, price, and quantity available. Users should be able to search for books by title, author, or genre. 
Use Hibernate to persist data to a relational database.

## Features

- CRUD operations with Books, Genres, Authors

## Prerequisites

Before running the application, make sure you have the following prerequisites installed on your system:

- Java 17 or higher
- MySQL database server

## Setup

1. Clone the repository: 
	https://github.com/Zenyk-L/BookStore.git

2. Update the database configuration in `src/main/resources/application.properties` with your PostgreSQL database settings:

spring.datasource.url=jdbc:mysql://localhost:3306/bookstore_db
spring.datasource.username=your_username
spring.datasource.password=your_password

## Running the Application

1. Start the MySQL database server.

2. Run the application:

   The application should now be accessible at `http://localhost:8080`.

## API Endpoints

Books:
- Get all: GET http://localhost:8080/api/books
- Create: POST http://localhost:8080/api/books
- Updatel: PUT http://localhost:8080/api/books/{id}
- Delete: DELETE http://localhost:8080/api/books/{id}
- SearchBooks: PUT http://localhost:8080/api/books/searchBooks

Author:
- Get all: GET http://localhost:8080/api/authors
- Create: POST http://localhost:8080/api/authors
- Updatel: PUT http://localhost:8080/api/authors/{id}
- Delete: DELETE http://localhost:8080/api/authors/{id}

Genre:
- Get all: GET http://localhost:8080/api/genre
- Create: POST http://localhost:8080/api/genre
- Updatel: PUT http://localhost:8080/api/genre/{id}
- Delete: DELETE http://localhost:8080/api/genre/{id}

## Usage

You can use a tool like Postman to interact with the API endpoints and manage product items. 

###  Feedback

- Was it easy to complete the task using AI? 

Yes it was easier to complete the task using AI, because it generate for you almost ready code.
It was needed only add some simple things like getter and setter. 

- How long did task take you to complete? (Please be honest, we need it to gather anonymized statistics) 

About 4 hours.

- Was the code ready to run after generation? What did you have to change to make it usable?

It was has a lot of misunderstanding between classes.

- Which challenges did you face during completion of the task?

It was a little hard to build proper prompt to get ready code after one request.
 Some times if I try to build clarifying prompts in answer was not matched types

- Which specific prompts you learned as a good practice to complete the task?

Tried to build prompts as much detailed with more terminology.




