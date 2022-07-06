package Section2.DailyCoding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _29_tiling {
    public static void main(String[] args){
        int output = tiling(5);
        System.out.println(output);
    }

    static int tiling(int num){
        //ArrayList<Integer> pertile_sol = new ArrayList<>(List.of(0,1,2));
        ArrayList<Integer> pertile_sol = new ArrayList<>(Arrays.asList(new Integer[]{0,1,2}));
        return cal_tiling(pertile_sol, num);
    }

    static int cal_tiling(ArrayList<Integer> pertile_sol, int num){
        if(pertile_sol.size() > num){
            return pertile_sol.get(num);
        }else{
            pertile_sol.add(cal_tiling(pertile_sol,num-1)+cal_tiling(pertile_sol,num-2));
        }

        return pertile_sol.get(num);
    }
//==============================================================

//    static int tiling(int num) {
//        ArrayList<Integer> memo = new ArrayList<>(Arrays.asList(0, 1, 2));
//        return aux(num, memo);
//    };
//
//    static int aux(int size, ArrayList<Integer> memo) {
//        if(memo.size() > size) return memo.get(size);
//        memo.add(aux(size - 1, memo) + aux(size - 2, memo));
//        return memo.get(size);
//    };
}
