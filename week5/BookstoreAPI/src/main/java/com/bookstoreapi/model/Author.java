package com.example.bookstore.model;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Schema(description = "Details about an author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique identifier for the author", example = "1", required = true)
    private Long id;

    @Schema(description = "First name of the author", example = "F. Scott", required = true)
    private String firstName;

    @Schema(description = "Last name of the author", example = "Fitzgerald", required = true)
    private String lastName;

    @Schema(description = "Date of birth of the author", example = "1896-09-24", required = true)
    private Date dateOfBirth;

    @Schema(description = "Nationality of the author", example = "American")
    private String nationality;

    @Schema(description = "Biography of the author", example = "F. Scott Fitzgerald was an American novelist.")
    private String biography;

    // Constructors
    public Author() {
    }

    public Author(String firstName, String lastName, Date dateOfBirth, String nationality, String biography) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.nationality = nationality;
        this.biography = biography;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    // toString method
    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", nationality='" + nationality + '\'' +
                ", biography='" + biography + '\'' +
                '}';
    }
}
