package model;

public class Cancha {
    private int idCancha;
    private String nombre;
    private String tipo;
    private double precioHora;

    public Cancha(int idCancha, String nombre, String tipo, double precioHora) {
        this.idCancha = idCancha;
        this.nombre = nombre;
        this.tipo = tipo;
        this.precioHora = precioHora;
    }

    // Getters exactos para el TableView
    public int getIdCancha() { return idCancha; }
    public String getNombre() { return nombre; }
    public String getTipo() { return tipo; }
    public double getPrecioHora() { return precioHora; }
}
