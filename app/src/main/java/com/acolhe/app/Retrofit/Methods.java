package com.acolhe.app.Retrofit;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface Methods {

    @GET("acolhe/usuario/ofensiva/1")
    Call<Model> getAllData();

    @POST("acolhe/usuario/inserirUsuario")
    Call<StringModel> postUser(@Body User user);


    @GET("acolhe/usuario/byEmailSenha/{email}/{senha}")
    Call<LoginModel> loginUser(@Path("email") String email, @Path("senha") String senha);



}
