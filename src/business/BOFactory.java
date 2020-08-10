package business;

import business.custom.impl.CustomerBOImpl;
import business.custom.impl.DeliveryBOImpl;
import business.custom.impl.ItemBOImpl;
import business.custom.impl.OrdersBOImpl;
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
        return (T) new DeliveryBOImpl();
      case ORDER:
        return (T) new OrdersBOImpl();
      default:
        return null;
    }
  }

}
