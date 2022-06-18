package com.atlas.spring.annotation;

import java.lang.reflect.Field;

/**
 * @author sunwenming
 * @date 2022/6/17.
 */
public class QueryUtil {

    public static String buildSql(Object object) throws IllegalAccessException {
        String sql = "select * from ";
        Class clazz = object.getClass();
        System.out.println(clazz.isAnnotationPresent(Table.class));
        if (clazz.isAnnotationPresent(Table.class)) {
            Table table = (Table) clazz.getAnnotation(Table.class);
            sql += table.value() + " where 1=1";
            for (Field field : clazz.getDeclaredFields()) {
                field.setAccessible(true);
                Object o = field.get(object);
                if (null == o) {
                    continue;
                }
                if (field.isAnnotationPresent(Column.class)) {
                    Column column = field.getAnnotation(Column.class);
                    sql += " and " + column.value() + "='" + o + "'";
                }
            }
        }
        return sql;
    }

}
