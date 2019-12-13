package xmu.oomall.controller.VO;
import xmu.oomall.domain.*;

public class OrderItemVo {
    /**
     * 订单项信息
     */
    OrderItem orderItem;
    /**
     * 商品规格信息
     */
    ProductVo productVo;

    public OrderItem getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(OrderItem orderItem) {
        this.orderItem = orderItem;
    }

    public ProductVo getProductVo() {
        return productVo;
    }

    public void setProductVo(ProductVo productVo) {
        this.productVo = productVo;
    }
}
