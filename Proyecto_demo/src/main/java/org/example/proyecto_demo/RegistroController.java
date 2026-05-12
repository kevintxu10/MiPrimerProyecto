package org.example.proyecto_demo;

import DAO.UsuarioDAO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class RegistroController {
    @FXML private TextField txtNombre, txtEmail;
    @FXML private PasswordField txtPassword;
    @FXML private Label lblMensaje;

    @FXML
    protected void onRegistrarUsuarioClick() {
        UsuarioDAO dao = new UsuarioDAO();
        boolean ok = dao.registrarUsuario(txtNombre.getText(), txtEmail.getText(), txtPassword.getText());

        lblMensaje.getStyleClass().clear();
        if (ok) {
            lblMensaje.getStyleClass().add("my-validated-text");
            lblMensaje.setText("Registro completado con éxito");
        } else {
            lblMensaje.getStyleClass().add("my-error-text");
            lblMensaje.setText("Error al registrar usuario");
        }
    }

    @FXML
    protected void onVolverLoginClick() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) txtEmail.getScene().getWindow();
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
