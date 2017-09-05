package com.example.carlos.sesion5;

/**
 * Created by Carlos on 03/09/2017.
 */

public class Alumno {
    private String nombre;
    private String telefono;
    private String escolaridad;
    private String genero;
    private String libro;
    private boolean deporte;

    public Alumno(){
        deporte = false;
        genero = "Femenino";
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEscolaridad() {
        return escolaridad;
    }

    public void setEscolaridad(String escolaridad) {
        this.escolaridad = escolaridad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getLibro() {
        return libro;
    }

    public void setLibro(String libro) {
        this.libro = libro;
    }

    public boolean isDeporte() {
        return deporte;
    }

    public void setDeporte(boolean deporte) {
        this.deporte = deporte;
    }

    public String toString(){
        return "Nombre: " + getNombre() + "\n" + "Telefono: " + getTelefono() + "\n" + "Escolaridad: " + getEscolaridad() + "\n" +
                "Genero: " + getGenero() + "\n" +"Libro: " + getLibro() + "\n" + "Practica Deporte: " + isDeporte();
    }
}
