package dao.custom.impl;

import java.util.List;

import dao.custom.DeliveryDAO;
import entity.Delivery;
import entity.DeliveryPK;

public class DeliveryDAOImpl implements DeliveryDAO {

  @Override
  public String getLastDeliveryId() {
    return null;
  }

  @Override
  public List<Delivery> findAll() {
    return null;
  }

  @Override
  public Delivery find(DeliveryPK key) {
    return null;
  }

  @Override
  public boolean save(Delivery entity) {
    return false;
  }

  @Override
  public boolean update(Delivery entity) {
    return false;
  }

  @Override
  public boolean delete(DeliveryPK key) {
    return false;
  }
}
