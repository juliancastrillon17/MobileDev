package com.example.ciclovida;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String TAG = "CicloDeVida";

    TextView results;
    TextView first;
    TextView second;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG,"Estamos en onCreate");


        first = findViewById(R.id.firstParameter);
        second = findViewById(R.id.secondParameter);
        results = findViewById(R.id.result);

        Button btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoActivity2(view);
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "Estamos en onStart");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "Estamos en onRestart");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "Estamos en onResume");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "Estamos en onPause");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "Estamos en onStop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Estamos en onDestroy");

    }

    public void gotoActivity2(View view){
        String n1 = first.getText().toString();
        String n2 = second.getText().toString();

        int valor1 = Integer.parseInt(n1);
        int valor2 = Integer.parseInt(n2);

        int resultado = valor1 * valor2;
        String finalResult = resultado + "";

        results.setText(finalResult);

        Intent pasarDato = new Intent(this,secondScreen.class); // Con lo que se pasan datos de una pantalla a otra;
        pasarDato.putExtra("firstValue",valor1);
        pasarDato.putExtra("secondValue",valor2);
        pasarDato.putExtra("response",resultado);
        startActivity(pasarDato);
    }


}