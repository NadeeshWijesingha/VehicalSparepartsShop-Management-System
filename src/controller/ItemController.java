package controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import business.BOFactory;
import business.BOType;
import business.custom.ItemBO;
import entity.Category;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import util.ItemTM;

public class ItemController {

  public AnchorPane root;
  public TableView <ItemTM> tblItem;
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
  public JFXComboBox <String> comboCategory;
  List<Category> categories;
  public JFXButton btnDelete;

  ItemBO itemBO = BOFactory.getInstance().getBO(BOType.ITEM);

  public void initialize(){

    tblItem.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("itemId"));
    tblItem.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("categoryId"));
    tblItem.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("description"));
    tblItem.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("qtyOnHand"));
    tblItem.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("buyPrice"));
    tblItem.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("unitPrice"));

    txtId.setDisable(true);
    txtDescription.setDisable(true);
    txtQtyOnHand.setDisable(true);
    txtSell.setDisable(true);
    comboCategory.setDisable(true);
    btnDelete.setDisable(true);
    btnSave.setDisable(true);

    loadAllItems();

    //loadCategory's

    try {
      ObservableList<String> cat = comboCategory.getItems();
      categories = itemBO.getCategories();
      for (Category category : categories) {
        cat.add(category.getDescription());
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    tblItem.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<ItemTM>() {
      @Override
      public void changed(ObservableValue<? extends ItemTM> observable, ItemTM oldValue, ItemTM newValue) {

        ItemTM selectedItem = tblItem.getSelectionModel().getSelectedItem();

        if (selectedItem == null) {
          btnSave.setText("Save");
          btnDelete.setDisable(true);
          txtId.clear();
          txtDescription.clear();
          txtQtyOnHand.clear();
          txtSell.clear();
          txtBuy.clear();
          return;
        }

        btnSave.setText("Update");
        btnSave.setDisable(false);
        btnDelete.setDisable(false);
        txtDescription.setDisable(false);
        txtQtyOnHand.setDisable(false);
        txtSell.setDisable(false);
        txtBuy.setDisable(false);
        txtId.setText(selectedItem.getItemId());
        txtDescription.setText(selectedItem.getDescription());
        txtQtyOnHand.setText(selectedItem.getQtyOnHand() + "");
        txtSell.setText(selectedItem.getUnitPrice() + "");
        txtBuy.setText(selectedItem.getBuyPrice() + "");

      }
    });

  }

  public void btnNew_OnAction(ActionEvent actionEvent) {
  }

  public void btnSave_OnAction(ActionEvent actionEvent) {
  }

  public void btnDelete_OnAction(ActionEvent actionEvent) {
  }

  private void loadAllItems() {

    ObservableList<ItemTM> items = tblItem.getItems();
    items.clear();
    try {
      items = FXCollections.observableArrayList(itemBO.findAllItem());
    } catch (Exception e) {
      e.printStackTrace();
    }
    tblItem.setItems(items);
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
