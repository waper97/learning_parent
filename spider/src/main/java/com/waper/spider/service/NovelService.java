package com.waper.spider.service;

import com.waper.spider.model.Chapter;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @ClassName NovelService
 * @Description TODO
 * @Author wangpeng
 * @Date 2020/3/3 17:56
 */
public interface NovelService {

     List<Chapter> listNovels(Map<String,Object> paramMap);

     /**
      * @Author wangpeng
      * @Description  添加小说
      * @Date 18:02 2020/3/4
      * @Param [chapter]
      * @return int
     **/

     int insertNovel(Chapter chapter);
}
