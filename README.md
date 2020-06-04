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
    "orderId": 30,
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
    "subtotal": "910.23",
    "tax": "88.80",
    "shippingCost": "10.99",
    "total": "1010.23",
    "orderItems": [
        {
            "productId": "INF5678",
            "imageSrc": "images/1945.jpg",
            "itemName": "COUNTDOWN 1945",
            "price": "15.30",
            "quantity": "1"
        },
        {
            "productId": "INF1234",
            "imageSrc": "images/a_stroke_of_malice.jpg",
            "itemName": "A STROKE OF MALICE",
            "price": "15.30",
            "quantity": "2"
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
	"subtotal": "910.23",
	"tax": "88.80",
	"shippingCost": "10.99",
	"total": "1010.23",
	"orderItems": 
		[
			{
				"productId": "INF5678", 
				"imageSrc": "images/1945.jpg", 
				"itemName": "COUNTDOWN 1945",
				"price": "15.30",
				"quantity": "1"
			},
			{
				"productId": "INF1234", 
				"imageSrc": "images/a_stroke_of_malice.jpg",
				"itemName": "A STROKE OF MALICE", 
				"price": "15.30", 
				"quantity": "2"
			}
		]
}
	





## Website - PA3 IS NOT DEPLOYED IN OPENLAB. WE HAVE SIGNED UP FOR A WEBSITE DEMONSTRATION.
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
   - **Check out the products you have seen!** will display the last (up to 5) products that the user has visited. If this button is clicked on 
     before seeing any actual products (before clicking on view collection), then it will display a message that says "You haven't check out any products yet!".
2. The Catalog Page
   - Includes 10 products
   - By clicking on the button "Click to Buy", you will be led to a detailed product description
3. Product Description Page(s) (from the catalog)
   - Includes book description, price, format, etc and a product code below the title (needed to purchase book)
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
- Requirement 1 has two servlets (products and SessionTracking). The products servlet will include SessionTracking, and session tracking contains 
  the use of include() to call/include the ProductDetailServlet.
- Requirement 2 When a user clicks on a product from the Catalog, the user can specify the quantity wanted and add the product to their cart. 
- Requirement 3 are covered in the Cart, CheckOut, OrderProcessing, and OrderConf servlets.
   - Showing items in the shopping cart, the total price, and filling in form information are implemented in Cart and CheckOut
   - When the CheckOut page is submitted, it is processed in the OrderProcessing servlet, where the information is inputted into the database.
   - After the information is inputted into the database, the OrderProcessing uses the servlet "forward" feature to forward to the OrderConf servlet. The Order Conf servlet shows the Order Confirmation page.

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
- **Hugo** and **Don** worked on Requirement 1, products.java and SessionTracking.java
- **Marissa** worked on Requirement 2, ProductDetailServlet.java, DatabaseAccess.java, and slightly modified the styling for each page from the html generated in each servlet.
- **Jessica** worked on Requirement 3 in Cart.java, CheckOut.java, OrderProcessing.java, and OrderConf.java servlets. She also contributed to DBInfo.java, Book.java, DatabaseAccess.java, and Item.java.

**Note:** We all contributed in code review and debugging for each individual page.
 
