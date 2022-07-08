package Section2.DailyCoding;

import java.util.ArrayList;
import java.util.Arrays;

public class _30_rotatedArraySearch {
    public static void main(String[] args) {
        //int output = rotatedArraySearch(new int[]{4, 5, 6, 0, 1, 2, 3}, 2);
        //int output2 = rotatedArraySearch(new int[]{11,12,13,14,4, 5, 6,7,8,9,10}, 6);
        int output3 = rotatedArraySearch(new int[]{4, 5, 6, 0, 1, 2, 3}, 2);
        System.out.println(output3);
    }

//    static int rotatedArraySearch(int[] rotated, int target) {
//        if(rotated.length ==0 || (rotated.length==1 && rotated[0]!=target)) return -1;
//
//        int half = rotated.length/2;
//        int[] left = Arrays.copyOfRange(rotated,0,half);
//        int[] right = Arrays.copyOfRange(rotated,half+1,rotated.length);
//
//        if(rotated[half] == target)
//            return half;
//        else if(rotated[half] < target){
//            if(isValid(right,target)){
//                int temp = rotatedArraySearch(right,target);
//                if(temp == -1) return temp;
//                return half+1+temp;
//            }else{
//                int temp = rotatedArraySearch(left,target);
//                return temp;
//            }
//        }else{
//            if(isValid(left,target)){
//                int temp = rotatedArraySearch(left,target);
//                return temp;
//            }else{
//                int temp = rotatedArraySearch(right,target);
//                if(temp == -1) return -1;
//                return half+1+temp;
//            }
//        }
//    }
//
//    static boolean isValid(int[] rotated,int target){
//        if(rotated.length==0){
//            return false;
//        }
//        if(Math.min(rotated[0],rotated[rotated.length-1]) <= target && Math.max(rotated[0],rotated[rotated.length-1]) >= target){
//            return true;
//        }else{
//            return false;
//        }
//    }
//==================================================================================

    static int rotatedArraySearch(int[] rotated, int target) {
        int left = 0;
        int right = rotated.length - 1;

        while(left <= right) {
            int middle = (right + left) / 2;

            if(rotated[middle] == target) {
                return middle;
            }

            if (rotated[left] < rotated[middle]) {
                // 왼쪽 절반이 정렬되어 있는 상태
                if (target < rotated[middle] && rotated[left] <= target) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            } else {
                // 오른쪽 절반이 정렬되어 있는 상태
                if (target <= rotated[right] && rotated[middle] < target) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
        }

        return -1;
    }

}

//  5 6 7 8 9 10 2 3 4                10

//

//
