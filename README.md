# INF124/CS137 Project

## Group Members
- Jessica Cheng&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(76401472)
- Hugo Ruiz&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(66212078)
- Don Cung&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(91314588)
- Marissa Yvonne Salcido&nbsp; (86569875)

# REST APIs
### Description (TEMPLATE - Copy and paste to add another method)
1. Method Type
2. Request URL
3. Sample Response
4. Sample Request (if applicable)

### Description: Post a new order
###### 1. Method Type:
Post
###### 2. Request URL:
http://localhost:8080/TomeRestService/tomerest/orders
###### 3. Sample Response:
{
    "orderId": 31,
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
###### 4. Sample Request (if applicable):
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
	"subtotal": 910.23,
	"tax": 88.80,
	"shippingCost": 10.99,
	"total": 1010.23,
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


## Website - PA4 IS NOT DEPLOYED IN OPENLAB. WE HAVE SIGNED UP FOR A WEBSITE DEMONSTRATION.
### Link: Not applicable
### Database Password: Not applicable
### Deploying Assignment 3
*Replace "user" with your own openlab username

Local Command Line:
- scp project3.war user@circinus-8.ics.uci.edu:/home/user/s2020-iae/pserv/

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
   - Note: There is no form validation, so the form must be correctly filled in before submitting. Otherwise, it will lead to a blank page after clicking the submit button.
6. Order Confirmation
   - Includes a summary of the customer's order details after submitting an order. 
6. The About Us Page
   - Includes information on our company and motto
   - Includes information on group member names/pictures along with student IDs

## Project 3
### Requirements
- Requirement 1 is completed in the catalog.jsp on the catalog page.
- Requirement 2 is completed in TomeRestService.
- Requirement 3 is completed in TomeClient's OrderProcessing.java, 

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
 
