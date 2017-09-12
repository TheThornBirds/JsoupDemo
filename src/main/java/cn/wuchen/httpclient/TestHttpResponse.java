package cn.wuchen.httpclient;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.HttpVersion;
import org.apache.http.message.BasicHttpResponse;

/**
 * Created by wuchen on 2017/9/12.
 */
public class TestHttpResponse {
    public static void main(String[] args){
        HttpResponse response = new BasicHttpResponse(HttpVersion.HTTP_1_1, HttpStatus.SC_OK,"OK");
        System.out.println(response.getProtocolVersion()); //协议
        System.out.println(response.getStatusLine().getStatusCode()); //状态码
        System.out.println(response.getStatusLine().getReasonPhrase()); //表达含义
        System.out.println(response.getStatusLine().toString());

    }
}
