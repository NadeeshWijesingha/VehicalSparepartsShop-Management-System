package business.custom;

import java.util.List;

import business.SuperBO;
import entity.Category;
import util.ItemTM;

public interface ItemBO extends SuperBO {

  boolean saveItem(String itemId, String categoryId, String description, int qtyOnHand, double buyPrice, double unitPrice) throws Exception;

  boolean updateItem(String categoryId, String description, int qtyOnHand, double buyPrice, double unitPrice, String itemId) throws Exception;

  boolean deleteItem(String itemId) throws Exception;

  List <ItemTM> findAllItem() throws Exception;

  String getNewItemId() throws Exception;

  public List<Category> getCategories()throws Exception;

}
