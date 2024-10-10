# Documentation for AttireAvenue Project

This Git repository contains the Java Spring Boot source code for an e-commerce backend system with a RESTful API for browsing products, adding to cart, placing orders, and checking out. Built with a modular MVC architecture and backed by MySQL.


Dockerized and deployed on AWS EC2

![AWS Loadbalancer Architecture](./assets/aws%20architecture.png)


## Api Docs


Welcome to the documentation for the Ecommerce Project API! This API provides a set of endpoints and functionalities to interact with our eCommerce platform programmatically. With this API, you can build applications, integrations, and automate various tasks related to our online store.



## Authentication

All protected endpoints require the `Authorization` header with a valid token.

## Endpoints

### Update Cart Item

- **URL**: `/api/cart_items/{cartItemId}`
- **Method**: PUT
- **Tags**: cart-item-controller
- **Request Parameters**:
  - `cartItemId` (integer, int64, required)
- **Request Headers**:
  - `Authorization` (string, required)
- **Request Body**:
  ```json
  {
    "$ref": "#/components/schemas/CartItem"
  }
  ```
- **Responses**:
  - 200 OK
    ```json
    {
      "$ref": "#/components/schemas/CartItem"
    }
    ```

### Delete Cart Item

- **URL**: `/api/cart_items/{cartItemId}`
- **Method**: DELETE
- **Tags**: cart-item-controller
- **Request Parameters**:
  - `cartItemId` (integer, int64, required)
- **Request Headers**:
  - `Authorization` (string, required)
- **Responses**:
  - 200 OK
    ```json
    {
      "$ref": "#/components/schemas/ApiResponse"
    }
    ```

### Add Item to Cart

- **URL**: `/api/cart/add`
- **Method**: PUT
- **Tags**: cart-controller
- **Request Headers**:
  - `Authorization` (string, required)
- **Request Body**:
  ```json
  {
    "$ref": "#/components/schemas/AddItemRequest"
  }
  ```
- **Responses**:
  - 200 OK
    ```json
    {
      "$ref": "#/components/schemas/ApiResponse"
    }
    ```



## Components

### Schemas

- CartItem
- ApiResponse
- AddItemRequest
- Product
- Order
- User
- AuthResponse
- ReviewRequest
- Review
- RatingRequest
- Rating
- PaymentLinkResponse
- Address
- CreateProductRequest
- PageProduct

## Servers

- Server 1:
  - URL: `http://localhost:5454`
  - Description: Generated server URL

## Contact

For any queries or issues, please contact **Yash Mahajan** at `yashmahajan0521@gmail.com`.





