package com.waper.spider.controller;

import com.waper.spider.model.Chapter;

import java.io.*;

/**
 * @ClassName SerializableTestController
 * @Description  序列化与反序列化测试
 * @Author wangpeng
 * @Date 2020/3/10 9:35
 */
public class SerializableTestController {
    public static void main(String[] args) throws Exception {
            Chapter chapter = deserializableNovel();
            System.out.println(chapter.toString());
    }

    private static  void serializableNovel () throws IOException {
        Chapter chapter = new Chapter();
        chapter.setNextUrl("www.baidu.com");
        chapter.setContent("天地洪荒");
        chapter.setChapterName("第一章");
        chapter.setUrl("www.zhizhiang.com");
        chapter.setBookName("fuck");

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("F:/novel.txt")));
        oos.writeObject(chapter);
        System.out.println("序列化成功!");
        oos.close();
    }

    public static Chapter deserializableNovel() throws Exception{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("F:/novel.txt")));
        Chapter chapter = (Chapter)ois.readObject();
        System.out.println("反序列化成功");
        return chapter;
    }
}
