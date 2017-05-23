package edu.libsys.test;

import edu.libsys.util.StringUtil;

public class Test {
    public static void main(String[] args) {
        String[] strings = StringUtil.getStringArrayBySubStringLength("abcdefgh", 2);
        System.out.println("Length: " + strings.length);
        for (String s : strings) {
            System.out.println(s);
        }
    }
}
