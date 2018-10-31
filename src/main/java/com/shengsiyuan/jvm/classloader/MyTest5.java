package com.shengsiyuan.jvm.classloader;

import com.sun.xml.internal.bind.v2.runtime.output.SAXOutput;

import java.util.Random;
import java.util.function.IntBinaryOperator;

/**
 * Created by admin on 2018/10/30.
 *  当一个接口在初始化时，并不要求其父接口都完成了初始化
 *
 *  只有在正确使用到父接口的时候（如引用接口中所定义的常量时，才会初始化）
 */
public class MyTest5 {

    public static void main(String[] args) {
        //主动使用子类  会初始化父类
//        System.out.println(MyChild5.b);

        System.out.println(MyParent5_1.thread);


    }



    static class MyGrandpa{
        public static int a = 6;

        public static Thread thread  = new Thread(){
            //实例化块
            {
                System.out.println("MyGrandpa invoked");
            }

        };
    }

     static class MyParent5 extends MyGrandpa{
        public static int a = 6;

        public static Thread thread  = new Thread(){
            //实例化块
            {
                System.out.println("MyParent5 invoked");
            }

        };
    }


     static class MyChild5 extends MyParent5{

        public static int b =  5;
    }



    interface  MyGRandpa5_1{
        public static Thread thread  = new Thread(){
            //实例化块
            {
                System.out.println("MyGRandpa5_1 invoked");
            }
        };
    }

    interface   MyParent5_1 extends MyGRandpa5_1 {
        public static Thread thread  = new Thread(){
            //实例化块
            {
                System.out.println("MyParent5_1 invoked");
            }
        };
    }








}
