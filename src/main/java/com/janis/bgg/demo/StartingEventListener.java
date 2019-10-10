package com.janis.bgg.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;

public class StartingEventListener implements ApplicationListener<ApplicationStartingEvent> {
    // @Value("${mysql.path}")
    private String mysqlPath = "d:\\xampp\\mysql_start.bat";

    @Override
    public void onApplicationEvent(ApplicationStartingEvent applicationStartingEvent) {


        try {
            String line;
            String pidInfo = "";
            Runtime runtime = Runtime.getRuntime();
            Process p = runtime.exec(System.getenv("windir") + "\\system32\\" + "tasklist.exe");

            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));

            while ((line = input.readLine()) != null) {
                pidInfo += line;
            }
            p.destroy();
            input.close();

            if (!pidInfo.contains("mysqld.exe")) {
                // Runtime sqlRuntime = runtime;
                runtime.exec(mysqlPath);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
