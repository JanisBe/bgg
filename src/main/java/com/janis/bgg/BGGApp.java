package com.janis.bgg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import static java.lang.management.ManagementFactory.getRuntimeMXBean;

@SpringBootApplication
//@EnableJpaRepositories("com.janis.bgg.dao")
public class BGGApp {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(BGGApp.class);
        application.addListeners(new StartingEventListener());
        application.run(args);
    }

    public static void Browse(String url) {
        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(new URI(url));
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
        } else {
            Runtime runtime = Runtime.getRuntime();
            try {
                runtime.exec(new String[]{"cmd", "/c", "start chrome http://localhost:8080"});
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @EventListener({ApplicationReadyEvent.class})
    void applicationReadyEvent() {
        System.out.println("Application started ... launching browser now");
        boolean isDebug = getRuntimeMXBean().getInputArguments().toString().indexOf("-agentlib:jdwp") > 0;
        if (!isDebug) {
            Browse("localhost:8080");
        }
    }
}
