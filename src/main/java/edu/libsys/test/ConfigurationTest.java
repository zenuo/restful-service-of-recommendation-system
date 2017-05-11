package edu.libsys.test;

import org.apache.log4j.PropertyConfigurator;

import java.io.InputStream;

public class ConfigurationTest {
    public static void main(String[] args) {
        config();
    }

    private static void config() {
        InputStream inputStream = ConfigurationTest.class.getResourceAsStream("/resources/log4j.properties");
        org.apache.ibatis.logging.LogFactory.useLog4JLogging();
        PropertyConfigurator.configure(inputStream);
    }
}
