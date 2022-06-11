//package Section1.Java_Collection;
//
////public class Generic {
////    public static void main(String[] args){
////        Basket<String> basket1 = new Basket<>();
////        basket1.set("String");
////        String str = basket1.get();
////
////        System.out.println(basket1.get().getClass().getSimpleName());
////
////        Basket<Integer> basket2 = new Basket<>();
////        basket2.set(1);
////        int value = basket2.get();
////
////        Show.show(basket1);
////    }
////}
////
////class Basket<T> {
////    private T t;
////    public T get() { return this.t; }
////    public void set(T t) { this.t = t; }
////}
////
////class Show{ static void show(Basket<?> basket){}}
//
//
//
////=====================================================================
//
//
//class TestClass { //일반 클래스 내부의 제네릭 메서드를 선언
//    public <T>T accept(T t){
//        return t;
//    }
//    public <K, V> void getPrint(K k, V v) { //리턴 타입 앞에 타입 매개변수 선언
//        System.out.println(k+ ":" + v);
//    }
//}
//
//public class Generic {
//    public static void main(String[] args) {
//
//        TestClass testClass = new TestClass();
//
//        String str1 = testClass.<String>accept("Kim Coding");
//        String str2 = testClass.accept("Kim Coding");
//        //입력 매개변수 값으로 제네릭 타입을 유추 가능하면 제네릭 타입 지정을 생략 가능
//        System.out.println(str1);
//        System.out.println(str2);
//
//        testClass.<String, Integer>getPrint("Kim Coding", 1);
//        testClass.getPrint("Kim Coding", 2);
//    }
//}
