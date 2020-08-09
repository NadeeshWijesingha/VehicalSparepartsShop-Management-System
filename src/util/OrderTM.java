package util;

import java.sql.Date;

public class OrderTM {

  private String orderId;
  private String itemId;
  private String description;
  private int addedQty;
  private double total;

  public OrderTM() {
  }

  public OrderTM(String orderId, String itemId, String description, int addedQty, double total) {
    this.orderId = orderId;
    this.itemId = itemId;
    this.description = description;
    this.addedQty = addedQty;
    this.total = total;
  }

  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  public String getItemId() {
    return itemId;
  }

  public void setItemId(String itemId) {
    this.itemId = itemId;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getAddedQty() {
    return addedQty;
  }

  public void setAddedQty(int addedQty) {
    this.addedQty = addedQty;
  }

  public double getTotal() {
    return total;
  }

  public void setTotal(double total) {
    this.total = total;
  }

  @Override
  public String toString() {
    return "OrderTM{" +
        "orderId='" + orderId + '\'' +
        ", itemId='" + itemId + '\'' +
        ", description='" + description + '\'' +
        ", addedQty=" + addedQty +
        ", total=" + total +
        '}';
  }
}
