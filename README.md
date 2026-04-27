\# Simple Expense Tracker



A beginner-friendly Spring Boot web application for tracking daily expenses.  

The system allows users to add, view, and delete expenses using a Thymeleaf interface connected to a MySQL 8 database.



\## Features



\- Add new expenses

\- View all expenses in a table

\- Delete expenses

\- Store data in MySQL

\- Auto-create database tables using Spring Data JPA

\- Clean Thymeleaf user interface



\## Technologies Used



\- Java 17

\- Spring Boot

\- Spring Web

\- Spring Data JPA

\- Thymeleaf

\- MySQL 8

\- Maven

\- Git and GitHub



\## Project Structure



```text

src/main/java/com/example/expense\_tracker/

&#x20;├── controller/

&#x20;│   └── ExpenseController.java

&#x20;├── model/

&#x20;│   └── Expense.java

&#x20;├── repository/

&#x20;│   └── ExpenseRepository.java

&#x20;├── service/

&#x20;│   └── ExpenseService.java

&#x20;└── ExpenseTrackerApplication.java



src/main/resources/

&#x20;├── templates/

&#x20;│   └── index.html

&#x20;├── static/css/

&#x20;│   └── style.css

&#x20;└── application.properties

