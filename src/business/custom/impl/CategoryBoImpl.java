package business.custom.impl;

import java.util.ArrayList;
import java.util.List;

import business.custom.CategoryBO;
import dao.DAOFactory;
import dao.DAOType;
import dao.custom.CategoryDAO;
import entity.Category;

public class CategoryBoImpl implements CategoryBO {

  CategoryDAO categoryDAO = DAOFactory.getInstance().getDAO(DAOType.CATEGORY);

  @Override
  public List<Category> getCategories() throws Exception {
    List<Category> categories = new ArrayList<>();
    List<Category> all = categoryDAO.findAll();
    for (Category category : all) {
      categories.add(new Category(category.getCategoryId(), category.getDescription()));
    }
    return categories;
  }
}
