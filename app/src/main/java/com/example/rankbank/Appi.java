package com.example.rankbank;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.rankbank.InterfaceApi.JsonApiNasa;
import com.example.rankbank.Model.Posts;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Appi extends AppCompatActivity {

    public String usuario;
    public String contrasena;
    TextView user;

    private TextView mJsonTxtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appi);

        usuario = getIntent().getStringExtra("usuario");
        contrasena = getIntent().getStringExtra("contrasena");

        user = findViewById(R.id.userText);
        user.setText(usuario);

        mJsonTxtView = findViewById(R.id.resultsApi);
        getPosts();
    }

    private void getPosts() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonApiNasa jsonApiNasa = retrofit.create(JsonApiNasa.class);
        Call<Posts> call = jsonApiNasa.getPosts();
        call.enqueue(new Callback<Posts>() {
            @Override
            public void onResponse(Call<Posts> call, Response<Posts> response) {
                if (!response.isSuccessful()) {
                    mJsonTxtView.setText("codigo: " + response.code());
                    return;
                }

                Posts post = response.body();
                String content = "";
                List photos = post.getPhotos();


                content += "Photos:"+ post.getPhotos().get(1) +"\n";


                mJsonTxtView.setText(content);


            }

            @Override
            public void onFailure(Call<Posts> call, Throwable t) {
                mJsonTxtView.setText(t.getMessage());
            }
        });
    }


}

