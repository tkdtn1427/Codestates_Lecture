package Section2.DailyCoding;
import java.util.*;
import java.util.stream.Collectors;

public class _24_isSubsetOf {
    public static void main(String[] args) {
        int[] base = new int[]{10, 99, 123, 7,6};
        int[] sample = new int[]{6, 7};
        boolean result = isSubsetOf(base,sample);
        System.out.println(result);
    }
    static boolean isSubsetOf(int[] base, int[] sample) {
        String arr_str = Arrays.toString(base);
        for(int tmp : sample){
            if(!arr_str.contains(String.valueOf(tmp))){
                return false;
            }
        }
        return true;
    }

//====================================================================
//    static boolean isSubsetOf(int[] base, int[] sample) {
//        List<Integer> list = new ArrayList<Integer>();
//        for(int i=0; i<base.length; i++){
//            list.add(base[i]);
//        }
//
//        for(int tmp : sample){
//            if(!list.contains(tmp)){
//                return false;
//            }
//        }
//        return true;
//    }
}

/*
    List<Integer> intList
         = Arrays.stream(base)
          .boxed()
          .collect(Collectors.toList());
 */
