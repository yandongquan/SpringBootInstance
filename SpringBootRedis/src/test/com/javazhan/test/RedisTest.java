package com.javazhan.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void contextLoads() {
        /**
         stringRedisTemplate.opsForValue();//操作字符串
         stringRedisTemplate.opsForHash();//操作hash
         stringRedisTemplate.opsForList();//操作list
         stringRedisTemplate.opsForSet();//操作set
         stringRedisTemplate.opsForZSet();//操作有序set
         */
        // 向redis里存入数据和设置缓存时间
        stringRedisTemplate.opsForValue().set("test", "100", 60*10, TimeUnit.SECONDS);
        // 根据key获取缓存中的value
        System.out.println("test的值：" + stringRedisTemplate.opsForValue().get("test"));
        // 根据key获取过期时间
        System.out.println("过期时间："+stringRedisTemplate.getExpire("test"));
        // 根据key获取过期时间并换算成指定单位
        System.out.println("过期时间（单位）："+stringRedisTemplate.getExpire("test",TimeUnit.SECONDS));
        // 检查key是否存在，返回boolean值
        System.out.println("是否含有key：" + stringRedisTemplate.hasKey("test"));
        // 根据key删除缓存
        stringRedisTemplate.delete("test");
        System.out.println("删除后test的值：" + stringRedisTemplate.opsForValue().get("test"));

    }

}
