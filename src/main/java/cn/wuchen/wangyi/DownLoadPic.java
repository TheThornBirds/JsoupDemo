package cn.wuchen.wangyi;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class DownLoadPic {

    private static final String saveImgPath="E:\\imgs";
    //图片保存路径

    public void getDoc() throws IOException{
        //以网易为例子
        Document doc = Jsoup.connect("http://www.163.com/").get();
        //获取后缀为png和jpg的图片的元素集合
        Elements a = doc.getElementsByTag("img");
        //遍历元素
        for(Element e : a){
            String src=e.attr("src");//获取img中的src路径
            //获取后缀名
            String imageName = src.substring(src.lastIndexOf("/") + 1,src.length());
            //连接url
            URL url = new URL(src);
            URLConnection uri=url.openConnection();
            //获取数据流
            InputStream is=uri.getInputStream();
            //写入数据流
            OutputStream os = new FileOutputStream(new File(saveImgPath, imageName));
            byte[] buf = new byte[1024];
            int l=0;
            while((l=is.read(buf))!=-1){
                os.write(buf, 0, l);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new DownLoadPic().getDoc(); //调用方法
    }
}