package edu.libsys.test;

import edu.libsys.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1000);
        integerList.add(10000);
        boolean isRemoved = integerList.remove(new Integer(100));
        System.out.println(isRemoved);
        integerList.forEach(System.out::println);
    }
}
