package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class ItemController {

  public AnchorPane root;
  public TableView tblItem;
  public TableColumn clmId;
  public TableColumn clmCategory;
  public TableColumn clmBrand;
  public TableColumn clmDescription;
  public TableColumn clmQty;
  public TableColumn clmBuy;
  public TableColumn clmSell;
  public JFXTextField txtId;
  public JFXTextField txtBrand;
  public JFXTextField txtQty;
  public JFXTextField txtDescription;
  public JFXTextField txtBuy;
  public JFXTextField txtSell;
  public JFXButton btnSave;
  public JFXComboBox comboCategory;

  public void btnHome_OnAction(MouseEvent mouseEvent) {
  }

  public void btnNew_OnAction(ActionEvent actionEvent) {
  }

  public void btnSave_OnAction(ActionEvent actionEvent) {
  }

  public void btnDelete_OnAction(ActionEvent actionEvent) {
  }
}
