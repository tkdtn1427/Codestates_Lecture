package Section2.DailyCoding2;

public class _41_binarySearch {
    public static void main(String[] args) {
        int output = binarySearch(new int[]{3, 6, 7, 8, 9, 21, 31, 32}, 25);
        System.out.println(output); // --> 2
    }

//    static int binarySearch(int[] arr, int target) {
//        return search(arr,target,0,arr.length-1);
//    }
//
//    static int search(int[] arr, int target, int start, int last){
//        if(start > last){
//            return -1;
//        }
//        int middle = (start+last)/2;
//        if(arr[middle] == target) return middle;
//        else if(target > arr[middle]) return search(arr,target,middle+1,last);
//        else return search(arr,target,start,middle-1);
//    }

//============================================================================

    static int binarySearch(int[] arr, int target) {
        // 좌측 기준점
        int left = 0;
        // 우측 기준점
        int right = arr.length - 1;
        // 기준점이 서로에게 도달할때까지 반복합니다.
        while (left <= right) {
            // 중앙 기준점
            int middle = (right + left) / 2;
            // 현재 기준이 타겟과 일치한다면 해당 값을 반환합니다.
            if (arr[middle] == target) return middle;
            // 기준점보다 크다면 우측을 줄이고
            if (target < arr[middle]) {
                right = middle - 1;
                //기준점보다 작다면 좌측을 줄입니다.
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }

}
