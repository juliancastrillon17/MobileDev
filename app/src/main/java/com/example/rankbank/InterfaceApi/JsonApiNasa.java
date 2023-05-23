package com.example.rankbank.InterfaceApi;

//import android.telecom.Call;

import com.example.rankbank.Model.Posts;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface JsonApiNasa {

    @GET("photos?sol=1000&api_key=DEMO_KEY")
    Call<Posts> getPosts();

}
