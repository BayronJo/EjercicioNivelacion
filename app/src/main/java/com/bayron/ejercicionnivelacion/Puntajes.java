package com.bayron.ejercicionnivelacion;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Puntajes extends ListActivity  {
    private ArrayList<String> lstjugadores;
    private ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_puntajes)
        lstjugadores = new ArrayList<>();

        Collections.sort(MainActivity.lstjugadores, new Comparator<Jugador>() {
            @Override
            public int compare(Jugador o1, Jugador o2) {
                return new Integer(o2.getPuntos()).compareTo(new Integer(o1.getPuntos()));
            }
        });
            for (int i = 0; i < 3; i++) {
                Jugador ju = MainActivity.lstjugadores.get(i);
                lstjugadores.add(ju.getNombre() + " " + String.valueOf(ju.getPuntos()) + "pts");
            }
            adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, lstjugadores);
            this.setListAdapter(adapter);

    }
}
