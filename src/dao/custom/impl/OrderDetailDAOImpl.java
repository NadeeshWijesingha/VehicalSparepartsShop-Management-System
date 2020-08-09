package dao.custom.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.CrudUtil;
import dao.custom.OrderDetailDAO;
import entity.Customer;
import entity.OrderDetail;
import entity.OrderDetailPK;

public class OrderDetailDAOImpl implements OrderDetailDAO {

  @Override
  public List<OrderDetail> findAll() throws SQLException {
    ResultSet rst = CrudUtil.execute("SELECT * FROM OrderDetail");
    List<OrderDetail> orderDetails = new ArrayList<>();
    while (rst.next()){
      orderDetails.add(new OrderDetail(rst.getString(1), rst.getString(2), rst.getInt(3), rst.getDouble(4)));
    }
    return orderDetails;
  }

  @Override
  public OrderDetail find(OrderDetailPK key) throws SQLException {
    ResultSet rst = CrudUtil.execute("SELECT * FROM OrderDetail WHERE orderId = ?", key);
    if (rst.next()){
      return new OrderDetail(rst.getString(1),rst.getString(2),rst.getInt(3), rst.getDouble(4));
    }
    return null;
  }

  @Override
  public boolean save(OrderDetail orderDetail) throws SQLException {
    return CrudUtil.execute("INSERT INTO OrderDetail VALUES (?,?,?,?)",orderDetail.getOrderDetailPK().getOrderId(), orderDetail.getOrderDetailPK().getItemId(),
        orderDetail.getQty(), orderDetail.getUnitPrice());
  }

  @Override
  public boolean update(OrderDetail orderDetail) throws SQLException {
    return CrudUtil.execute("UPDATE OrderDetail SET qty=?, unitPrice=? WHERE orderId = ? AND itemId = ?",orderDetail.getQty(), orderDetail.getUnitPrice(),
        orderDetail.getOrderDetailPK().getOrderId(), orderDetail.getOrderDetailPK().getItemId());
  }

  @Override
  public boolean delete(OrderDetailPK key) throws SQLException {
    return CrudUtil.execute("DELETE FROM OrderDetail WHERE orderId = ?", key);
  }
}
