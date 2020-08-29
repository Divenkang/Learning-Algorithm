package tree.BinarySearch;

//非递归的二分查找
public class BinarySearch {
    //类不产生任何实例
    private BinarySearch(){};

    //二分查找法，在有序数组arr中，查找target
    //如果找到target，返回相应的索引index
    //如果没有找到target，返回-1
    public static int find(Comparable[] arr, Comparable target){

        //find target in the arr
        int l = 0, r = arr.length-1;
        while(l<=r){
            //防止极端情况下的整形溢出，使用下面的逻辑求出mid
            int mid = l+(r-1)/2;

            if(arr[mid].compareTo(target)==0)
                return mid;

            if(arr[mid].compareTo(target)>0)
                r = mid-1;
            else
                l =mid+1;
        }
        return -1;//未找到
    }


}
