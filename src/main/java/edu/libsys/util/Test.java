package edu.libsys.util;

import org.apache.log4j.PropertyConfigurator;

public class Test {
    //test
    public static void main(String[] args) {
        PropertyConfigurator.configure("target/classes/edu/libsys/conf/log4j.properties");
        org.apache.ibatis.logging.LogFactory.useLog4JLogging();
        System.out.println(System.getProperty("user.dir"));
    }
}