package cn.wuchen.commansIO;

import jdk.internal.util.xml.impl.Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by wuchen on 2017/9/15.
 */
public class IOUtilsTest {
    public static void main(String[] args) throws Exception {
        InputStream in = new URL("https://t13.deviantart.net/3G8sLNurWUuU94O9BQ0rZQqW3gA=/fit-in/300x900/filters:no_upscale():origin()/pre00/4c6c/th/pre/f/2017/257/4/1/supergirl_and_streaky_by_artgerm-dbndewr.jpg").openStream();
        InputStreamReader inR = new InputStreamReader(in);
        BufferedReader buf = new BufferedReader(inR);
        String line;
        while ((line = buf.readLine())!=null){
            System.out.println(line);
        }
    }

}
