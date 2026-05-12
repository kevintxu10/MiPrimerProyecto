package org.example.proyecto_demo;

import DAO.UsuarioDAO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class HelloController {
    @FXML private TextField txtEmail;
    @FXML private PasswordField txtPassword;
    @FXML private Label mensajeError;

    @FXML
    protected void onLoginButtonClick() {
        UsuarioDAO dao = new UsuarioDAO();
        String email = txtEmail.getText();
        String pass = txtPassword.getText();

        if (dao.validarLogin(email, pass)) {
            try {
                // Saltamos a la pantalla de la Persona B
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("canchas-view.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 700, 450);
                Stage stage = (Stage) txtEmail.getScene().getWindow();
                stage.setScene(scene);
                stage.setTitle("Mantenimiento de Canchas - Club de Pádel");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            mensajeError.setText("Email o contraseña incorrectos");
        }
    }

    @FXML
    protected void onIrARegistroClick() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("registro-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) txtEmail.getScene().getWindow();
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

