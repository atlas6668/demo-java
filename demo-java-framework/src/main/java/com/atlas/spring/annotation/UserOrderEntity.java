package com.atlas.spring.annotation;

/**
 * @author sunwenming
 * @date 2022/6/17.
 */
@Table("user_order")
public class UserOrderEntity {

    @Column("order_id")
    private String orderId;

    @Column("user_id")
    private String userId;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
