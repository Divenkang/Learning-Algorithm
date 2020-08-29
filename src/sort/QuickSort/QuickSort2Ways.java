package sort.QuickSort;
//当我们排序的是一个近乎有序的序列时，快速排序会退化到一个O(n^2)级别的排序算法，
// 而对此的改进就是引入了随机化快速排序算法；但是当我们排序的是一个数值重复率非常高的序列时，
// 此时随机化快速排序算法就不再起作用了，而将会再次退化为一个O(n^2)级别的排序算法
import sort.Insert_sort.InsertionSort;
import java.util.*;

public class QuickSort2Ways {
    private QuickSort2Ways(){}

    // 双路快速排序的partition
    // 返回p, 使得arr[l...p-1] <= arr[p] ; arr[p+1...r] >= arr[p]
    // 双路快排处理的元素正好等于arr[p]的时候要注意，详见下面的注释：）
    private static int partition(Comparable[] arr, int l, int r){

        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        swap( arr, l , (int)(Math.random()*(r-l+1))+l );

        Comparable v = arr[l];

        // arr[l+1...i) <= v; arr(j...r] >= v
        int i = l+1, j = r;
        while( true ){
            // 注意这里的边界, arr[i].compareTo(v) < 0, 不能是arr[i].compareTo(v) <= 0
            // 思考一下为什么?
//            当我们的序列中存在大量重复的元素时，
//
//            排序完成之后就会将整个数组序列分成两个极度不平衡的部分，所以又退化到了O(n^2)级别
//
//            的时间复杂度，这是因为对于每一个"基准"元素来说，重复的元素太多了，如果我们选的"基准"
//
//            元素稍微有一点的不平衡，那么就会导致两部分的差距非常大；即时我们的"基准"元素选在了
//
//            一个平衡的位置，但是由于等于"基准"元素的元素也非常多，也会使得序列被分成两个及其不平

//            衡的部分，那么在这种情况下快速排序就又会退化成O(n^2)级别的排序算法。
            //这是因为对于连续出现相等的情况，a方式会交换i和j的值；而b方式则会将连续出现的这些值归为其中一方，使得两棵子树不平衡
            while( i <= r && arr[i].compareTo(v) < 0 )
                i ++;

            // 注意这里的边界, arr[j].compareTo(v) > 0, 不能是arr[j].compareTo(v) >= 0
            // 思考一下为什么?
            while( j >= l+1 && arr[j].compareTo(v) > 0 )
                j --;


            if( i > j )
                break;

            swap( arr, i, j );
            i ++;
            j --;
        }

        swap(arr, l, j);

        return j;
    }

    // 递归使用快速排序,对arr[l...r]的范围进行排序
    private static void sort(Comparable[] arr, int l, int r){

        // 对于小规模数组, 使用插入排序
        if( r - l <= 15 ){
            InsertionSort.sort(arr, l, r);
            return;
        }

        int p = partition(arr, l, r);
        sort(arr, l, p-1 );
        sort(arr, p+1, r);
    }

    public static void sort(Comparable[] arr){

        int n = arr.length;
        sort(arr, 0, n-1);
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }


}
