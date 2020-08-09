package controller;

import java.io.IOException;
import java.net.URL;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class CustomerController {

  public TableView tblCustomer;
  public TableColumn clmId;
  public TableColumn clmName;
  public TableColumn clmContact;
  public JFXTextField txtId;
  public JFXTextField txtName;
  public JFXTextField txtAddress;
  public JFXButton btnSave;
  public AnchorPane root;

  public void btnHome_OnAction(MouseEvent mouseEvent) throws IOException {
    URL resource;
    resource = this.getClass().getResource("/view/MainForm.fxml");
    Parent root = FXMLLoader.load(resource);
    Scene scene = new Scene(root);
    Stage primaryStage = (Stage) (this.root.getScene().getWindow());
    primaryStage.setScene(scene);
    primaryStage.centerOnScreen();
  }

  public void btnSave_OnAction(ActionEvent actionEvent) {
  }

  public void btnDelete_OnAction(ActionEvent actionEvent) {
  }

  public void btnNew_OnAction(ActionEvent actionEvent) {
  }
}
