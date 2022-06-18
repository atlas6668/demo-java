package com.atlas.spring.annotation;

/**
 * @author sunwenming
 * @date 2022/6/17.
 */
public class T {

    public static void main(String[] args) throws IllegalAccessException {
        UserOrderEntity userOrderEntity = new UserOrderEntity();
        userOrderEntity.setOrderId("111111");
        userOrderEntity.setUserId("222222");
        String sql = QueryUtil.buildSql(userOrderEntity);
        System.out.println(sql);
    }

}
