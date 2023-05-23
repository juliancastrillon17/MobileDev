package com.example.rankbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class singinTwo extends AppCompatActivity {

    private EditText vuser, vpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singin_two);

        vuser = findViewById(R.id.usserOne);
        vpass = findViewById(R.id.passwordOne);
    }

    public void consulta(View view){
        AdminBD admin = new AdminBD(this,"BaseDatos",null,1);
        SQLiteDatabase BaseDatos = admin.getWritableDatabase();
        String usuario = vuser.getText().toString();
        String contrasena = vpass.getText().toString();
        if(!usuario.isEmpty() && !contrasena.isEmpty()){
            Cursor fila = BaseDatos.rawQuery("select identificacion from usuario where usuario = '"+usuario+"' and pass = '"+contrasena+"'",null);
            vuser.setText(String.valueOf(fila.getCount()));

            if(fila.getCount()>0){
                Intent sing = new Intent(this,Appi.class);
                sing.putExtra("usuario",usuario);
                sing.putExtra("contrasena",contrasena);
                startActivity(sing);
            }
        }else {
            Toast.makeText(this, "No se encontró el usuario en la base de datos", Toast.LENGTH_LONG).show();
        }
    }
}