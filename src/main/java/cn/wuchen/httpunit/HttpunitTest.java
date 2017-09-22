package cn.wuchen.httpunit;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;

import javax.sound.midi.Soundbank;
import java.io.IOException;

/**
 * Created by wuchen on 2017/9/22.
 */
public class HttpunitTest {
    public static void main(String[] args) throws Exception {
        WebClient client = new WebClient(BrowserVersion.CHROME);
//        client.getOptions().setCssEnabled(false);
//        client.getOptions().setJavaScriptEnabled(false);
        HtmlPage page = client.getPage("http://blog.java1234.com/index.html"); //解析获取页面
//        System.out.println(page.asXml());
        System.out.println(page.asText());

        System.out.println("================================================================");
        DomNodeList<DomElement> aList = page.getElementsByTagName("a");
        for (DomElement a : aList){
            System.out.println(a);
        }

        System.out.println("=================================================================");

//        HtmlListItem item = (HtmlListItem) page.getByXPath("//div[@id='navMenu'][1]/ul/li").get(0);
//        System.out.println(item.asText());

        System.out.println("============================================");
        HtmlForm form = page.getFormByName("myform"); //得到form
        HtmlTextInput textFiled = form.getInputByName("q"); //获取查询文本框
        HtmlSubmitInput button = form.getInputByName("submitButton"); //获取提交按钮
        textFiled.setValueAttribute("java");
        HtmlPage page2 = button.click(); //模拟点击

        System.out.println(page2.asXml());

        client.close();
    }
}
