package com.Luis_Salazar_2doParcial_prueba_01.apps.Luis_Salazar_2doParcial_01_prueba;

import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LOSR_LoginActivity extends AppCompatActivity {
    private EditText editTextUsr;
    private EditText editTextPasswd;

    private Button buttonLogin;
    private Button btn_Edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activiy);

        editTextUsr = findViewById(R.id.editTextUsuario);
        editTextPasswd = findViewById(R.id.editTextPasswd);

        buttonLogin = findViewById(R.id.buttonLogin);
        btn_Edit = findViewById(R.id.btn_Edit);


        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ValidarUsuario(view);
            }
        });

       /* buttonCrud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditUserInformation(view);
            }
        });*/
        btn_Edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   EditUserInformation(view);
                }
        });

    }

    private void ValidarUsuario(View view) {

        LOSR_ClienteDAL clienteDAL = new LOSR_ClienteDAL(this);
        String usr = editTextUsr.getText().toString();
        String passwd = editTextPasswd.getText().toString();
        LOSR_Cliente cliente = new LOSR_Cliente();
//        cliente=clienteDAL.selectByUsrDAL(usr.toString());


        if(cliente!=null)
        {
            Toast.makeText(this,"Hay Datos",Toast.LENGTH_SHORT).show();


        }
        else
        {
            Toast.makeText(this, "No se encontraron registros del cliente en la tabla", Toast.LENGTH_SHORT).show();
        }

        Intent flags = new Intent(this, MainActivity.class);
        startActivity(flags);

    }

    private void EditUserInformation(View view) {
        Intent crudActivity = new Intent(this,LOSR_CrudClientes.class);
        startActivity(crudActivity);
    }
}

