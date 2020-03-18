package com.waper.spider.service.impl;

import com.waper.spider.mapper.NovelMapper;
import com.waper.spider.model.Chapter;
import com.waper.spider.service.NovelService;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName NovelServiceImpl
 * @Description TODO
 * @Author wangpeng
 * @Date 2020/3/3 17:58
 */
@Service
public class NovelServiceImpl implements NovelService {
    @Autowired
    private NovelMapper novelMapper;

    protected String crawl(String url){
        try {
            CloseableHttpClient httpClient = HttpClientBuilder.create().build();
            CloseableHttpResponse httpResponse = httpClient.execute(new HttpGet(url));
            String result = EntityUtils.toString(httpResponse.getEntity());
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return url;
    }


    @Override
    public List<Chapter> listNovels(Map<String, Object> paramMap) {
        return novelMapper.listNovels(paramMap);
    }

    @Override
    @Transactional
    public int insertNovel(Chapter chapter) {
        return novelMapper.saveNovel(chapter);
    }
}
