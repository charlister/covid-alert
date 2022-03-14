package fr.tp.springboottp.Component;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@ConfigurationProperties(prefix = "server")
public class ServerProperties {
    private Map<String, String> app;

    public Map<String, String> getApp() {
        return app;
    }

    public void setApp(Map<String, String> app) {
        this.app = app;
    }
}
