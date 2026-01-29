package com.ganz.fw;

public class User {
    private String firstName, lastName, email, password;

    public User setFirstName(String firstName) { this.firstName = firstName; return this; }
    public User setLastName(String lastName) { this.lastName = lastName; return this; }
    public User setEmail(String email) { this.email = email; return this; }
    public User setPassword(String password) { this.password = password; return this; }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
}