package com.crow.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisClusterNode;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtils {
    private RedisTemplate redisTemplate;

    @Autowired
    public RedisUtils(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * 设置过期值
     * @param key    key名称
     * @param value  数据
     * @param time   单位为分钟
     */
    public void seTex(Object key,Object value,Long time){
        ValueOperations string = redisTemplate.opsForValue();
        string.set(key,value);
        redisTemplate.expire(key, time, TimeUnit.MINUTES);
    }

    /**
     * 判断key是否存在
     * @param key key名称
     * @return
     */
    public Boolean exists(String key){
        return redisTemplate.hasKey(key);
    }

    /**
     * 获得key值
     * @param key key名称
     * @return
     */
    public Object getKey(String key){
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 操作String
     * @return
     */
    public ValueOperations<String, Object> getRedisString(){
        return redisTemplate.opsForValue();
    }

    /**
     * 设置String key与值存在时间
     * @param key key名称
     * @param value 值
     * @param timeUnit 存在格式
     * @param dateTime 时分秒天
     * @return
     */
    public Boolean setStringDateTime(String key, Object value, TimeUnit timeUnit,Long dateTime){
        if (!exists(key)) {
            getRedisString().set(key,value);

            return redisTemplate.expire(key,dateTime,timeUnit);
        }

        throw new RuntimeException("key 已存在");
    }


    /**
     * 删除Key
     * @param key
     * @return
     */
    public Boolean deleteKey(String key){
        if (redisTemplate.delete(key)) {
            return true;
        }
        return false;
    }

    /**
     * 清除缓存
     */
    public void flushDb(){
        Set keys = redisTemplate.keys("*");
        keys.forEach(item -> {
            System.out.println(item);
            redisTemplate.delete(item);
        });
    }
}
