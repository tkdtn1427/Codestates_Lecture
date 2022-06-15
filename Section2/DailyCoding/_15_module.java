package Section2.DailyCoding;
import java.util.*;

public class _15_module {
    public static void main(String[] args) {
        Integer output = modulo(25, 4);
        System.out.println(output);
    }

    static Integer modulo(int num1, int num2) {
        if(num2 == 0) return null;


        while(num1 >= num2){
            num1 -= num2;
        }

        return num1;
    }
//=======================================================
// Other Solution
//    static Integer modulo(int num1, int num2) {
//        if(num2 == 0) {
//            return null;
//        }
//
//        while (num1 >= num2) {
//            num1 = num1 - num2;
//        }
//
//        return num1;
//    }
}
