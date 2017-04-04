package edu.libsys.service;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.glassfish.jersey.CommonProperties;
import org.glassfish.jersey.server.ResourceConfig;

public class RestApplication extends ResourceConfig{
    public RestApplication() {
        packages("edu.libsys.service");
        property(CommonProperties.MOXY_JSON_FEATURE_DISABLE, true);
        register(JacksonJsonProvider.class);
    }
}
