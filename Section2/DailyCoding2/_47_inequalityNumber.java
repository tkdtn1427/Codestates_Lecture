package Section2.DailyCoding2;

import java.util.Arrays;

public class _47_inequalityNumber {
    public static void main(String[] args) {
        long output = inequalityNumber(">,<,>");
        System.out.println((int)output);
        long output2 = inequalityNumber("<,>,>,<");
        System.out.println((int)output2);
    }
//    static StringBuilder maxVal;
//    static StringBuilder minVal;
//    static boolean find;
//
//    static long inequalityNumber(String signs) {
//        boolean[] isValue = new boolean[10];
//        String[] arr = signs.split(",");
//        find = false;
//        maxVal = new StringBuilder("");
//        minVal = new StringBuilder("");
//        for(int i=0; i<arr.length+1; i++){
//            maxVal.append("0");
//            minVal.append("0");
//        }
//
//
//        for(int i=9; i>=0; i--){
//            if(isValue[i] == false){
//                maxVal.replace(0,1,String.valueOf(i));
//                isValue[i] = true;
//                recur(arr,isValue,0, maxVal,0);
//                if(find == true) break;
//                isValue[i] = false;
//            }
//        }
//
//        Arrays.fill(isValue,false);
//        find = false;
//
//        for(int i=9; i>=0; i--){
//            if(isValue[i] == false){
//                minVal.replace(0,1,String.valueOf(9-i));
//                isValue[i] = true;
//                recur(arr,isValue,0, minVal,9);
//                if(find == true) break;
//                isValue[i] = false;
//            }
//        }
//        System.out.println(maxVal.toString());
//        System.out.println(minVal.toString());
//        return Long.parseLong(maxVal.toString()) - Long.parseLong(minVal.toString());
//    }
//
//    static void recur(String[] arr, boolean[] isValue, int idx, StringBuilder maxVal, int tmp){
//        if(idx >= arr.length){
//            find = true;
//            return ;
//        }
//        String sign = arr[idx];
//        if(sign.equals(">")){
//            for(int i=9; i>=0; i--){
//                if(isValue[i] == false){
//                    int temp = Math.abs(tmp-i);
//                    maxVal.replace(idx+1,idx+2,String.valueOf(temp));
//                    if(maxVal.charAt(idx) -'0' > maxVal.charAt(idx+1) -'0'){
//                        isValue[i] = true;
//                        recur(arr,isValue,idx+1, maxVal, tmp);
//                        if(find == true) return ;
//                        isValue[i] = false;
//                    }
//                }
//            }
//        }else{
//            for(int i=9; i>=0; i--){
//                if(isValue[i] == false){
//                    int temp = Math.abs(tmp-i);
//                    maxVal.replace(idx+1,idx+2,String.valueOf(temp));
//                    if(maxVal.charAt(idx) -'0' < maxVal.charAt(idx+1) -'0'){
//                        isValue[i] = true;
//                        recur(arr,isValue,idx+1,maxVal, tmp);
//                        if(find == true) return ;
//                        isValue[i] = false;
//                    }
//                }
//            }
//        }
//    }
//==========================================================================================

    static long inequalityNumber(String signs) {
        String[] arr = signs.split(",");
        int[] digits = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] reverseDigits = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        long min = aux(-1, arr, new String[]{}, digits, new boolean[10]);
        long max = aux(-1, arr,  new String[]{}, reverseDigits, new boolean[10]);
        return max - min;
    }

    static int aux(int idx, String[] signs, String[] nums, int[] digits, boolean[] isVisited) {
        if(idx == signs.length) {
            // 부등호 수를 만든 경우
            String result = String.join("", nums);
            return Integer.parseInt(result);
        }

        String sign;

        if(idx != -1) {
            sign = signs[idx];
        } else {
            sign = "NULL";
        }
        for(int i = 0; i < digits.length; i++) {
            // 숫자를 차례대로 검토한다.
            // max를 구할 때는 9부터, min을 구할 때는 0부터
            int right = digits[i];
            // 이전 단계에서 사용한 숫자인 경우 스킵
            if (isVisited[right]) continue;

            // 첫번째 숫자가 아닌 경우에는 조건이 중요하다.
            if (idx >= 0) {
                // 항상 바로 직전의 숫자와 비교하면 된다.
                int left = Integer.parseInt(nums[nums.length - 1]);
                if(sign.equals("<") && left >= right) continue;
                if(sign.equals(">") && left <= right) continue;
            }

            // 조건을 만족하거나 첫번째 숫자인 경우
            isVisited[right] = true;
            String[] stringArr = Arrays.copyOf(nums, nums.length + 1);
            stringArr[stringArr.length - 1] = String.valueOf(right);
            int target = aux(idx + 1, signs, stringArr, digits, isVisited);

            if (target != -1) {
                // 부등호 수를 이미 찾은 경우 탐색을 더 할 필요가 없다.
                return target;
            }
            // 탐색에 실패한 경우, 시도한 숫자의 상태(사용중)를 원래대로(사용안함) 바꿔놔야 한다.
            isVisited[right] = false;
        }
        return -1;
    }
}
