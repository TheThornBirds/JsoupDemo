package cn.wuchen.blog;

import cn.wuchen.Selector;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by wuchen on 2017/9/8.
 */
public class Blog {
    public static void main(String[] args){
        getTxt();
    }

    public static void getTxt(){
        Document doc = null;
        try {
            doc = Jsoup.connect("http://wclxy.com/").get();
            Elements elements = doc.getElementsByAttributeValue("class", "post-title-link");
            Selector.forFoo2(elements);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
