package com.example.anicodebreaker.dbms_project.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Branch_ {

    @SerializedName("branchname")
    @Expose
    private String branchname;
    @SerializedName("branchcity")
    @Expose
    private String branchcity;
    @SerializedName("assets")
    @Expose
    private Integer assets;

    /**
     * No args constructor for use in serialization
     *
     */
    public Branch_() {
    }

    /**
     *
     * @param assets
     * @param branchcity
     * @param branchname
     */
    public Branch_(String branchname, String branchcity, Integer assets) {
        super();
        this.branchname = branchname;
        this.branchcity = branchcity;
        this.assets = assets;
    }

    public String getBranchname() {
        return branchname;
    }

    public void setBranchname(String branchname) {
        this.branchname = branchname;
    }

    public String getBranchcity() {
        return branchcity;
    }

    public void setBranchcity(String branchcity) {
        this.branchcity = branchcity;
    }

    public Integer getAssets() {
        return assets;
    }

    public void setAssets(Integer assets) {
        this.assets = assets;
    }

}