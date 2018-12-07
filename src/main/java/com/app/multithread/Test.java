package com.app.multithread;

import java.util.concurrent.CountDownLatch;

/**
 * Created by admin on 2018/12/7.
 * 用给定的计数 初始化 CountDownLatch。由于调用了 countDown() 方法，
 * 所以在当前计数到达零之前，await 方法会一直受阻塞。之后，会释放所有等待的线程，
 * await 的所有后续调用都将立即返回。这种现象只出现一次——计数无法被重置。
 * 如果需要重置计数，请考虑使用 CyclicBarrier。
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
