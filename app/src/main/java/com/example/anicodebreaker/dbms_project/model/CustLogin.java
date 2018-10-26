package com.example.anicodebreaker.dbms_project.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CustLogin {

    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("success")
    @Expose
    private String success;

    /**
     * No args constructor for use in serialization
     *
     */
    public CustLogin() {
    }

    /**
     *
     * @param success
     * @param msg
     */
    public CustLogin(String msg, String success) {
        super();
        this.msg = msg;
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

}