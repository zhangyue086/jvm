package com.app.multithread;

import java.util.concurrent.CountDownLatch;

/**
 * Created by admin on 2018/12/7.
 */
public class Test {
    private static CountDownLatch countDownLatch = new CountDownLatch(5);


    /**
     * Boss线程，等待员工到达开会
     */
    static class BossThread extends Thread{
        @Override
        public void run() {
            System.out.println("Boss在会议室等待："+countDownLatch.getCount()+"个人开会");
            try{
                countDownLatch.await();


            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("所有人都已经到齐了，开会吧...");
        }
    }


    //员工到达会议室
    static class EmpleoyeeThread  extends Thread{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "，到达会议室....");
            //员工到达会议室 count - 1
            countDownLatch.countDown();
        }
    }


    public static void main(String[] args) {
        System.out.println("总线程数："+countDownLatch.getCount());

        //Boss线程启动
        new BossThread().start();

        long max = countDownLatch.getCount();
        for(int i = 0;i<max;i++){
            new EmpleoyeeThread().start();
        }

        //Boss线程会等待 其他一组线程执行结束之后，再执行。

    }




}
