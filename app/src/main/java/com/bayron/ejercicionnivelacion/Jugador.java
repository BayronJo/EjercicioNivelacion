package com.bayron.ejercicionnivelacion;

public class Jugador {
    private  String Nombre;
    private  int Puntos;

    public Jugador(String nombre, int puntos) {
        Nombre = nombre;
        Puntos = puntos;
    }

    public String getNombre() {
        return Nombre;
    }

    public int getPuntos() {
        return Puntos;
    }
}
