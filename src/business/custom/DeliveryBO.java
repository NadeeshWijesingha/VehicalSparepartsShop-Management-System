package business.custom;

import java.util.List;

import business.SuperBO;
import util.DeliveryTM;

public interface DeliveryBO extends SuperBO {

  boolean saveDelivery(String deliveryId, String orderId, String address, String status) throws Exception;

  boolean updateDelivery(String orderId, String address, String status, String deliveryId) throws Exception;

  boolean deleteDelivery(String deliveryId, String orderId) throws Exception;

  List <DeliveryTM> findAllDelivery() throws Exception;

  String getNewDeliveryId() throws Exception;

}
