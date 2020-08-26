package business.custom;

import java.util.List;

import business.SuperBO;
import entity.Category;

public interface CategoryBO extends SuperBO {

  public List<Category> getCategories() throws Exception;

}
