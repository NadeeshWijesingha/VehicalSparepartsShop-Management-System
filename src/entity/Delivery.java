package entity;

public class Delivery implements SuperEntity {

  private DeliveryPK deliveryPK;
  private String address;
  private String status;

  public Delivery() {
  }

  public Delivery(DeliveryPK deliveryPK, String address, String status) {
    this.deliveryPK = deliveryPK;
    this.address = address;
    this.status = status;
  }

  public Delivery(String deliveryId, String orderId, String address, String status) {
    this.deliveryPK = new DeliveryPK(deliveryId, orderId);
    this.address = address;
    this.status = status;
  }

  public DeliveryPK getDeliveryPK() {
    return deliveryPK;
  }

  public void setDeliveryPK(DeliveryPK deliveryPK) {
    this.deliveryPK = deliveryPK;
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
    return "Delivery{" +
        "deliveryPK=" + deliveryPK +
        ", address='" + address + '\'' +
        ", status='" + status + '\'' +
        '}';
  }
}
