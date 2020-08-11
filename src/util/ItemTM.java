package util;

public class ItemTM {

  private String itemId;
  private String categoryId;
  private String description;
  private int qtyOnHand;
  private double buyPrice;
  private double unitPrice;

  public ItemTM() {
  }

  public ItemTM(String itemId, String categoryId, String description, int qtyOnHand, double buyPrice,
      double unitPrice) {
    this.itemId = itemId;
    this.categoryId = categoryId;
    this.description = description;
    this.qtyOnHand = qtyOnHand;
    this.buyPrice = buyPrice;
    this.setUnitPrice(unitPrice);
  }

  public String getItemId() {
    return itemId;
  }

  public void setItemId(String itemId) {
    this.itemId = itemId;
  }

  public String getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(String categoryId) {
    this.categoryId = categoryId;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getQtyOnHand() {
    return qtyOnHand;
  }

  public void setQtyOnHand(int qtyOnHand) {
    this.qtyOnHand = qtyOnHand;
  }

  public double getBuyPrice() {
    return buyPrice;
  }

  public void setBuyPrice(double buyPrice) {
    this.buyPrice = buyPrice;
  }

  public double getUnitPrice() {
    return unitPrice;
  }

  public void setUnitPrice(double unitPrice) {
    this.unitPrice = unitPrice;
  }

  @Override
  public String toString() {
    return "ItemTM{" +
        "itemId='" + itemId + '\'' +
        ", categoryId='" + categoryId + '\'' +
        ", description='" + description + '\'' +
        ", qtyOnHand=" + qtyOnHand +
        ", buyPrice=" + buyPrice +
        ", unitPrice=" + unitPrice +
        '}';
  }
}
