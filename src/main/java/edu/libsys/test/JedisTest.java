package edu.libsys.test;

import redis.clients.jedis.*;

import java.util.ArrayList;
import java.util.List;

public class JedisTest {
    public static void main(String[] args) {
        redis();
    }

    private static void redis() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(10);
        jedisPoolConfig.setMaxTotal(100);

        JedisPool pool = new JedisPool(new JedisPoolConfig(), "localhost");
        String scanRet = "0";
        List<String> list = new ArrayList<>();
        ScanParams params = new ScanParams();
        params.match("*va");
        try (Jedis jedis = pool.getResource()) {
            do {
                ScanResult scanResult = jedis.scan(scanRet, params);
                scanRet = scanResult.getStringCursor();
                list.addAll(scanResult.getResult());
            } while (!"0".equals(scanRet));
        }
        list.forEach(System.out::println);
        pool.destroy();
    }
}
