package JSOUP;

import org.jsoup.Jsoup;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class JsoupCustom {
    public static void main(String[] args) throws IOException {
        Jsoup.connect("https://www.google.com.au/search?q=Boat").get()
                .select("h3").select("a")
                .stream()
                .limit(5)
                .map(l -> l.attr("href"))
                .forEach(System.out::println);
        System.out.println(Jsoup.connect("https://www.google.com.au/search?q=Boat").get()
                .select("h3").select("a")
                .stream()
                .limit(5)
                .map(l -> l.attr("href")));
//        getURL("плов");
        }

    public static void getURL(String dish) throws IOException {

//        try{
//            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
//                Desktop.getDesktop().browse(new URI("https://www.google.com/search?q="+dish));
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } catch (URISyntaxException e) {
//            throw new RuntimeException(e);
//        }
//
//        Jsoup.connect("https://www.google.com/search?q=рецепт+блюда+" + URLEncoder.encode(dish, "UTF-8")).get()
//                .select("h3").select("a")
//                .stream()
//                .limit(1)
//                .map(l -> l.attr("href"))
//                .forEach(System.out::println);


//            Jsoup.connect("https://www.google.com/search?q=rdher"/* + URLEncoder.encode(dish, StandardCharsets.UTF_8)*/).get()
//                .select("h3").select("a")
//                .stream()
//                .limit(10)
//                .map(l -> l.attr("href"))
//                .forEach(System.out::println);
    }
}

