package com.example.anicodebreaker.dbms_project.rest;

import com.example.anicodebreaker.dbms_project.model.CustAccLoan;
import com.example.anicodebreaker.dbms_project.model.CustAll;
import com.example.anicodebreaker.dbms_project.model.CustLogin;
import com.example.anicodebreaker.dbms_project.model.UpdCust;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface ApiInterface {
    // Customer List
    @GET("/customer/list/all/")
    Call<List<CustAll>> getAllCustomers();

    @Headers({
            "Content-Type: application/x-www-form-urlencoded"
    })
    @POST("/customer/update/new/")
    //Call<UpdCust> createNewCustomer(@field("email") String email, @field("password") String password);
    Call<UpdCust> createNewCustomer(@QueryMap Map<String, String> options);

    @Headers({
            "Content-Type: application/x-www-form-urlencoded"
    })
    @POST("/customer/login/")
    Call<CustLogin> customerLogin(@QueryMap Map<String, String> options);

    @GET("/customer/getwithaccountsandloans/{user}/")
    Call<CustAccLoan> getCustomerDetails(
            @Path("user") String user
    );
}
