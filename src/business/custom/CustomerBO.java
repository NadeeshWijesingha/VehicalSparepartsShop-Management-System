package business.custom;

import java.util.List;

import business.SuperBO;
import util.CustomerTM;

public interface CustomerBO extends SuperBO {

  boolean saveCustomer(String id, String name, String contact) throws Exception;

  boolean updateCustomer(String name, String contact, String id) throws Exception;

  boolean deleteCustomer(String customerId) throws Exception;

  List<CustomerTM> findAllCustomer() throws Exception;

  String getNewCustomerId() throws Exception;

}
