package edu.libsys.util;

import edu.libsys.entity.Book;
import org.apache.log4j.PropertyConfigurator;
import redis.clients.jedis.*;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Test {
    //test
    public static void main(String[] args) throws SQLException {
        testBookListDeDup();
    }

    public static void testBookListDeDup() {
        Book b1 = new Book();
        b1.setId(1);
        b1.setIsbn("10-1a");

        Book b2 = new Book();
        b2.setId(2);
        b2.setIsbn("10-1a");

        Book b3 = new Book();
        b3.setId(3);
        b3.setIsbn("10-2");

        Book b4 = new Book();
        b4.setId(4);
        b4.setIsbn("10-2");

        List<Book> bookList = new ArrayList<>();
        bookList.add(b1);
        bookList.add(b2);
        bookList.add(b3);
        bookList.add(b4);

        List<Book> deduped = ListUtil.deDupBookList(bookList);
        deduped.forEach(System.out::println);
    }

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