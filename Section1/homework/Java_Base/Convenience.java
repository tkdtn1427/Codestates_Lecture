package Section1.homework.Java_Base;
import java.util.*;

public class Convenience {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Convenience_prod convenience_prod = new Convenience_prod();
        while(true){
            convenience_prod.operate(scanner);
        }

    }
}

class Convenience_prod{
    String[][] array;
    int count=0;

    Convenience_prod(){
        System.out.println("[System]코드스테이츠 점장님 어서오세요.");
        System.out.println("해당 프로그램의 기능입니다.");

        this.array = new String[5][2];
        for(int i=0; i<5; i++){
            array[i][0] = "등록 가능";
            array[i][1] = "0";
        }
    }

    void operate(Scanner scanner){
        System.out.println("1. 물건 정보(제품명) 등록하기");
        System.out.println("2. 물건 정보(제품명) 등록 취소하기");
        System.out.println("3. 물건 넣기 (제품 입고)");
        System.out.println("4. 물건 빼기 (제품 출고)");
        System.out.println("5. 재고 조회");
        System.out.println("6. 프로그램 종료");
        System.out.println("-".repeat(20));
        System.out.print("[System] 원하는 기능의 번호를 입력하세요 : ");
        int num = scanner.nextInt();
        scanner.nextLine();
        operate_choice(num);
    }

    void operate_choice(int num){
        switch (num){
            case 1:
                input_item();
                break;
            case 2:
                remove_item();
                break;
            case 3:
                input_number();
                break;
            case 5:
                search_item();
                break;
            default:
        }
    }

    void input_item(){
        Scanner scanner1 = new Scanner(System.in);
        System.out.print("[System] 제품 등록을 원하는 제품명을 입력하세요 : ");
        String item = scanner1.nextLine();
        if(count == this.array.length){
            System.out.println("자리가 없음");
        }else{
            this.array[count++][0] = item;
            System.out.println("[System] 등록이 완료됬습니다.");
            System.out.println("[System] 현재 등록된 제품 목록");
            for(int i=0; i<array.length; i++){
                System.out.print(array[i][0]);
                System.out.println(String.format(" : %s개",array[i][1]));
            }
        }

        System.out.println("-".repeat(20));
    }

    void remove_item(){
        Scanner scanner1 = new Scanner(System.in);
        System.out.print("[System] 제품 등록 취소를 원하는 제품명을 입력하세요 : ");
        String item = scanner1.nextLine();
        for(int i=0; i<array.length; i++) {
            if(array[i][0].equals(item)){
                for(int j=i+1; j<array.length; j++){
                    array[j-1] = array[j];
                }
                array[4][0] = "등록 가능";
                array[4][1] = "0";
                this.count = count-1;
                break;
            }
        }
        System.out.println("[System] 제품취소가 완료되었습니다.");
        System.out.println("-".repeat(20));
    }

    void input_number(){
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("[System] 물건의 수령을 추가합니다(입고)");
        System.out.println("[System] 현재 등록된 제품 및 수량");
        for(int i=0; i<array.length; i++){
            System.out.print(array[i][0]);
            System.out.println(String.format(" : %s개",array[i][1]));
        }
        System.out.print("[System] 수량을 추가할 제품명을 입력하세요 : ");
        String item = scanner1.nextLine();
        System.out.print("[System] 추가할 수량을 입력해주세요 : ");
        int number = scanner1.nextInt();
        scanner1.nextLine();
        for(int i=0; i<array.length; i++) {
            if(array[i][0].equals(item)){
                array[i][1] = String.valueOf(Integer.valueOf(array[i][1]) + number);
                break;
            }
        }
        System.out.println("[System] 정상적으로 제품의 수량 추가가 완료되었습니다.");
        search_item();

    }

    void search_item(){
        System.out.println("[System] 현재 등록된 물건 목록");
        for(int i=0; i<array.length; i++){
            System.out.print(array[i][0]);
            System.out.println(String.format(" : %s개",array[i][1]));
        }
    }



}
