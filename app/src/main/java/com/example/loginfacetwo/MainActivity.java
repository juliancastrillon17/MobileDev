package com.example.loginfacetwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String TAG = "Depurar";
    TextView users;
    TextView emails;
    TextView passwords;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.sing);
        users = findViewById(R.id.user);
        emails = findViewById(R.id.email);
        passwords = findViewById(R.id.password);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sing(view);
            }
        });
    }

    public void sing(View view){
        String user1 = users.getText().toString();
        String email1 = emails.getText().toString();
        String password1 = passwords.getText().toString();

        Intent pageSing = new Intent(this,page.class);
        pageSing.putExtra("user",user1);
        pageSing.putExtra("email",email1);
        pageSing.putExtra("password",password1);
        startActivity(pageSing);
    }
}