package business.custom.impl;

import java.util.List;

import business.custom.OrdersBO;
import dao.DAOFactory;
import dao.DAOType;
import dao.custom.ItemDAO;
import dao.custom.OrderDetailDAO;
import dao.custom.OrdersDAO;

public class OrdersBOImpl implements OrdersBO {

  OrdersDAO ordersDAO = DAOFactory.getInstance().getDAO(DAOType.ORDERS);
  OrderDetailDAO orderDetailDAO = DAOFactory.getInstance().getDAO(DAOType.ORDER_DETAIL);
  ItemDAO itemDAO =DAOFactory.getInstance().getDAO(DAOType.ITEM);

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
    String lastOrderId = null;
    try {
      lastOrderId = ordersDAO.getLastOrderId();
    } catch (Exception e) {
      e.printStackTrace();
    }
    if (lastOrderId == null) {
      return "OD001";
    } else {
      int maxId = Integer.parseInt(lastOrderId.replace("OD", ""));
      maxId = maxId + 1;
      String id = "";
      if (maxId < 10) {
        id = "OD00" + maxId;
      } else if (maxId < 100) {
        id = "OD0" + maxId;
      } else {
        id = "OD" + maxId;
      }
      return id;
    }
  }
}
