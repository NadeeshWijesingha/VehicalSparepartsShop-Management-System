package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

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

  public void btnHome_OnAction(MouseEvent mouseEvent) {
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
