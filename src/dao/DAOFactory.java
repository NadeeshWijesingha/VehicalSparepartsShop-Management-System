package dao;

import dao.custom.impl.CategoryDAOImpl;
import dao.custom.impl.CustomerDAOImpl;
import dao.custom.impl.DeliveryDAOImpl;
import dao.custom.impl.ItemDAOImpl;
import dao.custom.impl.OrderDetailDAOImpl;
import dao.custom.impl.OrdersDAOImpl;
import dao.custom.impl.QueryDAOImpl;

public class DAOFactory {

  private static DAOFactory daoFactory;

  private DAOFactory() {
  }

  public static DAOFactory getInstance(){
    return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
  }

  public <T extends SuperDAO> T getDAO(DAOType daoType){
    switch (daoType){
      case CATEGORY:
        return (T) new CategoryDAOImpl();
      case CUSTOMER:
        return (T) new CustomerDAOImpl();
      case DELIVERY:
        return (T) new DeliveryDAOImpl();
      case ITEM:
        return (T) new ItemDAOImpl();
      case ORDER_DETAIL:
        return (T) new OrderDetailDAOImpl();
      case ORDERS:
        return (T) new OrdersDAOImpl();
      case QUERY:
        return (T) new QueryDAOImpl();
      default:
        return null;
    }
  }
}
