package business.custom.impl;

import java.util.List;

import business.custom.CustomerBO;
import util.CustomerTM;

public class CustomerBOImpl implements CustomerBO {

  @Override
  public boolean saveCustomer(String id, String name, String contact) throws Exception {
    return false;
  }

  @Override
  public boolean updateCustomer(String name, String contact, String id) throws Exception {
    return false;
  }

  @Override
  public boolean deleteCustomer(String customerId) throws Exception {
    return false;
  }

  @Override
  public List<CustomerTM> findAllCustomer() throws Exception {
    return null;
  }

  @Override
  public String getNewCustomerId() throws Exception {
    return null;
  }
}
