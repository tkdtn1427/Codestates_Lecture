package Section2.DailyCoding;
import java.util.*;


public class _25_power {
    public static void main(String[] args) {
        long output = power(3, 40);
        System.out.println(output);
    }

//    static long power(int base, int exponent) {
//        long result = 1;
//        for(int i=0; i<exponent; i++){
//            result *= base;
//            if(result >= 94906249){
//                result %= 94906249;
//            }
//        }
//
//        return result;
//    }

//==================================================

    static long power(int base, int exponent) {
        //재귀함수로 동작합니다.
        //exponent변수가 0이 될때까지 재귀를 돈 이후, 나머지 연산을 계산하고,
        //해당 결과값을 사용하여 홀수일 경우 다시 연산하여 리턴합니다.

        if(exponent == 0) return 1;

        int half = exponent / 2;
        long temp = power(base, half);
        long result = (temp * temp) % 94906249;

        if(exponent % 2 == 1) return (base * result) % 94906249;
        else return result;
    }

}
