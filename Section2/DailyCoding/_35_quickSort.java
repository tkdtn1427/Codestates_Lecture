package Section2.DailyCoding;

import java.util.Arrays;

public class _35_quickSort {
//    static int[] quickSort(int[] arr) {
//        recur(arr,0,arr.length-1);
//        return arr;
//    }
//
//    static int[] recur(int[] arr, int left, int right){
//        if(left >= right){
//            return arr;
//        }else{
//            int first = left;
//            int last = right;
//            int compareNum = arr[first];
//            left += 1;
//
//            while(left <= right){
//                if(arr[left] > compareNum && arr[right] < compareNum){
//                    int temp = arr[left];
//                    arr[left] = arr[right];
//                    arr[right] = temp;
//                }
//                if(arr[left] < compareNum){
//                    left += 1;
//                }
//                if(arr[right] > compareNum){
//                    right -= 1;
//                }
//            }
//            int temp = arr[right];
//            arr[right] = arr[first];
//            arr[first] = temp;
//            recur(arr,first,right-1);
//            recur(arr,right+1,last);
//        }
//        return null;
//    }

    static int[] quickSort(int[] arr) {
        return test(arr,0,arr.length-1);
    }

    static int[] test(int[] arr, int left, int right){
        int pivot = recur(arr,left,right);
        if(left < pivot-1) arr = test(arr,left,pivot-1);
        if(right > pivot) arr = test(arr,pivot+1,right);

        return arr;
    }

    static int recur(int[] arr, int left, int right){
            int first = left;
            int last = right;
            int compareNum = arr[first];

            while(left <= right){
                while(arr[left] <= compareNum){
                    left +=1;
                    if(left > right){
                        break;
                    }
                }
                while (arr[right] > compareNum){
                    right -=1;
                    if(left > right){
                        break;
                    }
                }
                if(left <= right){
                    int temp = arr[left];
                    arr[left] = arr[right];
                    arr[right] = temp;
                    left++;
                    right--;
                }
            }
            int temp = arr[right];
            arr[right] = arr[first];
            arr[first] = temp;

        return right;
    }

//==============================================================================
//    static int[] quickSort(int[] arr) {
//    //빈 배열일 경우
//        if (arr.length == 0) return arr;
//
//        int left = 0;
//        int right = arr.length - 1;
//
//        return sort(arr, left, right);
//}
//
//    //퀵 정렬 메서드
//    static int[] sort(int[] arr, int left, int right) {
//        //partition 메서드를 활용하여 정렬
//        int part = partition(arr, left, right);
//        if (left < part - 1) arr = sort(arr, left, part - 1);
//        if (right > part) arr = sort(arr, part, right);
//
//        return arr;
//    }
//
//    static int partition(int[] arr, int left, int right) {
//        // 배열의 중앙을 기준으로
//        int pivot = arr[(left + right) / 2];
//        //좌측이 우측보다 작을 경우, 즉 아직 모든 배열을 순회하지 않은 경우 반복
//        while (left <= right) {
//            //좌측의 수가 기준점보다 작다면
//            while (arr[left] < pivot) left++;
//            //우측의 수가 기준점보다 크다면
//            while (arr[right] > pivot) right--;
//            if (left <= right) {
//                int temp = arr[left];
//                arr[left] = arr[right];
//                arr[right] = temp;
//                left++;
//                right--;
//            }
//        }
//        return left;
//    }



    public static void main(String[] args) {
        //                                           l   r
        int[] output = quickSort(new int[]{5,3,8,4,9,1,6,2,7});
        System.out.println(Arrays.toString(output));
    }
}

//5,3,2,4,1,9,6,8,7

