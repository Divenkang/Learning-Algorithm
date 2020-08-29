package sort.ShellSort;

import sort.base_sort.SelectionSort;

public class ShellSort {
    private ShellSort(){}

    public static <T extends Comparable<T>> void sort(T[] arr){
        int n = arr.length;
        //computer omcre,emt seqiemce:1,4,13,40,121,364,1093,...
        int h = 1;
        while (h<n/3)h = 3*h+1;
        while(h>=1){
            //h-sort the array
            for (int i = h;i<n;i++){

                // 对 arr[i], arr[i-h], arr[i-2*h], arr[i-3*h]... 使用插入排序
                T e = arr[i];
                int j = i;
                for ( ; j >= h && e.compareTo(arr[j-h]) < 0 ; j -= h)
                    arr[j] = arr[j-h];
                arr[j] = e;

            }
        }
    }
    public static void main(String[] args){
        Integer[] arr = {10,9,8,5,1,12};
        ShellSort.sort(arr);
        for(int i = 0;i< arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
