package com.example.storage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    String TAG = "Information Storage";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button singinButton = findViewById(R.id.singin);

        singinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoSingin(view);
            }
        });

    }

    public void gotoSingin(View view){
        Intent singinIntent = new Intent(this,singin.class);
        startActivity(singinIntent);
    }
}