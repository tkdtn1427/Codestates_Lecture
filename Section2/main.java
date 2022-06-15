package Section2;
import java.util.*;

public class main {
    public static void main(String[] args) {
        boolean output2 = balancedBrackets("[({})]");
        //System.out.println(output2);
    }
    static boolean balancedBrackets(String str) {
        ArrayList<Character> stack = new ArrayList<Character>();
        ArrayList<String> close_ = new ArrayList<>(Arrays.asList(new String[]{"]","}",")"}));
        for(int i=0; i<str.length(); i++){
            if(close_.contains(String.valueOf(str.charAt(i)))){
                String temp = close_.remove(close_.size()-1);

            }else{
                stack.add(str.charAt(i));
            }
        }
        return false;
    }
}

