package org.example.proyecto_demo;

import DAO.CanchaDAO;
import model.Cancha;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class CanchasController {
    @FXML private TableView<Cancha> tablaCanchas;
    @FXML private TableColumn<Cancha, Integer> colId;
    @FXML private TableColumn<Cancha, String> colNombre, colTipo;
    @FXML private TableColumn<Cancha, Double> colPrecio;

    @FXML private TextField txtNombre, txtTipo, txtPrecio;
    @FXML private Label lblMensaje;

    private CanchaDAO canchaDAO = new CanchaDAO();

    @FXML
    public void initialize() {
        // Enlazamos las columnas con los atributos del modelo Cancha
        colId.setCellValueFactory(new PropertyValueFactory<>("idCancha"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precioHora"));

        actualizarTabla();
    }

    private void actualizarTabla() {
        // Cargamos los datos desde la BD a la tabla
        tablaCanchas.setItems(FXCollections.observableArrayList(canchaDAO.listarCanchas()));
    }

    @FXML
    protected void onAgregarCancha() {
        try {
            String nom = txtNombre.getText();
            String tip = txtTipo.getText();
            double pre = Double.parseDouble(txtPrecio.getText());

            if (canchaDAO.insertarCancha(nom, tip, pre)) {
                lblMensaje.setText("Pista añadida correctamente");
                lblMensaje.setStyle("-fx-text-fill: green;");
                actualizarTabla();
                // Limpiar campos
                txtNombre.clear(); txtTipo.clear(); txtPrecio.clear();
            } else {
                lblMensaje.setText("Error: ¿Nombre duplicado?");
                lblMensaje.setStyle("-fx-text-fill: red;");
            }
        } catch (NumberFormatException e) {
            lblMensaje.setText("El precio debe ser un número");
            lblMensaje.setStyle("-fx-text-fill: orange;");
        }
    }
}
