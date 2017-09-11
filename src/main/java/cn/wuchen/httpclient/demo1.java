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

//        public static void main(String[] args) throws ClientProtocolException, IOException, URISyntaxException {
//            CloseableHttpClient httpclient = HttpClients.createDefault(); // 创建httpclient实例
//            URI uri = new URIBuilder()
//                    .setScheme("http")  // 设置scheme
//                    .setHost("download.csdn.net") // 设置host
//                    .setPath("/search")  // 设置path
//                    .setParameter("q", "java开发")  // 设置参数
//                    .build();
//            HttpGet httpget=new HttpGet(uri);
//            CloseableHttpResponse response = httpclient.execute(httpget); // 执行get请求
//            HttpEntity entity=response.getEntity(); // 获取返回实体
//            System.out.println("网页内容："+EntityUtils.toString(entity, "utf-8")); // 指定编码打印网页内容
//            response.close(); // 关闭流和释放系统资源
//        }
}
