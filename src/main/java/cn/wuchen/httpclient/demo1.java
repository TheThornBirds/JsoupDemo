package cn.wuchen.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by wuchen on 2017/9/11.
 */
public class demo1 {
    public static void main(String[] args) throws ClientProtocolException, IOException, URISyntaxException {
        //创建HTTPclient实例
        CloseableHttpClient httpClient = HttpClients.createDefault();

        URI uri = new URIBuilder()
                .setScheme("http") //设置scheme
                .setHost("download.csdn.net") //设置host
                .setPath("/search") //设置path
                .setParameter("q", "java开发") //设置参数
                .build();
        //创建get请求实例
        HttpGet get = new HttpGet(uri);

        CloseableHttpResponse response = httpClient.execute(get);
        HttpEntity entity = response.getEntity();
        System.out.println(EntityUtils.toString(entity,"UTF-8"));
        response.close();
    }

}
