package com.waper.spider.model;

/**
 * @ClassName Singleton
 * @Description TODO
 * @Author wangpeng
 * @Date 2020/3/16 14:15
 */
public class Singleton {
    private static Singleton instance = new Singleton();

    public Singleton() {
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
    public static Singleton getInstance() {
        return instance;
    }

    public void test(){
        System.out.println("hello singleton!");
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

}
