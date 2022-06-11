package Section1.homework.Java_Base;
import java.util.*;

public class String_replace {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Admin admin = Produce(scanner);
        String word = admin.produce_word(scanner);
        System.out.println("=".repeat(10));

        Youtube_word youtube_word = new Youtube_word();
        youtube_word.Change_word(word);


    }

    static Admin Produce(Scanner scanner) {
        int right_num = 1;
        Admin admin;
        do {
            System.out.print("[시스템] 유튜브 계정의 아이디를 입력하세요 {Ex - admin} : ");
            String admin_ID = scanner.nextLine();
            System.out.print("[시스템] 유튜브 계정의 비밀번호를 입력하세요 {Ex - admin} : ");
            int admin_password = scanner.nextInt();
            scanner.nextLine();

            admin = new Admin();
            right_num = admin.Admin_compare(admin_ID,admin_password);
        } while (right_num != 1);

        return admin;
    }
}

class Admin{
    final String admin_ID = "Sangsoo";
    final int admin_password  = 1234;

    int Admin_compare(String admin_ID, int admin_password){
        if(this.admin_ID.equals(admin_ID) && this.admin_password == admin_password) {
            return 1;
        }
        else{
            System.out.println("[경고] 유튜브 계정의 아이디 및 비밀번호를 다시 확인해 주세요.");
            return -1;
        }
    }

    String produce_word(Scanner scanner){
        System.out.println(String.format("[안내] 안녕하세요 %s님",this.admin_ID));
        System.out.println(String.format("[안내] 유튜브 영상의 자막을 생성해 주세요."));
        String word = scanner.nextLine();
        System.out.println(word);

        return word;
    }
}

class Youtube_word{
    String[] ban_word = new String[]{"킹","시발","씨발","미친"};
    String[] change_wold = new String[]{"짱","화남","매우화남","사랑해"};

    Youtube_word(){
        System.out.println("[알림] 프로그램의 금칙어 리스트입니다.");
        System.out.println(Arrays.toString(ban_word));
        System.out.println("=".repeat(10));
    }

    void Change_word(String word){

        for(int i=0; i<ban_word.length; i++){
            word = word.replaceAll(ban_word[i], change_wold[i]);
        }

        System.out.println("[알림] 자막 순화 프로그램 결과입니다.");
        System.out.println(word);
        System.out.println("[안내] 프로그램을 종료합니다");
    }
}