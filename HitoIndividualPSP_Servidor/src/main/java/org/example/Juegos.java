package org.example;

public class Juegos {
    private String nombre;
    private float nota;
    private String empresa;
    private String fecha;

    public Juegos(String nombre, float nota, String empresa, String fecha) {
        this.nombre = nombre;
        this.nota = nota;
        this.empresa = empresa;
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public float getNota() {
        return nota;
    }

    public String getEmpresa() {
        return empresa;
    }

    public String getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return "Juegos{" +
                "nombre='" + nombre + '\'' +
                ", nota=" + nota +
                ", empresa='" + empresa + '\'' +
                ", fecha='" + fecha + '\'' +
                '}';
    }
}
