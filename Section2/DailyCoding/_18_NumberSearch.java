package Section2.DailyCoding;
import java.io.OutputStream;
import java.util.*;

public class _18_NumberSearch {
    public static void main(String[] args) {
        int output = numberSearch("Hello6 9World 2,");
        System.out.println(output);
    }

//    static int numberSearch(String str) {
//        // TODO:
//        if(str.length() == 0) return 0;
//
//        String[] str_arr = str.split("");
//        int sum=0;
//        int count=0;
//
//        for(int i=0; i<str_arr.length; i++){
//            if(str_arr[i].charAt(0) >= '0' && str_arr[i].charAt(0) <= '9'){
//                sum += Integer.valueOf(str_arr[i]);
//                count++;
//            }
//            if(str_arr[i].equals(" ")) count++;
//        }
//        int len = str.length() - count;
//        int result = (int)Math.round(((double)sum / (double)len)*10/10);
//        return result;
//    }
//=========================================================================================
// Other Solution
    static int numberSearch(String str) {
        //찾아야 하는 숫자를 문자열로 모두 선언합니다.
        String digits = "0123456789";

        //입력된 문자열이 공백이라면 0을 리턴합니다.
        if(str.length() == 0) return 0;

        //숫자를 카운트할 변수와, 숫자를 제외한 문자열을 저장할 변수를 선언합니다.
        double sum = 0;
        String pureStr = "";

        //문자열을 순회합니다.
        for(int i = 0; i < str.length(); i++) {
            //digits의 값에서 str[i]의 값이 포함되어 있다면 (indefxOf는 값이 존재하면 해당 인덱스를, 없다면 -1을 리턴합니다)
            if(digits.indexOf(str.charAt(i)) != -1) {
                //숫자를 1 더해줍니다.
                sum = sum + Character.getNumericValue(str.charAt(i));
                //존재하지 않고, 공백이 아니라면
            } else if(str.charAt(i) != ' ') {
                //해당 문자열을 pureStr에 더해줍니다.
                pureStr = pureStr + str.charAt(i);
            }
        }
        //결과를 계산합니다. 계산된 숫자를 문자열의 길이로 나눈 이후,
        double result = sum / pureStr.length();
        //Math.round를 활용하여 소수점으로부터 반올림하여 리턴합니다.
        return (int) Math.round((result * 10) / 10);
    }

}
