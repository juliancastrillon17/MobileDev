package com.example.storage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class singin extends AppCompatActivity {

    private EditText videntification, vname, vnumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singin);

        videntification = findViewById(R.id.identification);
        vname = findViewById(R.id.name);
        vnumber = findViewById(R.id.number);

    }

    public void sing(View view){
        AdminBD admin = new AdminBD(this,"BaseDatos",null,1);
        SQLiteDatabase BaseDatos = admin.getWritableDatabase();
        String identificacion = videntification.getText().toString();
        String nombre = vname.getText().toString();
        String numero = vnumber.getText().toString();

        if(!identificacion.isEmpty() && !nombre.isEmpty() && !numero.isEmpty()){
            ContentValues registro = new ContentValues();
            registro.put("identificacion",identificacion);
            registro.put("nombre",nombre);
            registro.put("numero",numero);

            BaseDatos.insert("usuario",null,registro);
            BaseDatos.close();
            videntification.setText("");
            vname.setText("");
            vnumber.setText("");
            Toast.makeText(this,"Se almacenó el registro exitosamente",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this,"Ingrese todos los campos correctamente",Toast.LENGTH_LONG).show();
        }
    }

    public void consulta(View view){
        AdminBD admin = new AdminBD(this,"BaseDatos",null,1);
        SQLiteDatabase BaseDatos = admin.getWritableDatabase();
        String document = videntification.getText().toString();
        if(!document.isEmpty()){
            Cursor fila = BaseDatos.rawQuery("select nombre,numero from usuario where identificacion = "+document,null);
            if(fila.moveToFirst()){
                vname.setText(fila.getString(0));
                vnumber.setText(fila.getString(1));
                BaseDatos.close();
            }
        }else {
            Toast.makeText(this, "No se encontró el usuario en la base de datos", Toast.LENGTH_LONG).show();
        }
    }
}