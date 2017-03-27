package edu.libsys.util;

import org.apache.log4j.PropertyConfigurator;

import java.io.InputStream;

public class Test {
    //test
    public static void main(String[] args) {
        config();
    }

    private static void config(){
        InputStream inputStream = Test.class.getResourceAsStream("/test.xml");
        org.apache.ibatis.logging.LogFactory.useLog4JLogging();
        PropertyConfigurator.configure(inputStream);
    }
}