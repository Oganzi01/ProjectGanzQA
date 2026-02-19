package com.ganz.fw;

public class User {
    private String name;
    private String email;
    private String password;

    // Добавляем конструктор, который принимает 3 параметра
    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    // Геттеры для доступа к данным
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
}