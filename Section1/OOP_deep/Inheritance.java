//package Section1.OOP_deep;
//
//public class Inheritance{
//    public static void main(String[] args) {
//        Car car = new Car();
//
//        Vehicle vehicle = (Vehicle) car; // 상위 클래스 Vehicle 타입으로 변환(생략 가능)
//        Car car2 = (Car) vehicle; // 하위 클래스 Car타입으로 변환(생략 불가능)
//        //MotorBike motorBike = (MotorBike) car; // 상속관계가 아니므로 타입 변환 불가 -> 에러발생
//
//        MotorBike tmp3 = new MotorBike();
//        //Vehicle test = (Vehicle) tmp3;
//
//        tmp3.performance();
//    }
//}
//
//    class Vehicle {
//        String model = "parent";
//        String color;
//        int wheels;
//
//        void startEngine() {
//            System.out.println("시동 걸기");
//        }
//
//        void accelerate() {
//            System.out.println("속도 올리기");
//        }
//
//        void brake() {
//            System.out.println("브레이크!");
//        }
//    }
//
//    class Car extends Vehicle {
//        String model = super.model;
//        void giveRide() {
//            System.out.println("다른 사람 태우기");
//        }
//    }
//
//    class MotorBike extends Car {
//        void performance() {
//            System.out.println("묘기 부리기");
//        }
//
//        void giveRide() {
//            System.out.println("다른 사람 태우기_Motor");
//        }
//    }
