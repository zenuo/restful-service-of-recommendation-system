package edu.libsys.resource;

import org.glassfish.jersey.CommonProperties;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/api/*")
public class JsonResourceConfig extends ResourceConfig {
    public JsonResourceConfig() {
        //注册
        register(BookResource.class);
        register(PaperResource.class);

        //禁用自动探测
        property(CommonProperties.MOXY_JSON_FEATURE_DISABLE, true);
    }
}
