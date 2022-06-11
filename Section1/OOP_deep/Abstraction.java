//package Section1.OOP_deep;
//import java.util.HashMap;
//
//public class Abstraction {
//    public static void main(String[] args) {
//        Seller seller = new Seller("카페사장");
//        Buyer buyer = new Buyer("단골손님 A") ;
//        Buyer buyer1 = new Buyer("단골손님 B");
//        buyer.order("Americano");
//        buyer1.order("Caffee Latte");
//        buyer.play();
//        buyer1.play();
//
//        seller.ordered(buyer);
//        seller.ordered(buyer1);
//
//        seller.play(buyer);
//        seller.play(buyer1);
//
//    }
//}
//
//abstract class person{
//    String role;
//    String drink = "미주문";
//
//    protected void play() {};
//    protected void play(Buyer buyer){};
//}
//
//interface Coffee{
//    public abstract void order(String drink);
//}
//
//class Seller extends person{
//    HashMap<String,String> map = new HashMap<>();
//     Seller(String role){
//        super.role = role;
//    }
//
//     protected void play(Buyer buyer) {
//        if(map.containsKey(buyer.role)){
//            System.out.println(String.format("%s이 %s에게 %s를 줍니다.",super.role,buyer.role,map.get(buyer.role)));
//            map.remove(buyer.role);
//        }
//    }
//
//    public void ordered(Buyer buyer){
//        this.map.put(buyer.role,buyer.drink);
//    }
//
//}
//
//class Buyer extends person implements Coffee{
//    public Buyer(String role){
//        super.role = role;
//    }
//
//    public void order(String drink){
//        super.drink = drink;
//    }
//
//    protected void play(){
//        System.out.println(String.format("%s가 %s를 주문하였습니다.",super.role,super.drink));
//    }
//}
