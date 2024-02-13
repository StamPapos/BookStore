package com.bookStore.bookStore.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.*;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "book_id")
    private Integer id;

    private String title;

    private String author;

    private String summary;

    private int publicationYear;

    private String genre;

    public Book(String title, String author, String summary, int publicationYear, String genre){
        this.title = title;
        this.author = author;
        this.summary = summary;
        this.publicationYear = publicationYear;
        this.genre = genre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getAuthor(){
        return author;
    }

    public void setAuthor(String author){
        this.author = author;
    }


    public String getSummary(){
        return summary;
    }


    public void setSummary(String summary){
        this.summary = summary;
    }


    public Integer getPublicationYear(){
        return publicationYear;
    }


    public void setPublicationYear(int publicationYear){
        this.publicationYear = publicationYear;
    }


    public String getGenre(){
        return genre;
    }


    public void setGenre(String genre){
        this.genre = genre;
    }


}

