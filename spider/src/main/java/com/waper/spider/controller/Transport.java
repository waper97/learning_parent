package com.waper.spider.controller;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName transport
 * @Description TODO
 * @Author wangpeng
 * @Date 2020/3/11 10:45
 */
public class Transport  {

    public static void main(String[] args) {
        Circle circle = new Circle();
        Bus bus = new Bus();
        // 向上转换类型
        Bus bus1 = new Circle();
        // 向下转换类型
        Circle circle1 = (Circle) bus;

        List list = new ArrayList();
        System.out.println(circle instanceof  Bus);
    }
}
