package com.crow.utils;

import io.netty.util.internal.ReflectionUtil;
import org.springframework.data.util.ReflectionUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
}
