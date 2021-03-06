package edu.libsys.data.dao;

import edu.libsys.conf.Conf;
import edu.libsys.util.ListUtil;
import edu.libsys.util.StringUtil;
import redis.clients.jedis.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Jedis数据连接对象
 */
public class JedisDao {
    /**
     * Jedis连接池
     */
    private static JedisPool jedisPool = null;

    /**
     * 返回Jedis实例
     *
     * @return Jedis实例
     */
    private static Jedis getJedis() {
        if (jedisPool == null) {
            JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
            jedisPoolConfig.setMaxIdle(10);
            jedisPoolConfig.setMaxTotal(100);

            jedisPool = new JedisPool(jedisPoolConfig, "localhost");
        }
        return jedisPool.getResource();
    }

    /**
     * 搜索
     *
     * @param indexOfRedisDatabase redis数据库索引
     * @param keyWord              关键词字符串
     * @return 匹配的结果的id数组
     */
    public static List<Integer> search(final int indexOfRedisDatabase, final String keyWord) {
        //分割关键词，获取子字符串
        String[] keyWordArray = StringUtil.getStringArrayBySubStringLength(keyWord, Conf.LENGTH_OF_SPLIT_KEYWORD);
        //匹配的结果的id列表
        List<Integer> resultIntList = new ArrayList<>();
        //遍历子字符串，检索并将结果加入id列表
        for (String s : keyWordArray) {
            resultIntList.addAll(scanByKeyWord(indexOfRedisDatabase, s));
        }
        return ListUtil.deDupIntegerList(resultIntList);
    }

    /**
     * 根据关键词返回匹配的结果的id数组
     *
     * @param indexOfRedisDatabase redis数据库索引
     * @param keyWord              关键词字符串
     * @return 匹配的结果的id数组
     */
    private static List<Integer> scanByKeyWord(final int indexOfRedisDatabase, final String keyWord) {
        //结果-字符串列表
        List<String> resultStringList = new ArrayList<>();
        try (Jedis jedis = JedisDao.getJedis()) {
            //选择数据库
            jedis.select(indexOfRedisDatabase);
            //设置游标
            String cursor = "0";
            //设置便利参数，为搜索做准备
            ScanParams params = new ScanParams();
            params.match("*" + keyWord + "*");
            //遍历
            do {
                ScanResult<String> scanResult = jedis.scan(cursor, params);
                cursor = scanResult.getStringCursor();
                resultStringList.addAll(scanResult.getResult());
                //在结果数量大于预订数量时退出
            } while (resultStringList.size() <= Conf.MAX_AMOUNT_OF_SEARCH && !"0".equals(cursor));
        }
        //结果-整型数组
        List<Integer> resultIntList = new ArrayList<>();
        for (String resultString : resultStringList) {
            int id = getId(resultString);
            resultIntList.add(id);
        }
        return resultIntList;
    }

    /**
     * 根据在redis中查找到的结果，返回id
     *
     * @param line redis返回的key
     * @return id
     */
    private static int getId(final String line) {
        try {
            //分割
            String[] tokens = line.split("#");
            //返回第一个成员
            return Integer.valueOf(tokens[0]);
        } catch (Exception e) {
            //若不存在，返回0
            return 0;
        }
    }
}
