package com.waper.spider.controller;

/**
 * @ClassName ThreadTestController
 * @Description TODO
 * @Author wangpeng
 * @Date 2020/3/12 17:13
 */
public class ThreadTestController {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread thread = new Thread(myThread);
        thread.start();
    }


}
class MyThread extends Thread{
    @Override
    public void run() {
        super.run();
        System.out.println("hellow_world");
    }
}