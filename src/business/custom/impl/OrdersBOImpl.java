package business.custom.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import business.custom.OrdersBO;
import dao.DAOFactory;
import dao.DAOType;
import dao.custom.ItemDAO;
import dao.custom.OrderDetailDAO;
import dao.custom.OrdersDAO;
import db.DBConnection;
import entity.Item;
import entity.OrderDetail;
import entity.Orders;
import util.OrderDetailTM;
import util.OrderTM;

public class OrdersBOImpl implements OrdersBO {

  OrdersDAO ordersDAO = DAOFactory.getInstance().getDAO(DAOType.ORDERS);
  OrderDetailDAO orderDetailDAO = DAOFactory.getInstance().getDAO(DAOType.ORDER_DETAIL);
  ItemDAO itemDAO = DAOFactory.getInstance().getDAO(DAOType.ITEM);

  @Override
  public boolean placeOrder(OrderTM order, List<OrderDetailTM> orderDetails) throws Exception {
    Connection connection = DBConnection.getInstance().getConnection();
    try {
      connection.setAutoCommit(false);
      boolean result = ordersDAO.save(new Orders(order.getOrderId(), order.getOrderDate(), order.getCustomerId()));
      if (!result) {
        connection.rollback();
        return false;
      }

      for (OrderDetailTM orderDetail : orderDetails) {
        result = orderDetailDAO.save(new OrderDetail(order.getOrderId(), orderDetail.getItemId(),
            orderDetail.getQty(), orderDetail.getUnitPrice()));
        if (!result) {
          connection.rollback();
          return false;
        }

        Item item = itemDAO.find(orderDetail.getItemId());
        item.setQtyOnHand(item.getQtyOnHand() - orderDetail.getQty());
        itemDAO.update(item);
        if (!result) {
          connection.rollback();
          return false;
        }
      }
      connection.commit();
      return true;

    } catch (Throwable throwables) {
      throwables.printStackTrace();
      try {
        connection.rollback();
      } catch (SQLException e) {
        e.printStackTrace();
      }
      return false;
    } finally {
      try {
        connection.setAutoCommit(true);
      } catch (SQLException throwables) {
        throwables.printStackTrace();
      }
    }
  }

  @Override
  public List<String> loadOrderIds() throws Exception {
    List<Orders> allOrders = ordersDAO.findAll();
    List<String> ids = new ArrayList<>();
    for (Orders allOrder : allOrders) {
      ids.add(allOrder.getOrderId());
    }
    return ids;
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
