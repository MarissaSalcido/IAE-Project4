package com.tomerestservice.model;


import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "book")
//You will need to create a Java Object. Jersey uses these to construct requests and responses.

public class Book {
  private String id;
  private String author;
  private String genre;
  private String name;
  private float price;
  private String type;
  private String image;
  private String summary;
  
  public String getId() {
	  return id;
  }
  
  public void setId(String id) {
	  this.id = id;
  }
  
  public String getAuthor() {
	  return author;
  }
  
  public void setAuthor(String author) {
	  this.author = author;
  }
  
  public String getGenre() {
	  return genre;
  }
  
  public void setGenre(String genre) {
	  this.genre = genre;
  }
  
  public String getName() {
	  return name;
  }
  
  public void setName(String name) {
	  this.name = name;
  }
  
  public float getPrice() {
	  return price;
  }
  
  public void setPrice(float price) {
	  this.price = price;
  }
  
  public String getType() {
	  return type;
  }
  
  public void setType(String type) {
	  this.type = type;
  }
  
  public String getImage() {
	  return image;
  }
  
  public void setImage(String image) {
	  this.image = image;
  }
  
  public String getSummary() {
	  return summary;
  }
  
  public void setSummary(String summary) {
	  this.summary = summary;
  }
}

//public class Book {
//    private String summary;
//    private String description;
//    private int id;
//
//    public String getSummary() {
//        return summary;
//    }
//
//    public void setSummary(String summary) {
//        this.summary = summary;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public int getId() {
//        return id;
//    }
//}