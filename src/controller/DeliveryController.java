package controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import business.BOFactory;
import business.BOType;
import business.custom.DeliveryBO;
import business.custom.OrdersBO;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import util.DeliveryTM;

public class DeliveryController {

  public AnchorPane root;
  public TableView<DeliveryTM> tblDelivery;
  public TableColumn clmDeliveryId;
  public TableColumn clmOrderId;
  public TableColumn clmAddress;
  public TableColumn clmStatus;
  public JFXTextField txtDeliveryId;
  public JFXTextField txtAddress;
  public JFXComboBox<String> comboOrderId;
  public JFXComboBox<String> comboStatus;
  public JFXButton btnSave;
  public JFXButton btnDelete;

  DeliveryBO deliveryBO = BOFactory.getInstance().getBO(BOType.DELIVERY);
  OrdersBO ordersBO = BOFactory.getInstance().getBO(BOType.ORDER);

  public void initialize() {

    tblDelivery.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("deliveryId"));
    tblDelivery.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("orderId"));
    tblDelivery.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("address"));
    tblDelivery.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("status"));

    txtAddress.setDisable(true);
    txtDeliveryId.setDisable(true);
    comboOrderId.setDisable(true);
    comboStatus.setDisable(true);
    btnSave.setDisable(true);
    btnDelete.setDisable(true);

    tblDelivery.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<DeliveryTM>() {
      @Override
      public void changed(ObservableValue<? extends DeliveryTM> observable, DeliveryTM oldValue, DeliveryTM newValue) {

        DeliveryTM selectedItem = tblDelivery.getSelectionModel().getSelectedItem();

        if (selectedItem == null) {
          btnSave.setText("Save");
          btnDelete.setDisable(true);
          txtAddress.clear();
          txtDeliveryId.clear();
          comboOrderId.setValue(null);
          comboStatus.setValue(null);
          return;
        }

        btnSave.setText("Update");
        btnSave.setDisable(false);
        btnDelete.setDisable(false);
        txtDeliveryId.setDisable(false);
        txtAddress.setDisable(false);
        comboOrderId.setDisable(false);
        comboStatus.setDisable(false);
        txtAddress.setText(selectedItem.getAddress());
        txtDeliveryId.setText(selectedItem.getDeliveryId());
        comboOrderId.setValue(selectedItem.getOrderId());
        comboStatus.setValue(selectedItem.getStatus());

      }
    });

    loadAllDeliveries();

    // Load Order Id's
    ObservableList<String> comboOrder = comboOrderId.getItems();
    try {
      List<String> loadOrderIds = ordersBO.loadOrderIds();
      for (String loadOrderId : loadOrderIds) {
        comboOrder.add(loadOrderId);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    //load Status
    ObservableList<String> status = comboStatus.getItems();
    status.add("Delivered");
    status.add("Not Delivered");

  }

  public void btnSave_OnAction(ActionEvent actionEvent) {

    if (!((!comboOrderId.getSelectionModel().isEmpty()) && (!txtDeliveryId.getText().isEmpty())
        && (!txtAddress.getText().isEmpty()) && (!comboStatus.getSelectionModel().isEmpty())
    )) {
      new Alert(Alert.AlertType.ERROR, "Invalid inputs!").show();
      return;
    }

    ObservableList<DeliveryTM> table = tblDelivery.getItems();
    boolean result = false;
    if (btnSave.getText().equals("Save")) {
      try {

        result = deliveryBO.saveDelivery(txtDeliveryId.getText(), comboOrderId.getSelectionModel().getSelectedItem(), txtAddress.getText(), comboStatus.getSelectionModel().getSelectedItem());

        if (!result) {
          throw new RuntimeException("Something went wrong!");
        }

        table.add(new DeliveryTM(txtDeliveryId.getText(), String.valueOf(comboOrderId.getSelectionModel().getSelectedItem()), txtAddress.getText()
            , String.valueOf(comboStatus.getSelectionModel().getSelectedItem())));
        tblDelivery.refresh();
        btnNew_OnAction(actionEvent);

      } catch (Exception e) {
        new Alert(Alert.AlertType.ERROR, "Something went wrong!").show();
      }

    } else {
      try {
        result = deliveryBO.updateDelivery(txtDeliveryId.getText(), comboOrderId.getSelectionModel().getSelectedItem(),
            txtAddress.getText(),
            comboStatus.getSelectionModel().getSelectedItem());
        if (!result) {
          throw new RuntimeException("Something went wrong!");
        }
        tblDelivery.getItems().clear();
        comboOrderId.getItems().clear();
        comboStatus.getItems().clear();
        initialize();
        new Alert(Alert.AlertType.INFORMATION, "Record successfully updated!").show();
      } catch (Exception e) {
        new Alert(Alert.AlertType.ERROR, "Something went wrong!").show();
      }
    }

  }

  public void btnDelete_OnAction(ActionEvent actionEvent) {
  }

  public void btnNew_OnAction(ActionEvent actionEvent) {

    txtDeliveryId.clear();
    txtAddress.clear();
    comboOrderId.setValue(null);
    comboStatus.setValue(null);
    tblDelivery.getSelectionModel().clearSelection();
    txtAddress.setDisable(false);
    txtDeliveryId.setDisable(false);
    comboStatus.setDisable(false);
    comboOrderId.setDisable(false);
    btnSave.setDisable(false);

    try {
      txtDeliveryId.setText(deliveryBO.getNewDeliveryId());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void loadAllDeliveries() {
    tblDelivery.getItems().clear();
    List<DeliveryTM> all = null;
    try {
      all = deliveryBO.findAllDelivery();
    } catch (Exception e) {
      e.printStackTrace();
    }
    ObservableList<DeliveryTM> deliveryTMS = FXCollections.observableArrayList(all);
    tblDelivery.setItems(deliveryTMS);
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
