package controller;

import java.io.IOException;
import java.net.URL;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class OrderController {

  public AnchorPane root;
  public TableView tblOrder;
  public TableColumn clmOrderId;
  public TableColumn clmItemId;
  public TableColumn clmDescription;
  public TableColumn clmAddQty;
  public TableColumn clmTotal;
  public Label lblSubTotal;
  public JFXTextField txtId;
  public JFXTextField txtDate;
  public JFXTextField txtDescription;
  public JFXTextField txtQtyOnHand;
  public JFXTextField txtUnitPrice;
  public JFXTextField txtAddQty;
  public JFXComboBox comboCustomer;
  public JFXComboBox comboItem;
  public JFXButton btnSave;

  public void btnHome_OnAction(MouseEvent mouseEvent) throws IOException {
    URL resource;
    resource = this.getClass().getResource("/view/MainForm.fxml");
    Parent root = FXMLLoader.load(resource);
    Scene scene = new Scene(root);
    Stage primaryStage = (Stage) (this.root.getScene().getWindow());
    primaryStage.setScene(scene);
    primaryStage.centerOnScreen();
  }

  public void btnNew_OnAction(ActionEvent actionEvent) {
  }

  public void btnSave_OnAction(ActionEvent actionEvent) {
  }

  public void btnDelete_OnAction(ActionEvent actionEvent) {
  }

  public void btnPlaceOrder_OnAction(ActionEvent actionEvent) {
  }
}
