package Section2.DailyCoding;
import java.util.*;

public class _11_removeExtreams {
    public static void main(String[] args) {
        String[] output = removeExtremes(new String[]{"where", "is", "the", "longest", "word"});
        for(String str : output){
            System.out.println(str);
        }
    }

//    static String[] removeExtremes(String[] arr) {
//        // TODO:
//        if(arr.length == 0) return null;
//        int min=0;
//        int max=0;
//        for(int i=0; i<arr.length; i++){
//            if(arr[min].length()<=arr[i].length()) min=i;
//            if(arr[max].length()>=arr[i].length()) max=i;
//        }
//
//        String[] result = new String[arr.length-2];
//        int j=0;
//        for(int i=0; i<arr.length; i++){
//            if(max == i || min == i) continue;
//            result[j++] = arr[i];
//        }
//
//        return result;
//    }
//====================================================================
    static String[] removeExtremes(String[] arr) {
        //입력된 문자열이 공백일때 null을 리턴합니다.
        if(arr.length == 0) {
            return null;
        }
        //최대 길이는 20, 최소 길이는 0으로 기본값을 설정합니다.
        //가장 작은 인덱스와 가장 긴 문자열의 인덱스를 찾기위해 0으로 기본값을 설정합니다.
        int shortestLen = 20;
        int longestLen = 0;
        int shortestIdx = 0;
        int longestIdx = 0;

        //배열의 길이만큼 순회합니다.
        for (int i = 0; i < arr.length; i++) {
            //해당 요소(문자열)이 longestLen보다 클때
            if (arr[i].length() >= longestLen) {
                //longestLen에 현재 문자열의 길이를 넣어주고, longestIdx에 현재 인덱스를 넣어줍니다.
                longestLen = arr[i].length();
                longestIdx = i;
            }
            //같은 방식으로 최소 문자열과 인덱스를 찾아 대입합니다.
            if (arr[i].length() <= shortestLen) {
                shortestLen = arr[i].length();
                shortestIdx = i;
            }
        }
        //결과를 넣어줄 새로운 배열을 선언합니다. 최소 문자열과 최대 문자열을 제외하기 떄문에 -2만큼의 배열을 선언합니다.
        String[] result = new String[arr.length - 2];
        int curIndex = 0;
        //배열을 순회하며 결과를 넣어준 후
        for (int i = 0; i < arr.length; i++) {
            if (i != shortestIdx && i != longestIdx) {
                result[curIndex] = arr[i];
                curIndex++;
            }
        }
    //결과를 리턴합니다.
    return result;
}
}
