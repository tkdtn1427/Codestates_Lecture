package Section2.DailyCoding2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _49_LTS {
    public static void main(String[] args) {
        int output = LIS(new int[]{2, 5, 3, 7, 11, 8, 10, 13, 6});
        System.out.println(output);
    }

//    static int result;
//    static int LIS(int[] arr) {
//        result =0;
//        for(int i=0; i<arr.length-1; i++){
//            List<Integer> list = new ArrayList<>();
//            list.add(arr[i]);
//            list = recur(arr,list,i+1);
//        }
//
//        return result;
//    }
//
//    static List<Integer> recur(int[] arr, List<Integer> list,int idx){
//        if(idx == arr.length ){
//            if(list.size() > result) result = list.size();
//            return list;
//        }
//
//        if(arr[idx] > list.get(list.size()-1)){
//            list.add(arr[idx]);
//            list = recur(arr,list,idx+1);
//
//            list.remove(list.size()-1);
//            list = recur(arr,list,idx+1);
//        }else{
//            list = recur(arr,list,idx+1);
//        }
//
//        return list;
//    }
//=====================================================================================================


    static int LIS(int[] arr) {
        int N = arr.length;
        // lis[i]는 i에서 끝나는 LIS의 길이를 저장
        // 최소한 각 요소 하나로 LIS를 만들 수 있으므로 1로 초기화한다.
        int[] lis = new int[N];
        Arrays.fill(lis, 1);
        for(int i = 1; i < N; i++) {
            // i에서 끝나는 LIS의 길이
            for (int j = 0; j < i; j++) {
                // i 이전의 인덱스만 검사하면 된다.
                // i는 1부터 시작하므로, 짧은 길이부터 검사한다. (bottom-up 방식)
                if (arr[i] > arr[j] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                }
            }
        }
        System.out.println(Arrays.toString(lis));
        return Arrays.stream(lis).max().getAsInt();
    }
}
