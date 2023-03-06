package com.example.ciclovida;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class secondScreen extends AppCompatActivity {


    public int results;
    public int valorUno;
    public int valorDos;
    public String total;
    public String vOneT;
    public String vTwoT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);
        // Obtengo lo recibido;
        results = getIntent().getIntExtra("response",0);
        valorUno = getIntent().getIntExtra("firstValue",0);
        valorDos = getIntent().getIntExtra("secondValue",0);
        total = results + "";
        vOneT = valorUno + "";
        vTwoT = valorDos + "";

        publicarResultado(total,vOneT,vTwoT);
    }

    public void publicarResultado(String response,String uno, String dos){
        TextView res = findViewById(R.id.responseText);
        TextView vOne = findViewById(R.id.responseValueOne);
        TextView vTwo = findViewById(R.id.responseValueTwo);
        vOne.setText(uno);
        vTwo.setText(dos);
        res.setText(response);
    };
}