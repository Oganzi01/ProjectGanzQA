package com.ganz.fw;

public class User {
    
    private String firstName = "Oleg";
    private String lastName = "Ganz";
    private String email = "ganz@gmail.com";
    private String password = "Oleg1243";

   
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }

    
    public User withFirstName(String firstName) { this.firstName = firstName; return this; }
    public User withLastName(String lastName) { this.lastName = lastName; return this; }
    public User withEmail(String email) { this.email = email; return this; }
    public User withPassword(String password) { this.password = password; return this; }

    
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }
}
