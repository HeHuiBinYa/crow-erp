package com.crow.utils;

import com.crow.model.Columnar;
import com.crow.model.ColumnarList;
import io.netty.util.internal.ReflectionUtil;
import org.springframework.data.util.ReflectionUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.PropertyPermission;

/**
 * @PackageName:IntelliJ IDEA
 * @ClassName:StringUtils
 * @Description:
 * @Author 青黑色的乌鸦
 * @Email xingtan1976tkt@163.com
 * @Date 2023/7/19 13:23
 * @Role
 */

public class StringUtils {
    /**
     * 验证字符串是否匹配
     * @param s1
     * @param s2
     * @return
     */
    public static Boolean verify(String s1,String s2){
       return s1.equals(s2);
    }

    public static String odd_numbers(String odd_numbers){
        LocalDateTime now = LocalDateTime.now();
        return odd_numbers+"0"+now.getYear()+"0"+now.getMonth().getValue()+"0"+now.getHour()+now.getMinute()+"0"+now.getSecond();
    }

    /**
     * 状型图数组转List集合
     * @param columnars
     * @return
     */
    public static ColumnarList arrayToList(Columnar[] columnars){
        ColumnarList columnarList = new ColumnarList();

        for (int i = 0; i < columnars.length; i++) {
            columnarList.getNameList().add(columnars[i].getName());
            columnarList.getCountList().add(columnars[i].getCount());
        }

        return columnarList;
    }

    public static Object setPropertyNull(Object obj, String propertyName) {
        //利用反射获取类属性
        Field[] field = obj.getClass().getDeclaredFields();
        for (int i = 0; i < field.length; i++) {
            Field f = field[i];
            f.setAccessible(true);
            //获取属性名
            String name = field[i].getName();
            name = name.substring(0, 1).toUpperCase() + name.substring(1);
            Method method = null;
            //获取属性类型
            String type = field[i].getGenericType().toString();
            try {
                //
                if (type.equals("class java.lang.String") && propertyName.equalsIgnoreCase(name)) {
                    method = obj.getClass().getMethod("set" + name, String.class);
                    method.invoke(obj, (Object)null);
                }
                if (type.equals("class java.lang.Integer") && propertyName.equalsIgnoreCase(name)) {
                    method = obj.getClass().getMethod("set" + name, Integer.class);
                    method.invoke(obj, (Object)null);
                }
                if (type.equals("int") && propertyName.equalsIgnoreCase(name)) {
                    method = obj.getClass().getMethod("set" + name, int.class);
                    method.invoke(obj, (Object)null);
                }
                if (type.equals("class java.lang.Long") && propertyName.equalsIgnoreCase(name)) {
                    method = obj.getClass().getMethod("set" + name, Long.class);
                    method.invoke(obj, (Object)null);
                }
                if (type.equals("class java.math.BigDecimal") && propertyName.equalsIgnoreCase(name)) {
                    method = obj.getClass().getMethod("set" + name, BigDecimal.class);
                    method.invoke(obj, (Object)null);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return obj;
    }
}
