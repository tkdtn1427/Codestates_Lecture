package Section2.DailyCoding2;

import jdk.jshell.SourceCodeAnalysis;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class _39_heapSort {
    public static void main(String[] args) {
        int[] output = heapSort(new int[]{4,2,1,47,6,4,5,2,5,4,6,7,6,4,5,21,2,1,1,23,4,5});
        System.out.println(Arrays.toString(output));
    }

    static int[] heapSort(int[] arr) {
        for(int i=0; i<arr.length; i++){
            sorting(arr,i);
        }
        int[] sol = Arrays.copyOfRange(arr,0,arr.length);
        desc(sol,arr);
        return arr;
    }

    static void sorting(int[] arr, int idx){
        int origin = idx;
        while(idx!=0){
            idx = (idx-1)/2;
            if(arr[idx] > arr[origin]){
                int temp = arr[idx];
                arr[idx] = arr[origin];
                arr[origin] = temp;
                origin = idx;
            }else{
                break;
            }
        }
    }

    static void desc(int[] sol, int[] arr){
        int idx= 0;
        for(int i=0; i<sol.length; i++){
            arr[i] = sol[0];
            sol[0] = sol[sol.length-1-i];
            sol = sorting2(sol,sol.length-1-i,0);
        }
    }

    static int[] sorting2(int[] sol, int last, int idx) {
        //자식이 2개
        int left = idx*2+1;
        int right = idx*2+2;
        int choice = -1;

        if (right < last) {
            if (sol[left] > sol[right] && sol[right] < sol[idx]) {
                swap(sol,idx,right);
                choice = right;
            } else if (sol[left] <= sol[right] && sol[left] < sol[idx]) {
                swap(sol,idx,left);
                choice = left;
            }
        }else if (left < last) {
            if (sol[left] < sol[idx]) {
                swap(sol,idx,left);
                choice = left;
            }
        }
        if(choice == -1) return sol;
        else return sorting2(sol,last,choice);
    }

    static void swap(int[] sol, int first,int last) {
        int temp = sol[first];
        sol[first] = sol[last];
        sol[last] = temp;
    }


//========================================================================================\

//    static int[] heapSort(int[] arr) {
//        // 힙 정렬에 사용될 힙(우선순위 큐)을 선언합니다.
//        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
//
//        // 배열의 값을 힙에 모두 할당합니다.
//        for(int i = 0; i < arr.length; i++) {
//            heap.add(arr[i]);
//        }
//
//        // 힙에서 우선순위가 가장 높은 원소(root노드)를 하나씩 배열에 넣어줍니다.
//        for(int i = 0; i < arr.length; i++) {
//            arr[i] = heap.poll();
//        }
//
//        return arr;
//    }
}