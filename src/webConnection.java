import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;import java.net.*;
import java.util.Hashtable;
import java.io.*;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;



public class webConnection {
    public void readWeb() throws IOException {
        // Connection connect = Jsoup.connect("https://internetowykantor.pl/kurs-dolara/");
        //  Document document = connect.get();
        //  Elements allDiv = document.select("body > div.page-wrapper > div.page-main > div.content-container.with-top-margin > div.bem-single-rate-box > div.bem-single-rate-box__container > div.bem-single-rate-box__container-with-numbers > div:nth-child(2) > span.bem-single-rate-box__item-rate");


        /*
        System.out.println(allDiv);
        StringBuilder kurs = new StringBuilder(String.valueOf(allDiv));
        kurs.delete(0,74);
        kurs.delete(6,20);
        System.out.println(kurs);
        //Element kurs = document.querySelector("#knowledge-currency__updatable-data-column > div.b1hJbf > div.dDoNo.ikb4Bb.gsrt > span.DFlfde.SwHCTb");

         */
        // Make a URL to the web page
        URL url = new URL("https://internetowykantor.pl/kurs-dolara/");

        // Get the input stream through URL Connection
        URLConnection con = url.openConnection();
        InputStream is = con.getInputStream();

        // Once you have the Input Stream, it's just plain old Java IO stuff.

        // For this case, since you are interested in getting plain-text web page
        // I'll use a reader and output the text content to System.out.

        // For binary content, it's better to directly read the bytes from stream and write
        // to the target file.

        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line = null;

            // read each line and write to System.out
            while ((line = br.readLine()) != null) {
                if(line.contains("<div class=\"rate-alert-slider-center-label__rate\" data-js-selector=\"average-rate\">")){
                    break;
                }

            }
            StringBuilder sb = new StringBuilder(line);
            sb.delete(0,96).delete(6,20);
            System.out.println(sb);
            url.openConnection();

        }
/*
    @Override
    public Object getContent(URLConnection urlConnection) throws IOException {
        InputStream input = urlConnection.getInputStream();
        StringBuffer buf = new StringBuffer();
        int c;
        while ((c = input.read()) >= 0) {
            buf.append((char) c);
        }
        input.close();
        return (buf.toString());
    }

 */
    }
}

