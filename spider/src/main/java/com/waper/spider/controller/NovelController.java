package com.waper.spider.controller;

import com.waper.spider.model.BaseResponseInfo;
import com.waper.spider.model.Chapter;
import com.waper.spider.service.NovelService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName NovelController
 * @Description TODO
 * @Author wangpeng
 * @Date 2020/3/4 16:47
 */
@RestController
public class NovelController  extends  BaseController implements Runnable{

    @Autowired
    private NovelService novelService;

    @Override
    public void run() {

    }
    /**
     * @Author wangpeng
     * @Description 全书网的小说(免费的) ,遇到单位时间内限制访问次数，次数过多直接访问不了;jsoup 应用于静态页面，动态页面就不可以了
     * @Date 15:47 2020/3/6
     * @Param [url, name]
     * @return java.lang.Object
    **/

    @RequestMapping("getNovelByUrl")
    public synchronized Object getNovelByUrl(String url,String name) throws IOException {
        if (url == null || "".equals(url)) {
            return new BaseResponseInfo("小说链接不能为空",false);
        }
        if (name == null || "".equals(name)) {
            return new BaseResponseInfo("小说名称不能为空",false);
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("F://"+name+".txt")));
        // 起点文学
        Document doc  = Jsoup.connect(url)
            // 伪装浏览器
            .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.117 Safari/537.36")
            .get();
        while(doc != null) {
            // 获取书名
            String bookName = doc.select("div[class=bookInfo]").select("em").text();
            // 章节名称
            String chapterName = doc.select("strong[class=l jieqi_title]").text();
            // 向文件中写入章节名称
            bw.write(chapterName);
            bw.newLine();
            bw.flush();

            // 像文件写入文章内容
            String content = doc.getElementById("content")
                    .toString()
                    .replaceAll("</?[^>]+>|&nbsp;|style","");
                // 写入并替换<p></p>标签
                bw.write(content);
                bw.newLine();
                bw.flush();

            // 获取下一章的元素
            String nexturl = doc.getElementsByClass("next").attr("href");
            if (nexturl == null) {
                break;
            }
            // 获取下一章内容
            doc = Jsoup.connect(nexturl)
                    .timeout(60000)
                    .get();
        }
        return new BaseResponseInfo("保存成功",true);
    }

    @GetMapping("getNovel")
    public Object getNovel(){
         List<Chapter> list = novelService.listNovels(new HashMap<>(16));
        return list;
    }


    /**大小写转换**/
    public static String toLowerCase(String str) {
      int len = str.length();
      StringBuffer sb = new StringBuffer();
      for (int i = 0; i < len; i++) {
          // 得到具体的字母
          char tem = str.charAt(i);
          // 转大写 一个字母大写与小写的ASCLL相差32
          sb.append(tem >= 'A' && tem <= 'Z' ?(char)(tem+32):(char)(tem-32));
      }
        System.out.println(sb.toString());
      return sb.toString();
    }


    public static void main(String[] args) throws IOException {

        // 链接地址
        // 解析页面
        // 得到内容
        // 输出内容

       Document document =  Jsoup.connect("http://www.quanshuwang.com/book/0/329/97410.html")
            .userAgent("Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.117 Mobile Safari/537.36")
            .get();
        // 小说名称
//        while (true) {
            String novelName = document.select("div[class=bookInfo]").select("em").text();
            // 章节名称
            String chapterName = document.select("strong[class=l jieqi_title]").text();
            // 小说内容
            String content = document.getElementById("content")
                    .toString()
                    .replaceAll("</?[^>]+>|&nbsp;|style","");
            // 下一章链接
            String nextChapterUrl = document.getElementsByClass("next").attr("href");
            System.out.println(chapterName);

//        }
    }


}
