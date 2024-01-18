# Cloud_Computing_lab

### Description:

The project adopts a microservices architecture, leveraging Docker for containerization, Thymeleaf for the front-end, and Spring for the backend. Each microservice is designed to operate independently, and the overall application is orchestrated through a set of interconnected services.

### Key Components:

## Microservices:

Accounts Microservice: Manages user account-related functionalities. Dockerized as carageaanda/accounts:cc.
Loans Microservice: Handles loan-related operations. Dockerized as carageaanda/loans:cc.
Cards Microservice: Manages credit card-related activities. Dockerized as carageaanda/cards:cc.

# Databases:

Accounts Database: Dedicated MySQL database for the accounts microservice.
Loans Database: MySQL database specifically for the loans microservice.
Cards Database: MySQL database serving the cards microservice.

### Container Orchestration:

Docker is employed for containerization, allowing each microservice to run in isolated environments. The docker-compose.yml file is configured to define and manage the containers collectively.

### Communication and Monitoring:

The Prometheus service is incorporated for monitoring and collecting metrics from each microservice. Targets for Prometheus are set up for each microservice, facilitating observability.
