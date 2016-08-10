package com.twu.biblioteca.model;


public class User {
    private String name;
    private String email;
    private String id;
    private long phone;
    private int password;

    public User(String name, String email, String id, long phone, int password) {
        this.name = name;
        this.email = email;
        this.id = id;
        this.phone = phone;
        this.password = password;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public long getPhone() {
        return phone;
    }
    public void setPhone(long phone) {
        this.phone = phone;
    }
    public int getPassword() {
        return password;
    }
    public void setPassword(int password) {
        this.password = password;
    }
}
