package com.example.opa.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("user")
public class User {

    private String firstName;
    private String lastName;
    private double salary;
    private String email;
    private String role;

    public User() {
    }

    public User(String firstName, String lastName, double salary, String email, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.email = email;
        this.role = role;
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "{" +
                "firstName:" + '\"'+firstName + "\"," +
                "lastName:" + '\"'+lastName + "\"," +
                "salary:" + salary +','+
                "email:" + '\"'+email + "\"," +
                "role:" + '\"'+role + '\"' +
                '}';
    }
}
