package com.Luis_Salazar_2doParcial_prueba_01.apps.Luis_Salazar_2doParcial_02_prueba;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity_LOSR extends AppCompatActivity {

    private Button btnLogin;
    private EditText txtUser;
    private EditText txtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activiy);
        btnLogin = findViewById(R.id.buttonLogin);
        txtUser = findViewById(R.id.editTextUsuario);
        txtPass = findViewById(R.id.editTextPasswd);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alJuego(view);
            }
        });
    }

    public void alJuego(View view){
        if (txtUser.getText().toString().equals("luisSalazar") && txtPass.getText().toString().equals("accesoLuis1")
                || (txtUser.getText().toString().equals("orlandoRamos") && txtPass.getText().toString().equals("accesoOrlando2")))
        {
            Intent juego = new Intent(this,MainActivity_LOSR.class);
            juego.putExtra("nickname",txtUser.getText().toString());
            startActivity(juego);
        }
        else
        {
            Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
        }

    }
}