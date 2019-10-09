package com.janis.bgg.demo.utils;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static com.janis.bgg.demo.constants.AppConstants.NOT_RANKED;

@Component
public class ImporterUtils {

    public static String connect(String address) throws IOException, InterruptedException {
        HttpURLConnection con = null;
        StringBuilder content = new StringBuilder();
        while (true) {
            // try {
            if (!(con == null || con.getResponseCode() == 200))
                break;
            // } catch (IOException e) {
            // System.out.println("nie działa coś na razie");
            // e.printStackTrace();
            // }
            // try {
            con = (HttpURLConnection) new URL(address).openConnection();
            // con.setRequestMethod("GET");
            if (con.getResponseCode() == 429) {
                TimeUnit.SECONDS.sleep(1);
                break;
            }
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String readLine;

            while ((readLine = in.readLine()) != null) {
                content.append(readLine);
            }
            if (content.toString().isEmpty()) {
                break;
            }
            in.close();
            con.disconnect();
            break;
            // } catch (IOException e) {
            // System.out.println("nie działa dla id");
            // e.printStackTrace();
            // // continue;
            // } finally {

            // }
        }
        return content.toString().replace(NOT_RANKED, "0");
    }
}
