package com.janis.bgg;

import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StartingEventListener implements ApplicationListener<ApplicationStartingEvent> {
    // @Value("${mysql.path}")
    private String mysqlPath = "e:\\xampp\\mysql_start.bat";

    @Override
    public void onApplicationEvent(ApplicationStartingEvent applicationStartingEvent) {


        try {
            String line;
            StringBuilder pidInfo = new StringBuilder();
            Runtime runtime = Runtime.getRuntime();
            Process p = runtime.exec(System.getenv("windir") + "\\system32\\" + "tasklist.exe");

            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));

            while ((line = input.readLine()) != null) {
                pidInfo.append(line);
            }
            p.destroy();
            input.close();

            if (!pidInfo.toString().contains("mysqld.exe")) {
                // Runtime sqlRuntime = runtime;
                runtime.exec(mysqlPath);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
