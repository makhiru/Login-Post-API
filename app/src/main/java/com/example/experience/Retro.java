package com.example.experience;

import com.example.experience.Models.Login_Data;
import com.example.experience.Models.Ragister_Data;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public class Retro {
    String baseuri = "https://hetsweb.000webhostapp.com/YouApp/";
    public static Retro retro;
    public RetroAPI retroAPI;

    public Retro() {
        Retrofit retrtofit = new Retrofit.Builder()
                .baseUrl(baseuri)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retroAPI = retrtofit.create(RetroAPI.class);
    }

    public static Retro getInstance() {
        if (retro == null) {
            retro = new Retro();
        }
        return retro;
    }

    public interface RetroAPI {

        @FormUrlEncoded
        @POST("register.php")
        Call<Ragister_Data> Ragister_data(@Field("name") String name, @Field("email") String email,
                                          @Field("password") String password);

        @FormUrlEncoded
        @POST("login.php")
        Call<Login_Data> Login_data(@Field("email") String email, @Field("password") String password);

    }
}
