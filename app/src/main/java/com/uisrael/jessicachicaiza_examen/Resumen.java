package com.uisrael.jessicachicaiza_examen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Resumen extends AppCompatActivity {


    Bundle datoRes;
    TextView mostrarRes1,mostrarRes2, mostrarRes3,mostrarResUsuario, mostrarNombre,mostrarCuotaM,mostrarMontoInicial,mostrarTotal;
    String RecibirDato, RecibirDato2, RecibirDato3,RecibirDatoU,RecibirDatoNombre,RecibirPagoMensual,RecibirMontoInicial,RecibirTotal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen);
        mostrarRes1 = findViewById(R.id.etRes1);
        mostrarRes2 = findViewById(R.id.etRes2);
        mostrarRes3 = findViewById(R.id.etRes3);
        mostrarResUsuario = findViewById(R.id.etUser);
        mostrarNombre = findViewById(R.id.etNombre);
        mostrarCuotaM = findViewById(R.id.etPagoM);
        mostrarMontoInicial = findViewById(R.id.etMontoI);
        mostrarTotal = findViewById(R.id.etTotal);
        datoRes=getIntent().getExtras();
        RecibirDato=datoRes.getString("respuesta1");
        mostrarRes1.setText(RecibirDato);
        RecibirDato2=datoRes.getString("respuesta2");
        mostrarRes2.setText(RecibirDato2);
        RecibirDato3=datoRes.getString("respuesta3");
        mostrarRes3.setText(RecibirDato3);
        RecibirDatoU=datoRes.getString("usuario");
        mostrarResUsuario.setText(RecibirDatoU);
        RecibirDatoNombre=datoRes.getString("Nombre");
        mostrarNombre.setText(RecibirDatoNombre);
        RecibirPagoMensual=datoRes.getString("PagoMensual");
        mostrarCuotaM.setText(RecibirPagoMensual);
        RecibirMontoInicial=datoRes.getString("MontoInicial");
        mostrarMontoInicial.setText(RecibirMontoInicial);
        RecibirTotal=datoRes.getString("TotalF");
        mostrarTotal.setText(RecibirTotal);
    }
}
