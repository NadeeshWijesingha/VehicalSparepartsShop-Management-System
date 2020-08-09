package dao.custom;

import dao.CrudDAO;
import entity.Delivery;
import entity.DeliveryPK;

public interface DeliveryDAO extends CrudDAO <Delivery, DeliveryPK> {

  String getLastDeliveryId() throws Exception;

}
