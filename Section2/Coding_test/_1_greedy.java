package Section2.Coding_test;

import java.util.Arrays;

public class _1_greedy {
    public static void main(String[] args) {
        int[] stuff = new int[]{42, 25, 60, 73, 103, 167};
        int limit = 187;
        System.out.println(movingStuff(stuff,limit));
    }
//
//    static int movingStuff(int[] stuff, int limit) {
//        // TODO:
//        int tmp=0;
//        for(int i=0; i<stuff.length-1; i++){
//            int max = stuff[i];
//            int index = i;
//            for(int j=i+1; j<stuff.length; j++){
//                if(max < stuff[j]){
//                    max = stuff[j];
//                    index = j;
//                }
//            }
//            tmp = stuff[i];
//            stuff[i] = stuff[index];
//            stuff[index] = tmp;
//        }
//        System.out.println(Arrays.toString(stuff));
//
//        boolean[] use = new boolean[stuff.length];
//        int count=0;
//
//        while(invalid(use)){
//            int remain = limit;
//            int box_num = 2;
//            for(int i=0; i<stuff.length; i++){
//                if(use[i] == false && stuff[i] <= remain){
//                    use[i] = true;
//                    remain -= stuff[i];
//                    box_num-=1;
//                    if(box_num == 0) break;
//                    System.out.println(String.format("잡은 박스 : %d",stuff[i]));
//                    System.out.println(String.format("남은 limit : %d",remain));
//                }
//            }
//            System.out.println();
//            count++;
//        }
//        return count;
//
//    }
//
//    static boolean invalid(boolean[] use){
//        for(int i=0; i<use.length; i++){
//            if(use[i] == false) return true;
//        }
//
//        return false;
//    }

//=========================================================================
    static int movingStuff(int[] stuff, int limit) {
        int twoStuff = 0;
        // 짐을 무게순으로 오름차순 정렬
        Arrays.sort(stuff);
        // 가장 가벼운 짐의 인덱스
        int leftIdx = 0;
        // 가장 무거운 짐의 인덱스
        int rightIdx = stuff.length - 1;
        while (leftIdx < rightIdx) {
            // 가장 가벼운 짐과 무거운 짐의 합이 limit 보다 작거나 같으면 2개를 한번에 나를 수 있다
            if (stuff[leftIdx] + stuff[rightIdx] <= limit) {
                // 다음 짐을 확인하기 위해 가장 가벼운 짐과 무거운 짐을 가리키는 인덱스를 옮겨주고
                // 한번에 2개 옮길 수 있는 개수를 +1 해준다
                leftIdx++;
                rightIdx--;
                twoStuff++;
            } else {
                // 위 조건에 맞지 않는 경우는 한번에 한 개만 나를 수 있는 경우이기 때문에
                // 가장 무거운 짐의 인덱스만 옮겨준다
                rightIdx--;
            }
        }
        // 전체 짐의 개수에서 한번에 2개를 나를 수 있는 경우를 빼 주면 총 필요한 박스의 개수를 구할 수 있다
        return stuff.length - twoStuff;
    }
}