package com.app.multithread;

import java.util.concurrent.*;

/**
 * Created by admin on 2018/12/7.
 */
public class ThreadPoolExecutorTest {

    public static void main(String[] args) {

//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
//                2, 2, 0, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(2),
//                new ThreadPoolExecutor.CallerRunsPolicy());
//

        ExecutorService executorService = Executors.newCachedThreadPool();


        executorService.execute(new PersonThread());
        executorService.execute(new PersonThread());
        executorService.execute(new PersonThread());
        executorService.execute(new PersonThread());

        executorService.execute(new PersonThread());
        executorService.execute(new PersonThread());
        executorService.execute(new PersonThread());

//        executorService.shutdown();
        executorService.shutdownNow();

    }

    static class PersonThread extends Thread{
        @Override
        public void run() {
            System.out.println("PersonThread 执行了:"+Thread.currentThread().getName());
        }
    }




}
