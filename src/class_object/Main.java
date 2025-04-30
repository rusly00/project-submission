package class_object;

class Car {
    String color;
    int speed;
    void drive() {
        System.out.println("Car driving...");
    }
}

public class Main {
    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.color = "black";
        myCar.speed = 80;
        myCar.drive();
    }
}
