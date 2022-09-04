package com.example.login_app;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Api_Interface
{
    @FormUrlEncoded
    @POST("register.php")
    Call<Api_rep> performregistration(@Field("name") String name,
                                      @Field("user_name") String Username,
                                      @Field("user_password") String Userpassword);

    /*@GET("register.php")
    public Call<Api_rep> performregistration(@Query("name") String Name, @Query("user_name") String UserName, @Query("user_password") String Userpassword);
*/
    @GET("login.php")
    public Call<Api_rep> Performlogin(@Query("user_name") String UserName, @Query("user_password") String Userpassword);
}

