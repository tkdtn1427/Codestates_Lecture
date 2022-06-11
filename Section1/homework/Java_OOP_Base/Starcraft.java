package Section1.homework.Java_OOP_Base;
import java.util.*;

public class Starcraft {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        Unit[] units = new Unit[2];
        String name;
        int ad;
        int defense;
        int hp;

        for(int i=0; i<2; i++){
            System.out.println("[안내] TRPG 스타크래프트 시작합니다.");
            System.out.println("[안내] 자신의 유닛 정보를 입력해 주세요.");
            System.out.print("[시스템] 유닛 [이름] 을 입력해 주세요 : ");
            name = scanner.nextLine();
            System.out.print("[시스템] 유닛 [공격력] 을 입력해 주세요 : ");
            ad = scanner.nextInt();
            System.out.print("[시스템] 유닛 [방어력] 을 입력해 주세요 : ");
            defense = scanner.nextInt();
            System.out.print("[시스템] 유닛 [체력] 을 입력해 주세요 : ");
            hp = scanner.nextInt();
            scanner.nextLine();

            units[i] = new Unit(name,ad,defense,hp);
            units[i].show();
        }
        while(units[1].hp > 0){
            units[1] = units[0].attack(units[1]);
        }

    }
}

class Unit{
    String name;
    int ad;
    int defense;
    int hp;

    Unit(String name, int ad, int defense, int hp){
        this.name = name;
        this.ad = ad;
        this.defense = defense;
        this.hp = hp;
    }

    void show(){
        System.out.println("\n[안내] 생성된 유닛 정보는 다음과 같습니다.");
        System.out.println(String.format("[안내] %s 유닛이 게임에 참여하였습니다.",this.name));
        System.out.println(String.format("[공격력] : %d",this.ad));
        System.out.println(String.format("[방어력] : %d",this.defense));
        System.out.println(String.format("[체력] : %d",this.hp));
        System.out.println("=".repeat(15));
    }

    Unit attack(Unit unit){
        System.out.println("-".repeat(15));
        System.out.println(String.format("[안내] [%s]유닛이 [공격] 하였습니다.",this.name));
        unit.hp = unit.hp-this.ad;
        if(unit.hp < 0) unit.hp = 0;
        System.out.println(String.format("[안내] 상대 유닛의 남은 [체력]은 %d 입니다.",unit.hp));
        if(unit.hp == 0){
            System.out.println("-".repeat(15));
            System.out.println("[안내] 더 이상 공격할 수 없습니다.");
            System.out.println("\n[안내] 상대 유닛이 제거되었습니다.");
        }

        return unit;
    }

}