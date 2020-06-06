package com.tomerestservice.db;

import java.sql.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/DatabaseAccess")
public class DatabaseAccess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DatabaseAccess() {
        super();
    }
    public void init() {
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
    		String query = "SELECT COUNT(*) FROM INFORMATION_SCHEMA.SCHEMATA WHERE SCHEMA_NAME = 'tomedatabase';";
    	
    	
    		Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306", "root", "");
		    
    		Statement stmt = conn.createStatement();
    		ResultSet rs = stmt.executeQuery(query);
    		rs.next();
	    	
	    	 if (rs.getInt(1) == 0) {
	    		 	
	    		 	stmt.executeUpdate("CREATE DATABASE tomedatabase;");
	    		 
		    		stmt.close();
		    		
		 		    Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tomedatabase", "root", "");
		 		    
		 		    Statement statement = con.createStatement();
		 	    	
		 		    // Create books table
		 		    statement.executeUpdate("CREATE TABLE books "
		 	    			+ "(id varchar(10), author varchar(30), genre varchar(20), "
		 	    			+ "name varchar(50), price decimal(6,2), type varchar(15), "
		 	    			+ "image varbinary(100)" + ", summary varchar(500));");
		 	    	
		 		    // Populate books stable
		 		    statement.executeUpdate("INSERT INTO books (id, author, genre, name, price, type, image, summary)"
		 	    			+ "VALUES"
		 	    			+ "('INF5678', 'Chris Wallace','Mystery','COUNTDOWN 1945', 15.30, 'HARDCOVER', 'images/1945.jpg', 'An electrifying behind-the-scenes account of the 116 days leading up to the American attack on Hiroshima.'),"
		 	    			+ "('INF1928', 'Amor Towles','Mystery','A GENTLEMAN IN MOSCOW', 14.99,'PAPERBACK', 'images/a_gentleman_in_moscow.jpg', "
		 	    			+ "'From the <i>New York Times</i> bestselling author of <i>Rules of Civility - a transporting novel about a man who is "
		 	    			+ "ordered to spend the rest of his life inside a luxury hotel.</i>.. The mega bestseller with more than 2 million readers, soon to be a major television series.' ),"
		 	    			+ "('INF1234', 'Anna Lee Huber','Horror','A STROKE OF MALICE', 15.30, 'PAPERBACK', 'images/a_stroke_of_malice.jpg', 'Lady Kiera Darby and her husband Sebastian Gage "
		 	    			+ "are looking forward to celebrating with new friends at an exciting yearly soireey, but they soon learn that murder never takes a holiday.'),"
		 	    			+ "('INF2837', 'Catherine Coulter','Non-Fiction','LABYRINTH', 12.74, 'PAPERBACK', 'images/labyrinth.jpg', 'On a Tuesday afternoon, Agent Sherlock is driving" 
		 	    			+ " in downtown Washington when her Volvo is suddently T-boned at an intersection. As her car spins out of control, a man''s body slams agains her windshield and then ...'),"
		 	    			+ "('INF1357', 'Celeste Ng','Suspense','LITTLE FIRES EVERYWHERE', 14.99, 'PAPERBACK', 'images/little_fires.jpg', 'Enter Mia Warren - an enigmatic artis and single" 
		 	    			+ " mother - who arrives in this idyllic bubble with her teenaged daughter Pearl, and rents a house from the Richardsons. Soon Mia and Pearl become"
		 	    			+ " more than tenants: all four Richardsons children are drawn to the mother-daughter pair.'),"
		 	    			+ "('INF5498', 'Marcus Aurelius','Mystery','MEDITATIONS', 23.48, 'HARDCOVER', 'images/meditations.jpg', 'Written in Greek by the only Roman emperor who was also " 
		 	    			+ "a philosopher, without any intention of publication, The Meditations of Marcus Aurelius offer a remarkable series of challenging spiritual reflections " 
		 	    			+ "and exercises developed as the emperor struggled to understand himself and make sense of the universe.'),"
		 	    			+ "('INF3746', 'Leonard Goldberg','Mystery','THE DAUGHTER OF SHERLOCK HOLMES', 25.99, 'HARDCOVER', 'images/the_daughter_of_sherlock_holmes.jpg', 'From <i>USA today</i> "
		 	    			+ "and internationally bestselling author Leonard Goldberg comes <i>The Daughter of Sherlock Holmes</i>, a new thrilling tale of the greate detective''s dauighter and her companion Dr. John Watson.'),"
		 	    			+ "('INF2468', 'Erik Larson', 'Horror','THE DEVIL IN THE WHITE CITY', 15.30, 'PAPERBACK', 'images/the_devil_in_the_white_city.jpg', 'This New York Times bestseller intertwines the true " 
		 	    			+ "tale of the 1983 World''s Fair and the cunning serial killer who used to lure his victims to their death.'),"
		 	    			+ "('INF1245', 'Lucy Foley', 'Suspense','THE HUNTING PARTY', 24.29, 'HARDCOVER', 'images/the_hunting_party.jpg', '''My favorite kind of whodunit, kept me guessing " 
		 	    			+ "all the way through, and reminiscent of Agatha Christie at her best''<br><br> - Alex Michaelides, author of the #1 <i>New York Times</i> bestseller <i>The Silent Patient</i>'),"
		 	    			+ "('INF9782', 'Douglas Preston','Science Fiction','THE LOST CITY OF THE MONKEY GOD', 16.19, 'PAPERBACK', 'images/the_lost_city_of_the_monkey_god.jpg', 'The #1 New York Times and Wall "
		 	    			+ "Street Journal bestseller, named one of the best books of the year by The Boston Globe and National Geographic.')");
		 	    	
		 		    
		 		    // Create customers table
		 		    statement.executeUpdate("CREATE TABLE customers ( order_id int(11) NOT NULL AUTO_INCREMENT, first_name varchar(100) NOT NULL, "
		 						    	  + "last_name varchar(100) NOT NULL, phone_num char(10) NOT NULL, address_1 varchar(100) NOT NULL, address_2 varchar(100), "
		 						    	  + "city varchar(100) NOT NULL, state char(2) NOT NULL, zipcode char(5) NOT NULL, shipping_method varchar(9) NOT NULL,"
		 								  + " PRIMARY KEY (order_id) );");
		 		    
		 		    // Create orders table
		 		    statement.executeUpdate("CREATE TABLE order_items ( order_id int(11) NOT NULL, product_id char(7) NOT NULL, image_src varchar(100) NOT NULL, item_name varchar(100) NOT NULL, price decimal(6,2) NOT NULL, quantity int(11) NOT NULL," + 
		 		    						"FOREIGN KEY (order_id) REFERENCES customers(order_id) );");
		 		    
		 		    // Create billing table
		 		    statement.executeUpdate("CREATE TABLE billing ( order_id int(11) NOT NULL, card_type varchar(10) NOT NULL, card_number char(16) NOT NULL, exp_month varchar(2) NOT NULL, exp_year char(4) NOT NULL, cvv char(3) NOT NULL, subtotal decimal(8,2) NOT NULL, tax decimal(8,2) NOT NULL, shipping_cost decimal(4,2) NOT NULL, total decimal(8,2), FOREIGN KEY (order_id) REFERENCES customers(order_id) );");
		 		    
		 		    
		 		    // Create table to store tax rate per city information
		     //        statement.executeUpdate("CREATE TABLE tax_rates (State VARCHAR(2), ZipCode INT(5), TaxRegionName VARCHAR(89), CombinedRate DECIMAL(7,6));");
		             
		             // Loads tax rate data into the tax_rates table
		 /*            statement.executeUpdate("LOAD DATA LOCAL INFILE '../data/TaxRates2.csv' "
		             					  + "INTO TABLE tax_rates "
		             					  + "FIELDS TERMINATED BY ',' "
		             					  + "ENCLOSED BY '\"' "
		             					  + "IGNORE 1 LINES;");*/
		            
		             // Creates table to store city, state names based on zip code
		    //         statement.executeUpdate("CREATE TABLE updateCityState (zip INT(5), state VARCHAR(2), city VARCHAR(16));");
		             
		            // Loads city, state data into updateCityState table mentioned above
		 /*            statement.executeUpdate("LOAD DATA LOCAL INFILE '../data/zip_codes.csv'" +
		                       "INTO TABLE updateCityState" +
		                       "FIELDS TERMINATED BY ','" +
		 		              "OPTIONALLY ENCLOSED BY '\"'" +
		                       "LINES TERMINATED BY '\r\n' " +
		                       "IGNORE 1 LINES;");*/
		       //      System.out.println("Files updated successfully!");
		 		    
		 		    statement.close();
			 		
		    	 
		    	 }
	    	 else {stmt.close();}
			
	    }catch(Exception e) {System.out.println(e);}
    
}
    
}
    /*
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}*/
