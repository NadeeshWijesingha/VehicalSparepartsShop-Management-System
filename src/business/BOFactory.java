package business;

import business.custom.impl.CustomerBOImpl;
import business.custom.impl.ItemBOImpl;
import dao.custom.impl.DeliveryDAOImpl;
import dao.custom.impl.OrdersDAOImpl;

public class BOFactory {

  private static BOFactory boFactory;

  private BOFactory() {
  }

  public static BOFactory getInstance() {
    return (boFactory == null) ? boFactory = new BOFactory() : boFactory;
  }

  public <T extends SuperBO> T getBO(BOType boType) {
    switch (boType) {
      case CUSTOMER:
        return (T) new CustomerBOImpl();
      case ITEM:
        return (T) new ItemBOImpl();
      case DELIVERY:
        return (T) new DeliveryDAOImpl();
      case ORDER:
        return (T) new OrdersDAOImpl();
      default:
        return null;
    }
  }

}
