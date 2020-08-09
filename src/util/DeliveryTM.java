package util;

public class DeliveryTM {

  private String deliveryId;
  private String orderId;
  private String address;
  private String status;

  public DeliveryTM() {
  }

  public DeliveryTM(String deliveryId, String orderId, String address, String status) {
    this.deliveryId = deliveryId;
    this.orderId = orderId;
    this.address = address;
    this.status = status;
  }

  public String getDeliveryId() {
    return deliveryId;
  }

  public void setDeliveryId(String deliveryId) {
    this.deliveryId = deliveryId;
  }

  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "DeliveryTM{" +
        "deliveryId='" + deliveryId + '\'' +
        ", orderId='" + orderId + '\'' +
        ", address='" + address + '\'' +
        ", status='" + status + '\'' +
        '}';
  }
}
