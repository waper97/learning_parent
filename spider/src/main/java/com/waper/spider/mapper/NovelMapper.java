package com.waper.spider.mapper;

import com.waper.spider.model.Chapter;

import java.util.List;
import java.util.Map;

/**
 * @ClassName NovelMapper
 * @Description TODO
 * @Author wangpeng
 * @Date 2020/3/4 17:33
 */
public interface NovelMapper {
    List<Chapter> listNovels(Map<String,Object> paramMap);

    int saveNovel(Chapter chapter);
}
