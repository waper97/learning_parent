package com.example.design_patterns.model;

/**
 * @ClassName Duck
 * @Description TODO
 * @Author wangpeng
 * @Date 2020/3/23 14:17
 */
public abstract class Duck {
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public void  performFlay(){
        flyBehavior.fly();
    }

    public Duck(FlyBehavior flyBehavior, QuackBehavior quackBehavior) {
        this.flyBehavior = flyBehavior;
        this.quackBehavior = quackBehavior;
    }
}
