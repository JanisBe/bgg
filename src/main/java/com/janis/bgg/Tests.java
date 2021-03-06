package com.janis.bgg;

import com.janis.bgg.entities.xml.Items3.Items;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Tests {


    public static void main(String[] args) throws IOException {
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
            con = (HttpURLConnection) new URL("https://api.geekdo.com/xmlapi2/thing?id=92539&stats=1").openConnection();
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
        String data = content.toString();
        System.out.println(data);
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(Items.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            StringReader reader = new StringReader(data);
            Items item = (Items) jaxbUnmarshaller.unmarshal(reader);

            System.out.println(item);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
