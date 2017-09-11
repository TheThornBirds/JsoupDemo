package cn.wuchen.picture;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by wuchen on 2017/9/6.
 */
public class GetPicture {

    private static int count = 0;

    public void saveToFile(String destUrl) {
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        HttpURLConnection httpUrl = null;
        URL url = null;
        byte[] buf = new byte[1024];
        int size = 0;

        try {
            url = new URL(destUrl);
                httpUrl = (HttpURLConnection) url.openConnection();
                httpUrl.connect();
                bis = new BufferedInputStream(httpUrl.getInputStream());
                String imgName = destUrl.substring(7, destUrl.lastIndexOf("."));
                File dir = new File("E:\\img");
                if (!dir.exists()) {
                    dir.mkdirs();
                }

                File file = new File("E:\\img\\+count+.swf");
                fos = new FileOutputStream(file);
                while ((size = bis.read(buf)) != -1) {
                    fos.write(buf, 0, size);
                }
                fos.flush();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                count++;
                if (fos != null && bis != null && httpUrl != null) {
                    try {
                        fos.close();
                        bis.close();
                        httpUrl.disconnect();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
            }
        }
    }

    private void getHtmlElements(String url) {
        try {
            Document doc = Jsoup.connect(url).get();

            //获取后缀名为JPG的IMG元素
            Elements pngs = doc.select("embed[src$=.swf]");

            for (Element element : pngs) {

                String ele =  element.attr("src");
                System.out.println(ele);
                saveToFile(element.attr("src"));
            }
//            System.out.println(pngs);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        GetPicture pic = new GetPicture();
        pic.getHtmlElements("http://www.java1234.com/a/yuanchuang/jsoup/2017/0211/7539.html");
    }

}