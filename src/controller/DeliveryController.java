package controller;

import java.io.IOException;
import java.net.URL;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import business.BOFactory;
import business.BOType;
import business.custom.DeliveryBO;
import business.custom.OrdersBO;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import util.DeliveryTM;

public class DeliveryController {

  public AnchorPane root;
  public TableView <DeliveryTM> tblDelivery;
  public TableColumn clmDeliveryId;
  public TableColumn clmOrderId;
  public TableColumn clmAddress;
  public TableColumn clmStatus;
  public JFXTextField txtDeliveryId;
  public JFXTextField txtAddress;
  public JFXComboBox comboOrderId;
  public JFXComboBox comboStatus;
  public JFXButton btnSave;

  DeliveryBO deliveryBO = BOFactory.getInstance().getBO(BOType.DELIVERY);
  OrdersBO ordersBO = BOFactory.getInstance().getBO(BOType.ORDER);

  public void initialize(){

    tblDelivery.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("deliveryId"));
    tblDelivery.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("orderId"));
    tblDelivery.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("address"));
    tblDelivery.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("status"));

  }

  public void btnSave_OnAction(ActionEvent actionEvent) {
  }

  public void btnDelete_OnAction(ActionEvent actionEvent) {
  }

  public void btnNew_OnAction(ActionEvent actionEvent) {
  }

  public void btnHome_OnAction(MouseEvent mouseEvent) throws IOException {
    URL resource;
    resource = this.getClass().getResource("/view/MainForm.fxml");
    Parent root = FXMLLoader.load(resource);
    Scene scene = new Scene(root);
    Stage primaryStage = (Stage) (this.root.getScene().getWindow());
    primaryStage.setScene(scene);
    primaryStage.centerOnScreen();
  }
}
