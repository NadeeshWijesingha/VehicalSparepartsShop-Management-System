package business.custom.impl;

import java.util.List;

import business.custom.DeliveryBO;
import util.DeliveryTM;

public class DeliveryBOImpl implements DeliveryBO {

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
    return null;
  }

  @Override
  public List<String> getOrderIdList() throws Exception {
    return null;
  }
}
