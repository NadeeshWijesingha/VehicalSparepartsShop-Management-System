package controller;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.List;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import business.BOFactory;
import business.BOType;
import business.custom.CategoryBO;
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

  private static final DecimalFormat df = new DecimalFormat("#.##");
  public AnchorPane root;
  public TableView<ItemTM> tblItem;
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
  public JFXComboBox<String> comboCategory;
  public JFXButton btnDelete;
  List<Category> categories;

  //dependency injection
  ItemBO itemBO = BOFactory.getInstance().getBO(BOType.ITEM);
  CategoryBO categoryBO = BOFactory.getInstance().getBO(BOType.CATEGORY);

  public void initialize() {

    tblItem.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("itemId"));
    tblItem.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("categoryId"));
    tblItem.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("description"));
    tblItem.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("qtyOnHand"));
    tblItem.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("buyPrice"));
    tblItem.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("unitPrice"));

    txtId.setDisable(true);
    txtDescription.setDisable(true);
    txtQtyOnHand.setDisable(true);
    txtBuy.setDisable(true);
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

        try {
          ItemTM selectedItem = tblItem.getSelectionModel().getSelectedItem();

          txtId.setDisable(false);
          txtId.setText(selectedItem.getItemId());
          txtDescription.setDisable(false);
          txtDescription.setText(selectedItem.getDescription());
          txtQtyOnHand.setDisable(false);
          txtQtyOnHand.setText(String.valueOf(selectedItem.getQtyOnHand()));
          txtBuy.setDisable(false);
          txtBuy.setText(String.valueOf(df.format(selectedItem.getBuyPrice())));
          txtSell.setDisable(false);
          txtSell.setText(String.valueOf(df.format(selectedItem.getUnitPrice())));
          comboCategory.setDisable(false);
          ObservableList<String> cmb = comboCategory.getItems();
          System.out.println(selectedItem.getCategoryId());
          String catId = null;
          for (Category category : categories) {
            if (selectedItem.getCategoryId().equals(category.getCategoryId())) {
              comboCategory.getSelectionModel().select(category.getDescription());
            }
          }
          btnSave.setText("Update");
          btnSave.setDisable(false);

        } catch (Exception e) {
          return;
        }
      }
    });
  }


  public void btnNew_OnAction(ActionEvent actionEvent) {

    btnSave.setDisable(false);
    txtId.setDisable(false);
    txtDescription.setDisable(false);
    txtQtyOnHand.setDisable(false);
    txtBuy.setDisable(false);
    txtSell.setDisable(false);
    comboCategory.setDisable(false);
    txtId.clear();
    comboCategory.setValue(null);
    txtDescription.clear();
    txtQtyOnHand.clear();
    txtBuy.clear();
    txtSell.clear();
    btnSave.setText("Save");

    try {
      txtId.setText(itemBO.getNewItemId());
    } catch (Exception e) {
      e.printStackTrace();
    }


  }

  public void btnSave_OnAction(ActionEvent actionEvent) {

    String id = txtId.getText();
    String description = txtDescription.getText();
    String qty = txtQtyOnHand.getText();
    String buy = txtBuy.getText();
    String sell = txtSell.getText();

    String categoryId = null;

    if (btnSave.getText().equals("Save")) {

      try {

        for (Category category : categories) {
          if (comboCategory.getSelectionModel().getSelectedItem().equals(category.getDescription())) {
            categoryId = category.getCategoryId();
          }
        }

        itemBO.saveItem(id, categoryId, description, Integer.parseInt(qty), Double.parseDouble(buy), Double.parseDouble(sell));

        tblItem.refresh();
        btnNew_OnAction(actionEvent);
      } catch (Exception e) {
        e.printStackTrace();
      }

    } else {

      ItemTM selectedItem = tblItem.getSelectionModel().getSelectedItem();
      boolean result = false;
      try {

        for (Category category : categories) {
          if (comboCategory.getSelectionModel().getSelectedItem().equals(category.getDescription())) {
            categoryId = category.getCategoryId();
          }
        }

        result = itemBO.updateItem(categoryId, description, Integer.parseInt(qty), Double.parseDouble(buy), Double.parseDouble(sell), selectedItem.getItemId());

        tblItem.refresh();
        btnNew_OnAction(actionEvent);

      } catch (Exception e) {
        e.printStackTrace();
      }

    }

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
