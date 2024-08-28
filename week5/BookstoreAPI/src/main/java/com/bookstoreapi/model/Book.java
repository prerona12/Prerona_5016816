package com.example.bookstore.model;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Schema(description = "Details about a book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique identifier for the book", example = "1", required = true)
    private Long id;

    @Schema(description = "Title of the book", example = "The Great Gatsby", required = true)
    private String title;

    @Schema(description = "Author of the book", example = "F. Scott Fitzgerald", required = true)
    private String author;

    @Schema(description = "Price of the book", example = "10.99", required = true)
    private Double price;

    @Schema(description = "ISBN number of the book", example = "978-0743273565", required = true)
    private String isbn;

    @Schema(description = "Summary of the book", example = "A novel about the American dream.")
    private String summary;

    // Constructors
    public Book() {
    }

    public Book(String title, String author, Double price, String isbn, String summary) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.isbn = isbn;
        this.summary = summary;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    // toString method
    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", isbn='" + isbn + '\'' +
                ", summary='" + summary + '\'' +
                '}';
    }
}
