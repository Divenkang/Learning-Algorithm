package sort.QuickSort;

import java.util.*;

public class QuickSort {
    private QuickSort(){}

    //对arr[1,..,r]部分进行partition操作,其中P为主元
    //返回p，使得arr[1,..,p-1]<arr[p]; arr[p+1,..,r]>arr[p]
    private static <T extends Comparable<T>> int partition(T[]arr, int l, int r){
        T v = arr[l];//设置主元
        int j = l; // arr[l+1...j] < v ; arr[j+1...i) > v
//        System.out.println(j);
        for(int i = l + 1 ; i <= r ; i ++ )
            if(arr[i].compareTo(v)<0){
                j++;
//                System.out.println(j);
                swap(arr,j,i);
            }
        swap(arr, l, j);
        return j;
    }

    // 递归使用快速排序,对arr[l...r]的范围进行排序
    private static<T extends Comparable<T>> void sort(T[]arr,int l, int r){
        if(l>=r)
            return;

        int p = partition(arr,l,r);
        sort(arr,l,p-1);
        sort(arr,p+1,r);
    }

    private static<T extends Comparable<T>> void sort(T[]arr){
        int n = arr.length;
        sort(arr,0,n-1);
    }



    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;

    }

    public static void main(String[] args){
        Integer[] a ={5,1,4,7};
        sort(a);
        for(int i =0;i<a.length;i++)
            System.out.println(a[i]);
    }
}