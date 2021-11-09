package com.company;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import java.io.IOException;

public class HTMLParser {
    private static Document doc;

    public static void main(String[] args)  {
        getWeb();
    }

    static private void getWeb() {
        try {
            doc = Jsoup.connect("https://www.simbirsoft.com/").get();
            System.out.println(doc.text());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
