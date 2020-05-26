package com.uisrael.jessicachicaiza_examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText etUser, etPassword;
    String usuario="estudiante2020";
    String clave="uisrael2020";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etUser = findViewById(R.id.etUsuario);
        etPassword = findViewById(R.id.etContrasena);
    }
    public void ingresar(View v) {
        if(etUser.getText().toString().trim().equals(usuario)==true && etPassword.getText().toString().trim().equals(clave)==true){
            Intent intentEnvio = new Intent(this, Registro.class);
            intentEnvio.putExtra("datoEnviado", etUser.getText().toString());
            Toast.makeText(getApplicationContext(),"¡Ingreso Exitoso!", Toast.LENGTH_LONG).show();
            startActivity(intentEnvio);
        }else{
            Toast.makeText(getApplicationContext(),"¡Sus credenciales son Incorrectas!", Toast.LENGTH_LONG).show();
        }
    }

}
