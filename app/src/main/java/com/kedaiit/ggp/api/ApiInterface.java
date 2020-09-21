package com.kedaiit.ggp.api;

import com.kedaiit.ggp.model.login.Login;
import com.kedaiit.ggp.model.register.Register;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {

//    @FormUrlEncoded
//    @POST("api/gate/login.php")
//    Call<Login> loginResponse(
//            @Body Login login
//
//    );

    @FormUrlEncoded
    @POST("api/gate/login.php")
    Call<Login> loginResponse(
            @Field("indeks") String indeks,
            @Field("kata_sandi") String kata_sandi
    );

    @FormUrlEncoded
    @POST("register.php")
    Call<Register> registerResponse(
            @Field("username") String username,
            @Field("password") String password,
            @Field("name") String name
    );


//    Call<Login> loginResponse(String indeks, String kataSandi);
}
