package Lab5_Polymorphism.P03Animals;

public class Main {

    public static void main(String[] args) {

        Animal cat = new Cat("Oscar","Whiskers");
        Animal dog = new Dog("Rocky","Meat");

        System.out.println(cat.explainSelf());
        System.out.println(dog.explainSelf());
    }
}
