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

<h3> Description: Get all books' product information</h3>
<h3> i. Method Type </h3> Get
<h3> ii. Request URL: </h3> http://localhost:8080/TomeRestService/books
HTTP/1.1 200 OK
Date: Wed, 27 May 2020 08:20:10 GMT
Content-type: application/json
Content-Length: 3876
[
    {
        "id": "INF5678",
        "author": "Chris Wallace",
        "genre": "Mystery",
        "name": "COUNTDOWN 1945",
        "price": 15.3,
        "type": "HARDCOVER",
        "image": "images/1945.jpg",
        "summary": "An electrifying behind-the-scenes account of the 116 days leading up to the American attack on Hiroshima."
    },
    {
        "id": "INF1928",
        "author": "Amor Towles",
        "genre": "Mystery",
        "name": "A GENTLEMAN IN MOSCOW",
        "price": 14.99,
        "type": "PAPERBACK",
        "image": "images/a_gentleman_in_moscow.jpg",
        "summary": "From the <i>New York Times</i> bestselling author of <i>Rules of Civility - a transporting novel about a man who is ordered to spend the rest of his life inside a luxury hotel.</i>.. The mega bestseller with more than 2 million readers, soon to be a major television series."
    },
    {
        "id": "INF1234",
        "author": "Anna Lee Huber",
        "genre": "Horror",
        "name": "A STROKE OF MALICE",
        "price": 15.3,
        "type": "PAPERBACK",
        "image": "images/a_stroke_of_malice.jpg",
        "summary": "Lady Kiera Darby and her husband Sebastian Gage are looking forward to celebrating with new friends at an exciting yearly soireey, but they soon learn that murder never takes a holiday."
    },
    {
        "id": "INF2837",
        "author": "Catherine Coulter",
        "genre": "Non-Fiction",
        "name": "LABYRINTH",
        "price": 12.74,
        "type": "PAPERBACK",
        "image": "images/labyrinth.jpg",
        "summary": "On a Tuesday afternoon, Agent Sherlock is driving in downtown Washington when her Volvo is suddently T-boned at an intersection. As her car spins out of control, a man's body slams agains her windshield and then ..."
    },
    {
        "id": "INF1357",
        "author": "Celeste Ng",
        "genre": "Suspense",
        "name": "LITTLE FIRES EVERYWHERE",
        "price": 14.99,
        "type": "PAPERBACK",
        "image": "images/little_fires.jpg",
        "summary": "Enter Mia Warren - an enigmatic artis and single mother - who arrives in this idyllic bubble with her teenaged daughter Pearl, and rents a house from the Richardsons. Soon Mia and Pearl become more than tenants: all four Richardsons children are drawn to the mother-daughter pair."
    },
    {
        "id": "INF5498",
        "author": "Marcus Aurelius",
        "genre": "Mystery",
        "name": "MEDITATIONS",
        "price": 23.48,
        "type": "HARDCOVER",
        "image": "images/meditations.jpg",
        "summary": "Written in Greek by the only Roman emperor who was also a philosopher, without any intention of publication, The Meditations of Marcus Aurelius offer a remarkable series of challenging spiritual reflections and exercises developed as the emperor struggled to understand himself and make sense of the universe."
    },
    {
        "id": "INF3746",
        "author": "Leonard Goldberg",
        "genre": "Mystery",
        "name": "THE DAUGHTER OF SHERLOCK HOLMES",
        "price": 25.99,
        "type": "HARDCOVER",
        "image": "images/the_daughter_of_sherlock_holmes.jpg",
        "summary": "From <i>USA today</i> and internationally bestselling author Leonard Goldberg comes <i>The Daughter of Sherlock Holmes</i>, a new thrilling tale of the greate detective's dauighter and her companion Dr. John Watson."
    },
    {
        "id": "INF2468",
        "author": "Erik Larson",
        "genre": "Horror",
        "name": "THE DEVIL IN THE WHITE CITY",
        "price": 15.3,
        "type": "PAPERBACK",
        "image": "images/the_devil_in_the_white_city.jpg",
        "summary": "This New York Times bestseller intertwines the true tale of the 1983 World's Fair and the cunning serial killer who used to lure his victims to their death."
    },
    {
        "id": "INF1245",
        "author": "Lucy Foley",
        "genre": "Suspense",
        "name": "THE HUNTING PARTY",
        "price": 24.29,
        "type": "HARDCOVER",
        "image": "images/the_hunting_party.jpg",
        "summary": "'My favorite kind of whodunit, kept me guessing all the way through, and reminiscent of Agatha Christie at her best'<br><br> - Alex Michaelides, author of the #1 <i>New York Times</i> bestseller <i>The Silent Patient</i>"
    },
    {
        "id": "INF9782",
        "author": "Douglas Preston",
        "genre": "Science Fiction",
        "name": "THE LOST CITY OF THE MONKEY GOD",
        "price": 16.19,
        "type": "PAPERBACK",
        "image": "images/the_lost_city_of_the_monkey_god.jpg",
        "summary": "The #1 New York Times and Wall Street Journal bestseller, named one of the best books of the year by The Boston Globe and National Geographic."
    }
]
<h3>iv. Sample Request (if applicable):</h3>
GET http://localhost:8080/TomeRestService/tomerest/books

<br>
<br>

<h2> Description: Get a book by product id </h2>
<h3> i. Method Type </h3> GET
<h3> ii. Request URL </h3> http://localhost:8080/TomeRestService/tomerest/books/PRODUCTID, where PRODUCTID is a specific product identifier.
For example, http://localhost:8080/TomeRestService/tomerest/books/INF5678
<h3> iii. Sample Response </h3>
HTTP/1.1 200 OK
Date: Sun, 07 Jun 2020 03:42:06 GMT
Content-type: application/json
Content-Length: 259
{
    "id": "INF5678",
    "author": "Chris Wallace",
    "genre": "Mystery",
    "name": "COUNTDOWN 1945",
    "price": 15.3,
    "type": "HARDCOVER",
    "image": "images/1945.jpg",
    "summary": "An electrifying behind-the-scenes account of the 116 days leading up to the American attack on Hiroshima."
}

<h3> iv. Sample Request (if applicable) </h3> GET http://localhost:8080/TomeRestService/tomerest/books/INF5678

<br> 
<br> 
</body>
</html>
