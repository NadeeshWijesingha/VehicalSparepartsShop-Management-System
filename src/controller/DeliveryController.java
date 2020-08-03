package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class DeliveryController {

  public AnchorPane root;
  public TableView tblDelivery;
  public TableColumn clmDeliveryId;
  public TableColumn clmOrderId;
  public TableColumn clmAddress;
  public TableColumn clmStatus;
  public JFXTextField txtDeliveryId;
  public JFXTextField txtAddress;
  public JFXComboBox comboOrderId;
  public JFXComboBox comboStatus;
  public JFXButton btnSave;

  public void btnHome_OnAction(MouseEvent mouseEvent) {
  }

  public void btnSave_OnAction(ActionEvent actionEvent) {
  }

  public void btnDelete_OnAction(ActionEvent actionEvent) {
  }

  public void btnNew_OnAction(ActionEvent actionEvent) {
  }
}
