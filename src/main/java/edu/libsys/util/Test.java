package edu.libsys.util;

import edu.libsys.data.dao.BookDao;
import edu.libsys.data.dao.PaperDao;
import org.apache.log4j.PropertyConfigurator;

public class Test {
    //test
    public static void main(String[] args) {
        PropertyConfigurator.configure("target/classes/edu/libsys/conf/config.properties");
        org.apache.ibatis.logging.LogFactory.useLog4JLogging();
        //PaperDao paperDao = new PaperDao();
        //paperDao.getPaperList(1, 10).forEach(System.out::println);
    }
}