package cn.wuchen.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by wuchen on 2017/9/11.
 */
public class demo1 {
    public static void main(String[] args) throws IOException {
        //创建HTTPclient实例
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //创建get请求实例
        HttpGet get = new HttpGet("http://wclxy.com");

        CloseableHttpResponse response = httpClient.execute(get);
        HttpEntity entity = response.getEntity();
        System.out.println(EntityUtils.toString(entity,"UTF-8"));
        response.close();
    }
}
