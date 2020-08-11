package controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import business.BOFactory;
import business.BOType;
import business.custom.CustomerBO;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import util.CustomerTM;

public class CustomerController {

  public TableView <CustomerTM> tblCustomer;
  public TableColumn clmId;
  public TableColumn clmName;
  public TableColumn clmContact;
  public JFXTextField txtId;
  public JFXTextField txtName;
  public JFXTextField txtContact;
  public JFXButton btnSave;
  public JFXButton btnDelete;
  public AnchorPane root;

  CustomerBO customerBO = BOFactory.getInstance().getBO(BOType.CUSTOMER);

  public void initialize(){

    tblCustomer.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
    tblCustomer.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
    tblCustomer.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("contact"));

    txtId.setDisable(true);
    txtName.setDisable(true);
    txtContact.setDisable(true);
    btnDelete.setDisable(true);
    btnSave.setDisable(true);

    tblCustomer.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<CustomerTM>() {
      @Override
      public void changed(ObservableValue<? extends CustomerTM> observable, CustomerTM oldValue, CustomerTM newValue) {
        CustomerTM selectedItem = tblCustomer.getSelectionModel().getSelectedItem();

        if (selectedItem == null) {
          btnSave.setText("Save");
          btnDelete.setDisable(true);
          txtId.clear();
          txtName.clear();
          txtContact.clear();
          return;
        }

        btnSave.setText("Update");
        btnSave.setDisable(false);
        btnDelete.setDisable(false);
        txtName.setDisable(false);
        txtContact.setDisable(false);
        txtId.setText(selectedItem.getId());
        txtName.setText(selectedItem.getName());
        txtContact.setText(selectedItem.getContact());

      }
    });

    loadAllCustomers();

  }

  public void btnNew_OnAction(ActionEvent actionEvent) {

    txtId.clear();
    txtContact.clear();
    txtName.clear();
    tblCustomer.getSelectionModel().clearSelection();
    txtName.setDisable(false);
    txtContact.setDisable(false);
    txtName.requestFocus();
    btnSave.setDisable(false);

    try {
      txtId.setText(customerBO.getNewCustomerId());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void btnSave_OnAction(ActionEvent actionEvent) {
    String name = txtName.getText();
    String contact = txtContact.getText();

    // Validation
    if (name.trim().length() == 0 || contact.trim().length() == 0) {
      new Alert(Alert.AlertType.ERROR, "Customer Name, Address can't be empty", ButtonType.OK).show();
      return;
    }

    if (btnSave.getText().equals("Save")) {

      try {
        customerBO.saveCustomer(txtId.getText(),
            txtName.getText(),
            txtContact.getText());
      } catch (Exception e) {
        e.printStackTrace();
      }
      btnNew_OnAction(actionEvent);
    } else {
      CustomerTM selectedItem = tblCustomer.getSelectionModel().getSelectedItem();
      boolean result = false;
      try {
        result = customerBO.updateCustomer(txtName.getText(), txtContact.getText(), selectedItem.getId());
      } catch (Exception e) {
        e.printStackTrace();
      }
      if (!result) {
        new Alert(Alert.AlertType.ERROR, "Failed to update the customer", ButtonType.OK).show();
      }
      tblCustomer.refresh();
      btnNew_OnAction(actionEvent);
    }
    loadAllCustomers();
  }

  public void btnDelete_OnAction(ActionEvent actionEvent) {

    Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
        "Are you sure whether you want to delete this customer?",
        ButtonType.YES, ButtonType.NO);
    Optional<ButtonType> buttonType = alert.showAndWait();
    if (buttonType.get() == ButtonType.YES) {
      CustomerTM selectedItem = tblCustomer.getSelectionModel().getSelectedItem();

      boolean result = false;
      try {
        result = customerBO.deleteCustomer(selectedItem.getId());
      } catch (Exception e) {
        e.printStackTrace();
      }
      if (!result){
        new Alert(Alert.AlertType.ERROR, "Failed to delete the customer", ButtonType.OK).show();
      }else{
        tblCustomer.getItems().remove(selectedItem);
        tblCustomer.getSelectionModel().clearSelection();
      }
    }

  }

  private void loadAllCustomers() {
    tblCustomer.getItems().clear();
    List<CustomerTM> allCustomers = null;
    try {
      allCustomers = customerBO.findAllCustomer();
    } catch (Exception e) {
      e.printStackTrace();
    }
    ObservableList<CustomerTM> customers = FXCollections.observableArrayList(allCustomers);
    tblCustomer.setItems(customers);
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
