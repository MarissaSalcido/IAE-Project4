package com.tomerestservice.model;


import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "example")
//You will need to create a Java Object. Jersey uses these to construct requests and responses.

public class Example {
    private String summary;
    private String description;
    private int id;

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
