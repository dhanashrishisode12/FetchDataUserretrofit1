package com.example.fetchdatauserretrofit1;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyInterface {
    String JSONURL = "http://aadspart.freeoda.com/user_login/";

    @GET("get_services.php")
    Call<List<ServiceData>> get_services();
}
