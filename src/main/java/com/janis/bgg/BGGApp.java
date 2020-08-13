package com.janis.bgg;

import org.hibernate.exception.JDBCConnectionException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import static java.lang.management.ManagementFactory.getRuntimeMXBean;

@SpringBootApplication
public class BGGApp {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(BGGApp.class);
        application.addListeners(new StartingEventListener());
        try {
            application.run(args);
        }
        catch (Exception ex){
            System.out.println("Włącz bazę danych!");
            System.exit(1);
        }
    }

    private static void Browse() {
        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(new URI("localhost:4200"));
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
        } else {
            Runtime runtime = Runtime.getRuntime();
            try {
                runtime.exec(new String[]{"cmd", "/c", "start chrome http://localhost:4200"});
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @EventListener({ApplicationReadyEvent.class})
    public void applicationReadyEvent() {
        System.out.println("Application started ... launching browser now");
        boolean isDebug = getRuntimeMXBean().getInputArguments().toString().indexOf("-agentlib:jdwp") > 0;
        if (!isDebug) {
            Browse();
        }
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("DELETE");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
