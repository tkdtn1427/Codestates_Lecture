package Section1.Java_Collection;

//지역 내부 클래스

//class Outer { //외부 클래스
//    int num = 5;
//    void test() {
//        int num2 = 6;
//        class LocalInClass { //지역 내부 클래스
//            void getPrint() {
//                System.out.println(num);
//                System.out.println(num2);
//            }
//        }
//        LocalInClass localInClass = new LocalInClass();
//        localInClass.getPrint();
//    }
//}
//public class Inner__local {
//    public static void main(String[] args) {
//        Outer outer = new Outer();
//        outer.test();
//    }
//}

// ===================================================================



//익명 내부 클래스
interface Name {
    String name = "Kim Coding";
    int num =5;
    void getName();
}

class Main {
    public static void main(String [] args) {
        Name obj = new Name(){
            public void getName(){
                System.out.println(name);
            }
        };
        obj.getName();
        System.out.println(obj.getClass().getSimpleName());
    }
}