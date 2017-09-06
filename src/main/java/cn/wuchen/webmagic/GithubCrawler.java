package cn.wuchen.webmagic;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.processor.example.GithubRepoPageProcessor;

public class GithubCrawler implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

    public void process(Page page) {
        page.addTargetRequests(page.getHtml().links().regex("(http://wclxy\\.com/\\w+/\\w+)").all());
        page.putField("author", page.getUrl().regex("http://wclxy\\.com/(\\w+)/.*").toString());
        page.putField("name", page.getHtml().xpath("//h1[@class='post-header']/a/text()").toString());
        if (page.getResultItems().get("name")==null){
            //skip this page
        }
        page.setSkip(true);
//        page.putField("readme", page.getHtml().xpath("//div[@id='readme']/tidyText()"));
    }

    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new GithubRepoPageProcessor()).addUrl("http://wclxy.com").thread(5).run();
    }
}