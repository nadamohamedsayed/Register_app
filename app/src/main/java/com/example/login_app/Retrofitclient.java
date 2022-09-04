package com.example.login_app;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofitclient {

    //public static final String BASE_URL= "http://10.0.2.2/loginapp/";
    public static final String BASE_URL= "http://192.168.100.36/loginapp/";
    public static Retrofit retrofit;

    public static Retrofit getApiclient()
    {
      if (retrofit==null)
      {
          retrofit = new Retrofit.Builder()
                  .baseUrl(BASE_URL)
                  .addConverterFactory(GsonConverterFactory.create())
                  .build();

      }
      return retrofit;
    }
}
