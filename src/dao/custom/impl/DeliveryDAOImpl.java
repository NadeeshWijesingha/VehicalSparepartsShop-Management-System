package dao.custom.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.CrudUtil;
import dao.custom.DeliveryDAO;
import entity.Delivery;
import entity.DeliveryPK;

public class DeliveryDAOImpl implements DeliveryDAO {

  @Override
  public String getLastDeliveryId() throws SQLException {
    ResultSet rst = CrudUtil.execute("SELECT * FROM Delivery ORDER BY deliveryId DESC LIMIT 1");
    if (!rst.next()){
      return null;
    }else {
      return rst.getString(1);
    }
  }

  @Override
  public List<Delivery> findAll() throws SQLException {
    ResultSet rst = CrudUtil.execute("SELECT * FROM Delivery");
    List<Delivery> deliveries = new ArrayList<>();
    while (rst.next()){
      deliveries.add(new Delivery(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4)));
    }
    return deliveries;
  }

  @Override
  public Delivery find(DeliveryPK key) throws SQLException {
    ResultSet rst = CrudUtil.execute("SELECT * FROM Delivery WHERE deliveryId = ?", key);
    if (rst.next()){
      return new Delivery(rst.getString(1),rst.getString(2),rst.getString(3), rst.getString(4));
    }
    return null;
  }

  @Override
  public boolean save(Delivery delivery) throws SQLException {
    return CrudUtil.execute("INSERT INTO Delivery VALUES (?,?,?,?)", delivery.getDeliveryPK().getDeliveryId(), delivery.getDeliveryPK().getOrderId(),
        delivery.getAddress(), delivery.getStatus());
  }

  @Override
  public boolean update(Delivery delivery) throws SQLException {
    return CrudUtil.execute("UPDATE Delivery SET address=?, status=? WHERE deliveryId = ? AND orderId = ?", delivery.getAddress(), delivery.getStatus(),
        delivery.getDeliveryPK().getDeliveryId(), delivery.getDeliveryPK().getOrderId());
  }

  @Override
  public boolean delete(DeliveryPK key) throws SQLException {
    return CrudUtil.execute("DELETE FROM delivery WHERE deliveryId=? AND orderId=?", key.getDeliveryId(),key.getOrderId());
  }
}
