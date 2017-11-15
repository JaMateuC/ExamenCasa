package Programa;

public class Producto {

    private int numComprado;
    private String nombre;
    private double coste;

    public Producto() {
    }

    public Producto(String nombre, double coste) {
        this.numComprado = 1;
        this.nombre = nombre;
        this.coste = coste;
    }

    public int getNumComprado() {
        return numComprado;
    }

    public void setNumComprado(int numComprado) {
        this.numComprado = numComprado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCoste() {
        return coste;
    }

    public void setCoste(double coste) {
        this.coste = coste;
    }

    public void addCompra(){
        this.numComprado++;
    }

    @Override
    public String toString(){
        return "Nombre : " + this.nombre + ", Precio : " + this.coste + ", NumComprado : " + this.numComprado;
    }

}
