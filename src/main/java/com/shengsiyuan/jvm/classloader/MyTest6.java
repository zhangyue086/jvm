package com.shengsiyuan.jvm.classloader;

import java.util.Random;

/**
 * Created by admin on 2018/10/30.
 */
public class MyTest6 {

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        System.out.println("counter1:"+Singleton.counter1);
        System.out.println("counter2:"+Singleton.counter2);
    }

    static class Singleton{
        public static int counter1 = 1;
//        public static int counter2 = 0;

        private static Singleton singleton = new Singleton();

        private Singleton(){
            counter1++;
            counter2++;
            System.out.println(counter1);
            System.out.println(counter2);
        }
        public static int counter2 = 7;


        public static  Singleton getInstance(){
            return singleton;
        }
    }

    /**
     *     （从上到下真正的初始化）
     （最开始准备阶段，给静态变量赋默认值（构造方法不被执行）。 准备阶段完成之后，开始从上到下执行，进行真正的初始化。）

     26行代码显示赋值 为0，覆盖掉了在 构造方法中的1的值。
     */

}
