package Section2.DailyCoding2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _44_LSCS {
    public static void main(String[] args) {
        int output = LSCS(new int[]{-7, -6,7, -9});
        System.out.println(output); // --> 7 ([1, 2, 3, -4, 5])
    }

//    static int LSCS(int[] arr) {
//        // TODO:
//        List<Integer> list = new ArrayList<>();
//        int a_sum = 0;
//        int m_sum = 0;
//        int max=-100001;
//        int sum=0;
//
//        for(int i=0; i<arr.length; i++){
//            if(arr[i] > 0){
//                a_sum += arr[i];
//                if(m_sum < 0 ){
//                    list.add(m_sum);
//                    m_sum =0;
//                }
//            }else{
//                m_sum += arr[i];
//                if(a_sum > 0){
//                    list.add(a_sum);
//                    a_sum = 0;
//                }
//            }
//
//            if(i == arr.length-1){
//                if(arr[i] > 0){
//                    list.add(a_sum);
//                }else{
//                    list.add(m_sum);
//                }
//            }
//        }
//
//        boolean allminus = true;
//
//        for(int i=0; i<list.size(); i++){
//            int temp = list.get(i);
//            if(temp > 0){
//                allminus = false;
//            }
//            sum += temp;
//            if(sum < 0) sum = 0;
//            max = temp > sum ? (temp > max ? temp : max) : (sum > max ? sum : max);
//        }
//
//        if(allminus == true){
//            max = Arrays.stream(arr).max().orElse(0);
//        }
//
//        return max;
//    }


//======================================================================================

    static int LSCS(int[] arr) {
        int subArrSum = 0; // 연속 배열의 합
        int max = Integer.MIN_VALUE; // 정답의 후보를 저장, 음수를 포함하기 때문에 사용 가능한 최저 음수를 할당
        for(int i = 0; i < arr.length; i++) {
            subArrSum = subArrSum + arr[i];
            if(subArrSum > max) max = subArrSum;

            // 연속된 구간의 합이 음수인 경우,
            // 해당 부분은 버리고 다시 시작해도 된다.
            if (subArrSum < 0) {
                subArrSum = 0;
            }
        }
        return max;
    }
}
