package com.example.loginfacetwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
        Button sv = findViewById(R.id.save);
        users = findViewById(R.id.user);
        emails = findViewById(R.id.email);
        passwords = findViewById(R.id.password);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sing(view);
            }
        });

        SharedPreferences preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        SharedPreferences preferencesE = getSharedPreferences("credencialesE", Context.MODE_PRIVATE);
        SharedPreferences preferencesP = getSharedPreferences("credencialesP", Context.MODE_PRIVATE);


        users.setText(preferences.getString("user",""));
        emails.setText(preferencesE.getString("email",""));
        passwords.setText(preferencesP.getString("password",""));


        sv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guardar(view);
            }
        });
    }

    public void guardar(View view){
        SharedPreferences preferencias = getSharedPreferences("credenciales",Context.MODE_PRIVATE);
        SharedPreferences preferenciasE = getSharedPreferences("credencialesE",Context.MODE_PRIVATE);
        SharedPreferences preferenciasP = getSharedPreferences("credencialesP",Context.MODE_PRIVATE);


        SharedPreferences.Editor Object_editor = preferencias.edit(); // Hereda las propiedades de la clase y permite modificar la info a guardar;
        // El método Edit guarda la información modificada;
        SharedPreferences.Editor ObjectE_editor = preferenciasE.edit();
        SharedPreferences.Editor ObjectP_editor = preferenciasP.edit();

        Object_editor.putString("user",users.getText().toString());
        ObjectE_editor.putString("email",emails.getText().toString());
        ObjectP_editor.putString("password",passwords.getText().toString());

        Object_editor.commit(); // Vaciado de la información;
        ObjectE_editor.commit(); // Vaciado de la información;
        ObjectP_editor.commit(); // Vaciado de la información;

        finish();
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