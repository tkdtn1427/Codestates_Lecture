package Section1.homework.Java_Base;
import java.util.*;

public class Electric_Cal {
    public static void main(String[] args) {
        System.out.println("=".repeat(25));
        System.out.println(" 주택용 전기요금(저압) 계산기 ");
        System.out.println("=".repeat(25));

        Scanner scanner = new Scanner(System.in);
        double result;

        while (true) {
            int amount = scanner.nextInt();
            if(amount == -1)
                break;
            result = Cal_Elec(amount);
            System.out.println(String.format("%dkwh의 전기 요금은 %.1f원 입니다.",amount,result));
        }

        //TODO:

        // 1, 100 이하인 경우 전력당 60.7 원이 부가됩니다. (사용한 전력 100 kWh 이하일 경)

        // 2, 100 이하인 경우 전력당 60.7원 부과, 100 초과인 경우 125.9원 부과 (사용한 전력이 100 kWh 초과일 경우)
    }

    static double Cal_Elec(int amount) {
        double result = 0;

        if(amount >= 0 && amount <= 100){
            result += Cal_case.cal_100(amount);
        }
        else if(amount >100 && amount <= 200){
            result += Cal_case.cal_200(amount-100);
        }
        else if(amount >200 && amount <= 300){
            result += Cal_case.cal_300(amount-200);
        }
        else if(amount >300 && amount <= 400){
            result += Cal_case.cal_400(amount-300);
        }
        else if(amount >400 && amount <= 500){
            result += Cal_case.cal_500(amount-400);
        }
        else{
            result += Cal_case.cal_up(amount-500);
        }

        return result;
    }
}

class Cal_case{
    static double cal_100(int amount) {
        return amount*60.7;
    }
    static double cal_200(int amount) {
        return amount*125.9 + 100*60.7;
    }
    static double cal_300(int amount) {
        return amount*187.9 + 100*125.9 + 100*60.7;
    }
    static double cal_400(int amount) {
        return amount*280.6 + 100*187.9 + 100*125.9 + 100*60.7;
    }
    static double cal_500(int amount) {
        return amount*417.7 + 100*280.6 + 100*187.9 + 100*125.9 + 100*60.7;
    }

    static double cal_up(int amount) {
        return amount*670.6 + 100*417.7 + 100*280.6 + 100*187.9 + 100*125.9 + 100*60.7;
    }
}