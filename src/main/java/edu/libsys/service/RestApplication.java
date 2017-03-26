package edu.libsys.service;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.glassfish.jersey.server.ResourceConfig;

public class RestApplication extends ResourceConfig{
    public RestApplication() {
        packages("edu.libsys.service");
        register(JacksonJsonProvider.class);
    }
}
