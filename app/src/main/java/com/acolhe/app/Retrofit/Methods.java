package com.acolhe.app.Retrofit;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Methods {

    @GET("acolhe/usuario/ofensiva/1")
    Call<Model> getAllData();
}
