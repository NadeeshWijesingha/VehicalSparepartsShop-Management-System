package business.custom.impl;

import java.util.ArrayList;
import java.util.List;

import business.custom.CustomerBO;
import dao.DAOFactory;
import dao.DAOType;
import dao.custom.CustomerDAO;
import entity.Customer;
import util.CustomerTM;

public class CustomerBOImpl implements CustomerBO {

  CustomerDAO customerDAO = DAOFactory.getInstance().getDAO(DAOType.CUSTOMER);

  @Override
  public boolean saveCustomer(String id, String name, String contact) throws Exception {
    return customerDAO.save(new Customer(id, name, contact));
  }

  @Override
  public boolean updateCustomer(String name, String contact, String id) throws Exception {
    return customerDAO.update(new Customer(id, name, contact));
  }

  @Override
  public boolean deleteCustomer(String customerId) throws Exception {
    return customerDAO.delete(customerId);
  }

  @Override
  public List<CustomerTM> findAllCustomer() throws Exception {
    List<Customer> allCustomer = customerDAO.findAll();
    List<CustomerTM> customerTMS = new ArrayList<>();
    for (Customer customer : allCustomer) {
      customerTMS.add(new CustomerTM(customer.getCustomerId(), customer.getName(), customer.getContact()));
    }
    return customerTMS;
  }

  @Override
  public String getNewCustomerId() throws Exception {
    String lastCustomerId = null;
    try {
      lastCustomerId = customerDAO.getLastCustomerId();
    } catch (Exception e) {
      e.printStackTrace();
    }
    if (lastCustomerId == null) {
      return "C001";
    } else {
      int maxId = Integer.parseInt(lastCustomerId.replace("C", ""));
      maxId = maxId + 1;
      String id = "";
      if (maxId < 10) {
        id = "C00" + maxId;
      } else if (maxId < 100) {
        id = "C0" + maxId;
      } else {
        id = "C" + maxId;
      }
      return id;
    }
  }
}
