package com.example.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class StringRedis {

    private String prefix = "spring:";

    @Autowired
    private  RedisTemplate<String, String> redisTemplate;


    private String getPrefix(String key) {
        return this.prefix + key;
    }
    /**
     * 读取缓存
     * @param key
     * @return
     */
    public String get(String key) {
        if (StringUtils.isEmpty(key)) {
            return null;
        }
        key = this.getPrefix(key);

        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 设置
     * @param key
     * @param value
     * @return
     */
    public boolean set(String key, String value) {

        key = this.getPrefix(key);

        boolean result = false;
        try {
            redisTemplate.opsForValue().set(key, value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
