package cn.wuchen.crawler;

import cn.wuchen.module.Article;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Date;

/**
 * Created by wuchen on 2017/9/1.
 */
public class WaDuanZi {

    public static void main(String[] args){
        for (int i = 0; i < 10; i++) {

            String url = "http://www.waduanzi.com/page/"+i;

            try {
                Document doc = Jsoup.connect(url).timeout(500000000).get();
                Elements elements = doc.getElementsByAttributeValue("class", "item-detail");

                for (Element e:elements) {
                    Article article = new Article();
                    String title = e.select("h2[class=item-title]").text();
                    String content = e.select("div[class=item-content]").text();
                    if (title.length()==0){
                        continue;
                    }
                    article.setTitle(title);
                    article.setContent(content);
                    article.setDate(new Date());
                    article.setType("waduanzi");
                    System.out.println(article.getTitle()+":  "+article.getContent());
                }
//                System.out.println(elements.size());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
