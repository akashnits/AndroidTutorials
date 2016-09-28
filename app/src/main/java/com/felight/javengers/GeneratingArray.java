package com.felight.javengers;

import android.os.SystemClock;
import android.view.View;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.Random;

/**
 * Created by akash.raj on 6/19/2016.
 */
public class GeneratingArray {
    private static int[] array;

    public static void averageCaseArray(int size) {
        Random r = new Random();
        array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = r.nextInt(50);
        }

    }

    public static void bestCaseArray(int size) {
        array = new int[size];
        Random r = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = r.nextInt(10);
        }
    }

    public static void worstCaseArray(int size) {
        array = new int[size];
        Random r = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = r.nextInt(1000);
        }
    }


    public static long bSort() {
        long start = System.currentTimeMillis();
        int a;
        int size = array.length;
        int[] duplicate = array.clone();
        int swapCounter = -1;

        for (int i = 0; i < size-1; i++) {
            if (swapCounter != 0) {
                for (int j = 0; j < size-1 - i; j++) {
                    if (duplicate[j + 1] < duplicate[j]) {
                        a = duplicate[j + 1] + duplicate[j];
                        duplicate[j + 1] = a - duplicate[j + 1];
                        duplicate[j] = a - duplicate[j + 1];
                        swapCounter++;
                    }
                }
            }
        }
        long end = System.currentTimeMillis();
        long duration = end - start;
        return duration;
    }

    public static long sSort() {
        int[] duplicate = array.clone();
        int size = array.length;
        long start = System.currentTimeMillis();
        for (int i = 0; i < size-1; i++) {

            int m = 0;
            int min = Integer.MAX_VALUE;
            for (int j = i; j < size-1; j++) {
                if (min > duplicate[j]) {
                    min = duplicate[j];
                    m = j;
                }
            }
            duplicate[m] = duplicate[i];
            duplicate[i] = min;
        }
        long end = System.currentTimeMillis();
        long duration = end - start;
        return duration;
    }
    public static long iSort() {
        int[] duplicate = array.clone();
        int size = array.length;
        long start = System.currentTimeMillis();
        int sorted =1;
        for(int i=0; i<size;i++)
        {
            int counter=i;
            int pick = duplicate[i];
            for(int j=sorted;j >0; j--)
            {
                if(pick < duplicate[j-1])
                {
                    duplicate[j]=duplicate[j-1];
                    counter--;
                }
            }
            duplicate[counter]=pick;
            sorted++;

        }
        long end = System.currentTimeMillis();
        long duration = end - start;
        return duration;
    }

    public static long mSort() {
        int[] duplicate = array.clone();
        int size = array.length;
        long start = System.currentTimeMillis();

        part(duplicate,0,size-1);
        long end = System.currentTimeMillis();
        long duration = end - start;
        return duration;
    }


    public static void part(int arr[],int min,int max)
    {
        int mid;
        if(min<max)
        {
            mid=(min+max)/2;
            part(arr,min,mid);
            part(arr,mid+1,max);
            merge(arr,min,mid,max);
        }
    }


    public static void merge(int arr[],int min,int mid,int max)
    {
        int[] tmp = new int[array.length];
        int i,j,k,m;
        j=min;
        m=mid+1;
        for(i=min; j<=mid && m<=max ; i++)
        {
            if(arr[j]<=arr[m])
            {
                tmp[i]=arr[j];
                j++;
            }
            else
            {
                tmp[i]=arr[m];
                m++;
            }
        }
        if(j>mid)
        {
            for(k=m; k<=max; k++)
            {
                tmp[i]=arr[k];
                i++;
            }
        }
        else
        {
            for(k=j; k<=mid; k++)
            {
                tmp[i]=arr[k];
                i++;
            }

        }

    }
}
