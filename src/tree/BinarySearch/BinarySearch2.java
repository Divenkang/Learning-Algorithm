package tree.BinarySearch;
//递归实现

public class BinarySearch2 {

    private BinarySearch2() {}

    private static int find(Comparable[] arr, int l, int r, Comparable target){

        if( l > r )
            return -1;

        //int mid = (l+r)/2;
        // 防止极端情况下的整形溢出，使用下面的逻辑求出mid
        int mid = l + (r-l)/2;

        if( arr[mid].compareTo(target) == 0 )
            return mid;
        else if( arr[mid].compareTo(target) > 0 )
            return find(arr, l, mid-1, target);
        else
            return find(arr, mid+1, r, target);
    }

    // 二分查找法,在有序数组arr中,查找target
    // 如果找到target,返回相应的索引index
    // 如果没有找到target,返回-1
    public static int find(Comparable[] arr, Comparable target) {

        return find(arr, 0, arr.length-1, target);
    }
}
