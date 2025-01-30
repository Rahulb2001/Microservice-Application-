# Job Portal Microservices Application

## Overview
The **Job Portal Application** is a microservices-based backend system designed for managing jobs, reviews, and companies. It follows a **distributed architecture** using **Spring Boot**, **Spring Cloud**, and **PostgreSQL**, with services containerized using **Docker**. The system is equipped with an **API Gateway**, **Eureka Server**, and **Spring Boot Actuator** for monitoring and scalability.

## Features
- **Microservices Architecture**: Independent Job, Review, and Company services.
- **Spring Cloud Integration**: Eureka for service discovery and API Gateway for routing.
- **Database Management**: PostgreSQL as the primary database.
- **Containerization**: Dockerized for seamless deployment.
- **Monitoring**: Integrated Spring Boot Actuator.
- **Scalability**: Loosely coupled services for better performance and flexibility.

## Technologies Used
- **Backend**: Java, Spring Boot, Spring Cloud
- **Database**: PostgreSQL
- **Containerization**: Docker
- **Service Discovery**: Eureka Server
- **API Gateway**: Spring Cloud Gateway
- **Monitoring**: Spring Boot Actuator

## API Endpoints

### **Job Microservice (Port: 8082)**
| Method | Endpoint | Description |
|--------|---------|-------------|
| GET | `/job/getalljobs` | Retrieve all job listings |
| POST | `/job/addjob` | Add a new job |
| PUT | `/job/updatejob/1` | Update job details by ID |
| DELETE | `/job/deletejob/1` | Delete a job by ID |
| GET | `/job/getjobbyid/1` | Retrieve job details by ID |

### **Review Microservice (Ports: 8080, 8083)**
| Method | Endpoint | Description |
|--------|---------|-------------|
| GET | `/companies/1/reviews/1` | Retrieve a specific review for a company |
| GET | `/companies/1/reviews` | Retrieve all reviews for a company |
| GET | `/reviews?companyId=1` | Retrieve reviews using query parameters |

### **Company Microservice (Ports: 8080, 8081)**
| Method | Endpoint | Description |
|--------|---------|-------------|
| GET | `/companies/getallcompanies` | Retrieve all companies |
| POST | `/companies/addcompany` | Add a new company |
| PUT | `/companies/updatecompany/1` | Update company details by ID |
| DELETE | `/companies/deletecompany/1` | Delete a company by ID |
| GET | `/companies/getcompanybyid/1` | Retrieve company details by ID |

## Deployment Steps
### Prerequisites
- **Java 11+**
- **Docker & Docker Compose**
- **PostgreSQL**
- **Maven**

### Steps to Run
1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/job-portal-microservices.git
   cd job-portal-microservices
   ```
2. Build and package each microservice:
   ```bash
   mvn clean install
   ```
3. Run the application using Docker Compose:
   ```bash
   docker-compose up --build
   ```
4. Access the services:
   - **Eureka Dashboard**: [http://localhost:8761](http://localhost:8761)
   - **API Gateway**: [http://localhost:8080](http://localhost:8080)

## Monitoring & Health Checks
Spring Boot Actuator is enabled for all microservices. You can check the application’s health and metrics at:
- **Job MS**: `http://localhost:8082/actuator/health`
- **Review MS**: `http://localhost:8083/actuator/health`
- **Company MS**: `http://localhost:8081/actuator/health`

## Contributing
Contributions are welcome! Feel free to fork the repository and submit a pull request.

## License
This project is licensed under the **MIT License**.

## Acknowledgments
- **Spring Boot & Microservices Architecture**
- **Docker & PostgreSQL Documentation**
