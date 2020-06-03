package com.geekbrains.selenium.start;

public class UserAccount {
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public UserAccount(String fullName, String email, String password) {
        String[] nameParts = fullName.split(" ", 2);
        this.firstName = nameParts[0];
        this.lastName = nameParts[1];
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
