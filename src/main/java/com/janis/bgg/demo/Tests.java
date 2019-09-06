package com.janis.bgg.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.janis.bgg.demo.XMLObjects.Items;

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
            con = (HttpURLConnection) new URL("https://api.geekdo.com/xmlapi2/thing?id=12").openConnection();
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
        System.out.println(content.toString());
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(Items.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            StringReader reader = new StringReader(content.toString());
            Items employee = (Items) jaxbUnmarshaller.unmarshal(reader);

            System.out.println(employee);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
