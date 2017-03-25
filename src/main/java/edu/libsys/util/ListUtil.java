package edu.libsys.util;

import java.util.List;
import java.util.stream.Collectors;

public class ListUtil {
    //整数列表去重
    //http://stackoverflow.com/questions/27464781/creating-distinct-list-from-existing-list-in-java-7-and-8
    public static List<Integer> dedupIntegerList(List<Integer> integerList){
        return integerList.stream().distinct().collect(Collectors.toList());
    }
}
