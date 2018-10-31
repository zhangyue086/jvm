package com.shengsiyuan.jvm.classloader;

import java.util.Random;

/**
 * Created by admin on 2018/10/30.
 *  当一个接口在初始化时，并不要求其父接口都完成了初始化
 *
 *  只有在正确使用到父接口的时候（如引用接口中所定义的常量时，才会初始化）
 */
public class MyTest5 {

    public static void main(String[] args) {
        System.out.println(MyChild5.b);
    }


    interface MyParent5{
        public static int a = 6;
    }


    static class MyChild5 implements MyParent5{

        public static int b =  5;
    }



}
