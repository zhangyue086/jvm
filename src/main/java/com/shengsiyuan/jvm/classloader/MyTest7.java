package com.shengsiyuan.jvm.classloader;


/**
 * Created by admin on 2018/11/7.
 */
public class MyTest7 {

    public static void main(String[] args) throws ClassNotFoundException {

        Class<?> clazz  = Class.forName("java.lang.String").getClass();
        System.out.println(clazz.getClassLoader());

        Class<?> clazz2  = Class.forName("com.shengsiyuan.jvm.classloader.C").getClass();
        System.out.println(clazz2.getClassLoader());
        System.out.println(clazz2.getClassLoader().getParent());

    }
}


class C{

}

