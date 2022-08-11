package Section2.DailyCoding2;

import java.util.ArrayList;
import java.util.List;

public class _52_uglyNumbers {
    public static void main(String[] args) {
        int result = uglyNumbers(200);
        System.out.println(result);
    }

    static int uglyNumbers(int num){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        int idx =1;
        int isNum = 2;
        while (idx != num){
            if(isUgly(isNum)){
                idx++;
                list.add(isNum);
            }
            isNum++;
        }

        return list.get(idx-1);
    }

    static boolean isUgly(int isNum){

        boolean find = true;

        while(isNum != 1){
            if(isNum % 2 == 0) isNum /=2;
            else if(isNum % 3 == 0) isNum /=3;
            else if(isNum % 5 == 0) isNum /=5;
            else{
                find = false;
                break;
            }
        }

        return find;
    }

//    static int uglyNumbers(int num) {
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        int idx = 1;
//
//        int idx2=0;
//        int idx3=0;
//        int idx5=0;
//
//        while(idx != num){
//            int prev_2 = list.get(idx2)*2;
//            int prev_3 = list.get(idx3)*3;
//            int prev_5 = list.get(idx5)*5;
//
//            int adding = Math.min(Math.min(prev_2,prev_3),prev_5);
//            list.add(adding);
//
//            if(adding == prev_2) idx2++;
//            if(adding == prev_3) idx3++;
//            if(adding == prev_5) idx5++;
//            idx++;
//        }
//
//        return list.get(idx-1);
//    }
}
