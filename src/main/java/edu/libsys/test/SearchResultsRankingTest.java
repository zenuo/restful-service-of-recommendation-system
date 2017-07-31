package edu.libsys.test;

import java.util.HashMap;
import java.util.Map;

/**
 * Redis检索结果排序
 */
public class SearchResultsRankingTest {
    public static void main(String[] args) {
        String[] strings = {"1#北京图书馆藏珍本年谱丛刊.第44册-影印本", "2#寸纸留香：国家图书馆西文藏书票集萃", "3#高职院校学科馆员与图书馆知识服务理论与实践", "4#图书馆供应链管理的研究", "5#四川大学图书馆馆藏珍稀四川地方志丛刊·续编"};
        String keyWord = "图书馆藏珍本年";
        Map<Integer, String> resultsWithMark = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            resultsWithMark.put(i * 1000, strings[i]);
        }
        System.out.println(resultsWithMark.get(0));

        for (int i = 0; i < strings.length; i++) {

        }
    }
}
