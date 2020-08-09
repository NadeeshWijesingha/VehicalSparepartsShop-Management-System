package entity;

public class Item implements SuperEntity {

  private String itemID;
  private String categoryId;
  private String description;
  private int qtyOnHand;
  private double buyPrice;
  private double unitPrice;

  public Item() {
  }

  public Item(String itemID, String categoryId, String description, int qtyOnHand, double buyPrice, double unitPrice) {
    this.itemID = itemID;
    this.categoryId = categoryId;
    this.description = description;
    this.qtyOnHand = qtyOnHand;
    this.buyPrice = buyPrice;
    this.unitPrice = unitPrice;
  }

  public String getItemID() {
    return itemID;
  }

  public void setItemID(String itemID) {
    this.itemID = itemID;
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
    return "Item{" +
        "itemID='" + itemID + '\'' +
        ", categoryId='" + categoryId + '\'' +
        ", description='" + description + '\'' +
        ", qtyOnHand=" + qtyOnHand +
        ", buyPrice=" + buyPrice +
        ", unitPrice=" + unitPrice +
        '}';
  }
}
