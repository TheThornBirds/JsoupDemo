package cn.wuchen.crawler;

import cn.wuchen.module.Article;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Date;

public class DzCrawler {
    //请求的url
    public static void main(String args[]) throws IOException {
        for (int i=0;i<100;i++){
            try{
                String url="http://www.waduanzi.com/page/"+i;
                Document document=Jsoup.connect(url).get();
                //拿到段子div块
                Elements elements=document.select("div[class=panel panel20 post-item post-box]>div[class=item-detail]");
                for(Element element:elements){
                    Article article=new Article();
                    String title=element.select("div[class=item-title]").text();
                    String content=element.select("div[class=item-content]").html();
                    article.setTitle(title);
                    article.setType("waduanzi");
                    article.setContent(content);
                    article.setDate(new Date());
                    System.out.println(article.getTitle()+":"+article.getContent());
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
