package DAO;

import org.example.proyecto_demo.ConexionBD; // Asegúrate que esta ruta coincide con tu ConexionBD
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    public boolean validarLogin(String email, String password) {
        String sql = "SELECT * FROM Usuario WHERE email = ? AND password = ?";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, email);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();

            return rs.next();

        } catch (SQLException e) {
            System.out.println("Error en el login: " + e.getMessage());
            return false;
        }
    }

    public boolean registrarUsuario(String nombre, String email, String password) {

        String sql = "INSERT INTO Usuario (nombre, email, password, rol) VALUES (?, ?, ?, 'user')";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nombre);
            pstmt.setString(2, email);
            pstmt.setString(3, password);

            int filas = pstmt.executeUpdate();
            return filas > 0;
        } catch (SQLException e) {
            // Esto te dirá exactamente qué palabra está rechazando MySQL
            System.out.println("ERROR SQL DETALLADO: " + e.getMessage());
            return false;
        }
    }
}
