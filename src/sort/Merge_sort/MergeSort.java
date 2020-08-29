package sort.Merge_sort;

import sort.SortTestHelper;
import java.util.*;
public class MergeSort {

    private MergeSort(){}

    //将arr[1,..,mid]和arr[mid+1,..,r]两部分进行归并
    private static <T extends Comparable<T>> void merge(T[] arr,int l, int mid, int r){
//      将一个原始的数组original，从下标from开始复制，复制到上标to，生成一个新的数组。
        T[] aux = Arrays.copyOfRange(arr,l,r+1);
        // 初始化，i指向左半部分的起始索引位置l；j指向右半部分起始索引位置mid+1
        int i = l,j = mid+1;
        for(int k = l;k<=r;k++){
            if(i>mid){  // 如果左半部分元素已经全部处理完毕
                arr[k] = aux[j-l];j++;
            }
            else if( j > r ){   // 如果右半部分元素已经全部处理完毕
                arr[k] = aux[i-l]; i ++;
            }
            else if( aux[i-l].compareTo(aux[j-l]) < 0 ){  // 左半部分所指元素 < 右半部分所指元素
                arr[k] = aux[i-l]; i ++;
            }
            else{  // 左半部分所指元素 >= 右半部分所指元素
                arr[k] = aux[j-l]; j ++;
            }
        }
    }

    // 递归使用归并排序,对arr[l...r]的范围进行排序
    private static <T extends Comparable<T>> void sort(T[] arr, int l, int r) {

        if (l >= r)
            return;

        int mid = (l+r)/2;
        sort(arr, l, mid);

        sort(arr, mid + 1, r);

        merge(arr, l, mid, r);
    }

    public static <T extends Comparable<T>>  void sort(T[] arr){

        int n = arr.length;
        sort(arr, 0, n-1);
    }

    // 测试MergeSort
    public static void main(String[] args) {

        // Merge Sort是我们学习的第一个O(nlogn)复杂度的算法
        // 可以在1秒之内轻松处理100万数量级的数据
        // 注意：不要轻易尝试使用SelectionSort, InsertionSort或者BubbleSort处理100万级的数据
        // 否则，你就见识了O(n^2)的算法和O(nlogn)算法的本质差异：）
//        int N = 1000000;
//        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
//        SortTestHelper.testSort("sort.Merge_sort.MergeSort", arr);
//
//        return;
        Integer[] arr = {5,7,1,6,8,4};
        sort(arr);
    }
}
