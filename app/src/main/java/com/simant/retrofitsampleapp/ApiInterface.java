package com.simant.retrofitsampleapp;

import java.util.List;

import okhttp3.Cache;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("json_parsing.php")
    Call<PlayerInfoModalClass> getInfo();

}