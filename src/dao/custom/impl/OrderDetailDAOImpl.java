package dao.custom.impl;

import java.util.List;

import dao.custom.OrderDetailDAO;
import entity.OrderDetail;
import entity.OrderDetailPK;

public class OrderDetailDAOImpl implements OrderDetailDAO {

  @Override
  public List<OrderDetail> findAll() {
    return null;
  }

  @Override
  public OrderDetail find(OrderDetailPK key) {
    return null;
  }

  @Override
  public boolean save(OrderDetail entity) {
    return false;
  }

  @Override
  public boolean update(OrderDetail entity) {
    return false;
  }

  @Override
  public boolean delete(OrderDetailPK key) {
    return false;
  }
}
