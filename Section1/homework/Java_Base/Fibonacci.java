package Section1.homework.Java_Base;
import java.util.*;

public class Fibonacci {
    public static void main(String[] args){
        System.out.println("[안내]피보나치 수열 프로그램 시작.");
        Scanner scanner = new Scanner(System.in);
        int num = input_num(scanner);

        Fibonacci_prod fibonacci_prod = new Fibonacci_prod(num);
        fibonacci_prod.show(num);
    }

    static int input_num(Scanner scanner){
        System.out.print("원하는 수열의 개수를 입력해 주세요 : ");
        return scanner.nextInt();
    }
}

class Fibonacci_prod{
    int[] array;

    Fibonacci_prod(int num){
        this.array = new int[num];
    }

    void show(int num){
        for(int i=0; i<num; i++){
            if(i <= 1) array[i] = 1;
            else{
                array[i] = array[i-2] + array[i-1];
            }
        }

        System.out.println(Arrays.toString(array));


    }
}