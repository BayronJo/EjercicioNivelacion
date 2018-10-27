package com.bayron.ejercicionnivelacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{

    private Button btnnuevo,btniniciar,btnpuntajes;
    public  static final  int CODIGO_NUEVO =1;
    public  static final  int CODIGO_INICIO =2;
    public  static ArrayList<Jugador> lstjugadores;
    public  static String Nombre="";
    Integer Puntaje =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnnuevo = findViewById(R.id.btnNuevo);
        btniniciar = findViewById(R.id.btniniciar);
        btnpuntajes = findViewById(R.id.btnpuntajes);
        lstjugadores = new ArrayList<>();
        btnnuevo.setOnClickListener(this);
        btniniciar.setOnClickListener(this);
        btnpuntajes.setOnClickListener(this);

        if(Nombre.isEmpty()){
            btniniciar.setEnabled(false);
        }
        btnpuntajes.setEnabled(false);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnNuevo:
                Intent nuevo = new Intent(getApplicationContext(),NuevoJugador.class);
                startActivityForResult(nuevo,CODIGO_NUEVO);
                break;
            case R.id.btniniciar:
                Intent iniciar = new Intent(getApplicationContext(),IniciarJuego.class);
                startActivityForResult(iniciar,CODIGO_INICIO);
                break;
            case R.id.btnpuntajes:
                Intent puntos = new Intent(getApplicationContext(),Puntajes.class);
                startActivity(puntos);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case CODIGO_NUEVO:
                if(data==null) return;
                Nombre = data.getExtras().getString("Nombre");
                btniniciar.setEnabled(true);
                Toast.makeText(this, "Jugador : "+Nombre+"\n"+"Registrado con Exito", Toast.LENGTH_SHORT).show();
                break;
            case  CODIGO_INICIO:
                if(data==null) return;
                Puntaje = data.getExtras().getInt("Puntos");
                String nombre = data.getExtras().getString("Nombre");
                Jugador ju = new Jugador(nombre,Puntaje);
                lstjugadores.add(ju);
                btniniciar.setEnabled(false);
                if(lstjugadores.size()>=3){
                    btnpuntajes.setEnabled(true);
                }
                Toast.makeText(this, "Jugador :"+ nombre +"\n"+"Puntajes " +Puntaje+"\n"+" Insertado con Exito", Toast.LENGTH_SHORT).show();
                break;

        }
    }
}
