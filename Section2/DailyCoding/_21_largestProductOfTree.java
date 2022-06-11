package Section2.DailyCoding;
import java.util.*;

public class _21_largestProductOfTree {
    public static void main(String[] args) {
        int output = largestProductOfThree(new int[]{-5, -4, -3, -2, -1});
        System.out.println(output);
    }

//    static int largestProductOfThree(int[] arr) {
//        Arrays.sort(arr);
//        int[] mino = new int[]{};
//        int[] plus = new int[]{};
//        for(int i=0; i<arr.length; i++){
//            if(arr[i] >=0 ){
//                mino = Arrays.copyOfRange(arr,0,i);
//                plus = Arrays.copyOfRange(arr,i,arr.length);
//                break;
//            }
//
//            if(i==arr.length-1){
//                mino = arr;
//            }
//        }
//
//        List<Integer> result = new ArrayList<>();
//        int plus_n = 1;
//        int mino_n = 1;
//
//        for(int i=0; i<=3; i++){
//            if(mino.length >= i && plus.length >= 3-i){
//                if(i == 3){
//                    mino_n = cal_arr(Arrays.copyOfRange(mino,mino.length-3, mino.length));
//                }else{
//                    mino_n = cal_arr(Arrays.copyOfRange(mino,0,i));
//                    plus_n = cal_arr(Arrays.copyOfRange(plus,plus.length-(3-i),plus.length));
//                }
//                result.add(mino_n*plus_n);
//            }
//        }
//
//        return result.stream().mapToInt(x -> x).max().orElse(0);
//    }
//
//    static int cal_arr(int[] arr){
//        int result = 1;
//        for(int i=0; i<arr.length; i++){
//            result *= arr[i];
//        }
//
//        return result;
//    }
//==============================================================================================

    static int largestProductOfThree(int[] arr) {
        //배열을 오름차순으로 정리합니다.
        Arrays.sort(arr);
        int arrLength = arr.length;
        //가장 큰 양수 3가지를 곱한 값
        int candidate1 = arr[arrLength - 1] * arr[arrLength - 2] * arr[arrLength - 3];
        //가장 작은 음수 2가지와, 가장 큰 양수를 곱한 값
        int candidate2 = arr[arrLength - 1] * arr[0] * arr[1];
        return Math.max(candidate1, candidate2);
    }

}


