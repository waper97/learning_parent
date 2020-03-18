package com.waper.spider.controller;

import com.waper.spider.model.Singleton;

/**
 * @ClassName SingletonTestController
 * @Description TODO
 * @Author wangpeng
 * @Date 2020/3/16 14:23
 */
public class SingletonTestController {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        singleton.test();
    }
}
