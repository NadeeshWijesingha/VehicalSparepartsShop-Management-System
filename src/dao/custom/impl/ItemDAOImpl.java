package dao.custom.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.CrudUtil;
import dao.custom.ItemDAO;
import entity.Customer;
import entity.Item;

public class ItemDAOImpl implements ItemDAO {

  @Override
  public String getLastItemId() throws SQLException {
    ResultSet rst = CrudUtil.execute("SELECT * FROM Item ORDER BY itemId DESC LIMIT 1");
    if (!rst.next()){
      return null;
    }else {
      return rst.getString(1);
    }
  }

  @Override
  public List<Item> findAll() throws SQLException {
    ResultSet rst = CrudUtil.execute("SELECT * FROM Item");
    List<Item> items = new ArrayList<>();
    while (rst.next()){
      items.add(new Item(rst.getString(1), rst.getString(2), rst.getString(3),
          rst.getInt(4), rst.getDouble(5), rst.getDouble(6)));
    }
    return items;
  }

  @Override
  public Item find(String key) throws SQLException {
    ResultSet rst = CrudUtil.execute("SELECT * FROM Item WHERE itemId = ?", key);
    if (rst.next()){
      return new Item(rst.getString(1),rst.getString(2),rst.getString(3), rst.getInt(4),
          rst.getDouble(5), rst.getDouble(6));
    }
    return null;
  }

  @Override
  public boolean save(Item item) throws SQLException {
    return CrudUtil.execute("INSERT INTO Item VALUES (?,?,?,?,?,?)", item.getItemID(), item.getCategoryId(),item.getDescription(),
        item.getQtyOnHand(), item.getBuyPrice(), item.getBuyPrice());
  }

  @Override
  public boolean update(Item item) throws SQLException {
    return CrudUtil.execute("UPDATE Item SET categoryId=?, description=?, qtyOnHand=?, buyPrice=?, unitPrice=? WHERE itemId = ?",item.getCategoryId(),item.getDescription(),
        item.getQtyOnHand(), item.getBuyPrice(), item.getBuyPrice(), item.getItemID());
  }

  @Override
  public boolean delete(String key) throws SQLException {
    return CrudUtil.execute("DELETE FROM Item WHERE itemId = ?", key);
  }
}
