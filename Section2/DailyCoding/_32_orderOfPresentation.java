package Section2.DailyCoding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//★ Not Solve a Q Alone
// Re Solve
public class _32_orderOfPresentation {
    static List<Integer[]> result = new ArrayList<>();
    public static void main(String[] args) {
        int output = orderOfPresentation(4, new int[]{4, 3, 1, 2});
        System.out.println(output);
    }

//    static int orderOfPresentation(int N, int[] K) {
//        boolean[] isUsed = new boolean[N+1];
//        int order = 0;
//        for(int i=0; i<N; i++){
//            int use = K[i];
//            isUsed[use] = true;
//
//            int valid = 0;
//            for(int j=1; j<use; j++){
//                if(!isUsed[j]){
//                    valid += 1;
//                }
//            }
//            order += valid * factorial(N-1-i);
//        }
//
//        return order;
//    }
//
//    static int factorial(int n){
//        if (n ==0) return 0;
//        else if(n<=1) return 1;
//        return n * factorial(n-1);
//    }
//========================================================================
    static int orderOfPresentation(int N, int[] K) {
    // 조의 개수 N, 발표 순서 K

    // N은 최대 12입니다.
    // 발표 순서를 만드는 것은 순열(permutation)이므로, 발표 순서의 최대 크기는 12!입니다.
    // 이는 약 4억 8천만에 해당하며, 일반적인 수행 속도 상한(약 1억)을 훨씬 상회하므로 순열을 전부 생성하는 것은 올바른 접근 방법이 아닙니다.

    // 발표 순서를 담는 변수 생성
    int order = 0;

    // N개의 조 중에, 어떠한 조가 이미 포함되었는지 확인하기 위해 배열을 생성합니다.
    // 만약 N이 3이라면 [false, false, false, false]로 생성됩니다.
    // 제일 첫 번째는 더미 데이터입니다. (인덱스는 0부터 시작하지만 조는 1부터 시작하기 때문에)
    boolean[] isUsed = new boolean[N + 1];

    // K의 길이만큼 순회합니다.
    for (int i = 0; i < K.length; i++) {
        // K의 i번째 조를 변수에 담습니다.
        int num = K[i];
        // 사용했는지 판별하기 위해 isUsed에 체크합니다. (중복이 아니기 때문에)
        isUsed[num] = true;
        // num보다 앞에 올 수 있는 수들의 배열을 복제해서,
        boolean[] candidates = Arrays.copyOfRange(isUsed, 1, num);
        // 이 중에서 아직 사용되지 않은 수의 개수를 구합니다.
        int validCnt = 0;
        for (boolean candidate : candidates) if (!candidate) validCnt++;
        // 아직 사용되지 않은 수, 그 전까지의 모든 경우의 수를 카운트합니다.
        int formerCnt = validCnt * factorial(N - i - 1);
        // order에 추가합니다.
        order = order + formerCnt;
    }
    return order;
}

    static int factorial(int n) {
        if(n <= 1) return 1;
        return n * factorial(n - 1);
    }

}