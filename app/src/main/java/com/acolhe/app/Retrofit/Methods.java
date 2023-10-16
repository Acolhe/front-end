package com.acolhe.app.Retrofit;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Methods {

    @GET("usuario/vertodos2/4")
    Call<Model> getAllData();
}
