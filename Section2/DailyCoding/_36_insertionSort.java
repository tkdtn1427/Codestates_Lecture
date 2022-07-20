package Section2.DailyCoding;

import java.util.Arrays;

public class _36_insertionSort {
//    static int[] insertionSort(int [] arr){
//        for(int i=1; i<arr.length; i++){
//            for(int j=0; j<i; j++){
//                if(arr[j] > arr[i]){
//                    int temp = arr[j];
//                    arr[j] = arr[i];
//                    arr[i] = temp;
//                }
//            }
//        }
//        System.out.println(Arrays.toString(arr));
//
//        return arr;
//    }

//===================================================================================

    static int[] insertionSort(int[] arr) {
        for (int index = 1; index < arr.length; index++) {
            int target = index;
            while (target > 0 && arr[target - 1] > arr[target]) {
                int temp = arr[target - 1];
                arr[target - 1] = arr[target];
                arr[target] = temp;
                target--;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] output = insertionSort(new int[]{8,5,6,2,4});
        System.out.println(output);
    }
}
