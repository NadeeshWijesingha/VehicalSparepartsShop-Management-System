package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class CustomerController {

  public TableView tblCustomer;
  public TableColumn clmId;
  public TableColumn clmName;
  public TableColumn clmAddress;
  public JFXTextField txtId;
  public JFXTextField txtName;
  public JFXTextField txtAddress;
  public JFXButton btnSave;
  public AnchorPane root;

  public void btnHome_OnAction(MouseEvent mouseEvent) {
  }

  public void btnSave_OnAction(ActionEvent actionEvent) {
  }

  public void btnDelete_OnAction(ActionEvent actionEvent) {
  }

  public void btnNew_OnAction(ActionEvent actionEvent) {
  }
}
