package edu.libsys.util;

import org.apache.log4j.PropertyConfigurator;

import java.io.InputStream;
import java.sql.SQLException;

public class Test {
    //test
    public static void main(String[] args) throws SQLException {
        config();
    }

    private static void config() {
        InputStream inputStream = Test.class.getResourceAsStream("/resources/log4j.properties");
        org.apache.ibatis.logging.LogFactory.useLog4JLogging();
        PropertyConfigurator.configure(inputStream);
    }
}