package Section2.Coding_test;
import java.util.*;

public class _7_blackjack {
    public static void main(String[] args) {
        int output = boringBlackjack(new int[]{2, 3, 4, 8, 13});
        System.out.println(output);
    }

//    static int boringBlackjack(int[] cards) {
//        ArrayList<Integer> contain_ = new ArrayList<>();
//        int count=0;
//        return solution(cards,contain_,3,count);
//    }
//
//    static int solution(int[] cards, ArrayList<Integer> contain_, int picked,int count){
//        if(picked ==0){
//            if(isvalid(contain_)) count = count+1;
//            return count;
//        }
//
//        for(int i=0; i<cards.length;i++){
//            contain_.add(cards[i]);
//            count = solution(Arrays.copyOfRange(cards,i+1,cards.length),contain_,picked-1,count);
//            contain_.remove(contain_.size()-1);
//        }
//
//        return count;
//    }
//
//    static boolean isvalid(ArrayList<Integer> contain_){
//        int result = contain_.stream().mapToInt(x->x).sum();
//        for(int i=2; i<=result/2; i++){
//            if(result % i == 0) return false;
//        }
//
//        return true;
//    }

    static int boringBlackjack(int[] cards) {
        int count = 0;
        // 1. cards 에서 카드 3장 뽑기
        int length = cards.length;
        // 카드 뽑는 방식은 첫 카드를 cards 의 0번 index 부터 고정해 놓고 1씩 뒤로 옮겨간다
        for(int i = 0; i < length; i++) {
            // 두 번째 카드의 인덱스는 첫 카드 + 1에서 시작해야 하고
            for(int j = i + 1; j < length; j++) {
                // 세 번째 카드의 인덱스는 두 번째 카드 + 1에서 시작해야 한다
                for(int k = j + 1; k < length; k++) {
                    int number = cards[i] + cards[j] + cards[k];
                    // 세 카드의 합이 소수이면 경우의 수 + 1
                    if(isPrime(number)) count++;
                }
            }
        }
        return count;
    }

    //2. 소수 판별
    static boolean isPrime(int number) {
        // 2부터 비교하기 시작해서 나누어 떨어지는 수가 있으면 소수가 아니다
        // for 문 조건을 Math.sqrt(number) 로 해도 되는 이유는 i > Math.sqrt(number) 가 되면 몫이 절대 0이 될수 없기 때문에
        // Math.sqrt(number) 까지만 비교해 보아도 소수 판별이 가능하다
        for(int i = 2; i <= Math.sqrt(number); i++) {
            if(number % i == 0) return false;
        }
        return true;
    }
}


/*

1.

 */
