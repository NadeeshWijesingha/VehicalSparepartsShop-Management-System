package dao.custom.impl;

import java.sql.SQLException;
import java.util.List;

import dao.CrudUtil;
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
  public boolean save(Category category) throws SQLException {
    return CrudUtil.execute("INSERT INTO Category VALUES (?,?)", category.getCategoryId(), category.getDescription());
  }

  @Override
  public boolean update(Category category) throws SQLException {
    return CrudUtil.execute("UPDATE Category SET description = ? WHERE categoryId = ?", category.getDescription(), category.getCategoryId());
  }

  @Override
  public boolean delete(String key) throws SQLException {
    return CrudUtil.execute("DELETE FROM Category WHERE categoryId = ?", key);
  }
}
