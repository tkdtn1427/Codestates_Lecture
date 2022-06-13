package Section2.DailyCoding;
import java.util.*;

public class _13_readVertically {
    public static void main(String[] args) {
        String[] input = new String[]{
                "hi",
                "wolrd",
        };
        String output = readVertically(input);
    }

    static String readVertically(String[] arr) {
//        int max_size =0;
//        for(int i=0; i<arr.length; i++){
//            if(arr[i].length() > max_size) max_size = arr[i].length();
//        }
//
//        String result = "";
//        for(int i=0; i<max_size; i++){
//            for(int j=0; j<arr.length; j++){
//                if(arr[j].length() != 0){
//                    result += String.valueOf(arr[j].charAt(0));
//                    arr[j] = arr[j].substring(1,arr[j].length());
//                }
//            }
//        }
//
//        return result;
//============================================================================================
// Other Solution

        String result = "";
        while (true) {
            boolean find = false;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j].length() != 0) {
                    result += String.valueOf(arr[j].charAt(0));
                    arr[j] = arr[j].substring(1, arr[j].length());
                    find = true;
                }
            }
            if (find == false) break;
        }

        return result;
    }
//============================================================================================

//Other Solution
//    static String readVertically(String[] arr) {
//    //가장 긴 문자열의 길이를 검색합니다.
//        int maxLength = 0;
//
//        for(int i = 0; i < arr.length; i++) {
//            if(maxLength < arr[i].length()) {
//                maxLength = arr[i].length();
//            }
//        }
//        //임시로 해당 길이만큼의 배열을 선언한 뒤,
//        String[] temp = new String[maxLength];
//        //기존의 배열을 순회합니다.
//        for(int i = 0; i < arr.length; i++) {
//            String str = arr[i];
//            //해당 배열의 요소인 문자열을 순회합니다.
//            for(int j = 0; j < str.length(); j++) {
//                //임시 배열이 비어있다면
//                if(temp[j] == null) {
//                    //문자열의 j번째 char를 String으로 변환후 배열에 삽입 (세로위치 첫 문자열)
//                    temp[j] = Character.toString(str.charAt(j));
//                    //임시 배열이 비어있지 않다면, 임시 배열의 기존 문자열에 현재 j번째 char를 더해줍니다.
//                } else {
//                    temp[j] = temp[j] + str.charAt(j);
//                }
//            }
//        }
//        //배열을 순회하며 String으로 변환합니다.
//        String result = "";
//        for(int i = 0; i < temp.length; i++) {
//            result = result + temp[i];
//        }
//
//        return result;
//    }
}
