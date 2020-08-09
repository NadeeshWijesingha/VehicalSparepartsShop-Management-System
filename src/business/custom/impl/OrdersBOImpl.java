package business.custom.impl;

import java.util.List;

import business.custom.OrdersBO;

public class OrdersBOImpl implements OrdersBO {

  @Override
  public boolean placeOrder() throws Exception {
    return false;
  }

  @Override
  public List<String> loadOrderIds() throws Exception {
    return null;
  }

  @Override
  public String newOrderId() throws Exception {
    return null;
  }
}
