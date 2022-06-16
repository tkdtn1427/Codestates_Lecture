package Section2.DailyCoding;

import java.util.*;

public class _16_isIsogram {
    public static void main(String[] args) {
        boolean output = isIsogram("Dermatoglyphics");
        System.out.println(output);
    }

//    static boolean isIsogram(String str) {
//        // TODO:
//        if (str.length() == 0) return true;
//        str = str.toUpperCase();
//        for(int i=0; i<str.length()-1; i++){
//            for(int j=i+1; j<str.length(); j++){
//                if(str.charAt(i) == str.charAt(j)){
//                    return false;
//                }
//            }
//        }
//
//        return true;
//    }
//=====================================================
    static boolean isIsogram(String str) {
        //입력된 문자열이 공백일 경우 true를 리턴합니다.
        if(str.length() == 0) return true;

        //사용된 알파벳을 저장할 HashMap을 선언합니다.
        HashMap<Character, String> cache = new HashMap<Character, String>();

        //입력된 전체 문자열을 모두 소문자로 변환합니다.
        str = str.toLowerCase();

        //입력된 문자열을 순회하며
        for(int i = 0; i < str.length(); i++) {
            //HashMap에 이미 해당 알파벳이 저장되어 있다면
            if(cache.containsKey(str.charAt(i))) {
                //false를 리턴합니다.
                return false;
            }
            //HashMap에 해당 문자열이 저장되어 있지 않다면, 저장합니다.
            cache.put(str.charAt(i), "Exists");
        }
        //모든 문자열을 순회한다면 true를 리턴합니다.
        return true;
}



}
