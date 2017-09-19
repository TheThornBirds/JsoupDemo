package cn.wuchen;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.regex.Pattern;

/**
 * Created by wuchen on 2017/8/30.
 */
public class Selector {


    public static void forFoo(Elements e){
        for (Element element : e) {
            System.out.println(element);
        }
    }

    public static void forFoo2(Elements e){
        for (Element element : e){
            System.out.println(element.text());
        }
    }

    public static void main(String[] args){
        Document doc;
        try {
            //获取文档
            doc = Jsoup.connect("http://www.tuicool.com/").get();

            //获取单一元素
            //根据ID选择的选择器<div id="content"></div>
            Element content = doc.getElementById("header");
//            System.out.println(content);

            /******以下返回值都是Elements集合*******/

            //获取所有的a标签<a href="#"></a>
            Elements a = content.getElementsByTag("a");
//            Selector.forFoo(a);

            //获取所有符合条件的类选择器<div class=post-body></div>
            Elements divClass = doc.getElementsByClass("post-body");
//            Selector.forFoo(divClass);

            //获取所有元素
            Elements allElements = doc.getAllElements();
            Selector.forFoo(allElements);

            //根据属性获取元素<div class=...> <span class=...>
            Elements attribute = doc.getElementsByAttribute("href");
//            Selector.forFoo(attribute);

            //根据属性前缀获取元素
            Elements elementsByAttributeStarting = doc.getElementsByAttributeStarting("cl");
//            Selector.forFoo(elementsByAttributeStarting);

            //根据Key value选择 如<a href="https://hexo.io"> 对应
            Elements keyValue = doc.getElementsByAttributeValue("href", "https://hexo.io");
//            Selector.forFoo(keyValue);

            //选择不与这项匹配的 否定
            Elements valueNot = doc.getElementsByAttributeValueNot("href", "https://hexo.io");
//            Selector.forFoo(valueNot);

            //根据key-value,value可能是key对面属性的一个子字符串 包含
            Elements contain = doc.getElementsByAttributeValueContaining("href", "hexo");
//            Selector.forFoo(contain);

            //根据key value ,key对应值的结尾是value 结尾
            Elements ending = doc.getElementsByAttributeValueEnding("href", "io");
//            Selector.forFoo(ending);

            //根据key value , key对应值的开头是value开头
            Elements starting = doc.getElementsByAttributeValueStarting("href", "https");
//            Selector.forFoo(starting);

            //正则匹配 ,value需要满足正则表达式
            Elements re = doc.getElementsByAttributeValueMatching("title", Pattern.compile("[\\u4e00-\\u9fa5]"));
//            Selector.forFoo(re);

            //遍历标签
            for (Element link : content.getElementsByTag("a")) {
                String linkHref = link.attr("href");
//                System.out.println(linkHref);
                String linkText = link.text();
//                System.out.println(linkText);
            }

            /***********其他常用方法*************/
            //获取网页标题
            String title = doc.title();
//            System.out.println(title);

            //获取页面的所有文本
            String text = doc.text();
//            System.out.println(text);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
