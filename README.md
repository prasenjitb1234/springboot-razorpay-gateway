# SpringBoot Razorpay Payment Gateway

## Overview

This project demonstrates the integration of Razorpay's payment gateway with a Spring Boot web application. The system allows users to make online payments, with the transaction details being managed and stored in a MySQL database. The project employs REST API services to handle order creation, payment verification, and includes callback handling to confirm transaction status.

The frontend is built with HTML, CSS, and JavaScript, while the backend is implemented using Spring Boot, Spring JPA for database interaction, and Razorpay's Java API for payment integration.

## Features

- **Payment Integration with Razorpay:** Users can create orders and make payments.
- **Order Management:** Creation of new orders via a REST API.
- **Payment Callback Handling:** Razorpay sends a callback after payment, which the application processes and verifies.
- **Database:** Uses JPA to store and update transaction details in MySQL.
- **Frontend:** HTML, CSS, and JavaScript to handle user interactions and payments.
- **Validation:** Ensures secure and proper order/payment processing.

## Screenshots

Here are some screenshots of the application:

- **Payment Gateway Home**  
<img src="photos/1.png" alt="Home" style="max-width: 100%; height: auto;"/>


- **Razorpay Dashboard**  
  <img src="photos/2.png" alt="Home" style="max-width: 100%; height: auto;"/>

- **Payment Successful Razorpay**  
  <img src="photos/3.png" alt="Home" style="max-width: 100%; height: auto;"/>  

- **MySQL Database View**  
  ![MySQL Database](photos/5%20mysql%20db.png)

- **Spring Boot Configuration**  
  ![SpringBoot Config](photos/6%20springboot%20config.png)

## API Endpoints

- `GET /`: Displays the homepage (a simple HTML form for initiating a payment).
- `POST /create-order`: Creates a new Razorpay order and returns the order details in JSON format.
- `POST /handle-payment-callback`: Processes the Razorpay payment callback to verify the transaction and update the order status in the database.

## Technologies Used

- **Backend**: Spring Boot, Spring JPA, Razorpay Java API
- **Frontend**: HTML, CSS, JavaScript
- **Database**: MySQL
- **API Testing**: Postman

## How to Run

1. Clone the repository.
2. Configure the `application.properties` file with your MySQL and Razorpay credentials.
3. Build and run the Spring Boot application.
4. Access the application at `http://localhost:8080`.

---

