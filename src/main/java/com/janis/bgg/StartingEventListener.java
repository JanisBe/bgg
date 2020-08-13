package com.janis.bgg;

import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

public class StartingEventListener implements ApplicationListener<ApplicationStartingEvent> {

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
                // @Value("${mysql.path}")
                String mysqlPath = "e:\\xampp\\mysql_start.bat";
                try {
                    runtime.exec(mysqlPath);
                }
                catch (IOException ex){
                    System.out.println("Nie masz plików startowych bazy danych!");
//                    System.exit(1);
                }
                TimeUnit.SECONDS.sleep(3);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
