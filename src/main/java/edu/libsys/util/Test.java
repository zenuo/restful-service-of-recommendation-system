package edu.libsys.util;

import edu.libsys.data.dao.BookDao;
import org.apache.log4j.PropertyConfigurator;

public class Test {
    //test
    public static void main(String[] args) {
        PropertyConfigurator.configure("target/classes/edu/libsys/conf/config.properties");
        org.apache.ibatis.logging.LogFactory.useLog4JLogging();
        BookDao bookDao = new BookDao();
        System.out.println(bookDao.getBookByMarcRecId(3895026));
    }
}