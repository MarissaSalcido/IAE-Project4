<html>
<head>
    <title>Tome REST Service</title>
</head>
<body>
<h1>Tome REST Service</h1>
<br><br>
<h2>Description: Post a new order</h2>
<h3> i. Method Type: </h3>Post
<h3> ii. Request URL: </h3>http://localhost:8080/TomeRestService/tomerest/order
<h3> iii. Sample Response: </h3>
HTTP/1.1 200 OK
Date: Wed, 27 May 2020 06:08:22 GMT
Content-Type: application/json
Access-Control-Max-Age: 1728000
Cache-Control: no-cache
{
    "orderId": 12,
    "firstName": "Test2",
    "lastName": "Lovelace",
    "phoneNum": "9999999999",
    "address1": "9 Computing Way",
    "address2": "",
    "city": "Irvine",
    "state": "CA",
    "zipcode": "92617",
    "shippingMethod": "expedited",
    "cardType": "Visa",
    "cardNumber": "9999999999999999",
    "expMonth": "1",
    "expYear": "2021",
    "cvv": "999",
    "subtotal": 910.23,
    "tax": 88.8,
    "shippingCost": 10.99,
    "total": 1010.23,
    "orderItems": [
        {
            "productId": "INF5678",
            "imageSrc": "images/1945.jpg",
            "itemName": "COUNTDOWN 1945",
            "price": 15.3,
            "quantity": 1
        },
        {
            "productId": "INF1234",
            "imageSrc": "images/a_stroke_of_malice.jpg",
            "itemName": "A STROKE OF MALICE",
            "price": 15.3,
            "quantity": 2
        }
    ]
}

<h3> iv. Sample Request (if applicable): </h3>
POST /TomeRestService/tomerest/order HTTP/1.1
Host: localhost:8080
Content-Type: application/json
{
	"firstName": "Test2",
	"lastName": "Lovelace",
	"phoneNum": "9999999999",
	"address1": "9 Computing Way",
	"address2": "",
	"city": "Irvine",
	"state": "CA",
	"zipcode": "92617",
	"shippingMethod": "expedited",
	"cardType": "Visa",
	"cardNumber": "9999999999999999",
	"expMonth": "1",
	"expYear": "2021",
	"cvv": "999",
	"subtotal": 910.2300006,
	"tax": 88.8000006,
	"shippingCost": 10.99,
	"total": 1010.230003,
	"orderItems": 
		[
			{
				"productId": "INF5678", 
				"imageSrc": "images/1945.jpg", 
				"itemName": "COUNTDOWN 1945",
				"price": 15.30,
				"quantity": 1
			},
			{
				"productId": "INF1234", 
				"imageSrc": "images/a_stroke_of_malice.jpg",
				"itemName": "A STROKE OF MALICE", 
				"price": 15.30, 
				"quantity": 2
			}
		]
}
</body>
</html>
