package dao.custom.impl;

import java.util.List;

import dao.custom.CategoryDAO;
import entity.Category;

public class CategoryDAOImpl implements CategoryDAO {

  @Override
  public List<Category> findAll() {
    return null;
  }

  @Override
  public Category find(String key) {
    return null;
  }

  @Override
  public boolean save(Category entity) {
    return false;
  }

  @Override
  public boolean update(Category entity) {
    return false;
  }

  @Override
  public boolean delete(String key) {
    return false;
  }
}
