package dao.custom.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.CrudUtil;
import dao.custom.OrdersDAO;
import entity.Orders;

public class OrdersDAOImpl implements OrdersDAO {

  @Override
  public String getLastOrderId() throws SQLException {
    ResultSet rst = CrudUtil.execute("SELECT * FROM Orders ORDER BY orderId DESC LIMIT 1");
    if (!rst.next()){
      return null;
    }else {
      return rst.getString(1);
    }
  }

  @Override
  public List<Orders> findAll() throws SQLException {
    ResultSet rst = CrudUtil.execute("SELECT * FROM Orders");
    List<Orders> orders = new ArrayList<>();
    while (rst.next()){
      orders.add(new Orders(rst.getString(1), rst.getDate(2), rst.getString(3)));
    }
    return orders;
  }

  @Override
  public Orders find(String key) throws Exception {
    ResultSet rst = CrudUtil.execute("SELECT * FROM Orders WHERE orderId = ?", key);
    if (rst.next()){
      return new Orders(rst.getString(1),rst.getDate(2),rst.getString(3));
    }
    return null;
  }

  @Override
  public boolean save(Orders orders) throws Exception {
    return CrudUtil.execute("INSERT INTO Orders VALUES (?,?,?)", orders.getOrderId(), orders.getDate(), orders.getCustomerId());
  }

  @Override
  public boolean update(Orders orders) throws Exception {
    return CrudUtil.execute("UPDATE Orders SET date=?, customerId=? WHERE orderId = ?",orders.getDate(), orders.getCustomerId(), orders.getOrderId());
  }

  @Override
  public boolean delete(String key) throws Exception {
    return CrudUtil.execute("DELETE FROM Orders WHERE orderId = ?", key);
  }
}
