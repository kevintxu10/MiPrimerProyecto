package model;

public class Usuario {
    private int id_usuario;
    private String nombre;
    private String email;
    private String password;
    private String rol;


    public Usuario() {}

    // Constructor
    public Usuario(int id_usuario, String nombre, String email, String password, String rol) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.rol = rol;
    }

    // Getters
    public int getId_usuario() { return id_usuario; }
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
    public String getRol() { return rol; }
}
