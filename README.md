# 🛒 E-Commerce Backend Application (Spring Boot)

A secure and scalable **E-commerce backend system** built using **Spring Boot**, supporting authentication, product management, cart operations, and order processing.

---

## 🚀 Features

* 🔐 **JWT Authentication**

  * User login & secure API access
* 📦 **Product Management**

  * View available products
* 🛍️ **Cart Management**

  * Add products to cart
  * View cart items
  * Delete cart items
* 📑 **Order Management**

  * Place order from cart
  * Auto calculation of total amount

---

## 🛠️ Tech Stack

* **Backend:** Java, Spring Boot
* **Security:** Spring Security + JWT
* **Database:** MySQL
* **ORM:** Spring Data JPA (Hibernate)
* **API Testing:** Postman

---

## ⚙️ Project Structure

```
com.asmita.ecommerce
│
├── controller      # REST APIs
├── service         # Business logic
├── repository      # Database layer
├── entity          # JPA entities
├── security        # JWT & security config
└── config          # App configurations
```

---

## 🔑 Authentication (JWT)

### Login API

**POST** `/auth/login`

### Request Body

```json
{
  "email": "test@gmail.com",
  "password": "123456"
}
```

### Response

```json
{
  "token": "your_jwt_token_here"
}
```

👉 Use this token in all secured APIs:

```
Authorization: Bearer <token>
```

---

## 📦 Product APIs

### Get All Products

**GET** `/products`

---

## 🛒 Cart APIs

### Add Item to Cart

**POST** `/cart`

```json
{
  "product": { "id": 1 },
  "quantity": 2
}
```

---

### Get All Cart Items

**GET** `/cart`

---

### Delete Cart Item

**DELETE** `/cart/{id}`

---

## 📑 Order APIs

### Place Order

**POST** `/orders?cartId=1`

---

### Response

```json
{
  "id": 1,
  "totalAmount": 40000.0,
  "status": "PLACED"
}
```

---

## 🗄️ Database Configuration

Update `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce_db
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## ▶️ How to Run

1. Clone the repository
2. Open project in IDE (Eclipse/IntelliJ)
3. Configure MySQL database
4. Run the Spring Boot application
5. Test APIs using Postman

---

## ✅ Sample Data (Optional)

```sql
INSERT INTO product (id, name, price, stock) VALUES
(1, 'Phone', 20000, 10),
(2, 'Laptop', 60000, 5),
(3, 'Tablet', 30000, 5);
```

---

## 🧪 Testing Flow (Important)

1. Login → Get JWT token
2. Get Products
3. Add item to Cart
4. View Cart
5. Place Order

---

## 📌 Future Enhancements

* User-wise cart system
* Order history
* Payment integration
* DTO & validation layer
* Global exception handling

---

## 👩‍💻 Author

**Asmita Jadhav**

---

## ⭐ Conclusion

This project demonstrates:

* Secure backend development
* REST API design
* Database integration
* Real-world E-commerce workflow

---
