package com.company;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class HTMLParser {

    public static void main(String[] args) throws IOException {
        Document document = Jsoup.connect("https://www.simbirsoft.com/").get();
        Elements elements = document.select("img");
        for (Element element: elements) {
            System.out.println(element);
        }
    }
}
