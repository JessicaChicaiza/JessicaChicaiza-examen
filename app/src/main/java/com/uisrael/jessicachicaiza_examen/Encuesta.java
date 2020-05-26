package com.uisrael.jessicachicaiza_examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Encuesta extends AppCompatActivity {

    Bundle datoUsuario;
    TextView mostrarUsuario,etUsers, Nombre,Monto ,Total, CuotaMensual;
    RadioButton rb1, rb2;
    CheckBox cb1, cb2, cb3;
    EditText etRes;
    String RecibirDato, RecibirNombre,RecibirMonto,RecibirCuota,Totalf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encuesta);
        mostrarUsuario = findViewById(R.id.etUser);
        datoUsuario=getIntent().getExtras();
        RecibirDato=datoUsuario.getString("Usuario");
        RecibirNombre=datoUsuario.getString("Nombre");
        RecibirMonto=datoUsuario.getString("MontoInicial");
        RecibirCuota=datoUsuario.getString("PagoMensual");
        Totalf=datoUsuario.getString("Total");
        mostrarUsuario.setText(RecibirDato);
        rb1=findViewById(R.id.rbOpcion1);
        rb2=findViewById(R.id.rbOpcion2);
        cb1=findViewById(R.id.cbOpcion1);
        cb2=findViewById(R.id.cbOpcion2);
        cb3=findViewById(R.id.cbOpcion3);
        etRes = findViewById(R.id.etRespuesta1);
        etUsers=findViewById(R.id.etUser);
    }
    public String VerificarCheckBox(){
        String res2="";

        if(cb1.isChecked()==true && cb2.isChecked()==false && cb3.isChecked()==false){
            res2="Fútbol";
        }
        if(cb2.isChecked()==true && cb1.isChecked()==false && cb3.isChecked()==false){
            res2="Basketball";
        }
        if(cb3.isChecked()==true && cb1.isChecked()==false && cb2.isChecked()==false){
            res2="Voley";
        }
        if(cb1.isChecked()==true && cb2.isChecked()==true && cb3.isChecked()==true ){
            res2="Fútbol, Basketball y Voley";
        }
        if(cb1.isChecked()==true && cb2.isChecked()==true && cb3.isChecked()==false ){
            res2="Fútbol y Basketball ";
        }
        if(cb1.isChecked()==true && cb2.isChecked()==false && cb3.isChecked()==true ){
            res2="Fútbol y Voley";
        }
        if(cb1.isChecked()==false && cb2.isChecked()==true && cb3.isChecked()==true ){
            res2="Basketball y Voley";
        }

        if(cb1.isChecked()==false && cb2.isChecked()==false && cb3.isChecked()==false ){
            res2="¡No has seleccionado ningún deporte!";
        }

        return res2;
    }

    public String VerificarRadio(){
        String res1="";
        if(rb1.isChecked()==true){
            res1= "SI";
        }else{
            res1= "NO";
        }
        return res1;
    }



    public void enviarRespuestas(View v) {
        String resp2 = VerificarCheckBox();
        String resp3= VerificarRadio();
        Intent intentEnvio = new Intent(this, Resumen.class);
        intentEnvio.putExtra("usuario", etUsers.getText().toString());
        intentEnvio.putExtra("respuesta1", etRes.getText().toString());
        intentEnvio.putExtra("respuesta2", resp2);
        intentEnvio.putExtra("respuesta3", resp3 );
        intentEnvio.putExtra("Nombre", RecibirNombre);
        intentEnvio.putExtra("PagoMensual",RecibirCuota);
        intentEnvio.putExtra("MontoInicial",RecibirMonto);
        intentEnvio.putExtra("TotalF",Totalf);
        Toast.makeText(getApplicationContext(),"¡Datos Enviados!", Toast.LENGTH_LONG).show();
        startActivity(intentEnvio);

    }
}
