package com.emirpetek.walletapp.walletApp.model;

import jakarta.persistence.*;

@Entity
@Table//(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment ayarı
    private Long id;
    @Column(name = "firstName")
    public String firstName;
    @Column(name = "lastName")
    public String lastName;
    @Column(name = "email")
    public String email;
    @Column(name = "password")
    public String password;
    @Column(name = "birthdate")
    public String birthdate;
    @Column(name = "createdAt")
    public long createdAt;


    public User() {
        // JPA için gerekli
    }

    public User(Long id, String firstName, String lastName, String email, String birthdate, long createdAt) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthdate = birthdate;
        this.createdAt = createdAt;
    }

    public User(String firstName, String lastName, String email, String password, String birthdate, long createdAt) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.birthdate = birthdate;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthdate() {
        return this.birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public long getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + this.id +
                ", firstName='" + this.firstName + '\'' +
                ", lastName='" + this.lastName + '\'' +
                ", email='" + this.email + '\'' +
                ", password='" + this.password + '\'' +
                ", birthdate='" + this.birthdate + '\'' +
                ", createdAt=" + this.createdAt +
                '}';
    }

}
