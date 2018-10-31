package com.shengsiyuan.jvm.classloader;

import java.util.Random;

/**
 * Created by admin on 2018/10/30.
 *
 */
public class MyTest1 {

    public static void main(String[] args) {
        System.out.println(MyChild.a);
    }


   static class MyParent{
        public static int a = 9;
    }


    static class MyChild extends MyParent{

        public static int b =  2;

        public MyChild(){
            System.out.println("1");
        }
        static {
            System.out.println("2");
        }

    }



}
