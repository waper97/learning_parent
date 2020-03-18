package com.waper.spider.controller;

import com.waper.spider.model.User;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName LombokTestContorller
 * @Description TODO
 * @Author wangpeng
 * @Date 2020/3/13 11:33
 */
@Slf4j
public class LombokTestContorller {
    public static void main(String[] args) {
        User user = User.builder().age(1)
//                .name("fuck")
                .sex(1)
                .build();
        log.error("lombok日志输入");
        System.out.println(user);
        testNull(null);
    }

    public static  void testNull(@NonNull User user){
        System.out.println(user.toString());
    }
}
