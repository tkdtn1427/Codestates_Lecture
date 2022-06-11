package Section2.DailyCoding;


public class _23_fibonachi {
    public static void main(String[] args) {
        System.out.println(fibonacci(5));
    }

    static int fibonacci(int num) {
        int[] arr = new int[num+1];
        return recur(num,arr,0);
    }

    static int recur(int num,int[] arr, int count){
        if(count > num){
            return arr[count-1];
        }

        if(count ==0 || count ==1){
            arr[count] = count;
        }else{
            arr[count] = arr[count-1]+arr[count-2];
        }

        return recur(num,arr,count+1);
    }
}
