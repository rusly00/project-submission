package Inheritace_protected;

class Animal{
    protected String type = "Animal";
    void display(){
        System.out.println("This is an animal");
    }
}
class Tiger extends Animal{
    void roar(){
        System.out.println(type+ " says haaao!");
    }
}
public class Main {
    public static void main(String [] args){
        Tiger d=new Tiger();
        d.display();
        d.roar();
    }
}
