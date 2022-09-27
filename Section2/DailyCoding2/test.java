package Section2.DailyCoding2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

//Solution
public class test {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        LocalDate newDate = LocalDate.now();
        System.out.println(isTrue("String is good"));
        System.out.println(isTrue(43));
    }

    static boolean isTrue(Object object){
        if(object instanceof String){
            return true;
        }else{
            return false;
        }
    }
}
