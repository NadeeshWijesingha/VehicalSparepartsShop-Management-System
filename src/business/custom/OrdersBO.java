package business.custom;

import java.util.List;

import business.SuperBO;

public interface OrdersBO extends SuperBO {

  boolean placeOrder() throws Exception;

  List <String> loadOrderIds() throws Exception;

  String newOrderId() throws Exception;

}
