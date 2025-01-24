# Backend README

## Project Overview

This backend application is part of a digital wallet bank system. It manages user registrations, logins, and financial operations such as creating cards, making payments, and viewing transactions. The backend is implemented using **Spring Boot** and uses **MySQL** as the database. Also Hibernate was used.

## Features

- User registration and login (returns user model and authentication status as boolean).
- Card-related operations (create, manage, etc.).
- Payment operations:
  - Bill payments.
  - Withdrawals and deposits.
  - Transfers to other users using IBAN.
- Password reset for users.
- Viewing transaction history.

## Technologies Used

- **Java 17** (or compatible version).
- **Spring Boot** for application framework.
- **MySQL** for database.
- **Maven** for dependency management.

## Endpoints Overview

### Authentication

- **POST /auth/login**

  - Logs in a user with email and password.
  - **Request Body:**
    ```json
    {
      "email": "user@example.com",
      "password": "password123"
    }
    ```
  - **Response:**
    ```json
    {
      "authenticated": true,
      "user": {
        "id": 1,
        "email": "user@example.com",
        "firstName": "John",
        "lastName": "Doe",
        "birthdate": "2000-01-01",
        "createdAt": 1672531200000
      }
    }
    ```

- **POST /auth/register**

  - Registers a new user.
  - **Request Body:**
    ```json
    {
      "user": {
        "firstName": "John",
        "lastName": "Doe",
        "email": "user@example.com",
        "password": "password123",
        "birthdate": "2000-01-01",
        "createdAt": 1672531200000
      }
    }
    ```
  - **Response:**
    ```json
    {
      "success": true
    }
    ```

### User Operations

- **GET /user/{userID}**

  - Retrieves user data by user ID.

- **GET /user/getFullName/{userID}**

  - Retrieves the full name of a user by user ID.

- **GET /user/isEmailExist/{email}**

  - Checks if an email exists in the system.

- **GET /user/getUserIdFromEmail/{email}**

  - Retrieves user ID using email.

- **POST /user/changePassword**

  - Changes the password for a user.
  - **Request Body:**
    ```json
    {
      "userID": 1,
      "oldPassword": "oldpassword123",
      "newPassword": "newpassword123"
    }
    ```
  - **Response:**
    ```json
    {
      "response": "SUCCESSFUL"
    }
    ```

### Card Operations

- **POST /card/getCard**

  - Retrieves all cards for a user.

- **POST /card/createCard**

  - Creates a new card for the user.
  - **Request Body:**
    ```json
    {
      "cardType": "VISA",
      "cardHolder": "John Doe",
      "userID": 1,
      "balance": 1000.00,
      "currencyType": "USD"
    }
    ```
  - **Response:**
    ```json
    {
      "success": true
    }
    ```

- **POST /card/loadBalance**

  - Loads balance into a card.

- **POST /card/withdrawMoney**

  - Withdraws money from a card.

- **GET /card/getNumberOfCards/{userID}**

  - Retrieves the number of cards a user has.

### Payment and Transaction Operations

- **POST /transaction/moneyTransfer**

  - Transfers money to another user.

- **GET /transaction/getTransactions/{userID}**

  - Retrieves transaction history for a user.

- **GET /transaction/payBill/{userID}**

  - Pays a bill for the user.

- **GET /transaction/randomPayment/{userID}**

  - Makes a random payment for the user.

- **GET /transaction/getNumberOfTransactions/{userID}**

  - Retrieves the number of transactions a user has made.

## Setup and Installation

### Prerequisites

- JDK 17 or later.
- MySQL Server installed and running.
- Maven installed.

### Steps to Run the Project

1. Clone the repository:

   ```bash
   git clone <repository_url>
   cd <project_folder>
   ```

2. Configure the database:

   - Update the `application.properties` file with your MySQL credentials:
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/digital_wallet
     spring.datasource.username=root
     spring.datasource.password=your_password
     spring.jpa.hibernate.ddl-auto=update
     ```

3. Build and run the application:

   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

4. Access the application:

   - The application will run on `http://localhost:8080` by default.

## Future Improvements

- Adding JWT-based authentication.
- API documentation with Swagger.
- Integration with external payment gateways.



