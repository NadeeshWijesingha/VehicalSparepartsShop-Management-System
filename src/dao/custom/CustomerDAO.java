package dao.custom;

import java.sql.SQLException;

import dao.CrudDAO;
import entity.Customer;

public interface CustomerDAO extends CrudDAO <Customer,String> {

  String getLastCustomerId() throws Exception;

}
