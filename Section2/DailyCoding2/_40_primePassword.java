package Section2.DailyCoding2;

import java.util.*;
import java.util.stream.Stream;


//다시풀어보기 어느정도 풀이를 보고 혼자 작성한 케이스
public class _40_primePassword {
    public static void main(String[] args) {
        int output = primePassword(9787, 9923);
        System.out.println(output);
    }

//    static int primePassword(int curPwd, int newPwd) {
//        boolean[] isol = new boolean[10000];
//        boolean[] isValid = new boolean[10000];
//        int[] count = new int[10000];
//        Arrays.fill(isol,true);
//        Arrays.fill(isValid,true);
//        isol[0] = false;
//        isol[1] = false;
//        isol = isIsol(isol);
//        int temp = 0;
//
//        List<Integer> arr = new ArrayList<>();
//        isValid[curPwd] = false;
//        arr.add(curPwd);
//
//        while(!arr.isEmpty()) {
//            temp = arr.remove(0);
//
//            if (temp == newPwd) {
//                return count[temp];
//            }
//
//            for (int i = 0; i <= 3; i++) {
//                String total = String.valueOf(temp);
//                String remain = String.valueOf(temp).charAt(i)+"";
//                for (int j = 0; j < 10; j++) {
//                    int per = Integer.parseInt(remain) +j > 9? (Integer.parseInt(remain)+j)%10 : Integer.parseInt(remain) +j;
//                    StringBuffer sb = new StringBuffer(total);
//                    sb.replace(i,i+1,per+"");
//                    total = sb.toString();
//                    int total_int = Integer.valueOf(total);
//                    if(total_int < 1000){
//                        continue;
//                    }
//                    if(isValid[total_int] == true && isol[total_int] == true){
//                        count[total_int] = count[temp]+1;
//                        isValid[total_int] = false;
//                        arr.add(total_int);
//                    }
//                }
//            }
//        }
//
//        return -1;
//    }
//
//    static boolean[] isIsol(boolean[] isol){
//        int sqrt = (int)Math.ceil(Math.sqrt(isol.length));
//        for(int i=2; i<=sqrt; i++){
//            int j=2;
//            if(isol[i] == true){
//                while(j*i < 10000){
//                    isol[i*j] = false;
//                    j += 1;
//                }
//            }
//        }
//
//        return isol;
//    }
//==============================================================================================

    public static int primePassword(int curPwd, int newPwd) {
        //변경된 비밀번호가 같을 경우
        if (curPwd == newPwd) return 0;
        // bfs를 위해 queue를 선언
        Queue<int[]> queue = new LinkedList<>();

        // 각 4자리의 방문 여부를 저장하는 배열
        // 한 번 방문한 수(가장 최소의 동작으로 만든 수)는 다시 방문할 필요가 없다.
        boolean[] isVisited = new boolean[10000];
        isVisited[curPwd] = true;
        // bfs를 위한 시작점
        // 큐에는 [필요한 동작 수, 비밀번호]가 저장된다.
        // 배열의 첫번째 인자는 동작 수, 두번째 인자는 비밀번호가 입력된다.
        queue.offer(new int[]{0, curPwd});
        // bfs는 큐가 빌(empty) 때까지 탐색한다.
        while (!queue.isEmpty()) {
            int[] data = queue.poll();
            int step = data[0];
            int num = data[1];
            // 각 자리수 마다 변경이 가능하므로 4번의 반복이 필요하다.
            for (int i = 0; i < 4; i++) {
                int[] digits = splitNumber(num);
                // 0부터 9까지 시도한다.
                for (int d = 0; d < 10; d++) {
                    // 각 자리수마다 원래 있던 수(digits[i])는 피해야 한다.
                    if (d != digits[i]) {
                        // 현재 자리수의 수를 변경하고,
                        digits[i] = d;
                        // 변경한 후 4자리 수를 구한다.
                        int next = joinDigits(digits);
                        // 만약 이 수가 새 비밀번호와 같다면 리턴한다.
                        // next는 deQueue된 num으로부터 1단계 다음에 도달한 수이다.
                        if(next == newPwd) return step + 1;
                        // 1,000보다 큰 소수여야 하고, 방문된 적이 없어야 한다.
                        if(next > 1000 && isPrime(next) && !isVisited[next]) {
                            // 방문 여부를 표시하고,
                            isVisited[next] = true;
                            // 큐에 넣는다.
                            queue.offer(new int[]{step + 1 , next});
                        }
                    }
                }
            }
        }
        // 큐가 빌 때까지, 즉 모든 경우의 수를 탐색할 때까지 리턴되지 않은 경우
        // 현재 비밀번호에서 새 비밀번호를 만들 수 없다.
        return -1;
    }

    // 소수를 판별하는 메서드

    public static boolean isPrime(int num) {
        if(num % 2 == 0) return false;
        int sqrt = (int)(Math.sqrt(num));
        for(int divider = 3; divider <= sqrt; divider += 2) {
            if(num % divider == 0) {
                return false;
            }
        }
        return true;
    }

    // 4자리 수를 받아서 각 자리수의 수들의 배열로 변환하는 메서드
    //  int[] output = splitNum(3359);
    //  System.out.println(output); // --> [3, 3, 5, 9]
    public static int[] splitNumber(int num) {
        // Stream 사용하여 구현
        return Stream.of(String.valueOf(num).split("")).mapToInt(Integer::parseInt).toArray();

        // 반복문을 사용하여 구현

        // String temp = Integer.toString(num);
        // int[] digits = new int[temp.length()];
        // for (int i = 0; i < temp.length(); i++) digits[i] = temp.charAt(i) - '0';
        // return digits;
    }

    // 배열을 입력 받아서 각 자리수의 수들의 숫자로 변환하는 메서드
    //  int output = joinDigits(new int[]{3, 3, 5, 9});
    //  System.out.println(output); // 3359
    public static int joinDigits(int[] arr) {
        String[] tempArr = new String[arr.length];

        for(int i = 0; i < arr.length; i++) {
            tempArr[i] = String.valueOf(arr[i]);
        }

        return Integer.parseInt(String.join("", tempArr));
    }

}
