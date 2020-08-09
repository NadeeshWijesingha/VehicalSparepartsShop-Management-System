package business.custom.impl;

import java.util.List;

import business.custom.ItemBO;
import dao.DAOFactory;
import dao.DAOType;
import dao.custom.DeliveryDAO;
import dao.custom.ItemDAO;
import util.ItemTM;

public class ItemBOImpl implements ItemBO {

  ItemDAO itemDAO = DAOFactory.getInstance().getDAO(DAOType.ITEM);

  @Override
  public boolean saveItem(String itemId, String categoryId, String description, int qtyOnHand, double buyPrice,
      double unitPrice) throws Exception {
    return false;
  }

  @Override
  public boolean updateItem(String categoryId, String description, int qtyOnHand, double buyPrice, double unitPrice,
      String itemId) throws Exception {
    return false;
  }

  @Override
  public boolean deleteItem(String itemId) throws Exception {
    return false;
  }

  @Override
  public List<ItemTM> findAllItem() throws Exception {
    return null;
  }

  @Override
  public String getNewItemId() throws Exception {
    String lastItemId = null;
    try {
      lastItemId = itemDAO.getLastItemId();
    } catch (Exception e) {
      e.printStackTrace();
    }
    if (lastItemId == null) {
      return "I001";
    } else {
      int maxId = Integer.parseInt(lastItemId.replace("I", ""));
      maxId = maxId + 1;
      String id = "";
      if (maxId < 10) {
        id = "I00" + maxId;
      } else if (maxId < 100) {
        id = "I0" + maxId;
      } else {
        id = "I" + maxId;
      }
      return id;
    }
  }
}
