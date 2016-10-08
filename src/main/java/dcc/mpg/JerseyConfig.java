package dcc.mpg;

import org.glassfish.jersey.server.ResourceConfig;

/**
 * Setup our Jersey services.
 */
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(MpgService.class);
    }
}
