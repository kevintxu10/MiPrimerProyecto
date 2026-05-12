package DAO;

import model.Cancha;
import org.example.proyecto_demo.ConexionBD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CanchaDAO {
    // Listar para el TableView
    public List<Cancha> listarCanchas() {
        List<Cancha> lista = new ArrayList<>();
        String sql = "SELECT id_cancha, nombre, tipo, precio_hora FROM Canchas"; // Nombres de tu SQL
        try (Connection conn = ConexionBD.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Cancha(
                        rs.getInt("id_cancha"),
                        rs.getString("nombre"),
                        rs.getString("tipo"),
                        rs.getDouble("precio_hora")
                ));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return lista;
    }

    // Insertar con validación de nombre duplicado
    public boolean insertarCancha(String nombre, String tipo, double precio) {
        if (existeNombre(nombre)) return false; // Validación requerida para Persona B

        String sql = "INSERT INTO Canchas (nombre, tipo, precio_hora) VALUES (?, ?, ?)";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            pstmt.setString(2, tipo);
            pstmt.setDouble(3, precio);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) { return false; }
    }

    private boolean existeNombre(String nombre) {
        String sql = "SELECT id_cancha FROM Canchas WHERE nombre = ?";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            return pstmt.executeQuery().next();
        } catch (SQLException e) { return false; }
    }
}
