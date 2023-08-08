package com.crow.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * 连接的工具类
 */
public class MybatisUtil {
    private static  SqlSessionFactory factory;

    static {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            factory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // 获取会话
    public static SqlSession getSession(){
        return factory.openSession();
    }

    // 带提交功能的会话
    public static SqlSession getSession(Boolean auto){
        return factory.openSession(auto);
    }
}
