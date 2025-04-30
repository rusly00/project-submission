abstract class Animal {
    abstract void makeSound();

    void sleep() {
        System.out.println("Swiming...");
    }
}

class Tiger extends Animal {
    void makeSound() {
        System.out.println("hao hao");
    }
}

public class Main {
    public static void main(String[] args) {
        Tiger d = new Tiger();
        d.makeSound();
        d.sleep();
    }
}
