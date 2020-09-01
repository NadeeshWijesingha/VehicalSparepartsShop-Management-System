package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import dao.DAOFactory;
import dao.DAOType;
import dao.custom.ItemDAO;
import dao.custom.OrderDetailDAO;
import dao.custom.OrdersDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import util.ItemTM;
import util.OrderTM;

import java.io.IOException;
import java.net.URL;

public class OrderController {

    public AnchorPane root;
    public TableView<OrderTM> tblOrder;
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

    OrdersDAO ordersDAO = DAOFactory.getInstance().getDAO(DAOType.ORDERS);
    OrderDetailDAO orderDetailDAO = DAOFactory.getInstance().getDAO(DAOType.ORDER_DETAIL);
    ItemDAO itemDAO = DAOFactory.getInstance().getDAO(DAOType.ITEM);

    public void initialize() {

        tblOrder.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("itemId"));
        tblOrder.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("description"));
        tblOrder.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("qty"));
        tblOrder.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        tblOrder.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("total"));

    }

    public void btnSave_OnAction(ActionEvent actionEvent) {
    }

    public void btnDelete_OnAction(ActionEvent actionEvent) {
    }

    public void btnPlaceOrder_OnAction(ActionEvent actionEvent) {
    }

    public void loadAllCustomer() {
    }

    public void loadAllItems() {
    }

    public void generateOrderId() {

    }

    public void calculateTotal() {

    }

    public void calculateQtyOnHand(ItemTM item) {

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
