package com.example.anicodebreaker.dbms_project.rest;

import com.example.anicodebreaker.dbms_project.model.CustAll;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("/customer/list/all/")
    Call<List<CustAll>> getAllCustomers();
}
