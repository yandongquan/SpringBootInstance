package com.javazhan.tools;

import redis.clients.jedis.Jedis;

public class JedisTools {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.0.111", 6379);
        jedis.auth("123456");
        //jedis.set("name", "jedis");
        System.out.println("");
        String value = jedis.get("name");
        System.out.println(value);
        jedis.close();
    }
}
