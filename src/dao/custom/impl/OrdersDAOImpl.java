package dao.custom.impl;

import java.io.Serializable;
import java.util.List;

import dao.custom.OrdersDAO;
import entity.SuperEntity;

public class OrdersDAOImpl implements OrdersDAO {

  @Override
  public String getLastOrderId() {
    return null;
  }

  @Override
  public List findAll() {
    return null;
  }

  @Override
  public SuperEntity find(Serializable key) {
    return null;
  }

  @Override
  public boolean save(SuperEntity entity) {
    return false;
  }

  @Override
  public boolean update(SuperEntity entity) {
    return false;
  }

  @Override
  public boolean delete(Serializable key) {
    return false;
  }
}
