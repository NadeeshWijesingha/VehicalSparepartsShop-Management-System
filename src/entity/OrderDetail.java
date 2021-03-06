package entity;

public class OrderDetail implements SuperEntity {

  private OrderDetailPK orderDetailPK;
  private int qty;
  private double unitPrice;

  public OrderDetail() {
  }

  public OrderDetail(OrderDetailPK orderDetailPK, int qty, double unitPrice) {
    this.orderDetailPK = orderDetailPK;
    this.qty = qty;
    this.unitPrice = unitPrice;
  }

  public OrderDetail(String orderId, String itemId, int qty, double unitPrice) {
    this.orderDetailPK = new OrderDetailPK(orderId,itemId);
    this.qty = qty;
    this.unitPrice = unitPrice;
  }

  public OrderDetailPK getOrderDetailPK() {
    return orderDetailPK;
  }

  public void setOrderDetailPK(OrderDetailPK orderDetailPK) {
    this.orderDetailPK = orderDetailPK;
  }

  public int getQty() {
    return qty;
  }

  public void setQty(int qty) {
    this.qty = qty;
  }

  public double getUnitPrice() {
    return unitPrice;
  }

  public void setUnitPrice(double unitPrice) {
    this.unitPrice = unitPrice;
  }

  @Override
  public String toString() {
    return "OrderDetail{" +
        "orderDetailPK=" + orderDetailPK +
        ", qty=" + qty +
        ", unitPrice=" + unitPrice +
        '}';
  }
}
