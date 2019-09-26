package com.janis.bgg.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StartingEventListener implements ApplicationListener<ApplicationStartingEvent> {
    @Value("${mysql.path}")
    private String mysqlPath;

    @Override
    public void onApplicationEvent(ApplicationStartingEvent applicationStartingEvent) {


        try {
            String line;
            String pidInfo = "";
            Process p = Runtime.getRuntime().exec(System.getenv("windir") + "\\system32\\" + "tasklist.exe");

            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));

            while ((line = input.readLine()) != null) {
                pidInfo += line;
            }

            input.close();

            if (!pidInfo.contains("mysqld.exe")) {
                Runtime runtime = Runtime.getRuntime();
                runtime.exec(new String[]{mysqlPath});
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
