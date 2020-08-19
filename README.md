## Order Management System
Implemented an order management system that has two microservices: Order Service and Order Item Service. 

The Order Service is responsible for creating new orders, retrieving existing order info.
Order has below data:
- Customer name
- Order date
- Shipping address
- Order items
- Total ($)
```
POST: http://localhost:2222/api/order/create
Request Body
{
    "customerName": "Pintu",
    "shippingAddress": "abc",
    "products": [
        {
            "productCode": "cndd",
            "productName": "Redmi",
            "quantity": "1"
        },
        {
            "productCode": "ascd",
            "productName": "Vivo",
            "quantity": "1"
        }
    ],
    "orderTotal": 40000.00
}

Response We will receive:
{
    "response": "Order created with order id=1"
}

```
```
GET: http://localhost:2222/api/order/retrieve/1

Response we will receive:
{
    "orderId": 1,
    "customerName": "Pintu",
    "orderDate": "2020-08-19T12:38:58.073347",
    "shippingAddress": "abc",
    "orderTotal": 40000.00
}
```
Similarly, Order Item Service is responsible for creating order items, retrieving order items.
Order Item has below data:
- Product code
- Product name
- Quantity
```
GET: http://localhost:1111/api/products/retrieve/1
Response we will receive:
{
    "productId": 1,
    "productCode": "cndd",
    "productName": "Redmi",
    "quantity": 1,
    "orderId": 1
}
```

