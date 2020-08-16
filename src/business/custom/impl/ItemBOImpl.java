package business.custom.impl;

import java.util.ArrayList;
import java.util.List;

import business.custom.ItemBO;
import dao.DAOFactory;
import dao.DAOType;
import dao.custom.CategoryDAO;
import dao.custom.ItemDAO;
import entity.Category;
import entity.Item;
import util.ItemTM;

public class ItemBOImpl implements ItemBO {

  ItemDAO itemDAO = DAOFactory.getInstance().getDAO(DAOType.ITEM);
  CategoryDAO categoryDAO = DAOFactory.getInstance().getDAO(DAOType.CATEGORY);

  @Override
  public boolean saveItem(String itemId, String categoryId, String description, int qtyOnHand, double buyPrice,
      double unitPrice) throws Exception {
    return itemDAO.save(new Item(itemId, categoryId, description, qtyOnHand, buyPrice, unitPrice));
  }

  @Override
  public boolean updateItem(String categoryId, String description, int qtyOnHand, double buyPrice, double unitPrice,
      String itemId) throws Exception {
    return itemDAO.update(new Item(itemId, categoryId, description, qtyOnHand, buyPrice, unitPrice));
  }

  @Override
  public boolean deleteItem(String itemId) throws Exception {
    return itemDAO.delete(itemId);
  }

  @Override
  public List<ItemTM> findAllItem() throws Exception {
    List<Item> allItems = itemDAO.findAll();
    List<ItemTM> items = new ArrayList<>();
    for (Item item : allItems) {
      items.add(new ItemTM(item.getItemID(), item.getCategoryId(), item.getDescription(), item.getQtyOnHand(),
          item.getBuyPrice(), item.getUnitPrice()));
    }
    return items;
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

  @Override
  public List<Category> getCategories() throws Exception {
    List<Category> categoryList = new ArrayList<>();
    List<Category> cat = categoryDAO.findAll();

    for (Category category : cat) {
      categoryList.add(new Category(category.getCategoryId(), category.getDescription()));
    }
    return categoryList;
  }
}
