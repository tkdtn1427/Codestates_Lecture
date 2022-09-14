package Section2.DailyCoding2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

//Solution
public class test {
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String str2 = scanner.nextLine();
        String[] strlst = new String[]{str, str2};
        int idx = 0;

        for(String tmp : strlst){
            if(tmp.length() ==0) strlst[idx] = "null";
            idx++;
        }


        System.out.println(Arrays.toString(strlst));
    }
}
