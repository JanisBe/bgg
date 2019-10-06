package com.janis.bgg.demo.utils;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Component
public class ImporterUtils {

    public static String connect(String address) throws IOException {
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
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String readLine;

            while ((readLine = in.readLine()) != null) {
                content.append(readLine);
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
        return content.toString();
    }
}
