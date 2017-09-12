package cn.wuchen.httpclient.message;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.HttpVersion;
import org.apache.http.message.BasicHttpResponse;

/**
 * Created by wuchen on 2017/9/12.
 */
public class TestMessageHeaders {
    public static void main(String[] args){
        HttpResponse response = new BasicHttpResponse(HttpVersion.HTTP_1_1, HttpStatus.SC_OK,"OK");
        response.addHeader("Set-Cookie", "c1=a; path=/;domain=localhost" ); //添加消息头
        response.addHeader("Set-Cookie","c2=b; path=\"/\", c3=c; domain=\"localhost\""); // 添加消息头 设置cookie
        Header h1 = response.getFirstHeader("Set-Cookie"); //获得第一个消息头,指定key
        System.out.println(h1);

        Header h2 = response.getLastHeader("Set-Cookie"); //获得最后一个消息头,指定key
        System.out.println(h2);

        Header[] hs = response.getHeaders("Set-Cookie"); //获取所有消息头,指定key
        System.out.println(hs.length);

    }
}
