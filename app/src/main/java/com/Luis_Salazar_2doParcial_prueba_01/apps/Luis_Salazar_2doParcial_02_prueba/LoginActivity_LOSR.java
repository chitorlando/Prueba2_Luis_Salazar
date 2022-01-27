package com.Luis_Salazar_2doParcial_prueba_01.apps.Luis_Salazar_2doParcial_02_prueba;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity_LOSR extends AppCompatActivity {

    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activiy);
        btnLogin = findViewById(R.id.buttonLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alJuego(view);
            }
        });
    }

    public void alJuego(View view){
        Intent juego = new Intent(this,MainActivity_LOSR.class);
        startActivity(juego);
    }
}