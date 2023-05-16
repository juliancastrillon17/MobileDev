package com.example.rankbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class signup extends AppCompatActivity {

    private EditText videntification, vuser, vpass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        videntification = findViewById(R.id.identification);
        vuser = findViewById(R.id.user);
        vpass = findViewById(R.id.password);
    }

    public void sing(View view){
        AdminBD admin = new AdminBD(this,"BaseDatos",null,1);
        SQLiteDatabase BaseDatos = admin.getWritableDatabase();
        String identificacion = videntification.getText().toString();
        String usuario = vuser.getText().toString();
        String contrasena = vpass.getText().toString();

        if(!identificacion.isEmpty() && !usuario.isEmpty() && !contrasena.isEmpty()){
            ContentValues registro = new ContentValues();
            registro.put("identificacion",identificacion);
            registro.put("usuario",usuario);
            registro.put("pass",contrasena);

            BaseDatos.insert("usuario",null,registro);
            BaseDatos.close();
            videntification.setText("");
            vuser.setText("");
            vpass.setText("");
            Toast.makeText(this,"Se almacenó el registro exitosamente",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this,"Ingrese todos los campos correctamente",Toast.LENGTH_LONG).show();
        }
    }
}