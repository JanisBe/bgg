package com.janis.bgg.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.janis.bgg.constants.AppConstants.NOT_RANKED;
import static com.janis.bgg.service.ImportService.zapisz;

@Component
public class ImporterUtils {

    public static String connect(String address) throws IOException, InterruptedException {
        HttpURLConnection con = null;
        Matcher m = Pattern.compile("^(.+id=)([0-9]+)(&.+)").matcher(address);
        m.find();
        StringBuilder content = new StringBuilder();
        while (true) {
            if (!(con == null || con.getResponseCode() == 200))
                break;
            con = (HttpURLConnection) new URL(address).openConnection();
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
            zapisz(content.toString().replace(NOT_RANKED, "0"), null);
            if (content.toString().length() < 10 || content.toString().equals(StringUtils.EMPTY)) {
                TimeUnit.SECONDS.sleep(1);
                break;
            }
            in.close();
            con.disconnect();
            break;
        }
        return content.toString().replace(NOT_RANKED, "0");
    }
}
