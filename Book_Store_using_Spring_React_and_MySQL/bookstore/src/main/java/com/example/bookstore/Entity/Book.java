package com.example.bookstore.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    private String title;
    private String author;
    private String description;
    private int price; 

    public Book(){};

    public void setTitle(String title){this.title = title;}
    public String getTitle(){return title;}

    public void setAuthor(String author){this.author = author;}
    public String getAuthor(){return author;}

    public void setDescription(String description){this.description = description;}
    public String getDescription(){return description;}

    public void setPrice(int price){this.price = price;}
    public int getPrice(){return price;}

}