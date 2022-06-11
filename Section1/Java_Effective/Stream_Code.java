package Section1.Java_Effective;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Arrays;


public class Stream_Code {
    public static void main(String[] args) {
        String[] tmp = new String[]{"ab", "ac", "bcd", "cd"};
        List<String> names = Arrays.asList(tmp);
        //List<String> names = Arryas.asLIst("""""");

        names.stream()
                .distinct()
                //.forEach(System.out::print);
                .forEach(x -> System.out.print(x));

        System.out.println();

        names.stream()
                .filter(x -> x.startsWith("a"))
                .forEach(x -> System.out.printf("%s ",x));

        System.out.println();

        names.stream()
                .map(x -> x.toUpperCase())
                .forEach(x -> System.out.printf("%s ",x));

        System.out.println();

        Stream<String[]> Stream_arr = Stream.of(
                new String[]{"Hello","world","java"},
                new String[]{"code","States"});

        //Stream_arr.map(x -> Arrays.asList(x)).forEach(x-> System.out.printf("%s ",x));
        Stream_arr.flatMap(Arrays::stream).sorted(Comparator.reverseOrder()).
                peek(x -> System.out.println("x"))
                .forEach(x -> System.out.printf("%s ",x));

        System.out.println();

        boolean result = names.stream()
                .allMatch(x -> x.length() == 2);
        System.out.println(result);

        int[] intArr = {1,2,3,4,5};
        int sum1 = Arrays.stream(intArr)
                .reduce((a,b)->a+b)
                .getAsInt();

        System.out.println();

        Integer[] integer_arr = {1,2,3,4,5};
        List<Integer> collector_list = Arrays.asList(integer_arr).stream().collect(Collectors.toList());
        collector_list.stream().map(x-> x*x).forEach(x -> System.out.printf("%d ",x ));

        Optional<String> opt1 = Optional.ofNullable(null);

        System.out.println(opt1.isPresent());


//        Optional<String> optString = Optional.ofNullable(null);
//        System.out.println(optString);
//        System.out.println(optString.get());

        String nullname = null;
        String name = Optional.ofNullable(nullname).orElse("efef");


        List<String> languages = Arrays.asList(
                "Ruby", "Python", "Java", "Go", "Kotlin");
        Optional<List<String>> listOptional = Optional.of(languages);

        int size = listOptional
                .map(List::size)
                .orElse(-1);
        System.out.println(size);

    }
}