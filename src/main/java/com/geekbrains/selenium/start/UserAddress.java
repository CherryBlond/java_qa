package com.geekbrains.selenium.start;

public class UserAddress {
    private String address;
    private String city;
    private String state;
    private String postcode;
    private String phone;

    public UserAddress(String address, String city, String state, String postcode, String phone) {
        this.address = address;
        this.city = city;
        this.state = state;
        this.postcode = postcode;
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getPhone() {
        return phone;
    }
}
