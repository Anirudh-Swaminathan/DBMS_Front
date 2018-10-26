package com.example.anicodebreaker.dbms_project.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Account {

    @SerializedName("accountid")
    @Expose
    private Integer accountid;
    @SerializedName("accountnumber")
    @Expose
    private Integer accountnumber;
    @SerializedName("balance")
    @Expose
    private Integer balance;
    @SerializedName("isa")
    @Expose
    private String isa;
    @SerializedName("branch")
    @Expose
    private Branch branch;

    /**
     * No args constructor for use in serialization
     *
     */
    public Account() {
    }

    /**
     *
     * @param balance
     * @param isa
     * @param branch
     * @param accountnumber
     * @param accountid
     */
    public Account(Integer accountid, Integer accountnumber, Integer balance, String isa, Branch branch) {
        super();
        this.accountid = accountid;
        this.accountnumber = accountnumber;
        this.balance = balance;
        this.isa = isa;
        this.branch = branch;
    }

    public Integer getAccountid() {
        return accountid;
    }

    public void setAccountid(Integer accountid) {
        this.accountid = accountid;
    }

    public Integer getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(Integer accountnumber) {
        this.accountnumber = accountnumber;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public String getIsa() {
        return isa;
    }

    public void setIsa(String isa) {
        this.isa = isa;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

}