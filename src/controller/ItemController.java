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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ItemController {

  public AnchorPane root;
  public TableView tblItem;
  public TableColumn clmId;
  public TableColumn clmCategory;
  public TableColumn clmDescription;
  public TableColumn clmQtyOnHand;
  public TableColumn clmBuy;
  public TableColumn clmSell;
  public JFXTextField txtId;
  public JFXTextField txtQtyOnHand;
  public JFXTextField txtDescription;
  public JFXTextField txtBuy;
  public JFXTextField txtSell;
  public JFXButton btnSave;
  public JFXComboBox comboCategory;

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
}
