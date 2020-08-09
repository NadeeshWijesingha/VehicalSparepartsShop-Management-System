package business.custom.impl;

import java.util.List;

import business.custom.CustomerBO;
import dao.DAOFactory;
import dao.DAOType;
import dao.custom.CustomerDAO;
import util.CustomerTM;

public class CustomerBOImpl implements CustomerBO {

  CustomerDAO customerDAO = DAOFactory.getInstance().getDAO(DAOType.CUSTOMER);

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
