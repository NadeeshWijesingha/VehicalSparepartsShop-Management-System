package dao.custom.impl;

import java.util.List;

import dao.custom.ItemDAO;
import entity.Item;

public class ItemDAOImpl implements ItemDAO {

  @Override
  public String getLastItemId() {
    return null;
  }

  @Override
  public List<Item> findAll() {
    return null;
  }

  @Override
  public Item find(String key) {
    return null;
  }

  @Override
  public boolean save(Item entity) {
    return false;
  }

  @Override
  public boolean update(Item entity) {
    return false;
  }

  @Override
  public boolean delete(String key) {
    return false;
  }
}
