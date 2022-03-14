package fr.tp.springboottp.controllers;

import fr.tp.springboottp.Component.ServerProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {
    // TECHNIQUE AVEC @Value
    @Value("${server.app.version}")
    private String appVersion;

    @RequestMapping("/")
    @GetMapping
    public Map<String, String> get() {
        Map<String, String> serverProperties;
        serverProperties = new HashMap<>();
        serverProperties.put("version", appVersion);
        return serverProperties;
    }

    // TECHNIQUE AVEC @ConfigurationProperties (package fr.tp.springboottp.Component)
    /*
        @Autowired
        ServerProperties serverProperties;

        @RequestMapping("/")
        @GetMapping
        public Map<String, String> get() {
            return serverProperties.getApp();
        }
     */
}
