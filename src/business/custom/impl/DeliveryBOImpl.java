package business.custom.impl;

import java.util.List;

import business.custom.DeliveryBO;
import dao.DAOFactory;
import dao.DAOType;
import dao.custom.DeliveryDAO;
import util.DeliveryTM;

public class DeliveryBOImpl implements DeliveryBO {

  DeliveryDAO deliveryDAO = DAOFactory.getInstance().getDAO(DAOType.DELIVERY);

  @Override
  public boolean saveDelivery(String deliveryId, String orderId, String address, String status) throws Exception {
    return false;
  }

  @Override
  public boolean updateDelivery(String orderId, String address, String status, String deliveryId) throws Exception {
    return false;
  }

  @Override
  public boolean deleteDelivery(String deliveryId, String orderId) throws Exception {
    return false;
  }

  @Override
  public List<DeliveryTM> findAllDelivery() throws Exception {
    return null;
  }

  @Override
  public String getNewDeliveryId() throws Exception {
    String lastDeliveryId = null;
    try {
      lastDeliveryId = deliveryDAO.getLastDeliveryId();
    } catch (Exception e) {
      e.printStackTrace();
    }
    if (lastDeliveryId == null) {
      return "D001";
    } else {
      int maxId = Integer.parseInt(lastDeliveryId.replace("D", ""));
      maxId = maxId + 1;
      String id = "";
      if (maxId < 10) {
        id = "D00" + maxId;
      } else if (maxId < 100) {
        id = "D0" + maxId;
      } else {
        id = "D" + maxId;
      }
      return id;
    }
  }
}
