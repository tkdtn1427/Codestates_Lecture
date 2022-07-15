package Section2;
import java.lang.reflect.Member;
import java.util.*;

public class main {
    public static void main(String[] args) {
//        Map<String,Integer> trans = new HashMap<String,Integer>(){{
//            put("A",0);
//            put("G",1);
//            put("C",2);
//            put("T",3);
//        };
//        };
//
//        String[][] test = {{"A","C","A","G"},
//                {"C","G","T","A"},
//                {"A","T","C","G"},
//                {"G","A","G","T"}};
//
//        String test_str = "AAGTCG";
//        StringBuffer temp = new StringBuffer(test_str);
//        test_str = temp.reverse().toString();
//
//        String first = String.valueOf(test_str.charAt(0));
//
//        for(int i=1; i<test_str.length(); i++){
//            String next = String.valueOf(test_str.charAt(i));
//            first = test[trans.get(first)][trans.get(next)];
//        }
//
//        System.out.println(first);

    }
//    static boolean balancedBrackets(String str) {
//        ArrayList<Character> stack = new ArrayList<Character>();
//        ArrayList<String> open_ = new ArrayList<>(Arrays.asList(new String[]{"[","{","("}));
//        ArrayList<String> close_ = new ArrayList<>(Arrays.asList(new String[]{"]","}",")"}));
//
//        for(int i=0; i<str.length(); i++){
//            if(isVaild(str.charAt(i),open_)){
//                stack.add(str.charAt(i));
//            }else if(isVaild(str.charAt(i),close_)){
//                if(stack.size()==0 || !isMatch(stack.remove(stack.size()-1),str.charAt(i))){
//                    return false;
//                }
//            }else{}
//        }
//        if(stack.isEmpty()) return true;
//        else return false;
//    }
//
//    static boolean isVaild(char str,ArrayList<String> arr){
//        if(arr.contains(String.valueOf(str)))
//            return true;
//        else return false;
//    }
//
//    static boolean isMatch(char stack, char str){
//        if(stack=='(' && str==')') return true;
//        else if(stack=='[' && str==']') return true;
//        else if(stack=='{' && str=='}') return true;
//        else return false;
//    }

//=============================================================

//    public static void main(String[] args) {
//        boolean[] tile = new boolean[4];
//        Arrays.fill(tile, Boolean.TRUE);
//        int count = 1;
//
//        for (int i = 2; i <= tile.length - 1; i++) {
//            count += tofill(Arrays.copyOfRange(tile,0,i));
//        }
//    }
//
//    static int tofill(boolean[] tile){
//
//
}

