package business.custom.impl;

import java.util.List;

import business.custom.ItemBO;
import util.ItemTM;

public class ItemBOImpl implements ItemBO {

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
    return null;
  }
}
