package com.uisrael.jessicachicaiza_examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class Registro extends AppCompatActivity {

    Bundle datoUsuario;
    TextView mostrarUsuario,etCuota, etUsers;
    EditText etNombre, etMonto ;
    String Totalf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        mostrarUsuario = findViewById(R.id.etUser);
        datoUsuario=getIntent().getExtras();
        String RecibirDato=datoUsuario.getString("datoEnviado");
        mostrarUsuario.setText(RecibirDato);
        etNombre = findViewById(R.id.etNombre);
        etMonto = findViewById(R.id.etMontoInicial);
        etCuota=findViewById(R.id.etCuotaM);
        etUsers=findViewById(R.id.etUser);
    }

    public void calcular(View v) {


        double totalCurso=1800, montoInicial, resultado, cuota, interes, cuotaFinal, total;
        montoInicial=Double.parseDouble(etMonto.getText().toString());

        if (montoInicial >= 1800){
            Toast.makeText(getApplicationContext(),"¡Ud desea pagar el costo total, No aplicaria para cuotas!", Toast.LENGTH_LONG).show();
            etCuota.setText(obtieneDosDecimales(0.00));
        }

        if (montoInicial >=  1  && montoInicial <  1800){
            resultado=totalCurso-montoInicial;
            cuota=resultado/3;
            interes=totalCurso*0.05;
            cuotaFinal=cuota+interes;
            etCuota.setText(obtieneDosDecimales(cuotaFinal));
            total=(cuotaFinal*3)+ montoInicial;
            Totalf= obtieneDosDecimales(total);

        }
    }

    public void guardar(View v) {

        Intent intentEnvio = new Intent(this, Encuesta.class);
        intentEnvio.putExtra("Usuario", etUsers.getText().toString());
        intentEnvio.putExtra("Nombre", etNombre.getText().toString());
        intentEnvio.putExtra("PagoMensual", etCuota.getText().toString());
        intentEnvio.putExtra("MontoInicial", etMonto.getText().toString());
        intentEnvio.putExtra("Total",Totalf);
        Toast.makeText(getApplicationContext(),"¡Elemento Guardado con éxito!", Toast.LENGTH_LONG).show();
        startActivity(intentEnvio);
    }

    private String obtieneDosDecimales(double valor){
        DecimalFormat format = new DecimalFormat();
        format.setMaximumFractionDigits(2); //Define 2 decimales
        return format.format(valor);
    }


}
