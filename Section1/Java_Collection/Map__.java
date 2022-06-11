//package Section1.Java_Collection;
//import java.util.*;
//
//import java.util.*;
//
//public class Map__ {
//    public static void main(String[] args) {
//        Map<String, Integer> map = new HashMap<>();
//
//        //객체 저장
//        map.put("피카츄", 85);
//        map.put("꼬부기", 95);
//        map.put("야도란", 75);
//        map.put("파이리", 65);
//        map.put("피존투", 15);
//
//        //저장된 총 Entry 수 얻기
//        System.out.println("총 entry 수: " + map.size());
//
//        //객체 찾기
//        System.out.println("파이리 : " + map.get("파이리"));
//        //이름(key)로 점수(value)검색
//        System.out.println("///");
//
//        //객체를 하나씩 처리
//        Set<String> keySet = map.keySet(); //Set 컬렉션으로 이름(key) 얻기
//
//        //반복해서 이름(key)를 얻고, 값을 Map에서 얻어냄
//        Iterator<String> keyIterator = keySet.iterator();
//        while(keyIterator.hasNext()) {
//            String key = keyIterator.next();
//            Integer value = map.get(key);
//            System.out.println(key + " : " + value);
//        }
//
//        //객체 삭제
//        map.remove("피존투");
//        System.out.println("///");
//
//        System.out.println("총 entry 수: " + map.size());
//
//        //객체를 하나씩 처리
//        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
//        //Set 컬렉션으로 Map.Entry 얻기
//        Iterator<Map.Entry<String, Integer>> entryIterator = entrySet.iterator();
//
//        //반복해서 Map.Entry를 얻고 키와 값을 얻어냄
//        while(entryIterator.hasNext()) {
//            Map.Entry<String, Integer> entry = entryIterator.next();
//            String key = entry.getKey();
//            Integer value = entry.getValue();
//            System.out.println(key + " : " + value);
//        }
//        //객체 전체 삭제
//        map.clear();
//    }
//}
//
//
//
////====================================================================
//
//// HashTable
//
////
////public class Map__ {
////    public static void main(String[] args){
////        Map<String, String> map = new Hashtable<String, String>();
////        map.put("Spring", "345");
////        map.put("Summer", "678");
////        map.put("Fall", "91011");
////        map.put("Winter", "1212");
////
////        System.out.println(map);
////
////        Scanner scanner = new Scanner(System.in);
////
////        while(true){
////            System.out.println("아이디와 비밀번호를 입력해 주세요");
////            System.out.println("아이디");
////            String id = scanner.nextLine();
////
////            System.out.println("비밀번호");
////            String password = scanner.nextLine();
////
////            if(map.containsKey(id)) { //아이디인 키가 존재하는지 확인한다.
////                if(map.get(id).equals(password)) { //비밀번호를 비교한다.
////                    System.out.println("로그인 되었습니다.");
////                    break;
////                } else {
////                    System.out.println("비밀번호가 일치하지 않습니다. ");
////                }
////            } else {
////                System.out.println("입력하신 아이디가 존재하지 않습니다.");
////            }
////        }
////    }
////}