package edu.libsys.util;

import org.apache.log4j.PropertyConfigurator;
import redis.clients.jedis.*;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Test {
    //test
    public static void main(String[] args) throws SQLException {
        redis();
    }
/*

    public static void mongodb(){
        ServerAddress serverAddress = new ServerAddress("localhost", 8002);
        List<ServerAddress> addresses = new ArrayList<>();
        addresses.add(serverAddress);
        MongoCredential credential = MongoCredential.createCredential("spark", "libsys", "123456a".toCharArray());
        List<MongoCredential> credentials = new ArrayList<>();
        credentials.add(credential);

        MongoClient mongoClient = new MongoClient(addresses, credentials);

        MongoDatabase mongoDatabase = mongoClient.getDatabase("libsys");
        MongoCollection<Document> collection = mongoDatabase.getCollection("book");
        //collection.f
    }
*/

    public static void redis() {
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

    private static void config() {
        InputStream inputStream = Test.class.getResourceAsStream("/resources/log4j.properties");
        org.apache.ibatis.logging.LogFactory.useLog4JLogging();
        PropertyConfigurator.configure(inputStream);
    }
}