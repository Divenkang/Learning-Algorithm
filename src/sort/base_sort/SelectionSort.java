package sort.base_sort;

public class SelectionSort {


    private SelectionSort(){}

    public static void sort(int[] arr){
        int n = arr.length;

        for(int i =0;i<n;i++){
            int minIdex = i;

            for(int j = i+1;j<n;j++)
                if(arr[j]<arr[minIdex])
                    minIdex = j;

            swap(arr,i,minIdex);


        }
    }


    private  static void swap(int[]arr,int i ,int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args){
        int[] arr = {10,9,8,5,1,12};
        SelectionSort.sort(arr);
        for(int i = 0;i< arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
