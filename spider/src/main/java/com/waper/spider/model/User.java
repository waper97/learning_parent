package com.waper.spider.model;

import lombok.*;

/**
 * @ClassName User
 * @Description TODO
 * @Author wangpeng
 * @Date 2020/3/13 11:34
 */
@Data
@Builder
public class User {

    private String name;
    private int age;
    private int sex;

}
