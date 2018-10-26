package com.example.anicodebreaker.dbms_project.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Loan {

    @SerializedName("loannumber")
    @Expose
    private Integer loannumber;
    @SerializedName("amount")
    @Expose
    private Integer amount;
    @SerializedName("customer")
    @Expose
    private Customer customer;
    @SerializedName("branch")
    @Expose
    private Branch_ branch;

    /**
     * No args constructor for use in serialization
     *
     */
    public Loan() {
    }

    /**
     *
     * @param amount
     * @param loannumber
     * @param branch
     * @param customer
     */
    public Loan(Integer loannumber, Integer amount, Customer customer, Branch_ branch) {
        super();
        this.loannumber = loannumber;
        this.amount = amount;
        this.customer = customer;
        this.branch = branch;
    }

    public Integer getLoannumber() {
        return loannumber;
    }

    public void setLoannumber(Integer loannumber) {
        this.loannumber = loannumber;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Branch_ getBranch() {
        return branch;
    }

    public void setBranch(Branch_ branch) {
        this.branch = branch;
    }

}