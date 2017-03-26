package edu.libsys;

import edu.libsys.service.RestApplication;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;

/**
 * Main class.
 */
public class Main {
    // Base URI the Grizzly HTTP server will listen on
    private static String BASE_URI = null;

    /**
     * Starts Grizzly HTTP server exposing JAX-RS resources defined in this application.
     *
     * @return Grizzly HTTP server.
     */
    private static HttpServer startServer() {
        // create a resource config that scans for JAX-RS resources and providers
        final ResourceConfig rc = new RestApplication();

        // create and start a new instance of grizzly http server
        // exposing the Jersey application at BASE_URI
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

    /**
     * Main method.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        //检测参数
        if (args.length != 2){
            System.err.println("Useage:\n" + "java -jar restful-service-1.0.jar IP PORT" );
            System.exit(1);
        }
        BASE_URI =  "http://" + args[0] + ":" + args[1];
        final HttpServer server = startServer();
        System.out.println(String.format("Jersey app started with WADL available at "
                + "%s/application.wadl\nHit Enter to stop it...", BASE_URI));
        System.in.read();
        server.shutdownNow();
    }
}

