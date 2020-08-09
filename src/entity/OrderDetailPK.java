package entity;

public class OrderDetailPK implements SuperEntity {

  private String orderId;
  private String itemId;

  public OrderDetailPK() {
  }

  public OrderDetailPK(String orderId, String itemId) {
    this.orderId = orderId;
    this.itemId = itemId;
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

  @Override
  public String toString() {
    return "OrderDetailPK{" +
        "orderId='" + orderId + '\'' +
        ", itemId='" + itemId + '\'' +
        '}';
  }
}
