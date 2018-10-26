package com.example.anicodebreaker.dbms_project.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CustAccLoan {

    @SerializedName("customerid")
    @Expose
    private Object customerid;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("password")
    @Expose
    private Object password;
    @SerializedName("street")
    @Expose
    private String street;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("accounts")
    @Expose
    private List<Account> accounts = null;
    @SerializedName("loans")
    @Expose
    private List<Loan> loans = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public CustAccLoan() {
    }

    /**
     *
     * @param loans
     * @param username
     * @param accounts
     * @param customerid
     * @param street
     * @param name
     * @param password
     * @param city
     */
    public CustAccLoan(Object customerid, String username, String name, Object password, String street, String city, List<Account> accounts, List<Loan> loans) {
        super();
        this.customerid = customerid;
        this.username = username;
        this.name = name;
        this.password = password;
        this.street = street;
        this.city = city;
        this.accounts = accounts;
        this.loans = loans;
    }

    public Object getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Object customerid) {
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

    public Object getPassword() {
        return password;
    }

    public void setPassword(Object password) {
        this.password = password;
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

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }

}