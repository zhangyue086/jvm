package com.app.multithread;

/**
 * Created by admin on 2018/12/7.
 */
public class SeqCount {

    private static ThreadLocal<Integer> seqCount3 = new ThreadLocal<Integer>(){
        //实现initalValue方法
        public Integer initValue(){
            return 0;
        }
    };

    public int nextSeq(){
        seqCount3.set(seqCount3.get()+1);
        return seqCount3.get();
    }


    public static void main(String[] args) {
        SeqCount seqCount1 = new SeqCount();

        SeqThread thread1 = new SeqThread(seqCount1);
//        SeqThread thread2 = new SeqThread(seqCount);
//        SeqThread thread3 = new SeqThread(seqCount);
//        SeqThread thread4 = new SeqThread(seqCount);
        thread1.start();
//        thread2.start();
//        thread3.start();
//        thread4.start();

    }



    private static class SeqThread extends Thread{

        private SeqCount seqCount2;

        SeqThread(SeqCount seqCount){
            this.seqCount2 = seqCount;
        }

        public void run(){
            for(int i = 0;i<3;i++){
                System.out.println(Thread.currentThread().getName()+" seqCount:"+seqCount2.nextSeq());
            }
        }

    }




}
