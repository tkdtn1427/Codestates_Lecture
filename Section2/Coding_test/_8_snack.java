package Section2.Coding_test;
import java.util.*;

public class _8_snack {
    public static void main(String[] args) {
        int M = 4;
        int N = 8;
        ArrayList<Integer[]> output = divideChocolateStick(M, N);
        System.out.println(output);
    }

    static ArrayList<Integer[]> divideChocolateStick(int M, int N) {
        ArrayList<Integer[]> result = new ArrayList<Integer[]>();

        int GSD[] = Cal_GSD(M,N);
        for(int i=0; i< GSD.length; i++){
            int num = GSD[i];
            Integer[] tmp = new Integer[]{num,M/num,N/num};
            result.add(tmp);
        }

        return result;
    }

    static int[] Cal_GSD(int M, int N){
        int min=0;
        if(M > N) min = N;
        else min = M;

        ArrayList<Integer> GSD = new ArrayList<>();

        for(int i=1; i<=min; i++){
            if(M % i == 0 && N % i == 0){
                GSD.add(i);
            }
        }
        int[] result = new int[GSD.size()];

        for(int i=0; i<GSD.size(); i++){
            result[i] = GSD.get(i);
        }

        return result;
    }
}
