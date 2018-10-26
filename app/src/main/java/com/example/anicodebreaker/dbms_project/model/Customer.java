package com.example.anicodebreaker.dbms_project.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Customer {

    @SerializedName("customerid")
    @Expose
    private Integer customerid;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("street")
    @Expose
    private String street;
    @SerializedName("city")
    @Expose
    private String city;

    /**
     * No args constructor for use in serialization
     *
     */
    public Customer() {
    }

    /**
     *
     * @param username
     * @param customerid
     * @param street
     * @param name
     * @param city
     */
    public Customer(Integer customerid, String username, String name, String street, String city) {
        super();
        this.customerid = customerid;
        this.username = username;
        this.name = name;
        this.street = street;
        this.city = city;
    }

    public Integer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Integer customerid) {
        this.customerid = customerid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}