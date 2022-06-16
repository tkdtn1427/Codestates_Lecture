package Section2.DailyCoding;
import java.util.*;


public class _25_power {
    public static void main(String[] args) {
        long output = power(3, 40);
        System.out.println(output);
    }

    static long power(int base, int exponent) {
        long result = 1;
        for(int i=0; i<exponent; i++){
            result *= base;
            if(result >= 94906249){
                result %= 94906249;
            }
        }

        return result;
    }

}
