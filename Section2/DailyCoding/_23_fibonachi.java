package Section2.DailyCoding;


import java.util.ArrayList;

public class _23_fibonachi {
    public static void main(String[] args) {
        System.out.println(fibonacci(5));
    }

//    static int fibonacci(int num) {
//        int[] arr = new int[num+1];
//        return recur(num,arr,0);
//    }
//
//    static int recur(int num,int[] arr, int count){
//        if(count > num){
//            return arr[count-1];
//        }
//
//        if(count ==0 || count ==1){
//            arr[count] = count;
//        }else{
//            arr[count] = arr[count-1]+arr[count-2];
//        }
//
//        return recur(num,arr,count+1);
//    }
//================================================================================
    static int fibonacci(int num) {
        ArrayList<Integer> memo = new ArrayList<>();
        memo.add(0);
        memo.add(1);

        return aux(memo, num);
    }

    static int aux(ArrayList<Integer> memo, int num) {
        if (memo.size() <= num) {
            memo.add(aux(memo, num - 1) + aux(memo, num - 2));
        }
        return memo.get(num);
    }
}
