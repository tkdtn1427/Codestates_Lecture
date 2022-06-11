package Section1.Java_Collection;


// 인스턴스 내부 클래스
//
//class Outer { //외부 클래스
//    private int num = 1; //외부 클래스 private 변수
//    private static int sNum = 2; // 외부 클래스 정적 변수
//
//    private InClass inClass; // 내부 클래스 자료형 변수 선언
//
//    public Outer() {
//        inClass = new InClass(); //외부 클래스 생성자
//    }
//
//     void test(){
//        System.out.println("test");
//    }
//
//    class InClass { //인스턴스 내부 클래스
//        int inNum = 10; //내부 클래스의 인스턴스 변수
//        void Test() {
//            System.out.println("Outer num = " + num + "(외부 클래스의 인스턴스 변수)");
//            System.out.println("Outer sNum = " + sNum + "(외부 클래스의 정적 변수)");
//            test();
//        }
//    }
//    public void testClass() {
//        inClass.Test();
//    }
//}
//
//public class Inner__ {
//    public static void main(String[] args) {
//        Outer outer = new Outer();
//        System.out.println("외부 클래스 사용하여 내부 클래스 기능 호출");
//        //outer.testClass(); // 내부 클래스 기능 호출
//        Outer.InClass ttt = outer.new InClass();
//    }
//}

//===================================================================

//정적 내부 클래스


class Outer { //외부 클래스
    private int num = 3; //내부 클래스의 인스턴스 변수
    private static int sNum = 4;

    void getPrint() {
        System.out.println("인스턴스 메서드");
    }

    static void getPrintStatic() {
        System.out.println("스태틱 메서드");
    }

    static class StaticInClass { // 정적 내부 클래스
        static void test() {
            System.out.println("Outer num = " +sNum + "(외부 클래스의 정적 변수)");
            getPrintStatic();
            // num 과 getPrint() 는 정적 멤버가 아니라 사용 불가.
        }
    }
}

public class Inner__ {
    public static void main(String[] args) {
        Outer.StaticInClass a = new Outer.StaticInClass(); //정적 이너 클래스의 객체 생성
        a.test();
    }
}