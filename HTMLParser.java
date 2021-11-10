package com.company;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HTMLParser {
    private static Document doc;

    public static void main(String[] args)  {
//        getWeb();

        String text = "Брайан Гетц. Java Concurrency на практике\n" +
                "Адитья Бхаргава. Грокаем алогритмы\n" +
                "(Опционально) Роберт Лафоре. Структуры данных и алгоритмы Java\n" +
                "(Опционально) Николай Палрог. Система модулей Java\n" +
                "(Опционально) Кен Коузен. Современный Java. Рецепты программирования\n" +
                "Видео\n" +
                "Jakob Jenkov, Java Concurrency And Multithreading";
        Map<String, Integer> map = workTekst(text);
        map.forEach((w,n) -> System.out.println(w + " - " + n));
    }
// метод выводит текст вэб страницы
    static private void getWeb() {
        try {
            doc = Jsoup.connect("https://www.simbirsoft.com/").get();
            System.out.println(doc.text());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
// возвращаем мар-у с количеством каждого слова
    static private Map<String, Integer> workTekst(String text) {
        Scanner scanner = new Scanner(text);
//        scanner.useDelimiter("[\\W]+?");
        Map<String, Integer> map = new HashMap<>();
        String word;
        int numWord;
        while (scanner.hasNext()) {
            numWord = 1;
            word = scanner.next().toUpperCase();
            if (map.containsKey(word)) {
                numWord += map.get(word);
            }
            map.put(word, numWord);
        }
        return map;
    }

}
