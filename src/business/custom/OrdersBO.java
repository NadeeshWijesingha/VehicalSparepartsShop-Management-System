package business.custom;

import java.util.List;

import business.SuperBO;
import util.OrderDetailTM;
import util.OrderTM;

public interface OrdersBO extends SuperBO {

  boolean placeOrder(OrderTM order, List<OrderDetailTM> orderDetails) throws Exception;

  List <String> loadOrderIds() throws Exception;

  String newOrderId() throws Exception;

}
