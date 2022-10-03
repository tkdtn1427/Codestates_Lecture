package Section2.DailyCoding2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

//Solution
public class test {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Long> test = new LinkedHashMap<>();
        test.put("test", 1234l);
        test.put("test",4321l);
        System.out.println(test);
        System.out.println();
    }
}
