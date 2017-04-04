package edu.libsys;

import edu.libsys.service.RestApplication;
import org.apache.log4j.PropertyConfigurator;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

/**
 * 主类
 */
public class Main {
    // Base URI the Grizzly HTTP server will listen on
    private static String BASE_URI = null;

    /**
     * 启动Grizzly HTTP server
     *
     * @return Grizzly HTTP server.
     */
    private static HttpServer startServer() {
        final ResourceConfig rc = new RestApplication();
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

    /**
     * 主方法
     *
     * @param args 控制台参数
     * @throws IOException IO异常
     */
    public static void main(String[] args) throws IOException {
        //检测参数
        if (args.length != 2) {
            System.err.println("Useage:\n" + "java -jar restful-service-1.0.jar IP PORT");
            System.exit(1);
        }

        //配置log4j
        //http://stackoverflow.com/questions/2552793/reading-xml-file-inside-a-jar-package
        InputStream inputStream = Main.class.getResourceAsStream("/resources/log4j.properties");
        org.apache.ibatis.logging.LogFactory.useLog4JLogging();
        PropertyConfigurator.configure(inputStream);

        //启动GrizzlyHttpServer
        BASE_URI = "http://" + args[0] + ":" + args[1];
        final HttpServer server = startServer();
        System.out.println(String.format("Jersey app started with WADL available at "
                + "%s/application.wadl\nHit Enter to stop it...", BASE_URI));

        //等待终止
        System.in.read();
        server.shutdownNow();
    }
}

