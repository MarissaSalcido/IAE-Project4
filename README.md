# INF124/CS137 Project

## Group Members
- Jessica Cheng&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(76401472)
- Hugo Ruiz&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(66212078)
- Don Cung&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(91314588)
- Marissa Yvonne Salcido&nbsp; (86569875)

# REST APIs
### Description: Post a new order
###### i. Method Type:
POST
###### ii. Request URL:
http://localhost:8080/TomeRestService/tomerest/order
###### iii. Sample Response:
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

###### iv. Sample Request (if applicable):
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
	
&nbsp;
&nbsp;

### Description: Get all books' product information
###### i. Method Type
GET
###### ii. Request URL
http://localhost:8080/TomeRestService/books
###### iii. Sample Response
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
###### iv. Sample Request (if applicable):
GET http://localhost:8080/TomeRestService/tomerest/books

&nbsp;
&nbsp;

### Description: Get a book by product id
###### i. Method Type
GET
###### ii. Request URL
http://localhost:8080/TomeRestService/tomerest/books/PRODUCTID, where PRODUCTID is a specific product identifier.
For example, http://localhost:8080/TomeRestService/tomerest/books/INF5678
###### iii. Sample Response
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
###### iv. Sample Request (if applicable)
GET http://localhost:8080/TomeRestService/tomerest/books/INF5678

&nbsp;
&nbsp;

## Website - PA4 IS NOT DEPLOYED IN OPENLAB. WE HAVE SIGNED UP FOR A WEBSITE DEMONSTRATION.
### Link: Not applicable
### Database Password: Not applicable
### Deploying Assignment 4
*Replace "user" with your own openlab username
*** Repeat the above steps for each war file: the REST services war file and the client war file.

Local Command Line:
- scp project4.war user@circinus-8.ics.uci.edu:/home/user/s2020-iae/pserv/

Openlab Deployment:
- Log into UCI VPN
- Log into OpenLab (ssh user@openlab.ics.uci.edu)
- Log into circinus machine (ssh circinus-8)
- module load singularity
- singularity instance start -B /home/user/s2020-iae/pserv/:/usr/local/tomcat/webapps --writable ics124-tomcat:simg $USER-tomcat
- singularity run instance://$USER-tomcat

## General Layout/Design
1. The website starts at index.html which is the the e-commerce **home page** and will include:
   - a nav anchor to the products catalog; through the catalog tab in the header and the "view catalog" in the body
   - a nav anchor to the about us page; which contains our business/personal description
   - **View Collection** will take you to the catalog produced by a servlet and start a session to keep track of the end user
2. The Catalog Page
   - Includes 10 products
   - By clicking on each products image, you will be led to a detailed product description
   - At the bottom of the Catalog page, it shows the 5 most recent books viewed.
3. Product Description Page(s) (from the catalog)
   - Includes book description, price, format, etc and a product code below the title
   - Contains a field to purchase an x quantity of books
4. Cart
   - Displays a list of all items in the shopping cart and shows a subtotal
   - Allows the user to pick a shipping method
5. Checkout
   - Asks user to fill in information for ordering the products, including shipping and billing information
   - The items from the shopping cart are listed on the bottom of the page too
   - Also, the subtotal, tax, shipping, and total cost are displayed on the bottom too
   - Note: There is no form validation on the client side, so the form must be correctly filled in before submitting. Otherwise, it will lead the Order Confirmation page displaying that there was an error in processing.
6. Order Confirmation
   - Includes a summary of the customer's order details after submitting an order. 
6. The About Us Page
   - Includes information on our company and motto
   - Includes information on group member names/pictures along with student IDs

## Project 3
### Requirements
- Requirement 1 is completed in the catalog.jsp on the catalog page.
- Requirement 2 is completed in TomeRestService.
- Requirement 3 is completed in TomeClient's OrderProcessing.java, ProductDetailServlet.java, and CatalogServlet.java.

### Citations
Landing Page:
  * We used Roboto Font (fonts.google) in entire landing page 
  * Icons were pulled from fontawesome.com
  * Image was pulled from Pexels.com
  
About Us: 
  * We used Roboto Font (fonts.google) in entire landing page 
  * Stock photo was pulled from pixabay.

All other pages:
   * Book images used from Barnes and Noble: https://www.barnesandnoble.com/
   
All pages:
   * Roboto Font used throughout the page: https://fonts.google.com/
  
### Contributions
- **Marissa** worked on Requirement 1.
- **Hugo** and **Jessica** worked on Requirement 2.
- **Marissa**, **Don**, and **Jessica** worked on Requirement 3.

**Note:** We all contributed in code review and debugging for each individual page.
 
