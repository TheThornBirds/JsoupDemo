package cn.wuchen.ehcache;


import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 * Created by wuchen on 2017/9/21.
 */
public class EhcacheTest {
    public static void main(String[] args){
        //根据ehcache.xml配置文件创建cache管理器
        CacheManager manager = CacheManager.create("./src/main/resources/ehcache.xml");
        Cache c = manager.getCache("a");
        Element e = new Element("java1234","a");
        Element element = new Element("javalala", "c");
        c.put(e);
        c.put(element);

        Element e2 = c.get("java1234");
        Element e3 = c.get("javalala");
        System.out.println(e3);
        System.out.println(e3.getObjectValue());
        c.flush();
        manager.shutdown();
    }
}
