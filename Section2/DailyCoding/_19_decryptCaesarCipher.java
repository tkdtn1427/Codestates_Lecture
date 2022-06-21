package Section2.DailyCoding;
import java.util.*;

public class _19_decryptCaesarCipher {
    public static void main(String[] args) {
        String output = decryptCaesarCipher("khoor", 3);
        System.out.println(output);
    }

//    static String decryptCaesarCipher(String str, int secret) {
//        // TODO:
//        if(str.length() ==0 ) return new String("");
//        String[] str_arr = str.split("");
//
//        for(int i=0; i<str_arr.length; i++){
//            if(str_arr[i].equals(" ")) continue;
//            char tmp = (char)(str_arr[i].charAt(0) - secret % ('z'-'a'+1));
//            if(tmp < 'a'){
//                str_arr[i] = String.valueOf((char)(tmp +'z'-'a'+1)) ;
//            }
//            else{
//                str_arr[i] = String.valueOf(tmp);
//            }
//        }
//
//        return String.join("",str_arr);
//    }
//==================================================================

    static String decryptCaesarCipher(String str, int secret) {
        //알파벳을 모두 String으로 선언, 할당합니다.
        String alpha = "abcdefghijklmnopqrstuvwxyz";

        //결과를 담을 String을 선언합니다.
        String result = "";

        //입력된 str만큼 순회하며
        for(int i = 0; i < str.length(); i++) {
            //해당 문자열이 공백일 경우
            if(str.charAt(i) == ' ') {
                //결과에 공백을 그대로 추가합니다.
                result = result + str.charAt(i);
            } else {
                //이외의 경우, alpha에서 현재 문자열의 index를 찾아준 이후,
                int asis = alpha.indexOf(str.charAt(i));
                //복호화는 반대 방향으로 이루어기 때문에 seceret을 빼주게 됩니다.
                //전체 길이를 더하고, 나머지를 구하는 이유는 해당 문자열의 index를 벗어날 경우를 고려한 계산식입니다.
                int tobe = (asis - secret + alpha.length()) % alpha.length();
                //복호화한 문자열을 result에 추가합니다.
                result = result + alpha.charAt(tobe);
            }
        }
        //복호화된 문자열이 저장된 변수를 리턴합니다.
        return result;
    }

}
