package Exercise3_Inheritance.P02Zoo;

public class Main {

    public static void main(String[] args) {


        Animal animal = new Animal("Animal");
        Bear bear = new Bear("Brown");
        Gorilla gorilla = new Gorilla("King Kong");
        Lizard lizard = new Lizard("Green");
        Mammal mammal = new Mammal("Mammal");
        Reptile reptile = new Reptile("Reptile");
        Snake snake = new Snake("Cobra");

        System.out.println(animal.getName());
        System.out.println(bear.getName());
        System.out.println(gorilla.getName());
        System.out.println(lizard.getName());
        System.out.println(mammal.getName());
        System.out.println(reptile.getName());
        System.out.println(snake.getName());
    }
}
