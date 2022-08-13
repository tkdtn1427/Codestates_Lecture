package Section2.DailyCoding2;

import java.util.Arrays;

public class _51_LCS {
    public static void main(String[] args) {
        int output = LCS("abcd", "aceb");
        System.out.println(output);
    }

//    static int LCS(String str1, String str2) {
//        int[][] arr = new int[str1.length()+1][str2.length()+1];
//
//        for(int i=0; i<str1.length(); i++){
//            for(int j=0; j<str2.length(); j++){
//                if(str1.charAt(i) == str2.charAt(j)){
//                    arr[i+1][j+1] = arr[i][j]+1;
//                }else{
//                    int temp = Math.max(arr[i][j+1],arr[i+1][j]);
//                    arr[i+1][j+1] = temp;
//                }
//            }
//        }
//
//        return arr[str1.length()][str2.length()];
//    }
//============================================================
    static int LCS(String str1, String str2) {
    // dynamic programming: O(M * N)
    // memoization을 활용해 중복 계산되는 문제를 제거한다.
    // LCS('ABCD', 'ACEB')의 경우 재귀 호출을 적어보면 아래와 같다.
    // => 1) LCS('BCD', 'CEB')
    //  => 1-1) LCS('CD', 'CEB'), 1-2) LCS('BCD', 'EB')
    //    => 1-1-1) LCS('D', 'CEB'), 1-1-2) LCS('CD', 'EB')
    //    => 1-2-1) LCS('CD', 'EB'), 1-2-2) LCS('BCD', 'B')
    // 더 볼 필요 없이 1-1-2)와 1-2-1)은 같은 문제임을 알 수 있다.
    int M = str1.length();
    int N = str2.length();
    // 중복 계산을 방지하기 위해 left, right
    int[][] memo = new int[M + 1][N + 1];
    for(int[] data : memo) Arrays.fill(data, -1);

    return compareOneByOne(0, 0, 0, memo, str1, str2);

}
    static int compareOneByOne(int left, int right, int len, int[][] memo, String str1, String str2) {
        if (memo[left][right] != -1) return memo[left][right];

        if (left == str1.length() || right == str2.length()) return 0;

        if (str1.charAt(left) == str2.charAt(right)) {
            memo[left][right] = 1 + compareOneByOne(left + 1, right + 1, len + 1, memo, str1, str2);
            return memo[left][right];
        }

        memo[left][right] = Math.max(
                compareOneByOne(left + 1, right, len, memo, str1, str2),
                compareOneByOne(left, right + 1, len, memo, str1, str2)
        );
        return memo[left][right];
    }

}

//"acaykp", "capcak"