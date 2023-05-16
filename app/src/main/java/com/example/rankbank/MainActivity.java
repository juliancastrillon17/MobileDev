package com.example.rankbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    String TAG = "Information Storage";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button singinButton = findViewById(R.id.singin);
        Button signupButton = findViewById(R.id.signup);

        singinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoSingin(view);
            }
        });

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoSignup(view);
            }
        });
    }


    public void gotoSingin(View view){
        Intent singinIntent = new Intent(this,singinTwo.class);
        startActivity(singinIntent);
    }

    public void gotoSignup(View view){
        Intent signupIntent = new Intent(this,signup.class);
        startActivity(signupIntent);
    }
}