# Enjoy Shared Meal

The main motivation of this project is to reduce food waste and encourage food sharing among people.


## Technologies Used


This project implementats Spring Boot framework with given dependencies:

- Lombok --> Java annotation library which helps to reduce boilerplate code.
- Spring Web --> Builds web, including RESTful, applications using Spring MVC
- Spring Security --> Highly customizable authentication and access-control framework for Spring applications.
- Spring Data JPA --> Persists data in SQL stores with Java Persistence API using Spring Data and Hibernate
- PostgreSQL Driver --> JDBC & R2DBC driver allowing Java programs to connect to PostgreSQL database using standart Java code
- Swagger --> OAS Rest Documentation
- JUnit, Mockito -> (Unit Testing)
- SLF4J --> Logging

## API Documentation

(to be updated)

## Functional Requirements & Analysis

| **USER STORY ID** | **AS A**                    | **I WANT TO**         | **SO THAT**                                                                 |
|-------------------|-----------------------------|-----------------------|-----------------------------------------------------------------------------|
| 1                 | food receiver & food sharer | sign up to the system | I can create an account using an email and password                         |
| 2                 | food receiver & food sharer | login/logout          | I can enter/leave system                                                    |
| 3                 | food receiver & food sharer | choose my role        | I can each time decide weather I want to receive or share food              |
| 3                 | food receiver & food sharer | set my location       | I can pin my location                                                       | 
| 4                 | food receiver               | browse listings       | I can see list of shared foods near my location                             | 
| 5                 | food receiver               | choose a listing item | I can make a request to get the item                                        | 
| 6                 | food receiver               | give feedback         | I can rate and review the sharer after receiving food                       |
| 7                 | food sharer                 | create a listing item | I can post mine/restaurant/cafe food                                        |
| 8                 | food sharer                 | share a listing item  | I can make it publicly available on main feed                               | 
| 9                 | food sharer                 | confirm the pick up   | I can notify all watchers that food is taken.                               |
| 10                | admin                       | control the reviews   | I can take an action if there is any reported issue against community rules |
| 11                | admin                       | maintain the system   | I can handle all technical issues (to be extended)                          |



## UML Design & Flow Charts




