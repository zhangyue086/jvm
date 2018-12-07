package com.app.multithread;

import java.util.Arrays;

/**
 * Created by admin on 2018/12/7.
 */
public class Test2 {


    public static void main(String[] args) {
        int[] aa = {1,5,4,2,10,6};
        bSort(aa);


    }


    public static void bSort(int [] arr){
        for(int i =0;i<arr.length-1;i++){
            //里面的循环比外面的少一个
            boolean flag = true;

            for(int j=0; j <arr.length-1; j++){
                if(arr[j]>arr[j+1]){
                    flag = false;
                    int temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
            if(flag){
                break;
            }

        }
        System.out.println(Arrays.toString(arr));


    }


}
