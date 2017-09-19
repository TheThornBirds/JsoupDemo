package cn.wuchen.picture;

import cn.wuchen.Selector;
import jdk.internal.util.xml.impl.Input;
import org.apache.commons.io.FileUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by wuchen on 2017/9/15.
 */
public class Deviantart {

    public static String getHtml(String url) throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet get = new HttpGet(url);
        get.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.113 Safari/537.36");
        CloseableHttpResponse response = httpClient.execute(get);
        HttpEntity entity = response.getEntity();
        String content = EntityUtils.toString(entity);
        response.close();
        return content;
    }

    public static void main(String[] args) throws Exception {
        String content = Deviantart.getHtml("https://t13.deviantart.net/3G8sLNurWUuU94O9BQ0rZQqW3gA=/fit-in/300x900/filters:no_upscale():origin()/pre00/4c6c/th/pre/f/2017/257/4/1/supergirl_and_streaky_by_artgerm-dbndewr.jpg");
        Document document = Jsoup.parse(content);
        Elements elements = document.select("img[src$=.jpg]");
        for (Element element : elements){
            saveFile(element.attr("src"));
        }
    }

    public static void saveFile(String srcUrl) throws Exception {
//        FileOutputStream os = null;
//        BufferedInputStream bs = null;
//        HttpURLConnection httpUrl = null;
//        URL url = null;
//        byte[] buf = new byte[1024];
//        int size = 0;
//
//        url = new URL(srcUrl);

    }
}
