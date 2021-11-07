package com.company;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class HTMLParser {

    public static void main(String[] args) throws IOException {
        List<Article> articleList = new ArrayList<>();

        Document doc = Jsoup.connect("https://4pda.to/").get();
        // получаем заголовки статьи
        Elements h2Element = doc.getElementsByAttributeValue("class", "list-post-title");

        h2Element.forEach(h2Elem -> {
            Element aElement = h2Elem.child(0);
            String url = aElement.attr("href");
            String title = aElement.child(0).text();
            articleList.add(new Article(url, title));
        });

        String outFile = "D:\\texst\\4pda.txt";
        File file = new File(outFile);
        PrintWriter printWriter = new PrintWriter(file);
        articleList.forEach(s -> printWriter.println(s.getName()));
        printWriter.close();
    }

    static class Article {
        private String url;
        private String name;

        public Article(String url, String name) {
            this.url = url;
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return
                    "Article{" +
                    "url='" + url + '\'' +
                    ", name='" +
                            name
                            + '\'' +
                    '}'
                    ;
        }
    }
}
