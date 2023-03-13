package com.example.loginfacetwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class page extends AppCompatActivity {

    public String user;
    public String email;
    public String password;
    public String phoneNumber = "3192110866";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page);

        user = getIntent().getStringExtra("user");
        email = getIntent().getStringExtra("email");
        password = getIntent().getStringExtra("password");

        publicResults(user,email,password);

        Button google = findViewById(R.id.goog);
        Button call = findViewById(R.id.phone);

        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoGoogle(view);
            }
        });

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callPhone(view);
            }
        });
    }

    public void gotoGoogle(View view){
        Intent google = new Intent(Intent.ACTION_VIEW);
        google.setData(Uri.parse("https://www.google.com/"));
        startActivity(google);
    }

    public void callPhone(View view){
        Intent callP = new Intent(Intent.ACTION_DIAL);
        callP.setData(Uri.parse("tel:"+phoneNumber));
        if(callP.resolveActivity(getPackageManager())!=null){
            startActivity(callP);
        }
    }

    public void publicResults(String user1,String email1,String password1){
        TextView userP = findViewById(R.id.userPrint);
        TextView emailP = findViewById(R.id.emailPrint);
        TextView passwordP = findViewById(R.id.passwordPrint);
        userP.setText(user1);
        emailP.setText(email1);
        passwordP.setText(password1);
    }
}