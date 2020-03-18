package com.waper.spider;

import com.waper.spider.service.NovelService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class SpiderApplicationTests  implements  Runnable{
    @Autowired
    private NovelService novelService;

    @Test
    void contextLoads() throws IOException {

    }

    @Test
    void getContentByUrl() throws IOException {
        // 起点文学
        Document doc  = Jsoup.connect("https://read.qidian.com/chapter/pdA9qnJ0hrA1/VwaCbXqBxD9p4rPq4Fd4KQ2")
//        Document doc  = Jsoup.connect("https://read.qidian.com/chapter/1209977/23724364")
             // 伪装浏览器
            .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.117 Safari/537.36")
            .get();
        // 获取标题
        String title = doc.title();
        int i = 1;
        while(true) {
            // 获取书名
            String bookName = doc.getElementsByClass("book-cover-wrap").select("h1").text();
            // 章节名称
            String chapterName = doc.select("h3[class=j_chapterName]").text();
            // 内容
            String content = doc.select("div[class=read-content j_readContent]").select("p").toString();
            String vipChapter = doc.select("div[class=vip-limit-wrap]").text();

            // 获取下一章的元素
            Element element = doc.getElementById("j_chapterNext");
            // 下一章的链接
            String nexturl = "https:"+element.attr("href");
            // 替换<p></p>标签
            String s = content.replaceAll("<\\/?p>","");

            // 判断vip章节
            Elements vip = doc.getElementsByClass("vip-limit-wrap");
            doc = Jsoup.connect(nexturl).get();
            System.out.println("书名:"+bookName);
            System.out.println("章节名:"+chapterName);
//            System.out.println("内容:"+s);
            System.out.println("下一章:"+nexturl);
            if (!"".equals(vipChapter)) {
                System.out.println(vipChapter);
                break;
            }

        }

    }

    @Override
    public void run() {

    }
}
