package dao.custom.impl;

import java.util.List;

import dao.custom.CustomerDAO;
import entity.Customer;

public class CustomerDAOImpl implements CustomerDAO {

  @Override
  public String getLastCustomerId() {
    return null;
  }

  @Override
  public List<Customer> findAll() {
    return null;
  }

  @Override
  public Customer find(String key) {
    return null;
  }

  @Override
  public boolean save(Customer entity) {
    return false;
  }

  @Override
  public boolean update(Customer entity) {
    return false;
  }

  @Override
  public boolean delete(String key) {
    return false;
  }
}
